package com.apokal.gestoman.model;

public class Supply {
	private int id;
	private UnitValue amount;
	private int aggregate_state;
	private String name;
	private Location location;
	private String comment;
	private int substance_id;
		
	public int getSubstance_id() {
		return substance_id;
	}

	public void setSubstance_id(int substance_id) {
		this.substance_id = substance_id;
	}

	protected Supply () {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UnitValue getAmount() {
		return amount;
	}
	public void setAmount(UnitValue amount) {
		this.amount = amount;
	}
	public int getAggregate_state() {
		return aggregate_state;
	}
	public void setAggregate_state(int aggregate_state) {
		this.aggregate_state = aggregate_state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
