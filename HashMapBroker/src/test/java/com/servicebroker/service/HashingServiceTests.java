package com.servicebroker.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.servicebroker.app.ApplicationTests;
import com.servicebroker.service.HashingService;

public class HashingServiceTests extends ApplicationTests{

	@Autowired
	private HashingService hashingService;
	
	@Before
	public void addEntryToMap(){
		hashingService.put("10", "Henry");
	}
	
	@Test
	public void checkIfEntryExists(){
		Assert.assertEquals("Henry",hashingService.get("10"));
	}
	
	
}
