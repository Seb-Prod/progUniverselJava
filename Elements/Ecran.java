package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Panel.Panel;

public class Ecran extends JPanel{

	/**
	 * Ecran imitation Pro-face
	 */
	
	private static final long serialVersionUID = 1L;
	public PostIt dialogSupp = new PostIt(this);
	public PostIt dialogValid = new PostIt(this);
	
	Panel fond = new Panel(645, 525);
	public Color C;
	public Color C1 = Color.DARK_GRAY;
	public Color C2 = Color.DARK_GRAY;
	
	public Color CouleurLed = Color.GREEN;
	
	Boolean PageGraph7;
	
	public int H = 0;
	int Largeur  = 640;
	int Hauteur = 520;
	Image image;
	Image logo;
	
	
	
	
	
	public Ecran(Color c){
		super();
		
		
		dialogSupp.setLocation(110, 132);
		this.add(dialogSupp);
		dialogSupp.setVisible(false);
		
		dialogValid.setLocation(110, 132);
		this.add(dialogValid);
		dialogValid.setVisible(false);
		
		PageGraph7 = false;
		C = c;
		this.setSize(645, 525);
		this.setLayout(null);
		this.setOpaque(false);
		Label lbl = new Label(645, 15, "", Color.GRAY);
		lbl.setLocation(0, 485);
		this.add(lbl);
		
		ImageIcon iconTmps = new ImageIcon(getClass().getResource("/img/texture.png"));
		ImageIcon icon = new ImageIcon(iconTmps.getImage().getScaledInstance(645, 525, java.awt.Image.SCALE_SMOOTH));
		image = icon.getImage();
		
		ImageIcon iconTmps2 = new ImageIcon(getClass().getResource("/img/logo.png"));
		ImageIcon icon2 = new ImageIcon(iconTmps2.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		logo = icon2.getImage();
		
		LabelTft tft = new LabelTft(588, 435);
		tft.setLocation(30, 30);
		this.add(tft);
		
		LabelVis vis1 = new LabelVis();
		LabelVis vis2 = new LabelVis();
		LabelVis vis3 = new LabelVis();
		LabelVis vis4 = new LabelVis();
		
		vis1.setLocation(3, 3);
		vis2.setLocation(608, 3);
		vis3.setLocation(3, 488);
		vis4.setLocation(608, 488);
		
		this.add(vis1);
		this.add(vis2);
		this.add(vis3);
		this.add(vis4);
		
		
		LabelFissure fissure = new LabelFissure();
		fissure.setLocation(30, 30);
		this.add(fissure);
		
		fond.setLocation(0, 0);
		this.add(fond);
		
		
		
	}
	
	
	
	public void afficheDialog(PostIt p){
		p.setVisible(true);
		int nb = fond.getComponentCount();
		for(int i = 0 ; i < nb ; i++){
			fond.getComponent(i).setEnabled(false);
		}
		
		
	}
	
	public void cacheDialog(PostIt p){
		p.setVisible(false);
		int nb = fond.getComponentCount();
		for(int i = 0 ; i < nb ; i++){
			fond.getComponent(i).setEnabled(true);
		}
	}
	
	
	
	public void setCouleur(Color couleur){
		C = couleur;
	}
	public void setCouleurEcran1(Color couleur){
		C1 = couleur;
	}
	public void setCouleurEcran2(Color couleur){
		C2 = couleur;
	}
	
	public Ecran(Color c, Boolean pageGraph7){
		super();
		fond.setLocation(0, 0);
		this.add(fond);
		C = c;
		PageGraph7 = true;
		this.setSize(645, 525);
		this.setLayout(null);
		this.setOpaque(false);
		Label lbl = new Label(645, 15, "", Color.GRAY);
		lbl.setLocation(0, 482);
		this.add(lbl);
		
		ImageIcon iconTmps = new ImageIcon(getClass().getResource("/img/texture.png"));
		ImageIcon icon = new ImageIcon(iconTmps.getImage().getScaledInstance(645, 525, java.awt.Image.SCALE_SMOOTH));
		image = icon.getImage();
		
		ImageIcon iconTmps2 = new ImageIcon(getClass().getResource("/img/logo.png"));
		ImageIcon icon2 = new ImageIcon(iconTmps2.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		logo = icon2.getImage();
		
		LabelVis vis1 = new LabelVis();
		LabelVis vis2 = new LabelVis();
		LabelVis vis3 = new LabelVis();
		LabelVis vis4 = new LabelVis();
		LabelTft tft = new LabelTft(580, 435);
		tft.setLocation(30, 30);
		this.add(tft);
		vis1.setLocation(3, 3);
		vis2.setLocation(608, 3);
		vis3.setLocation(3, 488);
		vis4.setLocation(608, 488);
		
		this.add(vis1);
		this.add(vis2);
		this.add(vis3);
		this.add(vis4);
		
		
		LabelFissure fissure = new LabelFissure();
		fissure.setLocation(30, 30);
		this.add(fissure);
	
	}
	
	@SuppressWarnings("unused")
	private void rafraichie(){
		this.repaint();
	}
	
	public Ecran(Color c, int h){
		super();
		H = 1;
		PageGraph7 = false;
		C = c;
		this.setSize(645, 525);
		this.setLayout(null);
		this.setOpaque(false);
		Label lbl = new Label(645, 15, "", Color.GRAY);
		lbl.setLocation(0, 485);
		this.add(lbl);
	
		
	}
	
	public Ecran(int largeur, int hauteur){
		PageGraph7 = false;
		H = 1;
		this.setSize(largeur + 5, hauteur + 5);
		Label lbl = new Label(645, 12, "", Color.GRAY);
		lbl.setLocation(0, 695);
		this.add(lbl);
		this.setLayout(null);
		this.setOpaque(false);
		Largeur = largeur;
		Hauteur = hauteur;
		
		ImageIcon iconTmps = new ImageIcon(getClass().getResource("/img/texture.png"));
		ImageIcon icon = new ImageIcon(iconTmps.getImage().getScaledInstance(largeur, hauteur, java.awt.Image.SCALE_SMOOTH));
		image = icon.getImage();
		
		ImageIcon iconTmps2 = new ImageIcon(getClass().getResource("/img/logo.png"));
		ImageIcon icon2 = new ImageIcon(iconTmps2.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		logo = icon2.getImage();
		
		LabelTft tft1 = new LabelTft(520, 435);
		tft1.setLocation(30, 30);
		this.add(tft1);
		
		LabelTft tft2 = new LabelTft(520, 200);
		tft2.setLocation(30, 475);
		this.add(tft2);
		
		LabelVis vis1 = new LabelVis();
		LabelVis vis2 = new LabelVis();
		LabelVis vis3 = new LabelVis();
		LabelVis vis4 = new LabelVis();
		
		vis1.setLocation(3, 3);
		vis2.setLocation(548, 3);
		vis3.setLocation(3, 698);
		vis4.setLocation(548, 698);
		
		LabelFissure fissure = new LabelFissure();
		fissure.setLocation(500, 30);
		this.add(fissure);
		
		LabelFissure fissure2 = new LabelFissure();
		fissure2.setLocation(500, 530);
		this.add(fissure2);
		
		this.add(vis1);
		this.add(vis2);
		this.add(vis3);
		this.add(vis4);
	}
	
	
	
	
	public void ajout(JLabel lbl, int x, int y){
		lbl.setLocation(x + 30, y + 30);
		fond.add(lbl);
	}
	
	public void ajout(JTextField lbl, int x, int y){
		lbl.setLocation(x + 30, y + 30);
		fond.add(lbl);
	}
	
	public void ajout(JButton lbl, int x, int y){
		lbl.setLocation(x + 30, y + 30);
		fond.add(lbl);
	}
	
	public void ajout(JPanel lbl, int x, int y){
		lbl.setLocation(x + 30, y + 30);
		fond.add(lbl);
	}
	
	public void setCouleurLed(Color c){
		CouleurLed = c;
		this.repaint();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Bordure écran
		//g.drawImage(image, 0, 0, null);
		g2d.setColor(Color.BLACK);
		//g2d.drawRoundRect(0, 0, Largeur, Hauteur, 15, 15);
		g2d.fillRoundRect(0, 0, Largeur + 3, Hauteur + 3, 15, 15);
		g2d.setClip(new RoundRectangle2D.Double(1, 1, Largeur, Hauteur, 12, 12));
		g2d.drawImage(image, 2, 2, null);
		if(H ==0){
			//Ecran
			
			g2d.setColor(C);
			g2d.fillRoundRect(30, 30, 580, 435, 10, 10);
			g2d.setColor(Color.BLACK);
			g2d.drawRoundRect(30, 30, 580, 435, 10, 10);
			g2d.drawRoundRect(31, 31, 578, 433, 10, 10);
			g2d.drawRoundRect(32, 32, 576, 431, 10, 10);
			
			//Logo
			g2d.drawImage(logo, 270, 440, null);
			/*
			g2d.setColor(Color.GRAY.brighter());
			g2d.fillRoundRect(270, 475, 100, 30, 10, 10);
			g2d.setColor(Color.DARK_GRAY);
			g2d.drawRoundRect(270, 475, 100, 30, 10, 10);
			*/
			
			// Bouton
			g2d.setColor(Color.BLACK);
			g2d.fillOval(50, 490, 10, 10);
			g2d.setColor(CouleurLed);
			g2d.fillOval(51, 491, 8, 8);
			
			
			if(PageGraph7 == true){
				g2d.setColor(Color.WHITE);
				g2d.drawLine(98, 120, 98, 350);
				g2d.drawLine(78, 300, 118, 300);
			}
		}else{
			//Ecran1
			g2d.setColor(C1);
			g2d.fillRoundRect(30, 30, 520, 435, 10, 10);
			g2d.setColor(Color.BLACK);
			g2d.drawRoundRect(30, 30, 520, 435, 10, 10);
			
			//Ecran2
			g2d.setColor(C2);
			g2d.fillRoundRect(30, 475, 520, 200, 10, 10);
			g2d.setColor(Color.BLACK);
			g2d.drawRoundRect(30, 475, 520, 200, 10, 10);
			
			//Logo
			
			g2d.drawImage(logo, 240, 652, null);
			
			// Bouton
			g2d.setColor(Color.BLACK);
			g2d.fillOval(50, 702, 10, 10);
			g2d.setColor(Color.red);
			g2d.fillOval(51, 703, 8, 8);
		}

		
		
		
		
	}

}
