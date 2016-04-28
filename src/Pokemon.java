public class Pokemon {
	private String nome;
	private String tipo;
	private int HP;
	private Ataque[] ataques;
	private int hpMax;
	public Pokemon(String nome, String tipo, int HP, Ataque[] listaAtaques){
		this.nome = nome;
		this.tipo = tipo;
		this.HP = HP;
		ataques = listaAtaques;
		hpMax = HP;
	}
	public String getNome(){
		return nome;
	}
	public String getTipo(){
		return tipo;
	}
	
	//Métodos relacionados ao estado do pokémon
	public int getHp() {
		return HP;
	}
	public int getHpMax() {
		return hpMax;
	}
	public void diminuiHP(double dano){
		int intDano = (int) dano;
		if (this.estaVivo()) {
			HP -= intDano;
		}
	}
	public void aumentaHP(int ganho){
		int auxHp = HP + ganho;
		if (auxHp <= hpMax)
			HP = auxHp;
		else
			HP = hpMax;
	} 
	public boolean estaVivo() {
		if (HP > 0)
			return true;
		return false;
	}
	
	//Métodos relacionados aos ataques do pokémon
	public String getAtaque(int num){
		return ataques[num].getNome();
	}
	public Ataque[] getListaAtk() {
		return ataques;
	}
	public int getDanoAtual(int num) {
		return ataques[num].getDano();
	}
	public void imprimeAtaques() {
		System.out.println("0 - " + this.ataques[0].getNome() +  "		 1 - " + this.ataques[1].getNome() );
		System.out.println("2 - " + this.ataques[2].getNome() +  "		 3 - " + this.ataques[3].getNome() );

	}
	public int associaTipo(String tipo){
		if(tipo.compareTo("Normal") == 0) return 0;
		else if(tipo.compareTo("Lutador") == 0) return 1;
		else if(tipo.compareTo("Voador") == 0) return 2;
		else if(tipo.compareTo("Venenoso") == 0) return 3;
		else if(tipo.compareTo("Terrestre") == 0) return 4;
		else if(tipo.compareTo("Rocha") == 0) return 5;
		else if(tipo.compareTo("Inseto") == 0) return 6;
		else if(tipo.compareTo("Fantasma") == 0) return 7;
		else if(tipo.compareTo("Aco") == 0) return 8;
		else if(tipo.compareTo("Fogo") == 0) return 9;
		else if(tipo.compareTo("Agua") == 0) return 10;
		else if(tipo.compareTo("Grama") == 0) return 11;
		else if(tipo.compareTo("Eletrico") == 0) return 12;
		else if(tipo.compareTo("Psiquico") == 0) return 13;
		else if(tipo.compareTo("Gelo") == 0) return 14;
		else if(tipo.compareTo("Dragao") == 0) return 15;
		else if(tipo.compareTo("Escuro") == 0) return 16;
		else if(tipo.compareTo("Fada") == 0) return 17;		
		else return -1;
	}
	public double vantagem(Pokemon alvo){
		double m = 0.5; //Constante "1/2"
		double[][] vantagem = { {1, 1, 1, 1, 1, m, 1, 0, m, 1, 1, 1, 1, 1, 1, 1, 1, 1},
								{2, 1, m, m, 1, 2, m, 0, 2, 1, 1, 1, 1, m, 2, 1, 2, m},
								{1, 2, 1, 1, 1, m, 2, 1, m, 1, 1, 2, m, 1, 1, 1, 1, 1},
								{1, 1, 1, m, m, m, 1, m, 0, 1, 1, 2, 1, 1, 1, 1, 1, 2},
								{1, 1, 0, 2, 1, 2, m, 1, 2, 2, 1, m, 2, 1, 1, 1, 1, 1},
								{1, m, 2, 1, m, 1, 2, 1, m, 2, 1, 1, 1, 1, 2, 1, 1, 1},
								{1, m, m, m, 1, 1, 1, m, m, m, 1, 2, 1, 2, 1, 1, 2, m},
								{0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, m, 1},
								{1, 1, 1, 1, 1, 2, 1, 1, m, m, m, 1, m, 1, 2, 1, 1, 2},
								{1, 1, 1, 1, 1, m, 2, 1, 2, m, m, 2, 1, 1, 2, m, 1, 1},
								{1, 1, 1, 1, 2, 2, 1, 1, 1, 2, m, m, 1, 1, 1, m, 1, 1},
								{1, 1, m, m, 2, 2, m, 1, m, m, 2, m, 1, 1, 1, m, 1, 1},
								{1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, m, m, 1, 1, m, 1, 1},
								{1, 2, 1, 2, 1, 1, 1, 1, m, 1, 1, 1, 1, m, 1, 1, 0, 1},
								{1, 1, 2, 1, 2, 1, 1, 1, m, m, m, 2, 1, 1, m, 2, 1, 1},
								{1, 1, 1, 1, 1, 1, 1, 1, m, 1, 1, 1, 1, 1, 1, 2, 1, 0},
								{1, m, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, m, m},
								{1, 2, 1, m, 1, 1, 1, 1, m, m, 1, 1, 1, 1, 1, 2, 2, 1}
							}; //Tabela baseada em informações de http://bulbapedia.bulbagarden.net/wiki/Type
		int pkm1 = associaTipo(tipo), pkm2 = associaTipo(alvo.getTipo());
		return vantagem[pkm1][pkm2];
	}
}
