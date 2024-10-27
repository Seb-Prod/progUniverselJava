package Ecran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import Elements.BoutonIcon;
import Elements.Ecran;
import Elements.Label;
import Elements.PanelChargeProg;
import fr.ProgrammeUniversel.Chargement;
import fr.ProgrammeUniversel.Principal;

public class Ecran_import extends JPanel{

	/**
	 * Ecran du choix du programme à importer avec utilisation d'un FileChosser
	 * 
	 * @see Ecran
	 * @see PanelChargeProg
	 * @see Label
	 * @see BoutonIcon
	 * 
	 *
	 * @Bug :
	 * 
	 * @author sebastien Drillaud
	 * @création 24 janvier 2019
	 * @version 1.1 du 25 janvier 2019
	 * Corection du bug du nom chargement de certain programme
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	//L'écran
	Ecran ecran = new Ecran(new Color(179, 0, 0));
	JPanel fond = new JPanel();
	
	//Listes des programmes
	PanelChargeProg prog[];
	JPanel page[];
	private Chargement test;
	int nPage = 0;
	
	//Choix du répertoire
	JPanel panRep = new JPanel();
	//private File repertoire = new java.io.File(new java.io.File("").getAbsolutePath());
	JFileChooser chooser = new JFileChooser(); 
	
	//Labels
	Label lbl1 = new Label(580, 26, "LISTE DES", Color.WHITE);
	Label lbl2 = new Label(580, 26, "PROGRAMMES", Color.WHITE);
	Label lbl3 = new Label(580, 12, "" + Principal.repertoire, Color.BLACK);
	Label lbl4 = new Label(580, 20, "0 Programme", Color.WHITE);
	Label lbl5 = new Label(580, 20, "PAGE 1/1", Color.WHITE);
	Label lbl6 = new Label(580, 18, "DANS LE REPERTOIRE :", Color.BLACK);
	
	//Boutons
	BoutonIcon btRetour = new BoutonIcon(80, 80, "photo", "Retour au programme");
	BoutonIcon btGauche = new BoutonIcon(60, 60, "arrow_left", "Page précédente");
	BoutonIcon btDroit = new BoutonIcon(60, 60, "arrow_right", "Page suivante");
	BoutonIcon btRepertoire = new BoutonIcon(80, 80, "folder_full", "Changer de répertoire");

	
	
	public Ecran_import(){
		super();
		this.setSize(Principal.largeur, Principal.hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);
		
		//Bouton d'action
		ecran.ajout(btRetour, 5, 355);
		ecran.ajout(btRepertoire, 485, 355);
		ecran.ajout(btGauche, 5, 5);
		ecran.ajout(btDroit, 515, 5);
		btGauche.setVisible(false);
		btDroit.setVisible(false);
		
		//Label
		ecran.ajout(lbl1, 0, 5);
		ecran.ajout(lbl2, 0, 30);
		ecran.ajout(lbl6, 0, 60);
		ecran.ajout(lbl3, 0, 85);
		ecran.ajout(lbl4, 0, 370);
		ecran.ajout(lbl5, 0, 395);

		//Fond
		fond.setSize(580, 435);
		fond.setLayout(null);
		fond.setOpaque(false);
		fond.setLocation(30, 30);
		
		//Initialisation de l'affichage
		ecran.add(fond);
		this.add(ecran);
		btRetour.setVisible(false);
		Principal.param.btImport.setEnabled(false);
		//Charge les programmes du répertoire courant
		ajoutList(Principal.repertoire);
		
		//Initialise le JFileChooser
		choixRep();
		
		//Listener des boutons d'action
		ActionBtRetour();
		ActionBtDroit();
		ActionBtGauche();
		ActionBtRepertoire();
	}
	
	private void ActionBtRetour(){
		btRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.remove(Principal.ecranImport);
				Principal.graph7.setVisible(true);
				Principal.param.btImport.setEnabled(true);
				Principal.param.btExport.setEnabled(true);
				Principal.param.btNouveau.setEnabled(true);
				Principal.fond.repaint();
			}
		});
	}
	
	private void ActionBtDroit(){
		btDroit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nPage >= 0 && nPage < page.length - 1){
					page[nPage].setVisible(false);
					page[nPage + 1].setVisible(true);
					nPage = nPage + 1;
					lbl5.setText("Page " + (nPage + 1) + "/" + page.length);
					if(nPage == page.length - 1){
						btDroit.setVisible(false);
					}
					btGauche.setVisible(true);
				}
			}
		});
	}
	
	private void ActionBtGauche(){
		btGauche.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nPage >= 1){
					page[nPage].setVisible(false);
					page[nPage - 1].setVisible(true);
					nPage = nPage - 1;
					lbl5.setText("Page " + (nPage + 1) + "/" + page.length);
					if(nPage == 0){
						btGauche.setVisible(false);
					}
					btDroit.setVisible(true);
				}
			}
		});
	}
	
	private void ActionBtRepertoire(){
		btRepertoire.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				fond.setVisible(false);
				chooser.setVisible(true);
				lbl3.setVisible(false);
				lbl6.setVisible(false);
				
				ecran.C = new Color(214, 217, 223);
				
				//Déplace les boutons pour les cacher
				btDroit.setLocation(1000, 1000);
				btGauche.setLocation(1000, 1000);
				btRetour.setLocation(1000, 1000);
				btRepertoire.setLocation(1000, 1000);
				
				//Change la couleur des labels
				lbl1.setForeground(Color.BLACK);
				lbl2.setForeground(Color.BLACK);
				lbl3.setForeground(Color.BLACK);
				lbl4.setForeground(Color.BLACK);
				lbl5.setForeground(Color.BLACK);
				lbl5.setText(Principal.repertoire + "");		
			}
		});
	}
	
	public void recharge(){
		//Raz les programmes truvé
		prog = null;
		page = null;
		fond.removeAll();
		
		//Charge les programmes trouvé dans le répertoire séléctioné
		ajoutList(Principal.repertoire);
		
		//Initialisation de l'affichage
		chooser.setVisible(false);
		fond.setVisible(true);
		ecran.ajout(btRetour, 5, 355);
		btDroit.setLocation(545, 35);
		btGauche.setLocation(35, 35);
		btRetour.setLocation(35, 385);
		btRepertoire.setLocation(515, 385);
		lbl1.setForeground(Color.WHITE);
		lbl2.setForeground(Color.WHITE);
		lbl3.setForeground(Color.WHITE);
		lbl4.setForeground(Color.WHITE);
		lbl5.setForeground(Color.WHITE);
		if(page.length > 0){
			lbl5.setText("Page 1/" + (page.length));
		}else{
			lbl5.setText("");
		}
		lbl3.setText("" + Principal.repertoire);
		lbl3.setVisible(true);
		ecran.C = new Color(179, 0, 0);
	}
		
	private void choixRep(){
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choisir le répertoire où se trouve les programme");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    //Si clik sur bouton annulation ou validation
	    chooser.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Si répertoire choisie
				if (e.getActionCommand().equals("ApproveSelection")){
					//Raz les programmes truvé
					prog = null;
					page = null;
					fond.removeAll();
					
					//Charge les programmes trouvé dans le répertoire séléctioné
					Principal.repertoire = chooser.getSelectedFile();
					ajoutList(Principal.repertoire);
					
					//Initialisation de l'affichage
					chooser.setVisible(false);
					fond.setVisible(true);
					ecran.ajout(btRetour, 5, 355);
					btDroit.setLocation(545, 35);
					btGauche.setLocation(35, 35);
					btRetour.setLocation(35, 385);
					btRepertoire.setLocation(515, 385);
					lbl1.setForeground(Color.WHITE);
					lbl2.setForeground(Color.WHITE);
					lbl3.setForeground(Color.WHITE);
					lbl4.setForeground(Color.WHITE);
					lbl5.setForeground(Color.WHITE);
					if(page.length > 0){
						lbl5.setText("Page 1/" + (page.length));
					}else{
						lbl5.setText("");
					}
					lbl3.setText("" + Principal.repertoire);
					lbl3.setVisible(true);
					ecran.C = new Color(179, 0, 0);
			    }
				//Si annulation 
				if (e.getActionCommand().equals("CancelSelection")){
					//Initialisation de l'affichage
					chooser.setVisible(false);
					fond.setVisible(true);
					ecran.ajout(btRetour, 5, 355);
					btDroit.setLocation(545, 35);
					btGauche.setLocation(35, 35);
					btRetour.setLocation(35, 385);
					btRepertoire.setLocation(515, 385);
					lbl1.setForeground(Color.WHITE);
					lbl2.setForeground(Color.WHITE);
					lbl3.setForeground(Color.WHITE);
					lbl4.setForeground(Color.WHITE);
					lbl5.setForeground(Color.WHITE);
					if(page.length > 0){
						lbl5.setText("Page 1/" + (page.length));
					}else{
						lbl5.setText("");
					}
					lbl3.setText("" + Principal.repertoire);
					ecran.C = new Color(179, 0, 0);
			    }
			}
	    });
	    
	    //Quand clik sur un répertoire
	    chooser.addPropertyChangeListener(new PropertyChangeListener(){
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("SelectedFileChangedProperty"))
			    {
					apercusList(chooser.getSelectedFile());
			    }
			}
	    });
	    
	    //Paramètres
	    chooser.setLocation(31, 90);
	    chooser.setSize(579, 300);
	    ecran.add(chooser);
	    chooser.setVisible(false);
	}
	
	private void apercusList(File dir) {
		File[] files = dir.listFiles();
		int nb = 0;
		for (File file : files) {
			
		    if (file.isDirectory()) {
		    	File f = new File(file.getName() + "/4.bin");
		    	//Si le fichier exite on l'ajoute au compteur
				if (f.exists()){
					test = new Chargement(file.getName() + "/");
					nb = nb + 1;
				}
		    }
		}
		
		//Si au moin un programme est trouvé on affiche le compteur
		if(nb > 1){
			lbl4.setText(nb + " programmes de trouvé dans :");
		}
		
		//Si aucun programme de trouvé on affiche un messahe
		else{
			lbl4.setText("Aucun programme de trouvé dans :");
		}
		
		//Affiche le nom du répertoire sélectioné
		lbl5.setText(dir + "");
	}
	
	private void ajoutList(File dir) {
		File[] files = dir.listFiles();
		int nb = 0;
		for (File file : files) {
		    if (file.isDirectory()) {
		    	File f = new File(Principal.repertoire + "/" + file.getName() + "/4.bin");
		    	//Si le programme 4.BIN existe on le compte
				if (f.exists()){
					test = new Chargement(Principal.repertoire + "/" + file.getName() + "/");
					nb = nb + 1;
				}
		    }
		}
		
		//Initialisation du nombre de programme trouvé
		prog = new PanelChargeProg[nb];
		
		//Initialisation du nonbre de page à créer
		int nbPage = nb / 7;
		if(nb % 7 >0){
			nbPage = nbPage + 1;
		}
		page = new JPanel[nbPage];
		
		//Création des pages
		for(int i = 0 ; i < nbPage ; i++){
			page[i] = new JPanel();
			page[i].setSize(580, 435);
			page[i].setLayout(null);
			page[i].setOpaque(false);
			page[i].setVisible(false);
			page[i].setLocation(0, 0);
			fond.add(page[i]);
		}
		
		
		int i = 0; //Num du programme
		int x = 0; //Position X
		int y = 110; //Position Y
		int n = 0; //Compteur de programme par page (7)
		int p = 0; //Num de la page
				
		for (File file : files) {
		    if (file.isDirectory()) {
		    	File f = new File(Principal.repertoire + "/" + file.getName() + "/4.bin");
		    	//Si le fichier 4.BIN exsite on ajoute le programme à la liste
				if (f.exists()){
					//Charge le programme pour récupérer son nom
					test = new Chargement(Principal.repertoire + "/" + file.getName() + "/");
					//Ajoute le programme à la liste
					prog[i] = new PanelChargeProg(test.GetLibelleProgramme(), file.getName());
					//Position X et Y;
					prog[i].setLocation(x, y);
					//Ajout du programme à la page
					page[p].add(prog[i]);
					//Maj des compteurs
					n = n + 1;
					i = i + 1;
					y = y + 35;
					//Si page complette on passe à la suivante et on remet le compteur à 0 ainsi que la position X
					if(n == 7){
						p = p + 1;
						y = 110;
						n = 0;
					}
				}
		    }
		}
		
		/*Initialisation de l'affichage*/
		
		//Affiche le nom di répertoire
		lbl3.setText(Principal.repertoire + "");
		
		//Cache les boutons gauche et droit
		btDroit.setVisible(false);
		btGauche.setVisible(false);
		
		//Si au moin une page est crée
		if(page.length > 0){
			//Affiche la premire page
			page[0].setVisible(true);
			//Comme il y a au moin un programme l'icone est 'folder_full'
			btRepertoire.changeIcon("folder_full");
			//Affiche le nombre de programme trouvé
			if(prog.length > 1){
				lbl4.setText(prog.length + " programmes de trouvé");
			}else{
				lbl4.setText(prog.length + " programme de trouvé");
			}
			//Affiche le nombre de page
			lbl5.setText("Page 1/" + page.length);
		}
		//Si aucun programme de trouvé
		else{
			//Comme il n'y a aucun programme de trouvé l'icone est 'folder_deny'
			btRepertoire.changeIcon("folder_deny");
			//Message comme quoi il n'y a aucun programme
			lbl4.setText("Aucun programme");
			lbl5.setText("dans ce répertoire");
		}
		
		//Si plus d'une page affiche le bouton Droit
		if(page.length > 1){
			btDroit.setVisible(true);
		}
		
		//Actualise l'affichage
		this.repaint();
		nPage = 0;
	}
}
