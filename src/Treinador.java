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
	public boolean perdeu() {
		return derrotado;
	}
	public void foiDerrotado() {
		derrotado = true;
	}
	public String getNome() {
		return nome;
	}
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
	public void corre() {
		correu = true;
	}
	public boolean fugiu() {
		return correu;
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
	//No caso de um pokemon ser derrotado, substitui o mesmo por um pokemon que ainda nao foi derrotado.
	/*obs: na verdade, quando um pokemon é derrotado, o jogador escolhe o substituo. Mas como nesse exercício não tem
	 * interação, o método escolhe o primeiro pokemon livre */
	public void atualizaPokemonAtual() {
		int size = pokemons.length;
		for (int i = 0; i < size ; i++) 
			if (pokemons[i].estaVivo()) {
				pokemonAtual = pokemons[i];
				break;
			}
	}
	public int[] localizacao() {
		return posicao;
	}
	public void move(int[] novaPosicao) {
		posicao = novaPosicao;
	}
	//Estes métodos estáticos são apenas para criar treinadores "padrão", poupando tempo na hora da simulação
	public static Treinador criaTreinadorPadrao1 () {			
		Pokemon[] listaPokemon = {Pokemon.Mew(), Pokemon.Bulbasaur(), Pokemon.Diglett(),
				Pokemon.Hitmontop(), Pokemon.Jigglypuff(), Pokemon.Squirtle()};		
		return new Treinador ("Felix", listaPokemon);	
	}
	public static Treinador criaTreinadorPadrao2 () {		
		Pokemon[] listaPokemon = {Pokemon.Charmander(), Pokemon.Bellsprout(), Pokemon.Slowpoke(),
				Pokemon.Gastly(), Pokemon.Fearow(), Pokemon.Staryu()};		
		Treinador padrao = new Treinador ("Salaminho", listaPokemon);
		return padrao;		
	}
	
}
