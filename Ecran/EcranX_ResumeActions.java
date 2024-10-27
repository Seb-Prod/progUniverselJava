package Ecran;

import java.awt.Color;
import javax.swing.JPanel;

import Elements.Label;
import Elements.PanelPastille;
import Panel.Panel;
import fr.ProgrammeUniversel.Principal;

public class EcranX_ResumeActions extends JPanel{

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
	Panel ecran = new Panel(580, 200);
	//Ecran ecran = new Ecran(new Color(2, 63, 64), 1);
	Panel pEtate = new Panel(12, 190, Color.GRAY);
	public Panel pSortie = new Panel(520, 13, Color.GRAY);
	
	PanelPastille A2[] = new PanelPastille[6];
	PanelPastille A4[] = new PanelPastille[4];
	PanelPastille A5[] = new PanelPastille[8];
	PanelPastille A6[] = new PanelPastille[6];
	
	Label lbl[] = new Label[21];

	
	public EcranX_ResumeActions(){
		super();
		this.setSize(largeur, hauteur);
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setOpaque(false);
		
		int y = 25;
		int x = 178;
		

		for(int i = 0 ; i < 6 ; i ++){
			A2[i] = new PanelPastille("A2." + i, "azertyuiopqsdfghjklm");
			ecran.ajout(A2[i], 0, y);
			A2[i].cache();
			y = y + 13;	
		}
		for(int i = 0 ; i < 4 ; i ++){
			A4[i] = new PanelPastille("A4." + i, "azertyuiopqsdfghjklm");
			ecran.ajout(A4[i], 0, y);
			A4[i].cache();
			y = y + 13;	
		}
		for(int i = 6 ; i < 8 ; i ++){
			A5[i] = new PanelPastille("A5." + i, "azertyuiopqsdfghjklm");
			ecran.ajout(A5[i], 0, y);
			A5[i].cache();
			y = y + 13;	
		}
		for(int i = 5 ; i < 6 ; i ++){
			A6[i] = new PanelPastille("A6." + i, "azertyuiopqsdfghjklm");
			ecran.ajout(A6[i], 0, y);
			A6[i].cache();
			y = y + 13;	
		}
		
		x = x + 15;
		for(int i = 1 ; i < 21 ; i++){
			lbl[i] = new Label(15, 10, i + "", Color.WHITE);
			lbl[i].setLocation(x, 5);
			x = x + 15;
			ecran.add(lbl[i]);
		}
		
		
		ecran.ajout(pEtate, 179, 10);
		ecran.ajout(pSortie, 5, 25);
		this.add(ecran);

		pSortie.setVisible(false);
		

	}
	
	public void setEtape(int netape){
		pEtate.setLocation(149 + (15 * netape) + 30, 3);
	}
	
	public void setPosition(int x){
		pSortie.setLocation(5, x + 55);
	}
	

	public void maj(){
		Principal.resume.setCouleurEcran2(new Color(2, 63, 64));
		int indexTxt = 800;
		//Texte 12.
		for(int i = 0 ; i < 6 ; i++){
			A2[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
		}
		indexTxt = indexTxt + 20;
		//Texte A4.
		for(int i = 0 ; i < 4 ; i++){
			A4[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
		}
		//Texte A5.
		for(int i = 6 ; i < 8 ; i++){
			A5[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
		}
		//Texte A6.
		for(int i = 5 ; i < 6 ; i++){
			A6[i].setTexte(Principal.programme.GetLibelleSortie(indexTxt));
			indexTxt = indexTxt + 20;
		}

	
		int nIndex = 0;
		
		for(int i = 1 ; i < 21 ; i++){
			
			int index = Principal.programme.GetIndexTransition(i);
			
			for(int y = 0 ; y < 6 ; y++){
				A2[y].setNull(i);
			}
			for(int y = 0 ; y < 4 ; y++){
				A4[y].setNull(i);
			}
			for(int y = 6 ; y < 8 ; y++){
				A5[y].setNull(i);
			}
			for(int y = 5 ; y < 6 ; y++){
				A6[y].setNull(i);
			}
			
			for(int x = 0 ; x < 5 ; x++){
				if(Principal.programme.getTypeAction(index, x).equals("Action")){
					nIndex = Principal.programme.GetIndexTransition(i) + 30 + (22 * (x + 1)) - 22;
					for(int y = 0 ; y < 6 ; y++){
						A2[y].setNull(i);
						if(Principal.programme.getBit(nIndex, 5, y) == 1){
							A2[y].setActif(i);
						}
					}
					for(int y = 0 ; y < 4 ; y++){
						A4[y].setNull(i);
						if(Principal.programme.getBit(nIndex, 9, y) == 1){
							A4[y].setActif(i);
						}
					}
					for(int y = 6 ; y < 8 ; y++){
						A5[y].setNull(i);
						if(Principal.programme.getBit(nIndex, 11, y) == 1){
							A5[y].setActif(i);
						}
					}
					for(int y = 5 ; y < 6 ; y++){
						A6[y].setNull(i);
						if(Principal.programme.getBit(nIndex, 13, y) == 1){
							A6[y].setActif(i);
						}
					}
				}
			}
		}
				
			
			
		
		
		
		
		
	}

	

	

	
	

}
