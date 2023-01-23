package back;

public class main {
	static final int DISTANCIA_TOTAL = 100;
	static final int MAX_SALTO = 10;

	public static void main(String[] args) {
		String[] nomes = {"Sedicla", "Serdna", "Lavesoj", "Aesod", "Erdna"};
		sapos[] sapos = new sapos[5];
		
		for(int i =0; i < 5; i++) 
			sapos[i] = new sapos(nomes[i], DISTANCIA_TOTAL, MAX_SALTO);
		
		
		for(int i =0; i < 5; i++)
			sapos[i].start();
	}
}
