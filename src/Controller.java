public class Controller {
	private EventSet es = new EventSet();
	public void addEvent(Event c) {
		es.add(c); 
	}
	public void run() {	
		Event a;
		boolean trocou = false;
		boolean perdeu = false, correu = false;
		while((a = es.getNext()) != null && !perdeu && !correu && !trocou) {
			if(a.ready()) {
				a.action();
				if (a.treinadorDerrotado())
					perdeu = true;
				if (a.treinadorFugiu())
					correu = true;
				if (a.treinadorTrocou())
					trocou = true;
				es.removeCurrent(); 
			}
		}
	}
}