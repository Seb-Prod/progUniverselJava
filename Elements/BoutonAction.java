package Elements;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BoutonAction extends JButton{

	/**
	 * Bouton Action avec effet quand survol de la souris
	 * @param largeur
	 * @param hauteur
	 * @param texte
	 * @since 1.0
	 * @author Sébastien Drillaud
	 * @date 15 janvier 2019
	 */
	
	private static final long serialVersionUID = 1L;
	
	int L = 120;
	int H = 40;
	Color c = Color.GRAY;
	Color c1 = Color.GRAY;
	Color c2 = Color.GRAY.brighter();
	boolean Bordure = true;
	
	int Type = 0;

	public BoutonAction(String text, int largeur, int hauteur){
		super();
		Bordure = true;
		L = largeur;
		H = hauteur;
		this.setSize(L, H);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setLayout(null);
		this.setForeground(Color.BLACK);
		this.setText(text);
		
		this.addMouseListener(new java.awt.event.MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				c2 = c;
				c1 = Color.WHITE;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				c1 = c;
				c2 = Color.WHITE;
				repaint();
			}
			
		});
	}
	
	public BoutonAction(String text, int largeur, int hauteur, boolean bordure, boolean info){
		super();
		L = largeur;
		H = hauteur;
		Bordure = bordure;
		this.setSize(L, H);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setLayout(null);
		if(info = true){
			this.setToolTipText(text);
		}else{
			this.setText(text);
		}
		
	}
	
	public void setType(int n){
		Type = n;
	}
	
	public int getType(){
		return Type;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(Bordure == true){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// Bordure
			g2d.setColor(Color.LIGHT_GRAY);
			g2d.fillRoundRect(0, 0, L - 1, H - 1, 10, 10);
			
			// Fond
			GradientPaint gradFond = new GradientPaint(0, 0, c2, L - (L/2), H, c1);
			g2d.setPaint(gradFond);
			g2d.fillRoundRect(1, 1, L - 3, H - 3, 10, 10);
			super.paintComponent(g);
		}
		
	}
}
