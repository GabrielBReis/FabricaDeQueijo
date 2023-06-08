package dao;
import java.util.List;
import entidades.Endereco;
import entidades.Cliente;

public interface EnderecoDao {
    void insert(Endereco endereco, Cliente cliente);
	void update(Endereco obj);
	void deleteById(Endereco id) throws Exception;
	Endereco findById(Endereco id);
	List <Endereco> findAll();
}
