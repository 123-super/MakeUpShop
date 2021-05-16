package com.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.bean.User;

import cn.hutool.core.util.IdUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {
	
	protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final long MILLIS_MINUTE_20 = 20 * 60 * 1000L;
    
    private String header = "Authori";
    
    private String secret = "liqianxiaokeai";

    private int expireTime = 30;
    
	/**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(User user) {
        String token = IdUtil.fastUUID();
        user.setToken(token);
        refreshToken(user);

        Map<String, Object> claims = new HashMap<>();
        claims.put(Constant.LOGIN_TOKEN_KEY, token);
        return createToken(claims);
    }

    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUser 登录用户
     * @return 令牌
     */
    public void verifyToken(User user) {
        long expireTime = user.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_20) {
            refreshToken(user);
        }
    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(User user) {
    	user.setLoginTime(System.currentTimeMillis());
    	user.setExpireTime(user.getLoginTime() + expireTime * MILLIS_MINUTE);
    	// 存入本地token map
    	Constant.TOKEN_MAP.put(user.getToken(), user);
    }    
    
    /**
     * 从数据声明生成令牌
     * 它将用户信息加密到token里，服务器不保存任何用户信息。服务器通过使用保存的密钥验证token的正确性，只要正确即通过验证
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public User getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = request.getHeader(this.header);
        if (!StringUtils.isEmpty(token)) {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String uuid = (String) claims.get(Constant.LOGIN_TOKEN_KEY);
            return Constant.TOKEN_MAP.get(uuid);
        }
        return null;
    }
}
