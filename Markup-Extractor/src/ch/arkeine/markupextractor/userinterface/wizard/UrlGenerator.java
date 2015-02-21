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
package ch.arkeine.markupextractor.userinterface.wizard;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Nils Ryter
 */
public class UrlGenerator extends javax.swing.JDialog {

    //OUTPUT
    private boolean isOk;
    private String[] urls;

    /**
     * Creates new form UrlGenerator
     */
    public UrlGenerator(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        isOk = false;
        urls = new String[0];
    }

    public String[] getUrlsGenerated() {
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

        titleBaseURL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBaseURL = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        titleToken = new javax.swing.JLabel();
        txtToken = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        titleInitialValue = new javax.swing.JLabel();
        spInitalValue = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        titleEndvalue = new javax.swing.JLabel();
        spEndValue = new javax.swing.JSpinner();
        btGenerate = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/arkeine/markupextractor/internationalization"); // NOI18N
        setTitle(bundle.getString("UrlGenerator.title")); // NOI18N

        titleBaseURL.setText(bundle.getString("UrlGenerator.titleBaseURL.text")); // NOI18N

        txtBaseURL.setColumns(20);
        txtBaseURL.setRows(1);
        jScrollPane1.setViewportView(txtBaseURL);

        titleToken.setText(bundle.getString("UrlGenerator.titleToken.text")); // NOI18N

        txtToken.setText(bundle.getString("UrlGenerator.txtToken.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(titleToken)
                .addGap(0, 59, Short.MAX_VALUE))
            .addComponent(txtToken)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(titleToken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        titleInitialValue.setText(bundle.getString("UrlGenerator.titleInitialValue.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spInitalValue)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(titleInitialValue)
                .addGap(0, 65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(titleInitialValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spInitalValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        titleEndvalue.setText(bundle.getString("UrlGenerator.titleEndvalue.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spEndValue)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(titleEndvalue)
                .addGap(0, 79, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(titleEndvalue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spEndValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btGenerate.setText(bundle.getString("UrlGenerator.btGenerate.text")); // NOI18N
        btGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerateActionPerformed(evt);
            }
        });

        btCancel.setText(bundle.getString("UrlGenerator.btCancel.text")); // NOI18N
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleBaseURL)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btGenerate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleBaseURL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGenerate)
                    .addComponent(btCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerateActionPerformed
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(
                "ch/arkeine/markupextractor/internationalization"); // NOI18N
        String base = txtBaseURL.getText();
        String token = txtToken.getText();

        if ((int) spInitalValue.getValue() >= (int) spEndValue.getValue()) {
            JOptionPane.showMessageDialog(this, bundle.getString(
                    "UrlGeneratorMenu.message.invalidIndex"));

        } else if (StringUtils.countMatches(base, token) != 1) {
            JOptionPane.showMessageDialog(this, bundle.getString(
                    "UrlGeneratorMenu.message.invalidToken"));

        } else {

            String[] tmpUrl = new String[(int) spEndValue.getValue()
                    - (int) spInitalValue.getValue()];
            for (int i = 0; i < tmpUrl.length; i++) {
                tmpUrl[i] = base.replaceFirst(token, Integer.toString(
                        i + (int) spInitalValue.getValue()));
                System.out.println(tmpUrl[i]);
            }

            urls = tmpUrl;
            isOk = true;
            dispose();
        }
    }//GEN-LAST:event_btGenerateActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btGenerate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spEndValue;
    private javax.swing.JSpinner spInitalValue;
    private javax.swing.JLabel titleBaseURL;
    private javax.swing.JLabel titleEndvalue;
    private javax.swing.JLabel titleInitialValue;
    private javax.swing.JLabel titleToken;
    private javax.swing.JTextArea txtBaseURL;
    private javax.swing.JTextField txtToken;
    // End of variables declaration//GEN-END:variables
}
