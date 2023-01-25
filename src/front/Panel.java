package front;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Panel extends JPanel {
	//private ImageIcon sapo1img = new ImageIcon("sapo1.png");
	/**
	 * Create the panel.
	 */
	public Panel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setBounds(new Rectangle(0, 0, 900, 900));
		setLayout(null);
		
		JLabel sapo1 = new JLabel();
		sapo1.setIcon(new ImageIcon(Panel.class.getResource("/resources/sapo1.png")));
		sapo1.setBounds(100, 156, 40, 23);
		add(sapo1);
		
		JLabel sapo2 = new JLabel();
		sapo2.setIcon(new ImageIcon(Panel.class.getResource("/resources/sapo2.png")));
		sapo2.setBounds(100, 181, 40, 23);
		add(sapo2);
		
		JLabel sapo3 = new JLabel();
		sapo3.setIcon(new ImageIcon(Panel.class.getResource("/resources/sapo3.png")));
		sapo3.setBounds(100, 206, 40, 23);
		add(sapo3);
		
		JLabel sapo4 = new JLabel();
		sapo4.setIcon(new ImageIcon(Panel.class.getResource("/resources/sapo4.png")));
		sapo4.setBounds(100, 231, 40, 23);
		add(sapo4);
		
		JLabel plataforma = new JLabel("New label");
		plataforma.setBounds(10, 11, 820, 400);
		add(plataforma);
		
		CriadorPista pista = new CriadorPista(plataforma);
		
		
	}
}
