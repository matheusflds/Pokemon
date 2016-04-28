public class Treinador {
	private String nome;
	private Pokemon[] pokemons = new Pokemon[6];
	private Pokemon pokemonAtual;
	private boolean correu;
	private boolean derrotado;
	private int[] posicao = {1,1}; 
	
	public Treinador (String nome, Pokemon[] listaDePokemons) {
		this.nome = nome;
		pokemons = listaDePokemons;	
		pokemonAtual = pokemons[0];
		correu = false;
		derrotado = false;
	}
	public String getNome() {
		return nome;
	}
	
	//Métodos relacionados aos pokémons do treinador	
	public Pokemon getPokemon(int i) {
		return pokemons[i];
	}
	public Pokemon getPokemonAtual() {
		return pokemonAtual;
	}
	public String getAtaqueAtual (int num) {
		return pokemonAtual.getAtaque(num);
	}
	public int getDanoAtual(int num) {
		return pokemonAtual.getDanoAtual(num);
	}
	public void recebeAtaque (int dano) {
		pokemonAtual.diminuiHP(dano);
	}
	public void cura() {
		if (pokemonAtual.estaVivo())
			pokemonAtual.aumentaHP(100);
	}
	public int quantosPokemons() {
		return pokemons.length;
	}
	public void mudaPokemonAtual(int i) {
		if (pokemons[i].estaVivo())
			pokemonAtual = pokemons[i];
	}
	public boolean temPokemonVivo() {
		boolean tem = false;
		int size = pokemons.length;
		for (int i = 0; i < size ; i++) 
			if (pokemons[i].estaVivo()) tem = true;
		return tem;
	}
	public void imprimePokemons() {
		int aux = pokemons.length;
		for (int i = 0; i < aux; i++) {
			if (pokemons[i].estaVivo())
				System.out.println(i + " - " + pokemons[i].getNome());
		}
	}
	public void adicionaPokemon(Pokemon novo) {
		int qtd = pokemons.length;
		
		boolean trocou = false;
		//verifica se tem algum espaço vazio
		for (int i = 0; i < qtd; i++) {
			if (!pokemons[i].estaVivo()) {
				pokemons[i] = novo;
				trocou = true;
			}
		}
		if (!trocou && qtd < 6) {	
			//cria uma lista auxiliar
			Pokemon[] novaLista = new Pokemon[qtd + 1];
			for(int i = 0; i < qtd; i++)
				novaLista[i] = pokemons[i];
			novaLista[qtd] = novo;
			pokemons = novaLista;
			System.out.println("Pokemon " + novo.getNome() + "foi adicionado à sua lista!");
		}
		else
			System.out.println("Sua lista de pokemons está cheia!");
	}
	
	//Métodos relacionados a fuga ou derrota do treinador
		public boolean perdeu() {
			return derrotado;
		}
		public void foiDerrotado() {
			derrotado = true;
		}
		
		public void corre() {
			correu = true;
		}
		public boolean fugiu() {
			return correu;
		}
		public void voltaCorreu(){
			correu = false;
		}
	
	//Métodos relacionados à posição do treinador no mapa
	public int[] localizacao() {
		return posicao;
	}
	public void move(int lin, int col) {
		int[] novaPosicao = {lin, col};
		posicao = novaPosicao;
	}
}