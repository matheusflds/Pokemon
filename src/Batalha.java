import java.util.Scanner;
public class Batalha extends Controller {

	public void batalhaSelvagem (Treinador jogador) {
		//cria o treinador que tem o pokemon selvagem
		Scanner leitura = new Scanner (System.in);
		Pokemon[] listaPokemon = { Fixo.Pidgey()};
		Treinador inimigo = new Treinador ("Pokemon selvagem", listaPokemon);
		System.out.println("\nUm " + inimigo.getPokemonAtual().getNome() + " selvagem apareceu!");
		while (!jogador.fugiu() && jogador.temPokemonVivo() && inimigo.temPokemonVivo()) {	
			System.out.println("O que deseja fazer?");
			System.out.println("1 - Atacar\n2 - Usar poção de cura\n3 - Trocar de pokemon\n4 - Fugir");
			int opcao = leitura.nextInt();
			Batalha simulacao = new Batalha();
			if (opcao == 1) {
				System.out.println("Escolha o ataque: ");
				Pokemon aux = jogador.getPokemonAtual();
				aux.imprimeAtaques();
				opcao = leitura.nextInt();
				long tm = System.currentTimeMillis();
				simulacao.addEvent (new Atacar (tm, jogador, inimigo, opcao));
			}
			else if (opcao == 2) {
				long tm = System.currentTimeMillis();
				simulacao.addEvent (new Curar(tm, jogador));
			}
			else if (opcao == 3) {
				long tm = System.currentTimeMillis();
				System.out.println("Escolha o pokemon substituto: ");
				jogador.imprimePokemons();
				int novoPokemon = leitura.nextInt();
				simulacao.addEvent (new Trocar (tm, jogador, novoPokemon));
			}
			else if (opcao == 4) {
				long tm = System.currentTimeMillis();
				simulacao.addEvent (new Fugir (tm, jogador));
			}
			
			//Ataque do selvagem
			double sorteio = Math.random();
			if(sorteio < 0.25) {
				long tm = System.currentTimeMillis();
				simulacao.addEvent (new Atacar(tm, inimigo, jogador, 0));
			}
			else if(sorteio >= 0.25 && sorteio < 0.5) {
				long tm = System.currentTimeMillis();
				simulacao.addEvent (new Atacar(tm, inimigo, jogador, 1));
			}
			else if(sorteio >= 0.5 && sorteio < 0.75) {
				long tm = System.currentTimeMillis();
				simulacao.addEvent (new Atacar(tm, inimigo, jogador, 2));
			}
			else if(sorteio >= 0.75) {
				long tm = System.currentTimeMillis();
				simulacao.addEvent (new Atacar(tm, inimigo, jogador, 3));
			}
			simulacao.run();
		}
		leitura.close();
	}
	
	//Evento: Treinador ataca outro
	public class Atacar extends Event {
		private Treinador quemAtaca;
		private Treinador alvo;
		private int ataque;
		public 	Atacar(long eventTime, Treinador quemAtaca, Treinador alvo, int ataque) {
			super(eventTime);
			this.quemAtaca = quemAtaca;
			this.alvo = alvo;
			this.ataque = ataque;
		}
		public void action() {
			Pokemon aux = alvo.getPokemonAtual();
			double k = quemAtaca.getPokemonAtual().vantagem(aux);
			if (aux.estaVivo()) {
				aux.diminuiHP(k * quemAtaca.getDanoAtual(ataque));
				System.out.println(quemAtaca.getNome() + " decidiu atacar:");
				System.out.println(quemAtaca.getPokemonAtual().getNome() + 
						" usou " + quemAtaca.getAtaqueAtual(ataque) + "!");				
			}	
			if (aux.estaVivo()){
				if (k == 0)
					System.out.println("O ataque não surtiu efeito.");
				else if (k == 0.5)
					System.out.println("O ataque não foi muito efetivo.");
				else if (k == 2)
					System.out.println("O ataque foi muito efetivo!");
				System.out.println(aux.getNome() + " agora tem " + alvo.getPokemonAtual().getHp() + "HP.\n");
			}
			else {
				Scanner leitura = new Scanner(System.in);
				System.out.println(aux.getNome() + " foi derrotado.");
				/*Substituição do pokémon derrotado*/
				if (alvo.temPokemonVivo()) {
					System.out.println("Escolha o pokemon substituto (digite o nome): ");
					alvo.imprimePokemons();
					int novoPokemon = leitura.nextInt();
					long tm = System.currentTimeMillis();
					Trocar troca = new Trocar (tm, alvo, novoPokemon);
					troca.action();
				}
				else {
					System.out.println (alvo.getNome() + " foi derrotado!\n");
					alvo.foiDerrotado();
				}
			}
				
		}
		public int prioridade() {
			return 4;
		}
		public boolean treinadorDerrotado() {
			return alvo.perdeu();
		}
		public boolean treinadorFugiu() {
			return false;
		}
	}
	//Evento: Treinador foge de uma batalha
	public class Fugir extends Event {
		private Treinador jogador;
		public Fugir (long eventTime, Treinador jogador) {
			super(eventTime);
			this.jogador = jogador;
		}
		public void action() {
			jogador.corre();	
			System.out.println (jogador.getNome() + " escapou com segurança.\n");
		}
		public int prioridade() {
			return 1;
		}
		public boolean treinadorDerrotado() {
			return false;
		}
		public boolean treinadorFugiu() {
			return jogador.fugiu();
		}
	}
	//Evento: Treinador troca de pokemon
	public class Trocar extends Event {
		private Treinador jogador;
		private int novoPokemon;
		public Trocar (long eventTime, Treinador jogador, int novoPokemon) {
			super(eventTime);
			this.jogador = jogador;
			this.novoPokemon = novoPokemon;
		}
		public void action() {
			Pokemon aux = jogador.getPokemon(novoPokemon);
			if (aux.estaVivo()) {
				jogador.mudaPokemonAtual(novoPokemon);
				System.out.println(jogador.getNome() + " trocou de pokemon. Pokemon atual: " + aux.getNome() + ".\n");
			}
		}
		public int prioridade() {
			return 2;
		}
		public boolean treinadorDerrotado() {
			return false;
		}
		public boolean treinadorFugiu() {
			return false;
		}
	}
	//Evento: Treinador usa poção de cura (Cura 100 de HP)
	public class Curar extends Event {
		private Treinador jogador;
		public 	Curar(long eventTime, Treinador jogador) {
			super(eventTime);
			this.jogador = jogador;
		}
		public void action() {
			jogador.cura();	
			System.out.println(jogador.getNome() + " usou Poção de cura(100HP). " +
					jogador.getPokemonAtual().getNome() + " agora tem " + jogador.getPokemonAtual().getHp() + ".\n");
		}
		public int prioridade() {
			return 3;
		}
		public boolean treinadorDerrotado() {
			return false;
		}
		public boolean treinadorFugiu() {
			return false;
		}
	}
	public static void main(String[] args) {
			
	}

}
