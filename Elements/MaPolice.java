package Elements;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class MaPolice {
	
	/**
	 * class MaPolice
	 * Charge  une police de caratère avec pour taille par défaut de 12
	 * Possibilité de changer la taille de la police
	 * 
	 * @param police : Nom de la plolice choise
	 * @paral taille : Taille de la police
	 * 
	 * @return setTaille : retourne une police avec la taille choisie
	 * 
	 * @author Sébastien Drillaud
	 * @date 26 janvier 2018
	 * @version 1.0
	 */
	
	Font font;
	
	public MaPolice(String police){
		try{
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(police));
			font = font.deriveFont(Font.TRUETYPE_FONT, 12);
		}catch(IOException e){
			 
		}catch(FontFormatException e){
		                 
		}catch(IllegalArgumentException e){
		                 
		}
	}
	
	public Font setTaille(int taille){
		font = font.deriveFont(Font.TRUETYPE_FONT, taille);
		return font;
	}

}
