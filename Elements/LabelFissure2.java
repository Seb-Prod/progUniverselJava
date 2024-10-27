package Elements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelFissure2 extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon icon;
	int largeur;
	int hauteur;

	public LabelFissure2(){
		this.setSize(150, 196);
		icon = new ImageIcon(getClass().getResource("/img/fisure.png"));
		this.setIcon(icon);
	}
	

	
}
