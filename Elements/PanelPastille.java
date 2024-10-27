package Elements;

import java.awt.Color;

import javax.swing.JPanel;

public class PanelPastille extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Label lbl;
	Label lblTxt;
	BoutonIcon bt = new BoutonIcon(10, 10, "edit", "");
	
	Pastille pastille[] = new Pastille[21];
	
	public PanelPastille(String t, String text){
		super();
		this.setSize(515, 14);
		this.setLayout(null);
		this.setOpaque(false);
		this.setForeground(Color.BLACK);
		
		lbl = new Label(45, 10, t, Color.WHITE);
		lblTxt = new Label(text, Color.BLACK, 10);
		
		lbl.setLocation(5, 0);
		lblTxt.setLocation(45, 0);
		bt.setLocation(500, 0);
		bt.setVisible(false);
		
		this.add(lbl);
		this.add(lblTxt);
		this.add(bt);
		
		int x = 180;
		for(int i = 0 ; i < 21 ; i++){
			pastille[i] = new Pastille();
			pastille[i].setLocation(x, 2);
			x = x + 15;
			this.add(pastille[i]);
			
		}
		
	}
	
	public void cache(){
		pastille[0].setVisible(false);
	}
	
	public void setTexte(String t){
		lblTxt.setText(t);
	}
	
	public void setActif(int i){
		pastille[i].setActif();
	}
	
	public void setPasActif(int i){
		pastille[i].setPasActif();
	}
	
	public void setNull(int i){
		pastille[i].setNull();
	}
	
	public void setResultat(){
		int actif = 0;
		int pasActif = 0;
		int rien = 0;
		
		for(int i = 0 ; i < 21 ; i++){
			if(pastille[i].getEtat().equals("true")){
				actif = actif + 1;
			}
			if(pastille[i].getEtat().equals("false")){
				pasActif = pasActif + 1;
			}
			if(pastille[i].getEtat().equals("null")){
				rien = rien + 1;
			}
		}
		
		if(rien == 21 && lblTxt.getText().equals("")){
			bt.setVisible(false);
		}
		
		if(rien == 21 && !lblTxt.getText().equals("")){
			bt.changeIcon("bullet_deny");
			bt.setVisible(true);
		}
		
		if(actif > 0 && pasActif > 0){
			bt.changeIcon("bullet_accept");
			bt.setToolTipText("OK");
			bt.setVisible(false);
		}
		if(actif > 0 && pasActif == 0){
			bt.changeIcon("bullet_deny");
			bt.setToolTipText("Manque test à 0");
			bt.setVisible(true);
		}
		if(actif == 0 && pasActif > 0){
			bt.changeIcon("bullet_deny");
			bt.setToolTipText("Manque test à 1");
			bt.setVisible(true);
		}
		
	}

}
