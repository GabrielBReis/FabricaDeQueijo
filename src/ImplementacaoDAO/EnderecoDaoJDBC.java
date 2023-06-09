package ImplementacaoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.EnderecoDao;
import db.DB;
import db.DbException;
import entidades.Endereco;
import entidades.Cliente;
import entidades.ClienteFisico;

public class EnderecoDaoJDBC implements EnderecoDao {

    private Connection conexaoBanco;

    public EnderecoDaoJDBC(Connection conn) {
        this.conexaoBanco = conn;
    }

    @Override
    public void insert(Endereco endereco, Cliente cliente) {
        PreparedStatement inserirEndereco = null;
        try {
            inserirEndereco = conexaoBanco.prepareStatement("INSERT INTO enderecos (numero, logradouro) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            inserirEndereco.setString(1, endereco.getNumero());
            inserirEndereco.setString(2, endereco.getLogradouro());
            int enderecosAcrescentados = inserirEndereco.executeUpdate();
            if (enderecosAcrescentados > 0) {
                ResultSet chavesGeradasEndereco = inserirEndereco.getGeneratedKeys();
                if (chavesGeradasEndereco.next()) {
                    int idEndereco = chavesGeradasEndereco.getInt(1);
                    cliente.setEndereco(idEndereco);
                }
                DB.closeResultSet(chavesGeradasEndereco);
            } else {
                System.out.println("Nenhum endereço acrescentado!");
                // throw new UnsupportedOperationException("Unimplemented method 'insert'");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(inserirEndereco);
        }
    }

    @Override
    public void update(Endereco endereco) {
        PreparedStatement atualizarEndereco = null;
        try {
            atualizarEndereco = conexaoBanco.prepareStatement("UPDATE enderecos SET numero = ?, logradouro = ? WHERE id_endereco = ?");
            atualizarEndereco.setString(1, endereco.getNumero());
            atualizarEndereco.setString(2, endereco.getLogradouro());
            atualizarEndereco.setInt(3, endereco.getID());
            atualizarEndereco.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(atualizarEndereco);
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        PreparedStatement deletarEndereco = null;
        try {
            deletarEndereco = conexaoBanco.prepareStatement("DELETE FROM enderecos WHERE id_endereco = ?");
            deletarEndereco.setInt(1, id);
            deletarEndereco.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(deletarEndereco);
        }
    }

    @Override
    public Endereco findById(Integer id) {
        PreparedStatement encontrarEndereco = null;
        ResultSet resultado = null;
        try {
            encontrarEndereco = conexaoBanco.prepareStatement("SELECT * FROM enderecos WHERE id_endereco = ?");
            encontrarEndereco.setInt(1, id);
            resultado = encontrarEndereco.executeQuery();

            if (resultado.next()) {
                Endereco endereco = new Endereco();
                endereco.setID(resultado.getInt("id_endereco"));
                endereco.setNumero(resultado.getString("numero"));
                endereco.setLogradouro(resultado.getString("logradouro"));
                return endereco;
            }

            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarEndereco);
        }
    }

    @Override
    public List<Endereco> findAll() {
        PreparedStatement encontrarEnderecos = null;
        ResultSet resultado = null;
        try {
            encontrarEnderecos = conexaoBanco.prepareStatement("SELECT * FROM enderecos");
            resultado = encontrarEnderecos.executeQuery();

            List<Endereco> enderecos = new ArrayList<>();

            while (resultado.next()) {
                Endereco endereco = new Endereco();
                endereco.setID(resultado.getInt("id_endereco"));
                endereco.setNumero(resultado.getString("numero"));
                endereco.setLogradouro(resultado.getString("logradouro"));
                enderecos.add(endereco);
            }

            return enderecos;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarEnderecos);
        }
    }

    @Override
    public Endereco findByCliente(ClienteFisico cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCliente'");
    }


    
}
