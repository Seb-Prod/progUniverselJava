package Elements;

import java.awt.Color;
import java.awt.FontMetrics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MonJLabel extends JLabel{

	/**
	 * class MomJLabel
	 * Création de JLabel Personalisé
	 * 
	 * @param width : largeur du JLabel
	 * @param height : hauteur du JLabel
	 * @param color : couleur du texte
	 * @param text : texte du JLabel
	 * @param centrer : centre le texte si true
	 * @param police : police de caractère
	 * @param tailleFont : taille de la police de caractère
	 * 
	 * @author Sébastien Drillaud
	 * @date 26 janvier 2018
	 * @version 1.0
	 */
	
	private static final long serialVersionUID = 1L;
	
	MaPolice font;
	
	public MonJLabel(int width, int height, Color color, String text, boolean centrer, String police, int tailleFont){
		super();
		font = new MaPolice(police);
		this.setForeground(color);
		this.setFont(font.setTaille(tailleFont));
		this.setText(text);
		
		if(centrer == true){
			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setSize(width, height);
		}else{
			FontMetrics metrics = getFontMetrics(this.getFont()); 
			int messageWidth = metrics.stringWidth(this.getText()); 
			this.setSize(messageWidth + 4, height);
		}
		
		
	}

}
