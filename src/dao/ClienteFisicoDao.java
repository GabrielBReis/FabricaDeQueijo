package dao;

import java.util.List;

import entidades.ClienteFisico;
import entidades.Cliente;

public interface ClienteFisicoDao {
	void insert(Cliente cliente, ClienteFisico objeto);
	void update(ClienteFisico objeto);
	void deleteById(Integer id) throws Exception;
	Cliente findById(Integer id);
	List <ClienteFisico> findAll();
}

