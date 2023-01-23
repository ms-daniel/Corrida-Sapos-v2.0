package front;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel() {
		
		
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setBounds(new Rectangle(0, 0, 100, 100));
		setLayout(null);
		
		JLabel plataforma = new JLabel("New label");
		plataforma.setBounds(10, 11, 660, 400);
		add(plataforma);
		
		CriadorPista pista = new CriadorPista(plataforma);
	}
}
