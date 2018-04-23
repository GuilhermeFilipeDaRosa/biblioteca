
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
import model.Editora;
import util.ConnectionJdbc;


public class EditoraDAO {
    Connection connection;
    
    public EditoraDAO() throws Exception{
        connection = ConnectionJdbc.getConnection();
    }
    
    public void save(Editora editora) throws Exception{
        String SQL = "INSERT INTO EDITORA(EDITORA_ID, NOME, MUNICIPIO) VALUES(?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, editora.getEditora_id());
            p.setString(2, editora.getNome_editora());
            p.setString(3, editora.getMunicipio());
            p.execute();
            JOptionPane.showMessageDialog(null,"Salvo!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void delete(Editora editora) throws Exception{
        String SQL = "DELETE FROM EDITORA WHERE EDITORA_ID =?";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, editora.getEditora_id());
            p.execute();
            JOptionPane.showMessageDialog(null,"Deletado!");
        }catch(SQLException ex) {
           throw new Exception(ex);
        }
    }
    
    public void update(Editora editora) throws Exception{
        try {
            String SQL = "UPDATE EDITORA SET NOME=?, MUNICIPIO=? WHERE EDITORA_ID=?";
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, editora.getNome_editora());
            p.setString(2, editora.getMunicipio());
            p.setInt(3, editora.getEditora_id());
            p.execute();
            JOptionPane.showMessageDialog(null,"Atualizado!");
        }catch (SQLException ex){
            throw new Exception(ex);
        }
    }
    
    public List<Editora> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<Editora> list = new ArrayList<>();
        Editora objeto;
        String SQL = "SELECT * FROM EDITORA ORDER BY EDITORA_ID";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            // 
            ResultSet rs = p.executeQuery();
            // Navega a classe e informa o valor do BD
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Editora();
                objeto.setEditora_id(rs.getInt("EDITORA_ID"));
                objeto.setNome_editora(rs.getString("NOME"));
                objeto.setMunicipio(rs.getString("MUNICIPIO"));
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
