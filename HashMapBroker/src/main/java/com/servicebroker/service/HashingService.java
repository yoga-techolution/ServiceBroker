package com.servicebroker.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servicebroker.model.CustomHashMap;

@Component
public class HashingService {

    @Autowired
    private CustomHashMap<String, Object> hashMap;

    public void put(String key, Object value) {
    	hashMap.put(key, value);
    }
 
    public Object get(String key) {
    	return hashMap.get(key);
    }
    
    public boolean delete(String key) {
        return hashMap.remove(key);
    }


}
