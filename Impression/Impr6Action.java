package Impression;

import java.awt.Color;

import javax.swing.JPanel;

import Elements.Label;

public class Impr6Action extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Impr6Action(){
		super();
		this.setSize(400, 100);
		Label lblTitre = new Label(400, 20, "Vissage", Color.BLACK);
		
		lblTitre.setLocation(0, 0);
		this.add(lblTitre);
		
	}

}
