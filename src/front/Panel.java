package front;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;

import back.sapos;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {
	private JLabel sapo1;
	private JLabel sapo2;
	private JLabel sapo3;
	private JLabel sapo4;
	private JLabel sapo5;
	
	private CriadorPista pista;
	
	static final int DISTANCIA_TOTAL = 100;
	static final int MAX_SALTO = 10;
	
	
	private void startWalk() {
		sapos sapo1T = new sapos("Aucru", 750, 20, sapo1, 200, 790);
		sapos sapo2T = new sapos("Pirarucu", 750, 20, sapo2, 200, 790);
		sapos sapo3T = new sapos("Alcatra", 750, 20, sapo3, 200, 790);
		sapos sapo4T = new sapos("Neiva", 750, 20, sapo4, 200, 790);
		sapos sapo5T = new sapos("Invisivel", 750, 20, sapo4, 200, 790);
		
		sapo1T.start();
		sapo2T.start();
		sapo3T.start();
		sapo4T.start();
	}
	
	//private ImageIcon sapo1img = new ImageIcon("sapo1.png");
	/**
	 * Create the panel.
	 */
	public Panel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setBounds(new Rectangle(0, 0, 900, 900));
		setLayout(null);
		
		JButton startRun = new JButton("Run");
		startRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startWalk();
			}
		});
		startRun.setBounds(336, 315, 89, 23);
		add(startRun);
		
		sapo1 = new JLabel();
		sapo1.setIcon(new ImageIcon(Panel.class.getResource("/resources/sapo1.png")));
		sapo1.setBounds(20, 22, 40, 23);
		add(sapo1);
		
		sapo2 = new JLabel();
		sapo2.setIcon(new ImageIcon(Panel.class.getResource("/resources/sapo2.png")));
		sapo2.setBounds(20, 47, 40, 23);
		add(sapo2);
		
		sapo3 = new JLabel();
		sapo3.setIcon(new ImageIcon(Panel.class.getResource("/resources/sapo3.png")));
		sapo3.setBounds(20, 72, 40, 23);
		add(sapo3);
		
		sapo4 = new JLabel();
		sapo4.setIcon(new ImageIcon(Panel.class.getResource("/resources/sapo4.png")));
		sapo4.setBounds(20, 97, 40, 23);
		add(sapo4);
		
		sapo5 = new JLabel();
		sapo5.setIcon(new ImageIcon(Panel.class.getResource("")));
		sapo5.setBounds(20, 122, 40, 23);
		add(sapo5);
		
		JLabel plataforma = new JLabel("New label");
		plataforma.setBounds(10, 11, 820, 400);
		add(plataforma);
		
		pista = new CriadorPista(plataforma);
	}
}
