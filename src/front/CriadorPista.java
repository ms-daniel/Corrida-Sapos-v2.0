package front;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CriadorPista {
	private BufferedImage buffer;
	private JLabel img = new JLabel();
	//private JButton play;
	//private boolean animation = true;
	
	public CriadorPista(JLabel label) {
		label.setIcon(drawnWay());
	}
	
	
	public ImageIcon drawnWay() {
		int width=650, height=400, wC = 30, hC = 30, fxP = 12, fyP = 10, lxP = 600, lyP = 10;
		
		//cria um buffer para a imagem
		buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.createGraphics();
		
		//
		g.setColor( Color.BLACK );
		for(int i = 0; i < 5; i++){
			g.drawLine(fxP, fyP, lxP, lyP);
			//curva da ponta esquerda superior
			g.drawArc(fxP-11, fyP, wC, hC, 100, 85);
			//curva da ponta direita superior
			g.drawArc(lxP-15, lyP, wC, hC, 0, 100);
			//curva da ponta direita inferior
			//g.drawArc(lxP-15, lyP, wC, hC, -100, 100);
			
			fxP += 14;
			fyP += 14;
			
			lxP -= 14;
			lyP += 14;
			
			
		}
		//g.drawLine(1, 25, 645, 25);
		return new ImageIcon(buffer);
	}
}
