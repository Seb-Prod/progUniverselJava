package fr.ProgrammeUniversel;

public class PoidBouton {

	public PoidBouton(){
	}
	
	public int poidBit(int i){
		int poid = 0;
		switch(i){
		case 0:
			poid = 1;
			break;
		case 1:
			poid = 2;
			break;
		case 2:
			poid = 4;
			break;
		case 3:
			poid = 8;
			break;
		}
		return poid;
	}
	

	
	public int poidEntree(int i){
		int poid = 0;
		switch(i){
		case 0:
			poid = 1;
			break;
		case 1:
			poid = 2;
			break;
		case 2:
			poid = 4;
			break;
		case 3:
			poid = 8;
			break;
		case 4:
			poid = 16;
			break;
		case 5:
			poid = 32;
			break;
		case 6:
			poid = 64;
			break;
		case 7:
			poid = 128;
			break;
		case 8:
			poid = 1;
			break;
		case 9:
			poid = 2;
			break;
		case 10:
			poid = 4;
			break;
		case 11:
			poid = 8;
			break;
		case 12:
			poid = 16;
			break;
		case 13:
			poid = 32;
			break;
		case 14:
			poid = 64;
			break;
		case 15:
			poid = 128;
			break;
		case 16:
			poid = 1;
			break;
		case 17:
			poid = 2;
			break;
		case 18:
			poid = 4;
			break;
		case 19:
			poid = 8;
			break;
		case 20:
			poid = 16;
			break;
		}
		return poid;
	}
	
	public int offcetEntree(int i){
		int offcet = 0;
		if(i < 8){
			offcet = 6;
		}
		if(i > 7 && i < 16){
			offcet = 7;
		}
		if(i > 15 && i < 20){
			offcet = 8;
		}
		
		return offcet;
	}
	
	public int poidSortie(int i){
		int poid = 0;
		switch(i){
		case 0:
			poid = 1;
			break;
		case 1:
			poid = 2;
			break;
		case 2:
			poid = 4;
			break;
		case 3:
			poid = 8;
			break;
		case 4:
			poid = 16;
			break;
		case 5:
			poid = 32;
			break;
		case 6:
			poid = 64;
			break;
		case 7:
			poid = 128;
			break;
		case 8:
			poid = 4;
			break;
		case 9:
			poid = 8;
			break;
		}
		return poid;
	}
	
	public int offcetSortie(int i){
		int offcet = 0;
		if(i < 6){
			offcet = 5;
		}
		if(i > 5 && i < 9){
			offcet = 9;
		}
		return offcet;
	}
	
	public int getIndexTransition(int i){
		int v = 0;
		switch(i){
		case 0 :
			v = 4400;
			break;
		case 1 :
			v = 4418;
			break;
		case 2 :
			v = 4436;
			break;
		case 3 :
			v = 4454;
			break;
		case 4 :
			v = 4472;
			break;
		case 5 :
			v = 4490;
			break;
		case 6 :
			v = 4508;
			break;
		case 7 :
			v = 4526;
			break;
		case 8 :
			v = 4544;
			break;
		case 9 :
			v = 4562;
			break;
		case 10 :
			v = 4580;
			break;
		case 11 :
			v = 4598;
			break;
		case 12 :
			v = 4616;
			break;
		case 13 :
			v = 4634;
			break;
		case 14 :
			v = 4652;
			break;
		case 15 :
			v = 4670;
			break;
		case 16 :
			v = 4688;
			break;
		case 17 :
			v = 4706;
			break;
		case 18 :
			v = 4724;
			break;
		case 19 :
			v = 4742;
			break;
		case 20 :
			v = 4760;
			break;
		}
		return v;
	}

	public int getIndexAction(int i){
		int v = 0;
		switch(i){
		case 0 :
			break;
		case 1 :
			v = 1600;
			break;
		case 2 :
			v = 1740;
			break;
		case 3 :
			v = 1880;
			break;
		case 4 :
			v = 2020;
			break;
		case 5 :
			v = 2160;
			break;
		case 6 :
			v = 2300;
			break;
		case 7 :
			v = 2440;
			break;
		case 8 :
			v = 2580;
			break;
		case 9 :
			v = 2720;
			break;
		case 10 :
			v = 2860;
			break;
		case 11 :
			v = 3000;
			break;
		case 12 :
			v = 3140;
			break;
		case 13 :
			v = 3280;
			break;
		case 14 :
			v = 3420;
			break;
		case 15 :
			v = 3560;
			break;
		case 16 :
			v = 3700;
			break;
		case 17 :
			v = 3840;
			break;
		case 18 :
			v = 3980;
			break;
		case 19 :
			v = 4120;
			break;
		case 20 :
			v = 4260;
			break;
			
		}
		return v;
	}
}
