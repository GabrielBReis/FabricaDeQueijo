package dao;
import java.util.List;

import entidades.ClienteJuridico;
import entidades.Cliente;

public interface ClienteJuridicoDao {
    void insert(Cliente cliente, ClienteJuridico objeto);
	void update(ClienteJuridico objeto);
	void deleteById(Integer id) throws Exception;
	Cliente findById(Integer id);
	List <ClienteJuridico> findAll();
}




