package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PostIt extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image image;
	Label lbl1;
	Label lbl2;
	Label lbl3;
	Label lbl4;

	public PostIt(){
		super();
		this.setSize(260, 140);
		this.setLayout(null);
		this.setOpaque(false);
		
		ImageIcon iconTmps = new ImageIcon(getClass().getResource("/img/note.png"));
		ImageIcon icon = new ImageIcon(iconTmps.getImage().getScaledInstance(260, 140, java.awt.Image.SCALE_SMOOTH));
		image = icon.getImage();
		
		lbl1 = new Label(260, 30, "A3.0", Color.red, "Dillova");
		lbl2 = new Label(260, 15, "Realis Ctrl conso 4 (clignotant)", Color.BLACK, "Dillova");
		lbl3 = new Label(260, 15, "A3.0", Color.black, "Dillova");
		lbl4 = new Label(260, 15, "Realis Ctrl conso 4 (clignotant)", Color.BLACK, "Dillova");
		
		lbl1.setLocation(0, 20);
		lbl2.setLocation(0, 45);
		lbl3.setLocation(0, 65);
		lbl4.setLocation(0, 85);
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		this.add(lbl4);
	}
	
	public PostIt(final Ecran p){
		super();
		this.setSize(420, 300);
		this.setLayout(null);
		this.setOpaque(false);
		
		ImageIcon iconTmps = new ImageIcon(getClass().getResource("/img/note.png"));
		ImageIcon icon = new ImageIcon(iconTmps.getImage().getScaledInstance(425, 300, java.awt.Image.SCALE_SMOOTH));
		image = icon.getImage();
		
		lbl1 = new Label(425, 50, "", Color.red, "Dillova");
		lbl2 = new Label(425, 40, "", Color.BLACK, "Dillova");
		lbl3 = new Label(425, 40, "", Color.BLACK, "Dillova");
		lbl4 = new Label(425, 40, "", Color.BLACK, "Dillova");
		
		lbl1.setLocation(0, 45);
		lbl2.setLocation(0, 95);
		lbl3.setLocation(0, 145);
		lbl4.setLocation(0, 195);
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl2);
		this.add(lbl3);
	}
	
	public void setTexte(String t1, String t2){
		lbl1.setText(t1);
		lbl2.setText(t2);
		lbl3.setText("");
		lbl4.setText("");
	}

	public void setTexte(String t1, int min, int max){
		lbl1.setText(t1);
		lbl2.setText("");
		lbl3.setText("min : " + min + " >     < " +  "max : " + max);
		lbl4.setText("");
	}	
	
	public void setTexte(String t1, String t2, String t3, String t4){
		lbl1.setText(t1);
		lbl2.setText(t2);
		lbl3.setText(t3);
		lbl4.setText(t4);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 2, 2, null);
	}

	

	
}
