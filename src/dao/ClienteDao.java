package dao;

import java.util.List;

import entidades.Cliente;

public interface ClienteDao {
	void insert(Cliente obj);
	void update(Cliente obj);
	void deleteById(Integer id) throws Exception;
	Cliente findById(Integer id);
	List <Cliente> findAll();
}