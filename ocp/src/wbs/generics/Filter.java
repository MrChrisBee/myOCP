package wbs.generics;

public interface Filter<T> {
	
	public boolean accepts(T t);

}
