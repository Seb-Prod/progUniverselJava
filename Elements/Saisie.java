package Elements;

/**
 * Zone de saisie
 * @param
 * @param
 * @param
 * @since 1.0
 * @author Sébastien Drillaud
 * @date 15 janvier 2019
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Saisie extends JTextField{
	private static final long serialVersionUID = 1L;
	
	private int Largeur = 25; //Largeur de la zone de texte
	private int Hauteur = 25; //Hauteur de la zone de texte
	private Font font;
	private int valeurMax;
	@SuppressWarnings("unused")
	private Color couleurTxt;
	JOptionPane jop1;
	String t;
	
	public Color CouleurFond = Color.WHITE;
	
	public Saisie(String type, int valMax, int t){
		super();
		setFont(t);
		valeurMax = valMax;
		couleurTxt = Color.ORANGE;
		this.setFont(font); //Police de caractère la zone de saisie
		this.setBackground(CouleurFond); //Couleur de fond de la Zone de saisie
		this.setText("");
		this.setForeground(Color.BLACK);
		this.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				setBackground(Color.ORANGE);
				setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent e) {
				setBackground(CouleurFond);
				setForeground(Color.BLACK);
			}
			
		});
		

		if(type == "double"){
			SaisieDouble();
		}
		if(type == "double2"){
			SaisieDouble2();
		}
		if(type == "int"){
			SaisieInt();
		}
		if(type == "string"){
			SaisieString();
		}
	}
	
	public Saisie(String type, int valMax, int t, int l, int h){
		super();
		setFont(t);
		Largeur = l;
		Hauteur = h;
		this.setSize(Largeur, Hauteur);
		valeurMax = valMax;
		couleurTxt = Color.ORANGE;
		this.setFont(font);
		this.setOpaque(false);
		this.setLayout(null);
		
		

		if(type == "double"){
			SaisieDouble();
		}
		if(type == "int"){
			SaisieInt();
		}
		if(type == "string"){
			SaisieString();
		}
	}

	
	public void SaisieDouble(){
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				//Si le caractère n'est pas pas un nombre ou un point, on le supprime
				if((c >= '0' && c <= '9') || c == '.' ){
        		} else {
        			e.consume();
        		}
				
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				Object o = e.getSource();
        		if (o instanceof JTextField){
        			JTextField texte = (JTextField) o;
        			double valeur = 0.;
        			double vMax = valeurMax / 10.;
        			
        			if(texte.getText().equals("")){
        			} else {
            			try {
                			Double.parseDouble(texte.getText());
                		} catch (NumberFormatException nfe) {
                			texte.setText(texte.getText().substring(0, texte.getText().length() -1));
                		}
            			valeur = Double.parseDouble(texte.getText());
        			}
        			
        			if(valeur > vMax){ 
        				jop1 = new JOptionPane();
        				JOptionPane.showMessageDialog(null, "Valeur maxi : " + vMax, "Attention", JOptionPane.WARNING_MESSAGE);
        				texte.setText("0.0");
        				texte.select(0, texte.getText().length());
        			}
        		}
			}
		});
	}
	
	public void SaisieDouble2(){
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				//Si le caractère n'est pas pas un nombre ou un point, on le supprime
				if((c >= '0' && c <= '9') || c == '.' ){
        		} else {
        			e.consume();
        		}
				
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				Object o = e.getSource();
        		if (o instanceof JTextField){
        			JTextField texte = (JTextField) o;
        			double valeur = 0.;
        			double vMax = valeurMax / 1000.;
        			
        			if(texte.getText().equals("")){
        			} else {
            			try {
                			Double.parseDouble(texte.getText());
                		} catch (NumberFormatException nfe) {
                			texte.setText(texte.getText().substring(0, texte.getText().length() -1));
                		}
            			valeur = Double.parseDouble(texte.getText());
        			}
        			
        			if(valeur > vMax){ 
        				jop1 = new JOptionPane();
        				JOptionPane.showMessageDialog(null, "Valeur maxi : " + vMax, "Attention", JOptionPane.WARNING_MESSAGE);
        				texte.setText("0.000");
        				texte.select(0, texte.getText().length());
        			}
        		}
			}
		});
	}	
	
	public void SaisieInt(){
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				//Si le caractère n'est pas pas un nombre ou un point, on le supprime
				if(c >= '0' && c <= '9'){
        		} else {
        			e.consume();
        		}
				
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				Object o = e.getSource();
        		if (o instanceof JTextField){
        			JTextField texte = (JTextField) o;
        			int valeur = 0;
        			
        			if(!texte.getText().equals("")){ 
            			valeur = Integer.parseInt(texte.getText());
        			}
        			
        			if(valeur > valeurMax){ 
        				jop1 = new JOptionPane();
        				JOptionPane.showMessageDialog(null, "Valeur maxi : " + valeurMax, "Attention", JOptionPane.WARNING_MESSAGE);
        				
        				texte.setText("0");
        				texte.select(0, texte.getText().length());
        			}
        		}
			}
		});
	}	
	
	public void SaisieString(){
		this.setDocument(new JTextFieldLimit(valeurMax));
		this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent evt){ //Filtre les caractères saisie
            	char c = evt.getKeyChar();
            	if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') 
            			|| c == '.' || c == '-' || c == '+' || c == '/' || c == '*' || c == '#' || c == ' '){
            		 
            	} else {
            		//suppression du caractère
                evt.consume();
            	}
            }
            @Override
            public void keyReleased(KeyEvent e) { //Vérifie si la saisie est correct
  
            }
			@Override
			public void keyPressed(KeyEvent e) {} //Non Utilisé
			
        });
	}
	
	
	//Setter
	public void setLargeur(int l){
		this.setSize(l, Hauteur);
	}
	public void setHauteur(int h){
		this.setSize(Largeur, h);
	}
	
	public void setCouleur(Color c){
		this.setForeground(c);
	}
	
	private void setFont(int t){
		try{
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/Hack-Regular.ttf"));
			font = font.deriveFont(Font.TRUETYPE_FONT, t);
		}catch(IOException e){
			 
		}catch(FontFormatException e){
		                 
		}catch(IllegalArgumentException e){
		                 
		}
	}
	
	public void ajoutInfoBulle(String text){
		this.setToolTipText("");
		t = text;
	}




}
