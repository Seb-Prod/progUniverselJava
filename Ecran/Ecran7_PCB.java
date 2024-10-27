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

import Elements.BoutonIcon;
import Elements.Ecran;
import Elements.Label;
import Elements.MonJLabel;
import Elements.Saisie;
import fr.ProgrammeUniversel.Principal;

public class Ecran7_PCB extends JPanel{

	/**
	 * Page de programmation de Traçabilité PCB
	 * 
	 * 
	 * Réf. AL = index + 2 à index + 10
	 * N° du PCB dans le TAG (int) = index + 11
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
	 * @version 1.1 du 26 Janvier 2019
	 * Ajout du chargement des données
	 * Ajout de la suppression des donnée
	 * 
	 * @version 1.2 du 27 Janvier 2019
	 * Ajouter de la validation des donnée
	 * Ajout boite de dialogue de confirmation pour la suppression et la modification des données
	 */
	
	private static final long serialVersionUID = 1L;
	
	int nEtape = 0;
	int nAction = 0;
	int nIndex = 0;
	
	//L'écran
	Ecran ecran = new Ecran(new Color(2, 63, 64));
	
	//Labels
	Label lblNumEtape = new Label(290, 26, "Etape N°xx", Color.WHITE);
	Label lblNumAction = new Label(290, 26, "Action N°xx", Color.WHITE);
	
	//Boutons d'action
	BoutonIcon btRetour = new BoutonIcon(80, 80, "photo", "Retour");
	BoutonIcon btValider = new BoutonIcon(80, 80, "bullet_accept", "Valider les modifications");
	BoutonIcon btSupprimer = new BoutonIcon(80, 80, "trash_empty", "Supprimer l'Action");
	
	//Zones de saisie
	Saisie saisie1= new Saisie("string", 8, 24);
	Saisie saisie2 = new Saisie("int", 6, 24);
	Saisie saisie3 = new Saisie("string", 4, 24);
	Saisie saisie4 = new Saisie("double2", 9999, 24);
	
	public Ecran7_PCB(){
		super();
		this.setSize(Principal.largeur, Principal.hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setOpaque(false);
		
		//Boutons Action
		ecran.ajout(btRetour, 5, 355);
		ecran.ajout(btValider, 485, 355);
		ecran.ajout(btSupprimer, 252, 355);
		
		//Labels
		Label lblTitre = new Label(580, 26, "Traçabilité du PCB", Color.WHITE);
		Label lbl1 = new Label("AL Code:", Color.WHITE, 24);
		Label lbl2 = new Label("N° PCB dans le Tag RFID:", Color.WHITE, 24);
		Label lbl3 = new Label("AL Revision:", Color.WHITE, 24);
		Label lbl4 = new Label("Tempo en fin de lecture:        Sec.", Color.WHITE, 24);
		
		ecran.ajout(lblNumEtape, 0, 20);
		ecran.ajout(lblNumAction, 290, 20);
		ecran.ajout(lblTitre, 0, 55);
		ecran.ajout(lbl1, 5, 150);
		ecran.ajout(lbl2, 5, 205);
		ecran.ajout(lbl3, 315, 150);
		ecran.ajout(lbl4, 5, 260);
		
		//Zone de saisie
		saisie1.setSize(150, 36);
		ecran.ajout(saisie1, 120, 146);
		saisie2.setSize(85, 36);
		ecran.ajout(saisie2, 350, 201);
		saisie3.setSize(80, 36);
		ecran.ajout(saisie3, 490, 146);
		saisie4.setSize(85, 36);
		ecran.ajout(saisie4, 350, 256);
		
		this.add(ecran);
		
		//Ajout des listener des boutons d'action
		actionRetour();
		actionSupprimer();
		actionValider();
		//Listener pour l'info codage
		actionListenerInfo(saisie1, 2, 8, "AL Code (8 char)");
		actionListenerInfo(saisie2, 11, 1, "> N° du PCB dans le TAG <", "0", "6");
		actionListenerInfo(saisie3, 12, 4, "AL Révision (4 char)");
		actionListenerInfo(saisie4, 20, 2, "> Tempo <", "0,000s", "9.999s");

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
	
	private void actionRetour(){
		//Retour à l'écran graph7
		btRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.remove(Principal.pcb);
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
						"<html>Voulez vous supprimer<br>l'action<br> traçabilité du PCB ?</html>", true, 
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
					Principal.fond.remove(Principal.pcb);
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
						"<html>Valider les modification<br>de l'action<br>traçabilité du PCB ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "bullet_accept" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation modification", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					//Ajoute la valeur
					Principal.programme.setString(nIndex + 2, saisie1.getText(), 8);
					Principal.programme.setValeur(nIndex + 11, Integer.parseInt(saisie2.getText()));
					Principal.programme.setString(nIndex + 12, saisie3.getText(), 4);
					Principal.programme.setValeurDouble2(nIndex,20 , saisie4.getText());
					
					//Quite l'écran
					Principal.fond.remove(Principal.pcb);
					Principal.graph7.majAffichage();
					Principal.graph7.setVisible(true);
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
		
		//Importation des données
		saisie1.setText(Principal.programme.getString((nIndex + 2), 8));
		saisie2.setText(Principal.programme.getValeur(nIndex + 11) + "");
		saisie3.setText(Principal.programme.getString((nIndex + 12), 4));
		saisie4.setText(Principal.programme.getValeurDouble2(nIndex, 20) + "");
		
		Principal.param.afficheInfoCodeAction("Traçabilité du PCB");
		Principal.param.setDataAction(nIndex);
	}
	
	

}
