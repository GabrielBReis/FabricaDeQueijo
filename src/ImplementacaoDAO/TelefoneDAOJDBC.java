package ImplementacaoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.TelefoneDao;
import db.DB;
import db.DbException;
import entidades.Cliente;
import entidades.Telefone;

public class TelefoneDaoJDBC implements TelefoneDao {

    private Connection conexaoBanco;

    public TelefoneDaoJDBC(Connection conn) {
        this.conexaoBanco = conn;
    }

    @Override
    public void insert(Telefone telefone, Cliente cliente) {
        PreparedStatement st = null;
        try {
            st = conexaoBanco.prepareStatement("INSERT INTO telefones (ddd, numero) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, telefone.getDDD());
            st.setString(2, telefone.getNumero());
            int telefonesAcrescentados = st.executeUpdate();

            if (telefonesAcrescentados > 0) {
                ResultSet chavesGeradasTelefone = st.getGeneratedKeys();
                if (chavesGeradasTelefone.next()) {
                    int idTelefone = chavesGeradasTelefone.getInt(1);
                    cliente.setTelefone(idTelefone);
                }
                DB.closeResultSet(chavesGeradasTelefone);
            } else {
                System.out.println("Nenhum telefone acrescentado!");
                // throw new UnsupportedOperationException("Unimplemented method 'insert'");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Telefone telefone) {
        PreparedStatement atualizarTelefone = null;
        try {
            atualizarTelefone = conexaoBanco.prepareStatement("UPDATE telefones SET ddd = ?, numero = ? WHERE id_telefone = ?");
            atualizarTelefone.setString(1, telefone.getDDD());
            atualizarTelefone.setString(2, telefone.getNumero());
            atualizarTelefone.setInt(3, telefone.getID());
            atualizarTelefone.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(atualizarTelefone);
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        PreparedStatement deletarTelefone = null;
        try {
            deletarTelefone = conexaoBanco.prepareStatement("DELETE FROM telefones WHERE id_telefone = ?");
            deletarTelefone.setInt(1, id);
            deletarTelefone.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(deletarTelefone);
        }
    }

    @Override
    public Telefone findById(Integer id) {
        PreparedStatement encontrarTelefone = null;
        ResultSet resultado = null;
        try {
            encontrarTelefone = conexaoBanco.prepareStatement("SELECT * FROM telefones WHERE id_telefone = ?");
            encontrarTelefone.setInt(1, id);
            resultado = encontrarTelefone.executeQuery();

            if (resultado.next()) {
                Telefone telefone = new Telefone();
                telefone.setID(resultado.getInt("id_telefone"));
                telefone.setDDD(resultado.getString("ddd"));
                telefone.setNumero(resultado.getString("numero"));
                return telefone;
            }

            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarTelefone);
        }
    }

    @Override
    public List<Telefone> findAll() {
        PreparedStatement encontrarTelefones = null;
        ResultSet resultado = null;
        try {
            encontrarTelefones = conexaoBanco.prepareStatement("SELECT * FROM telefones");
            resultado = encontrarTelefones.executeQuery();

            List<Telefone> telefones = new ArrayList<>();

            while (resultado.next()) {
                Telefone telefone = new Telefone();
                telefone.setID(resultado.getInt("id_telefone"));
                telefone.setDDD(resultado.getString("ddd"));
                telefone.setNumero(resultado.getString("numero"));
                telefones.add(telefone);
            }

            return telefones;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarTelefones);
        }
    }
}
