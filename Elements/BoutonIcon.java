package Elements;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonIcon extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon iconTmps;
	int largeur;
	int hauteur;

	public BoutonIcon(int width, int height, String img, String text){
		this.setSize(width, height);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setToolTipText(text);
		largeur = width;
		hauteur = height;
		iconTmps = new ImageIcon(getClass().getResource("/img/" + img + ".png"));
		icon = new ImageIcon(iconTmps.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
		//iconTmps = null;
		this.setIcon(icon);
	}
	
	public void changeIcon(String img){
		iconTmps = new ImageIcon(getClass().getResource("/img/" + img + ".png"));
		icon = new ImageIcon(iconTmps.getImage().getScaledInstance(largeur, hauteur, java.awt.Image.SCALE_SMOOTH));
		iconTmps = null;
		this.setIcon(icon);
	}
	
	public void changeTaille(int width, int height){
		this.setSize(width, height);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		largeur = width;
		hauteur = height;
		//iconTmps = new ImageIcon(getClass().getResource("/img/" + img + ".png"));
		icon = new ImageIcon(iconTmps.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
		//iconTmps = null;
		this.setIcon(icon);
	}
	
	
}
