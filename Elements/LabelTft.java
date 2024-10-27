package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelTft extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon icon;
	int Largeur;
	int Hauteur;
	Image image;
	
	public LabelTft(int largeur, int hauteur){
		Largeur = largeur;
		Hauteur = hauteur;
		this.setSize(largeur, hauteur);
		
		icon = new ImageIcon(getClass().getResource("/img/tft.png"));
		ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(580, 435, java.awt.Image.SCALE_SMOOTH));
		image = icon2.getImage();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Bordure écran
		//g.drawImage(image, 0, 0, null);
		g2d.setColor(Color.BLACK);
		//g2d.drawRoundRect(0, 0, Largeur + 2, Hauteur + 2, 15, 15);
		g2d.setClip(new RoundRectangle2D.Double(0, 0, Largeur, Hauteur, 10, 10));
		g2d.drawImage(image, 0, 0, null);
	

		
		
		
		
	}
	
}
