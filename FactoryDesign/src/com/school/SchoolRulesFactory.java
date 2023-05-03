package com.school;

public class SchoolRulesFactory {

	public Student getInstance(String str) {

		if (str.equals("jacky")) {
			return new Teachers();
		} else if (str.equals("Help")) {
			return new Principle();
		} else {
			return new Parents();
		}

	}
}
