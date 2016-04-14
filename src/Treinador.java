
public class Treinador {
	private String nome;
	private Pokemon[] pokemons = new Pokemon[6];
	private Pokemon pokemonAtual;
	public Treinador (String nome, Pokemon[] listaDePokemons) {
		this.nome = nome;
		pokemons = listaDePokemons;	
		pokemonAtual = pokemons[0];
	}
	public class Atacar extends Event {
		public 	Atacar(long eventTime) {
			super(eventTime);
		}
		public void action() {
		//Ataca o outro pokemon		
		}
		public String description() {
			return "Algum texto";
		}
	}
}
