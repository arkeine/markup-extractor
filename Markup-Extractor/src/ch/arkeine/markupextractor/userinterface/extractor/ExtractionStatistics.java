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

import ch.arkeine.markupextractor.extractor.Extractor;

public class ExtractionStatistics extends javax.swing.JPanel {

    /**
     * Creates new form ExtractedStatistic
     */
    public ExtractionStatistics() {
        initComponents();
    }
    
    public void loadStatistic(Extractor extractor){
        txtNbError.setText(
                Integer.toString(extractor.getNoExtractedDoc().length));
        txtNbExtracted.setText(Integer.toString(
                extractor.getExtractedDoc().length));
        txtNbAllUrls.setText(Integer.toString(
                extractor.getDoc().length));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleFail = new javax.swing.JLabel();
        txtNbExtracted = new javax.swing.JLabel();
        txtNbError = new javax.swing.JLabel();
        titleNbAllUrls = new javax.swing.JLabel();
        txtNbAllUrls = new javax.swing.JLabel();
        titleExtracted = new javax.swing.JLabel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/arkeine/markupextractor/internationalization"); // NOI18N
        titleFail.setText(bundle.getString("ExtractionStatistics.titleFail.text")); // NOI18N

        titleNbAllUrls.setText(bundle.getString("ExtractionStatistics.titleNbAllUrls.text")); // NOI18N

        titleExtracted.setText(bundle.getString("ExtractionStatistics.titleExtracted.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleExtracted)
                    .addComponent(titleFail)
                    .addComponent(titleNbAllUrls))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNbExtracted, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(txtNbAllUrls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNbError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNbExtracted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleExtracted))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNbError, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleFail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleNbAllUrls)
                    .addComponent(txtNbAllUrls, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel titleExtracted;
    private javax.swing.JLabel titleFail;
    private javax.swing.JLabel titleNbAllUrls;
    private javax.swing.JLabel txtNbAllUrls;
    private javax.swing.JLabel txtNbError;
    private javax.swing.JLabel txtNbExtracted;
    // End of variables declaration//GEN-END:variables
}