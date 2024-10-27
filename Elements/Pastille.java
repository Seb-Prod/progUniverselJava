package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Pastille extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color c = Color.GRAY;
	String actif;
	
	public Pastille(){
		super();
		this.setSize(10, 10);
		this.setOpaque(false);
		this.setForeground(Color.BLACK);
	}
	
	public void setActif(){
		c = new Color(11, 150, 22);
		actif = "true";
	}
	
	public void setPasActif(){
		c = new Color(150, 42, 22);
		actif = "false";
	}
	
	public void setNull(){
		c = Color.GRAY;
		actif = "null";
	}
	
	public String getEtat(){
		return actif;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Fond
		
		// Bordure
		g2d.setColor(Color.BLACK);
		g2d.fillOval(0, 0, 10, 10);
		g2d.setColor(c);
		g2d.fillOval(1, 1, 8, 8);
	}

}
