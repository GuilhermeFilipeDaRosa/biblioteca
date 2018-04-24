/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.EmprestimoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Emprestimo;
import model.Estudante;
import model.Livro;

/**
 *
 * @author User
 */
public class EmprestimoForm extends javax.swing.JFrame {

    /**
     * Creates new form EmprestimoForm
     */
    public EmprestimoForm() {
        initComponents();
        try {
            emprestimoDAO = new EmprestimoDAO();
        } catch (Exception ex) {
            Logger.getLogger(EmprestimoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtEstudanteId = new javax.swing.JTextField();
        txtLivroId = new javax.swing.JTextField();
        txtDataDevolucao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        txtStatus = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnBuscarEstudante = new javax.swing.JButton();
        btnBuscarLivro = new javax.swing.JButton();
        btnEntrega = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDataEntrega = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("EMPRESTIMOS");

        jLabel2.setText("Emprestimo Id:");

        jLabel3.setText("Estudante Id:");

        jLabel4.setText("Livro Id:");

        jLabel5.setText("Data de Devolução: ");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emprestimo Id", "Estudante Id", "Livro Id", "Data  de Devolução", "Data  de Entrega", "Data de Retirada", "Status"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel7.setText("Status:");

        btnBuscarEstudante.setText("Buscar Estudante");
        btnBuscarEstudante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstudanteActionPerformed(evt);
            }
        });

        btnBuscarLivro.setText("Buscar Livro");
        btnBuscarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLivroActionPerformed(evt);
            }
        });

        btnEntrega.setText("Registrar Entrega");
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });

        jLabel6.setText("Data de Entrega");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar)
                        .addGap(27, 27, 27))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEntrega))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLivroId)
                                        .addGap(32, 32, 32)
                                        .addComponent(btnBuscarLivro))
                                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDataDevolucao)
                                    .addComponent(txtStatus)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(63, 63, 63)
                                .addComponent(txtEstudanteId)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarEstudante)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrega)
                    .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarEstudante)
                    .addComponent(txtEstudanteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarLivro)
                    .addComponent(txtLivroId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnDeletar)
                    .addComponent(btnSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(Integer.parseInt(txtId.getText()));
        //livro.setEditora((Editora) cbEditora.getSelectedItem());
        emprestimo.setEstudanteId(Integer.parseInt(txtEstudanteId.getText()));
        emprestimo.setLivroId(Integer.parseInt(txtLivroId.getText()));
        emprestimo.setStatus(txtStatus.getText());
        SimpleDateFormat f = new SimpleDateFormat("dd/mm/yyyy");
        Date dataDevolucao = new Date();
        try {
            dataDevolucao = f.parse(txtDataDevolucao.getText());
        } catch (ParseException ex) {
            Logger.getLogger(EmprestimoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        emprestimo.setDataDevolucao(dataDevolucao);
        try {
            if(mode.equals("INS")){
                emprestimoDAO.save(emprestimo);
            } else if(mode.equals("UPD")){
                emprestimoDAO.update(emprestimo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        listar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        txtId.setText("");
        txtEstudanteId.setText("");
        txtLivroId.setText("");
        txtStatus.setText("");
        txtDataDevolucao.setText("");
        mode = "INS";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(Integer.parseInt(txtId.getText()));
        try {
            emprestimoDAO.delete(emprestimo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        listar();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listar();
    }//GEN-LAST:event_formWindowOpened

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        mode="UPD";
        int row = tabela.getSelectedRow();
        txtId.setText((String) tabela.getValueAt(row, 0));
        txtEstudanteId.setText((String) tabela.getValueAt(row, 1));
        txtLivroId.setText((String) tabela.getValueAt(row, 2));
        txtDataDevolucao.setText((String) tabela.getValueAt(row, 3));
        txtStatus.setText((String) tabela.getValueAt(row, 6));
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnBuscarEstudanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstudanteActionPerformed
       EstudanteDialog dialog = new EstudanteDialog(this, true); // true impede o acesso a tela de baixo
       dialog.setVisible(true);
       txtEstudanteId.setText(""+dialog.getEstudanteId());
    }//GEN-LAST:event_btnBuscarEstudanteActionPerformed

    private void btnBuscarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLivroActionPerformed
       LivroDialog dialog = new LivroDialog(this, true); // true impede o acesso a tela de baixo
       dialog.setVisible(true);
       txtLivroId.setText(""+dialog.getLivroId());
    }//GEN-LAST:event_btnBuscarLivroActionPerformed

    private void btnEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregaActionPerformed
        Emprestimo emprestimo = new Emprestimo();
        SimpleDateFormat f = new SimpleDateFormat("dd/mm/yyyy");
        Date dataEntrega = new Date();
        try {
            dataEntrega = f.parse(txtDataEntrega.getText());
        } catch (ParseException ex) {
            Logger.getLogger(EmprestimoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        emprestimo.setDataEntrega(dataEntrega);
        emprestimo.setId(Integer.parseInt(txtId.getText()));
        try {
            emprestimoDAO.entrega(emprestimo);
        } catch (Exception ex) {
            Logger.getLogger(EmprestimoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        listar();
    }//GEN-LAST:event_btnEntregaActionPerformed
        public void listar(){
        DefaultTableModel model = (DefaultTableModel)tabela.getModel();
        // Limpar tabela
        model.setNumRows(0);
        try {
            //Buscar lista de objetos
            for (Emprestimo emprestimo  : emprestimoDAO.findAll()){
                String linha[] = {""+emprestimo.getId(), ""+emprestimo.getEstudanteId(), ""+emprestimo.getLivroId(), ""+emprestimo.getDataDevolucao(), ""+emprestimo.getDataEntrega(),
                                  ""+emprestimo.getDataRetirada(), emprestimo.getStatus()};
                model.addRow(linha);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmprestimoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmprestimoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmprestimoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmprestimoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmprestimoForm().setVisible(true);
            }
        });
    }
    private EmprestimoDAO emprestimoDAO;
    private String mode = "INS";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEstudante;
    private javax.swing.JButton btnBuscarLivro;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtDataDevolucao;
    private javax.swing.JTextField txtDataEntrega;
    private javax.swing.JTextField txtEstudanteId;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLivroId;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
