package Elements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelEquipe extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon icon;
	int largeur;
	int hauteur;

	public LabelEquipe(){
		this.setSize(320, 369);
		icon = new ImageIcon(getClass().getResource("/img/equipe.png"));
		this.setIcon(icon);
	}
	

	
}
