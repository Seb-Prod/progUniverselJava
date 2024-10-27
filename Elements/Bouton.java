package Elements;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import fr.ProgrammeUniversel.Principal;

public class Bouton extends JButton{

	/**
	 * Bouton Action avec effet quand survol de la souris
	 * @param largeur : largeur du bouton
	 * @param hauteur : hauteur du bouton
	 * @param texte : texte à afficher
	 * @param CouleurInactif : couleur du bouton non actif
	 * @param CouleurActif : couleur du bouton actif
	 * @param taille : taille du texte
	 * @param bordure : si vec bordure
	 * @param info : bouton vide avec le texte en info bulle
	 * 
	 * @return getEtat : renvoie true si actif et false si inactif
	 * 
	 * 
	 * @author sebastien Drillaud
	 * @creation 15 Janvier 2018
	 *
	 *
	 * @version 1.0 du 15 Janvier 2019
	 * Création du bouton
	 *
	 * @version 1.1 du 26 Janvier 2019
	 * Optimisation de l'affichage du texte
	 * 
	 * @version 1.2 du 27 Janvier 2019
	 * Ajout du getter de l'état du bouton
	 * Ajout de l'ActionListener
	 * 
	 * @version 1.3 du 28 Janvier 2019
	 * Ajout de la possibilité de supprimer la bordure
	 */
	
	private static final long serialVersionUID = 1L;
	
	//Taille du bouton
	int L = 120;
	int H = 40;
	
	//Couleurs
	Color c = Color.GRAY;
	Color c1 = Color.GRAY;
	Color c2 = Color.GRAY.brighter();
	Color couleurActif;
	Color couleurInactif;
	boolean Bordure;
	
	//Etat du bouton
	boolean actif = false;
	
	String t;
	
	MaPolice font = new MaPolice(Principal.fontDuProgramme);
	MonJLabel lblTexte;

	public Bouton(String text, int largeur, int hauteur, Color CouleurInactif, Color CouleurActif,int taille){
		super();
		L = largeur;
		H = hauteur;
		Bordure = true;
		
		couleurActif = CouleurActif;
		couleurInactif = CouleurInactif;
		
		c = CouleurInactif;
		c1 = c;
		c2 = c.brighter();
		
		
		this.setSize(L, H);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setLayout(null);
		
		lblTexte = new MonJLabel(L, H, Color.WHITE, text, true,  "/font/Hack-Regular.ttf", taille);
		this.add(lblTexte);

		effet();
	}
	
	public Bouton(String text, int largeur, int hauteur, boolean bordure, boolean info, int taille){
		super();
		L = largeur;
		H = hauteur;
		Bordure = bordure;
		this.setSize(L, H);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setLayout(null);
		
		
		if(info == true){
			lblTexte = new MonJLabel(L, H, Color.WHITE, text, true,  "/font/Hack-Regular.ttf", taille);
			this.add(lblTexte);
		}else{
			this.setToolTipText(text);
		}

	}
	
	private void effet(){
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
				c1 = c.brighter();
				repeindre();
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				c1 = c;
				c2 = c.brighter();
				repeindre();
			}
			
		});
	}
	
	public void repeindre(){
		this.repaint();
	}

	public void action(){
		this.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(actif == true){
					setInactif();
				}else{
					setActif();
				}
				
			}
			
		});
	}
	
	
	
	public void setTexte(String text){
		lblTexte.setText(text);
	}
	
	public void setInactif(){
		c = couleurInactif;
		c1 = c;
		c2 = c.brighter();
		actif = false;
	}
	
	public void setActif(){
		c = couleurActif;
		c1 = c;
		c2 = c.brighter();
		actif = true;
	}
	
	public boolean getEtat(){
		return actif;
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
			GradientPaint gradFond = new GradientPaint(0, 0, c1, L - (L/2), H, c2);
			g2d.setPaint(gradFond);
			g2d.fillRoundRect(1, 1, L - 3, H - 3, 10, 10);
			super.paintComponent(g);
		}
		
	}
	
	public void ajoutInfoBulle(String text){
		this.setToolTipText("");
		t = text;
	}
	
	

	
}
