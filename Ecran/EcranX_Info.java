package Ecran;

import java.awt.Color;
import javax.swing.JPanel;

import Elements.LabelLettre;
import fr.ProgrammeUniversel.Principal;

public class EcranX_Info extends JPanel{

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
	
	
	
	
	LabelLettre lblCode[] = new LabelLettre[30];
	LabelLettre lblChar[] = new LabelLettre[30];
	
	LabelLettre lblEtape1[] = new LabelLettre[22];
	LabelLettre lblEtape2[] = new LabelLettre[22];
	LabelLettre lblEtape3[] = new LabelLettre[22];
	LabelLettre lblEtape4[] = new LabelLettre[22];
	LabelLettre lblEtape5[] = new LabelLettre[22];

	public EcranX_Info(){
		super();
		this.setSize(largeur, hauteur);
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setOpaque(false);
		
		int x = 5;
		int y = 30;

		
		for(int i = 0 ; i < 30 ; i++){
			lblCode[i] = new LabelLettre(18, 10, Color.red);
			lblCode[i].setLocation(x, y);
			this.add(lblCode[i]);
			
			lblChar[i] = new LabelLettre(18, 10, Color.WHITE);
			lblChar[i].setLocation(x, y + 20);
			this.add(lblChar[i]);
			
			x = x + 19;
		}
		y = 100;
		x = 5;
		for(int i = 0 ; i < 22 ; i++){
			lblEtape1[i] = new LabelLettre(25, 10, Color.red);
			lblEtape1[i].setLocation(x, y);
			this.add(lblEtape1[i]);
			
			lblEtape2[i] = new LabelLettre(25, 10, Color.red);
			lblEtape2[i].setLocation(x, y + 60);
			this.add(lblEtape2[i]);
			
			lblEtape3[i] = new LabelLettre(25, 10, Color.red);
			lblEtape3[i].setLocation(x, y + 120);
			this.add(lblEtape3[i]);
			
			lblEtape4[i] = new LabelLettre(25, 10, Color.red);
			lblEtape4[i].setLocation(x, y + 180);
			this.add(lblEtape4[i]);
			
			lblEtape5[i] = new LabelLettre(25, 10, Color.red);
			lblEtape5[i].setLocation(x, y + 240);
			this.add(lblEtape5[i]);
			x = x + 26;
		}
		

	}
	

	public void setData(int index){
		for(int i = 0 ; i < 30 ; i++){
			lblCode[i].setText(Principal.programme.getValeur(index + i) + "");
			//lblChar[i].setText(Principal.programme.getString(index + i, 1));
		}
		for(int i = 0 ; i < 22 ; i++){
			lblEtape1[i].setText(Principal.programme.getValeur(index + 30 + i) + "");
			lblEtape2[i].setText(Principal.programme.getValeur(index + 52 + i) + "");
			lblEtape3[i].setText(Principal.programme.getValeur(index + 74 + i) + "");
			lblEtape4[i].setText(Principal.programme.getValeur(index + 96 + i) + "");
			lblEtape5[i].setText(Principal.programme.getValeur(index + 118 + i) + "");
		}
	}

	

	

	
	

}
