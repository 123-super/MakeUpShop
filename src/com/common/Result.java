package com.common;

import java.util.HashMap;

public class Result extends HashMap<Object, Object> {

	
	private static final int SUCCESS = 200;
	private static final int ERROR = 404;
	
	public Result(Integer status, Object obj) {
		super.put("status", status);
		super.put("data", obj);
	}
	
	public static Result success(Object obj) {
		return new Result(SUCCESS, obj);
	}
	
	public static Result error() {
		return new Result(ERROR, null);
	}

	public static Result toResult(int count) {
		if (count > 0) return Result.success("²Ù×÷³É¹¦");
		return Result.error(); 
	}
}
