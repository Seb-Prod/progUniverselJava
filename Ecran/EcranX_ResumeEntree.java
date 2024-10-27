package Ecran;

import java.awt.Color;
import javax.swing.JPanel;

import Elements.Label;
import Elements.PanelPastille;
import Panel.Panel;
import fr.ProgrammeUniversel.PoidBouton;
import fr.ProgrammeUniversel.Principal;

public class EcranX_ResumeEntree extends JPanel{

	/**
	 * Page de programmation des tansition
	 * 
	 * 
	 * 
	 * @author sebastien Drillaud
	 * @creation 29 janvier 2019
	 *
	 * @Bug :
	 * 
	 *
	 * @version 1.0 du 29 Janvier 2019
	 * Création de de l'écran
	 *
	 */
	
	private static final long serialVersionUID = 1L;
	
	int nEtape;
	int nAction;
	int largeur = 645;
	int hauteur = 525;
	
	Panel ecran = new Panel(580, 435);
	
	PanelPastille E2[] = new PanelPastille[8];
	PanelPastille E3[] = new PanelPastille[8];
	PanelPastille E4[] = new PanelPastille[8];
	PanelPastille E6[] = new PanelPastille[8];
	PanelPastille E7[] = new PanelPastille[8];
	
	Label lbl[] = new Label[21];
	
	Panel pEtape = new Panel(12, 425, Color.GRAY);
	public Panel pEntree = new Panel(520, 13, Color.GRAY);

	public EcranX_ResumeEntree(){
		super();
		this.setSize(largeur, hauteur);
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setOpaque(false);
		
		int x = 178;
		int y = 25;

		for(int i = 0 ; i < 8 ; i ++){
			
			E2[i] = new PanelPastille("E2." + i, "azertyuiopqsdfghjklm");
			E3[i] = new PanelPastille("E3." + i, "azertyuiopqsdfghjklm");
			E4[i] = new PanelPastille("E4." + i, "azertyuiopqsdfghjklm");
			E6[i] = new PanelPastille("E6." + i, "azertyuiopqsdfghjklm");
			E7[i] = new PanelPastille("E7." + i, "azertyuiopqsdfghjklm");
			
			ecran.ajout(E2[i], 0, y);
			ecran.ajout(E3[i], 0, y + (8 * 13));
			ecran.ajout(E4[i], 0, y + (16 * 13));
			ecran.ajout(E6[i], 0, y + (24 * 13));
			ecran.ajout(E7[i], 0, y + (24 * 13));
			
			if(i >= 4 && i < 7){
				E6[i].setVisible(false);
			}
			if(i > 3){
				E7[i].setVisible(false);
			}
			
			y = y + 13;
			
		}
		E6[7].setLocation(0, 389);
		E7[0].setVisible(false);
		E7[1].setVisible(false);
		E7[2].setLocation(0, 402);
		E7[3].setLocation(0, 415);
		
		
		for(int i = 0 ; i < 21 ; i++){
			lbl[i] = new Label(15, 10, i + "", Color.WHITE);
			lbl[i].setLocation(x, 5);
			x = x + 15;
			ecran.add(lbl[i]);
		}
		
		ecran.ajout(pEtape, 179, 10);
		ecran.ajout(pEntree, 5, 25);
		this.add(ecran);

		pEntree.setVisible(false);

	}
	
	public void setEtape(int netape){
		pEtape.setLocation(149 + (15 * netape) + 30, 3);
	}
	
	public void setPosition(int x){
		pEntree.setLocation(5, x + 55);
	}

	public void maj(){
		Principal.resume.setCouleurEcran1(new Color(64, 160, 159));
		int indexTxt = 0;
		//Texte E2.
		for(int i = 0 ; i < 8 ; i++){
			E2[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
		}
		//Texte E3.
		for(int i = 0 ; i < 8 ; i++){
			E3[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
		}
		//Texte E4.
		for(int i = 0 ; i < 8 ; i++){
			E4[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
		}
		//Texte E6.
		for(int i = 0 ; i < 8 ; i++){
			E6[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
		}
		//Texte E7.
		for(int i = 0 ; i < 8 ; i++){
			E7[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
		}
				
		PoidBouton index = new PoidBouton();
		int nIndex = 0;
		for(int i = 0 ; i < 21 ; i++){
			nIndex = index.getIndexTransition(i);
			for(int y = 0 ; y < 8 ; y++){
				//Etat boutons E2
				if(Principal.programme.getBit(nIndex, 0, y) == 1){
					E2[y].setActif(i);
				}else{
					E2[y].setNull(i);
				}
				if(Principal.programme.getBit(nIndex, 6, y) == 1){
					E2[y].setPasActif(i);
				}
				
				//Etat boutons E3
				if(Principal.programme.getBit(nIndex, 1, y) == 1){
					E3[y].setActif(i);
				}else{
					E3[y].setNull(i);
				}
				if(Principal.programme.getBit(nIndex, 7, y) == 1){
					E3[y].setPasActif(i);
				}
				
				//Etat boutons E4
				if(Principal.programme.getBit(nIndex, 2, y) == 1){
					E4[y].setActif(i);
				}else{
					E4[y].setNull(i);
				}
				if(Principal.programme.getBit(nIndex, 8, y) == 1){
					E4[y].setPasActif(i);
				}
				
				//Etat boutons E6
				if(Principal.programme.getBit(nIndex, 4, y) == 1){
					E6[y].setActif(i);
				}else{
					E6[y].setNull(i);
				}
				if(Principal.programme.getBit(nIndex, 10, y) == 1){
					E6[y].setPasActif(i);
				}
				
				//Etat boutons E7
				if(Principal.programme.getBit(nIndex, 5, y) == 1){
					E7[y].setActif(i);
				}else{
					E7[y].setNull(i);
				}
				if(Principal.programme.getBit(nIndex, 11, y) == 1){
					E7[y].setPasActif(i);
				}
				
			}
		}
		
		for(int i = 0 ; i < 8 ; i++){
			E2[i].setResultat();
			E3[i].setResultat();
			E4[i].setResultat();
			E6[i].setResultat();
			E7[i].setResultat();
		}
		
		
	}

	

	

	
	

}
