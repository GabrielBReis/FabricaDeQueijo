package dao;


import java.util.List;

import entidades.Telefone;
import entidades.Cliente;

public interface TelefoneDao {
    void insert(Telefone telefone, Cliente cliente);
	void update(Telefone obj);
	void deleteById(Telefone id) throws Exception;
	Telefone findById(Telefone id);
	List <Telefone> findAll();
}
