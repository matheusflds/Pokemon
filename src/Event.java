
public abstract class Event {
	private long evtTime;
	public Event(long eventTime) {
		evtTime = eventTime;
	}
	public boolean ready() {
		return System.currentTimeMillis() >= evtTime;
	}
	abstract public void action();
	abstract public int prioridade();
	abstract public boolean treinadorDerrotado();
	abstract public boolean treinadorFugiu();
	abstract public boolean treinadorTrocou();//devolve true se o treinador substituiu um pokemon que acabou de ser derrotado
}
