package ClassesDeInterface;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal extends javax.swing.JFrame {
    
    frmColeta frmCol;
    frmMaterial frmMat;
    frmAgenteAmbiental frmAg;
    frmPontoColeta frmPost;
    frmItens frmIte;
    
    public static EntityManagerFactory emf;
    
    
    public Principal() {
        initComponents();
        
        emf = Persistence.createEntityManagerFactory("UP");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btPosto = new javax.swing.JButton();
        btAgente = new javax.swing.JButton();
        btMaterial = new javax.swing.JButton();
        btColeta = new javax.swing.JButton();
        btAgente1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btPosto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btPosto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/location.png"))); // NOI18N
        btPosto.setText("Ponto de Coleta");
        btPosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPostoActionPerformed(evt);
            }
        });

        btAgente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btAgente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/people.png"))); // NOI18N
        btAgente.setText("Agente Ambiental");
        btAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgenteActionPerformed(evt);
            }
        });

        btMaterial.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/paper.png"))); // NOI18N
        btMaterial.setText("Material");
        btMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMaterialActionPerformed(evt);
            }
        });

        btColeta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btColeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/interface.png"))); // NOI18N
        btColeta.setText("Coleta");
        btColeta.setFocusPainted(false);
        btColeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btColetaActionPerformed(evt);
            }
        });

        btAgente1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btAgente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/item64.png"))); // NOI18N
        btAgente1.setText("Itens de Coleta");
        btAgente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btAgente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btColeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btPosto, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(btMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btAgente1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btColeta)
                    .addComponent(btPosto))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgente)
                    .addComponent(btMaterial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAgente1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btColetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btColetaActionPerformed
       frmCol = new frmColeta();
       frmCol.setLocationRelativeTo(null);
       frmCol.setVisible(true);        
    }//GEN-LAST:event_btColetaActionPerformed

    private void btAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgenteActionPerformed
        frmAg = new frmAgenteAmbiental();
        frmAg.setLocationRelativeTo(null);
        frmAg.setVisible(true);
    }//GEN-LAST:event_btAgenteActionPerformed

    private void btPostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPostoActionPerformed
        frmPost = new frmPontoColeta();
        frmPost.setLocationRelativeTo(null);
        frmPost.setVisible(true);
    }//GEN-LAST:event_btPostoActionPerformed

    private void btMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMaterialActionPerformed
        frmMat = new frmMaterial();
        frmMat.setLocationRelativeTo(null);
        frmMat.setVisible(true);
    }//GEN-LAST:event_btMaterialActionPerformed

    private void btAgente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgente1ActionPerformed
        frmIte = new frmItens();
        frmIte.setLocationRelativeTo(null);
        frmIte.setVisible(true);
    }//GEN-LAST:event_btAgente1ActionPerformed

    
    public static void main(String args[]) {
      
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal p = new  Principal();
                p.setLocationRelativeTo(null);
                p.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgente;
    private javax.swing.JButton btAgente1;
    private javax.swing.JButton btColeta;
    private javax.swing.JButton btMaterial;
    private javax.swing.JButton btPosto;
    // End of variables declaration//GEN-END:variables
}
