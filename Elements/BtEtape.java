package Elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BtEtape extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int L = 120;
	int H = 40;
	int N = 0;
	Color c = Color.LIGHT_GRAY;
	Color c1 = Color.LIGHT_GRAY;
	Color c2 = Color.LIGHT_GRAY.brighter();
	
	public BtEtape(int n){
		super();
		L = 76;
		H = 76;
		N = n;
		this.setSize(L, H);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setForeground(Color.BLACK);
		this.setText(n + "");
		Font font = new Font("Courier", Font.BOLD, 20);
		this.setFont(font);
		this.addMouseListener(new java.awt.event.MouseListener(){

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
				c2 = c;
				c1 = c.brighter();
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				c1 = c;
				c2 = c.brighter();
				repaint();
			}
			
		});
	}
	
	public void setEtape(int n){
		N = n;
		if(n < 10){
			this.setText("0" + n);
		}else{
			this.setText(n + "");
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Fond
		GradientPaint gradFond = new GradientPaint(0, 0, c2, L - (L/2), H, c1);
		g2d.setPaint(gradFond);
		g2d.fillRoundRect(1, 1, L - 3, H - 3, 10, 10);
		// Bordure
		g2d.setColor(Color.BLACK);
		g2d.drawRoundRect(0, 0, L - 1, H - 1, 10, 10);

		if(N == 0){
			g2d.drawRoundRect(10, 10, L - 21, H - 21, 10, 10);
		}
		super.paintComponent(g);
	}

}
