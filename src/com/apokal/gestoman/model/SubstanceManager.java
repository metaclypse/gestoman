package com.apokal.gestoman.model;

import java.util.ArrayList;

/**
 * Responsible for providing managing features regarding the Substance class.
 * @author Alexander Stahl
 *
 */
public class SubstanceManager {
	private ArrayList<Substance> substances;
	
	public SubstanceManager () {
		substances = new ArrayList<Substance>();
	}
	
	public int getFreeId () {
		for (int i = 0; i <= substances.size(); i++) {
			boolean good = true;
			for (int j = 0; j <= substances.size() - 1; j++) {
				if (i == substances.get(j).getId()) {
					good = false;
				}
			}
			if (good) return i;
		}
		return -1; //error
	}
	
	public Substance createSubstance (String name, boolean[] hs, boolean[] ghs) {
		int id = getFreeId();
		Substance s = new Substance(id);
		s.setGhs(ghs);
		s.setHs(hs);
		s.setName(name);
		return s;
	}
	
	public void addSubstance (Substance substance) {
		substances.add(substance);
	}
}
