package br.ifpe.edu.agendamento.model.dao;

import java.util.List;

/**
 * @author JJunio
 *
 */
public interface DAOGeneric<T> {

	public abstract boolean add(T t);
	public abstract boolean update(T t);
	public abstract boolean clear(T t);
	public abstract List<T> listAll();
}

