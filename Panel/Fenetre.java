package Panel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Fenetre extends JFrame {

	/**
	 * Création d'une fenêtre
	 * @param l Largeur
	 * @param h Largeur
	 * @param t Texte dans la barre de titre
	 * @since 1.0
	 * @author Sébastien Drillaud
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	

	public Fenetre (int l, int h, String t){
		this.setSize(l, h);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(false);
		this.setLayout(null);
		this.setTitle(t);
		ImageIcon iconTmps = new ImageIcon(getClass().getResource("/img/photo.png"));
		ImageIcon icon = new ImageIcon(iconTmps.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH));
		Image logo = icon.getImage();
		this.setIconImage(logo);
		
		//this.setUndecorated(true); 
		
	    //this.setBackground(new Color(0, 0, 0, 100)); 
		//setOpacity(0.4f);
	}
}
