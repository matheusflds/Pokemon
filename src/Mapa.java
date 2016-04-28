

public class Mapa {
	private int linhas = 16;
	private int colunas = 29;
	private char[][] mapa = {
			{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
			{'|', ' ', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}			 
	};
	public void imprimeMapa (Treinador player) {
		int[] aux = player.localizacao();
		int x = aux[0], y = aux[1];
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				if (i == x && j == y)
					System.out.print('X');
				else
					System.out.print(mapa[i][j]);
			}
			System.out.println("");
		}
	}
	public boolean caminhoValido(Treinador jogador, String opcao){
		if( (opcao.compareTo("w") == 0	&&	jogador.localizacao()[0] == 1) ||
				(opcao.compareTo("a") == 0	&&	jogador.localizacao()[1] == 1)||
				(opcao.compareTo("s") == 0	&&	jogador.localizacao()[0] == 14)||
				(opcao.compareTo("d") == 0	&&	jogador.localizacao()[1] == 27) ){
			System.out.println("Movimento inválido. Você está na borda do mapa!");
			return false;
		}
		return true;		
	}
	public char localidade(int[] posicao){
		int lin = posicao[0], col = posicao[1];
		return mapa[lin][col];
	}
	public void moveJogador(Treinador jogador, String opcao){
		if(opcao.compareTo("w") == 0)
			jogador.move(jogador.localizacao()[0] -1, jogador.localizacao()[1]   );
		else if(opcao.compareTo("a") == 0)
			jogador.move(jogador.localizacao()[0]   , jogador.localizacao()[1] -1);
		else if(opcao.compareTo("s") == 0)
			jogador.move(jogador.localizacao()[0] +1, jogador.localizacao()[1]   );
		else if(opcao.compareTo("d") == 0)
			jogador.move(jogador.localizacao()[0]   , jogador.localizacao()[1] +1);
		
	}
	public static void main(String[] args) {
		
	}
}

