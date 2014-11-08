package com.apokal.gestoman.model;

import java.util.ArrayList;

/**
 * Responsible for providing managing features for Supply objects.
 * @author Alexander Stahl
 *
 */
public class SupplyManager {
	private ArrayList<Supply> supplies;
	
	public SupplyManager() {
		supplies = new ArrayList<Supply>();
	}
	
	public void addSupply (Supply supply) {
		supplies.add(supply);
	}
	
	public Supply createSupply (int substance_id, String name) {
		Supply s = new Supply();
		s.setName(name);
		s.setSubstance_id(substance_id);
		
		return s;
	}
	
	public Supply findSupplyByName (String name) {
		for (Supply s : supplies) {
			if (s.getName().equals(name)) return s;
		}
		return null;
	}
	
	public ArrayList<Supply>listSupplies () {
		return supplies;
	}
	
}
