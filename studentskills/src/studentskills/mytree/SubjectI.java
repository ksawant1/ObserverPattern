package studentskills.mytree;

import studentskills.operation.Operation;

public interface SubjectI{

	void register(StudentRecord record);
	void unregister(StudentRecord record);
	void notifyObserver(StudentRecord record, Operation operation);

}
