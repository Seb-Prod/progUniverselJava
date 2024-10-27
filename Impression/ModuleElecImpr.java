package Impression;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import Elements.Label;

public class ModuleElecImpr extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color c = Color.GRAY;
	String actif;
	Label lbl[] = new Label[12];
	Label lblB[] = new Label[6];
	ModulePinElec pin[] = new ModulePinElec[12];
	
	public ModuleElecImpr(){
		super();
		this.setSize(90, 202);
		this.setOpaque(false);
		this.setLayout(null);
		this.setForeground(Color.BLACK);
		
		int y = 10;
		for(int i = 0 ; i < 6 ; i++){
			lbl[i] = new Label(20, 12, (i + 1) + "", new Color(84, 77, 63));
			pin[i] = new ModulePinElec();
			lbl[i].setLocation(2, y);
			pin[i].setLocation(20, y - 2);
			this.add(lbl[i]);
			this.add(pin[i]);
			y = y + 32;
		}
		y = 10;
		for(int i = 6 ; i < 12 ; i++){
			lbl[i] = new Label(20, 12, (i + 1) + "", new Color(84, 77, 63));
			pin[i] = new ModulePinElec();
			lbl[i].setLocation(70, y);
			pin[i].setLocation(47, y - 2);
			this.add(pin[i]);
			this.add(lbl[i]);
			y = y + 32;
		}
	}
	
	public void setTexte(int n, String t){
		pin[n - 1].setTexte(t);
	}
	
	public void setActif(int n){
		pin[n - 1].setActif();
	}
	
	public void setActif(int n, Color c){
		pin[n - 1].setActif(c);
	}
	
	public void setActif(int n, boolean v){
		pin[n - 1].setActif(v);
	}
	
	public void setInactif(int n){
		pin[n - 1].setInactif();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(new Color(95, 88, 70));
		g2d.fillRect(0, 0, 88, 200);
		
		g2d.setColor(new Color(200, 194, 175));
		g2d.fillRect(4, 4, 80, 192);

	}

}
