package studentskills.mytree;
import studentskills.mytree.Subject;


public abstract class ObserverI {
	protected Subject subject;
	public abstract void update();
}