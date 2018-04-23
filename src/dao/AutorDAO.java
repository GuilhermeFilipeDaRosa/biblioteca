package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Autor;
import util.ConnectionJdbc;

public class AutorDAO {

    Connection connection;

    public AutorDAO() throws Exception {
        connection = ConnectionJdbc.getConnection();
    }

    public void save(Autor autor) throws Exception {
        String SQL = "INSERT INTO AUTOR(autor_id, nome) VALUES (?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, autor.getAutor_id());
            p.setString(2, autor.getNome());
            p.execute();
            JOptionPane.showMessageDialog(null, "Salvo!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(Autor autor) throws Exception {
        String SQL = "UPDATE  AUTOR SET NOME=? WHERE AUTOR_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, autor.getNome());
            p.setInt(2, autor.getAutor_id());
            p.execute();
            JOptionPane.showMessageDialog(null, "Atualizado!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Autor autor) throws Exception {
        String SQL = "DELETE FROM AUTOR WHERE NOME=? AND AUTOR_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, autor.getNome());
            p.setInt(2, autor.getAutor_id());
            p.execute();
            JOptionPane.showMessageDialog(null, "Deletado!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public Autor findById(int d) {
        return new Autor();
    }

    public List<Autor> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<Autor> list = new ArrayList<>();
        Autor objeto;
        String SQL = "SELECT * FROM AUTOR ORDER BY AUTOR_ID";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            // 
            ResultSet rs = p.executeQuery();
            // Navega a classe e informa o valor do BD
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Autor();
                objeto.setAutor_id(rs.getInt("autor_id"));
                objeto.setNome(rs.getString("nome"));
                // Inclui na lista
                list.add(objeto);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
        // Retorna a lista
        return list;
    }
}
