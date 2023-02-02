package back;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class sapos extends Thread{
	private Object colocacao = new Object();
	private static List<Object> colocados = new ArrayList<>();
	private String nome;
	private Random alea = new Random();
	private int salto;
	private int max_salto;
	private int total_percorrido = 0;
	private int total_corrida;
	private JLabel myLabel;
	private Clip frog;
	private JLabel classificados[];
	private JTextPane relatorio;

	
	public sapos(String nome, int total_corrida, int max_salto, JLabel myLabel, int vert,
				int hori, JLabel classificados[], JTextPane relatorio) {
		this.nome = nome;
		this.total_corrida = total_corrida;
		this.max_salto = max_salto + 1; 
		this.myLabel = myLabel;
		this.classificados = classificados;
		this.relatorio = relatorio;
	}
	
	public void run() {
		
		while(total_percorrido < total_corrida) {
			Saltar();
			Relatorio();
			ChangeLocale();
			if(total_percorrido == total_corrida) {
				Chegada();
			}
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void ChangeLocale() {
		myLabel.setLocation(myLabel.getX()+salto, myLabel.getY());
	}
	
	private void Saltar() {
		salto = alea.nextInt(this.max_salto);

		if((total_percorrido + salto) > total_corrida)
			salto = total_corrida - total_percorrido;
		
		total_percorrido += salto;
	}
	
	private void Relatorio(){
		//relatorio.setText(relatorio.getText() + "\n" + this.nome + " saltou " + salto + "cm");
		System.out.println(this.nome + " saltou " + salto + "cm");
	}
	
	synchronized private void Chegada() {
		synchronized(colocados) {
			colocados.add(colocacao);
			
			classificados[colocados.size()].setText(colocados.size() + " - " + this.nome);
			
			System.out.println( "Parabéns! " + this.nome + " chegou em " + colocados.size() +"°!");
		}
	}
	
	public void Placar() {
		for(int i =0; i < 5; i++)
			System.out.println("|" + i + "° - " + this.nome);
	}
}
