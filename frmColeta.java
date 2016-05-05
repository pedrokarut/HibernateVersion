package ClassesDeInterface;
import DAO.AgenteAmbientalJpaController;
import DAO.ColetaJpaController;
import DAO.PontoColetaJpaController;
import DAO.exceptions.NonexistentEntityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AgenteAmbiental;
import model.Coleta;
import model.PontoColeta;


public class frmColeta extends javax.swing.JFrame {
    
    frmAgenteAmbiental frmAge;
    frmPontoColeta frmPont;
    Coleta c;
    AgenteAmbiental a;
    PontoColeta p;
    ColetaJpaController ColetaJPA;
    AgenteAmbientalJpaController AgenteJPA;
    PontoColetaJpaController PontoJPA;    
    public static long codColeta;
    
    public frmColeta() {
        initComponents();
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }

   private void LimpaCampos()
   {
       txtCodAgente.setText(null);
       txtCodColeta.setText(null);
       txtCodPonto.setText(null);
       txtData.setText(null);
   }
    
    private void LimpaJTable()
    {
        DefaultTableModel model = (DefaultTableModel) jTableColeta.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        jTableColeta.setModel(model);
    }
    
    private void PreencheJTable()
    {
        String[] cabecalhos = {"Código da Coleta", "Data", "Código do Agente", "Código do Ponto"};
        DefaultTableModel model = (DefaultTableModel) jTableColeta.getModel();
        model.setColumnIdentifiers(cabecalhos);
        
        ColetaJPA = new ColetaJpaController(Principal.emf);
        int numObjetos = ColetaJPA.getColetaCount();
        List<Coleta> Lista = ColetaJPA.findColetaEntities();
        
        for(int i=0;i<Lista.size();i++)
        {
            Object[][] objects = new Object[numObjetos][5];
            
            for(int j=0;j<numObjetos;j++)
            {
                Coleta c = new Coleta();
                c = Lista.get(i);
                objects[j][0] = c.getId();
                objects[j][1] = c.getDataColeta();
                objects[j][2] = c.getCodAgente().getId();
                objects[j][3] = c.getCodPonto().getId();
            }
                model.addRow(new Object[]{objects[i][0], objects[i][1], objects[i][2], objects[i][3]});

        }
         jTableColeta.setModel(model); 
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodColeta = new javax.swing.JTextField();
        txtCodPonto = new javax.swing.JTextField();
        txtCodAgente = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableColeta = new javax.swing.JTable();
        btAdicionarPonto = new javax.swing.JButton();
        btAdicionarAgente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btImportarColeta = new javax.swing.JButton();

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/interface.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Coleta");

        jLabel3.setText("Data:");

        jLabel4.setText("Código Ponto:");

        jLabel5.setText("Código Agente:");

        jLabel6.setText("Código Coleta:");

        txtCodColeta.setEditable(false);
        txtCodColeta.setEnabled(false);

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/draw.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon("/home/peter/Pictures/Coletas icons/CRUD16/png/close.png")); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jTableColeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableColeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableColetaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableColeta);

        btAdicionarPonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btAdicionarPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarPontoActionPerformed(evt);
            }
        });

        btAdicionarAgente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btAdicionarAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarAgenteActionPerformed(evt);
            }
        });

        jLabel7.setText("Lista de Coletas:");

        btImportarColeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btImportarColeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportarColetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btImportarColeta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtData, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCodColeta)
                                            .addComponent(txtCodPonto, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btAdicionarPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(254, 254, 254))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(122, 122, 122)))
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel3))
                                .addGap(0, 12, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAdicionarAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodColeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionarAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodPonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionarPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCadastrar)
                            .addComponent(btEditar)
                            .addComponent(btExcluir)))
                    .addComponent(btImportarColeta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarAgenteActionPerformed
        frmAge = new frmAgenteAmbiental();
        frmAge.setLocationRelativeTo(null);
        frmAge.setVisible(true);
    }//GEN-LAST:event_btAdicionarAgenteActionPerformed

    private void btAdicionarPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarPontoActionPerformed
        frmPont = new frmPontoColeta();
        frmPont.setLocationRelativeTo(null);
        frmPont.setVisible(true);
    }//GEN-LAST:event_btAdicionarPontoActionPerformed

    private void btImportarColetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportarColetaActionPerformed
        codColeta = Long.parseLong(txtCodColeta.getText());
        dispose();
    }//GEN-LAST:event_btImportarColetaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(frmAgenteAmbiental.codAgente != 0)
        {
            txtCodAgente.setText(String.valueOf(frmAgenteAmbiental.codAgente));
        }
        if(frmPontoColeta.codPonto != 0)
        {
            txtCodPonto.setText(String.valueOf(frmPontoColeta.codPonto));
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        c = new Coleta();
        AgenteJPA = new AgenteAmbientalJpaController(Principal.emf);
        a  = AgenteJPA.findAgenteAmbiental(Long.parseLong(txtCodAgente.getText()));
        PontoJPA = new PontoColetaJpaController(Principal.emf);
        p = PontoJPA.findPontoColeta(Long.parseLong(txtCodPonto.getText()));
        c.setCodAgente(a);
        c.setCodPonto(p);
        c.setDataColeta(txtData.getText());
        ColetaJPA = new ColetaJpaController(Principal.emf);
        ColetaJPA.create(c);
        JOptionPane.showMessageDialog(null, "Coleta realizada com sucesso!");
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        ColetaJPA = new ColetaJpaController(Principal.emf);
        c = ColetaJPA.findColeta(Long.parseLong(txtCodColeta.getText()));
        AgenteJPA = new AgenteAmbientalJpaController(Principal.emf);
        a  = AgenteJPA.findAgenteAmbiental(Long.parseLong(txtCodAgente.getText()));
        PontoJPA = new PontoColetaJpaController(Principal.emf);
        p = PontoJPA.findPontoColeta(Long.parseLong(txtCodPonto.getText()));
        c.setCodAgente(a);
        c.setCodPonto(p);
        c.setDataColeta(txtData.getText());        
        try
        {
            ColetaJPA.edit(c);
        }
        catch (Exception ex) 
        {
            Logger.getLogger(frmColeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Coleta alterada com sucesso!");
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        ColetaJPA = new ColetaJpaController(Principal.emf);
        try         
        {
            ColetaJPA.destroy(Long.parseLong(txtCodColeta.getText()));
        } 
        catch (NonexistentEntityException ex)
        {
            Logger.getLogger(frmColeta.class.getName()).log(Level.SEVERE, null, ex);
        }        
        JOptionPane.showMessageDialog(null, "Coleta deletada com sucesso!");
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void jTableColetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableColetaMouseClicked
        int linha = jTableColeta.getSelectedRow();
        txtCodColeta.setText(String.valueOf(jTableColeta.getValueAt(linha, 0)));
        txtData.setText(String.valueOf(jTableColeta.getValueAt(linha, 1)));
        txtCodAgente.setText(String.valueOf(jTableColeta.getValueAt(linha, 2)));
        txtCodPonto.setText(String.valueOf(jTableColeta.getValueAt(linha, 3)));
    }//GEN-LAST:event_jTableColetaMouseClicked

   
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
            java.util.logging.Logger.getLogger(frmColeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmColeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmColeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmColeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmColeta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarAgente;
    private javax.swing.JButton btAdicionarPonto;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btImportarColeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableColeta;
    private javax.swing.JTextField txtCodAgente;
    private javax.swing.JTextField txtCodColeta;
    private javax.swing.JTextField txtCodPonto;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
