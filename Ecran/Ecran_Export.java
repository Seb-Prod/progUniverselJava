package Ecran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Elements.Bouton;
import Elements.BoutonIcon;
import Elements.Ecran;
import Elements.Label;
import Elements.MonJLabel;
import Elements.PanelChargeProg;
import Elements.Saisie;
import fr.ProgrammeUniversel.Principal;
//import fr.programme.universel.Interface;

public class Ecran_Export extends JPanel{

	/**
	 * Ecran d'exprtation du programme
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
	
	static //L'écran
	Ecran ecran = new Ecran(new Color(0, 70, 3));
	JPanel fond = new JPanel();
	
	//Listes des programmes
	PanelChargeProg prog[];
	JPanel page[];
	int nPage = 0;
	
	//Choix du répertoire
	JPanel panRep = new JPanel();
	//private File repertoire = new java.io.File(new java.io.File("").getAbsolutePath());
	JFileChooser chooser = new JFileChooser(); 
	
	//Labels
	Label lbl1 = new Label(580, 26, "Export du", Color.WHITE);
	Label lbl2 = new Label(580, 26, "PROGRAMME", Color.WHITE);
	Label lbl3 = new Label(580, 12, "" + Principal.repertoire, Color.BLACK);
	Label lbl5 = new Label(580, 20, "Nom du dossier d'exportation :", Color.WHITE);
	Label lbl6 = new Label(580, 18, "DANS LE REPERTOIRE :", Color.BLACK);
	static Label lbl7 = new Label(576, 20, "Exportation du programme terminé", Color.WHITE, Color.red, true);
	
	//Boutons
	BoutonIcon btRetour = new BoutonIcon(80, 80, "photo", "Retour au programme");
	BoutonIcon btRepertoire = new BoutonIcon(80, 80, "folder_full", "Changer de répertoire");
	Bouton bt = new Bouton("Exporter", 150, 40, new Color(11, 42, 22), new Color(11, 150, 22), 20);
	
	Saisie saisie2 = new Saisie("string", 3600, 22);
	String text = "";
	
	
	
	
	public Ecran_Export(){
		super();
		this.setSize(Principal.largeur, Principal.hauteur);
		this.setLocation(1, 210);
		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);
		
		//Bouton d'action
		ecran.ajout(btRetour, 5, 355);
		ecran.ajout(btRepertoire, 485, 355);

		
		//Label
		ecran.ajout(lbl1, 0, 5);
		ecran.ajout(lbl2, 0, 30);
		ecran.ajout(lbl6, 0, 60);
		ecran.ajout(lbl3, 0, 85);
		ecran.ajout(lbl5, 0, 130);
		ecran.ajout(lbl7, 2, 330);
		lbl7.setVisible(false);
		
		//Fond
		fond.setSize(580, 435);
		fond.setLayout(null);
		fond.setOpaque(false);
		fond.setLocation(30, 30);
		
		saisie2.setSize(150, 40);
		saisie2.setText(Principal.nom);
		ecran.ajout(saisie2, 110, 180);
		ecran.ajout(bt, 320, 180);
		
		//Initialisation de l'affichage
		ecran.add(fond);
		this.add(ecran);
		Principal.param.btImport.setEnabled(false);
		
		//Initialise le JFileChooser
		choixRep();
		
		//Listener des boutons d'action
		ActionBtRetour();
		ActionBtRepertoire();
		
		bt.addActionListener(new ActionListener(){
			

			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File(lbl3.getText() + "/" + saisie2.getText() + "/");
				if (f.exists()) {
					MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
							"<html>Voulez vous remplacer<br>le programme : <br>" + saisie2.getText()+ " ?</html>", true, 
							"/font/Hack-Regular.ttf", 30);
					ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "folder_edit" + ".png"));
					
					int option = JOptionPane.showConfirmDialog(null, lbl, 
							"Validation enregistrement", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

					//Si oui
					if(option == 0){
						exporte();
						lbl7.setVisible(true);
					}
				}else{
					File dir = new File (lbl3.getText() + "/" + saisie2.getText());
					dir.mkdirs();
					exporte();
					lbl7.setVisible(true);
					
				}
				
				Principal.ecranImport.recharge();
				
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Exportation terminé</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "folder_edit" + ".png"));
				JOptionPane.showMessageDialog(null, lbl, 
						"Exportation", JOptionPane.OK_OPTION, img);
				
				Principal.fond.remove(Principal.ecranExport);
				Principal.graph7.setVisible(true);
				Principal.param.btImport.setEnabled(true);
				Principal.param.btExport.setEnabled(true);
				Principal.param.btNouveau.setEnabled(true);
				Principal.fond.repaint();
			}
		});
		
		initAffichage();
		
	}
	
	public void getNom(){
		saisie2.setText(Principal.nom);
	}
	

	

	
	private void exporte(){
		String fich = saisie2.getText();
		final String chemin = lbl3.getText() + "/" + fich + "/";
		int index = 0;
		byte[] tab2 = new byte[1204];
		
		
		for (int y = 1; y < 5; y++) {
			for (int i = index; i < index + 1204; i++) {
				int valeur = Principal.programme.getValeur(i);
				tab2[i - index] = (byte) valeur;
				
			}

			try {
				// On écrit le password crypté et la variable
				// isPwdCrypted dans le fichier Config.txt
				@SuppressWarnings("resource")
				FileOutputStream fout = new FileOutputStream(new File(chemin + y + ".BIN"));
				fout.write(tab2);
			} catch (FileNotFoundException ex) {
				
			} catch (IOException ex) {
				System.out.println("Erreur lors de l'écriture dans le fichier");
			}

			index = index + 1204;
		}
		
		
	}
	
	private void ActionBtRetour(){
		btRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.remove(Principal.ecranExport);
				Principal.graph7.setVisible(true);
				Principal.param.btImport.setEnabled(true);
				Principal.param.btExport.setEnabled(true);
				Principal.param.btNouveau.setEnabled(true);
				Principal.fond.repaint();
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
				
				
				//Change la couleur des labels
				lbl1.setForeground(Color.BLACK);
				lbl2.setForeground(Color.BLACK);
				lbl3.setForeground(Color.BLACK);	
				lbl5.setVisible(false);
				btRepertoire.setVisible(false);
				btRepertoire.setVisible(false);
				bt.setVisible(false);
				saisie2.setVisible(false);
			}
		});
	}
		
	private void choixRep(){
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choisir le répertoire de destination");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    //Si clik sur bouton annulation ou validation
	    chooser.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Si répertoire choisie
				if (e.getActionCommand().equals("ApproveSelection")){
					
					//Charge les programmes trouvé dans le répertoire séléctioné
					Principal.repertoire = chooser.getSelectedFile();
					
					
					//Initialisation de l'affichage
					initAffichage();
			    }
				//Si annulation 
				if (e.getActionCommand().equals("CancelSelection")){
					//Initialisation de l'affichage
					initAffichage();
			    }
			}
	    });
	    
	    
	    
	    //Paramètres
	    chooser.setLocation(33, 90);
	    chooser.setSize(575, 300);
	    ecran.add(chooser);
	    chooser.setVisible(false);
	}
	
	public void initAffichage(){
		chooser.setVisible(false);
		fond.setVisible(true);
		lbl3.setText("" + Principal.repertoire);
		lbl3.setVisible(true);
		lbl1.setForeground(Color.WHITE);
		lbl2.setVisible(true);
		ecran.C = new Color(0, 70, 3);
		btRepertoire.setVisible(true);
		bt.setVisible(true);
		saisie2.setVisible(true);
		lbl5.setVisible(true);
		lbl7.setVisible(false);
		
	}
	


}
