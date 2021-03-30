package com.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bean.MyOrder;
import com.bean.Order;
import com.bean.OrderItem;
import com.service.OrderService;


@Controller
@RequestMapping("/order")
public class OrderController {
		@Autowired
		private OrderService orderservice;
		@RequestMapping(value = "/addOrder", method = RequestMethod.POST,produces = "application/json;charsest=utf-8")
	    @ResponseBody
	    public void addOrder(Order order) {
			orderservice.addOrder(order);
		}
		
		@RequestMapping(value = "/addOrderItem", method = RequestMethod.POST,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public void addOrderItem(OrderItem orderitem) {
				orderservice.addOrderItem(orderitem);
			}
		@RequestMapping(value = "/getMyOrder", method = RequestMethod.GET,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public String getMyOrder() {
			List<MyOrder> myorder= orderservice.getMyOrder();
			return JSON.toJSONString(myorder);
			}
	
		@RequestMapping(value = "/getOrderUnPay", method = RequestMethod.GET,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public String getOrderUnPay() {
			List<MyOrder> myorder= orderservice.getOrderUnPay();
			return JSON.toJSONString(myorder);
			}
		@RequestMapping(value = "/getOrdersUnDeliver", method = RequestMethod.GET,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public String getOrdersUnDeliver() {
			List<MyOrder> myorder= orderservice.getOrdersUnDeliver();
			return JSON.toJSONString(myorder);
			}
		
		@RequestMapping(value = "/getOrdersUnReceive", method = RequestMethod.GET,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public String getOrdersUnReceive() {
			List<MyOrder> myorder= orderservice.getOrdersUnReceive();
			return JSON.toJSONString(myorder);
			}
		
		
		@RequestMapping(value = "/getOrdersUnComment", method = RequestMethod.GET,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public String getOrdersUnComment() {
			List<MyOrder> myorder= orderservice.getOrdersUnComment();
			return JSON.toJSONString(myorder);
			}
		@RequestMapping(value = "/delCurrentOrder", method = RequestMethod.POST,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public void delCurrentOrder(Integer id) {
			orderservice.delCurrentOrder(id);
			}
		@RequestMapping(value = "/getOrderId", method = RequestMethod.GET,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public String getOrderId(String orderNum) {
			Order order=orderservice.getOrderId(orderNum);
			return JSON.toJSONString(order);
			}
		
		@RequestMapping(value = "/updateStatus", method = RequestMethod.POST,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public void updateStatus(Integer id) {
		   orderservice.updateStatus(id);
			}

		@RequestMapping(value = "/updLeftStatus", method = RequestMethod.POST,produces = "application/json;charsest=utf-8")
		@ResponseBody
		public void updLeftStatus(MyOrder order) {
		   orderservice.updLeftStatus(order);
			}
//		public void addOrder(@RequestBody String obj) {
//			JSONObject jsonObject = JSONObject.parseObject(obj);
//	        //通过迭代器获得json当中所有的key值
//	        Iterator keys = jsonObject.keys();
//	        //然后通过循环遍历出的key值
//	        while (keys.hasNext()){
//	            String key = String.valueOf(keys.next());
//	            //通过通过刚刚得到的key值去解析后面的json了
//	        }
//			
//			System.out.println(obj.toString()+"wwwwwww");
//			orderservice.addOrder(order, orderitem);
//			System.out.println(order+"wwwwwww");
			
		
//		public void addOrder(@RequestBody Map<String,Object> map) throws  IOException {
//			ObjectMapper objectmapper=new ObjectMapper();
//			 Order order=objectmapper.readValue(objectmapper.writeValueAsString(map.get("order")), Order.class);
//			OrderItem orderitem=objectmapper.readValue(objectmapper.writeValueAsString(map.get("orderitem")),OrderItem.class);
//			orderservice.addOrder(order, orderitem);
//			System.out.println(map+"wwwwwww");
//			
//		}
		
}
