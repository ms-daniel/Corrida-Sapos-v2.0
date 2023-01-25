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
		int 										 fx2P = 12, fy2P = 243, ly2P = 243, lx2P = 800, tamanhoHorizontal = 790, tamanhoVertical = 200;
		int vX = 126, viY = 144, vfY = 143 + (25*4);  
		
		//cria um buffer para a imagem
		buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.createGraphics();
		
		//
		for(int i = 0; i < 5; i++){
			g.setColor(corPista);
			//==================pintura=========================
			//linhas horizontais superiores
			if(i < 4) {
				//linhas horizontais
				g.fillRect(fxP, fyP, tamanhoHorizontal, 25);
				g.fillRect(fx2P, fy2P-25, tamanhoHorizontal, 25);
				
				//linhas verticais
				if(i < 1) {
					g.fillRect(fxP-10, fyP+10, 25, tamanhoVertical+5);
					g.fillRect(lxP-10, lyP+20, 25, tamanhoVertical);
				}else {
					g.fillRect(fxP-10, fyP, 25, tamanhoVertical+32);
					g.fillRect(lxP-10, lyP, 25, tamanhoVertical+32);
				}
				
				g.fillArc(fxP-11, fyP, wC, hC, 100, 85);
				//curva da ponta esquerda inferior
				g.fillArc(fx2P-11, fy2P-30, wC, hC, -100, -90);
				//curva da ponta direita superior
				g.fillArc(lxP, lyP, wC, hC, 0, 100);
				//curva da ponta direita inferior
				g.fillArc(lx2P-15, ly2P-30, wC, hC, 0, -100);
				
			}/*else {
				g.fillRect(fxP-10, fyP-4, 14, tamanhoVertical+36);
				g.fillRect(lxP+2, lyP-4, 14, tamanhoVertical+36);
			}*/
			//==================fim pintura=========================
			
			//==================linhas=========================
			g.setColor( Color.BLACK );
			//linhas horizontais superiores
			g.drawLine(fxP, fyP, lxP, lyP);
			
			//linhas horizontais inferiores
			g.drawLine(fx2P, fy2P, lx2P, ly2P);
			
			//curva da ponta esquerda superior
			g.drawArc(fxP-11, fyP, wC, hC, 100, 85);
			//curva da ponta esquerda inferior
			g.drawArc(fx2P-11, fy2P-30, wC, hC, -100, -90);
			
			//curva da ponta direita superior
			g.drawArc(lxP-15, lyP, wC, hC+3, 0, 100);
			//curva da ponta direita inferior
			g.drawArc(lx2P-15, ly2P-30, wC, hC, 0, -100);
			
			//linhas verticais esquerda
			if(i > 0)
				g.drawLine(fxP-36, fyP-8, fx2P-36, fy2P+10);
			
			//linhas verticais direita
			if(i > 0)
				g.drawLine(lxP+40, lyP-10, lx2P+40, ly2P+10);
			/*
			if(i > 3){
				//curva da ponta esquerda superior
				g.fillArc(fxP-11, fyP, wC, hC, 100, 85);
				//curva da ponta esquerda inferior
				g.fillArc(fx2P-11, fy2P-30, wC, hC, -100, -90);
				//curva da ponta direita superior
				g.fillArc(lxP-15, lyP, wC, hC, 0, 100);
				//curva da ponta direita inferior
				g.fillArc(lx2P-15, ly2P-30, wC, hC, 0, -100);
			}*/
			
			//==================fim linha=========================
			
			fxP += 25;
			fyP += 25;
			
			lxP -= 25;
			lyP += 25;
			
			fx2P += 25;
			fy2P -= 25;
			ly2P -= 25;
			lx2P -= 25;
			
			tamanhoHorizontal -= 50;
			tamanhoVertical -= 50;
		}
		g.fillRect(vX-3, viY, 5, 25*4);
		
		return new ImageIcon(buffer);
	}
}
