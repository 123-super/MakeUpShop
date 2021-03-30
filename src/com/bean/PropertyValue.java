package com.bean;

public class PropertyValue {
private Integer id;
private Integer pid;
private String name;
private String value;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
@Override
public String toString() {
	return "PropertyValue [id=" + id + ", pid=" + pid + ", name=" + name + ", value=" + value + "]";
}
public PropertyValue() {
	super();
	// TODO Auto-generated constructor stub
}

}
