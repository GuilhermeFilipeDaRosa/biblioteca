package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Estudante;
import util.ConnectionJdbc;

public class EstudanteDAO {

    Connection connection;

    public EstudanteDAO() throws Exception {
        connection = ConnectionJdbc.getConnection();
    }

    public void save(Estudante estudante) throws Exception {
        String SQL = "INSERT INTO ESTUDANTE(ESTUDANTE_ID, NOME, CURSO, DATA_MATRICULA, STATUS) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, estudante.getId());
            p.setString(2, estudante.getNome());
            p.setString(3, estudante.getCurso());
            java.util.Date d = new java.util.Date();
            java.sql.Date dt = new java.sql.Date (d.getTime());
            p.setDate(4, dt);
            p.setString(5, estudante.getStatus());
            p.execute();
            JOptionPane.showMessageDialog(null, "Inserido!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void update(Estudante estudante) throws Exception {
        String SQL = "UPDATE ESTUDANTE SET NOME=?, CURSO=?, STATUS=? WHERE ESTUDANTE_ID=?";
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setString(1, estudante.getNome());
        p.setString(2, estudante.getCurso());
        p.setString(3, estudante.getStatus());
        p.setInt(4, estudante.getId());
        p.execute();
        JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO!");
    }
    
    public void delete(Estudante estudante) throws Exception{
       String SQL="DELETE FROM ESTUDANTE WHERE ESTUDANTE_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, estudante.getId());
            p.execute();
            JOptionPane.showMessageDialog(null, "Registro deletado!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<Estudante> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<Estudante> list = new ArrayList<>();
        Estudante objeto;
        String SQL = "SELECT * FROM ESTUDANTE ORDER BY ESTUDANTE_ID";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            // 
            ResultSet rs = p.executeQuery();
            // Navega a classe e informa o valor do BD
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Estudante();
                objeto.setId(rs.getInt("ESTUDANTE_ID"));
                objeto.setNome(rs.getString("NOME"));
                objeto.setCurso(rs.getString("CURSO"));
                objeto.setData(rs.getString("DATA_MATRICULA"));
                objeto.setStatus(rs.getString("STATUS"));
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
