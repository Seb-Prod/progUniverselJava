package Ecran;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Elements.BoutonIcon;
import Elements.Label;
import Elements.LabelFissure;
import Elements.LabelLettre;
import Elements.LabelTft;
import Elements.LabelVis;
import Elements.ModuleElec;
import Elements.ModulePneu;
import Elements.MonJLabel;
import Impression.Impression;
import fr.ProgrammeUniversel.PoidBouton;
import fr.ProgrammeUniversel.Principal;

public class Ecran_Param extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoutonIcon btImport = new BoutonIcon(100, 100, "folder_download", "Importer un programme");
	public BoutonIcon btExport = new BoutonIcon(100, 100, "folder_edit", "Enregister le programme");
	public BoutonIcon btNouveau = new BoutonIcon(100, 100, "folder_add", "Nouveau programme");
	public BoutonIcon btImprime = new BoutonIcon(100, 100, "printer", "Imprimer Grafcet");
	BoutonIcon btZoom = new BoutonIcon(100, 100, "photo_zoom_in", "Vue global du programme");
	
	public ModulePneu modulePneu[] = new ModulePneu[6];
	public ModuleElec moduleElec[] = new ModuleElec[6];
	
	Label lblPneu[] = new Label[6];
	Label lblElec[] = new Label[6];
	
	Image image;
	Image image2;
	boolean zoom = false;
	public JPanel page[] = new JPanel[3];
	LabelLettre lblAction[] = new LabelLettre[22];
	Color couleur = Color.GRAY;
	Label lblInfo = new Label(560, 20, "", Color.WHITE, Color.WHITE, false);
	Label lblTitre = new Label(560, 30, "", Color.WHITE);
	Label lblMini = new Label(100, 20, "", new Color(121, 248, 248), Color.WHITE, false);
	Label lblMaxi = new Label(100, 20, "", Color.RED, Color.WHITE, false);
	Label lblMiniTxt = new Label(100, 20, "", new Color(121, 248, 248), Color.WHITE, false);
	Label lblMaxiTxt = new Label(100, 20, "", Color.RED, Color.WHITE, false);
	
	
	public Ecran_Param(){
		super();
		this.setSize(645, 205);
		this.setLayout(null);
		this.setOpaque(false);
		LabelTft tft = new LabelTft(588, 120);
		tft.setLocation(30, 45);
		this.add(tft);
		for(int i = 0 ; i < 3 ; i++){
			page[i] = new JPanel();
			page[i].setSize(645, 205);
			page[i].setLayout(null);
			page[i].setOpaque(false);
			page[i].setVisible(false);
			page[i].setLocation(0, 0);
			this.add(page[i]);
		}
		
		
		ImageIcon iconTmps = new ImageIcon(getClass().getResource("/img/texture.png"));
		ImageIcon icon = new ImageIcon(iconTmps.getImage().getScaledInstance(640, 200, java.awt.Image.SCALE_SMOOTH));
		image = icon.getImage();
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/img/fisure.png"));
		image2 = icon2.getImage();
		//buffered = (BufferedImage) image;
		
		LabelVis vis1 = new LabelVis();
		LabelVis vis2 = new LabelVis();
		LabelVis vis3 = new LabelVis();
		LabelVis vis4 = new LabelVis();
		
		LabelFissure fissure = new LabelFissure();
		fissure.setLocation(390, 50);
		
		
		
		vis1.setLocation(3, 3);
		vis2.setLocation(608, 3);
		vis3.setLocation(3, 168);
		vis4.setLocation(608, 168);
		
		this.add(vis1);
		this.add(vis2);
		this.add(vis3);
		this.add(vis4);
		
		
		Label lbl = new Label(645, 30, "Editeur Progragamme Universel", Color.GRAY.darker());
		lbl.setLocation(0, 5);
		this.add(lbl);
		
		
		
		lblInfo.setLocation(40, 120);
		lblTitre.setLocation(40,  50);
		lblMini.setLocation(100, 110);
		lblMaxi.setLocation(440,  110);
		lblMiniTxt.setLocation(100, 130);
		lblMaxiTxt.setLocation(440,  130);
		
		page[1].add(lblInfo);
		page[1].add(lblTitre);
		page[1].add(lblMini);
		page[1].add(lblMaxi);
		page[1].add(lblMiniTxt);
		page[1].add(lblMaxiTxt);
		
		btImport.setLocation(35, 60);
		page[0].add(btImport);
		btExport.setLocation(150, 60);
		page[0].add(btExport);
		btNouveau.setLocation(265, 60);
		page[0].add(btNouveau);
		btImprime.setLocation(380, 60);
		page[0].add(btImprime);
		btZoom.setLocation(500, 60);
		page[0].add(btZoom);
		page[0].setVisible(true);
		AjoutModule();
		
		
		int x = 35;
		for(int i = 0 ; i < 22 ; i++){
			lblAction[i] = new LabelLettre(25, 10, Color.red);
			lblAction[i].setLocation(x, 85);
			page[1].add(lblAction[i]);
			x = x + 26;
		}
		
		
		
		btImport.setEnabled(false);
		btExport.setEnabled(false);
		btNouveau.setEnabled(false);
		zoom();
		importer();
		exporter();
		nouveau();
		impression();
		
		
		
		this.add(fissure);
	}
	
	public void afficheInfoCodeAction(String t){
		page[0].setVisible(false);
		page[1].setVisible(true);
		page[2].setVisible(false);
		couleur = new Color(2, 63, 64);
		lblTitre.setText(t);
	}
	
	public void afficheParamProg(){
		page[0].setVisible(true);
		page[1].setVisible(false);
		page[2].setVisible(false);
		couleur = Color.DARK_GRAY;
	}
	
	public void afficheMouleSortie(){
		page[0].setVisible(false);
		page[1].setVisible(false);
		page[2].setVisible(true);
		couleur = new Color(0, 187, 210);
		MajTextModule();
	}
	
	
	
	public void impression(){
		btImprime.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Voulez imprimmer<br>le Grafcet ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "printer" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Impression", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					Impression page[] = new Impression[3];
					for(int i = 0 ; i < 3 ; i++){
						page[i] = new Impression(i);
					}
					print(page);
					
					
					
				}
				
				
			}
			
		});
	}
	
  

	public void print(final JPanel[] p) {
		PrinterJob printjob = PrinterJob.getPrinterJob();
		printjob.setJobName("Grafcet " + Principal.programme.GetLibelleProgramme());
		
		Printable printable = new Printable() {
			@Override
			public int print(Graphics pg, PageFormat pf, int pageNum) {
				if (pageNum < p.length) {
					
					Dimension size = p[pageNum].getSize();
					BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
					p[pageNum].print(bufferedImage.getGraphics());
					Graphics2D g2 = (Graphics2D) pg;
					g2.translate(pf.getImageableX(), pf.getImageableY());
					g2.drawImage(bufferedImage, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);
    				return PAGE_EXISTS;
    				}else{
    					return NO_SUCH_PAGE;
    				}
    			}
    		};

    		Paper paper = new Paper();
    		//paper.setImageableArea(0, 0, 1654, 2339);
    		paper.setImageableArea(0, 0, 596, 842);
    		paper.setSize(596, 842);

    		PageFormat format = new PageFormat();
    		format.setPaper(paper);
    		format.setOrientation(PageFormat.PORTRAIT);
    		
    		
    		printjob.setPrintable(printable, format);
    		if (printjob.printDialog() == false)
    			return;

    		try {
    			printjob.print();
    		} catch (PrinterException ex) {
    			System.out.println("NO PAGE FOUND." + ex);

    		}
	}
	
	public void setDataAction(int index){
		for(int i = 0 ; i < 22 ; i++){
			lblAction[i].setText(Principal.programme.getValeur(index + i) + "");
		}
	}
	
	private void zoom(){
		btZoom.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(zoom == false){
					Principal.fenetre.setSize((645 * 2) + 10 - 60, 760);
					Principal.fenetre.setLocationRelativeTo(null);
					zoom = true;
					btZoom.changeIcon("photo_zoom_out");
				}else{
					Principal.fenetre.setSize((650), 760);
					Principal.fenetre.setLocationRelativeTo(null);
					zoom = false;
					btZoom.changeIcon("photo_zoom_in");
				}
				
			}
			
		});
		
	}
	
	private void importer(){
		btImport.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.add(Principal.ecranImport);
				Principal.ecranImport.btRetour.setVisible(true);
				Principal.removeAll();
				btImport.setEnabled(false);
				btExport.setEnabled(false);
				btNouveau.setEnabled(false);
				Principal.graph7.setVisible(false);
				Principal.fond.repaint();
				Principal.ecranImport.setVisible(true);
				
			}
			
		});
	}
	
	private void exporter(){
		btExport.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.fond.add(Principal.ecranExport);
				Principal.ecranExport.getNom();
				Principal.ecranExport.initAffichage();
				Principal.removeAll();
				btImport.setEnabled(false);
				btExport.setEnabled(false);
				btNouveau.setEnabled(false);
				Principal.graph7.setVisible(false);
				Principal.fond.repaint();
				Principal.ecranExport.setVisible(true);
				
			}
			
		});
	}
	
	private void nouveau(){
		btNouveau.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				MonJLabel lbl = new MonJLabel(0, 0, Color.BLACK, 
						"<html>Voulez vous créer<br>un nouveau programme ?</html>", true, 
						"/font/Hack-Regular.ttf", 30);
				ImageIcon img = new ImageIcon(getClass().getResource("/img/" + "folder_add" + ".png"));
				int option = JOptionPane.showConfirmDialog(null, lbl, 
						"Nouveau programme", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, img);

				//Si oui
				if(option == 0){
					Principal.programme.RAZ();
					
					btImport.setEnabled(true);
					btExport.setEnabled(true);
					btNouveau.setEnabled(true);
					Principal.ecranExport.setVisible(false);
					Principal.ecranImport.setVisible(false);
					Principal.graph7.setVisible(true);
					Principal.fond.repaint();
					Principal.graph7.majAffichage();
					Principal.nom = "NEW";
					Principal.resume.add(Principal.resumeEntree);
					Principal.resume.add(Principal.resumeAction);
				}
				
				
			}
			
		});
	}
	
	public void razCouleurInfo(){
		for(int i = 0 ; i < 22 ; i++){
			lblAction[i].changeCouleur(Color.GRAY);
			lblInfo.setText("");
			lblMiniTxt.setText("");
			lblMaxiTxt.setText("");
			lblMini.setText("");
			lblMaxi.setText("");
		}
		this.repaint();
	}
	
	public void changeCouleur(int index, int nb, String t){
		for(int i = index ; i < index + nb ; i++){
			lblAction[i].changeCouleur(Color.ORANGE);
			lblInfo.setText(t);
			lblMiniTxt.setText("");
			lblMaxiTxt.setText("");
			lblMini.setText("");
			lblMaxi.setText("");
		}
		this.repaint();
	}
	
	public void changeCouleur(int index, int nb, String t, String min, String max){
		for(int i = index ; i < index + nb ; i++){
			lblAction[i].changeCouleur(Color.ORANGE);
			lblInfo.setText(t);
			lblMiniTxt.setText(min);
			lblMaxiTxt.setText(max);
			lblMini.setText("Mini.");
			lblMaxi.setText("Maxi.");
		}
		this.repaint();
	}
	
	public void AjoutModule(){
		int x = 35;
		for(int i = 0 ; i < 6 ; i++){
			lblPneu[i] = new Label(44, 14, ((char) (65 + i)) + "", Color.WHITE);
			modulePneu[i] = new ModulePneu();
			modulePneu[i].setLocation(x, 60);
			lblPneu[i].setLocation(x, 45);
			x = x + 47;
			page[2].add(modulePneu[i]);
			page[2].add(lblPneu[i]);
		}
		x = x + 10;
		for(int i = 0 ; i < 6 ; i++){
			lblElec[i] = new Label(44, 14, ((char) (65 + i)) + "", Color.WHITE);
			moduleElec[i] = new ModuleElec();
			moduleElec[i].setLocation(x, 60);
			lblElec[i].setLocation(x, 45);
			x = x + 46;
			page[2].add(moduleElec[i]);
			page[2].add(lblElec[i]);
		}
		
		//Module A pin éléect
		
		moduleElec[0].setTexte(1, "+24V", "", "Bornier X03 - Borne 1", "fil 51");
		moduleElec[0].setTexte(2, "+24V", "", "Bornier X03 - Borne 2", "fil 52");
		moduleElec[0].setTexte(3, "+24V", "", "Bornier X03 - Borne 3", "fil 53");
		moduleElec[0].setTexte(4, "+24V", "", "Bornier X03 - Borne 4", "fil 54");
		moduleElec[0].setTexte(5, "0V", "", "Bornier X03 - Borne 5", "fil 54");
		moduleElec[0].setTexte(6, "0V", "", "Bornier X03 - Borne 6", "fil 56");
		moduleElec[0].setTexte(7, "0V", "", "Bornier X03 - Borne 7", "fil 57");
		moduleElec[0].setTexte(8, "0V", "", "Bornier X03 - Borne 8", "fil 58");
		moduleElec[0].setTexte(9, "E1.2", "Codage 1", "Bornier X03 - Borne 9", "fil 59");
		moduleElec[0].setTexte(10, "E1.3", "Codage 2", "Bornier X03 - Borne 10", "fil 60");
		moduleElec[0].setTexte(11, "E1.4", "Codage 3", "Bornier X03 - Borne 11", "fil 61");
		moduleElec[0].setTexte(12, "E1.5", "Codage 4", "Bornier X03 - Borne 12", "fil 62");
		
		//Module C pin éléect
		moduleElec[2].setTexte(1, "E0.5", "Caméra 1 OUT : OK", "Bornier X03 - Borne 25", "fil 75");
		moduleElec[2].setTexte(2, "E0.6", "Caméra 1 OUT : ENABLE", "Bornier X03 - Borne 26", "fil 76");
		moduleElec[2].setTexte(3, "E0.7", "Caméra 1 OUT : ERROR", "Bornier X03 - Borne 27", "fil 77");
		moduleElec[2].setTexte(4, "A0.5", "Caméra 1 IN : TEACH", "Bornier X03 - Borne 28", "fil 78");
		moduleElec[2].setTexte(5, "A0.6", "Caméra 1 IN : TRIGGER", "Bornier X03 - Borne 29", "fil 79");
		moduleElec[2].setTexte(6, "A0.7", "Caméra 1 IN : BANK 1", "Bornier X03 - Borne 30", "fil 80");
		moduleElec[2].setTexte(7, "A1.0", "Caméra 1 IN : BANK 2", "Bornier X03 - Borne 31", "fil 81");
		moduleElec[2].setTexte(8, "A1.1", "Caméra 1 IN : BANK 2", "Bornier X03 - Borne 32", "fil 82");

		
		//Module D pin éléect

		moduleElec[3].setTexte(9, "Relais", "Ctrl conso 1 (Recul)", "Bornier X03 - Borne 45", "fil 95");
		moduleElec[3].setTexte(10, "Relais", "Ctrl conso 1 (Recul)", "Bornier X03 - Borne 46", "fil 96");
		moduleElec[3].setTexte(11, "Relais",  "Ctrl conso 2 (Lanterne)", "Bornier X03 - Borne 47", "fil 97");
		moduleElec[3].setTexte(12, "Relais", "Ctrl conso 2 (Lanterne)", "Bornier X03 - Borne 48", "fil 98");

		//Module E pin éléect
		moduleElec[4].setTexte(1, "Relais", "Ctrl conso 3 (Stop)", "Bornier X03 - Borne 49", "fil 99");
		moduleElec[4].setTexte(2, "Relais", "Ctrl conso 3 (Stop)", "Bornier X03 - Borne 50", "fil 100");
		moduleElec[4].setTexte(3, "Profinet", "RFID 1", "Bornier X03 - Borne 51", "fil 101");
		moduleElec[4].setTexte(4, "Profinet", "RFID 1", "Bornier X03 - Borne 52", "fil 102");
		moduleElec[4].setTexte(5, "Profinet", "RFID 1", "Bornier X03 - Borne 53", "fil 103");
		moduleElec[4].setTexte(6, "Profinet", "RFID 1", "Bornier X03 - Borne 54", "fil 104");
		moduleElec[4].setTexte(7, "Profinet", "RFID 1", "Bornier X03 - Borne 55", "fil 105");
		moduleElec[4].setTexte(8, "Profinet", "RFID 2", "Bornier X03 - Borne 56", "fil 106");
		moduleElec[4].setTexte(9, "Profinet", "RFID 2", "Bornier X03 - Borne 57", "fil 107");
		moduleElec[4].setTexte(10, "Profinet", "RFID 2", "Bornier X03 - Borne 58", "fil 108");
		moduleElec[4].setTexte(11, "Profinet", "RFID 2", "Bornier X03 - Borne 59", "fil 109");
		moduleElec[4].setTexte(12, "Profinet", "RFID 2", "Bornier X03 - Borne 60", "fil 110");
		
		//Module F pin éléect
		moduleElec[5].setTexte(1, "Relais", "Ctrl conso 4 (Clignotant)", "Bornier X03 - Borne 61", "fil 111");
		moduleElec[5].setTexte(2, "Relais", "Ctrl conso 4 (Clignotant)", "Bornier X03 - Borne 62", "fil 112");
		moduleElec[5].setTexte(3, "Relais", "Ctrl Conso 5 (Autre)", "Bornier X03 - Borne 63", "fil 113");
		moduleElec[5].setTexte(4, "Relais", "Ctrl Conso 5 (Autre)", "Bornier X03 - Borne 64", "fil 114");
		moduleElec[5].setTexte(5, "E5.5", "Caméra 2 OUT : OK", "Bornier X03 - Borne 65", "fil 115");
		moduleElec[5].setTexte(6, "E5.6", "Caméra 2 OUT : ENABLE", "Bornier X03 - Borne 66", "fil 116");
		moduleElec[5].setTexte(7, "E5.7", "Caméra 2 OUT : ERROR", "Bornier X03 - Borne 67", "fil 117");
		moduleElec[5].setTexte(8, "A5.0", "Caméra 2 IN : TEACH", "Bornier X03 - Borne 68", "fil 118");
		moduleElec[5].setTexte(9, "A5.1", "Caméra 2 IN : TRIGGER", "Bornier X03 - Borne 69", "fil 119");
		moduleElec[5].setTexte(10, "A5.2", "Caméra 2 IN : BANK 1", "Bornier X03 - Borne 70", "fil 120");
		moduleElec[5].setTexte(11, "A5.3", "Caméra 2 IN : BANK 2", "Bornier X03 - Borne 71", "fil 121");
		moduleElec[5].setTexte(12, "A5.4", "Caméra 2 IN : BANK 2", "Bornier X03 - Borne 72", "fil 122");
		
		
	}
	
	public void MajTextModule(){
		//Module B pin éléc
		moduleElec[1].setTexte(1, "E2.0", Principal.programme.GetLibelleSortie(0), "Bornier X03 - Borne 13", "fil 63");
		moduleElec[1].setTexte(2, "E2.1", Principal.programme.GetLibelleSortie(20), "Bornier X03 - Borne 14", "fil 64");
		moduleElec[1].setTexte(3, "E2.2", Principal.programme.GetLibelleSortie(40), "Bornier X03 - Borne 15", "fil 65");
		moduleElec[1].setTexte(4, "E2.3", Principal.programme.GetLibelleSortie(60), "Bornier X03 - Borne 16", "fil 66");
		moduleElec[1].setTexte(5, "E2.4", Principal.programme.GetLibelleSortie(80), "Bornier X03 - Borne 17", "fil 67");
		moduleElec[1].setTexte(6, "E2.5", Principal.programme.GetLibelleSortie(100), "Bornier X03 - Borne 18", "fil 68");
		moduleElec[1].setTexte(7, "E2.6", Principal.programme.GetLibelleSortie(120), "Bornier X03 - Borne 19", "fil 69");
		moduleElec[1].setTexte(8, "E2.7", Principal.programme.GetLibelleSortie(140), "Bornier X03 - Borne 20", "fil 70");
		moduleElec[1].setTexte(9, "E3.0", Principal.programme.GetLibelleSortie(160), "Bornier X03 - Borne 21", "fil 71");
		moduleElec[1].setTexte(10, "E3.1", Principal.programme.GetLibelleSortie(180), "Bornier X03 - Borne 22", "fil 72");
		moduleElec[1].setTexte(11, "E3.2", Principal.programme.GetLibelleSortie(200), "Bornier X03 - Borne 23", "fil 73");
		moduleElec[1].setTexte(12, "E3.3", Principal.programme.GetLibelleSortie(220), "Bornier X03 - Borne 13", "fil 74");
		
		//Module C pin éléc
		moduleElec[2].setTexte(9, "E3.4", Principal.programme.GetLibelleSortie(240), "Bornier X03 - Borne 33", "fil 83");
		moduleElec[2].setTexte(10, "E3.5", Principal.programme.GetLibelleSortie(260), "Bornier X03 - Borne 34", "fil 84");
		moduleElec[2].setTexte(11, "E3.6", Principal.programme.GetLibelleSortie(280), "Bornier X03 - Borne 35", "fil 85");
		moduleElec[2].setTexte(12, "E3.7", Principal.programme.GetLibelleSortie(300), "Bornier X03 - Borne 36", "fil 86");
		
		//Module D pin éléc
		moduleElec[3].setTexte(1, "A4.0", Principal.programme.GetLibelleSortie(940), "Bornier X03 - Borne 37", "fil 87");
		moduleElec[3].setTexte(2, "A4.1", Principal.programme.GetLibelleSortie(960), "Bornier X03 - Borne 38", "fil 88");
		moduleElec[3].setTexte(3, "A4.2", Principal.programme.GetLibelleSortie(980), "Bornier X03 - Borne 39", "fil 89");
		moduleElec[3].setTexte(4, "A4.3", Principal.programme.GetLibelleSortie(1000), "Bornier X03 - Borne 40", "fil 90");
		moduleElec[3].setTexte(5, "E4.0", Principal.programme.GetLibelleSortie(320), "Bornier X03 - Borne 41", "fil 91");
		moduleElec[3].setTexte(6, "E4.1", Principal.programme.GetLibelleSortie(340), "Bornier X03 - Borne 42", "fil 92");
		moduleElec[3].setTexte(7, "E4.2", Principal.programme.GetLibelleSortie(360), "Bornier X03 - Borne 43", "fil 93");
		moduleElec[3].setTexte(8, "E4.3", Principal.programme.GetLibelleSortie(380), "Bornier X03 - Borne 44", "fil 94");
		
		//Module A pin pneu
		modulePneu[0].setTexte(1, "A2.0", Principal.programme.GetLibelleSortie(800), "(Repos)");
		modulePneu[0].setTexte(2, "A2.0", Principal.programme.GetLibelleSortie(800), "(Travail)");
		modulePneu[0].setTexte(3, "A2.1", Principal.programme.GetLibelleSortie(820), "(Travail)");
		//Module B pin pneu
		modulePneu[1].setTexte(1, "A2.1", Principal.programme.GetLibelleSortie(820), "(Travail)");
		modulePneu[1].setTexte(2, "A2.2", Principal.programme.GetLibelleSortie(840), "(Repos)");
		modulePneu[1].setTexte(3, "A2.2", Principal.programme.GetLibelleSortie(840), "(Travail)");
		//Module C pin pneu
		modulePneu[2].setTexte(1, "A2.3", Principal.programme.GetLibelleSortie(860), "(Repos)");
		modulePneu[2].setTexte(2, "A2.3", Principal.programme.GetLibelleSortie(860), "(Travail)");
		modulePneu[2].setTexte(3, "A2.4", Principal.programme.GetLibelleSortie(880), "(Repos)");
		//Module D pin pneu
		modulePneu[3].setTexte(1, "A2.4", Principal.programme.GetLibelleSortie(880), "(Travail)");
		modulePneu[3].setTexte(2, "A2.5", Principal.programme.GetLibelleSortie(900), "(Repos)");
		modulePneu[3].setTexte(3, "A2.5", Principal.programme.GetLibelleSortie(900), "(Travail)");
	}
	
	public void setModuPinPneuActif(int nEtape){
		int nIndex = 0;
		int index = Principal.programme.GetIndexTransition(nEtape);
		//Color Actif = new Color(10, 116, 175);
		Color Actif = Color.LIGHT_GRAY;
		Color Inactif = new Color(0, 187, 210);
		
		for(int i = 0 ; i < 5 ; i++){
			
			if(Principal.programme.getTypeAction(index, i).equals("Action")){
				nIndex = index + 30 + (22 * i);
			}
		}
		//A2.0
		if(Principal.programme.getBit(nIndex, 5, 0) == 1){
			modulePneu[0].setCouleurActif(1, Inactif);
			modulePneu[0].setCouleurActif(2, Actif);
		}else{
			modulePneu[0].setCouleurActif(1, Actif);
			modulePneu[0].setCouleurActif(2, Inactif);
		}
		//A2.1
		if(Principal.programme.getBit(nIndex, 5, 1) == 1){
			modulePneu[0].setCouleurActif(3, Inactif);
			modulePneu[1].setCouleurActif(1, Actif);
		}else{
			modulePneu[0].setCouleurActif(3, Actif);
			modulePneu[1].setCouleurActif(1, Inactif);
		}
		//A2.2
		if(Principal.programme.getBit(nIndex, 5, 2) == 1){
			modulePneu[1].setCouleurActif(2, Inactif);
			modulePneu[1].setCouleurActif(3, Actif);
		}else{
			modulePneu[1].setCouleurActif(2, Actif);
			modulePneu[1].setCouleurActif(3, Inactif);
		}
		//A2.3
		if(Principal.programme.getBit(nIndex, 5, 3) == 1){
			modulePneu[2].setCouleurActif(1, Inactif);
			modulePneu[2].setCouleurActif(2, Actif);
		}else{
			modulePneu[2].setCouleurActif(1, Actif);
			modulePneu[2].setCouleurActif(2, Inactif);
		}
		//A2.4
		if(Principal.programme.getBit(nIndex, 5, 4) == 1){
			modulePneu[2].setCouleurActif(3, Inactif);
			modulePneu[3].setCouleurActif(1, Actif);
		}else{
			modulePneu[2].setCouleurActif(3, Actif);
			modulePneu[3].setCouleurActif(1, Inactif);
		}
		//A2.5
		if(Principal.programme.getBit(nIndex, 5, 5) == 1){
			modulePneu[3].setCouleurActif(2, Inactif);
			modulePneu[3].setCouleurActif(3, Actif);
		}else{
			modulePneu[3].setCouleurActif(2, Actif);
			modulePneu[3].setCouleurActif(3, Inactif);
		}
		
		//A4.
		for(int i = 0 ; i < 5 ; i++){
			if(Principal.programme.getBit(nIndex, 9, i) == 1){
				moduleElec[3].setActif(i + 1);
			}else{
				moduleElec[3].setInactif(i + 1);
			}
		}
		
		
		PoidBouton index2 = new PoidBouton();
		int nIndexTransition = index2.getIndexTransition(nEtape);
		
		//E2
		for(int i = 0 ; i < 8 ; i++){
			moduleElec[1].setInactif(i + 1);
			if(Principal.programme.getBit(nIndexTransition, 0, i) == 1){
				moduleElec[1].setActif(i + 1, true);
			}
			if(Principal.programme.getBit(nIndexTransition, 6, i) == 1){
				moduleElec[1].setActif(i + 1, false);
			}
		}
		//E3
		for(int i = 0 ; i < 4 ; i++){
			moduleElec[1].setInactif(i + 9);
			if(Principal.programme.getBit(nIndexTransition, 1, i) == 1){
				moduleElec[1].setActif(i + 9, true);
			}
			if(Principal.programme.getBit(nIndexTransition, 7, i) == 1){
				moduleElec[1].setActif(i + 9, false);
			}
		}
		for(int i = 4 ; i < 8 ; i++){
			moduleElec[2].setInactif(i + 5);
			if(Principal.programme.getBit(nIndexTransition, 1, i) == 1){
				moduleElec[2].setActif(i + 5, true);
			}
			if(Principal.programme.getBit(nIndexTransition, 7, i) == 1){
				moduleElec[2].setActif(i + 5, false);
			}
		}
		//E4
		for(int i = 0 ; i < 4 ; i++){
			moduleElec[3].setInactif(i + 5);
			if(Principal.programme.getBit(nIndexTransition, 2, i) == 1){
				moduleElec[3].setActif(i + 5, true);
			}
			if(Principal.programme.getBit(nIndexTransition, 8, i) == 1){
				moduleElec[3].setActif(i + 5, false);
			}
		}
		
		
		//Codage
		
		if(Principal.programme.getBit(4815, 0, 0) == 1){
			moduleElec[0].setActif(9, Color.MAGENTA);
		}else{
			moduleElec[0].setActif(9, Color.GRAY);
		}
		if(Principal.programme.getBit(4815, 0, 1) == 1){
			moduleElec[0].setActif(10, Color.MAGENTA);
		}else{
			moduleElec[0].setActif(10, Color.GRAY);
		}
		if(Principal.programme.getBit(4815, 0, 2) == 1){
			moduleElec[0].setActif(11, Color.MAGENTA);
		}else{
			moduleElec[0].setActif(11, Color.GRAY);
		}
		if(Principal.programme.getBit(4815, 0, 3) == 1){
			moduleElec[0].setActif(12, Color.MAGENTA);
		}else{
			moduleElec[0].setActif(12, Color.GRAY);
		}
		
		
		
		//Conso, RFID et caméra
		Boolean consoRecul = false;
		Boolean consoLanterne = false;
		Boolean consoStop = false;
		Boolean consoCligno = false;
		Boolean consoAutre = false;
		Boolean cam1 = false;
		Boolean cam2 = false;
		boolean rfid1 = false;
		boolean rfid2 = false;
		
		
		for(int i = nEtape ; i < nEtape + 1 ; i++){
			
			int index21 = Principal.programme.GetIndexTransition(i);
			for(int x = 0 ; x < 5 ; x++){
				
				
				if(Principal.programme.getTypeAction(index21, x).equals("Conso.")){
					
					nIndex = index21 + 30 + (22 * (x + 1)) - 22;
					if(Principal.programme.getValeur(nIndex + 3) == 1){
						consoRecul = true;
					}
					if(Principal.programme.getValeur(nIndex + 3) == 2){
						consoLanterne = true;
					}
					if(Principal.programme.getValeur(nIndex + 3) == 3){
						consoStop = true;
					}
					if(Principal.programme.getValeur(nIndex + 3) == 4){
						consoCligno = true;
					}
					if(Principal.programme.getValeur(nIndex + 3) == 5){
						consoAutre = true;
					}
				}
				
				if(Principal.programme.getTypeAction(index21, x).equals("Caméra")){
					
					nIndex = index21 + 30 + (22 * (x + 1)) - 22;
					if(Principal.programme.getValeur(nIndex + 3) == 1){
						cam1 = true;
					}
					if(Principal.programme.getValeur(nIndex + 3) == 2){
						cam2 = true;
					}
					
				}
				
				if(Principal.programme.getTypeAction(index21, x).equals("RFID")){
					
					nIndex = index21 + 30 + (22 * (x + 1)) - 22;
					if(Principal.programme.getValeur(nIndex + 21) == 0){
						rfid1 = true;
					}
					if(Principal.programme.getValeur(nIndex + 21) == 1){
						rfid2 = true;
					}
					
				}
			}
		}
		moduleElec[3].setActif(9, Color.GRAY);
		moduleElec[3].setActif(10, Color.GRAY);
		moduleElec[3].setActif(9, Color.GRAY);
		moduleElec[3].setActif(10, Color.GRAY);
		moduleElec[4].setActif(1, Color.GRAY);
		moduleElec[4].setActif(2, Color.GRAY);
		moduleElec[5].setActif(1, Color.GRAY);
		moduleElec[5].setActif(2, Color.GRAY);
		moduleElec[5].setActif(3, Color.GRAY);
		moduleElec[5].setActif(4, Color.GRAY);
		
		moduleElec[2].setActif(1, Color.GRAY);
		moduleElec[2].setActif(2, Color.GRAY);
		moduleElec[2].setActif(3, Color.GRAY);
		moduleElec[2].setActif(4, Color.GRAY);
		moduleElec[2].setActif(5, Color.GRAY);
		moduleElec[2].setActif(6, Color.GRAY);
		moduleElec[2].setActif(7, Color.GRAY);
		moduleElec[2].setActif(8, Color.GRAY);
		
		moduleElec[5].setActif(5, Color.GRAY);
		moduleElec[5].setActif(6, Color.GRAY);
		moduleElec[5].setActif(7, Color.GRAY);
		moduleElec[5].setActif(8, Color.GRAY);
		moduleElec[5].setActif(9, Color.GRAY);
		moduleElec[5].setActif(10, Color.GRAY);
		moduleElec[5].setActif(11, Color.GRAY);
		moduleElec[5].setActif(12, Color.GRAY);
		
		moduleElec[4].setActif(3, Color.GRAY);
		moduleElec[4].setActif(4, Color.GRAY);
		moduleElec[4].setActif(5, Color.GRAY);
		moduleElec[4].setActif(6, Color.GRAY);
		moduleElec[4].setActif(7, Color.GRAY);
		moduleElec[4].setActif(8, Color.GRAY);
		moduleElec[4].setActif(9, Color.GRAY);
		moduleElec[4].setActif(10, Color.GRAY);
		moduleElec[4].setActif(11, Color.GRAY);
		moduleElec[4].setActif(12, Color.GRAY);
		
		if(consoRecul == true){
			moduleElec[3].setActif(9, Color.CYAN);
			moduleElec[3].setActif(10, Color.CYAN);
		}
		
		if(consoLanterne == true){
			moduleElec[3].setActif(11, Color.CYAN);
			moduleElec[3].setActif(12, Color.CYAN);
		}
		
		if(consoStop == true){
			moduleElec[4].setActif(1, Color.CYAN);
			moduleElec[4].setActif(2, Color.CYAN);
		}

		
		if(consoCligno == true){
			moduleElec[5].setActif(1, Color.CYAN);
			moduleElec[5].setActif(2, Color.CYAN);
		}
		
		if(consoAutre == true){
			moduleElec[5].setActif(3, Color.CYAN);
			moduleElec[5].setActif(4, Color.CYAN);
		}
		
		if(cam1 == true){
			moduleElec[2].setActif(1, Color.PINK);
			moduleElec[2].setActif(2, Color.PINK);
			moduleElec[2].setActif(3, Color.PINK);
			moduleElec[2].setActif(4, Color.PINK);
			moduleElec[2].setActif(5, Color.PINK);
			moduleElec[2].setActif(6, Color.PINK);
			moduleElec[2].setActif(7, Color.PINK);
			moduleElec[2].setActif(8, Color.PINK);
		}
		
		if(cam2 == true){
			moduleElec[5].setActif(5, Color.PINK);
			moduleElec[5].setActif(6, Color.PINK);
			moduleElec[5].setActif(7, Color.PINK);
			moduleElec[5].setActif(8, Color.PINK);
			moduleElec[5].setActif(9, Color.PINK);
			moduleElec[5].setActif(10, Color.PINK);
			moduleElec[5].setActif(11, Color.PINK);
			moduleElec[5].setActif(12, Color.PINK);
		}
		
		if(rfid1 == true){
			moduleElec[4].setActif(3, Color.YELLOW);
			moduleElec[4].setActif(4, Color.YELLOW);
			moduleElec[4].setActif(5, Color.YELLOW);
			moduleElec[4].setActif(6, Color.YELLOW);
			moduleElec[4].setActif(7, Color.YELLOW);
		}
		
		if(rfid2 == true){
			moduleElec[4].setActif(8, Color.YELLOW);
			moduleElec[4].setActif(9, Color.YELLOW);
			moduleElec[4].setActif(10, Color.YELLOW);
			moduleElec[4].setActif(11, Color.YELLOW);
			moduleElec[4].setActif(12, Color.YELLOW);
		}
		
		consoRecul = false;
		consoLanterne = false;
		consoStop = false;
		consoCligno = false;
		consoAutre = false;
	}
	
	
			
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		g2d.setColor(Color.BLACK);
		g2d.fillRoundRect(0, 0, 643, 203, 15, 15);
		g2d.setClip(new RoundRectangle2D.Double(1, 1, 640, 200, 10, 10));
		g2d.drawImage(image, 2, 2, null);
		//g2d.setColor(Color.LIGHT_GRAY);
		//g2d.fillRoundRect(0, 0, 640, 200, 15, 15);
		g2d.drawImage(image2, -30, 50, null);
		g2d.setColor(couleur);
		g2d.fillRoundRect(30, 45, 580,  120, 10, 10);
		g2d.setColor(Color.BLACK);
		g2d.drawRoundRect(30, 45, 580, 120, 10, 10);
		g2d.drawRoundRect(31, 46, 578, 118, 10, 10);
		g2d.drawRoundRect(32, 47, 576, 116, 10, 10);
		
	}
	
	
	
}
