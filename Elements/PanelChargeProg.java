package Elements;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fr.ProgrammeUniversel.Chargement;
import fr.ProgrammeUniversel.Principal;

public class PanelChargeProg extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BoutonIcon btImport = new BoutonIcon(30, 30, "file_zipped", "Retour");
	Saisie saisie1 = new Saisie("string", 3600, 22);
	Saisie saisie2 = new Saisie("string", 3600, 22);
	
	public PanelChargeProg(String nomProg, final String nomRep){
		super();
		this.setSize(580, 35);
		this.setOpaque(false);
		this.setLayout(null);
		btImport.setLocation(5, 0);
		
		saisie1.setEditable(false);
		saisie1.setSize(420, 30);
		saisie1.setText(nomProg);
		saisie1.setLocation(35, 0);
		this.add(saisie1);
		
		
		saisie2.setEditable(false);
		saisie2.setSize(115, 30);
		saisie2.setText(nomRep);
		saisie2.setLocation(460, 0);
		this.add(saisie2);
		
		this.add(btImport);
		
		btImport.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.programme = new Chargement(Principal.repertoire + "/" + nomRep);
				Principal.fond.remove(Principal.ecranImport);
				Principal.graph7.setVisible(true);
				Principal.graph7.nEtape = 1;
				Principal.graph7.majAffichage();
				Principal.fond.repaint();
				Principal.resumeEntree.maj();
				Principal.resumeAction.maj();
				btImport.changeIcon("file_zipped");
				saisie1.setBackground(Color.WHITE);
				saisie2.setBackground(Color.WHITE);
				Principal.resume.add(Principal.resumeEntree);
				Principal.resume.add(Principal.resumeAction);
				
				
				
				Principal.param.btImport.setEnabled(true);
				Principal.param.btExport.setEnabled(true);
				Principal.param.btNouveau.setEnabled(true);
				Principal.nom = nomRep;
			}
			
		});
		
		ajoutMouseListener(btImport);
		ajoutMouseListener(saisie1);
		ajoutMouseListener(saisie1);
		ajoutMouseListener(this);
	}

	private void ajoutMouseListener(Object o){
		((Component) o).addMouseListener(new MouseListener(){

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
				btImport.changeIcon("file_unzipped");
				saisie1.setBackground(Color.ORANGE);
				saisie2.setBackground(Color.ORANGE);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btImport.changeIcon("file_zipped");
				saisie1.setBackground(Color.WHITE);
				saisie2.setBackground(Color.WHITE);
			}
			
		});
	}
	
}
