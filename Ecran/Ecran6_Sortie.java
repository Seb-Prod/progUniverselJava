package Ecran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Elements.BoutonIcon;
import Elements.Ecran;
import Elements.Label;
import Elements.MonJLabel;
import Panel.PanelSortie;
import fr.ProgrammeUniversel.PoidBouton;
import fr.ProgrammeUniversel.Principal;

public class Ecran6_Sortie extends JPanel{

	/**
	 * Page de programmation de l'action sortie
	 * 
	 * 
	 * A2 = index + 5
	 * A4 = index + 9
	 * A5 = index + 11
	 * A6 = index + 13
	 * 
	 * @author sebastien Drillaud
	 * @creation 24 janvier 2019
	 *
	 * @Bug :
	 * 
	 *
	 * @version 1.0 du 24 Janvier 2019
	 * Création de de l'écran
	 *
	 * @version 1.1 du 28 Janvier 2019
	 * Ajout du chargement des textes
	 * Ajout du chargement des etat des boutons
	 * Ajout de la suppression des donnée
	 * Ajouter de la validation des donnée
	 * Ajout boite de dialogue de confirmation pour la suppression et la modification des données
	 * 
	 * @version 1.2 du 29 Janvier 2019
	 * Ajout du zoom pour tous affichier sur un écran
	 * 
	 * @version 1.3 du 31 Janvier 2019
	 * Simplification du code en utilisant le @see PanelSortie 
	 * qui regroupe les intération entre grande et petite version
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	int nEtape = 0;
	int nAction = 0;
	int nIndex = 0;
	int nPage = 1;
	
	//L'écran
	Ecran ecran = new Ecran(new Color(2, 63, 64));
	JPanel page[] = new JPanel[4];
	
	//Labels
	Label lblNumEtape = new Label(290, 26, "Etape N°xx", Color.WHITE);
	Label lblNumAction = new Label(290, 26, "Action N°xx", Color.WHITE);
	
	//Boutons d'action
	BoutonIcon btRetour = new BoutonIcon(80, 80, "photo", "Retour");
	BoutonIcon btValider = new BoutonIcon(80, 80, "bullet_accept", "Valider les modifications");
	BoutonIcon btSupprimer = new BoutonIcon(80, 80, "trash_empty", "Supprimer l'Action");
	BoutonIcon btGauche = new BoutonIcon(60, 60, "arrow_left", "Page précédente");
	BoutonIcon btDroit = new BoutonIcon(60, 60, "arrow_right", "Page suivante");
	BoutonIcon btZoomPlus = new BoutonIcon(50, 50, "zoom_in", "Aficher toutes les sortie");
	BoutonIcon btZoomMoin = new BoutonIcon(50, 50, "zoom_out", "Afficher moin");
	
	
	//Version grannde
	PanelSortie A2[] = new PanelSortie[6];
	PanelSortie A4[] = new PanelSortie[4];
	PanelSortie A5[] = new PanelSortie[8];
	PanelSortie A6[] = new PanelSortie[6];
	
	//Version petite
	PanelSortie A2mini[] = new PanelSortie[6];
	PanelSortie A4mini[] = new PanelSortie[4];
	PanelSortie A5mini[] = new PanelSortie[8];
	PanelSortie A6mini[] = new PanelSortie[6];
	
	
	public Ecran6_Sortie(){
		super();
		this.setSize(Principal.largeur, Principal.hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setOpaque(false);
		
		//Bouton Action
		ecran.ajout(btRetour, 5, 355);
		ecran.ajout(btValider, 485, 355);
		ecran.ajout(btSupprimer, 252, 355);
		ecran.ajout(btGauche, 5, 5);
		ecran.ajout(btDroit, 515, 5);
		ecran.ajout(btZoomPlus, 350, 439);
		ecran.ajout(btZoomMoin, 350, 439);
		btGauche.setVisible(false);
	
		//Page
		for(int i = 0 ; i < 4 ; i++){
			page[i] = new JPanel();
			page[i].setSize(580, 435);
			page[i].setLayout(null);
			page[i].setOpaque(false);
			page[i].setVisible(false);
			page[i].setLocation(30, 30);
			ecran.add(page[i]);
		}
		
		page[1].setVisible(true);
		
		//Labels
		ecran.ajout(lblNumEtape, 0, 20);
		ecran.ajout(lblNumAction, 285, 20);

		//Positions initialles
		int y = 60;
		int y2 = 60;
		int posX = -30;
		//sortie A2.
		for(int i = 0 ; i < 6 ; i++){
			//Création des panels
			A2[i] = new PanelSortie("A2." + i, false, posX);
			A2mini[i] = new PanelSortie("A2." + i, true, posX);
			//Position des panels
			A2[i].setLocation(0, y);
			A2mini[i].setLocation(0, y2);
			//Ajout des panels aux écrans
			page[1].add(A2[i]);
			page[0].add(A2mini[i]);
			//Ajout des listner des saisies
			A2[i].ajoutKeyListener(A2mini[i]);
			A2mini[i].ajoutKeyListener(A2[i]);
			//Ajout des listener des boutons
			A2[i].ajoutActionListener(A2mini[i]);
			A2mini[i].ajoutActionListener(A2[i]);
			//Position des panels suivants
			y = y + 50;
			y2 = y2 + 25;
			posX = posX + 13;
		}
		
		//Positions initialles
		y = 160;
		y2 = 110;
		//sortie A4.
		for(int i = 0 ; i < 4 ; i++){
			//Création des panels
			A4[i] = new PanelSortie("A4." + i, false, posX);
			A4mini[i] = new PanelSortie("A4." + i, true, posX);
			//Position des panels
			A4[i].setLocation(0, y);
			A4mini[i].setLocation(275, y2);
			//Ajout des panels aux écrans
			page[2].add(A4[i]);
			page[0].add(A4mini[i]);
			//Ajout des listner de saisie
			A4[i].ajoutKeyListener(A4mini[i]);
			A4mini[i].ajoutKeyListener(A4[i]);
			//Ajout des listener des boutons
			A4[i].ajoutActionListener(A4mini[i]);
			A4mini[i].ajoutActionListener(A4[i]);
			//Position des panels suivants
			y = y + 50;
			y2 = y2 + 25;
			posX = posX + 13;
		}
		
		//Positions initialles
		y = 60 + 50;
		y2 = 220;
		//sortie A5
		for(int i = 6 ; i < 8 ; i++){
			//Création des panels
			A5[i] = new PanelSortie("A5." + i, false, posX);
			A5mini[i] = new PanelSortie("A5." + i, true, posX);
			//Position des panels
			A5[i].setLocation(0, y);
			A5mini[i].setLocation(0, y2);
			//Ajout des panels aux écrans
			page[3].add(A5[i]);
			page[0].add(A5mini[i]);
			//Ajout des listner de saisie
			A5[i].ajoutKeyListener(A5mini[i]);
			A5mini[i].ajoutKeyListener(A5[i]);
			//Ajout des listener des boutons
			A5[i].ajoutActionListener(A5mini[i]);
			A5mini[i].ajoutActionListener(A5[i]);
			//Ajout TollTipText
			A5[i].ajoutInfoBulle("A5." + i);
			A5mini[i].ajoutInfoBulle("A5." + i);
			//Position des panels suivants
			y = y + 50;
			y2 = y2 + 25;
			posX = posX + 13;
		}
		
		//Positions initialles
		y = y + 50;
		y2 = y2 + 25;
		//sortie A6
		for(int i = 5 ; i < 6 ; i++){
			//Création des panels
			A6[i] = new PanelSortie("A6." + i, false, posX);
			A6mini[i] = new PanelSortie("A6." + i, true, posX);
			//Position des panels
			A6[i].setLocation(0, y);
			A6mini[i].setLocation(0, y2);
			//Ajout des panels aux écrans
			page[3].add(A6[i]);
			page[0].add(A6mini[i]);
			//Ajout des listner de saisie
			A6[i].ajoutKeyListener(A6mini[i]);
			A6mini[i].ajoutKeyListener(A6[i]);
			//Ajout des listener des boutons
			A6[i].ajoutActionListener(A6mini[i]);
			A6mini[i].ajoutActionListener(A6[i]);
			//Ajout TollTipText
			A6[i].ajoutInfoBulle("A6." + i);
			A6mini[i].ajoutInfoBulle("A6." + i);
			//Position des panels suivants
			y = y + 50;
			y2 = y2 + 25;
			posX = posX + 13;
		}

		this.add(ecran);
		
		btDroit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(nPage > 0 && nPage < 3){
					page[nPage].setVisible(false);
					page[nPage + 1].setVisible(true);
					nPage = nPage + 1;
					if(nPage == 3){
						btDroit.setVisible(false);
					}
					btGauche.setVisible(true);
				}
			}
		});
		
		btGauche.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(nPage > 1 && nPage < 4){
					page[nPage].setVisible(false);
					page[nPage - 1].setVisible(true);
					nPage = nPage - 1;
					if(nPage == 1){
						btGauche.setVisible(false);
					}
					btDroit.setVisible(true);
				}
			}
		});
		
		//Ajout des listener des boutons d'action
		actionRetour();
		actionSupprimer();
		actionValider();
		actionZoomPlus();
		actionZoomMoin();
		
		A2[0].ajoutActionListener(0, 1, 0, 2);
		A2[1].ajoutActionListener(0, 3, 1, 1);
		A2[2].ajoutActionListener(1, 2, 1, 3);
		A2[3].ajoutActionListener(2, 1, 2, 2);
		A2[4].ajoutActionListener(2, 3, 3, 1);
		A2[5].ajoutActionListener(3, 2, 3, 3);
		A4[0].ajoutActionListener(3, 1);
		A4[1].ajoutActionListener(3, 2);
		A4[2].ajoutActionListener(3, 3);
		A4[3].ajoutActionListener(3, 4);
		
		A2mini[0].ajoutActionListener(0, 1, 0, 2);
		A2mini[1].ajoutActionListener(0, 3, 1, 1);
		A2mini[2].ajoutActionListener(1, 2, 1, 3);
		A2mini[3].ajoutActionListener(2, 1, 2, 2);
		A2mini[4].ajoutActionListener(2, 3, 3, 1);
		A2mini[5].ajoutActionListener(3, 2, 3, 3);
		A4mini[0].ajoutActionListener(3, 1);
		A4mini[1].ajoutActionListener(3, 2);
		A4mini[2].ajoutActionListener(3, 3);
		A4mini[3].ajoutActionListener(3, 4);
	}
	
	private void actionRetour(){
		//Retour à l'écran graph7
		btRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.remove(Principal.sortie);
				Principal.graph7.majAffichage();
				Principal.graph7.setVisible(true);
				Principal.fond.repaint();
			}
		});
	}
	
	private void actionSupprimer(){
		//Suppression de l'action
		btSupprimer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Demande de confimation
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Voulez vous supprimer<br>l'action ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "trash_empty" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation suppression", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					//Suppression de l'action
					for(int i = 0; i < 22 ; i ++){
						Principal.programme.setValeur(nIndex + i, 0);
						
					}
					
					//Quite l'écran
					Principal.fond.remove(Principal.sortie);
					Principal.graph7.majAffichage();
					Principal.graph7.setVisible(true);
					Principal.fond.repaint();
				}
				
			}
			
		});
	}
	
	private void actionValider(){
		btValider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Demande de confimation
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Valider les modification<br>de l'action ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "bullet_accept" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation modification", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					
					//A2
					int poid = 0;
					int indexTxt = 800;
					for (int i = 0; i < 6; i++) {
						PoidBouton poidFonction = new PoidBouton();
						if (A2[i].getEtat() == true) {
							poid = poid + poidFonction.poidSortie(i);
						}
						Principal.programme.setString(indexTxt, A2[i].getTexte(), 20);
						indexTxt = indexTxt + 20;
					}
					//Ajoute la valeur
					Principal.programme.setValeur(nIndex + 5, poid);
					
					//A4
					poid = 0;
					indexTxt = indexTxt + 20;
					for (int i = 0; i < 4; i++) {
						PoidBouton poidFonction = new PoidBouton();
						if (A4[i].getEtat() == true) {
							poid = poid + poidFonction.poidSortie(i);
						}
						Principal.programme.setString(indexTxt, A4[i].getTexte(), 20);
						indexTxt = indexTxt + 20;
					}
					
					//A5
					Principal.programme.setValeur(nIndex + 9, poid);
					poid = 0;
					for (int i = 6; i < 8; i++) {
						PoidBouton poidFonction = new PoidBouton();
						if (A5[i].getEtat() == true) {
							poid = poid + poidFonction.poidSortie(i);
						}
						Principal.programme.setString(indexTxt, A5[i].getTexte(), 20);
						indexTxt = indexTxt + 20;
					}
					
					//6
					Principal.programme.setValeur(nIndex + 11, poid);
					poid = 0;
					for (int i = 5; i < 6; i++) {
						PoidBouton poidFonction = new PoidBouton();
						if (A6[i].getEtat() == true) {
							poid = poid + poidFonction.poidSortie(i);
						}
						Principal.programme.setString(indexTxt, A6[i].getTexte(), 20);
						indexTxt = indexTxt + 20;
					}
					//Ajoute la valeur
					Principal.programme.setValeur(nIndex + 13, poid);
					
					//Quite l'écran
					Principal.fond.remove(Principal.sortie);
					Principal.graph7.majAffichage();
					Principal.graph7.setVisible(true);
					Principal.fond.repaint();
				}
				
			}
			
		});
	}
		
	private void actionZoomPlus(){
		btZoomPlus.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				page[nPage].setVisible(false);
				btZoomPlus.setVisible(false);
				btZoomMoin.setVisible(true);
				btGauche.setVisible(false);
				btDroit.setVisible(false);
				page[0].setVisible(true);
				ecran.repaint();
			}
		});
	}
	
	private void actionZoomMoin(){
		btZoomMoin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				page[nPage].setVisible(true);
				btZoomPlus.setVisible(true);
				btZoomMoin.setVisible(false);
				page[0].setVisible(false);
				if(nPage > 0 & nPage < 5){
					btDroit.setVisible(true);
				}
				if(nPage > 1){
					btGauche.setVisible(true);
				}
				ecran.repaint();
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
		
		Principal.param.setModuPinPneuActif(etape);
		
		//Importation des données
		int indexTxt = 800;
		//Texte A2.
		for(int i = 0 ; i < 6 ; i++){
			A2[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			A2mini[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
			A2[i].setInactif();
			A2mini[i].setInactif();
			if(Principal.programme.getBit(nIndex, 5, i) == 1){
				A2[i].setActif();
				A2mini[i].setActif();
			}else{
				A2[i].setInactif();
				A2mini[i].setInactif();
			}
		}
		//Texte A4.
		indexTxt = indexTxt + 20;
		for(int i = 0 ; i < 4 ; i++){
			A4[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			A4mini[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
			A4mini[i].setInactif();
			A4[i].setInactif();
			if(Principal.programme.getBit(nIndex, 9, i) == 1){
				A4[i].setActif();
				A4mini[i].setActif();
			}else{
				A4[i].setInactif();
				A4mini[i].setInactif();
				
			}
		}
		//Texte A5.
		for(int i = 6 ; i < 8 ; i++){
			A5[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			A5mini[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
			A5[i].setInactif();
			A5mini[i].setInactif();
			if(Principal.programme.getBit(nIndex, 11, i) == 1){
				A5[i].setActif();
				A5mini[i].setActif();
			}else{
				A5[i].setInactif();
				A5mini[i].setInactif();
			}
		}
		for(int i = 5 ; i < 6 ; i++){
			A6[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			A6mini[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			A6[i].setInactif();
			A6mini[i].setInactif();
			if(Principal.programme.getBit(nIndex, 13, i) == 1){
				A6[i].setActif();
				A6mini[i].setActif();
			}else{
				A6[i].setInactif();
				A6mini[i].setInactif();
			}
		}
		
		

		//Initialisation affichage
		page[nPage].setVisible(false);
		nPage = 1;
		btGauche.setVisible(false);
		btDroit.setVisible(true);
		page[nPage].setVisible(true);
		btZoomMoin.setVisible(false);
		btZoomPlus.setVisible(true);
		btGauche.setVisible(false);
		btDroit.setVisible(true);
		page[0].setVisible(false);
		Principal.param.afficheMouleSortie();
	}
	
	
	
	

}
