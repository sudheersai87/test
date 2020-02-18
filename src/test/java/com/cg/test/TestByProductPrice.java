
package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.exception.ValidateException;
import com.cg.service.Service;
import com.cg.service.Serviceimpl;

public class TestByProductPrice {
	
	static Service service;
	@BeforeAll
	public static void beforeAll() {
		service = new Serviceimpl();
	}
	
	@Test
	public void Test2() {
		assertThrows(ValidateException.class,()->service.searchByProductPrice(0));	
	}
	@Test
	public void Test3() {
		assertThrows(ValidateException.class,()->service.searchByProductPrice(-32000));	
	}
	
}
