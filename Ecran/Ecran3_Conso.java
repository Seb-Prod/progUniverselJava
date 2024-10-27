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

public class Ecran3_Conso extends JPanel{

	/**
	 * Page de programmation de l'action contôle consomation
	 * 
	 * Type de conso = index + 3 (0 = Aucune ; 1 = Recul ; 2 = Lantern ; 3 = Stop ; 4 = Cligno ; 5 = Autre)
	 * Consomation Mini. (int) = (index + 4) & (index + 5)
	 * Consomation Maxi. (int) = (index + 6) & (index + 7)
	 * Temps de mesure (double) = (index + 8) & (index + 9)
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
	 */
	
	private static final long serialVersionUID = 1L;
	
	int nEtape = 0;
	int nAction = 0;
	int nIndex = 0;
	
	//L'écran
	Ecran ecran = new Ecran(new Color(2, 63, 64));
	
	//Labels
	Label lblNumEtape = new Label(290, 24, "Etape N°xx", Color.WHITE);
	Label lblNumAction = new Label(290, 24, "Action N°xx", Color.WHITE);
	
	//Boutons d'action
	BoutonIcon btRetour = new BoutonIcon(80, 80, "photo", "Retour");
	BoutonIcon btValider = new BoutonIcon(80, 80, "bullet_accept", "Valider les modifications");
	BoutonIcon btSupprimer = new BoutonIcon(80, 80, "trash_empty", "Supprimer l'Action");
	
	//Zones de saisie
	Saisie saisie1 = new Saisie("int", 2000, 24);
	Saisie saisie2 = new Saisie("int", 2000, 24);
	Saisie saisie3 = new Saisie("int", 2000, 24);
	Saisie saisie4 = new Saisie("double", 999, 24);
	
	//Boutons
	Bouton bt[] = new Bouton[6];
	
	
	public Ecran3_Conso(){
		super();
		this.setSize(Principal.largeur, Principal.hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setOpaque(false);
		
		//Boutons Action
		ecran.ajout(btRetour, 5, 355);
		ecran.ajout(btValider, 485, 355);
		ecran.ajout(btSupprimer, 252, 355);
		
		//Label
		Label lblTitre = new Label("Mesure consommation", Color.WHITE, 24);
		Label lbl1 = new Label("Conso mini.", new Color(121, 248, 248), 24);
		Label lbl2 = new Label("Conso maxi.", Color.RED, 24);
		Label lbl3 = new Label("         mA <          mA <          mA", Color.WHITE, 24);
		Label lbl4 = new Label("Durée de mesure :     Sec.", Color.WHITE, 24);
		
		ecran.ajout(lblNumEtape, 0, 20);
		ecran.ajout(lblNumAction, 290, 20);
		ecran.ajout(lblTitre, 35, 80);
		ecran.ajout(lbl1, 5, 200);
		ecran.ajout(lbl2, 405, 200);
		ecran.ajout(lbl3, 10, 235);
		ecran.ajout(lbl4, 5, 285);
		
		//Zone de saisie
		saisie1.setSize(110, 36);
		ecran.ajout(saisie1, 10, 230);
		saisie2.setSize(110, 36);
		saisie2.setEnabled(false);
		ecran.ajout(saisie2, 210, 230);
		saisie3.setSize(110, 36);
		ecran.ajout(saisie3, 415, 230);
		saisie4.setSize(60, 36);
		ecran.ajout(saisie4, 245, 280);
		saisie2.setEditable(false);
		
		//Bouton
		bt[0] = new Bouton("Aucune", 114, 41, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt[1] = new Bouton("Recul", 114, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[2] = new Bouton("Lantern", 114, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[3] = new Bouton("Stop", 114, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[4] = new Bouton("Cligno", 114, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[5] = new Bouton("Autre", 114, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		
		ecran.ajout(bt[0], 346, 74);
		ecran.ajout(bt[1], 5, 154);
		ecran.ajout(bt[2], 119, 154);
		ecran.ajout(bt[3], 233, 154);
		ecran.ajout(bt[4], 347, 154);
		ecran.ajout(bt[5], 461, 154);
		
		this.add(ecran);

		
		//Ajout des listener des boutons d'action
		actionRetour();
		actionSupprimer();
		actionValider();
		ajoutListener();
		//Listener pour l'info codage
		actionListenerInfo(saisie1, 4, 2, "> Conso. Mini. <", "0 mA", "2000 mA");
		actionListenerInfo(saisie3, 6, 2, "> Conso. Maxi. <", "0 mA", "2000 mA");
		actionListenerInfo(saisie4, 8, 2, "> Duréé de mesure <", "0,0 sec", "9.9 sec");
		actionListenerInfo(bt[0], 3, 1, "Aucune (=0)");
		actionListenerInfo(bt[1], 3, 1, "Recul (=1)");
		actionListenerInfo(bt[2], 3, 1, "Lanterne (=2)");
		actionListenerInfo(bt[3], 3, 1, "Stop (=3)");
		actionListenerInfo(bt[4], 3, 1, "Clignotant (=4)");
		actionListenerInfo(bt[5], 3, 1, "Autre (=5)");
	}
	


	private void actionListenerInfo(Object o,final int index, final int longeur, final String t, final String min, final String max){
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
				Principal.param.changeCouleur(index, longeur, t, min, max);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Principal.param.razCouleurInfo();
				
			}
			
		});
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
	
	private void ajoutListener(){
		for(int i = 0 ; i < 6 ; i++){
			final int x = i;
			bt[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if(bt[x].getEtat() == false){
						razBouton();
						bt[x].setActif();
						ecran.repaint();
					}
					
				}
				
			});
		}
	}
	
	private void actionRetour(){
		//Retour à l'écran graph7
		btRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.remove(Principal.conso);
				Principal.graph7.majAffichage();
				Principal.graph7.setVisible(true);
				Principal.param.afficheParamProg();
				Principal.fond.repaint();
			}
		});
	}
	
	private void actionValider(){
		btValider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Demande de confimation
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Valider les modification<br>de l'action contrôle consommation ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "bullet_accept" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation modification", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					//Récupère les boutons activés
					int type = 0;
					for (int i = 0; i < 6; i++) {
						if (bt[i].getEtat() == true) {
							type = type + i;
						}
					}
					//Ajoute la valeur
					Principal.programme.setValeur(nIndex + 3, type);
					Principal.programme.setValeurInt(nIndex, 4, saisie1.getText());
					Principal.programme.setValeurInt(nIndex, 6, saisie3.getText());
					Principal.programme.setValeurDouble(nIndex, 8, saisie4.getText());
					
					//Quite l'écran
					Principal.fond.remove(Principal.conso);
					Principal.graph7.majAffichage();
					Principal.graph7.setVisible(true);
					Principal.param.afficheParamProg();
					Principal.fond.repaint();
				}
				
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
						"<html>Voulez vous supprimer<br>l'action contrôle consommation ?</html>", true, 
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
					Principal.fond.remove(Principal.conso);
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
		

		//Importation des données
		razBouton();
		
		saisie1.setText(Principal.programme.getValeurInt(nIndex, 4) + "");
		saisie3.setText(Principal.programme.getValeurInt(nIndex, 6) + "");
		saisie4.setText(Principal.programme.getValeurDouble(nIndex, 8) + "");
		
		bt[Principal.programme.getValeur(nIndex + 3)].setActif();
		
		Principal.param.afficheInfoCodeAction("Mesure consommation");
		Principal.param.setDataAction(nIndex);
	}
	
	private void razBouton(){
		for(int i = 0 ; i < 6 ; i++){
			bt[i].setInactif();
		}
		
	}

}
