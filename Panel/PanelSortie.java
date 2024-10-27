package Panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import Elements.Bouton;
import Elements.Saisie;
import fr.ProgrammeUniversel.Principal;

public class PanelSortie extends JPanel{

	/**
	 * Panel pour les sorties
	 * Avec un bouton pour activé la sortie et une zone de saise pour saisir le libéllé de la sortie
	 * 
	 * Possiblilé de créer en version grande ou petite.
	 * Toute intéranction sur une version est automatiquement dupliqué sur l'autre
	 * 
	 * @param texte : texte du bouton
	 * @param mini : choix entre grande et petite version
	 * @param posX : position en X du panel résumé
	 * 
	 * @return getEtat : retour si bouton actif ou pas
	 * @return getTexte : retour du texte de la zone de saisie
	 * 
	 * @setter setActif : colore le bouton comme actif
	 * @setter setInactif : colore le bouton comme inactif
	 * @setter setTexte : remplie la zone de saisie
	 * 
	 * @author sebastien Drillaud
	 * @creation 31 janvier 2019
	 * @version 1.0 du 31 janvier 2019
	 * 
	 *
	 */
	
	private static final long serialVersionUID = 1L;
	
	Bouton bt;
	Saisie saisie;
	String TEXTE;
	String msg;
	int POSX;
	
	
	public PanelSortie(String texte, boolean mini, final int posX){
		super();
		this.setLayout(null);
		this.setOpaque(false);
		
		TEXTE = texte;
		POSX = posX;
		
		if(mini == false){
			PanelSortieGrand();
		}else{
			PanelSortiePetit();
		}
		
		ajoutMouseListener(bt);
		ajoutMouseListener(saisie);
		ajoutMouseListener(this);
		bt.action();
		
		this.add(saisie);
		this.add(bt);
		
	}
	
	private void PanelSortieGrand(){
		this.setSize(580, 50);
		
		bt = new Bouton(TEXTE, 70, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt.setLocation(65, 2);
		saisie = new Saisie("string", 20, 24);
		saisie.setSize(370, 46);
		saisie.setLocation(150, 0);
		
	}
	
	private void PanelSortiePetit(){
		this.setSize(270, 25);
		
		bt = new Bouton(TEXTE, 35, 20, new Color(11, 42, 22), new Color(11, 150, 22), 10);
		bt.setLocation(65, 2);
		saisie = new Saisie("string", 20, 12);
		saisie.setSize(160, 23);
		saisie.setLocation(105, 0);
		
	}
	
	public void ajoutKeyListener(final PanelSortie p){
		saisie.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				p.setTexte(saisie.getText());
				
			}
			
		});
	}
	
	public void ajoutActionListener(final PanelSortie p){
		bt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt.getEtat() == false){
					p.setActif();
				}else{
					p.setInactif();
				}
				
			}
			
		});
	}
	
	public void ajoutActionListener(final int module, final int pin, final int module2, final int pin2){
		bt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Color Actif = Color.LIGHT_GRAY;
				Color Inactif = new Color(0, 187, 210);
				if(bt.getEtat() == false){
					Principal.param.modulePneu[module].setCouleurActif(pin, Inactif);
					Principal.param.modulePneu[module2].setCouleurActif(pin2, Actif);
				}else{
					Principal.param.modulePneu[module2].setCouleurActif(pin2, Inactif);
					Principal.param.modulePneu[module].setCouleurActif(pin, Actif);
				}
				Principal.param.repaint();
			}
			
		});
	}
	
	public void ajoutActionListener(final int module, final int pin){
		bt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt.getEtat() == false){
					Principal.param.moduleElec[module].setActif(pin);
				}else{
					Principal.param.moduleElec[module].setInactif(pin);
				}
				Principal.param.repaint();
			}
			
		});
	}
	
	public void setActif(){
		bt.setActif();
	}
	
	public void setInactif(){
		bt.setInactif();
	}
	
	public boolean getEtat(){
		return bt.getEtat();
	}
	
	public String getTexte(){
		return saisie.getText();
	}
	
	private void ajoutMouseListener(Object o){
		((Component) o).addMouseListener(new MouseListener(){

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
				Principal.resumeAction.pSortie.setVisible(true);
				Principal.resumeAction.setPosition(POSX);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Principal.resumeAction.pSortie.setVisible(false);
				
			}
			
		});
	}
	
	private void ajouListener(Object o){
		((Component) o).addMouseListener(new MouseListener(){

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
				Principal.postIt.setVisible(true);
				Principal.postIt.setTexte(msg, "Disponible sur API mais", "pas sur l'outil par manque", "de place dans la prise Harting");
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Principal.postIt.setVisible(false);
				
			}
			
		});
	}
	
	public void ajoutInfoBulle(String t){
		ajouListener(saisie);
		ajouListener(bt);
		msg = t;
		
	}
	

	public void setTexte(String t){
		saisie.setText(t);
	}
	
	
}
