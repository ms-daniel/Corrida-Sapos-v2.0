package back;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sapos extends Thread{
	private Object colocacao = new Object();
	private static List<Object> colocados = new ArrayList<>();
	private String nome;
	private Random alea = new Random();
	private int salto;
	private int max_salto;
	private int total_p = 0;
	private int total_corrida;
	
	public sapos(String nome, int total_corrida, int max_salto) {
		this.nome = nome;
		this.total_corrida = total_corrida;
		this.max_salto = max_salto + 1; 
	}
	
	public void run() {
		while(total_p < total_corrida) {
			Saltar();
			Relatorio();
			if(total_p >= total_corrida) 
				Chegada();
		}
	}
	
	private void Saltar() {
		salto = alea.nextInt(this.max_salto);
		total_p += salto;
	}
	
	private void Relatorio(){
		System.out.println(this.nome + " saltou " + salto + "cm");
	}
	
	synchronized private void Chegada() {
		synchronized(colocados) {
			colocados.add(colocacao);
			System.out.println( "Parabéns! " + this.nome + " chegou em " + colocados.size() +"°!");
		}
	}
	
	public void Placar() {
		for(int i =0; i < 5; i++)
			System.out.println("|" + i + "° - " + this.nome);
	}
}
