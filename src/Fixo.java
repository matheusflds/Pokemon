/*A classe fixo deverá conter objetos estáticos de treinadores e pokémons que serão usados para teste ou durante a execuçãop do jogo*/
public class Fixo {

		/*Esses métodos servem apenas para retornar um determinado pokemon dentre alguns já criados
		(poupando tempo na hora de criar pokemons para simular a batalha)*/
		public static Pokemon Diglett(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Scratch", 80);
			listaAtaque[1] = new Ataque("Mud-Slap", 40);
			listaAtaque[2] = new Ataque("Mud Bomb", 120);
			listaAtaque[3] = new Ataque("Earthquake", 150);
			return new Pokemon ("Diglett", "Terrestre", 400, listaAtaque);
		}
		public static Pokemon Mew(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Pound", 80);
			listaAtaque[1] = new Ataque("Psychic", 180);
			listaAtaque[2] = new Ataque("Mega Punch", 160);
			listaAtaque[3] = new Ataque("Aura Sphere", 160);
			return new Pokemon ("Mew", "Psiquico", 700, listaAtaque);
		}
		public static Pokemon Bulbasaur(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Tackle", 100);
			listaAtaque[1] = new Ataque("Vine Whip", 90);
			listaAtaque[2] = new Ataque("Razor Leaf", 110);
			listaAtaque[3] = new Ataque("Seed Bomb", 160);
			return new Pokemon ("Bulbasaur", "Grama", 400, listaAtaque);
		}
		public static Pokemon Squirtle(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Tackle", 100);
			listaAtaque[1] = new Ataque("Water Gun", 80);
			listaAtaque[2] = new Ataque("Aqua Tail", 180);
			listaAtaque[3] = new Ataque("Hydro Pump", 220);
			return new Pokemon ("Squirtle", "Agua", 400, listaAtaque);
		}
		public static Pokemon Charmander(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Scratch", 80);
			listaAtaque[1] = new Ataque("Ember", 80);
			listaAtaque[2] = new Ataque("Flame Burst", 140);
			listaAtaque[3] = new Ataque("Inferno", 200);
			return new Pokemon ("Charmander", "Fogo", 500, listaAtaque);
		}
		public static Pokemon Jigglypuff(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Pound", 80);
			listaAtaque[1] = new Ataque("Disarming Voice", 80);
			listaAtaque[2] = new Ataque("Round", 120);
			listaAtaque[3] = new Ataque("Hyper Voice", 180);
			return new Pokemon ("Jigglypuff", "Fada", 450, listaAtaque);
		}
		public static Pokemon Hitmontop(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Close Combat", 240);
			listaAtaque[1] = new Ataque("Revenge", 120);
			listaAtaque[2] = new Ataque("Rolling Kick", 120);
			listaAtaque[3] = new Ataque("Quick Attack", 80);
			return new Pokemon ("Hitmontop", "Lutador", 520, listaAtaque);
		}
		public static Pokemon Slowpoke(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Tackle", 100);
			listaAtaque[1] = new Ataque("Water Gun", 80);
			listaAtaque[2] = new Ataque("Zen Headbutt", 160);
			listaAtaque[3] = new Ataque("Psychic", 180);
			return new Pokemon ("Slowpoke", "Psiquico", 400, listaAtaque);
		}
		public static Pokemon Staryu(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Tackle", 100);
			listaAtaque[1] = new Ataque("Water Gun", 80);
			listaAtaque[2] = new Ataque("Bubble Beam", 130);
			listaAtaque[3] = new Ataque("Hydro Pump", 220);
			return new Pokemon ("Staryu", "Agua", 700, listaAtaque);
		}
		public static Pokemon Gastly(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Lick", 60);
			listaAtaque[1] = new Ataque("Shadow Ball", 160);
			listaAtaque[2] = new Ataque("Hex", 130);
			listaAtaque[3] = new Ataque("Dark Pulse", 160);
			return new Pokemon ("Gastly", "Fantasma", 500, listaAtaque);
		}
		public static Pokemon Bellsprout(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Vine Whip", 90);
			listaAtaque[1] = new Ataque("Acid", 80);
			listaAtaque[2] = new Ataque("Razor Leaf", 110);
			listaAtaque[3] = new Ataque("Slam", 160);
			return new Pokemon ("Bellsprout", "Grama", 500, listaAtaque);
		}
		public static Pokemon Fearow(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Pluck", 120);
			listaAtaque[1] = new Ataque("Peck", 70);
			listaAtaque[2] = new Ataque("Aerial Ace", 120); 
			listaAtaque[3] = new Ataque("Drill Peck", 160);
			return new Pokemon ("Fearow", "Voador", 600, listaAtaque);
		}
		public static Pokemon Pidgey(){
			Ataque[] listaAtaque = new Ataque[4];
			listaAtaque[0] = new Ataque("Tackle", 100);
			listaAtaque[1] = new Ataque("Gust", 80);
			listaAtaque[2] = new Ataque("Wing Attack", 120);
			listaAtaque[3] = new Ataque("Hurricane", 220);
			return new Pokemon ("Pidgey", "Voador", 50, listaAtaque);
		}
		
		//Estes métodos estáticos são apenas para criar treinadores "padrão", poupando tempo na hora da simulação
		public static Treinador criaTreinadorPadrao1 () {			
			Pokemon[] listaPokemon = {Fixo.Mew(), Fixo.Bulbasaur(), Fixo.Diglett(),
					Fixo.Hitmontop(), Fixo.Jigglypuff(), Fixo.Squirtle()};		
			return new Treinador ("Felix", listaPokemon);	
		}
		public static Treinador criaTreinadorPadrao2 () {		
			Pokemon[] listaPokemon = {Fixo.Charmander(), Fixo.Bellsprout(), Fixo.Slowpoke(),
					Fixo.Gastly(), Fixo.Fearow(), Fixo.Staryu()};		
			Treinador padrao = new Treinador ("Salaminho", listaPokemon);
			return padrao;		
		}

}
