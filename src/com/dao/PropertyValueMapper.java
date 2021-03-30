package com.dao;

import java.util.List;

import com.bean.PropertyValue;

public interface PropertyValueMapper {
	public List<PropertyValue>getPVByPId(Integer pid);
	 public List<PropertyValue> getPVByPidAndPtid(Integer pid);
}
