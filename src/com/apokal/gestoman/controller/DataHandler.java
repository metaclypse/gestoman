package com.apokal.gestoman.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataHandler {
	public static String loadAsString (String file) {
		String result = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = reader.readLine()) != null) {
				result += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
