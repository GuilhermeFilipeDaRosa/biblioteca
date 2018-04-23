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
import model.Editora;
import model.Livro;
import util.ConnectionJdbc;

public class LivroDAO {

    Connection connection;

    public LivroDAO() throws Exception {
        connection = ConnectionJdbc.getConnection();
    }

    public void save(Livro livro) throws Exception {
        String SQL = "INSERT INTO LIVRO VALUES (?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, livro.getLivro_id());
            p.setInt(2, livro.getEditora().getEditora_id());
            p.setString(3, livro.getTitulo());
            p.setInt(4, livro.getAno());
            p.setString(5, livro.getDescricao());
            p.execute();
            JOptionPane.showMessageDialog(null, "Salvo!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void saveAutorLivro(Autor autor, Livro livro) throws Exception{
        String SQL = "INSERT INTO AUTOR_LIVRO(AUTOR_ID, LIVRO_ID) VALUES(?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, autor.getAutor_id());
            p.setInt(2, livro.getLivro_id());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void update(Livro livro) throws Exception {
        String SQL = "UPDATE  LIVRO SET EDITORA_ID=?,TITULO=?,ANO=?,DESCRICAO=? WHERE LIVRO_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, livro.getEditora().getEditora_id());
            p.setString(2, livro.getTitulo());
            p.setInt(3, livro.getAno());
            p.setString(4, livro.getDescricao());
            p.setInt(5, livro.getLivro_id());

            p.execute();
            JOptionPane.showMessageDialog(null, "Atualizado!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Livro livro) throws Exception {
        String SQL = "DELETE FROM LIVRO WHERE LIVRO_ID=?";
        String SQL2 = "DELETE FROM AUTOR_LIVRO WHERE LIVRO_ID = ?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, livro.getLivro_id());
            p.execute();
            PreparedStatement p2 = connection.prepareStatement(SQL2);
            p2.setInt(1, livro.getLivro_id());
            p2.execute();
            JOptionPane.showMessageDialog(null, "Deletado!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void deleteAutorLivro(Autor autor, Livro livro) throws Exception{
        String SQL = "DELETE FROM AUTOR_LIVRO WHERE LIVRO_ID = ? AND AUTOR_ID = ?";
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setInt(1, livro.getLivro_id());
        p.setInt(2, autor.getAutor_id());
        p.execute();
        JOptionPane.showMessageDialog(null, "Deletado!");
    }
    

    public Livro findById(int id) throws Exception {
        Livro objeto = new Livro();
        String SQL = "SELECT L.*,E.NOME FROM LIVRO L INNER JOIN EDITORA E ON E.EDITORA_ID = L.EDITORA_ID "
                + "WHERE LIVRO_ID = ? ";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            // Navega a classe e informa o valor do BD
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Livro();
                objeto.setLivro_id(rs.getInt("livro_id"));
                objeto.setTitulo(rs.getString("titulo"));
                objeto.setAno(rs.getInt("ano"));
                objeto.setDescricao(rs.getString("descricao"));

                Editora editora = new Editora();
                editora.setEditora_id(rs.getInt("editora_id"));
                editora.setNome_editora(rs.getString("nome"));
                objeto.setEditora(editora);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
        objeto.setAutores(findAutoresLivro(objeto.getLivro_id()));
        return objeto;
    }

    public List<Livro> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<Livro> list = new ArrayList<>();
        Livro objeto;
        String SQL = "SELECT L.*,E.NOME FROM LIVRO L INNER JOIN EDITORA E ON E.EDITORA_ID = L.EDITORA_ID "
                + "ORDER BY L.LIVRO_ID";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            // 
            ResultSet rs = p.executeQuery();
            // Navega a classe e informa o valor do BD
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Livro();
                objeto.setLivro_id(rs.getInt("livro_id"));
                objeto.setTitulo(rs.getString("titulo"));
                objeto.setAno(rs.getInt("ano"));
                objeto.setDescricao(rs.getString("descricao"));

                Editora editora = new Editora();
                editora.setEditora_id(rs.getInt("editora_id"));
                editora.setNome_editora(rs.getString("nome"));
                objeto.setEditora(editora);
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
    
    private List<Autor> findAutoresLivro(int livroId) throws Exception{
        List<Autor> lista = new ArrayList<>();
        String SQL = "SELECT AL.AUTOR_ID, A.NOME FROM AUTOR_LIVRO AS AL "
                + "INNER JOIN AUTOR AS A ON A.AUTOR_ID = AL.AUTOR_ID "
                + "WHERE LIVRO_ID = ?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, livroId);
            ResultSet rs = p.executeQuery();
            
            while(rs.next()){
                Autor a = new Autor();
                a.setAutor_id(rs.getInt("AUTOR_ID"));
                a.setNome(rs.getString("NOME"));
                lista.add(a);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
           throw new Exception(ex);
        }
        return lista;
    }

    public static void main(String[] args) {
        try {
            new LivroDAO().findAll();
        } catch (Exception ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
