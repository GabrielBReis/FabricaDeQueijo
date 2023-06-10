package dao;
import java.util.List;
import entidades.Endereco;
import entidades.Cliente;

public interface EnderecoDao {
    void insert(Endereco objeto);
	void update(Endereco objeto);
	void deleteById(Integer id) throws Exception;
	Endereco findById(Integer id);
	List <Endereco> findAll();
    Endereco findByCliente(Cliente cliente);
}
