package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class ModulePinElec extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Color actif = Color.WHITE;
	Color inactif = Color.GRAY;
	Color C0 = Color.red;
	Color C1 = Color.GREEN;
	Color couleur = inactif;
	
	public ModulePinElec(){
		super();
		this.setSize(13, 13);
	}
	
	public void setTexte(String t){
		this.setToolTipText(t);
	}
	
	public void setActif(){
		couleur = actif;
	}
	
	public void setActif(Color c){
		couleur = c;
	}
	
	public void setActif(boolean v){
		if(v == true){
			couleur = C1;
		}else{
			couleur = C0;
		}
	}
	
	public void setInactif(){
		couleur = inactif;
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(new Color(95, 88, 70));
		g2d.fillOval(0, 0, 12, 12);
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillOval(1, 1, 10, 10);
		
		g2d.setColor(couleur);
		g2d.fillOval(3, 3, 6, 6);
		
		g2d.setColor(Color.BLACK);
		g2d.fillOval(5, 5, 2, 2);
		
	}

}
