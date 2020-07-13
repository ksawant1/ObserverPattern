package studentskills.mytree;


import studentskills.operation.Operation;

public interface Observer{

	public abstract void update(StudentRecord record, Operation operation);
}