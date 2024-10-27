package Ecran;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Elements.BoutonIcon;
import Elements.Ecran;
import Elements.Label;
import Elements.LabelEquipe;
import Panel.Panel;

public class Ecran_Accueil extends JPanel{

	/**
	 * Page de programmation de l'action Vissage
	 */
	
	private static final long serialVersionUID = 1L;

	int largeur = 645;
	int hauteur = 525;
	
	static Ecran ecran = new Ecran(Color.GRAY.darker());
	
	public Label lbl4 = new Label(580, 20, "", Color.GREEN);
	public JLabel lbl5 = new JLabel();
	public Panel p = new Panel(575, 20, Color.DARK_GRAY.darker());
	
	public static LabelEquipe equipe = new LabelEquipe();
	
	BufferedImage tamponSauvegarde;
	ImageIcon image;
	ImageIcon icon;
	Thread tmp = new MonThread();
	public static BoutonIcon btImport = new BoutonIcon(100, 100, "folder_download", "Importer un programme");
	public static BoutonIcon btNouveau = new BoutonIcon(100, 100, "folder_add", "Nouveau programme");
	public static BoutonIcon btIndus = new BoutonIcon(100, 52, "indus", "Heureusement il y a l'indus");
	
	static int y = 260;
	static int x1 = 270;
	static int l = 100;
	static double pas = 1.;
	static double mul = .1;
	static Label lbl2;
	static int h = 52;
	
	public Ecran_Accueil(){
		super();
		this.setSize(largeur, hauteur);
		this.setLocation(1, 1);
		this.setLayout(null);
		this.setOpaque(false);
		//Label
		
		ImageIcon iconTmps2 = new ImageIcon(getClass().getResource("/img/logo.png"));
		ImageIcon icon2 = new ImageIcon(iconTmps2.getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH));
		//logo = icon2.getImage();
		
		Label lbl1 = new Label(580, 30, "EDITEUR PROGRAMME UNIVERSEL", Color.WHITE);
		lbl2 = new Label(580, 60, "Mars 2019", Color.WHITE, 8);
		
		lbl2.setIcon(icon2);

		ecran.ajout(lbl1, 0, 10);
		ecran.ajout(lbl2, 0, 40);
		//ecran.ajout(lbl3, 5, 75);
		
		ecran.ajout(lbl4, 5, 100);
		
		lbl4.setVisible(false);
		
		p.setLocation(35, 440);
		ecran.add(p);
		
		btImport.setLocation(122, 260);
		ecran.add(btImport);
		btNouveau.setLocation(422, 260);
		ecran.add(btNouveau);
		btIndus.setLocation(460, 380);
		ecran.add(btIndus);
		btImport.setVisible(false);
		btNouveau.setVisible(false);
		btIndus.setVisible(false);
		
		equipe.setLocation(170, 100);
		ecran.add(equipe);
		equipe.setVisible(false);
		lbl5.setSize(305, 248);
		lbl5.setLocation(170, 170);
		ecran.add(lbl5);
		tmp.start();
		this.add(ecran);
		
		btIndus.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(btImport.isVisible()== true){
					equipe.setVisible(true);
					btIndus.setVisible(false);
				}
				
			}
			
		});
		
		
	}
	
	public void setCapture(JPanel p){
		//image = new ImageIcon(getClass().getResource("/img/ecran.png"));
		image = new ImageIcon(createImage(p));
		icon = new ImageIcon(image.getImage().getScaledInstance(305, 248, java.awt.Image.SCALE_SMOOTH));
		lbl5.setIcon(icon);
	}
	
	public static class MonThread extends Thread {

	    @Override
	    public void run() {
	        while(true) {
	            try {
	            	int t = 200;
	            	//int l = 150;
	            	ecran.setCouleurLed(Color.DARK_GRAY);
	            	btIndus.changeTaille(150, 78);
	            	

	            	
	            	Thread.sleep(t);
	            	ecran.setCouleurLed(Color.GREEN);
	            	btIndus.changeTaille(130, 68);
	            	Thread.sleep(t);
	            	//btIndus.setLocation(x1, y);
	            	
	            	
	            	
	            	
	            	/*
	            	if(y == 256){
	            		pas = 2;
	            		btIndus.changeTaille(100, 52, "indus");
	            	}
	            	if(y == 260){
	            		pas = -2;
	            		btIndus.changeTaille(50, 26, "indus");
	            	}
	            	y = y + pas;
	            	x1 = x1 + pas;
	            	*/
	            } catch (InterruptedException ex) {
	                Thread.currentThread().interrupt(); // Très important de réinterrompre
	                break; // Sortie de la boucle infinie
	            }
	        }
	    }
	}
	
	public BufferedImage createImage(JPanel panel) {
		int w = panel.getWidth();
	    int h = panel.getHeight();
	    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = bi.createGraphics();
	    g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, w, h);
	    panel.print(g);
	    g.dispose();
	    
	    return bi;
	}

	


}
