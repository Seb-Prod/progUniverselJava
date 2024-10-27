package Impression;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

import Elements.Label;
import fr.ProgrammeUniversel.PoidBouton;
import fr.ProgrammeUniversel.Principal;

public class ImprimEtape0 extends JPanel{
	
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
	

	public ImprimEtape0(int n){
		super();
		numEtape = n;
		this.setSize(1654, 250);
		
		
		//int index = Principal.programme.GetIndexTransition(n);
		Label lbl2 = new Label(100, 50, n + "", Color.BLACK);
		lbl2.setLocation(120, 75);
		this.add(lbl2);
		
		
		
		
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
		
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Bordure écran
		//g.drawImage(image, 0, 0, null);
		g2d.setColor(Color.BLACK);
		//g2d.drawRoundRect(0, 0, Largeur, Hauteur, 15, 15);
		g2d.drawRoundRect(120, 50, 100, 100, 15, 15);
		g2d.drawRoundRect(130, 60, 80, 80, 15, 15);
		
		g2d.drawLine(40, 0, 40, 200);
		g2d.drawLine(40, 0, 170, 0);
		
		g2d.drawLine(170, 0, 170, 50);
		g2d.drawLine(170, 150, 170, 250);
		g2d.drawLine(150, 200, 190, 200);
	}

}
