package Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class ConsoleCode extends JPanel{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public ConsoleCode(){
		super();
		this.setSize(150, 30);
		this.setLayout(null);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//Cadre
		g2d.setColor(Color.GRAY.brighter());
		g2d.fillRoundRect(0, 0, 150, 30, 10, 10);
		g2d.setColor(Color.darkGray);
		g2d.drawRoundRect(0, 0, 150, 30, 10, 10);
		

		
		
	}

}
