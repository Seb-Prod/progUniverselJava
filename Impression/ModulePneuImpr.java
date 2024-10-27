package Impression;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import Elements.Label;

public class ModulePneuImpr extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color c = Color.GRAY;
	String actif;
	ModulePinPneu pin[] = new ModulePinPneu[3];
	
	public ModulePneuImpr(){
		super();
		this.setSize(90, 202);
		this.setOpaque(false);
		this.setLayout(null);
		this.setForeground(Color.BLACK);
		Label lbl1 = new Label(30, 36, "1", Color.BLACK);
		Label lbl2 = new Label(30, 36, "2", Color.BLACK);
		Label lbl3 = new Label(30, 36, "3", Color.BLACK);
		lbl1.setLocation(58, 20);
		lbl2.setLocation(58, 80);
		lbl3.setLocation(58, 140);
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		
		int y = 20;
		for(int i  = 0 ; i < 3 ; i++){
			pin[i] = new ModulePinPneu();
			pin[i].setLocation(24, y);
			this.add(pin[i]);
			y = y + 60;
		}
	}
	
	public void setTexte(int n, String t){
		pin[n - 1].setTexte(t);
	}
	

	
	public void setCouleurActif(int n, Color C){
		pin[n - 1].setCouleurActif(C);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(new Color(10, 116, 175));
		g2d.fillRect(14, 0, 60, 200);
		g2d.fillRect(0, 10, 88, 180);
		
		g2d.setColor(new Color(41, 76, 120));
		g2d.fillRect(0, 10, 4, 180);
		g2d.fillRect(84, 10, 6, 180);
		
		g2d.fillRect(14, 0, 60, 4);
		g2d.fillRect(14, 196, 60, 4);
		
		
		g2d.fillRect(0, 10, 16, 4);
		g2d.fillRect(0, 188, 16, 4);
		
		
		g2d.fillRect(14, 0, 4, 12);
		g2d.fillRect(74, 0, 4, 12);
		
		g2d.fillRect(14, 188, 4, 12);
		g2d.fillRect(74, 188, 4, 12);
		
		
		g2d.fillRect(74, 10, 20, 4);
		g2d.fillRect(74, 184, 20, 4);
		
		g2d.fillRect(0, 34, 40, 12);
		g2d.fillRect(0, 94, 40, 12);
		g2d.fillRect(0, 154, 40, 12);
		
	}

}
