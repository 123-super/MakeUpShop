package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.PropertyValue;

import com.dao.PropertyValueMapper;
@Service
public class PropertyValueServiceImpl implements PropertyValueService{
	@Autowired 
	private PropertyValueMapper propertyvaluemapper;
	@Override
	public List<PropertyValue> getPVByPId(Integer pid) {
		// TODO Auto-generated method stub
		return propertyvaluemapper.getPVByPId(pid);
	}
	@Override
	public List<PropertyValue> getPVByPidAndPtid(Integer pid) {
		// TODO Auto-generated method stub
		return propertyvaluemapper.getPVByPidAndPtid(pid);
	}

}
