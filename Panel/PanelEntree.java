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
import Elements.Label;
import Elements.Saisie;
import fr.ProgrammeUniversel.Principal;

public class PanelEntree extends JPanel{

	/**
	 * Panel pour les entrées
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
	
	Bouton bt_0;
	Bouton bt_1;
	Label lbl;
	Saisie saisie;
	String TEXTE;
	int POSX;
	String msg;
	
	
	public PanelEntree(String texte, boolean mini, final int posX){
		super();
		this.setLayout(null);
		this.setOpaque(false);
		
		TEXTE = texte;
		POSX = posX;
		
		if(mini == false){
			PanelGrand();
		}else{
			PanelPetit();
		}
		
		ajoutMouseListener(bt_0);
		ajoutMouseListener(bt_1);
		ajoutMouseListener(saisie);
		ajoutMouseListener(lbl);
		ajoutMouseListener(this);
		bt_0.action();
		bt_1.action();
		
		this.add(saisie);
		this.add(lbl);
		this.add(bt_0);
		this.add(bt_1);
	}
	
	private void PanelGrand(){
		this.setSize(580, 50);
		
		lbl = new Label(70, 26, TEXTE, Color.WHITE);
		saisie = new Saisie("string", 20, 24);
		bt_0 = new Bouton("= 0", 65, 41, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt_1 = new Bouton("= 1", 65, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		
		saisie.setSize(360, 46);
		
		lbl.setLocation(5, 10);
		saisie.setLocation(75, 0);
		bt_0.setLocation(440, 2);
		bt_1.setLocation(510, 2);
		
	}
	
	private void PanelPetit(){
		this.setSize(270, 25);
		
		lbl = new Label(45, 13, TEXTE, Color.WHITE);
		saisie = new Saisie("string", 20, 12);
		bt_0 = new Bouton("= 0", 32, 20, new Color(42, 11, 22), new Color(150, 42, 22), 10);
		bt_1 = new Bouton("= 1", 32, 20, new Color(11, 42, 22), new Color(11, 150, 22), 10);
		
		saisie.setSize(160, 23);
		
		lbl.setLocation(5, 3);
		saisie.setLocation(45, 0);
		bt_0.setLocation(205, 1);
		bt_1.setLocation(237, 1);
		
	}
	
	public void ajoutKeyListener(final PanelEntree p){
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
	
	public void ajoutActionListener_bt0(final PanelEntree p){
		bt_0.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt_0.getEtat() == false){
					p.setActif_bt0();
					setInactif_bt1();
					p.setInactif_bt1();
					bt_1.repaint();
				}else{
					p.setInactif_bt0();
				}
				
			}
			
		});
	}
	
	public void ajoutActionListener_bt1(final PanelEntree p){
		bt_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt_1.getEtat() == false){
					p.setActif_bt1();
					setInactif_bt0();
					p.setInactif_bt0();
					bt_0.repaint();
				}else{
					p.setInactif_bt1();
				}
				repaint();
			}
			
		});
	}
	
	public void ajoutActionListener_bt0(final int module, final int pin){
		bt_0.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(bt_0.getEtat() == false){
					Principal.param.moduleElec[module].setActif(pin, false);
				}else{
					Principal.param.moduleElec[module].setInactif(pin);
				}
				Principal.param.repaint();
			}
			
		});
	}
	
	public void ajoutActionListener_bt1(final int module, final int pin){
		bt_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt_1.getEtat() == false){
					Principal.param.moduleElec[module].setActif(pin, true);
				}else{
					Principal.param.moduleElec[module].setInactif(pin);
				}
				Principal.param.repaint();
			}
			
		});
	}
	
	public void setActif_bt0(){
		bt_0.setActif();
	}
	
	public void setInactif_bt0(){
		bt_0.setInactif();
	}
	
	public boolean getEtat_bt0(){
		return bt_0.getEtat();
	}
	
	public void setActif_bt1(){
		bt_1.setActif();
	}
	
	public void setInactif_bt1(){
		bt_1.setInactif();
	}
	
	public boolean getEtat_bt1(){
		return bt_1.getEtat();
	}
	
	public String getTexte(){
		return saisie.getText();
	}
	
	@Override
	public void repaint(){
		
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
				Principal.resumeEntree.pEntree.setVisible(true);
				Principal.resumeEntree.setPosition(POSX);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Principal.resumeEntree.pEntree.setVisible(false);
				
			}
			
		});
	}

	public void setTexte(String t){
		saisie.setText(t);
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
		ajouListener(bt_0);
		ajouListener(bt_1);
		msg = t;
		
	}

}
