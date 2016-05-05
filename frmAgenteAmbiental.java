package ClassesDeInterface;
import DAO.AgenteAmbientalJpaController;
import DAO.exceptions.NonexistentEntityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import model.AgenteAmbiental;


public class frmAgenteAmbiental extends javax.swing.JFrame {

    AgenteAmbiental a;
    AgenteAmbientalJpaController AgenteJPA;
    public static long codAgente;
    
    public frmAgenteAmbiental() {
        initComponents();
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }

    
    private void LimpaCampos()
    {
        txtCPF.setText(null);
        txtCodColetador.setText(null);
        txtDataNascimento.setText(null);
        txtEndereco.setText(null);
        txtNome.setText(null);
    }
    
    private void LimpaJTable()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        jTable1.setModel(model);
    }
    
    private void PreencheJTable()
    {
        String[] cabecalhos = {"Código do Agente", "Nome", "CPF", "Data de Nascimento", "Endereço"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(cabecalhos);
        
        AgenteJPA = new AgenteAmbientalJpaController(Principal.emf);
        int numObjetos = AgenteJPA.getAgenteAmbientalCount();
        List<AgenteAmbiental> Lista = AgenteJPA.findAgenteAmbientalEntities();
        
        for(int i=0;i<Lista.size();i++)
        {
            Object[][] objects = new Object[numObjetos][5];
            
            for(int j=0;j<numObjetos;j++)
            {
                AgenteAmbiental a = new AgenteAmbiental();
                a = Lista.get(i);
                objects[j][0] = a.getId();
                objects[j][1] = a.getNome();
                objects[j][2] = a.getCpf();
                objects[j][3] = a.getDataNascimento();
                objects[j][4] = a.getEndereco();
            }
                model.addRow(new Object[]{objects[i][0], objects[i][1], objects[i][2], objects[i][3], objects[i][4]});

        }
         jTable1.setModel(model); 
        
    }
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        UPEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("UP").createEntityManager();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodColetador = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtDataNascimento = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btLimpar = new javax.swing.JButton();
        btImportarAgente = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/people.png"))); // NOI18N

        jLabel2.setText("Endereço:");

        jLabel3.setText("Data de Nascimento:");

        jLabel4.setText("CPF:");

        jLabel5.setText("Nome:");

        jLabel6.setText("Código Coletador:");

        txtCodColetador.setEditable(false);
        txtCodColetador.setEnabled(false);

        jTable1.setName("jTable"); // NOI18N
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("Agente Ambiental");

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/broom.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btImportarAgente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/circle.png"))); // NOI18N
        btImportarAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportarAgenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btImportarAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCodColetador)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCPF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataNascimento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(23, 23, 23)
                        .addComponent(btLimpar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btCadastrar)
                            .addGap(36, 36, 36)
                            .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodColetador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btEditar)
                    .addComponent(btExcluir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImportarAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        a = new AgenteAmbiental();
        a.setNome(txtNome.getText());
        a.setEndereco(txtEndereco.getText());
        a.setDataNascimento(txtDataNascimento.getText());
        a.setCpf(Long.parseLong(txtCPF.getText()));
        AgenteJPA = new AgenteAmbientalJpaController(Principal.emf);
        AgenteJPA.create(a);
        JOptionPane.showMessageDialog(null, "Agente Ambiental cadastrado com sucesso!");
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int linha = jTable1.getSelectedRow();
        txtCodColetador.setText(String.valueOf(jTable1.getValueAt(linha, 0)));
        txtNome.setText(String.valueOf(jTable1.getValueAt(linha, 1)));
        txtCPF.setText(String.valueOf(jTable1.getValueAt(linha, 2)));
        txtDataNascimento.setText(String.valueOf(jTable1.getValueAt(linha, 3)));
        txtEndereco.setText(String.valueOf(jTable1.getValueAt(linha, 4)));
    }//GEN-LAST:event_jTable1MouseClicked

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        a = AgenteJPA.findAgenteAmbiental(Long.parseLong(txtCodColetador.getText()));
        a.setNome(txtNome.getText());
        a.setCpf(Long.parseLong(txtCPF.getText()));
        a.setDataNascimento(txtDataNascimento.getText());
        a.setEndereco(txtEndereco.getText());
        AgenteJPA = new AgenteAmbientalJpaController(Principal.emf);
        
        try 
        {
            AgenteJPA.edit(a);
        } 
        catch (Exception ex)
        {
            Logger.getLogger(frmAgenteAmbiental.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Agente editado com sucesso!");
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        AgenteJPA = new AgenteAmbientalJpaController(Principal.emf);
        try 
        {
            AgenteJPA.destroy(Long.parseLong(txtCodColetador.getText()));
        } 
        catch (NonexistentEntityException ex) 
        {
            Logger.getLogger(frmAgenteAmbiental.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Agente removido com sucesso!");
        LimpaCampos();
        LimpaJTable();
        PreencheJTable();
       
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btImportarAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportarAgenteActionPerformed
        codAgente = Long.parseLong(txtCodColetador.getText());
        dispose();
    }//GEN-LAST:event_btImportarAgenteActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
       LimpaCampos();
       LimpaJTable();
       PreencheJTable();
    }//GEN-LAST:event_btLimparActionPerformed

   
  
   
    
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgenteAmbiental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager UPEntityManager;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btImportarAgente;
    private javax.swing.JButton btLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCodColetador;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
