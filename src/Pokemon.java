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
	public int getHp() {
		return HP;
	}
	public String getTipo(){
		return tipo;
	}
	public String getAtaque(int num){
		return ataques[num].getNome();
	}
	public int getDanoAtual(int num) {
		return ataques[num].getDano();
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
	public int associaTipo(String tipo){
		if(tipo == "Normal") return 0;
		if(tipo == "Lutador") return 1;
		if(tipo == "Voador") return 2;
		if(tipo == "Venenoso") return 3;
		if(tipo == "Terrestre") return 4;
		if(tipo == "Rocha") return 5;
		if(tipo == "Inseto") return 6;
		if(tipo == "Fantasma") return 7;
		if(tipo == "Aco") return 8;
		if(tipo == "Fogo") return 9;
		if(tipo == "Agua") return 10;
		if(tipo == "Grama") return 11;
		if(tipo == "Eletrico") return 12;
		if(tipo == "Psiquico") return 13;
		if(tipo == "Gelo") return 14;
		if(tipo == "Dragao") return 15;
		if(tipo == "Escuro") return 16;
		if(tipo == "Fada") return 17;
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
	public void imprimeAtaques() {
		for(int i = 0; i < 4; i++) {
			System.out.println(i + " - " + this.ataques[i].getNome());
		}
	}
	
}

