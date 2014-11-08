package com.apokal.gestoman.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import com.apokal.gestoman.controller.SettingsHandler;

/**
 * Graphical User Interface.
 * 
 * @author Alexander Stahl
 *
 */
public class Gui extends JFrame implements ActionListener {
	private static Gui instance = null;
	
	private LayoutManager layoutmanager;
	
	private Gui () {
		this.setSize(SettingsHandler.guiSize);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout gridlayout = new GridLayout();
		FlowLayout flowlayout = new FlowLayout();
		flowlayout.setAlignment(FlowLayout.RIGHT);
		
		this.setLayout(gridlayout);
		
		Container l1container = new Container();
		l1container.setLayout(gridlayout);
		Container l2container1 = new Container();
		l2container1.setLayout(new GridLayout());
		Container l2container2 = new Container();
		l2container2.setLayout(flowlayout);
		
		List list = new List();
		list.setSize(l1container.WIDTH, 400);
		
		l2container1.add(list);
		l2container1.add(new TextArea());
		
		l1container.add(l2container1);
		l1container.add(l2container2);
		

		JButton addButton = new JButton("Add"); 
		l2container2.add(addButton);

		JButton removeButton = new JButton("Remove");
		removeButton.setEnabled(false);
		l2container2.add(removeButton);
		
		JButton showButton = new JButton("Show");
		showButton.setEnabled(false);
		l2container2.add(showButton);
		
		this.add(l2container2);
	}
	
	public static Gui getInstance () {
		if (instance == null) {
			instance = new Gui();
		}
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
