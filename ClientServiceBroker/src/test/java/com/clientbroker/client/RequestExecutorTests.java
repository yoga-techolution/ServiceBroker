package com.clientbroker.client;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.clientbroker.app.AppTest;
import com.clientbroker.client.RequestExecutor;
import com.clientbroker.util.Constants;

import junit.framework.Assert;

public class RequestExecutorTests extends AppTest{
	
	@Autowired
	private RequestExecutor requestExecutor; 
	 
	@Before
	public void setUp(){
		requestExecutor.doPostRequest(Constants.ADD_ENTRY+"1/Ram");
	}
	
	@Test
	public void checkGetEntry(){
		String output = requestExecutor.getRequest(Constants.GET_ENTRY+"/2");
		Assert.assertEquals("Vinay", output);
	}
	
	@Test
	public void checkAddEntry(){
		Assert.assertEquals("{Success: Key Added}", requestExecutor.doPostRequest(Constants.ADD_ENTRY+"2/Vinay"));
		
	}

}
