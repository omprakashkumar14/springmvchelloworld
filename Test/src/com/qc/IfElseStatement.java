package com.qc;

public class IfElseStatement {
	/*
	 * if(condition) { statement 1; //executes when condition is true } else{
	 * statement 2; //executes when condition is false }
	 */
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		if (a + b < 10) {
			System.out.println("a+b is less then 10");
		} else {
			System.out.println("a+b is greater than 20");
		}
	}

}
