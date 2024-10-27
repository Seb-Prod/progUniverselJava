package Impression;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import Elements.Label;
import fr.ProgrammeUniversel.Principal;

public class ImprAction extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int nIndex;
	
	public ImprAction(String type, int index){
		super();
		nIndex = index;
		this.setSize(221, 101);
		Label lblTitre = new Label(200, 12, type, Color.BLACK);
		lblTitre.setLocation(20, 0);
		this.add(lblTitre);
		
		switch(type){
		case("Vissage"):
			lblTitre.setText("Vissage");
			vissage();
		break;
		case("Soudure"):
			soudure();
			lblTitre.setText("Soudure US");
		break;
		case("Conso."):
			conso();
			lblTitre.setText("Mesure consommation");
		break;
		case("Action"):
			action();
			lblTitre.setText("Action");
		break;
		case("Traçab."):
			tracab();
			lblTitre.setText("Traçabilité du PCB");
		break;
		case("RFID"):
			rfid();
			lblTitre.setText("RFID");
		break;
		case("Caméra"):
			cam();
			lblTitre.setText("Contrôle caméra");
		break;
		}
	}
	
	private void cam(){
		String type = "";
		
		
		Label lbl2 = new Label("N° de programme caméra : " + Principal.programme.getValeur(nIndex + 5), Color.BLACK, 10);
		
		
		lbl2.setLocation(25, 27);
		
		if(Principal.programme.getValeur(nIndex + 3) == 0){
			type = "Désactivé";
		}
		
		if(Principal.programme.getValeur(nIndex + 3) == 1){
			type = "Caméra 1";
			Impression.cam1 = true;
		}
		
		if(Principal.programme.getValeur(nIndex + 3) == 2){
			type = "Caméra 2";
			Impression.cam2 = true;
		}
		
		Label lbl1 = new Label("Contrôle caméra : " + type, Color.BLACK, 10);
		lbl1.setLocation(25, 15);
		
		this.add(lbl1);
		this.add(lbl2);
	}
	
	private void rfid(){
		String type = "";
		
		
		Label lbl2 = new Label("N° de station précédente : " + Principal.programme.getString((nIndex + 4), 3), Color.BLACK, 10);
		Label lbl3 = new Label("N° de station actuel : " + Principal.programme.getString((nIndex + 8), 3), Color.BLACK, 10);
		Label lbl4 = new Label("N° de produit : " + Principal.programme.getString((nIndex + 12), 8), Color.BLACK, 10);
		Label lbl5 = new Label("N° de tête RFID : " + (Principal.programme.getValeur(nIndex + 21) + 1), Color.BLACK, 10);
		
		
		lbl2.setLocation(25, 27);
		lbl3.setLocation(25, 39);
		lbl4.setLocation(25, 51);
		lbl5.setLocation(25, 63);
		
		if(Principal.programme.getValeur(nIndex + 3) == 0){
			type = "RAZ";
			lbl2.setVisible(false);
			lbl3.setVisible(false);
			lbl4.setVisible(false);
		}
		
		if(Principal.programme.getValeur(nIndex + 3) == 1){
			type = "Ecriture";
			lbl2.setVisible(false);
			lbl3.setVisible(true);
			lbl4.setVisible(true);
		}
		
		if(Principal.programme.getValeur(nIndex + 3) == 2){
			type = "Lecture";
			lbl2.setVisible(true);
			lbl3.setVisible(false);
			lbl4.setVisible(true);
		}
		
		Label lbl1 = new Label("Type d'accès RFID : " + type, Color.BLACK, 10);
		lbl1.setLocation(25, 15);
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		this.add(lbl4);
		this.add(lbl5);
	}
	
	private void tracab(){
		Label lbl1 = new Label("AL Code : FR" + Principal.programme.getString(nIndex + 2, 8), Color.BLACK, 10);
		Label lbl2 = new Label("AL Révision : " + Principal.programme.getString((nIndex + 12), 4), Color.BLACK, 10);
		Label lbl3 = new Label("N° de PCB dans le TAG RFID : " + Principal.programme.getValeur(nIndex + 11), Color.BLACK, 10);
		Label lbl4 = new Label("Tempo en fin de lecture : " + Principal.programme.getValeurDouble2(nIndex, 20) + "s", Color.BLACK, 10);
		lbl1.setLocation(25, 15);
		lbl2.setLocation(25, 27);
		lbl3.setLocation(25, 39);
		lbl4.setLocation(25, 51);
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		this.add(lbl4);
	}
	
	private void vissage(){
		Label lbl1 = new Label("Programme n°" + Principal.programme.getValeur(nIndex + 5) + "", Color.BLACK, 10);
		lbl1.setLocation(25, 15);
		this.add(lbl1);
		
		//Angles
		if(Principal.programme.getBit(nIndex + 3, 0, 0) == 1){
			Label lbl2 = new Label("Angle 1 : " + Principal.programme.getValeurDouble(nIndex, 6) +
					"° +/- " + Principal.programme.getValeurDouble(nIndex, 8) + "°", Color.black, 10);
			Label lbl3 = new Label("Angle 2 : " + Principal.programme.getValeurDouble(nIndex, 10) +
					"° +/- " + Principal.programme.getValeurDouble(nIndex, 12) + "°", Color.black, 10);
			lbl2.setLocation(25,  27);
			lbl3.setLocation(25,  39);
			this.add(lbl2);
			this.add(lbl3);
		}
		//AxeZ
		if(Principal.programme.getBit(nIndex + 3, 0, 1) == 1){
			Label lbl2 = new Label("Axe Z    : " + Principal.programme.getValeurDouble(nIndex, 14) +
					"  +/- " + Principal.programme.getValeurDouble(nIndex, 16) + "", Color.black, 10);
			lbl2.setLocation(25,  51);
			this.add(lbl2);
		}
		//Bridage D'axe
		if(Principal.programme.getBit(nIndex + 3, 0, 2) == 0){
			Label lbl2 = new Label("Avec bridage d'axe", Color.black, 10);
			lbl2.setLocation(25,  63);
			this.add(lbl2);
		}else{
			Label lbl2 = new Label("Sans bridage d'axe", Color.black, 10);
			lbl2.setLocation(25,  63);
			this.add(lbl2);
		}
		//Type de gachette
		if(Principal.programme.getBit(nIndex + 3, 0, 2) == 1){
			Label lbl2 = new Label("Type de gachette : Impulsion", Color.black, 10);
			lbl2.setLocation(25,  75);
			this.add(lbl2);
		}else{
			Label lbl2 = new Label("Type de gachette : Maintenue", Color.black, 10);
			lbl2.setLocation(25,  75);
			this.add(lbl2);
		}
	}
	
	private void soudure(){
		Label lbl1 = new Label("Programme n°" + Principal.programme.getValeur(nIndex + 5) + "", Color.BLACK, 10);
		lbl1.setLocation(25, 15);
		this.add(lbl1);
		
		//Angles
		if(Principal.programme.getBit(nIndex + 3, 0, 0) == 1){
			Label lbl2 = new Label("Angle 1 : " + Principal.programme.getValeurDouble(nIndex, 6) +
					"° +/- " + Principal.programme.getValeurDouble(nIndex, 8) + "°", Color.black, 10);
			Label lbl3 = new Label("Angle 2 : " + Principal.programme.getValeurDouble(nIndex, 10) +
					"° +/- " + Principal.programme.getValeurDouble(nIndex, 12) + "°", Color.black, 10);
			lbl2.setLocation(25,  27);
			lbl3.setLocation(25,  39);
			this.add(lbl2);
			this.add(lbl3);
		}
	}
	
	private void conso(){
		Label lbl1 = null;
		switch (Principal.programme.getValeur(nIndex + 3)){
		case 0:
			lbl1 = new Label("Aucune mesure", Color.BLACK, 10);
			break;
		case 1:
			lbl1 = new Label("Mesure conso. Recul", Color.BLACK, 10);
			Impression.consoRecul = true;
			break;
		case 2:
			lbl1 = new Label("Mesure conso. Lanterne", Color.BLACK, 10);
			Impression.consoLanterne = true;
			break;
		case 3:
			lbl1 = new Label("Mesure conso. Stop", Color.BLACK, 10);
			Impression.consoStop = true;
			break;
		case 4:
			lbl1 = new Label("Mesure conso. Clignotant", Color.BLACK, 10);
			Impression.consoCligno = true;
			break;
		case 5:
			lbl1 = new Label("Mesure conso. Autre", Color.BLACK, 10);
			Impression.consoAutre = true;
			break;
		}
		
		lbl1.setLocation(25, 15);
		this.add(lbl1);
		
		Label lbl2 = new Label("Mini. :" + Principal.programme.getValeurInt(nIndex, 4) + "mA", Color.BLACK, 10);
		Label lbl3 = new Label("Maxi. :" + Principal.programme.getValeurInt(nIndex, 6) + "mA", Color.BLACK, 10);
		Label lbl4 = new Label("Durée de mesure :" + Principal.programme.getValeurDouble(nIndex, 8) + "s", Color.BLACK, 10);
		lbl2.setLocation(25, 27);
		lbl3.setLocation(25, 39);
		lbl4.setLocation(25, 51);
		this.add(lbl2);
		this.add(lbl3);
		this.add(lbl4);
		
	}

	private void action(){
		Label A2[] = new Label[6];
		Label A4[] = new Label[4];
		Label A5[] = new Label[8];
		Label A6[] = new Label[6];
		int x = 28;
		int y = 20;
		for(int i = 0 ; i < 6 ; i++){
			if(Principal.programme.getBit(nIndex, 5, i) == 1){
				A2[i] = new Label("A2." + i, Color.BLACK, 12);
				A2[i].setLocation(x, y);
				this.add(A2[i]);
				x = x + 32;
			}
		}
		x = 28;
		y = 35;
		for(int i = 0 ; i < 4 ; i++){
			if(Principal.programme.getBit(nIndex, 9, i) == 1){
				A4[i] = new Label("A4." + i, Color.BLACK, 12);
				A4[i].setLocation(x, y);
				this.add(A4[i]);
				x = x + 32;
			}
		}
		x = 28;
		y = 50;
		for(int i = 6 ; i < 8 ; i++){
			if(Principal.programme.getBit(nIndex, 11, i) == 1){
				A5[i] = new Label("A5." + i, Color.BLACK, 12);
				A5[i].setLocation(x, y);
				this.add(A5[i]);
				x = x + 32;
			}
		}
		x = 28;
		y = 65;
		for(int i = 5 ; i < 6 ; i++){
			if(Principal.programme.getBit(nIndex, 13, i) == 1){
				A6[i] = new Label("A6." + i, Color.BLACK, 12);
				A6[i].setLocation(x, y);
				this.add(A6[i]);
				x = x + 32;
			}
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Bordure écran
		//g.drawImage(image, 0, 0, null);
		g2d.setColor(Color.BLACK);
		//g2d.drawRoundRect(0, 0, Largeur, Hauteur, 15, 15);
		g2d.drawRoundRect(20, 0, 200, 100, 15, 15);
		g2d.drawLine(0, 50, 20, 50);
		
	}

}
