public class Batalha extends Controller {
	
	//método para executar a simulação de uma batalha de acordo com o script(exercício 1)
	public void ScriptEx1() {
		System.out.println("Simulação de uma batalha entre dois Treinadores\n");
		Batalha simulacao = new Batalha();		
		long tm = System.currentTimeMillis();
		Treinador player2 = Treinador.criaTreinadorPadrao2();
		Treinador player1 = Treinador.criaTreinadorPadrao1();	
		
		simulacao.addEvent (simulacao.new Atacar(tm, player2, player1, 0));
		simulacao.addEvent (simulacao.new Atacar(tm, player1, player2, 0));		
		
		simulacao.addEvent (simulacao.new Atacar(tm, player2, player1, 1));
		simulacao.addEvent (simulacao.new Atacar(tm, player1, player2, 3));
		
		simulacao.addEvent (simulacao.new Atacar(tm, player2, player1, 1));
		simulacao.addEvent (simulacao.new Trocar(tm, player1, "Hitmontop"));
		
		simulacao.addEvent (simulacao.new Atacar(tm, player2, player1, 1));
		simulacao.addEvent (simulacao.new Atacar(tm, player1, player2, 2));
		
		simulacao.addEvent (simulacao.new Curar(tm, player2));
		simulacao.addEvent (simulacao.new Atacar(tm, player1, player2, 1));
		
		simulacao.addEvent (simulacao.new Atacar(tm, player2, player1, 1));
		simulacao.addEvent (simulacao.new Atacar(tm, player1, player2, 2));
		
		simulacao.addEvent (simulacao.new Atacar(tm, player2, player1, 1));
		simulacao.addEvent (simulacao.new Atacar(tm, player1, player2, 2));
		
		simulacao.addEvent (simulacao.new Atacar(tm, player2, player1, 1));
		simulacao.addEvent (simulacao.new Fugir(tm, player1));
		
		simulacao.run();
	}
	public void ScriptEx2() {
		System.out.println("Simulação de uma batalha entre dois Treinadores\n");
		Batalha simulacao = new Batalha();		
		long tm = System.currentTimeMillis();
		Treinador player2 = Treinador.criaTreinadorPadrao2();
		Treinador player1 = Treinador.criaTreinadorPadrao1();
		
		simulacao.addEvent (simulacao.new Trocar(tm, player2, "Gastly"));
		simulacao.addEvent (simulacao.new Trocar(tm, player1, "Hitmontop"));	
		
		simulacao.addEvent (simulacao.new Atacar(tm, player2, player1, 1));
		simulacao.addEvent (simulacao.new Atacar(tm, player1, player2, 2));
		
		simulacao.run();
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
				System.out.println(aux.getNome() + " foi derrotado.");
				if (alvo.temPokemonVivo()) {
					alvo.atualizaPokemonAtual();
					System.out.println("O pokemon derrotado foi substituido por " 
							+ alvo.getPokemonAtual().getNome() + ".\n");
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
		private String novoPokemon;
		public Trocar (long eventTime, Treinador jogador, String novoPokemon) {
			super(eventTime);
			this.jogador = jogador;
			this.novoPokemon = novoPokemon;
		}
		public void action() {
			for (int i = 0; i < jogador.quantosPokemons(); i++) {
				Pokemon aux = jogador.getPokemon(i);
				if (aux.estaVivo() && aux.getNome() == novoPokemon) {
					jogador.mudaPokemonAtual(i);
					System.out.println(jogador.getNome() + " trocou de pokemon. Pokemon atual: " + novoPokemon + ".\n");
				}
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
		Batalha simulacao = new Batalha();
		simulacao.ScriptEx1();		
	}

}
