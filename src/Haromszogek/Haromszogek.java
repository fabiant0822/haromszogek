package Haromszogek;

import Haromszogek.DHaromszog.Kivetel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabian Tamas 1.0
 */
public class Haromszogek extends javax.swing.JFrame {

    DefaultListModel<String> lm = new DefaultListModel<>();
    ArrayList<DHaromszog> haromszogek = new ArrayList<>();
  
    public Haromszogek() {
        initComponents();
        lstHaromszogek.setModel(lm);
    }
    
    private void megnyit() {
        if (fcMegnyit.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (Scanner be = new Scanner(fcMegnyit.getSelectedFile())) {
                txaHibak.setText("");
                txaAdatok.setText("");
                lm.clear();
                haromszogek.clear();
                int i = 1;
                DHaromszog h;
                while (be.hasNextLine()) {
                    try {
                        h = new DHaromszog(be.nextLine(), i++);
                        String v = h.getAdatok();
                        lm.addElement(v);
                        haromszogek.add(h);
                    } catch (Kivetel ex) {
                        txaHibak.append(ex.getMessage()+"\n");
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Nem tudtam megnyitni a fájlt!",
                        "Hiba!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void kijelol() {
        int i = lstHaromszogek.getSelectedIndex();
        if (i == -1) return;
        txaAdatok.setText(String.format("Kerület: %.2f\nTerület: %.2f", 
                haromszogek.get(i).getKerulet(), haromszogek.get(i).getTerulet()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fcMegnyit = new javax.swing.JFileChooser();
        btnBetolt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaHibak = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstHaromszogek = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaAdatok = new javax.swing.JTextArea();

        fcMegnyit.setApproveButtonMnemonic(77);
        fcMegnyit.setApproveButtonText("Megnyitás");
        fcMegnyit.setApproveButtonToolTipText("");
        fcMegnyit.setControlButtonsAreShown(false);
        fcMegnyit.setCurrentDirectory(new File("."));
        fcMegnyit.setDialogTitle("Megnyitás");
        fcMegnyit.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Derékszögű háromszögek");

        btnBetolt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBetolt.setText("Adatok betöltése");
        btnBetolt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBetoltActionPerformed(evt);
            }
        });

        txaHibak.setEditable(false);
        txaHibak.setColumns(20);
        txaHibak.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txaHibak.setRows(5);
        txaHibak.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hibák a kiválasztott állományban", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane1.setViewportView(txaHibak);

        lstHaromszogek.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Derékszögű háromszögek", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        lstHaromszogek.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstHaromszogek.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstHaromszogek.setToolTipText("");
        lstHaromszogek.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstHaromszogekValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstHaromszogek);

        txaAdatok.setEditable(false);
        txaAdatok.setColumns(20);
        txaAdatok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txaAdatok.setRows(5);
        txaAdatok.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kiválasztott derékszögű háromszög adatai", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane3.setViewportView(txaAdatok);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBetolt, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBetolt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBetoltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBetoltActionPerformed
        megnyit();
    }//GEN-LAST:event_btnBetoltActionPerformed

    private void lstHaromszogekValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstHaromszogekValueChanged
        kijelol();
    }//GEN-LAST:event_lstHaromszogekValueChanged

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
            java.util.logging.Logger.getLogger(Haromszogek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Haromszogek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Haromszogek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Haromszogek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Haromszogek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBetolt;
    private javax.swing.JFileChooser fcMegnyit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lstHaromszogek;
    private javax.swing.JTextArea txaAdatok;
    private javax.swing.JTextArea txaHibak;
    // End of variables declaration//GEN-END:variables
}
