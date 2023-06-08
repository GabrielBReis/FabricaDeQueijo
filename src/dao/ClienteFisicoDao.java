package dao;

import java.util.List;

import entidades.ClienteFisico;
import entidades.Cliente;


public interface ClienteFisicoDao {
	void insert(ClienteFisico obj);
	void update(ClienteFisico obj);
	void deleteById(Integer id) throws Exception;
	Cliente findById(Integer id);
	List <ClienteFisico> findAll();
}

