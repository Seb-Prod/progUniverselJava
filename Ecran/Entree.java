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
import Elements.Saisie;
import Panel.PanelEntree;
import fr.ProgrammeUniversel.PoidBouton;
import fr.ProgrammeUniversel.Principal;

public class Entree extends JPanel{

	/**
	 * Page de programmation des tansition
	 * 
	 * 
	 * 
	 * @author sebastien Drillaud
	 * @creation 24 janvier 2018
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
	 * 
	 * @version 1.2 du 29 Janvier 2019
	 * Ajout du zoom pour tous afficher sur un écran
	 * 
	 * @verion 1.3 du 02 Février 2019
	 * Simplification du code en utilisant le @see PanelSortie 
	 * qui regroupe les intération entre grande et petite version
	 * Ajout de la validation des donnée et la suppression
	 */
	
	private static final long serialVersionUID = 1L;
	
	int nEtape;
	int nAction;
	int largeur = 645;
	int hauteur = 525;
	int nPage = 1;
	
	Ecran ecran = new Ecran(new Color(64, 160, 159));
	JPanel page[] = new JPanel[6];
	
	Label lblNumEtape = new Label(290, 26, "n°xx", Color.WHITE);
	
	BoutonIcon btRetour = new BoutonIcon(50, 50, "photo", "Retour");
	BoutonIcon btValider = new BoutonIcon(50, 50, "bullet_accept", "Valider les modifications");
	BoutonIcon btSupprimer = new BoutonIcon(50, 50, "trash_empty", "Effacer la transition");
	BoutonIcon btZoomPlus = new BoutonIcon(50, 50, "zoom_in", "Aficher toutes les entrées");
	BoutonIcon btZoomMoin = new BoutonIcon(50, 50, "zoom_out", "Afficher moin");
	BoutonIcon btGauche = new BoutonIcon(60, 60, "arrow_left", "Page précédente");
	BoutonIcon btDroit = new BoutonIcon(60, 60, "arrow_right", "Page suivante");
	
	
	PanelEntree E2[] = new PanelEntree[8];
	PanelEntree E3[] = new PanelEntree[8];
	PanelEntree E4[] = new PanelEntree[8];
	PanelEntree E6[] = new PanelEntree[8];
	PanelEntree E7[] = new PanelEntree[8];
	
	PanelEntree E2mini[] = new PanelEntree[8];
	PanelEntree E3mini[] = new PanelEntree[8];
	PanelEntree E4mini[] = new PanelEntree[8];
	PanelEntree E6mini[] = new PanelEntree[8];
	PanelEntree E7mini[] = new PanelEntree[8];

	//Zone de saisie
	Saisie saisie1 = new Saisie("double", 999, 24);
	Saisie saisie2 = new Saisie("double", 999, 24);
	

	
	public Entree(){
		super();
		this.setSize(largeur, hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setOpaque(false);
		
		//Bouton Action
		ecran.ajout(btRetour, 430, 439);
		ecran.ajout(btValider, 530, 439);
		ecran.ajout(btSupprimer, 480, 439);
		ecran.ajout(btZoomPlus, 350, 439);
		ecran.ajout(btZoomMoin, 350, 439);
		
		ecran.ajout(btGauche, 5, 5);
		ecran.ajout(btDroit, 515, 5);
		btGauche.setVisible(false);
		
	
		//Pages
		for(int i = 0 ; i < 6 ; i++){
			page[i] = new JPanel();
			page[i].setSize(580, 435);
			page[i].setLayout(null);
			page[i].setOpaque(false);
			page[i].setVisible(false);
			page[i].setLocation(30, 30);
			ecran.add(page[i]);
		}
		
		page[1].setVisible(true);
		
		//Label
		ecran.ajout(lblNumEtape, 0, 30);
		Label lbl1 = new Label(290, 26, "Transition", Color.WHITE);
		Label lbl2 = new Label(" Tempo :     s", Color.WHITE, 22);
		Label lbl3 = new Label("Defaut :     s", Color.WHITE, 22);
		
		ecran.ajout(lbl1, 0, 5);
		ecran.ajout(lbl2, 320, 5);
		ecran.ajout(lbl3, 320, 35);
		
		//Zones de saisie
		saisie1.setSize(70, 30);
		ecran.ajout(saisie1, 420, 5);
		saisie2.setSize(70, 30);
		ecran.ajout(saisie2, 420, 35);
		
		//Entree E2.
		
		int y = 70;
		int y2 = 70;
		int posX = -30;
		for(int i = 0 ; i < 8 ; i++){
			//E2
			//Création des panels
			E2[i] = new PanelEntree("E2." + i, false, posX);
			E2mini[i] = new PanelEntree("E2." + i, true, posX);
			//Position des panels
			E2[i].setLocation(0, y);
			E2mini[i].setLocation(0, y2);
			//Ajout des panels aux écrans
			page[1].add(E2[i]);
			page[0].add(E2mini[i]);
			//Ajout des listner de saisie
			E2[i].ajoutKeyListener(E2mini[i]);
			E2mini[i].ajoutKeyListener(E2[i]);
			//Ajout des listener des boutons
			E2[i].ajoutActionListener_bt0(E2mini[i]);
			E2[i].ajoutActionListener_bt1(E2mini[i]);
			E2mini[i].ajoutActionListener_bt0(E2[i]);
			E2mini[i].ajoutActionListener_bt1(E2[i]);
			
			//E3
			//Création des panels
			E3[i] = new PanelEntree("E3." + i, false, (posX + (8 * 13)));
			E3mini[i] = new PanelEntree("E3." + i, true, (posX + (8 * 13)));
			//Position des panels
			E3[i].setLocation(0, y);
			E3mini[i].setLocation(0, y2 + 180);
			//Ajout des panels aux écrans
			page[2].add(E3[i]);
			page[0].add(E3mini[i]);
			//Ajout des listner de saisie
			E3[i].ajoutKeyListener(E3mini[i]);
			E3mini[i].ajoutKeyListener(E3[i]);
			//Ajout des listener des boutons
			E3[i].ajoutActionListener_bt0(E3mini[i]);
			E3[i].ajoutActionListener_bt1(E3mini[i]);
			E3mini[i].ajoutActionListener_bt0(E3[i]);
			E3mini[i].ajoutActionListener_bt1(E3[i]);		

			//E4
			//Création des panels
			E4[i] = new PanelEntree("E4." + i, false, (posX + (16 * 13)));
			E4mini[i] = new PanelEntree("E4." + i, true, (posX + (16 * 13)));
			//Position des panels
			E4[i].setLocation(0, y);
			E4mini[i].setLocation(305, y2);
			//Ajout des panels aux écrans
			page[3].add(E4[i]);
			page[0].add(E4mini[i]);
			//Ajout des listner de saisie
			E4[i].ajoutKeyListener(E4mini[i]);
			E4mini[i].ajoutKeyListener(E4[i]);
			//Ajout des listener des boutons
			E4[i].ajoutActionListener_bt0(E4mini[i]);
			E4[i].ajoutActionListener_bt1(E4mini[i]);
			E4mini[i].ajoutActionListener_bt0(E4[i]);
			E4mini[i].ajoutActionListener_bt1(E4[i]);

			y = y + 45;
			y2 = y2 + 22;
			posX = posX + 13;
		}
		
		for(int i = 4 ; i < 8 ; i++){
			E4[i].ajoutInfoBulle("E4." + i);
			E4mini[i].ajoutInfoBulle("E4." + i);
		}
		
		y = 70;
		y2 = 70;
		for(int i = 0 ; i < 4 ; i++){
			//E6.0 à E6.3
			//Création des panels
			E6[i] = new PanelEntree("E6." + i, false, (posX + (16 * 13)));
			E6mini[i] = new PanelEntree("E6." + i, true, (posX + (16 * 13)));
			//Position des panels
			E6[i].setLocation(0, y);
			E6mini[i].setLocation(305, y2 + 180);
			//Ajout des panels aux écrans
			page[4].add(E6[i]);
			page[0].add(E6mini[i]);
			//Ajout des listner de saisie
			E6[i].ajoutKeyListener(E6mini[i]);
			E6mini[i].ajoutKeyListener(E6[i]);
			//Ajout des listener des boutons
			E6[i].ajoutActionListener_bt0(E6mini[i]);
			E6[i].ajoutActionListener_bt1(E6mini[i]);
			E6mini[i].ajoutActionListener_bt0(E6[i]);
			E6mini[i].ajoutActionListener_bt1(E6[i]);
			E6[i].ajoutInfoBulle("E6." + i);
			E6mini[i].ajoutInfoBulle("E6." + i);
			
			y = y + 45;
			y2 = y2 + 22;
			posX = posX + 13;
		}
		y = y + 135;
		//E6.7
		//Création des panels
		E6[7] = new PanelEntree("E6." + 7, false, (posX + (16 * 13)));
		E6mini[7] = new PanelEntree("E6." + 7, true, (posX + (16 * 13)));
		//Position des panels
		E6[7].setLocation(0, y);
		E6mini[7].setLocation(305, y2 + 180);
		//Ajout des panels aux écrans
		page[4].add(E6[7]);
		page[0].add(E6mini[7]);
		//Ajout des listner de saisie
		E6[7].ajoutKeyListener(E6mini[7]);
		E6mini[7].ajoutKeyListener(E6[7]);
		//Ajout des listener des boutons
		E6[7].ajoutActionListener_bt0(E6mini[7]);
		E6[7].ajoutActionListener_bt1(E6mini[7]);
		E6mini[7].ajoutActionListener_bt0(E6[7]);
		E6mini[7].ajoutActionListener_bt1(E6[7]);
		E6[7].ajoutInfoBulle("E6." + 7);
		E6mini[7].ajoutInfoBulle("E6." + 7);
		y = y + 45;
		y2 = y2 + 22;
		posX = posX + 13;
		
		y = 160;
		y2 = y2 + 22;
		for(int i = 2 ; i < 4 ; i++){
			//E6.0 à E6.3
			//Création des panels
			E7[i] = new PanelEntree("E7." + i, false, (posX + (16 * 13)));
			E7mini[i] = new PanelEntree("E7." + i, true, (posX + (16 * 13)));
			//Position des panels
			E7[i].setLocation(0, y);
			E7mini[i].setLocation(305, y2 + 180);
			//Ajout des panels aux écrans
			page[5].add(E7[i]);
			page[0].add(E7mini[i]);
			//Ajout des listner de saisie
			E7[i].ajoutKeyListener(E7mini[i]);
			E7mini[i].ajoutKeyListener(E7[i]);
			//Ajout des listener des boutons
			E7[i].ajoutActionListener_bt0(E7mini[i]);
			E7[i].ajoutActionListener_bt1(E7mini[i]);
			E7mini[i].ajoutActionListener_bt0(E7[i]);
			E7mini[i].ajoutActionListener_bt1(E7[i]);
			E7[i].ajoutInfoBulle("E7." + i);
			E7mini[i].ajoutInfoBulle("E7." + i);
			y = y + 45;
			y2 = y2 + 22;
			posX = posX + 13;
		}

		this.add(ecran);
		
		btDroit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(nPage > 0 && nPage < 5){
					page[nPage].setVisible(false);
					page[nPage + 1].setVisible(true);
					nPage = nPage + 1;
					if(nPage == 5){
						btDroit.setVisible(false);
					}
					btGauche.setVisible(true);
				}
				
			}
		});
		
		btGauche.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(nPage > 1 && nPage < 6){
					page[nPage].setVisible(false);
					page[nPage - 1].setVisible(true);
					nPage = nPage - 1;
					if(nPage == 1){
						btGauche.setVisible(false);
					}
					btDroit.setVisible(true);
					
				}
				if(nPage == 1){
					
				}
			}
		});

		actionRetour();
		actionZoomPlus();
		actionZoomMoin();
		actionValider();
		actionSupprimer();
		
		
		for(int i = 0 ; i < 8 ; i++){
			E2[i].ajoutActionListener_bt0(1, i + 1);
			E2[i].ajoutActionListener_bt1(1, i + 1);
			E2mini[i].ajoutActionListener_bt0(1, i + 1);
			E2mini[i].ajoutActionListener_bt1(1, i + 1);
		}
		for(int i = 0 ; i < 4 ; i++){
			E3[i].ajoutActionListener_bt0(1, i + 9);
			E3[i].ajoutActionListener_bt1(1, i + 9);
			E3mini[i].ajoutActionListener_bt0(1, i + 9);
			E3mini[i].ajoutActionListener_bt1(1, i + 9);
		}
		for(int i = 4 ; i < 8 ; i++){
			E3[i].ajoutActionListener_bt0(2, i + 5);
			E3[i].ajoutActionListener_bt1(2, i + 5);
			E3mini[i].ajoutActionListener_bt0(2, i + 5);
			E3mini[i].ajoutActionListener_bt1(2, i + 5);
		}
		for(int i = 0 ; i < 4 ; i++){
			E4[i].ajoutActionListener_bt0(3, i + 5);
			E4[i].ajoutActionListener_bt1(3, i + 5);
			E4mini[i].ajoutActionListener_bt0(3, i + 5);
			E4mini[i].ajoutActionListener_bt1(3, i + 5);
		}
	}
	

	private void actionSupprimer(){
		//Suppression de l'action
		btSupprimer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Demande de confimation
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Voulez vous effacer<br>la transition ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "trash_empty" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation suppression", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					//Suppression de l'action
					PoidBouton index = new PoidBouton();
					int nIndex = index.getIndexTransition(nEtape);
					for(int i = 0; i < 18 ; i ++){
						Principal.programme.setValeur(nIndex + i, 0);
						
					}
					
					//Quite l'écran
					Principal.fond.remove(Principal.entree);
					Principal.graph7.majAffichage();
					Principal.graph7.setVisible(true);
					Principal.fond.repaint();
				}
				
			}
			
		});
	}
	
	private void actionRetour(){
		//Retour à l'écran graph7
		btRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.remove(Principal.entree);
				Principal.graph7.setVisible(true);
				Principal.graph7.majAffichage();
				Principal.fond.repaint();
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
	
	private void actionValider(){
		btValider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Demande de confimation
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Valider les modification<br>de la transition ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "bullet_accept" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation modification", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					PoidBouton index = new PoidBouton();
					PoidBouton poidFonction = new PoidBouton();
					int nIndex = index.getIndexTransition(nEtape);
					int indexTxt = 0;
					int poid_0 = 0;
					int poid_1 = 0;
					
					//E2
					for(int i = 0 ; i < 8 ; i++){
						Principal.programme.setString(indexTxt, E2[i].getTexte(), 20);
						indexTxt = indexTxt + 20;
						
						if (E2[i].getEtat_bt1() == true) {
							poid_1 = poid_1 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 0, poid_1);
						if (E2[i].getEtat_bt0() == true) {
							poid_0 = poid_0 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 6, poid_0);
					}
					
					poid_0 = 0;
					poid_1 = 0;
					//E3
					for(int i = 0 ; i < 8 ; i++){
						Principal.programme.setString(indexTxt, E3[i].getTexte(), 20);
						indexTxt = indexTxt + 20;
						
						if (E3[i].getEtat_bt1() == true) {
							poid_1 = poid_1 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 1, poid_1);
						if (E3[i].getEtat_bt0() == true) {
							poid_0 = poid_0 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 7, poid_0);
					}
					
					poid_0 = 0;
					poid_1 = 0;
					//E4
					for(int i = 0 ; i < 8 ; i++){
						Principal.programme.setString(indexTxt, E4[i].getTexte(), 20);
						indexTxt = indexTxt + 20;
						
						if (E4[i].getEtat_bt1() == true) {
							poid_1 = poid_1 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 2, poid_1);
						if (E4[i].getEtat_bt0() == true) {
							poid_0 = poid_0 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 8, poid_0);
					}
					
					poid_0 = 0;
					poid_1 = 0;
					//E6.0
					for(int i = 0 ; i < 4 ; i++){
						Principal.programme.setString(indexTxt, E6[i].getTexte(), 20);
						indexTxt = indexTxt + 20;
						
						if (E6[i].getEtat_bt1() == true) {
							poid_1 = poid_1 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 4, poid_1);
						if (E6[i].getEtat_bt0() == true) {
							poid_0 = poid_0 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 10, poid_0);
					}
					
					indexTxt = indexTxt + 60;
					Principal.programme.setString(indexTxt, E6[7].getTexte(), 20);
					indexTxt = indexTxt + 20;
					
					if (E6[7].getEtat_bt1() == true) {
						poid_1 = poid_1 + poidFonction.poidSortie(7);
					}
					Principal.programme.setValeur(nIndex + 4, poid_1);
					if (E6[7].getEtat_bt0() == true) {
						poid_0 = poid_0 + poidFonction.poidSortie(7);
					}
					Principal.programme.setValeur(nIndex + 10, poid_0);
					
					poid_0 = 0;
					poid_1 = 0;
					indexTxt = 680;
					//E7
					for(int i = 2 ; i < 4 ; i++){
						Principal.programme.setString(indexTxt, E7[i].getTexte(), 20);
						indexTxt = indexTxt + 20;
						
						if (E7[i].getEtat_bt1() == true) {
							poid_1 = poid_1 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 5, poid_1);
						if (E7[i].getEtat_bt0() == true) {
							poid_0 = poid_0 + poidFonction.poidSortie(i);
						}
						Principal.programme.setValeur(nIndex + 11, poid_0);
					}
					
					Principal.programme.setValeurDouble(nIndex, 12, saisie1.getText());
					Principal.programme.setValeurDouble(nIndex, 14, saisie2.getText());
					
					//Quite l'écran
					Principal.fond.remove(Principal.entree);
					Principal.graph7.majAffichage();
					Principal.graph7.setVisible(true);
					Principal.fond.repaint();
				}
				
			}
			
		});
	}

	public void setValeur(int etape){
		String e = etape + "";
		if(etape < 10){
			e = "0" + etape;
		}
		nEtape = etape;
		lblNumEtape.setText("n°" + e);
		PoidBouton index = new PoidBouton();
		int nIndex = index.getIndexTransition(nEtape);
		
		Principal.param.setModuPinPneuActif(etape);
		
		//Importation des données
		
		saisie1.setText(Principal.programme.getValeurDouble(nIndex, 12) + "");
		saisie2.setText(Principal.programme.getValeurDouble(nIndex, 14) + "");
		
		int indexTxt = 0;
		
		//E2.
		for(int i = 0 ; i < 8 ; i++){
			//Textes
			E2[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			E2mini[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
			//Etat des boutons
			if(Principal.programme.getBit(nIndex, 0, i) == 1){
				E2[i].setActif_bt1();
				E2mini[i].setActif_bt1();
			}else{
				E2[i].setInactif_bt1();
				E2mini[i].setInactif_bt1();
			}
			if(Principal.programme.getBit(nIndex, 6, i) == 1){
				E2[i].setActif_bt0();
				E2mini[i].setActif_bt0();
			}else{
				E2[i].setInactif_bt0();
				E2mini[i].setInactif_bt0();
			}
		}
		
		//E3.
		for(int i = 0 ; i < 8 ; i++){
			//Textes
			E3[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			E3mini[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
			//Etat des boutons
			if(Principal.programme.getBit(nIndex, 1, i) == 1){
				E3[i].setActif_bt1();
				E3mini[i].setActif_bt1();
			}else{
				E3[i].setInactif_bt1();
				E3mini[i].setInactif_bt1();
			}
			if(Principal.programme.getBit(nIndex, 7, i) == 1){
				E3[i].setActif_bt0();
				E3mini[i].setActif_bt0();
			}else{
				E3[i].setInactif_bt0();
				E3mini[i].setInactif_bt0();
			}
		}
		
		//E4.
		for(int i = 0 ; i < 8 ; i++){
			//Textes
			E4[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			E4mini[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
			//Etat des boutons
			if(Principal.programme.getBit(nIndex, 2, i) == 1){
				E4[i].setActif_bt1();
				E4mini[i].setActif_bt1();
			}else{
				E4[i].setInactif_bt1();
				E4mini[i].setInactif_bt1();
			}
			if(Principal.programme.getBit(nIndex, 8, i) == 1){
				E4[i].setActif_bt0();
				E4mini[i].setActif_bt0();
			}else{
				E4[i].setInactif_bt0();
				E4mini[i].setInactif_bt0();
			}
		}
		
		//E6.0 à E6.3
		for(int i = 0 ; i < 4 ; i++){
			E6[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			E6mini[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
			//Etat des boutons
			if(Principal.programme.getBit(nIndex, 4, i) == 1){
				E6[i].setActif_bt1();
				E6mini[i].setActif_bt1();
			}else{
				E6[i].setInactif_bt1();
				E6mini[i].setInactif_bt1();
			}
			if(Principal.programme.getBit(nIndex, 10, i) == 1){
				E6[i].setActif_bt0();
				E6mini[i].setActif_bt0();
			}else{
				E6[i].setInactif_bt0();
				E6mini[i].setInactif_bt0();
			}
		}
		
		indexTxt = indexTxt + 60;
		
		//Texte E6.7
		E6[7].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
		E6mini[7].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
		//Etat des boutons
		if(Principal.programme.getBit(nIndex, 4, 7) == 1){
			E6[7].setActif_bt1();
			E6mini[7].setActif_bt1();
		}else{
			E6[7].setInactif_bt1();
			E6mini[7].setInactif_bt1();
		}
		if(Principal.programme.getBit(nIndex, 10, 7) == 1){
			E6[7].setActif_bt0();
			E6mini[7].setActif_bt0();
		}else{
			E6[7].setInactif_bt0();
			E6mini[7].setInactif_bt0();
		}
		
		//E7.
		indexTxt = 680;
		for(int i = 2 ; i < 4 ; i++){
			//Texte
			E7[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			E7mini[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
			//Etat des boutons
			if(Principal.programme.getBit(nIndex, 5, i) == 1){
				E7[i].setActif_bt1();
				E7mini[i].setActif_bt1();
			}else{
				E7[i].setInactif_bt1();
				E7mini[i].setInactif_bt1();
			}
			if(Principal.programme.getBit(nIndex, 11, i) == 1){
				E7[i].setActif_bt0();
				E7mini[i].setActif_bt0();
			}else{
				E7[i].setInactif_bt0();
				E7mini[i].setInactif_bt0();
			}
		}
		
		
		//Initialisation affichage
		page[nPage].setVisible(false);
		page[0].setVisible(false);
		btZoomPlus.setVisible(true);
		nPage = 1;
		btZoomMoin.setVisible(false);
		btGauche.setVisible(false);
		btDroit.setVisible(true);
		page[nPage].setVisible(true);
		Principal.param.afficheMouleSortie();
	}
	
	

}
