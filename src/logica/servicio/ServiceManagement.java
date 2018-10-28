package logica.servicio;

import logica.structure.*;

public class ServiceManagement<T extends Comparable<T>> implements structurebehavior<T> {
	//ATTRIBUTES
	private structurebehavior<T> structure;

	//GETTERS AND SETTERS
	public structurebehavior<T> getStructure() {
		return structure;
	}

	public void setStructure(structurebehavior<T> structure) {
		this.structure = structure;
	}

	// CONSTRUCTOR
	public ServiceManagement(boolean iscola) {
		if(iscola)
			this.structure = new cola<>();
                
                else
			this.structure = new Heap<>();
	}
        


	//INTERFACE METHODS
        @Override
	public void create(T element) {
		structure.create(element);
	}

	@Override
	public T extract() {
		return structure.extract();
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public String toString() {
		return "ServiceManagement [structure=" + structure.toString() + "]";
	}
	
	
	
	
}

