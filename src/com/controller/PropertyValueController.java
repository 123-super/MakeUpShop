package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bean.PropertyValue;
import com.service.PropertyValueService;

@Controller
@RequestMapping("/property")
public class PropertyValueController {
@Autowired
private PropertyValueService propertyvalueservice;
@RequestMapping(value = "/getPVByPId", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
@ResponseBody
public String getPVByPId(Integer pid) {
	 List<PropertyValue> pv =  propertyvalueservice.getPVByPId(pid);
	return JSON.toJSONString(pv);
}


@RequestMapping(value = "/getPVByPidAndPtid", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
@ResponseBody
public String getPVByPidAndPtid(Integer pid) {
	 List<PropertyValue> pv1 =  propertyvalueservice.getPVByPidAndPtid(pid);
	return JSON.toJSONString(pv1);
}

}
