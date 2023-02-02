package front;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;

import back.LoadSound;
import back.sapos;

import java.awt.Color;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JTextPane;

public class Panel extends JPanel {
	private JLabel sapo1;
	private JLabel sapo2;
	private JLabel sapo3;
	private JLabel sapo4;
	private JLabel sapo5;
	
	private JLabel classificados[];
	private JTextPane relatorio;
	
	private CriadorPista pista;
	
	private Clip back_sound;
	
	static final int DISTANCIA_TOTAL = 100;
	static final int MAX_SALTO = 10;
	
	
	private void startWalk() {
		sapos sapo1T = new sapos("Aucru1",     750, 20, sapo1, 200, 790, classificados, relatorio);
		sapos sapo2T = new sapos("Pirarucu2",  750, 20, sapo2, 200, 790, classificados, relatorio);
		sapos sapo3T = new sapos("Alcatra3",   750, 20, sapo3, 200, 790, classificados, relatorio);
		sapos sapo4T = new sapos("Neiva4",     750, 20, sapo4, 200, 790, classificados, relatorio);
		sapos sapo5T = new sapos("Invisivel5", 750, 20, sapo5, 200, 790, classificados, relatorio);
		
		sapo1T.start();
		sapo2T.start();
		sapo3T.start();
		sapo4T.start();
		sapo5T.start();
	}
	
	//private ImageIcon sapo1img = new ImageIcon("sapo1.png");
	/**
	 * Create the panel.
	 */
	public Panel() {
		LoadSound load_sound = new LoadSound();
		
		try {
			AudioInputStream sound = load_sound.LoadSound("Sapo-Cururu.wav");
			back_sound = AudioSystem.getClip();
			back_sound.open(sound);
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		back_sound.setMicrosecondPosition(0);
		back_sound.loop(5);
		back_sound.start();
		
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
		sapo5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sapo5.setIcon(new ImageIcon(Panel.class.getResource("")));
		sapo5.setBounds(20, 122, 40, 23);
		add(sapo5);
		
		relatorio = new JTextPane();
		relatorio.setEditable(false);
		relatorio.setText("");
		relatorio.setBounds(386, 162, 323, 142);
		add(relatorio);
		
		JLabel plataforma = new JLabel("New label");
		plataforma.setBounds(10, 11, 820, 400);
		add(plataforma);
		
		pista = new CriadorPista(plataforma);
		
		classificados = new JLabel[6];
		classificados[0] = new JLabel("--------------Classificados--------------");
		classificados[0].setBounds(20, 180, 250, 30);
		add(classificados[0]);
		
		classificados[1] = new JLabel("--------------Classificados--------------");
		classificados[1].setBounds(20, 200, 250, 30);
		add(classificados[1]);
		
		classificados[2] = new JLabel("--------------Classificados--------------");
		classificados[2].setBounds(20, 220, 250, 30);
		add(classificados[2]);
		
		classificados[3] = new JLabel("--------------Classificados--------------");
		classificados[3].setBounds(20, 240, 250, 30);
		add(classificados[3]);
		
		classificados[4] = new JLabel("--------------Classificados--------------");
		classificados[4].setBounds(20, 260, 250, 30);
		add(classificados[4]);
		
		classificados[5] = new JLabel("--------------Classificados--------------");
		classificados[5].setBounds(20, 280, 250, 30);
		add(classificados[5]);
	}
}
