package com.assignment.reverse.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ReverseService {
	
	Logger logger = LogManager.getLogger(ReverseService.class);
	
	public String reverseLogic(String input)
	{
		String reverse_word = "";
		for (int i = input.length() - 1; i >= 0; i--) {
            reverse_word = reverse_word + input.charAt(i);
			}
		logger.info("String converted Successfully: {}", reverse_word);
		return reverse_word;
	}

}
