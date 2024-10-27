package Ecran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Elements.Bouton;
import Elements.BoutonIcon;
import Elements.Ecran;
import Elements.Label;
import Elements.Saisie;
import Panel.Panel;
import fr.ProgrammeUniversel.Principal;

public class Ecran0_Param extends JPanel{

	/**
	 * Page de programmation de l'action Vissage
	 */
	
	private static final long serialVersionUID = 1L;
	
	public int nEtape = 1;
	int largeur = 645;
	int hauteur = 525;
	
	Ecran ecran = new Ecran(Color.DARK_GRAY.darker().darker());
	
	
	BoutonIcon btRetour = new BoutonIcon(80, 80, "arrow_left", "Paramètre du programme");
	
	
	//Zone de saisie
	Saisie saisie1= new Saisie("string", 30, 22);
	Saisie saisie2 = new Saisie("int", 15, 22);
	Saisie saisie3 = new Saisie("string", 11, 22);
	Saisie saisie4 = new Saisie("int", 20, 22);
	Saisie saisie5 = new Saisie("int", 1440, 22);
	//Bouton
		Bouton bt[] = new Bouton[4];
	
	public Ecran0_Param(){
		super();
		this.setSize(largeur, hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setOpaque(false);
		//Bouton Action
		ecran.ajout(btRetour, 5, 95);
		
		
		//Label
		
		Label lbl1 = new Label("Codage :", Color.WHITE, 18);
		Label lbl2 = new Label("Référence Produit :", Color.WHITE, 16);
		Label lbl3 = new Label("Déclencher le comptage", Color.WHITE, 22);
		Label lbl4 = new Label("du temps de cycle", Color.WHITE, 22);
		Label lbl5 = new Label("à partir de l'étape n°", Color.WHITE, 22);
		Label lbl6 = new Label("Gestion du RFID", Color.WHITE, 22);
		Label lbl7 = new Label("Durée mini entre 2 postes :       Minutes", Color.WHITE, 22);
		
		Panel t = new Panel(565, 4, Color.GRAY);
		t.setLocation(35, 220);
		this.add(t);
		
		ecran.ajout(lbl1, 427, 12);
		ecran.ajout(lbl2, 30, 57);
		ecran.ajout(lbl3, 90, 95);
		ecran.ajout(lbl4, 90, 117);
		ecran.ajout(lbl5, 90, 139);
		ecran.ajout(lbl6, 40, 210);
		ecran.ajout(lbl7, 10, 400);
		
		//Zone de saisie
		saisie1.setSize(420, 36);
		ecran.ajout(saisie1, 5, 5);
		saisie2.setSize(50, 36);
		ecran.ajout(saisie2, 520, 5);
		saisie3.setSize(200, 36);
		ecran.ajout(saisie3, 225, 50);
		saisie4.setSize(50, 36);
		ecran.ajout(saisie4, 380, 134);
		saisie5.setSize(65, 36);
		ecran.ajout(saisie5, 372, 396);
		
		saisie2.setBackground(Color.red);
		saisie2.setForeground(Color.YELLOW);
		saisie4.setBackground(Color.red);
		saisie4.setForeground(Color.YELLOW);
		
		bt[0] = new Bouton("Désactivé", 180, 41, new Color(42, 11, 22), new Color(150, 42, 22), 20);
		bt[1] = new Bouton("Tête n°1", 180, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[2] = new Bouton("Tête n°2", 180, 41, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		bt[3] = new Bouton("<html>Tête n°1<br>   &<br>Tête n°2</html>", 180, 91, new Color(11, 42, 22), new Color(11, 150, 22), 20);
		
		ecran.ajout(bt[0], 320, 200);
		ecran.ajout(bt[1], 70, 260);
		ecran.ajout(bt[2], 70, 310);
		ecran.ajout(bt[3], 320, 260);
		
		this.add(ecran);
		actionRetour();
		listenerBt();
	}
	
	private void listenerBt(){
		bt[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[0].getEtat() == false){
					bt[0].setActif();
					bt[1].setInactif();
					bt[2].setInactif();
					bt[3].setInactif();
					ecran.repaint();
				}
			}	
		});
		bt[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[1].getEtat() == false){
					bt[1].setActif();
					bt[0].setInactif();
					bt[2].setInactif();
					bt[3].setInactif();
					ecran.repaint();
				}
			}	
		});
		bt[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[2].getEtat() == false){
					bt[2].setActif();
					bt[1].setInactif();
					bt[0].setInactif();
					bt[3].setInactif();
					ecran.repaint();
				}
			}	
		});
		bt[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bt[3].getEtat() == false){
					bt[3].setActif();
					bt[1].setInactif();
					bt[2].setInactif();
					bt[0].setInactif();
					ecran.repaint();
				}
			}	
		});
	}
	
	private void actionRetour(){
		//Retour à l'écran graph7
		btRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.programme.SetLibelleProgramme(saisie1.getText());
				Principal.programme.SetNumProgramme(Integer.parseInt(saisie2.getText()));
				Principal.programme.SetNumEtape(Integer.parseInt(saisie4.getText()));
				Principal.programme.SetRef(saisie3.getText());
				Principal.programme.setValeurInt(4780, 0, saisie5.getText());
				for(int i = 0 ; i < 4 ; i++){
					if(bt[i].getEtat() == true){
						Principal.programme.SetParamRFID(i);
					}
				}
				
				
				Principal.graph7.majAffichage();
				Principal.fond.remove(Principal.ecranParam);
				Principal.graph7.setVisible(true);
				Principal.fond.repaint();
			}
		});
	}
	
	public void getParam(){
		saisie1.setText(Principal.programme.GetLibelleProgramme());
		saisie2.setText(Principal.programme.GetNumProgramme() + "");
		saisie3.setText(Principal.programme.GetRef());
		saisie4.setText(Principal.programme.GetNumEtape() + "");
		saisie5.setText(Principal.programme.getValeurInt(4780, 0) + "");
		for(int i = 0 ; i < 4 ; i++){
			bt[i].setInactif();
		}
		bt[Principal.programme.GetParamRFID()].setActif();
	}
	

}
