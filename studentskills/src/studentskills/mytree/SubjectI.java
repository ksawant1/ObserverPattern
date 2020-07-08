package studentskills.mytree;

public interface SubjectI{

	public void register(Observer o);
	public void unregister(Observer o);
	public void notifyObserver();

}
