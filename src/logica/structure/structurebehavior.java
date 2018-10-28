package logica.structure;
public interface structurebehavior<T> {
	//INTERFACE METHODS
	public void create(T element);
	public T extract() ;
	public void clear();
	public boolean isEmpty();
        @Override
	public String toString();
}
