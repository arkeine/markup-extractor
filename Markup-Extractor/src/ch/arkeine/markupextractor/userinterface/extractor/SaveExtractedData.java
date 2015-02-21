/*
 * Copyright 2015 nils.ryter.
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
package ch.arkeine.markupextractor.userinterface.extractor;

import ch.arkeine.markupextractor.extractor.Command;
import ch.arkeine.markupextractor.extractor.Extractor;
import ch.arkeine.markupextractor.tool.ToolFiles;
import ch.arkeine.markupextractor.tool.ToolMessages;
import ch.arkeine.markupextractor.tool.ToolUrls;
import ch.arkeine.markupextractor.userinterface.ScriptEditorMenu;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author nils.ryter
 */
public class SaveExtractedData extends javax.swing.JPanel {

    private Extractor extractor;
    
    public SaveExtractedData() {
        initComponents();
        extractor = new Extractor(new Command[0], new String[0], false);
    }
    
    public void setDataSource(Extractor e){
        extractor = e;
    }

    private void writeUrlsFile(String[] urls) {
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(
                "ch/arkeine/markupextractor/internationalization"); // NOI18N
        
        String extension = bundle.getString(".constant.urlFile.extension");
        String description = bundle.getString(".constant.urlFile.description");
        String summary = bundle.getString(".message.errorSummary");
        String title = bundle.getString(".message.errorTitle");

        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(ToolFiles.getFilter(extension, description));
        fc.showSaveDialog(this);

        if (fc.getSelectedFile() != null) {

            try {
                ToolFiles.writeStringToFile(ToolUrls.urlsToString(urls, "\n"),
                        fc.getSelectedFile().getAbsolutePath(),extension);
            } catch (IOException ex) {
                ToolMessages.showException(this, summary, title, ex);
                Logger.getLogger(ScriptEditorMenu.class.getName()).log(
                        Level.WARNING, null, ex);
            }
        }
    }
    
    private void writeDataToFile(){
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(
            "ch/arkeine/markupextractor/internationalization"); // NOI18N
        String extension = bundle.getString(".constant.urlFile.extension");
        String description = bundle.getString(".constant.urlFile.description");
        String summary = bundle.getString(".message.errorSummary");
        String title = bundle.getString(".message.errorTitle");

        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(ToolFiles.getFilter(extension, description));
        fc.showSaveDialog(this);

        String separator = JOptionPane.showInputDialog(this,
            bundle.getString("SummaryMenu.input.separator"));

        if (separator != null && !separator.isEmpty() && fc.getSelectedFile() != null) {

            try {
                ToolFiles.writeStringToFile(
                    extractor.getExtractedToCSV(separator),
                    fc.getSelectedFile().getAbsolutePath(),extension);
            } catch (IOException ex) {
                ToolMessages.showException(this, summary, title, ex);
                Logger.getLogger(ScriptEditorMenu.class.getName()).log(
                    Level.WARNING, null, ex);
            }

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

        jPanel2 = new javax.swing.JPanel();
        buttonSaveData = new javax.swing.JButton();
        labelSaveData = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelSaveAllUrl = new javax.swing.JLabel();
        buttonSaveAllUrl = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        labelSaveUrlsSuccess = new javax.swing.JLabel();
        buttonSaveUrlSuccess = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        labelSaveUrlError = new javax.swing.JLabel();
        buttonSaveUrlError = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(2, 2));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/arkeine/markupextractor/internationalization"); // NOI18N
        buttonSaveData.setText(bundle.getString("SaveExtractedData.buttonSaveData.text")); // NOI18N
        buttonSaveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveDataActionPerformed(evt);
            }
        });

        labelSaveData.setText(bundle.getString("SaveExtractedData.labelSaveData.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSaveData)
                    .addComponent(labelSaveData))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSaveData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSaveData)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(jPanel2);

        labelSaveAllUrl.setText(bundle.getString("SaveExtractedData.labelSaveAllUrl.text")); // NOI18N

        buttonSaveAllUrl.setText(bundle.getString("SaveExtractedData.buttonSaveAllUrl.text")); // NOI18N
        buttonSaveAllUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveAllUrlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSaveAllUrl)
                    .addComponent(buttonSaveAllUrl))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSaveAllUrl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSaveAllUrl)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(jPanel3);

        labelSaveUrlsSuccess.setText(bundle.getString("SaveExtractedData.labelSaveUrlsSuccess.text")); // NOI18N

        buttonSaveUrlSuccess.setText(bundle.getString("SaveExtractedData.buttonSaveUrlSuccess.text")); // NOI18N
        buttonSaveUrlSuccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveUrlSuccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSaveUrlsSuccess)
                    .addComponent(buttonSaveUrlSuccess))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSaveUrlsSuccess)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSaveUrlSuccess)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(jPanel6);

        labelSaveUrlError.setText(bundle.getString("SaveExtractedData.labelSaveUrlError.text")); // NOI18N

        buttonSaveUrlError.setText(bundle.getString("SaveExtractedData.buttonSaveUrlError.text")); // NOI18N
        buttonSaveUrlError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveUrlErrorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSaveUrlError)
                    .addComponent(buttonSaveUrlError))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSaveUrlError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSaveUrlError)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(jPanel4);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveDataActionPerformed
        writeDataToFile();
    }//GEN-LAST:event_buttonSaveDataActionPerformed

    private void buttonSaveAllUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveAllUrlActionPerformed
        writeUrlsFile(extractor.getDoc());
    }//GEN-LAST:event_buttonSaveAllUrlActionPerformed

    private void buttonSaveUrlErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveUrlErrorActionPerformed
        writeUrlsFile(extractor.getNoExtractedDoc());
    }//GEN-LAST:event_buttonSaveUrlErrorActionPerformed

    private void buttonSaveUrlSuccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveUrlSuccessActionPerformed
        writeUrlsFile(extractor.getExtractedDoc());
    }//GEN-LAST:event_buttonSaveUrlSuccessActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSaveAllUrl;
    private javax.swing.JButton buttonSaveData;
    private javax.swing.JButton buttonSaveUrlError;
    private javax.swing.JButton buttonSaveUrlSuccess;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelSaveAllUrl;
    private javax.swing.JLabel labelSaveData;
    private javax.swing.JLabel labelSaveUrlError;
    private javax.swing.JLabel labelSaveUrlsSuccess;
    // End of variables declaration//GEN-END:variables
}
