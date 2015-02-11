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

import ch.arkeine.markupextractor.extractor.Command;
import ch.arkeine.markupextractor.extractor.Extractor;
import ch.arkeine.markupextractor.tool.UrlTool;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nils Ryter
 */
public class CommandEditor extends javax.swing.JFrame {

    /**
     * Creates new form CommandEditor
     */
    public CommandEditor() {
        initComponents();
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
        btSaveCommand = new javax.swing.JButton();
        btLoadCommand = new javax.swing.JButton();
        panOther = new javax.swing.JPanel();
        btTestScript = new javax.swing.JButton();
        panGenerate = new javax.swing.JPanel();
        btMarkupFinder = new javax.swing.JButton();
        commandEditorConsole1 = new ch.arkeine.markupextractor.userinterface.CommandEditorConsole();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/arkeine/markupextractor/internationalization"); // NOI18N
        setTitle(bundle.getString("CommandEditor.title")); // NOI18N

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setResizeWeight(1.0);

        panFiles.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("CommandEditor.panFiles.border.title"))); // NOI18N

        btSaveCommand.setText(bundle.getString("CommandEditor.btSaveCommand.text")); // NOI18N
        btSaveCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveCommandActionPerformed(evt);
            }
        });

        btLoadCommand.setText(bundle.getString("CommandEditor.btLoadCommand.text")); // NOI18N
        btLoadCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoadCommandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panFilesLayout = new javax.swing.GroupLayout(panFiles);
        panFiles.setLayout(panFilesLayout);
        panFilesLayout.setHorizontalGroup(
            panFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSaveCommand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLoadCommand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panFilesLayout.setVerticalGroup(
            panFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSaveCommand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLoadCommand)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panOther.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("CommandEditor.panOther.border.title"))); // NOI18N

        btTestScript.setText(bundle.getString("CommandEditor.btTestScript.text")); // NOI18N
        btTestScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTestScriptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panOtherLayout = new javax.swing.GroupLayout(panOther);
        panOther.setLayout(panOtherLayout);
        panOtherLayout.setHorizontalGroup(
            panOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOtherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btTestScript, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        panOtherLayout.setVerticalGroup(
            panOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOtherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btTestScript)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panGenerate.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("CommandEditor.panGenerate.border.title"))); // NOI18N

        btMarkupFinder.setText(bundle.getString("CommandEditor.btMarkupFinder.text")); // NOI18N
        btMarkupFinder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMarkupFinderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panGenerateLayout = new javax.swing.GroupLayout(panGenerate);
        panGenerate.setLayout(panGenerateLayout);
        panGenerateLayout.setHorizontalGroup(
            panGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGenerateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btMarkupFinder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panGenerateLayout.setVerticalGroup(
            panGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGenerateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btMarkupFinder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panOther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel1);
        jSplitPane1.setLeftComponent(commandEditorConsole1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveCommandActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showSaveDialog(this);

        if(fc.getSelectedFile() == null) return;
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter(
                fc.getSelectedFile()))) {
            out.write(commandEditorConsole1.getText());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(CommandEditor.class.getName()).log(Level.WARNING,
                    null, ex);
        }
    }//GEN-LAST:event_btSaveCommandActionPerformed

    private void btLoadCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoadCommandActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);

        if(fc.getSelectedFile() == null) return;
        
        try (BufferedReader in = new BufferedReader(new FileReader(
                fc.getSelectedFile()))) {
            String line;
            StringBuilder s = new StringBuilder();
            while ((line = in.readLine()) != null) {
                s.append(line);
            }
            commandEditorConsole1.setText(s.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(CommandEditor.class.getName()).log(Level.WARNING,
                    null, ex);
        }
    }//GEN-LAST:event_btLoadCommandActionPerformed

    private void btMarkupFinderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMarkupFinderActionPerformed
        MarkupFinder m = new MarkupFinder();
        m.setVisible(true);
        
        String[] markups = m.getMarkups();
        assert markups.length == 2 : "error in markups array";
        
        Command[] cmd = new Command[1];
        cmd[0] = new Command(Command.CommandName.COPY);
        cmd[0].setParameter1(markups[0]);
        cmd[0].setParameter2(markups[1]);
        
        commandEditorConsole1.loadCommand(cmd);
    }//GEN-LAST:event_btMarkupFinderActionPerformed

    private void btTestScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTestScriptActionPerformed
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(
                "ch/arkeine/markupextractor/internationalization"); // NOI18N
        String[] url = new String[1];
        try {
            url[0] = UrlTool.loadURL(JOptionPane.showInputDialog(this, bundle.getString(
                    "CommandEditor.inputUrl.message")),"").toString();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, bundle.getString(
                    "CommandEditor.invalidUrl.message"));
            Logger.getLogger(CommandEditor.class.getName()).log(Level.WARNING,
                    null, ex);
        }
        
        String separator = JOptionPane.showInputDialog(this, bundle.getString(
                    "CommandEditor.separator.message"));
        
        Extractor extractor = new Extractor(commandEditorConsole1.saveCommand(), 
                url);
        extractor.run();
        
        JOptionPane.showMessageDialog(this, extractor.getExtractedToCSV(separator));
    }//GEN-LAST:event_btTestScriptActionPerformed

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
            java.util.logging.Logger.getLogger(CommandEditor.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommandEditor.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommandEditor.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommandEditor.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommandEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLoadCommand;
    private javax.swing.JButton btMarkupFinder;
    private javax.swing.JButton btSaveCommand;
    private javax.swing.JButton btTestScript;
    private ch.arkeine.markupextractor.userinterface.CommandEditorConsole commandEditorConsole1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel panFiles;
    private javax.swing.JPanel panGenerate;
    private javax.swing.JPanel panOther;
    // End of variables declaration//GEN-END:variables
}
