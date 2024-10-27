package fr.ProgrammeUniversel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Ecran.Ecran4_Camera;
import Ecran.Ecran3_Conso;
import Ecran.Ecran_Accueil;
import Ecran.Ecran_Export;
import Ecran.Ecran_Param;
import Ecran.Ecran_import;
import Ecran.Entree;
import Ecran.Graph7;
import Ecran.Ecran7_PCB;
import Ecran.EcranX_Info;
import Ecran.EcranX_ResumeActions;
import Ecran.EcranX_ResumeEntree;
import Ecran.Ecran5_RFID;
import Ecran.Ecran6_Sortie;
import Ecran.Ecran2_Soudure;
import Elements.Ecran;
import Elements.MaPolice;
import Elements.PostIt;
import Panel.Fenetre;
import Panel.Panel;
import Ecran.Ecran0_Param;
import Ecran.Ecran0_fonctions;
import Ecran.Ecran1_Vissage;

public class Principal {
	//Programme
	public static File repertoire = new java.io.File(new java.io.File("").getAbsolutePath());
	public static Chargement programme = new Chargement("Seb-Prod");
	public static String nom = "";
	
	public static String fontDuProgramme = "/font/Hack-Regular.ttf";
	MaPolice font = new MaPolice(Principal.fontDuProgramme);
	
	//La fenêtre
	public static Fenetre fenetre  = new Fenetre(650, 550, "Editeur Grafcet Programme Universel V3.30 (20190325)");
	public static Panel fond = new Panel(Color.DARK_GRAY);
	
	//Les écrans
	public static int largeur = 645;
	public static int hauteur = 525;
	public static Ecran_Accueil panAccueil = new Ecran_Accueil();
	public static Ecran1_Vissage vissage;
	public static Ecran2_Soudure soudure;
	public static Ecran3_Conso conso;
	public static Ecran4_Camera camera;
	public static Ecran5_RFID rfid;
	public static Ecran6_Sortie sortie;
	public static Ecran7_PCB pcb;
	public static Entree entree;
	public static Ecran0_fonctions fonction;
	public static Ecran0_Param ecranParam;
	
	public static Ecran_Param param = new Ecran_Param();
	public static Ecran resume;
	public static EcranX_ResumeEntree resumeEntree;
	public static EcranX_ResumeActions resumeAction;
	
	public static EcranX_Info infoEtape;
	
	public static Graph7 graph7;
	public static Ecran_import ecranImport;
	public static Ecran_Export ecranExport;
	
	public static PostIt postIt = new PostIt();
	


	public static void main(String[] args) throws Exception {
		
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		//fond.setOpaque(false);
		fenetre.setContentPane(fond);
		fond.add(panAccueil);
		fenetre.setVisible(true);
		panAccueil.lbl4.setVisible(true);
		
		//post it
		postIt.setLocation(190, 140);
		fond.add(postIt);
		postIt.setVisible(false);
		panAccueil.p.setSize((575 / 16), 20);
		pause();
		
		//Import de l'écran param du programme
		panAccueil.lbl4.setText("Chargement de l'écran option");
		param.setLocation(1, 1);
		fond.add(param);
		panAccueil.p.setSize((575 / 15), 20);
		pause();
		
		//Ecran des résumés
		panAccueil.lbl4.setText("Chargement de l'écran des résumés");
		resume = new Ecran(580, 730);
		resume.setLocation(650, 0);
		fond.add(resume);
		panAccueil.p.setSize((575 / 14), 20);
		pause();
		
		//Ecran choix des action
		panAccueil.lbl4.setText("Chargement de l'écran du choix des actions");
		fonction = new Ecran0_fonctions();
		panAccueil.setCapture(fonction);
		panAccueil.p.setSize((575 / 13), 20);
		pause();
		
		//Ecran Vissage
		vissage = new Ecran1_Vissage();
		panAccueil.setCapture(vissage);
		panAccueil.lbl4.setText("Chargement de l'écran Vissage");
		panAccueil.p.setSize((575 / 12), 20);
		pause();
		
		//Ecran Soudure
		soudure = new Ecran2_Soudure();
		panAccueil.setCapture(soudure);
		panAccueil.lbl4.setText("Chargement de l'écran Soudure");
		panAccueil.p.setSize((575 / 11), 20);
		pause();
		
		//Ecran Conso
		conso = new Ecran3_Conso();
		panAccueil.setCapture(conso);
		panAccueil.lbl4.setText("Chargement de l'écran Mesure consommation");
		panAccueil.p.setSize((575 / 10), 20);
		pause();
		
		//Ecran caméra
		camera = new Ecran4_Camera();
		panAccueil.setCapture(camera);
		panAccueil.lbl4.setText("Chargement de l'écran Contrôl caméra");
		panAccueil.p.setSize((575 / 9), 20);
		pause();
		
		//Ecran RFID
		rfid = new Ecran5_RFID();
		panAccueil.setCapture(rfid);
		panAccueil.lbl4.setText("Chargement de l'écran RFID");
		panAccueil.p.setSize((575 / 8), 20);
		pause();
		
		//Ecran des Sortie
		sortie = new Ecran6_Sortie();
		panAccueil.setCapture(sortie);
		resumeAction = new EcranX_ResumeActions();
		resumeAction.setLocation(30, 475);
		panAccueil.lbl4.setText("Chargement de l'écran Action");
		panAccueil.p.setSize((575 / 7), 20);
		pause();
		
		//Ecran PCB
		pcb = new Ecran7_PCB();
		panAccueil.setCapture(pcb);
		panAccueil.lbl4.setText("Chargement de l'écran Traçabilité PCB");
		panAccueil.p.setSize((575 / 6), 20);
		pause();
		
		//Ecran transition
		entree = new Entree();
		panAccueil.setCapture(entree);
		panAccueil.lbl4.setText("Chargement de l'écran Transition");
		resumeEntree = new EcranX_ResumeEntree();
		resumeEntree.setLocation(30, 30);
		panAccueil.p.setSize((575 / 5), 20);
		pause();
		
		//Ecran Param
		ecranParam = new Ecran0_Param();
		panAccueil.setCapture(ecranParam);
		panAccueil.lbl4.setText("Chargement de l'écran Paramètres");
		panAccueil.p.setSize((575 / 4), 20);
		pause();
		
		/*
		infoEtape = new EcranX_Info();
		infoEtape.setLocation(30, 30);
		infoEtape.setVisible(false);
		*/
		
		
		//Ecran grafcet
		graph7 = new Graph7();
		graph7.setVisible(false);
		fond.add(graph7);
		panAccueil.setCapture(graph7);
		panAccueil.lbl4.setText("Chargement de l'écran Grafcet");
		panAccueil.p.setSize((575 / 3), 20);
		pause();
		
		//Ecran importation
		ecranImport = new Ecran_import();
		panAccueil.setCapture(ecranImport);
		panAccueil.lbl4.setText("Chargement de l'écran Importation");
		panAccueil.p.setSize((570 / 2), 20);
		pause();
		
		//Ecran exportation
		ecranExport = new Ecran_Export();
		panAccueil.setCapture(ecranExport);
		panAccueil.lbl4.setText("Chargement de l'écran d'exportation");
		panAccueil.p.setSize((570 / 1), 20);
		pause();
		
		panAccueil.lbl4.setText("");
		
		panAccueil.p.setVisible(false);
		panAccueil.lbl5.setVisible(false);
		
		Ecran_Accueil.btNouveau.setVisible(true);
		Ecran_Accueil.btImport.setVisible(true);
		
		Ecran_Accueil.btIndus.setVisible(true);
		Ecran_Accueil.equipe.setVisible(false);
		
		
		Ecran_Accueil.btImport.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				fond.add(ecranImport);
				
				fond.remove(panAccueil);
				
				Principal.param.btNouveau.setEnabled(true);
				
				Principal.resume.setCouleurEcran2(Color.DARK_GRAY);
				Principal.resume.setCouleurEcran1(Color.DARK_GRAY);
				
				fenetre.setSize((650), 760);
				Principal.fenetre.setLocationRelativeTo(null);
				fond.repaint();
				
			}
			
		});
		
		Ecran_Accueil.btNouveau.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.programme.RAZ();
				
				fond.remove(panAccueil);
				
				Principal.param.btNouveau.setEnabled(true);
				Principal.param.btExport.setEnabled(true);
				Principal.param.btImport.setEnabled(true);
				
				Principal.resume.setCouleurEcran2(Color.DARK_GRAY);
				Principal.resume.setCouleurEcran1(Color.DARK_GRAY);
				
				fenetre.setSize((650), 760);
				Principal.fenetre.setLocationRelativeTo(null);
				fond.repaint();
				
				Principal.ecranExport.setVisible(false);
				Principal.ecranImport.setVisible(false);
				
				Principal.graph7.setVisible(true);
				Principal.fond.repaint();
				Principal.graph7.majAffichage();
				Principal.nom = "NEW";
				Principal.resume.add(Principal.resumeEntree);
				Principal.resume.add(Principal.resumeAction);
				
			}
			
		});
		
		
		
		
	}
	
	

	
	private static void pause(){
		try {
			Thread.sleep(1 * 0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void removeAll(){
		fond.remove(camera);
		fond.remove(conso);
		fond.remove(ecranParam);
		fond.remove(entree);
		fond.remove(fonction);
		fond.remove(pcb);
		fond.remove(rfid);
		fond.remove(vissage);
		fond.remove(soudure);
		fond.remove(sortie);
	}
	
	

}
