package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fr.ProgrammeUniversel.Principal;

public class LabelLettre extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MaPolice font = new MaPolice(Principal.fontDuProgramme);
	int taille;
	Color couleur = Color.GRAY;
	
	
	public LabelLettre(int Taille, int TailleTexte, Color C){
		super();
		taille = Taille - 1;
		this.setSize(Taille, Taille);
		this.setFont(font.setTaille(TailleTexte));
		this.setForeground(C);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
	}
	
	public void changeCouleur(Color c){
		couleur = c;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Fond
		g2d.setColor(couleur);
		g2d.fillRoundRect(0, 0, taille, taille, 2, 2);
		g2d.setColor(Color.BLACK);
		g2d.drawRoundRect(0, 0, taille, taille, 2, 2);
		
		super.paintComponent(g);
	}

}
