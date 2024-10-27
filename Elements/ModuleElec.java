package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fr.ProgrammeUniversel.Principal;

public class ModuleElec extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color c = Color.GRAY;
	String actif;
	Label lbl[] = new Label[12];
	Label lblB[] = new Label[6];
	ModulePinElec pin[] = new ModulePinElec[12];
	String msg[][] = new String[12][4];
	
	public ModuleElec(){
		super();
		this.setSize(45, 101);
		this.setOpaque(false);
		this.setLayout(null);
		this.setForeground(Color.BLACK);
		
		int y = 5;
		for(int i = 0 ; i < 6 ; i++){
			lbl[i] = new Label(10, 6, (i + 1) + "", new Color(84, 77, 63));
			pin[i] = new ModulePinElec();
			lbl[i].setLocation(1, y);
			pin[i].setLocation(10, y - 1);
			listener(i);
			this.add(lbl[i]);
			this.add(pin[i]);
			y = y + 16;
		}
		y = 5;
		for(int i = 6 ; i < 12 ; i++){
			lbl[i] = new Label(10, 6, (i + 1) + "", new Color(84, 77, 63));
			pin[i] = new ModulePinElec();
			lbl[i].setLocation(35, y);
			pin[i].setLocation(24, y - 1);
			listener(i);
			this.add(pin[i]);
			this.add(lbl[i]);
			y = y + 16;
		}
	}
	
	public void setTexte(int n, String t1, String t2, String t3, String t4){
		msg[n - 1][0] = t1;
		msg[n - 1][1] = t2;
		msg[n - 1][2] = t3;
		msg[n - 1][3] = t4;
	}
	
	private void listener(final int i){
		pin[i].addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Principal.postIt.setVisible(true);
				Principal.postIt.setTexte(msg[i][0], msg[i][1], msg[i][2], msg[i][3]);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Principal.postIt.setVisible(false);
				
			}
			
		});
	}
	

	
	public void setActif(int n){
		pin[n - 1].setActif();
	}
	
	public void setActif(int n, boolean v){
		pin[n - 1].setActif(v);
	}
	
	public void setActif(int n, Color c){
		pin[n - 1].setActif(c);
	}
	
	public void setInactif(int n){
		pin[n - 1].setInactif();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(new Color(95, 88, 70));
		g2d.fillRect(0, 0, 44, 100);
		
		g2d.setColor(new Color(200, 194, 175));
		g2d.fillRect(2, 2, 40, 96);

	}

}
