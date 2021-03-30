package com.dao;

import java.util.List;

import com.bean.Product;
import com.bean.PropertyValue;

public interface ProductMapper {
     public List<Product> getProductById(Integer id);
    
}
