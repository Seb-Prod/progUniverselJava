package Elements;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BoiteDeDialogue extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image image;
	public BoiteDeDialogue(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(450, 276);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		/*
		this.setUndecorated(true);
		this.getRootPane ().setOpaque (false);
		this.getContentPane ().setBackground (new Color (0, 0, 0, 0));
		this.setBackground (new Color (0, 0, 0, 0));
	    */
		setUndecorated(true);
       // setOpacity(0.5f);
		ImageIcon iconTmps = new ImageIcon(getClass().getResource("/img/note.png"));
		ImageIcon icon = new ImageIcon(iconTmps.getImage().getScaledInstance(450, 276, java.awt.Image.SCALE_SMOOTH));
		image = icon.getImage();
		
		
		
		BoutonIcon btOK = new BoutonIcon(60, 60, "bullet_accept", "Valider");
		btOK.setLocation(10,  10);
		this.add(btOK);
		
	}
	
	@Override
    public void paint(Graphics g) {
        if (!isOpaque()) {
            super.paint(g);
            return;
        }
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        //GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        //g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
