package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Item;
import com.test.service.TestService;

//@Controller
@RestController
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@ResponseBody
	public String read() {
		return "test";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public String write(@RequestBody Item request) {
		return "test";
	}

	@RequestMapping(value = "/writeparam/{id}", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public String writeParam(@PathVariable("id") Integer id,
			@RequestParam("name")String name,
			@RequestBody Item request) {
		return "test";
	}
}
