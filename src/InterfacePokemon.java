import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//Esta classe tem como objetivo interagir com o usuário
public class InterfacePokemon {
	
	public static void main(String[] args) throws FileNotFoundException {			
		
		Scanner leitura = new Scanner (System.in);
		
		System.out.println("Simulação do jogo Pokemon\n");
		System.out.println("Bem vindo! O que deseja fazer?");
		System.out.println("Digite 1 se quiser batalhar com outro treinador.");
		System.out.println("Digite 2 se quiser andar pelo mapa.");
		System.out.println("Digite 3 se quiser sair do jogo.");
		
		int tipoJogo = leitura.nextInt(); 
		
		if(tipoJogo == 1){
			//Criando os treinadores
			Scanner treinadores = new Scanner(new FileReader("criaTreinadores.txt")).useDelimiter("\\||\\n");
			//por alguma razão, não conseguimos ler o .txt ao utilizarmos o terminal do linux, mas funcionou normalmente executando pelo Eclipse.
			//Criando o primeiro jogador			
			String nome1 = treinadores.next();
			int quantidade = treinadores.nextInt();				
			Pokemon[] listaPokemon1 = new Pokemon[quantidade];
			for (int i = 0; i < quantidade; i++) {
				String nomePok = treinadores.next();
				String tipo = treinadores.next();
				int hp = treinadores.nextInt();
				Ataque[] listaAtk = new Ataque[4];
				for (int j = 0; j < 4; j++) {
					String nomeAtk = treinadores.next();
					int dano = treinadores.nextInt();
					listaAtk[j] = new Ataque(nomeAtk, dano);
				}	
				listaPokemon1[i] = new Pokemon(nomePok, tipo, hp, listaAtk);
			}
			Treinador jogador1 = new Treinador (nome1, listaPokemon1);
			//Criando o segundo jogador
			
			String nome2 = treinadores.next();
			quantidade = treinadores.nextInt();				
			Pokemon[] listaPokemon2 = new Pokemon[quantidade];
			for (int i = 0; i < quantidade; i++) {
				String nomePok = treinadores.next();
				String tipo = treinadores.next();
				int hp = treinadores.nextInt();
				Ataque[] listaAtk = new Ataque[4];
				for (int j = 0; j < 4; j++) {
					String nomeAtk = treinadores.next();
					int dano = treinadores.nextInt();
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
			Scanner treinador = new Scanner(new FileReader("criaTreinador.txt")).useDelimiter("\\||\\n");
			String nome = treinador.next();
			int quantidade = treinador.nextInt();				
			Pokemon[] listaPokemon = new Pokemon[quantidade];
			for (int i = 0; i < quantidade; i++) {
				String nomePok = treinador.next();
				String tipo = treinador.next();
				int hp = treinador.nextInt();
				Ataque[] listaAtk = new Ataque[4];
				for (int j = 0; j < 4; j++) {
					String nomeAtk = treinador.next();
					int dano = treinador.nextInt();
					listaAtk[j] = new Ataque(nomeAtk, dano);
				}	
				listaPokemon[i] = new Pokemon(nomePok, tipo, hp, listaAtk);
			}
			Treinador player = new Treinador (nome, listaPokemon);
				
			//Movimentação do jogador
			Mapa mapaJogo = new Mapa();
			mapaJogo.imprimeMapa(player);				
			System.out.println("Mover:\n" +
					"w - para cima		a - para a esquerda\n" +
					"s - para baixo		d - para a direita.\nSair: 0");
			System.out.println("Selecione: ");
			opcao = leitura.next(); 
			while(opcao.compareTo("0") != 0 && !player.perdeu()){						 
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
				if (!player.perdeu()) {
					//Escolha do próximo movimento
					mapaJogo.imprimeMapa(player);
					System.out.println("Selecione o próximo movimento: ");
					opcao = leitura.next(); 
				}
			}
		}
		else {
			System.out.println("Obrigado por jogar!");
		}
		leitura.close();
	}

}