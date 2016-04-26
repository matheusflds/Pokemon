
public class Mapa {
	private int linhas = 16;
	private int colunas = 29;
	private char[][] mapa = {
			{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
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
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '|'},
			{'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'}			 
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
	public static void main(String[] args) {
		System.out.println("Simulação do jogo Pokemon");
		System.out.println("Bem vindo! O que deseja fazer?");
		System.out.println("Digite 1 se quiser batalhar com outro treinador.");
		System.out.println("Digite 2 se quiser andar pelo mapa.");
		System.out.println("Digite 3 se quiser sair do jogo.");
		//Primeiro, vamos simular uma batalha entre dois treinadores
		int decisao	= 1; //aqui deveria na verdade interagir com o usuario, recebendo o número que o mesmo digitou
		while (decisao != 3) {
			System.out.println("Crie o jogador 1:");
			System.out.println("Digite o seu nome:");
			String nome1 = "Salaminho";
			System.out.println("Quantos pokemons deseja criar? (no máximo 6)");
			/*se tivesse interação aqui iriamos ler quantos pokemons o usuario quer e 
			teria um while, como não tem, vamos criar os pokemons um por um */
			Pokemon[] listaPokemon1 = {Pokemon.Charmander(), Pokemon.Bellsprout(), Pokemon.Slowpoke(),
					Pokemon.Gastly(), Pokemon.Fearow(), Pokemon.Staryu()};		
			Treinador jogador1 = new Treinador (nome1, listaPokemon1);
			System.out.println("Crie o jogador 2:");
			System.out.println("Digite o seu nome:");
			String nome2 = "Felix";
			System.out.println("Quantos pokemons deseja criar? (no máximo 6)");
			Pokemon[] listaPokemon2 = {Pokemon.Mew(), Pokemon.Bulbasaur(), Pokemon.Diglett(),
					Pokemon.Hitmontop(), Pokemon.Jigglypuff(), Pokemon.Squirtle()};			
			Treinador jogador2 = new Treinador (nome2, listaPokemon2);
			
			
		}
	}

}
