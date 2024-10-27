package Ecran;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Elements.Bouton;
import Elements.BoutonIcon;
import Elements.Ecran;
import Elements.Label;
import Elements.MonJLabel;
import Elements.Saisie;
import fr.ProgrammeUniversel.Principal;

public class Ecran5_RFID extends JPanel{

	/**
	 * Page de programmation de l'action RFID
	 * 
	 * Type d'accès RFID = index + 3 (0 = RAZ ; 1 = Ecriture ; 2 = Lecture)
	 * N° de tête utilisé = index + 21 (0 = tête n°1 ; 1 = tête n°2)
	 * N° de Station présédente = index + 4 à index + 6
	 * N° de Station actuel = index + 8 à index + 10
	 * Réf AL = index + 12 à index + 18
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
	 * @version 1.1 du 27 Janvier 2019
	 * Ajout du chargement des données
	 * Ajout de la suppression des donnée
	 * Ajout des actionListener des Boutons
	 * Ajout de la validation des donnée
	 * Ajout boite de dialogue de confirmation pour la suppression et la modification des données
	 *
	 * @verion 1.2 du 7 Février 2019
	 * Ajouter des informationde codage
	 *	
	 * @TODO cacher les bouton caméra 1 et 2 si pas utilisé
	 */
	
	private static final long serialVersionUID = 1L;
	
	int nEtape;
	int nAction;
	int nIndex = 0;
	
	//L'écran
	Ecran ecran = new Ecran(new Color(2, 63, 64));
	
	//Labels
	Label lblNumEtape = new Label(290, 26, "Etape N°xx", Color.WHITE);
	Label lblNumAction = new Label(290, 26, "Action N°xx", Color.WHITE);
	Label lbl1 = new Label("N° de station précédente :", Color.WHITE, 24);
	Label lbl2 = new Label("N° de station actuelle :", Color.WHITE, 24);
	Label lbl3 = new Label("N° de produit :", Color.WHITE, 24);
	
	//Boutons d'action
	BoutonIcon btRetour = new BoutonIcon(80, 80, "photo", "Retour");
	BoutonIcon btValider = new BoutonIcon(80, 80, "bullet_accept", "Valider les modifications");
	BoutonIcon btSupprimer = new BoutonIcon(80, 80, "trash_empty", "Supprimer l'Action");
	
	//Zones de saisie
	Saisie saisie1= new Saisie("string", 3, 24);
	Saisie saisie2 = new Saisie("string", 3, 24);
	Saisie saisie3 = new Saisie("string", 8, 24);
	
	//Boutons
	Bouton bt[] = new Bouton[5];

	
	public Ecran5_RFID(){
		super();
		this.setSize(Principal.largeur, Principal.hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setOpaque(false);
		
		//Bouton Action
		ecran.ajout(btRetour, 5, 355);
		ecran.ajout(btValider, 485, 355);
		ecran.ajout(btSupprimer, 252, 355);
		
		//Labels
		Label lblTitre = new Label(580, 26, "Type d'accès RFID", Color.WHITE);
		Label lbl4 = new Label("N° de tête:", Color.WHITE, 24);

		ecran.ajout(lblNumEtape, 0, 20);
		ecran.ajout(lblNumAction, 290, 20);
		ecran.ajout(lblTitre, 0, 55);
		ecran.ajout(lbl1, 5, 150);
		ecran.ajout(lbl2, 5, 196);
		ecran.ajout(lbl3, 5, 242);
		ecran.ajout(lbl4, 5, 288);
		
		//Zones de saisie
		saisie1.setSize(80, 36);
		ecran.ajout(saisie1, 400, 146);
		saisie2.setSize(80, 36);
		ecran.ajout(saisie2, 400, 192);
		saisie3.setSize(150, 36);
		ecran.ajout(saisie3, 400, 238);
		
		//Boutons
		bt[0] = new Bouton("RAZ", 150, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[1] = new Bouton("Ecriture", 150, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[2] = new Bouton("Lecture", 150, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[3] = new Bouton("1", 40, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[4] = new Bouton("2", 40, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);

		
		ecran.ajout(bt[0], 45, 94);
		ecran.ajout(bt[2], 215, 94);
		ecran.ajout(bt[1], 385, 94);
		ecran.ajout(bt[3], 400, 280);
		ecran.ajout(bt[4], 450, 280);
		
		//Ajoute les éléments à l'écran
		this.add(ecran);

		//Ajout des listener des boutons d'action
		actionRetour();
		actionSupprimer();
		actionValider();
		
		//Listener du bouton Raz
		bt[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[0].getEtat() == false){
					bt[0].setActif();
					bt[1].setInactif();
					bt[2].setInactif();
					lbl1.setVisible(false);
					lbl2.setVisible(false);
					lbl3.setVisible(false);
					saisie1.setVisible(false);
					saisie2.setVisible(false);
					saisie3.setVisible(false);
					ecran.repaint();
				}
				
			}	
		});
		//Listener du bouton Ecriture
		bt[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[1].getEtat() == false){
					bt[1].setActif();
					bt[0].setInactif();
					bt[2].setInactif();
					lbl1.setVisible(false);
					lbl2.setVisible(true);
					lbl3.setVisible(true);
					saisie1.setVisible(false);
					saisie2.setVisible(true);
					saisie3.setVisible(true);
					ecran.repaint();
				}
			}	
		});
		//Listener du bouton Ecriture
		bt[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[2].getEtat() == false){
					bt[2].setActif();
					bt[1].setInactif();
					bt[0].setInactif();
					lbl1.setVisible(true);
					lbl2.setVisible(false);
					lbl3.setVisible(true);
					saisie1.setVisible(true);
					saisie2.setVisible(false);
					saisie3.setVisible(true);
					ecran.repaint();
				}
			}	
		});
		//Listener du bouton tête n°1
		bt[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				bt[3].setActif();
				bt[4].setInactif();
				ecran.repaint();
			}
			
		});
		//Listener du bouton tête n°2
		bt[4].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				bt[4].setActif();
				bt[3].setInactif();
				ecran.repaint();
			}
			
		});
		//Listener pour l'info codage
		actionListenerInfo(saisie1, 4, 3, "Station précédente (3 char)");
		actionListenerInfo(saisie2, 8, 3, "Station actuel (3 char)");
		actionListenerInfo(saisie3, 12, 8, "N° de produit (8 char)");
		actionListenerInfo(bt[0], 3, 1, "RAZ (=0)");
		actionListenerInfo(bt[1], 3, 1, "Ecriture (=1)");
		actionListenerInfo(bt[2], 3, 1, "Lecture (=2)");
		actionListenerInfo(bt[3], 21, 1, "Tête N°1 (=0)");
		actionListenerInfo(bt[4], 21, 1, "Tête n°2 (=1)");
	}
	



	
	private void actionListenerInfo(Object o,final int index, final int longeur, final String t){
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
				Principal.param.razCouleurInfo();
				Principal.param.changeCouleur(index, longeur, t);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Principal.param.razCouleurInfo();
				
			}
			
		});
	}
	
	private void actionRetour(){
		//Retour à l'écran graph7
		btRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.remove(Principal.rfid);
				Principal.graph7.majAffichage();
				Principal.graph7.setVisible(true);
				Principal.param.afficheParamProg();
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
						"<html>Voulez vous supprimer<br>l'action RFID ?</html>", true, 
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
					Principal.fond.remove(Principal.rfid);
					Principal.graph7.majAffichage();
					Principal.graph7.setVisible(true);
					Principal.param.afficheParamProg();
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
						"<html>Valider les modification<br>de l'action RFID ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "bullet_accept" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation modification", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					//Récupère les boutons activés
					int type = 0;
					for (int i = 0; i < 3; i++) {
						if (bt[i].getEtat() == true) {
							type = type + i;
						}
					}
					int n = 0;
					for (int i = 3; i < 5; i++) {
						if (bt[i].getEtat() == true) {
							n = n+ i - 3;
						}
					}
					//Ajoute la valeur
					Principal.programme.setValeur(nIndex + 3, type);
					Principal.programme.setValeur(nIndex + 21, n);
					Principal.programme.setString(nIndex + 4, saisie1.getText(), 3);
					Principal.programme.setString(nIndex + 8, saisie2.getText(), 3);
					Principal.programme.setString(nIndex + 12, saisie3.getText(), 8);
					
					//Quite l'écran
					Principal.fond.remove(Principal.rfid);
					Principal.graph7.majAffichage();
					Principal.graph7.setVisible(true);
					Principal.param.afficheParamProg();
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
		
		//Affichage des donnée dans ma console
		//ecran.setCode(Principal.programme.GetIndexTransition(nEtape) + 30 + (22 * nAction) - 22);
		
		//Imporation des données
		razBouton();
		
		bt[Principal.programme.getValeur(nIndex + 3)].setActif();
		bt[Principal.programme.getValeur(nIndex + 21) + 3].setActif();
		saisie1.setText(Principal.programme.getString(nIndex + 4, 3));
		saisie2.setText(Principal.programme.getString(nIndex + 8, 3));
		saisie3.setText(Principal.programme.getString(nIndex + 12, 8));
		
		initAffichage();
		
		Principal.param.afficheInfoCodeAction("Type d'accès RFID");
		Principal.param.setDataAction(nIndex);
	}
	
	private void razBouton(){
		for(int i = 0 ; i < 5 ; i++){
			bt[i].setInactif();
		}
		saisie1.setVisible(false);
		saisie2.setVisible(false);
		saisie3.setVisible(false);
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		
	}
	
	private void initAffichage(){
		if(bt[1].getEtat() == true){
			lbl2.setVisible(true);
			lbl3.setVisible(true);
			saisie2.setVisible(true);
			saisie3.setVisible(true);
		}
		if(bt[2].getEtat() == true){
			lbl1.setVisible(true);
			lbl3.setVisible(true);
			saisie1.setVisible(true);
			saisie3.setVisible(true);
		}
	}
	
	

}
