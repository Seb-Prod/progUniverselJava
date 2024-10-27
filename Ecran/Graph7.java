package Ecran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Elements.Bouton;
import Elements.BoutonAction;
import Elements.BoutonIcon;
import Elements.BtEtape;
import Elements.Ecran;
import Elements.Label;
import Elements.MonJLabel;
import Elements.Saisie;
import fr.ProgrammeUniversel.PoidBouton;
import fr.ProgrammeUniversel.Principal;

public class Graph7 extends JPanel{

	/**
	 * Page de programmation de l'action Vissage
	 */
	
	private static final long serialVersionUID = 1L;
	
	public int nEtape = 1;
	int largeur = 645;
	int hauteur = 525;
	
	Ecran ecran = new Ecran(Color.DARK_GRAY.darker().darker(), true);
	
	
	BoutonIcon btParam = new BoutonIcon(80, 80, "file_edit", "Paramètre du programme");
	BoutonIcon btAjouter = new BoutonIcon(80, 80, "photo_add", "Insérer une étape");
	BoutonIcon btSupprimer = new BoutonIcon(80, 80, "photo_delete", "Supprimer l'étape");
	BoutonIcon btHaut = new BoutonIcon(56, 56, "arrow_up", "Retour");
	BoutonIcon btBas = new BoutonIcon(56, 56, "arrow_down", "Retour");
	
	BoutonAction btAction1 = new BoutonAction("", 140, 36);
	BoutonAction btAction2 = new BoutonAction("", 140, 36);
	BoutonAction btAction3 = new BoutonAction("", 140, 36);
	BoutonAction btAction4 = new BoutonAction("", 140, 36);
	BoutonAction btAction5 = new BoutonAction("", 140, 36);
	Bouton btTransition = new Bouton("Transition", 76, 35, false, false, 20);
	Bouton btTransition0 = new Bouton("<html>Conditions<br>Initiales</html>", 96, 60, false, true, 18);
	
	BtEtape btEtape = new BtEtape(1);
	
	//Zone de saisie
	Saisie saisie1= new Saisie("string", 30, 22);
	Saisie saisie2 = new Saisie("int", 30, 22);
	Saisie saisie3 = new Saisie("string", 30, 22);
	
	@SuppressWarnings("deprecation")
	public Graph7(){
		super();
		this.setSize(largeur, hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setOpaque(false);
		//Bouton Action
		ecran.ajout(btParam, 215, 355);
		ecran.ajout(btSupprimer, 400, 355);
		ecran.ajout(btAjouter, 485, 355);
		ecran.ajout(btHaut, 40, 45);
		ecran.ajout(btBas, 40, 315);
		
		ecran.ajout(btAction1, 130, 140);
		ecran.ajout(btAction2, 280, 140);
		ecran.ajout(btAction3, 430, 140);
		ecran.ajout(btAction4, 130, 205);
		ecran.ajout(btAction5, 280, 205);
		
		ecran.ajout(btTransition, 30, 255);
		ecran.ajout(btTransition0, 30, 43);
		
		ecran.ajout(btEtape, 30, 135);
		
		//Label
		
		Label lbl1 = new Label("Codage :", Color.WHITE, 18);
		Label lbl2 = new Label("Message opérateur:", Color.WHITE, 24);
		Label lbl3 = new Label("Action 1:", Color.WHITE, 22);
		Label lbl4 = new Label("Action 2:", Color.WHITE, 22);
		Label lbl5 = new Label("Action 3:", Color.WHITE, 22);
		Label lbl6 = new Label("Action 4:", Color.WHITE, 22);
		Label lbl7 = new Label("Action 5:", Color.WHITE, 22);

		ecran.ajout(lbl1, 430, 12);
		ecran.ajout(lbl2, 135, 40);
		ecran.ajout(lbl3, 135, 115);
		ecran.ajout(lbl4, 285, 115);
		ecran.ajout(lbl5, 435, 115);
		ecran.ajout(lbl6, 135, 180);
		ecran.ajout(lbl7, 285, 180);
		
		saisie1.enable(false);
		saisie2.enable(false);
		//Zone de saisie
		saisie1.setSize(420, 36);
		ecran.ajout(saisie1, 5, 5);
		saisie2.setSize(50, 36);
		ecran.ajout(saisie2, 520, 5);
		saisie3.setSize(430, 36);
		ecran.ajout(saisie3, 130, 70);
		
		
		this.add(ecran);
		
		btTransition.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.add(Principal.entree);
				Principal.entree.setValeur(nEtape);
				Principal.graph7.setVisible(false);
				Principal.fond.repaint();
				
			}
			
		});
		
		btTransition0.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.add(Principal.entree);
				Principal.entree.setValeur(0);
				Principal.graph7.setVisible(false);
				Principal.fond.repaint();
			}
			
		});
		
		btBas.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(nEtape < 20){
					nEtape = nEtape + 1;
					btEtape.setEtape(nEtape);
				}
				majAffichage();
			}
			
		});
		
		btHaut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(nEtape > 1){
					nEtape = nEtape - 1;
					btEtape.setEtape(nEtape);
				}
				if(nEtape == 1){
					btHaut.setVisible(false);
					btTransition0.setVisible(true);
				}else{
					btHaut.setVisible(true);
					btTransition0.setVisible(false);
				}
				majAffichage();
			}
			
		});
	
		saisie3.addKeyListener(new KeyListener(){

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
				int index = Principal.programme.GetIndexTransition(nEtape);
				Principal.programme.setString(index, saisie3.getText(), 30);
				
			}
			
		});
		
		BtAction(btAction1, 1);
		BtAction(btAction2, 2);
		BtAction(btAction3, 3);
		BtAction(btAction4, 4);
		BtAction(btAction5, 5);
		
		param();
		supp();
		ajouter();
		majAffichage();
	}
	
	private void ajouter(){
		btAjouter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//Demande de confimation
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Voulez vous insérer une étape<br>entre l'étape n°" + (nEtape - 1) + 
						" et l'étape n°" + (nEtape) + " ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "photo_add" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation suppression", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					//Suppression de l'étape
					int n = 0;
					int n2 = 0;
					PoidBouton transition = new PoidBouton();
					for(int i = 19 ; i > nEtape - 1 ; i--){
						
						int index = Principal.programme.GetIndexTransition(i);
						int index2 = Principal.programme.GetIndexTransition(i + 1);
						
						int nIndex = transition.getIndexTransition(i);
						int nIndex2 = transition.getIndexTransition(i + 1);
						
						for(int v = nIndex ; v < nIndex2 ; v ++){
							Principal.programme.setValeur(nIndex2 + n2, Principal.programme.getValeur(v));
							n2 = n2 + 1;
							
						}
						
						
						for(int u = index ; u < index2 ; u++){
							Principal.programme.setValeur(index2 + n, Principal.programme.getValeur(u));
							n = n + 1;
						}
						n = 0;
						n2 = 0;
					}
					
					int index = Principal.programme.GetIndexTransition(nEtape);
					int index2 = Principal.programme.GetIndexTransition(nEtape + 1);
					
					int nIndex = transition.getIndexTransition(nEtape);
					int nIndex2 = transition.getIndexTransition(nEtape + 1);
					
					for(int v = nIndex ; v < nIndex2 ; v ++){
						Principal.programme.setValeur(v, 0);
						
						
					}
					
					
					for(int u = index ; u < index2 ; u++){
						Principal.programme.setValeur(u, 0);
					}
					
					
					//Quite l'écran
					Principal.graph7.majAffichage();
					Principal.fond.repaint();
				}
			}
			
		});
	}
	
	private void supp(){
		btSupprimer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//Demande de confimation
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Voulez vous supprimer l'étape n°" + nEtape + "<br>"
								+ saisie3.getText() + " ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "trash_empty" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Validation suppression", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					//Suppression de l'étape
					int n = 0;
					int n2 = 0;
					PoidBouton transition = new PoidBouton();
					for(int i = nEtape ; i < 19 ; i ++){
						
						int index = Principal.programme.GetIndexTransition(i);
						int index2 = Principal.programme.GetIndexTransition(i + 1);
						
						
						int nIndex = transition.getIndexTransition(i);
						int nIndex2 = transition.getIndexTransition(i + 1);
						
						for(int v = nIndex ; v < nIndex2 ; v ++){
							Principal.programme.setValeur(v, Principal.programme.getValeur(nIndex2 + n2));
							n2 = n2 + 1;
							
						}
						
						for(int u = index ; u < index2 ; u++){
							Principal.programme.setValeur(u, Principal.programme.getValeur(index2 + n));
							n = n + 1;
						}
						n = 0;
						n2 = 0;
					}
					
					
					//Quite l'écran
					Principal.graph7.majAffichage();
					Principal.fond.repaint();
				}
			}
			
		});
	}
	
	private void param(){
		btParam.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.graph7.setVisible(false);
				Principal.fond.add(Principal.ecranParam);
				Principal.ecranParam.getParam();
			}
			
		});
	}
	
	public void majAffichage(){
		int index = Principal.programme.GetIndexTransition(nEtape);
		btEtape.setEtape(nEtape);
		saisie1.setText(Principal.programme.GetLibelleProgramme());
		saisie2.setText(Principal.programme.GetNumProgramme() + "");
		saisie3.setText(Principal.programme.GetLibelleEtape(index));
		btAction1.setText(Principal.programme.getTypeAction(index, 0));
		btAction2.setText(Principal.programme.getTypeAction(index, 1));
		btAction3.setText(Principal.programme.getTypeAction(index, 2));
		btAction4.setText(Principal.programme.getTypeAction(index, 3));
		btAction5.setText(Principal.programme.getTypeAction(index, 4));
		Principal.resumeAction.setEtape(nEtape);
		Principal.resumeEntree.setEtape(nEtape);
		Principal.param.afficheParamProg();
		Principal.resumeAction.maj();
		Principal.resumeEntree.maj();
		
		
		if(nEtape == 1){
			btHaut.setVisible(false);
			btTransition0.setVisible(true);
		}else{
			btHaut.setVisible(true);
			btTransition0.setVisible(false);
		}
		
	}
	
	private void BtAction(final JButton b, final int nAction){
		
		
		b.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String t = b.getText();
				switch(t){
				case "Vissage":
					Principal.fond.add(Principal.vissage);
					Principal.vissage.setValeur(nEtape, nAction);
					Principal.graph7.setVisible(false);
					Principal.fond.repaint();
					break;
				case "Soudure":
					Principal.fond.add(Principal.soudure);
					Principal.soudure.setValeur(nEtape, nAction);
					Principal.graph7.setVisible(false);
					Principal.fond.repaint();
					break;
				case "Conso.":
					Principal.fond.add(Principal.conso);
					Principal.conso.setValeur(nEtape, nAction);
					Principal.graph7.setVisible(false);
					Principal.fond.repaint();
					break;
				case "Caméra":
					Principal.fond.add(Principal.camera);
					Principal.camera.setValeur(nEtape, nAction);
					Principal.graph7.setVisible(false);
					Principal.fond.repaint();
					break;
				case "RFID":
					Principal.fond.add(Principal.rfid);
					Principal.rfid.setValeur(nEtape, nAction);
					Principal.graph7.setVisible(false);
					Principal.fond.repaint();
					break;
				case "Action":
					Principal.fond.add(Principal.sortie);
					Principal.sortie.setValeur(nEtape, nAction);
					Principal.graph7.setVisible(false);
					Principal.fond.repaint();
					break;
				case "Traçab.":
					Principal.fond.add(Principal.pcb);
					Principal.pcb.setValeur(nEtape, nAction);
					Principal.graph7.setVisible(false);
					Principal.fond.repaint();
					break;
				case "":
					Principal.fond.add(Principal.fonction);
					Principal.fonction.setValeur(nEtape, nAction);
					Principal.graph7.setVisible(false);
					Principal.fond.repaint();
					break;
				}
				
			}
			
		});
	}
	
	public void setNum(int etape){
		

		
		
	}
	
	

}
