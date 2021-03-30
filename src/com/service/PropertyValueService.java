package com.service;

import java.util.List;

import com.bean.PropertyValue;

public interface PropertyValueService {
	public List<PropertyValue> getPVByPId(Integer pid);
	 public List<PropertyValue> getPVByPidAndPtid(Integer pid);
}
