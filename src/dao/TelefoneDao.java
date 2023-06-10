package dao;

import java.util.List;

import entidades.Telefone;

public interface TelefoneDao {
    void insert(Telefone objeto);
	void update(Telefone objeto);
	void deleteById(Integer id) throws Exception;
	Telefone findById(Integer id);
	List <Telefone> findAll();
    //Telefone findByCliente(Cliente cliente);
}
