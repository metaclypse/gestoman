package com.apokal.gestoman.controller;

import com.apokal.gestoman.model.SubstanceManager;
import com.apokal.gestoman.model.SupplyManager;
import com.apokal.gestoman.view.Gui;

public class Controller {
	private SubstanceManager substancemanager;
	private SupplyManager supplymanager;
	private ResourceLoader resourceloader;
	private DataHandler datahandler;
	private Gui gui;
	
	public void init () {
		substancemanager = new SubstanceManager();
		supplymanager = new SupplyManager();
		resourceloader = new ResourceLoader();
		datahandler = DataHandler.getInstance();
		gui = Gui.getInstance();
		gui.setVisible(true);
	}
}
