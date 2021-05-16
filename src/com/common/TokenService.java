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
     * ��������
     *
     * @param loginUser �û���Ϣ
     * @return ����
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
     * ��֤������Ч�ڣ�����20���ӣ��Զ�ˢ�»���
     *
     * @param loginUser ��¼�û�
     * @return ����
     */
    public void verifyToken(User user) {
        long expireTime = user.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_20) {
            refreshToken(user);
        }
    }

    /**
     * ˢ��������Ч��
     *
     * @param loginUser ��¼��Ϣ
     */
    public void refreshToken(User user) {
    	user.setLoginTime(System.currentTimeMillis());
    	user.setExpireTime(user.getLoginTime() + expireTime * MILLIS_MINUTE);
    	// ���뱾��token map
    	Constant.TOKEN_MAP.put(user.getToken(), user);
    }    
    
    /**
     * ������������������
     * �����û���Ϣ���ܵ�token��������������κ��û���Ϣ��������ͨ��ʹ�ñ������Կ��֤token����ȷ�ԣ�ֻҪ��ȷ��ͨ����֤
     *
     * @param claims ��������
     * @return ����
     */
    private String createToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * �������л�ȡ��������
     *
     * @param token ����
     * @return ��������
     */
    private Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * ��ȡ�û������Ϣ
     *
     * @return �û���Ϣ
     */
    public User getLoginUser(HttpServletRequest request) {
        // ��ȡ����Я��������
        String token = request.getHeader(this.header);
        if (!StringUtils.isEmpty(token)) {
            Claims claims = parseToken(token);
            // ������Ӧ��Ȩ���Լ��û���Ϣ
            String uuid = (String) claims.get(Constant.LOGIN_TOKEN_KEY);
            return Constant.TOKEN_MAP.get(uuid);
        }
        return null;
    }
}
