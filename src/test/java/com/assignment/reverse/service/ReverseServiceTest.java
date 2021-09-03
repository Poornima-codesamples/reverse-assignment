package com.assignment.reverse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ReverseServiceTest {
	
	@InjectMocks
    ReverseService reverseService;
	
	@Test
	public void testreverseLogic()
	{
		String testResult=reverseService.reverseLogic("reverse");
		assertEquals("esrever",testResult);
	}
    
	@Test
	public void testEmptyString()
	{
		String testResult=reverseService.reverseLogic("");
		assertEquals("",testResult);
	}
}
