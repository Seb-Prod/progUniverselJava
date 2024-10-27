package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fr.ProgrammeUniversel.Principal;

public class ModulePneu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color c = Color.GRAY;
	String actif;
	ModulePinPneu pin[] = new ModulePinPneu[3];
	String msg[][] = new String[3][3];
	
	public ModulePneu(){
		super();
		this.setSize(45, 101);
		this.setOpaque(false);
		this.setLayout(null);
		this.setForeground(Color.BLACK);
		Label lbl1 = new Label(15, 18, "1", Color.BLACK);
		Label lbl2 = new Label(15, 18, "2", Color.BLACK);
		Label lbl3 = new Label(15, 18, "3", Color.BLACK);
		lbl1.setLocation(29, 10);
		lbl2.setLocation(29, 40);
		lbl3.setLocation(29, 70);
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		
		int y = 10;
		for(int i  = 0 ; i < 3 ; i++){
			pin[i] = new ModulePinPneu();
			pin[i].setLocation(12, y);
			msg[i][0] = "";
			msg[i][1] = "Module";
			msg[i][2] = "Non cablé";
			listener(i);
			this.add(pin[i]);
			y = y + 30;
		}
	}
	
	public void setTexte(int n, String t1, String t2, String t3){
		msg[n - 1][0] = t1;
		msg[n - 1][1] = t2;
		msg[n - 1][2] = t3;
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
				Principal.postIt.setTexte(msg[i][0], msg[i][1], msg[i][2], "");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Principal.postIt.setVisible(false);
				
			}
			
		});
	}
	
	public void setCouleurActif(int n, Color C){
		pin[n - 1].setCouleurActif(C);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(new Color(10, 116, 175));
		g2d.fillRect(7, 0, 30, 100);
		g2d.fillRect(0, 5, 44, 90);
		
		g2d.setColor(new Color(41, 76, 120));
		g2d.fillRect(0, 5, 2, 90);
		g2d.fillRect(42, 5, 3, 90);
		
		g2d.fillRect(7, 0, 30, 2);
		g2d.fillRect(7, 98, 30, 2);
		
		
		g2d.fillRect(0, 5, 8, 2);
		g2d.fillRect(0, 94, 8, 2);
		
		
		g2d.fillRect(7, 0, 2, 6);
		g2d.fillRect(37, 0, 2, 6);
		
		g2d.fillRect(7, 94, 2, 6);
		g2d.fillRect(37, 94, 2, 6);
		
		
		g2d.fillRect(37, 5, 10, 2);
		g2d.fillRect(37, 92, 10, 2);
		
		g2d.fillRect(0, 17, 20, 6);
		g2d.fillRect(0, 47, 20, 6);
		g2d.fillRect(0, 77, 20, 6);
		
	}

}
