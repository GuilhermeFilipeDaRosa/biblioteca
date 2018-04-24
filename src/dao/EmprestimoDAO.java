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
import model.Emprestimo;
import model.Estudante;
import model.Livro;
import util.ConnectionJdbc;

public class EmprestimoDAO {

    Connection connection;

    public EmprestimoDAO() throws Exception {
        connection = ConnectionJdbc.getConnection();
    }

    public void save(Emprestimo emprestimo) throws Exception {
        String SQL = "INSERT INTO EMPRESTIMO(EMPRESTIMO_ID, LIVRO_ID, ESTUDANTE_ID, DATA_RETIRADA, DATA_DEVOLUCAO, STATUS) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, emprestimo.getId());
            p.setInt(2, emprestimo.getLivroId());
            p.setInt(3, emprestimo.getEstudanteId());
            java.util.Date d = new java.util.Date();
            java.sql.Date dt = new java.sql.Date (d.getTime());
            p.setDate(4, dt);
            p.setDate(5, new Date(emprestimo.getDataDevolucao().getTime()));
            p.setString(6, emprestimo.getStatus());
            p.execute();
            JOptionPane.showMessageDialog(null, "Inserido!");
        } catch (SQLException ex) {
            System.out.print("Erro aqui");
            throw new Exception(ex);
        }
    }
    
    public void update(Emprestimo emprestimo) throws Exception {
        String SQL = "UPDATE EMPRESTIMO SET LIVRO_ID=?, ESTUDANTE_ID=?, DATA_DEVOLUCAO=?, STATUS=? WHERE EMPRESTIMO_ID=?";
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setInt(1, emprestimo.getLivroId());
        p.setInt(2, emprestimo.getEstudanteId());
        p.setDate(3, new Date(emprestimo.getDataDevolucao().getTime()));
        p.setString(5, emprestimo.getStatus());
        p.setInt(5, emprestimo.getId());
        p.execute();
        JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO!");
    }
    public void entrega(Emprestimo emprestimo){
        String SQL = "UPDATE EMPRESTIMO SET DATA_ENTREGA=? WHERE EMPRESTIMO_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setDate(1, new Date(emprestimo.getDataEntrega().getTime()));
            p.setInt(2, emprestimo.getId());
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(Emprestimo emprestimo) throws Exception{
       String SQL="DELETE FROM EMPRESTIMO WHERE EMPRESTIMO_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, emprestimo.getId());
            p.execute();
            JOptionPane.showMessageDialog(null, "Registro deletado!");
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<Emprestimo> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<Emprestimo> list = new ArrayList<>();
        Emprestimo objeto;
        String SQL = "SELECT E.*, L.LIVRO_ID, ES.ESTUDANTE_ID FROM EMPRESTIMO E "
                + "INNER JOIN LIVRO L  ON L.LIVRO_ID = E.LIVRO_ID "
                + "INNER JOIN ESTUDANTE ES ON ES.ESTUDANTE_ID =  E.ESTUDANTE_ID "
                + "ORDER BY EMPRESTIMO_ID ";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            // 
            ResultSet rs = p.executeQuery();
            // Navega a classe e informa o valor do BD
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Emprestimo();
                objeto.setId(rs.getInt("EMPRESTIMO_ID"));
                //objeto.setLivroId(rs.getInt("LIVRO_ID"));
                //objeto.setEstudanteId(rs.getInt("ESTUDANTE_ID"));
                objeto.setDataEntrega(rs.getDate("DATA_ENTREGA"));
                objeto.setDataDevolucao(rs.getDate("DATA_DEVOLUCAO"));
                objeto.setDataRetirada(rs.getString("DATA_RETIRADA"));
                objeto.setStatus(rs.getString("STATUS"));
                objeto.setEstudanteId(rs.getInt("ESTUDANTE_ID"));
                objeto.setLivroId(rs.getInt("LIVRO_ID"));
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
