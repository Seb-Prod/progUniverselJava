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

public class Ecran4_Camera extends JPanel{

	/**
	 * Page de programmation de l'action contrôle caméra
	 * 
	 * 
	 * N° de caméra = index + 3 (0 = Aucune ; 1 = caméra 1 ; 2 = caméra 2)
	 * N° de Programme (int) = index + 5
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
	 * @version 1.1 du 26 Janvier 2019
	 * Ajout du chargement des données
	 * Ajout de la suppression des donnée
	 * 
	 * @version 1.2 du 27 Janvier 2019
	 * Ajouter de la validation des donnée
	 * Ajout boite de dialogue de confirmation pour la suppression et la modification des données
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
	Label lblNumEtape = new Label(290, 24, "Etape N°xx", Color.WHITE);
	Label lblNumAction = new Label(290, 24, "Action N°xx", Color.WHITE);
	
	//Boutons d'action
	BoutonIcon btRetour = new BoutonIcon(80, 80, "photo", "Retour");
	BoutonIcon btValider = new BoutonIcon(80, 80, "bullet_accept", "Valider les modifications");
	BoutonIcon btSupprimer = new BoutonIcon(80, 80, "trash_empty", "Supprimer l'Action");
	
	//Zone de saisie
	Saisie saisie1 = new Saisie("int", 80, 26);
	
	//Bouton
	Bouton bt[] = new Bouton[3];
	
	public Ecran4_Camera(){
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
		Label lblTitre = new Label("Contrôle caméra :", Color.WHITE, 24);
		Label lbl1 = new Label("N° Programme caméra :", Color.WHITE, 24);
		
		ecran.ajout(lblNumEtape, 0, 20);
		ecran.ajout(lblNumAction, 290, 20);
		ecran.ajout(lblTitre, 35, 90);
		ecran.ajout(lbl1, 5, 285);
		
		//Zone de saisie
		saisie1.setSize(60, 36);
		ecran.ajout(saisie1, 320, 280);
		
		//Bouton
		bt[0] = new Bouton("Désactivé", 180, 61, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt[1] = new Bouton("Camera n°1", 180, 61, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[2] = new Bouton("Camera n°2", 180, 61, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		
		ecran.ajout(bt[0], 360, 74);
		ecran.ajout(bt[1], 40, 154);
		ecran.ajout(bt[2], 360, 154);
		
		this.add(ecran);
		//Ajout des listener des boutons d'action
		actionRetour();
		actionSupprimer();
		actionValider();
		ajoutListener();
		//Listener pour l'info codage
		actionListenerInfo(saisie1, 5, 1, "> N° programme caméra <", "1", "8");
		actionListenerInfo(bt[0], 3, 1, "Désactivé (=0)");
		actionListenerInfo(bt[1], 3, 1, "Caméra 1 (=1)");
		actionListenerInfo(bt[2], 3, 1, "Caméra 2 (=2)");
		
		saisie1.setBackground(Color.red);
		saisie1.setForeground(Color.YELLOW);
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
		for(int i = 0 ; i < 3 ; i++){
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
				Principal.fond.remove(Principal.camera);
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
						"<html>Valider les modification<br>de l'action<br>contrôle caméra ?</html>", true, 
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
					//Ajoute la valeur
					Principal.programme.setValeur(nIndex + 3, type);
					if(saisie1.getText().equals("")){
						Principal.programme.setValeur(nIndex + 5, 1);
					}else{
						Principal.programme.setValeur(nIndex + 5, Integer.parseInt(saisie1.getText()));
					}
					//Quite l'écran
					Principal.fond.remove(Principal.camera);
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
						"<html>Voulez vous supprimer<br>l'action<br>contrôle caméra ?</html>", true, 
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
					Principal.fond.remove(Principal.camera);
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
		razBouton();
		bt[Principal.programme.getValeur(nIndex + 3)].setActif();
		saisie1.setText(Principal.programme.getValeur(nIndex + 5) + "");
		
		Principal.param.afficheInfoCodeAction("Contrôle caméra");
		Principal.param.setDataAction(nIndex);
		
	}
	
	private void razBouton(){
		for(int i = 0 ; i < 3 ; i++){
			bt[i].setInactif();
		}
		
	}	

}
