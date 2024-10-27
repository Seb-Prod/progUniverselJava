package Elements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelVis extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon icon;
	int largeur;
	int hauteur;

	public LabelVis(){
		this.setSize(30, 30);
		icon = new ImageIcon(getClass().getResource("/img/vis.png"));
		this.setIcon(icon);
	}
	

	
}
