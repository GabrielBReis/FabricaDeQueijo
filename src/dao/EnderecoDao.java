package dao;
import java.util.List;
import entidades.Endereco;
import entidades.Cliente;
import entidades.ClienteFisico;

public interface EnderecoDao {
    void insert(Endereco endereco, Cliente cliente);
	void update(Endereco obj);
	void deleteById(Integer id) throws Exception;
	Endereco findById(Integer id);
	List <Endereco> findAll();
    Endereco findByCliente(ClienteFisico cliente);
}
