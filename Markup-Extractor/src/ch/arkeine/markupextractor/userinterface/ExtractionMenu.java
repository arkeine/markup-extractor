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
package ch.arkeine.markupextractor.userinterface;

import ch.arkeine.markupextractor.extractor.Extractor;
import ch.arkeine.markupextractor.extractor.ExtractorListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author nils.ryter
 */
public class ExtractionMenu extends javax.swing.JDialog implements ExtractorListener {

    private Extractor extractor;
    
    /**
     * Creates new form ExtractionMenu
     */
    public ExtractionMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(
                "ch/arkeine/markupextractor/internationalization"); // NOI18N
        final String title = bundle.getString(
                "ExtractionMenu.message.titleNoData");
        final String message = bundle.getString(
                "ExtractionMenu.message.messageNoData");
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);

        dispose();
    }

    /**
     * Creates new form ExtractionMenu
     */
    public ExtractionMenu(java.awt.Frame parent, boolean modal, Extractor e) {
        super(parent, modal);
        initComponents();
        
        extractor = e;
        extractor.addExtractorListener(this);

        Thread t = new Thread(extractor);
        t.start();
    }

    public Extractor getExtractor() {
        return extractor;
    }

    @Override
    public void progressUpdate(double percent) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                progressBarExtraction.setValue((int) percent);
                panelExtractionStatistics.loadStatistic(extractor);
            }
        });
    }

    @Override
    public void extractionFinish() {
        dispose();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelProgressBar = new javax.swing.JLabel();
        progressBarExtraction = new javax.swing.JProgressBar();
        panelExtractionStatistics = new ch.arkeine.markupextractor.userinterface.extractor.ExtractionStatistics();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/arkeine/markupextractor/internationalization"); // NOI18N
        setTitle(bundle.getString("ExtractionMenu.title")); // NOI18N

        labelProgressBar.setText(bundle.getString("ExtractionMenu.labelProgressBar.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBarExtraction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelProgressBar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelExtractionStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelProgressBar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBarExtraction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelExtractionStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelProgressBar;
    private ch.arkeine.markupextractor.userinterface.extractor.ExtractionStatistics panelExtractionStatistics;
    private javax.swing.JProgressBar progressBarExtraction;
    // End of variables declaration//GEN-END:variables
}
