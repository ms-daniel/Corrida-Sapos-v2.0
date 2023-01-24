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
		int width=650, height=400, wC = 30, hC = 30, fxP = 12, fyP = 10, lxP = 612, lyP = 10;
		int fx2P = 12, fy2P = 152, ly2P = 152, lx2P = 612, tamanhoHorizontal = 600, tamanhoVertical = 112;
		
		//cria um buffer para a imagem
		buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.createGraphics();
		
		//
		for(int i = 0; i < 5; i++){
			g.setColor(corPista);
			//pintura
			//linhas horizontais superiores
			if(i < 4) {
				//linhas horizontais
				g.fillRect(fxP, fyP, tamanhoHorizontal, 14);
				g.fillRect(fx2P, fy2P-14, tamanhoHorizontal, 14);
				
				//linhas verticais
				if(i < 1) {
					g.fillRect(fxP-10, fyP+14, 14, tamanhoVertical);
					g.fillRect(lxP+2, lyP+14, 14, tamanhoVertical);
				}else {
					g.fillRect(fxP-10, fyP, 14, tamanhoVertical+32);
					g.fillRect(lxP+2, lyP, 14, tamanhoVertical+32);
				}
				
				g.fillArc(fxP-11, fyP, wC, hC, 100, 85);
				//curva da ponta esquerda inferior
				g.fillArc(fx2P-11, fy2P-30, wC, hC, -100, -90);
				//curva da ponta direita superior
				g.fillArc(lxP-15, lyP, wC, hC, 0, 100);
				//curva da ponta direita inferior
				g.fillArc(lx2P-15, ly2P-30, wC, hC, 0, -100);
				
			}else {
				g.fillRect(fxP-10, fyP-4, 14, tamanhoVertical+36);
				g.fillRect(lxP+2, lyP-4, 14, tamanhoVertical+36);
			}
			
			
			

			g.setColor( Color.WHITE );
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
			
			//linhas verticais esquerda
			if(i > 0)
				g.drawLine(fxP-25, fyP, fx2P-25, fy2P);
			
			//linhas verticais direita
			if(i > 0)
				g.drawLine(lxP+29, lyP, lx2P+29, ly2P);
			
			if(i > 3){
				//curva da ponta esquerda superior
				g.fillArc(fxP-11, fyP, wC, hC, 100, 85);
				//curva da ponta esquerda inferior
				g.fillArc(fx2P-11, fy2P-30, wC, hC, -100, -90);
				//curva da ponta direita superior
				g.fillArc(lxP-15, lyP, wC, hC, 0, 100);
				//curva da ponta direita inferior
				g.fillArc(lx2P-15, ly2P-30, wC, hC, 0, -100);
			}
			
			fxP += 14;
			fyP += 14;
			
			lxP -= 14;
			lyP += 14;
			
			fx2P += 14;
			fy2P -= 14;
			ly2P -= 14;
			lx2P -= 14;
			
			tamanhoHorizontal -= 28;
			tamanhoVertical -= 28;
			
			
		}
		//g.drawLine(1, 82, 645, 82);
		return new ImageIcon(buffer);
	}
}
