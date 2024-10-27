package Elements;

import java.awt.Color;
import java.awt.FontMetrics;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fr.ProgrammeUniversel.Principal;

public class Label extends JLabel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	int Largeur = 0;
	MaPolice font = new MaPolice(Principal.fontDuProgramme);
	
	public Label(int l, int h, String t, Color c){
		super();
		this.setSize(l, h + 4);
		this.setFont(font.setTaille(h));
		this.setForeground(c);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setText(t);
	}
	
	public Label(int l, int h, String t, Color c, int taille){
		super();
		this.setSize(l, h + 4);
		this.setFont(font.setTaille(taille));
		this.setForeground(c);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setText(t);
	}
	
	public Label(int l, int h, String t, Color c, String police){
		super();
		this.setSize(l, h + 4);
		MaPolice font2 = new MaPolice("/font/" + police + ".ttf");
		
		this.setFont(font2.setTaille(h));
		this.setForeground(c);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setText(t);
	}
	
	public Label(int l, int h, String t, Color c, Color c2, boolean opaque){
		super();
		this.setSize(l, h + 4);
		this.setFont(font.setTaille(h));
		this.setForeground(c);
		this.setText(t);
		this.setBackground(c2);
		this.setOpaque(opaque);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
	}
	
	
	public Label(String t, Color c, int taille){
		super();
		
		this.setFont(font.setTaille(taille));
		this.setText(t);
		FontMetrics metrics = getFontMetrics(this.getFont()); 
		int messageWidth = metrics.stringWidth(this.getText()); 
		this.setForeground(c);
		this.setSize(messageWidth, taille + 4);
		this.setVerticalAlignment(SwingConstants.CENTER);
		
		Largeur =100;
	}
	
	public Label(String t, Color c, Color f, int taille){
		super();
		//Font font = null;
		
		this.setFont(font.setTaille(taille));
		this.setText(t);
		FontMetrics metrics = getFontMetrics(this.getFont()); 
		int messageWidth = metrics.stringWidth(this.getText()); 
		this.setForeground(c);
		this.setOpaque(true);
		this.setBackground(f);
		this.setSize(messageWidth + 4, taille + 4);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER); 
		Largeur = messageWidth;
	}
	
	
	
	public int getLargeur(){
		
		return Largeur;
		
	}
	
	
}
