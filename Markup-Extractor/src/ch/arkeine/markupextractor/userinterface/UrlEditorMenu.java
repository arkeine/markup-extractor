/*
 * Copyright 2015 Nils Ryter.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.arkeine.markupextractor.userinterface;

import ch.arkeine.markupextractor.tool.FileTool;
import ch.arkeine.markupextractor.tool.UrlTool;
import ch.arkeine.markupextractor.userinterface.wizard.UrlGenerator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nils Ryter
 */
public class UrlEditorMenu extends javax.swing.JDialog {

    private boolean isOk;
    private String[] urls;

    /**
     * Creates new form UrlEditorMenu
     */
    public UrlEditorMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        isOk = false;
        urls = new String[0];
    }

    public String[] getUrls() {
        return urls;
    }

    public boolean isOk() {
        return isOk;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        panFiles = new javax.swing.JPanel();
        btSaveUrls = new javax.swing.JButton();
        btOpenUrls = new javax.swing.JButton();
        panGenerate = new javax.swing.JPanel();
        btUrlGenerator = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        btOk = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        titleUrls = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtUrls = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/arkeine/markupextractor/internationalization"); // NOI18N
        setTitle(bundle.getString("UrlEditorMenu.title")); // NOI18N

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setResizeWeight(1.0);

        panFiles.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("ScriptEditorMenu.panFiles.border.title"))); // NOI18N

        btSaveUrls.setText(bundle.getString("UrlEditorMenu.btSaveUrls.text")); // NOI18N
        btSaveUrls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveUrlsActionPerformed(evt);
            }
        });

        btOpenUrls.setText(bundle.getString("UrlEditorMenu.btOpenUrls.text")); // NOI18N
        btOpenUrls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenUrlsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panFilesLayout = new javax.swing.GroupLayout(panFiles);
        panFiles.setLayout(panFilesLayout);
        panFilesLayout.setHorizontalGroup(
            panFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSaveUrls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btOpenUrls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panFilesLayout.setVerticalGroup(
            panFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSaveUrls)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOpenUrls)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panGenerate.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("ScriptEditorMenu.panGenerate.border.title"))); // NOI18N

        btUrlGenerator.setText(bundle.getString("UrlEditorMenu.btUrlGenerator.text")); // NOI18N
        btUrlGenerator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUrlGeneratorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panGenerateLayout = new javax.swing.GroupLayout(panGenerate);
        panGenerate.setLayout(panGenerateLayout);
        panGenerateLayout.setHorizontalGroup(
            panGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGenerateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btUrlGenerator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panGenerateLayout.setVerticalGroup(
            panGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGenerateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btUrlGenerator)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btCancel.setText(bundle.getString("UrlEditorMenu.btCancel.text")); // NOI18N
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btOk.setText(bundle.getString("UrlEditorMenu.btOk.text")); // NOI18N
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancel)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel1);

        titleUrls.setText(bundle.getString("UrlEditorMenu.titleUrls.text")); // NOI18N

        txtUrls.setColumns(20);
        txtUrls.setRows(5);
        jScrollPane1.setViewportView(txtUrls);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(titleUrls)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleUrls)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        urls = txtUrls.getText().split("\n");
        isOk = true;
        dispose();
    }//GEN-LAST:event_btOkActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btSaveUrlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveUrlsActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(FileTool.getUrlsFilter());
        fc.showSaveDialog(this);

        if (fc.getSelectedFile() != null) {

            try {
                FileTool.writeStringToFile(fc.getSelectedFile().getAbsolutePath(),
                        UrlTool.urlsToString(urls), FileTool.URL_FILE_EXTENSION);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex);
                Logger.getLogger(ScriptEditorMenu.class.getName()).log(
                        Level.WARNING,
                        null, ex);
            }
        }
    }//GEN-LAST:event_btSaveUrlsActionPerformed

    private void btOpenUrlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpenUrlsActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(FileTool.getUrlsFilter());
        fc.showOpenDialog(this);

        if (fc.getSelectedFile() != null) {

            try {
                urls = UrlTool.stringToUrls(FileTool.readStringFromFile(
                        fc.getSelectedFile().getAbsolutePath()));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex);
                Logger.getLogger(ScriptEditorMenu.class.getName()).log(
                        Level.WARNING,
                        null, ex);
            }
        }
    }//GEN-LAST:event_btOpenUrlsActionPerformed

    private void btUrlGeneratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUrlGeneratorActionPerformed
        UrlGenerator dialog = new UrlGenerator(null, true);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        
        if(dialog.isOk())
        {
            txtUrls.setText(UrlTool.urlsToString(dialog.getUrlsGenerated()));
        }
    }//GEN-LAST:event_btUrlGeneratorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UrlEditorMenu.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrlEditorMenu.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrlEditorMenu.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrlEditorMenu.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UrlEditorMenu dialog = new UrlEditorMenu(
                        new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOk;
    private javax.swing.JButton btOpenUrls;
    private javax.swing.JButton btSaveUrls;
    private javax.swing.JButton btUrlGenerator;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel panFiles;
    private javax.swing.JPanel panGenerate;
    private javax.swing.JLabel titleUrls;
    private javax.swing.JTextArea txtUrls;
    // End of variables declaration//GEN-END:variables
}
