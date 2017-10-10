package com.ibm.dst.pwgen;

import java.util.Random;

public class PasswordGenerator {
	public static void main(String[] args) {
		PasswordGenerator pg = new PasswordGenerator();
		
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		
		StringBuffer pws = new StringBuffer();
		for (int count = 0; count < 25; count++) {
			String pw = pg.genPw(r);
			
			pws.append(pw).append("\n");
		}
		
		System.out.println(pws);
	}
	
	private String genPw(Random r) {
		StringBuffer pw = new StringBuffer();
		
		// generate 6 characters( upper&lower case included)
		for (int i = 0; i < 6; i++) {
			char c = this.genCharacter(r);
			
			pw.append(c);
		}
		
		// generate 1 special character
		char s = this.genSpecialCharacter(r);
		pw.append(s);
		
		// generate 1 number
		char n = this.genNumber(r);
		pw.append(n);
		
		return pw.toString();
	}
	
	private char genCharacter(Random r) {
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		
		StringBuffer sb = new StringBuffer();
		sb.append(upperCase).append(lowerCase);
		
		String characters = sb.toString();
		
		int index = r.nextInt(characters.length());
		
		return characters.charAt(index);
	}
	
	private char genSpecialCharacter(Random r) {
		String specialCharacters = "!\"#$%&";
		
		int index = r.nextInt(specialCharacters.length());
		
		return specialCharacters.charAt(index);
	}
	
	private char genNumber(Random r) {
		String numbers = "0123456789";
		
		int index = r.nextInt(numbers.length());
		
		return numbers.charAt(index);
	}
}