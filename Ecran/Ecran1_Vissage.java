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
import fr.ProgrammeUniversel.PoidBouton;
import fr.ProgrammeUniversel.Principal;

public class Ecran1_Vissage extends JPanel{

	/**
	 * Page de programmation de l'action Vissage
	 * 
	 * 
	 * Numero de programme (int) = index + 5
	 * Angle 1 (double) = (index + 6) & (index + 7)
	 * Tolérence Angle 1 (double) = (index + 8) & (index + 9)
	 * Angle 2 (double) = (index + 10) & (index + 11)
	 * Tolérence Angle 2 (double) = (index + 12) & (index + 13)
	 * Axe Z (double) = (index + 14) & (index + 15)
	 * Tolérence Axe Z (double) = (index + 16) & (index + 17)
	 * Bouton Bridage d'axe = (index + 3) Bit 3
	 * Bouton Angle 1 et Angle 2 = (index + 3) Bit 1
	 * Bouton Axe Z = (index + 3) Bit 2
	 * Bouton Type de gachette = (index + 3) Bit 4
	 * 
	 * @author sebastien Drillaud
	 * @creation 24 janvier 2019
	 *
	 * @Bug :
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
	 * Ajout de l'actionListener du boutin type de gachette
	 * 
	 * @verion 1.3 du 7 Février 2019
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
	Label lblNumEtape = new Label(290, 26, "Etape N°xx", Color.WHITE);
	Label lblNumAction = new Label(290, 26, "Action N°xx", Color.WHITE);
	
	//Boutons d'action
	BoutonIcon btRetour = new BoutonIcon(80, 80, "photo", "Retour");
	BoutonIcon btValider = new BoutonIcon(80, 80, "bullet_accept", "Valider les modifications");
	BoutonIcon btSupprimer = new BoutonIcon(80, 80, "trash_empty", "Supprimer l'Action");


	
	//Zones de saisie
	Saisie saisieNumProg = new Saisie("int", 15, 24);
	Saisie saisieAngle1 = new Saisie("double", 3599, 24);
	Saisie saisieAngle2 = new Saisie("double", 3599, 24);
	Saisie saisieAxeZ = new Saisie("double", 9999, 24);
	Saisie saisieTolAngle1 = new Saisie("double", 999, 24);
	Saisie saisieTolAngle2 = new Saisie("double", 999, 24);
	Saisie saisieTolAxeZ = new Saisie("double", 999, 24);
	
	//Boutons
	Bouton bt[] = new Bouton[4];
	
	
	
	public Ecran1_Vissage(){
		super();
		this.setSize(Principal.largeur, Principal.hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setOpaque(false);
		
		//Bouton Action
		ecran.ajout(btRetour, 5, 355);
		ecran.ajout(btValider, 485, 355);
		ecran.ajout(btSupprimer, 252, 355);
		//Label
		Label lblTitre = new Label(580, 26, "Vissage", Color.WHITE);
		Label lblProgramme = new Label("N° Programme :", Color.WHITE, 24);
		Label lblGachette = new Label("Type de gachette :", Color.WHITE, 24);
		Label lbl1 = new Label("° Tolerance +/- :     °", Color.WHITE, 24);
		Label lbl2 = new Label("° Tolerance +/- :     °", Color.WHITE, 24);
		Label lbl3 = new Label("  Tolerance +/- :", Color.WHITE, 24);
		
		ecran.ajout(lblNumEtape, 0, 20);
		ecran.ajout(lblNumAction, 290, 20);
		ecran.ajout(lblTitre, 0, 55);
		ecran.ajout(lblProgramme, 5, 100);
		ecran.ajout(lblGachette, 80, 160);
		ecran.ajout(lbl1, 250, 218);
		ecran.ajout(lbl2, 250, 264);
		ecran.ajout(lbl3, 250, 310);
		
		//Zones de saisie
		saisieNumProg.setSize(56, 36);
		ecran.ajout(saisieNumProg, 205, 96);
		saisieAngle1.setSize(100, 36);
		ecran.ajout(saisieAngle1, 150, 214);
		saisieAngle2.setSize(100, 36);
		ecran.ajout(saisieAngle2, 150, 260);
		saisieAxeZ.setSize(100, 36);
		ecran.ajout(saisieAxeZ, 150, 306);
		saisieTolAngle1.setSize(70, 36);
		ecran.ajout(saisieTolAngle1, 490, 214);
		saisieTolAngle2.setSize(70, 36);
		ecran.ajout(saisieTolAngle2, 490, 260);
		saisieTolAxeZ.setSize(70, 36);
		ecran.ajout(saisieTolAxeZ, 490, 306);
		
		//Bouton
		bt[3] = new Bouton("Bridage d'axe", 220, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[2] = new Bouton("Maintenue", 220, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[0] = new Bouton("<html>Angle 1 :<br><br>Angle 2 :</html>", 140, 82, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[1] = new Bouton("Axe Z :", 140, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[0].action();
		bt[1].action();
		bt[2].action();
		bt[3].action();
		
		ecran.ajout(bt[3], 355, 94);
		ecran.ajout(bt[2], 355, 154);
		ecran.ajout(bt[0], 5, 214);
		ecran.ajout(bt[1], 5, 304);
		
		//Ajoute les éléments à l'écran
		this.add(ecran);
		
		//Ajout des listener des boutons d'action
		actionRetour();
		actionSupprimer();
		actionValider();
		
		//Listener du bouton type de gachette
		bt[2].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[2].getEtat() == true){
					bt[2].setTexte("Maintenue");
				}else{
					bt[2].setTexte("Impulsion");
				}
				
			}
			
		});
		
		//Listener pour l'info codage
		actionListenerInfo(saisieNumProg, 5, 1, "> N° programme <", "0", "15");
		actionListenerInfo(saisieAngle1, 6, 2, "> Angle 1 <", "0,0°", "359,9°");
		actionListenerInfo(saisieAngle2, 10, 2, "> Angle 2 <", "0,0°", "359,9°");
		actionListenerInfo(saisieAxeZ, 14, 2, "> Axe Z <", "0,0", "999,9");
		actionListenerInfo(saisieTolAngle1, 8, 2, "> Tol. Angle 1 <", "0,0°", "99,9°");
		actionListenerInfo(saisieTolAngle2, 12, 2, "> Tol. Angle 2 <", "0,0°", "99,9°");
		actionListenerInfo(saisieTolAxeZ, 16, 2, "> Tol. Axe Z <", "0,0", "99,9");
		actionListenerInfo(bt[0], 3, 1, "Angle 1 et 2 (+1)");
		actionListenerInfo(bt[1], 3, 1, "Axe Z (+2)");
		actionListenerInfo(bt[2], 3, 1, "Type de gachette (+4)");
		actionListenerInfo(bt[3], 3, 1, "Bridage d'axe (+8)");
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
				Principal.fond.remove(Principal.vissage);
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
						"<html>Voulez vous supprimer<br>l'action vissage ?</html>", true, 
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
					Principal.fond.remove(Principal.vissage);
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
						"<html>Valider les modification<br>de l'action vissage ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "bullet_accept" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation modification", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					//Récupère les boutons activés
					int poid = 0;
					for (int i = 0; i < 4; i++) {
						PoidBouton poidFonction = new PoidBouton();
						if (bt[i].getEtat() == true) {
							poid = poid + poidFonction.poidBit(i);
						}
					}
					//Ajoute la valeur
					ecran.cacheDialog(ecran.dialogValid);
					Principal.programme.setValeur(nIndex + 3, poid);
					Principal.programme.setValeurDouble(nIndex, 6, saisieAngle1.getText());
					Principal.programme.setValeurDouble(nIndex, 8, saisieTolAngle1.getText());
					Principal.programme.setValeurDouble(nIndex, 10, saisieAngle2.getText());
					Principal.programme.setValeurDouble(nIndex, 12, saisieTolAngle2.getText());
					Principal.programme.setValeurDouble(nIndex, 14, saisieAxeZ.getText());
					Principal.programme.setValeurDouble(nIndex, 16, saisieTolAxeZ.getText());
					
					if(saisieNumProg.getText().equals("")){
						Principal.programme.setValeur(nIndex + 5, 1);
					}else{
						Principal.programme.setValeur(nIndex + 5, Integer.parseInt(saisieNumProg.getText()));
					}
					
					
					
					//Quite l'écran
					Principal.fond.remove(Principal.vissage);
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
		
		//Importation des données
		saisieNumProg.setText(Principal.programme.getValeur(nIndex + 5) + "");
		saisieAngle1.setText(Principal.programme.getValeurDouble(nIndex, 6) + "");
		saisieTolAngle1.setText(Principal.programme.getValeurDouble(nIndex, 8) + "");
		saisieAngle2.setText(Principal.programme.getValeurDouble(nIndex, 10) + "");
		saisieTolAngle2.setText(Principal.programme.getValeurDouble(nIndex, 12) + "");
		saisieAxeZ.setText(Principal.programme.getValeurDouble(nIndex, 14) + "");
		saisieTolAxeZ.setText(Principal.programme.getValeurDouble(nIndex, 16) + "");
		
		
		
		for(int y = 0 ; y < 4 ; y++){
			if(Principal.programme.getBit(nIndex + 3, 0, y) == 1){
				bt[y].setActif();
			}else{
				bt[y].setInactif();
			}
		}
		
		if(Principal.programme.getBit(nIndex + 3, 0, 2) == 1){
			bt[2].setTexte("Impulsion");
			
		} else {
			bt[2].setTexte("Maintenue");
		}
		
		Principal.param.afficheInfoCodeAction("Vissage");
		Principal.param.setDataAction(nIndex);
	}
	

	


}
