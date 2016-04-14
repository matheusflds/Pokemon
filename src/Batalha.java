
public class Batalha extends Controller {
	Treinador Jogador1;
	Treinador Jogador2;
	public Batalha (Treinador um, Treinador dois) {
		Jogador1 = um;
		Jogador2 = dois;
	}
	private class Atacar extends Event {
		private Treinador jogador;
		private int ataque;
		public 	Atacar(long eventTime) {
			super(eventTime);
		}
		public void action() {
			//Ataca o outro pokemon		
		}
		public String description() {
			return (pokemonAtual.getNome() + "usou" + pokemonAtual.getAtaque(ataque));
		}		
	}
	public static void main(String[] args) {
	

	}

}
