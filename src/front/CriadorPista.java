package front;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CriadorPista {
	private BufferedImage buffer;
	private JLabel img = new JLabel();
	private Color corPista = new Color(210, 76, 67);
	//private JButton play;
	//private boolean animation = true;
	
	public CriadorPista(JLabel label) {
		label.setIcon(drawnWay());
	}

	public ImageIcon drawnWay() {
		int width=850, height=400, wC = 30, hC = 30, fxP = 12, fyP = 10, lxP = 800, lyP = 10;
		int tamanhoHorizontal = 790, tamanhoVertical = 200;
		int vX = 126, viY = 144, vfY = 143 + (25*4);  
		
		//cria um buffer para a imagem
		buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.createGraphics();
		
		//
		
		for(int i = 0; i < 5; i++){
			g.setColor(corPista);
			//linhas horizontais
			g.fillRect(fxP, fyP, tamanhoHorizontal, 25);
			//g.fillRect(fx2P, fy2P-25, tamanhoHorizontal, 25);
			
			//==================linhas=========================
			g.setColor( Color.BLACK );
			//linhas horizontais
			g.drawLine(fxP, fyP, lxP, lyP);
			//==================fim linha=========================

			fyP += 25;
			lyP += 25;
			g.drawLine(fxP, fyP, lxP, lyP);
		}
		g.drawLine(fxP, fyP-125, fxP, fyP);
		g.drawLine(lxP+1, lyP-125, lxP+1, lyP);
		
		g.fillRect(fxP+30, fyP-125, 5, 25*5);
		
		g.setColor(Color.WHITE);
		g.fillRect(lxP-10, lyP-124, 5, 123);
		
		return new ImageIcon(buffer);
	}
}
