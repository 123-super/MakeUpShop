package com.utils;

public class ResponseObj {
private Integer status;
private Object obj;
//private String msg;

//public String getMsg() {
//	return msg;
//}
//public void setMsg(String msg) {
//	this.msg = msg;
//}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Object getObj() {
	return obj;
}
public void setObj(Object obj) {
	this.obj = obj;
}
public ResponseObj(int status, Object obj) {
	this.status=status;
	this.obj=obj;
}
public ResponseObj() {
	// TODO Auto-generated constructor stub
}

}
