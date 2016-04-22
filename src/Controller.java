public class Controller {
	private EventSet es = new EventSet();
	public void addEvent(Event c) {
		es.add(c); 
	}
	public void run() {	
		Event a;
		boolean perdeu = false, correu = false;
		int i = 0;
		while((a = es.getNext()) != null && !perdeu && !correu) {
			if(a.ready()) {
				if (i % 2 == 0) {
					System.out.println("------" + (i/2 + 1) + "a rodada -----------" );
				}
				a.action();
				if (a.treinadorDerrotado())
					perdeu = true;
				if (a.treinadorFugiu())
					correu = true;
				es.removeCurrent();
				i++;
			}
		}
	}
}
