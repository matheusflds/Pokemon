import java.util.Scanner;
import java.lang.Math;

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
	public char localidade(int lin, int col){
		return mapa[lin][col];
	}
	public void moveJogador(Treinador jogador, String opcao){
		if(opcao.compareTo("w") == 0)
			jogador.move(jogador.localizacao()[0] -1, jogador.localizacao()[1]   );
		if(opcao.compareTo("a") == 0)
			jogador.move(jogador.localizacao()[0]   , jogador.localizacao()[1] -1);
		if(opcao.compareTo("s") == 0)
			jogador.move(jogador.localizacao()[0] +1, jogador.localizacao()[1]   );
		if(opcao.compareTo("d") == 0)
			jogador.move(jogador.localizacao()[0]   , jogador.localizacao()[1] +1);
		else
			System.out.println("nao moveu!");
	}
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Simulação do jogo Pokemon");
		System.out.println("Bem vindo! O que deseja fazer?");
		System.out.println("Digite 1 se quiser batalhar com outro treinador.");
		System.out.println("Digite 2 se quiser andar pelo mapa.");
		System.out.println("Digite 3 se quiser sair do jogo.");
		//Primeiro, vamos simular uma batalha entre dois treinadores
		int tipoJogo = leitura.nextInt(); //aqui deveria na verdade interagir com o usuario, recebendo o número que o mesmo digitou
		if(tipoJogo == 1){
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
		else if(tipoJogo == 2){
			String opcao = " ";
			
			//Inicialização do jogo (Cria jogador com pokemons)
			Treinador player = Treinador.criaTreinadorPadrao1();
			//Movimentação do jogador
			Mapa mapaJogo = new Mapa();
			mapaJogo.imprimeMapa(player);
			
			System.out.println("Mover: w - para cima\n a - para a esquerda\n s - para baixo\n d - para a direita.\n Sair: 0");
			System.out.println("Selecione: ");
			opcao = leitura.next(); 
			while(opcao.compareTo("0") != 0){		
		
				if(mapaJogo.caminhoValido(player,opcao)){						
					mapaJogo.moveJogador(player, opcao);	
					mapaJogo.imprimeMapa(player);						
					System.out.println(player.localizacao()[0] + ", " + player.localizacao()[1]);
					/*Se o jogador estiver em grama alta, pode haver batalha com pokémon selvagem*/
					if(mapaJogo.localidade(player.localizacao()[0],player.localizacao()[1]) == '*'){
						if(Math.random() > 0.5){
							//Encontra batalha
						}
					}				
				}
				if (player.temPokemonVivo()) {	
					//Escolha do próximo movimento
					System.out.println("Selecione o próximo movimento: ");
					opcao = leitura.next(); 
				}
				else 
					opcao = "0";				
			}
		}
		else
			System.out.println("Obrigado por jogar!");		
	}
}


