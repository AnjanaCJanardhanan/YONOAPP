package com.nissan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	// name validation
	public Boolean isNameValid(String name) {
		boolean bool = false;
		try {
			Pattern namePattern = Pattern.compile("[^A-Za-z]");
			Matcher nameMatcher = namePattern.matcher(name);

			if (nameMatcher.find()) {
				throw new InvalidNameException("Hey! Invalid name");
			} else {
				bool = true;
			}
		} catch (InvalidNameException e) {
			e.getMessage();
		}
		return bool;
	}

	public Boolean isNumberValid(String mobileno) {
		boolean bool = false;
		try {
			Pattern pattern = Pattern.compile("[^0-9]");
			// match
			Matcher matcher = pattern.matcher(mobileno);
			// boolean finder = matcher.find();
			// find method returns false if string matches the pattern
			if (matcher.find()) {
				throw new InvalidNameException("Hey! Invalid number");
			} else {
				bool = true;
			}
		} catch (InvalidNameException e) {
			e.getMessage();
		}
		return bool;
	}

	public Boolean isAccountNumberValid(String accountno) {
		boolean bool = false;
		try {
			Pattern pattern = Pattern.compile("[^0-9]");
			// match
			Matcher matcher = pattern.matcher(accountno);
			// boolean finder = matcher.find();
			// find method returns false if string matches the pattern
			if (matcher.find()) {
				throw new InvalidNameException("Hey! Invalid accountnumber");
			} else {
				bool = true;
			}
		} catch (InvalidNameException e) {
			e.getMessage();
		}
		return bool;
	}
}
