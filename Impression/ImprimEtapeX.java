package Impression;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

import Elements.Label;
import fr.ProgrammeUniversel.PoidBouton;
import fr.ProgrammeUniversel.Principal;

public class ImprimEtapeX extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int numEtape;
	int x = 220;
	PoidBouton p = new PoidBouton();
	ImprAction action1;
	ImprAction action2;
	ImprAction action3;
	ImprAction action4;
	ImprAction action5;
	

	public ImprimEtapeX(int n){
		super();
		numEtape = n;
		this.setSize(1654, 250);
		
		
		int index = Principal.programme.GetIndexTransition(n);
		Label lbl = new Label(Principal.programme.GetLibelleEtape(index), Color.BLACK, 18);
		lbl.setLocation(250, 30);
		this.add(lbl);
		Label lbl2 = new Label(100, 50, n + "", Color.BLACK);
		lbl2.setLocation(120, 75);
		this.add(lbl2);
		
		//Action1
		action1 = new ImprAction(Principal.programme.getTypeAction(index, 0), index + 30 +(22 * 0));
		setAfficheActoin(action1, index, 0);
		//Action2
		action2 = new ImprAction(Principal.programme.getTypeAction(index, 1), index + 30 +(22 * 1));
		setAfficheActoin(action2, index, 1);
		//Action1
		action3 = new ImprAction(Principal.programme.getTypeAction(index, 2), index + 30 +(22 * 2));
		setAfficheActoin(action3, index, 2);
		//Action1
		action4 = new ImprAction(Principal.programme.getTypeAction(index, 3), index + 30 +(22 * 3));
		setAfficheActoin(action4, index, 3);
		//Action1
		action5 = new ImprAction(Principal.programme.getTypeAction(index, 4), index + 30 +(22 * 4));
		setAfficheActoin(action5, index, 4);
		
		Label E2[] = new Label[8];
		Label E3[] = new Label[8];
		Label E4[] = new Label[8];
		Label E6[] = new Label[8];
		Label E7[] = new Label[8];
		int nIndex = p.getIndexTransition(n);
		Label lbl3 = new Label("Tempo : " + Principal.programme.getValeurDouble(nIndex, 12) + "s", Color.black, 14);
		Label lbl4 = new Label("Defaut : " + Principal.programme.getValeurDouble(nIndex, 14) + "s", Color.black, 14);
		lbl3.setLocation(200, 160);
		this.add(lbl3);
		lbl4.setLocation(360, 160);
		this.add(lbl4);
		
		
		int x = 200;
		for(int i = 0 ; i < 8 ; i++){
			if(Principal.programme.getBit(nIndex, 0, i) == 1){
				E2[i] = new Label("E2." + i + "=1", Color.BLACK, 12);
				E2[i].setLocation(x, 180);
				this.add(E2[i]);
				x = x + 55;
			}
			if(Principal.programme.getBit(nIndex, 6, i) == 1){
				E2[i] = new Label("E2." + i + "=0", Color.red, 12);
				E2[i].setLocation(x, 180);
				this.add(E2[i]);
				x = x + 55;
			}
		}
		
		for(int i = 0 ; i < 8 ; i++){
			if(Principal.programme.getBit(nIndex, 1, i) == 1){
				E3[i] = new Label("E3." + i + "=1", Color.BLACK, 12);
				E3[i].setLocation(x, 180);
				this.add(E3[i]);
				x = x + 55;
			}
			if(Principal.programme.getBit(nIndex, 7, i) == 1){
				E3[i] = new Label("E3." + i + "=0", Color.red, 12);
				E3[i].setLocation(x, 180);
				this.add(E3[i]);
				x = x + 55;
			}
		}
		x = 200;
		for(int i = 0 ; i < 8 ; i++){
			if(Principal.programme.getBit(nIndex, 2, i) == 1){
				E4[i] = new Label("E4." + i + "=1", Color.BLACK, 12);
				E4[i].setLocation(x, 200);
				this.add(E4[i]);
				x = x + 55;
			}
			if(Principal.programme.getBit(nIndex, 8, i) == 1){
				E4[i] = new Label("E4." + i + "=0", Color.red, 12);
				E4[i].setLocation(x, 200);
				this.add(E4[i]);
				x = x + 55;
			}
		}
		for(int i = 0 ; i < 8 ; i++){
			if(Principal.programme.getBit(nIndex, 4, i) == 1){
				E6[i] = new Label("E6." + i + "=1", Color.BLACK, 12);
				E6[i].setLocation(x, 200);
				this.add(E6[i]);
				x = x + 55;
			}
			if(Principal.programme.getBit(nIndex, 10, i) == 1){
				E6[i] = new Label("E6." + i + "=0", Color.red, 12);
				E6[i].setLocation(x, 200);
				this.add(E6[i]);
				x = x + 55;
			}
		}
		for(int i = 0 ; i < 8 ; i++){
			if(Principal.programme.getBit(nIndex, 5, i) == 1){
				E7[i] = new Label("E7." + i + "=1", Color.BLACK, 12);
				E7[i].setLocation(x, 200);
				this.add(E7[i]);
				x = x + 55;
			}
			if(Principal.programme.getBit(nIndex, 11, i) == 1){
				E7[i] = new Label("E7." + i + "=0", Color.red, 12);
				E7[i].setLocation(x, 200);
				this.add(E7[i]);
				x = x + 55;
			}
		}
		
	}
	
	private void setAfficheActoin(Object o, int index, int nAction){
		if(Principal.programme.getTypeAction(index, nAction).equals("")){
		}else{
			((Component) o).setLocation(x , 50);
			this.add((Component) o);
			x = x + 220;
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
		g2d.drawRoundRect(120, 50, 100, 100, 15, 15);
		g2d.drawLine(170, 0, 170, 50);
		g2d.drawLine(40, 0, 40, 250);
		g2d.drawLine(170, 150, 170, 250);
		g2d.drawLine(150, 200, 190, 200);
		if(numEtape == 20){
			g2d.drawLine(40, 249, 170, 249);
		}
		if(numEtape == 8 || numEtape == 18){
			g2d.drawLine(160, 240, 170, 249);
			g2d.drawLine(170, 249, 180, 240);
		}
		if(numEtape == 19 || numEtape == 9){
			g2d.drawLine(30, 10, 40, 0);
			g2d.drawLine(40, 0, 50, 10);
		}
	}

}
