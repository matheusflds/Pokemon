import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//Esta classe tem como objetivo interagir com o usuário
public class InterfacePokemon {
	
	public static void main(String[] args) throws FileNotFoundException {
		//para o exercicio 1 o arquivo de texto é "roteiro-ex1.txt"
		//e para o exercicio 2, "roteiro-ex2.txt"
		
		Scanner leitura = new Scanner(new FileReader("roteiro-ex1.txt")).useDelimiter("\\||\\n");
		//Caso não queira seguir o roteiro, e sim interagir com o software, basta utilizar o seguinte código:
		//Scanner leitura = new Scanner (System.in);
		
		System.out.println("Simulação do jogo Pokemon\n");
		System.out.println("Bem vindo! O que deseja fazer?");
		System.out.println("Digite 1 se quiser batalhar com outro treinador.");
		System.out.println("Digite 2 se quiser andar pelo mapa.");
		System.out.println("Digite 3 se quiser sair do jogo.");
		
		int tipoJogo = leitura.nextInt(); 
		
		if(tipoJogo == 1){
			//Criando o primeiro jogador
			System.out.println("Crie o primeiro jogador");
			System.out.println("Digite o seu nome:");
			String nome1 = leitura.next();
			System.out.println("Quantos pokemons deseja criar? (no máximo 6)");
			int quantidade = leitura.nextInt();				
			Pokemon[] listaPokemon1 = new Pokemon[quantidade];
			for (int i = 0; i < quantidade; i++) {
				System.out.println("Digite o nome do " + (i + 1) + "o" + " pokemon:");
				String nomePok = leitura.next();
				System.out.println("Digite o tipo");
				String tipo = leitura.next();
				System.out.println("Digite o Hp:");
				int hp = leitura.nextInt();
				System.out.println("Digite os (4) ataques (Digite o nome e em seguida o dano):");
				Ataque[] listaAtk = new Ataque[4];
				for (int j = 0; j < 4; j++) {
					String nomeAtk = leitura.next();
					int dano = leitura.nextInt();
					listaAtk[j] = new Ataque(nomeAtk, dano);
				}	
				listaPokemon1[i] = new Pokemon(nomePok, tipo, hp, listaAtk);
			}
			Treinador jogador1 = new Treinador (nome1, listaPokemon1);
			//Criando o segundo jogador
			System.out.println("Crie o segundo jogador");
			System.out.println("Digite o seu nome:");
			String nome2 = leitura.next();
			System.out.println("Quantos pokemons deseja criar? (no máximo 6)");
			quantidade = leitura.nextInt();				
			Pokemon[] listaPokemon2 = new Pokemon[quantidade];
			for (int i = 0; i < quantidade; i++) {
				System.out.println("Digite o nome do " + (i + 1) + "o" + " pokemon:");
				String nomePok = leitura.next();
				System.out.println("Digite o tipo");
				String tipo = leitura.next();
				System.out.println("Digite o Hp:");
				int hp = leitura.nextInt();
				System.out.println("Digite os (4) ataques (Digite o nome e em seguida o dano):");
				Ataque[] listaAtk = new Ataque[4];
				for (int j = 0; j < 4; j++) {
					String nomeAtk = leitura.next();
					int dano = leitura.nextInt();
					listaAtk[j] = new Ataque(nomeAtk, dano);
				}	
				listaPokemon2[i] = new Pokemon(nomePok, tipo, hp, listaAtk);
			}
			Treinador jogador2 = new Treinador (nome2, listaPokemon2);
			//Batalha entre os dois treinadores
			Batalha comum = new Batalha();
			comum.batalhaComum(jogador1, jogador2);			
		}
		else if(tipoJogo == 2){
			String opcao;				
			//Inicialização do jogo (Cria jogador com pokemons)
			System.out.println("Crie o primeiro jogador");
			System.out.println("Digite o seu nome:");
			String nome = leitura.next();
			System.out.println("Quantos pokemons deseja criar? (no máximo 6)");
			int quantidade = leitura.nextInt();				
			Pokemon[] listaPokemon = new Pokemon[quantidade];
			for (int i = 0; i < quantidade; i++) {
				System.out.println("Digite o nome do " + (i + 1) + "o" + " pokemon:");
				String nomePok = leitura.next();
				System.out.println("Digite o tipo");
				String tipo = leitura.next();
				System.out.println("Digite o Hp:");
				int hp = leitura.nextInt();
				System.out.println("Digite os (4) ataques (Digite o nome e em seguida o dano):");
				Ataque[] listaAtk = new Ataque[4];
				for (int j = 0; j < 4; j++) {
					String nomeAtk = leitura.next();
					int dano = leitura.nextInt();
					listaAtk[j] = new Ataque(nomeAtk, dano);
				}	
				listaPokemon[i] = new Pokemon(nomePok, tipo, hp, listaAtk);
			}
			Treinador player = new Treinador (nome, listaPokemon);
				
			//Movimentação do jogador
			Mapa mapaJogo = new Mapa();
			mapaJogo.imprimeMapa(player);				
			System.out.println("Mover: w - para cima		a - para a esquerda\n" +
										 " s - para baixo		d - para a direita.\n Sair: 0");
			System.out.println("Selecione: ");
			opcao = leitura.next(); 
			while(opcao.compareTo("0") != 0 && player.temPokemonVivo()){		
				System.out.println("Selecione o movimento: ");
				opcao = leitura.next(); 
				if(mapaJogo.caminhoValido(player,opcao)){						
					mapaJogo.moveJogador(player, opcao);	
					mapaJogo.imprimeMapa(player);						
					System.out.println("Posicao atual: " + player.localizacao()[0] + ", " + player.localizacao()[1]);
					/*Se o jogador estiver em grama alta, pode haver batalha com pokémon selvagem*/
					if(mapaJogo.localidade(player.localizacao()) == '*'){
						if(Math.random() > 0.5){//Math.random() > 0.5
							//Encontra batalha
							Batalha selvagem = new Batalha();
							selvagem.batalhaSelvagem(player);									
						}
					}				
				}								
			}
		}
		else {
			System.out.println("Obrigado por jogar!");
		}
		leitura.close();
	}

}