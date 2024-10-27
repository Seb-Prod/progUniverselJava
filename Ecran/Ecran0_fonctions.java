package Ecran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Elements.Bouton;
import Elements.BoutonIcon;
import Elements.Ecran;
import Elements.Label;
import fr.ProgrammeUniversel.Principal;

public class Ecran0_fonctions extends JPanel{

	/**
	 * Page de programmation du choix de la fonction
	 * 
	 * 
	 * @author sebastien Drillaud
	 * @creation 2 Février 2019
	 *
	 * @Bug :
	 * 
	 *
	 * @version 1.0 du 2 Février 2019
	 * Création de de l'écran
	 */
	
	private static final long serialVersionUID = 1L;
	
	int nEtape = 0;
	int nAction = 0;
	int nIndex = 0;
	
	//L'écran
	Ecran ecran = new Ecran(new Color(2, 63, 64));
	
	//Labels
	Label lblNumEtape = new Label(290, 24, "Etape N°22", Color.WHITE);
	Label lblNumAction = new Label(290, 24, "Action N°22", Color.WHITE);
	
	//Boutons d'action
	BoutonIcon btRetour = new BoutonIcon(80, 80, "photo", "Retour");
	
	//Bouton
	Bouton bt[] = new Bouton[7];
	
	public Ecran0_fonctions(){
		super();
		this.setSize(Principal.largeur, Principal.hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setOpaque(false);
		
		//Bouton Action
		ecran.ajout(btRetour, 5, 355);
		
		//Labels
		Label lblTitre = new Label(580, 26, "Choisir une fonction :", Color.WHITE);
		
		ecran.ajout(lblNumEtape, 0, 20);
		ecran.ajout(lblNumAction, 290, 20);
		ecran.ajout(lblTitre, 0, 55);
		
		//Bouton
		bt[0] = new Bouton("Sortie", 250, 40, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt[1] = new Bouton("Vissage", 250, 40, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt[2] = new Bouton("RFID", 250, 40, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt[3] = new Bouton("Consommation", 250, 40, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt[4] = new Bouton("Caméra", 250, 40, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt[5] = new Bouton("Traçabilité PCB", 250, 40, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt[6] = new Bouton("Soudure US", 250, 40, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		
		ecran.ajout(bt[0], 5, 94);
		ecran.ajout(bt[1], 320, 94);
		ecran.ajout(bt[2], 5, 174);
		ecran.ajout(bt[3], 320, 174);
		ecran.ajout(bt[4], 5, 254);
		ecran.ajout(bt[5], 320, 254);
		ecran.ajout(bt[6], 320, 334);
		
		this.add(ecran);
		//Ajout des listener des boutons d'action
		actionRetour();
		actionListener();
	}
	

	
	private void actionRetour(){
		//Retour à l'écran graph7
		btRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.remove(Principal.fonction);
				Principal.graph7.setVisible(true);
				Principal.fond.repaint();
			}
		});
	}
	
	private void actionListener(){
		bt[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[0].getEtat() == false){
					Principal.programme.setValeurInt(nIndex, 0, "6");
					Principal.fond.remove(Principal.fonction);
					Principal.fond.add(Principal.sortie);
					Principal.sortie.setValeur(nEtape, nAction);
					Principal.fond.repaint();
				}
			}
		});
		bt[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[1].getEtat() == false){
					Principal.programme.setValeurInt(nIndex, 0, "1");
					Principal.fond.remove(Principal.fonction);
					Principal.fond.add(Principal.vissage);
					Principal.vissage.setValeur(nEtape, nAction);
					Principal.fond.repaint();
				}
			}
		});
		bt[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[2].getEtat() == false){
					Principal.programme.setValeurInt(nIndex, 0, "5");
					Principal.fond.remove(Principal.fonction);
					Principal.fond.add(Principal.rfid);
					Principal.rfid.setValeur(nEtape, nAction);
					Principal.fond.repaint();
				}
			}
		});
		bt[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[3].getEtat() == false){
					Principal.programme.setValeurInt(nIndex, 0, "3");
					Principal.fond.remove(Principal.fonction);
					Principal.fond.add(Principal.conso);
					Principal.conso.setValeur(nEtape, nAction);
					Principal.fond.repaint();
				}
			}
		});
		bt[4].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[4].getEtat() == false){
					Principal.programme.setValeurInt(nIndex, 0, "4");
					Principal.fond.remove(Principal.fonction);
					Principal.fond.add(Principal.camera);
					Principal.camera.setValeur(nEtape, nAction);
					Principal.fond.repaint();
				}
			}
		});
		bt[5].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[5].getEtat() == false){
					Principal.programme.setValeurInt(nIndex, 0, "7");
					Principal.fond.remove(Principal.fonction);
					Principal.fond.add(Principal.pcb);
					Principal.pcb.setValeur(nEtape, nAction);
					Principal.fond.repaint();
				}
			}
		});
		bt[6].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[6].getEtat() == false){
					Principal.programme.setValeurInt(nIndex, 0, "2");
					Principal.fond.remove(Principal.fonction);
					Principal.fond.add(Principal.soudure);
					Principal.soudure.setValeur(nEtape, nAction);
					Principal.fond.repaint();
				}
			}
		});
	}


	
	
	public void setValeur(int etape, int action){
		//Affichage du numéro de l'étape
		String e = etape + "";
		if(etape < 10){
			e = "0" + etape;
		}
		lblNumEtape.setText("Etape n°" + e);
		
		//Affichage du numéro de l'action
		String a = etape + "";
		if(action < 10){
			a = "0" + action;
		}
		lblNumAction.setText("Action N°" + a);
		//Initialisation du numéro de l'étape et de l'action
		nEtape = etape;
		nAction = action;
		nIndex = Principal.programme.GetIndexTransition(nEtape) + 30 + (22 * nAction) - 22;
		int index = Principal.programme.GetIndexTransition(nEtape);
		
		for(int i = 0 ; i < 7 ; i++){
			bt[i].setInactif();
		}
		
		for(int i = 0 ; i < 5 ; i++){
			if(Principal.programme.getTypeAction(index, i).equals("Vissage")){
				bt[1].setActif();
			}
			
			if(Principal.programme.getTypeAction(index, i).equals("Soudure")){
				bt[6].setActif();
			}
			
			if(Principal.programme.getTypeAction(index, i).equals("Conso.")){
				bt[3].setActif();
			}
			
			if(Principal.programme.getTypeAction(index, i).equals("Caméra")){
				bt[4].setActif();
			}
			
			if(Principal.programme.getTypeAction(index, i).equals("RFID")){
				bt[2].setActif();
			}
			
			if(Principal.programme.getTypeAction(index, i).equals("Action")){
				bt[0].setActif();
			}
			
			if(Principal.programme.getTypeAction(index, i).equals("Traçab.")){
				bt[5].setActif();
			}
		}
	
		
	}
	
	

}
