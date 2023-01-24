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
		int fx2P = 68, fy2P = 96, ly2P = 96, lx2P = 544;
		
		//cria um buffer para a imagem
		buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.createGraphics();
		
		//
		g.setColor( Color.BLACK );
		for(int i = 0; i < 5; i++){
			//linhas horizontais superiores
			g.drawLine(fxP, fyP, lxP, lyP);
			//linhas horizontais inferiores
			g.drawLine(fx2P, fy2P, lx2P, ly2P);
			
			//curva da ponta esquerda superior
			g.drawArc(fxP-11, fyP, wC, hC, 100, 85);
			//curva da ponta esquerda inferior
			g.drawArc(fx2P-11, fy2P-30, wC, hC, -100, -90);
			//curva da ponta direita superior
			g.drawArc(lxP-15, lyP, wC, hC, 0, 100);
			//curva da ponta direita inferior
			g.drawArc(lx2P-15, ly2P-30, wC, hC, 0, -100);
			
			fxP += 14;
			fyP += 14;
			
			lxP -= 14;
			lyP += 14;
			
			fx2P -= 14;
			fy2P += 14;
			ly2P += 14;
			lx2P += 14;
			
			
		}
		//g.drawLine(1, 82, 645, 82);
		return new ImageIcon(buffer);
	}
}
