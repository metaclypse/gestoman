package com.apokal.gestoman.model;

/**
 * Models a chemical substance.
 * 
 * @author Alexander Stahl
 *
 */
public class Substance {
	private String name;
	private boolean[] hs = new boolean[7];
	private boolean[] ghs = new boolean[9];
	private int id;
	
	protected Substance (int id) {
		this.id = id;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean[] getHs() {
		return hs;
	}
	public void setHs(boolean[] hs) {
		this.hs = hs;
	}
	public boolean[] getGhs() {
		return ghs;
	}
	public void setGhs(boolean[] ghs) {
		this.ghs = ghs;
	}
	public int getId() {
		return id;
	}
	
}
