package Impression;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Elements.Label;
import fr.ProgrammeUniversel.Principal;

public class Impression extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImprimEtapeX etape[] = new ImprimEtapeX[21];
	Label lblTxtElecA[] = new Label[12];
	Label lblTxtElecB[] = new Label[12];
	Label lblTxtElecC[] = new Label[12];
	Label lblTxtElecD[] = new Label[12];
	Label lblTxtElecE[] = new Label[12];
	Label lblTxtElecF[] = new Label[12];
	Label lblTxtPneuA[] = new Label[3];
	Label lblTxtPneuB[] = new Label[3];
	Label lblTxtPneuC[] = new Label[3];
	Label lblTxtPneuD[] = new Label[3];
	Label lblTxtPneuE[] = new Label[3];
	Label lblTxtPneuF[] = new Label[3];
	
	static Boolean consoRecul = false;
	static Boolean consoLanterne = false;
	static Boolean consoStop = false;
	static Boolean consoCligno = false;
	static Boolean consoAutre = false;
	static Boolean cam1 = false;
	static Boolean cam2 = false;
	
	public Impression(int page){
		super();
		this.setSize(1654, 2339);
		this.setBackground(Color.WHITE);
		Label lblTitre = new Label(1554, 80, "GRAFCET", Color.BLACK);
		Label lblNom = new Label(1553, 49, Principal.programme.GetLibelleProgramme(), Color.DARK_GRAY);
		
		lblTitre.setLocation(0, 5);		
		lblNom.setLocation(0, 90);	
		
		this.add(lblTitre);
		this.add(lblNom);
		
		if(page == 0){
			Label lbl5 = new Label("Codage n°" + Principal.programme.GetNumProgramme(), Color.BLACK, 16);
			Label lbl6 = new Label("Référence produit : " + Principal.programme.GetRef(), Color.BLACK, 16);
			Label lbl7 = new Label("Déclencher le comptage du temps de cycle à partir de l'étape n°" + Principal.programme.GetNumEtape(), Color.BLACK, 16);
			
			lbl5.setLocation(120, 170);
			lbl6.setLocation(120, 190);
			lbl7.setLocation(120, 210);
			
			this.add(lbl5);
			this.add(lbl6);
			this.add(lbl7);
			
			if(Principal.programme.GetParamRFID() == 0){
				Label lbl8 = new Label("Gestion du RFID : Désactivé", Color.BLACK, 16);
				lbl8.setLocation(120, 230);
				this.add(lbl8);
			}
			if(Principal.programme.GetParamRFID() == 1){
				Label lbl8 = new Label("Gestion du RFID : Tête n°1", Color.BLACK, 16);
				lbl8.setLocation(120, 230);
				this.add(lbl8);
			}
			if(Principal.programme.GetParamRFID() == 2){
				Label lbl8 = new Label("Gestion du RFID : Tête n°2", Color.BLACK, 16);
				lbl8.setLocation(120, 230);
				this.add(lbl8);
			}
			if(Principal.programme.GetParamRFID() == 3){
				Label lbl8 = new Label("Gestion du RFID : Tête n°1 & Tête n°2", Color.BLACK, 16);
				lbl8.setLocation(120, 230);
				this.add(lbl8);
			}
			
			Label lbl9 = new Label("Durée mini entre 2 postes : " + Principal.programme.getValeurInt(4780, 0) + " minutes", Color.BLACK, 16);
			lbl9.setLocation(120, 250);
			this.add(lbl9);
			
			int y = 350;
			ImprimEtape0 etape0 = new ImprimEtape0(0);
			etape0.setLocation(0, y);
			this.add(etape0);
			y = y + 200;
			
			for(int i = 0 ; i < 8 ; i ++){
				etape[i] = new ImprimEtapeX(i + 1);
				etape[i].setLocation(0, y);
				this.add(etape[i]);
				y = y + 200;
			}
		}
		
		if(page == 1){
			int y = 150;
			for(int i = 8 ; i < 18 ; i ++){
				etape[i] = new ImprimEtapeX(i + 1);
				etape[i].setLocation(0, y);
				this.add(etape[i]);
				y = y + 200;
			}
		}
		
		if(page == 2){
			int y = 150;
			for(int i = 18 ; i < 20 ; i ++){
				etape[i] = new ImprimEtapeX(i + 1);
				etape[i].setLocation(0, y);
				this.add(etape[i]);
				y = y + 200;
			}
			
			
			ModuleElecImpr moduleElec[] = new ModuleElecImpr[6];
			ModulePneuImpr modulePneu[] = new ModulePneuImpr[6];
			Label lblElec[] = new Label[6];
			Label lblPneu[] = new Label[6];
			
			int Y = 620;
			for(int i = 0 ; i < 6 ; i++){
				moduleElec[i] = new ModuleElecImpr();
				modulePneu[i] = new ModulePneuImpr();
				
				lblElec[i] = new Label(88, 24, ((char) (65 + i)) + "", Color.BLACK);
				lblPneu[i] = new Label(88, 24, ((char) (65 + i)) + "", Color.BLACK);
				
				lblElec[i].setLocation(1157, Y);
				lblPneu[i].setLocation(360, Y);
				
				moduleElec[i].setLocation(1157, Y + 24);
				modulePneu[i].setLocation(360, Y + 24);
				
				this.add(moduleElec[i]);
				this.add(lblElec[i]);
				this.add(modulePneu[i]);
				this.add(lblPneu[i]);
				Y = Y + 235;
			}
			
			//Module élec A
			Y = 649;
			for(int i = 0 ; i < 6 ; i ++){
				lblTxtElecA[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecA[i].setHorizontalAlignment(SwingConstants.RIGHT);
				lblTxtElecA[i].setLocation(802, Y + 5);
				this.add(lblTxtElecA[i]);
				Y = Y + 32;
			}
			Y = 649;
			for(int i = 6 ; i < 12 ; i ++){
				lblTxtElecA[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecA[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtElecA[i].setLocation(1257, Y + 5);
				this.add(lblTxtElecA[i]);
				Y = Y + 32;
			}
			
			//Module élec B
			Y = 884;
			for(int i = 0 ; i < 6 ; i ++){
				lblTxtElecB[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecB[i].setHorizontalAlignment(SwingConstants.RIGHT);
				lblTxtElecB[i].setLocation(802, Y + 5);
				this.add(lblTxtElecB[i]);
				Y = Y + 32;
			}
			Y = 884;
			for(int i = 6 ; i < 12 ; i ++){
				lblTxtElecB[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecB[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtElecB[i].setLocation(1257, Y + 5);
				this.add(lblTxtElecB[i]);
				Y = Y + 32;
			}
			
			//Module élec C
			Y = 1119;
			for(int i = 0 ; i < 6 ; i ++){
				lblTxtElecC[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecC[i].setHorizontalAlignment(SwingConstants.RIGHT);
				lblTxtElecC[i].setLocation(802, Y + 5);
				this.add(lblTxtElecC[i]);
				Y = Y + 32;
			}
			Y = 1119;
			for(int i = 6 ; i < 12 ; i ++){
				lblTxtElecC[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecC[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtElecC[i].setLocation(1257, Y + 5);
				this.add(lblTxtElecC[i]);
				Y = Y + 32;
			}
			
			//Module élec D
			Y = 1354;
			for(int i = 0 ; i < 6 ; i ++){
				lblTxtElecD[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecD[i].setHorizontalAlignment(SwingConstants.RIGHT);
				lblTxtElecD[i].setLocation(802, Y + 5);
				this.add(lblTxtElecD[i]);
				Y = Y + 32;
			}
			Y = 1354;
			for(int i = 6 ; i < 12 ; i ++){
				lblTxtElecD[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecD[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtElecD[i].setLocation(1257, Y + 5);
				this.add(lblTxtElecD[i]);
				Y = Y + 32;
			}
			
			//Module élec E
			Y = 1589;
			for(int i = 0 ; i < 6 ; i ++){
				lblTxtElecE[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecE[i].setHorizontalAlignment(SwingConstants.RIGHT);
				lblTxtElecE[i].setLocation(802, Y + 5);
				this.add(lblTxtElecE[i]);
				Y = Y + 32;
			}
			Y = 1589;
			for(int i = 6 ; i < 12 ; i ++){
				lblTxtElecE[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecE[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtElecE[i].setLocation(1257, Y + 5);
				this.add(lblTxtElecE[i]);
				Y = Y + 32;
			}
			
			//Module élec F
			Y = 1824;
			for(int i = 0 ; i < 6 ; i ++){
				lblTxtElecF[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecF[i].setHorizontalAlignment(SwingConstants.RIGHT);
				lblTxtElecF[i].setLocation(802, Y + 5);
				this.add(lblTxtElecF[i]);
				Y = Y + 32;
			}
			Y = 1824;
			for(int i = 6 ; i < 12 ; i ++){
				lblTxtElecF[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtElecF[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtElecF[i].setLocation(1257, Y + 5);
				this.add(lblTxtElecF[i]);
				Y = Y + 32;
			}
			
			
			
			//Module Pneu A
			Y = 649;
			for(int i = 0 ; i < 3 ; i ++){
				lblTxtPneuA[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtPneuA[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtPneuA[i].setLocation(460, Y + 25);
				this.add(lblTxtPneuA[i]);
				Y = Y + 60;
			}
			//Module Pneu B
			Y = 884;
			for(int i = 0 ; i < 3 ; i ++){
				lblTxtPneuB[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtPneuB[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtPneuB[i].setLocation(460, Y + 25);
				this.add(lblTxtPneuB[i]);
				Y = Y + 60;
			}
			//Module Pneu C
			Y = 1119;
			for(int i = 0 ; i < 3 ; i ++){
				lblTxtPneuC[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtPneuC[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtPneuC[i].setLocation(460, Y + 25);
				this.add(lblTxtPneuC[i]);
				Y = Y + 60;
			}
			//Module Pneu D
			Y = 1354;
			for(int i = 0 ; i < 3 ; i ++){
				lblTxtPneuD[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtPneuD[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtPneuD[i].setLocation(460, Y + 25);
				this.add(lblTxtPneuD[i]);
				Y = Y + 60;
			}
			//Module Pneu E
			Y = 1589;
			for(int i = 0 ; i < 3 ; i ++){
				lblTxtPneuE[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtPneuE[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtPneuE[i].setLocation(460, Y + 25);
				this.add(lblTxtPneuE[i]);
				Y = Y + 60;
			}
			//Module Pneu F
			Y = 1824;
			for(int i = 0 ; i < 3 ; i ++){
				lblTxtPneuF[i] = new Label(350, 15, "Relais Ctrl conso 4 clignotant", Color.BLACK);
				lblTxtPneuF[i].setHorizontalAlignment(SwingConstants.LEFT);
				lblTxtPneuF[i].setLocation(460, Y + 25);
				this.add(lblTxtPneuF[i]);
				Y = Y + 60;
			}
			setTexteModule();
			
			
			//Couleur des Pins
			//Entrée et sortie
			for(int i = 1 ; i < 13 ; i++){
				moduleElec[1].setActif(i, new Color(11, 150, 22));
			}
			for(int i = 9 ; i < 13 ; i++){
				moduleElec[2].setActif(i, new Color(11, 150, 22));
			}
			for(int i = 1 ; i < 9 ; i++){
				moduleElec[3].setActif(i, new Color(11, 150, 22));
			}
			//RFID
			if(Principal.programme.GetParamRFID() == 1 || Principal.programme.GetParamRFID() == 3){
				for(int i = 3 ; i < 8 ; i++){
					moduleElec[4].setActif(i, Color.YELLOW);
				}
			}
			if(Principal.programme.GetParamRFID() == 2 || Principal.programme.GetParamRFID() == 3){
				for(int i = 8 ; i < 13 ; i++){
					moduleElec[4].setActif(i, Color.YELLOW);
				}
			}
			
			//Conso
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
			
			consoRecul = false;
			consoLanterne = false;
			consoStop = false;
			consoCligno = false;
			consoAutre = false;
			cam1 = false;
			cam2 = false;
			
			Label lbl = new Label(1654, 40, "Disponible sur API mais abscence de place dans la prise Harting", Color.RED, "Dillova");
			lbl.setLocation(0, 2059);
			this.add(lbl);
			
			Y = 2099;
			int indexTxt = 400;
			Label E4[] = new Label[8];
			for(int i = 4 ; i < 8 ; i++){
				E4[i] = new Label("E4." + i + " - " + Principal.programme.GetLibelleSortie(indexTxt), Color.BLACK, 20);
				E4[i].setLocation(820, Y);
				this.add(E4[i]);
				Y = Y + 25;
				indexTxt = indexTxt + 20;
			}
			Y = 2099;
			Label E6[] = new Label[8];
			for(int i = 0 ; i < 4 ; i++){
				E6[i] = new Label("E6." + i + " - " + Principal.programme.GetLibelleSortie(indexTxt), Color.BLACK, 20);
				E6[i].setLocation(1220, Y);
				this.add(E6[i]);
				Y = Y + 25;
				indexTxt = indexTxt + 20;
			}
			indexTxt = indexTxt + 60;
			for(int i = 7 ; i < 8 ; i++){
				E6[i] = new Label("E6." + i + " - " + Principal.programme.GetLibelleSortie(indexTxt), Color.BLACK, 20);
				E6[i].setLocation(1220, Y);
				this.add(E6[i]);
				Y = Y + 25;
				indexTxt = indexTxt + 20;
			}
			Label E7[] = new Label[8];
			indexTxt = 680;
			for(int i = 2 ; i < 4 ; i++){
				E7[i] = new Label("E7." + i + " - " + Principal.programme.GetLibelleSortie(indexTxt), Color.BLACK, 20);
				E7[i].setLocation(1220, Y);
				this.add(E7[i]);
				Y = Y + 25;
				indexTxt = indexTxt + 20;
			}
			
			
			Y = 2099;
			Label A5[] = new Label[8];
			for(int i = 6 ; i < 8 ; i++){
				A5[i] = new Label("A5." + i + " - " + Principal.programme.GetLibelleSortie(indexTxt), Color.BLACK, 20);
				A5[i].setLocation(20, Y);
				this.add(A5[i]);
				Y = Y + 25;
				indexTxt = indexTxt + 20;
			}
			Y = 2099;
			Label A6[] = new Label[8];
			for(int i = 5 ; i < 6 ; i++){
				A6[i] = new Label("A6." + i + " - " + Principal.programme.GetLibelleSortie(indexTxt), Color.BLACK, 20);
				A6[i].setLocation(420, Y);
				this.add(A6[i]);
				Y = Y + 25;
				indexTxt = indexTxt + 20;
			}
		}
		
		
		
		
		
	}
	
	private void setTexteModule(){
		//Module A éléc
		lblTxtElecA[0].setText("+24V");
		lblTxtElecA[1].setText("+24V");
		lblTxtElecA[2].setText("+24V");
		lblTxtElecA[3].setText("+24V");
		lblTxtElecA[4].setText("0V");
		lblTxtElecA[5].setText("0V");
		lblTxtElecA[6].setText("0V");
		lblTxtElecA[7].setText("0V");
		lblTxtElecA[8].setText("CODAGE 1");
		lblTxtElecA[9].setText("CODAGE 2");
		lblTxtElecA[10].setText("CODAGE 3");
		lblTxtElecA[11].setText("CODAGE 4");
		
		//Module B élec
		lblTxtElecB[0].setText(Principal.programme.GetLibelleSortie(0) + " - E2.0");
		lblTxtElecB[1].setText(Principal.programme.GetLibelleSortie(20) + " - E2.1");
		lblTxtElecB[2].setText(Principal.programme.GetLibelleSortie(40) + " - E2.2");
		lblTxtElecB[3].setText(Principal.programme.GetLibelleSortie(60) + " - E2.3");
		lblTxtElecB[4].setText(Principal.programme.GetLibelleSortie(80) + " - E2.4");
		lblTxtElecB[5].setText(Principal.programme.GetLibelleSortie(100) + " - E2.5");
		lblTxtElecB[6].setText("E2.6 - " + Principal.programme.GetLibelleSortie(120));
		lblTxtElecB[7].setText("E2.7 - " + Principal.programme.GetLibelleSortie(140));
		lblTxtElecB[8].setText("E3.0 - " + Principal.programme.GetLibelleSortie(160));
		lblTxtElecB[9].setText("E3.1 - " + Principal.programme.GetLibelleSortie(180));
		lblTxtElecB[10].setText("E3.2 - " + Principal.programme.GetLibelleSortie(200));
		lblTxtElecB[11].setText("E3.3 - " + Principal.programme.GetLibelleSortie(220));
		
		//Module C éléc
		lblTxtElecC[0].setText("Caméra 1 Out : OK");
		lblTxtElecC[1].setText("Caméra 1 Out : ENABLE");
		lblTxtElecC[2].setText("Caméra 1 Out : ERROR");
		lblTxtElecC[3].setText("Caméra 1 In : TEACH");
		lblTxtElecC[4].setText("Caméra 1 In : TRIGGER");
		lblTxtElecC[5].setText("Caméra 1 In : BANK 1");
		lblTxtElecC[6].setText("Caméra 1 In : BANK 2");
		lblTxtElecC[7].setText("Caméra 1 In : BANK 3");
		lblTxtElecC[8].setText("E3.4 - " + Principal.programme.GetLibelleSortie(240));
		lblTxtElecC[9].setText("E3.5 - " + Principal.programme.GetLibelleSortie(260));
		lblTxtElecC[10].setText("E3.6 - " + Principal.programme.GetLibelleSortie(280));
		lblTxtElecC[11].setText("E3.7 - " + Principal.programme.GetLibelleSortie(300));
		
		//Module D éléc
		lblTxtElecD[0].setText(Principal.programme.GetLibelleSortie(940) + " - A4.0");
		lblTxtElecD[1].setText(Principal.programme.GetLibelleSortie(960) + " - A4.1");
		lblTxtElecD[2].setText(Principal.programme.GetLibelleSortie(980) + " - A4.2");
		lblTxtElecD[3].setText(Principal.programme.GetLibelleSortie(1000) + " - A4.3");
		lblTxtElecD[4].setText(Principal.programme.GetLibelleSortie(320) + " - E4.0");
		lblTxtElecD[5].setText(Principal.programme.GetLibelleSortie(340) + " - E4.1");
		lblTxtElecD[6].setText("E4.2 - " + Principal.programme.GetLibelleSortie(360));
		lblTxtElecD[7].setText("E4.3 - " + Principal.programme.GetLibelleSortie(380));
		lblTxtElecD[8].setText("Relais Ctrl conso 1 (Recul)");
		lblTxtElecD[9].setText("Relais Ctrl conso 1 (Recul");
		lblTxtElecD[10].setText("Relais Ctrl conso 2 (Lanterne)");
		lblTxtElecD[11].setText("Relais Ctrl conso 2 (Lanterne)");
		
		//Module E éléc
		lblTxtElecE[0].setText("Relais Ctrl conso 3 (Stop)");
		lblTxtElecE[1].setText("Relais Ctrl conso 3 (Stop)");
		lblTxtElecE[2].setText("RFID 1");
		lblTxtElecE[3].setText("RFID 1");
		lblTxtElecE[4].setText("RFID 1");
		lblTxtElecE[5].setText("RFID 1");
		lblTxtElecE[6].setText("RFID 1");
		lblTxtElecE[7].setText("RFID 2");
		lblTxtElecE[8].setText("RFID 2");
		lblTxtElecE[9].setText("RFID 2");
		lblTxtElecE[10].setText("RFID 2");
		lblTxtElecE[11].setText("RFID 2");
		
		//Module F éléc
		lblTxtElecF[0].setText("Relais Ctrl conso 4 (Clignotant)");
		lblTxtElecF[1].setText("Relais Ctrl conso 4 (Clignotant)");
		lblTxtElecF[2].setText("Relais Ctrl conso 5 (Autre)");
		lblTxtElecF[3].setText("Relais Ctrl conso 5 (Autre)");
		lblTxtElecF[4].setText("Caméra 2 Out : OK");
		lblTxtElecF[5].setText("Caméra 2 Out : ENABLE");
		lblTxtElecF[6].setText("Caméra 2 Out : ERROR");
		lblTxtElecF[7].setText("Caméra 2 In : TEACH");
		lblTxtElecF[8].setText("Caméra 2 In : TRIGGER");
		lblTxtElecF[9].setText("Caméra 2 In : BANK 1");
		lblTxtElecF[10].setText("Caméra 2 In : BANK 2");
		lblTxtElecF[11].setText("Caméra 2 In : BANK 3");	
		
		//Module A Pneu
		lblTxtPneuA[0].setText("A2.0 - " + Principal.programme.GetLibelleSortie(800) + " (R)");
		lblTxtPneuA[1].setText("A2.0 - " + Principal.programme.GetLibelleSortie(800) + " (T)");
		lblTxtPneuA[2].setText("A2.1 - " + Principal.programme.GetLibelleSortie(820) + " (R)");
		
		//Module B Pneu
		lblTxtPneuB[0].setText("A2.1 - " + Principal.programme.GetLibelleSortie(820) + " (T)");
		lblTxtPneuB[1].setText("A2.2 - " + Principal.programme.GetLibelleSortie(840) + " (R)");
		lblTxtPneuB[2].setText("A2.2 - " + Principal.programme.GetLibelleSortie(840) + " (T)");
		
		//Module C Pneu
		lblTxtPneuC[0].setText("A2.3 - " + Principal.programme.GetLibelleSortie(860) + " (R)");
		lblTxtPneuC[1].setText("A2.3 - " + Principal.programme.GetLibelleSortie(860) + " (T)");
		lblTxtPneuC[2].setText("A2.4 - " + Principal.programme.GetLibelleSortie(880) + " (R)");
		
		//Module D Pneu
		lblTxtPneuD[0].setText("A2.4 - " + Principal.programme.GetLibelleSortie(880) + " (T)");
		lblTxtPneuD[1].setText("A2.5 - " + Principal.programme.GetLibelleSortie(900) + " (R)");
		lblTxtPneuD[2].setText("A2.5 - " + Principal.programme.GetLibelleSortie(900) + " (T)");
		
		
		//Module E Pneu
		lblTxtPneuE[0].setText("");
		lblTxtPneuE[1].setText("");
		lblTxtPneuE[2].setText("");
		
		//Module F Pneu
		lblTxtPneuF[0].setText("");
		lblTxtPneuF[1].setText("");
		lblTxtPneuF[2].setText("");		
		

	}


}
