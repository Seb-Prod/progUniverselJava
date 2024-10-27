package Elements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelFissure extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon icon;
	int largeur;
	int hauteur;

	public LabelFissure(){
		this.setSize(100, 80);
		icon = new ImageIcon(getClass().getResource("/img/ecran.png"));
		this.setIcon(icon);
	}
}
