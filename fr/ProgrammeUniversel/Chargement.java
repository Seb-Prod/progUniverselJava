package fr.ProgrammeUniversel;

import java.io.File;
import java.io.FileInputStream;

public class Chargement {
	
	//Initialisation des Variables
	public int tableau[] = new int[5000];
	public int tabEtape[] = new int[21];
	public int tabTransition[] = new int[21];
			
	
	public Chargement(String rep){
		//Nom des BIN
		File bin1 = new File(rep + "/1.BIN");
		File bin2 = new File(rep + "/2.BIN");
		File bin3 = new File(rep + "/3.BIN");
		File bin4 = new File(rep + "/4.BIN");
	
		ChargementFichier(bin1, 0);
		ChargementFichier(bin2, 1204);
		ChargementFichier(bin3, 2408);
		ChargementFichier(bin4, 3612);
		//Charge les index
		ChargeIndex();
	}
	
	//Lecture du fichier
	private void ChargementFichier(File fichier, int index){
		if(fichier.exists()){
			FileInputStream fileInputStream = null;
			byte[] bFile = new byte[(int) fichier.length()];
			try{
				fileInputStream = new FileInputStream(fichier);
				fileInputStream.read(bFile);
				fileInputStream.close();
				for (int i = 0; i < bFile.length; i++){
		            tableau[index] = bFile[i] & 0xFF;
		            //tableau2[index] = (int) bFile[i];
		            //System.out.println(fichier + " = ");
		            //System.out.println(index + " - " + tableau[index]);
		            
		            index++;
				}
			}
		      catch (Exception e)
		      {
		         e.printStackTrace();
		      }
		}
		
		
	}
	
	public void console(){
		for(int i = 0 ; i < tableau.length ; i++){
			System.out.println(i + " - " + tableau[i]);
		}
	}

	//Getter pour récupérer la valeur de l'index	
	public int getValeur(int index){
		int valeur = tableau[index];
		return valeur;
	}

	//Setter pour changer la valeur de l'index
	public void setValeur(int index, int valeur){
		tableau[index] = valeur;
	}
	
	//Getter pour récupérer une chaine String
	public String getString(int index, int longeur){
		//Initialisation de la variable
		String libelle = new String("");
		//Concataination
		for(int i = index ; i < index + longeur ; i++){
			libelle = libelle + (char) tableau[i];
		}
		libelle = libelle.trim();
		return libelle;
	}
	//Setter pour changer la chaine String
	public void setString(int index, String txt, int longeur){
		for(int i = index ; i < index + longeur ; i++){
			tableau[i] = 32;
		}
		for(int i = 0 ; i < txt.length() ; i++){
			tableau[i + index] = txt.charAt(i);
		}
	}
	
	//Getter pour récupérer une valeur double
	public int getValeurInt(int index, int offcet){
		int valeur = ((tableau[index + offcet] * 256) + (tableau[index + offcet + 1]));
		return valeur;
	}
	
	//Getter pour récupérer une valeur double
	public double getValeurDouble(int index, int offcet){
		double valeur = ((tableau[index + offcet] * 256) + (tableau[index + offcet + 1]));
		valeur = valeur / 10.;
		return valeur;
	}
	//Getter pour récupérer une valeur double
	public String getValeurDouble2(int index, int offcet){
		double valeur = ((tableau[index + offcet] * 256) + (tableau[index + offcet + 1]));
		valeur = valeur / 1000.;
		String t = valeur + "";
		while(t.length() < 5){
			t = t + "0";
		}
		return t;
	}
	
	//Setter pour changer une valeur int ou double
		public void setValeurDouble2(int index, int offcet, String v){
			int valeur = 0;
			if(v.equals("")){
				valeur = 0;
			}else{
				valeur = (int)(Double.parseDouble(v) * 1000);
			}
			
			tableau[index + offcet + 1] = valeur % 256;
			tableau[index + offcet] = (valeur - tableau[index + offcet + 1]) / 256;
		}
	
	//Setter pour changer une valeur int ou double
	public void setValeurDouble(int index, int offcet, String v){
		int valeur = 0;
		if(v.equals("")){
			valeur = 0;
		}else{
			valeur = (int)(Double.parseDouble(v) * 10);
		}
		
		tableau[index + offcet + 1] = valeur % 256;
		tableau[index + offcet] = (valeur - tableau[index + offcet + 1]) / 256;
	}
	
	//Setter pour changer une valeur int ou double
	public void setValeurInt(int index, int offcet, String v){
		int valeur = 0;
		if(v.equals("")){
			valeur = 0;
		}else{
			valeur = (int)(Double.parseDouble(v));
		}
		tableau[index + offcet + 1] = valeur % 256;
		tableau[index + offcet] = (valeur - tableau[index + offcet + 1]) / 256;
	}
	
	//Getter pour convertir le poid
	public int getBit(int index, int offset, int nBit){
		int temps1 = getValeur(index + offset);
		int temps2;
		int[] poid = new int[8];
		for(int i = 0 ; i < 8 ; i++){
			temps2 = (temps1 / 2);
			if(temps2 * 2 != temps1){
				poid[i] = 1;
			}else{
				poid[i] = 0;
			}
			temps1 = temps2;
		}
		
		return poid[nBit];
	}
	
	//Getter pour récuéper le type d'action
	public String getTypeAction(int index, int nAction){
		//Initialisation de la variable
		String[] typeAction = new String[5];
		index = index + 31;
		//Récupére le Type d'action
		for(int i = 0 ; i < 5 ; i++){
			switch(tableau[index]){
			case 1:
				typeAction[i] = "Vissage";
				break;
			case 2:
				typeAction[i] = "Soudure";
				break;
			case 3:
				typeAction[i] = "Conso.";
				break;
			case 4:
				typeAction[i] = "Caméra";
				break;
			case 5:
				typeAction[i] = "RFID";
				break;
			case 6:
				typeAction[i] = "Action";
				break;
			case 7:
				typeAction[i] = "Traçab.";
				break;
			default:
				typeAction[i] = "";
			}	
			index = index + 22;
		}
		return typeAction[nAction];
	}	
	

	
	//Getter fonction RFID String
	public String getRFIDTxt(int index){ //Getter fonction RFID String
		String valeur ="";
		switch(tableau[index + 3]){
		case 0:
			valeur = "RAZ";
			break;
		case 1:
			valeur = "ECRITURE";
			break;
		case 2:
			valeur = "LECTURE";
			break;
		}
		return valeur;
	}	
	
	//Supprimer Action
	public void supAction(int index){
		for(int i = index ; i < index + 22 ; i++){
			tableau[i] = 0;
		}
	}
	
	
	
	
	//Getter pour récupérer le libellé des Sorties
	public String GetLibelleSortie(int index){
		//Initialisation de la variable
		String libelle = new String("");
		//Concataination
		for(int i = index ; i < index + 20 ; i++){
			libelle = libelle + (char) tableau[i];
		}
		libelle = libelle.trim();
		return libelle;
	}
	//Gettter pour récupérer le libellé de l'étape
	public String GetLibelleEtape(int index){
		//Initialisation de la variable
		String libelle = new String("");
		//Concataination
		for(int i = index ; i < index + 30 ; i++){
			libelle = libelle + (char) tableau[i];
		}
		libelle = libelle.trim();
		return libelle;
	}


	
	
	/*
	 * Propriété du programme :
	 * 	- Nom du programme
	 * 	- Numero du programme
	 * 	- Numero de l'étape pour début comptage du temps de cycle
	 * 	- Gestion du RFID
	 */
	
	public String GetLibelleProgramme(){ //Getter Nom du programme
		String libelle = new String("");
		//Concataination de la variable
		for(int i = 4784 ; i < 4814 ; i++){
			libelle = libelle + (char) tableau[i];
		}
		libelle = libelle.trim();
		return libelle;
	}
	public void SetLibelleProgramme(String txt){ //Setter Nom du programme
		for(int i = 4784 ; i < 4814 ; i++){
			tableau[i] = 32;
		}
		for(int i = 0 ; i < txt.length() ; i++){
			tableau[i + 4784] = txt.charAt(i);
		}
	}

	public int GetNumProgramme(){ //Getter Num programme
		int valeur = tableau[4815];
		return valeur;
	}
	public void SetNumProgramme(int n){ //Setter Num programme
		tableau[4815] = n;
	}
	
	public int GetNumEtape(){ //Getter Num étape pour comptage temps de cycle
		int valeur = tableau[4779];
		return valeur;
	}
	public void SetNumEtape(int n){ //Setter Num étape pour comptage du temps de cycle
		tableau[4779] = n;
	}
	
	public int GetParamRFID(){ //Getter pour récupérer si RFID actif et num tête utilisé
		int valeur = tableau[4783];
		return valeur;
	}
	public void SetParamRFID(int n){ //Setter param RFID
		tableau[4783] = n;
	}
	
	private void ChargeIndex(){
		int indexTransition = 1460;
		for(int i = 0 ; i < 21 ; i++){
			tabTransition[i] =  indexTransition;
			indexTransition = indexTransition + 140;
		}
	}
	
	public int GetIndexTransition(int i){
		return tabTransition[i];
	}




		
	public int GetRFIDTete(int index){ //Getter pour récupérer la tête utilisé
		int valeur = tableau[index + 21];
		return valeur;
	}
	public void SetRFIDTete(int index, int valeur){ //Setter n° de la tête utilisé
		tableau[index + 21] = valeur;
	}
	
	public String GetRef(){
		String libelle = new String("");
		//Concataination de la variable
		for(int i = 780 ; i < 791 ; i++){
			libelle = libelle + (char) tableau[i];
		}
		libelle = libelle.trim();
		return libelle;
	}

	public void SetRef(String txt){ //Setter Nom du programme
		for(int i = 780 ; i < 791 ; i++){
			tableau[i] = 32;
		}
		for(int i = 0 ; i < txt.length() ; i++){
			tableau[i + 780] = txt.charAt(i);
		}
	}
	
	public void RAZ(){
		//Raz des Strings
		for(int i = 0 ; i < tableau.length ; i++){
			tableau[i] = 32;
		}
		//Raz des Actions
		for(int i = 1 ; i < 21 ; i++){
			int debut = GetIndexTransition(i) + 30;
			int fin = debut + (22 * 5);
			for(int x = debut ; x < fin ; x++){
				tableau[x] = 0;
			}
		}
		//Raz des transitions
		for(int i = 4400 ; i < 4784 ; i++){
			tableau[i] = 0;
		}
		
		//Raz diver
		for(int i = 4814; i < 4820 ; i++){
			tableau[i] = 0;
		}
		
		
		
	}
	
}
