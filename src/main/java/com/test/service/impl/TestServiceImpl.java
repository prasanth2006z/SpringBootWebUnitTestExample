package com.test.service.impl;

import com.test.model.Item;
import com.test.service.TestService;

public class TestServiceImpl implements TestService{

	public void read() {
		System.out.println("Hi...");
	}

	public Item write() {
		Item item=new Item();
		
		return item;
	}
}
