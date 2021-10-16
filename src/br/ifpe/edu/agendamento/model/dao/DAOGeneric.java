package br.ifpe.edu.agendamento.model.dao;

/**
 * @author JJunio
 *
 */
public interface DAOGeneric<T> {

	public abstract boolean add(T t);

	public abstract boolean update(T t);

	public abstract boolean clear(T t);
}
