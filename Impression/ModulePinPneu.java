package Impression;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class ModulePinPneu extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color tuyau = Color.DARK_GRAY;
	Color Actif = Color.black;
	
	public ModulePinPneu(){
		super();
		this.setSize(42, 42);
	}
	
	public void setTexte(String t){
		this.setToolTipText(t);
	}
	

	
	public void setCouleurActif(Color c){
		Actif = c;
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.BLACK);
		g2d.fillOval(0, 0, 40, 40);
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillOval(4, 4, 32, 32);	

		g2d.setColor(Actif);
		g2d.fillOval(12, 12, 16, 16);		
	}

}
