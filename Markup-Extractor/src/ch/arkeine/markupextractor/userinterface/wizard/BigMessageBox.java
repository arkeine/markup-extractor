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

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nils Ryter
 */
public class BigMessageBox extends javax.swing.JDialog {

    private String buttonPressed;

    /**
     * Creates new form BigMessageBox
     */
    public BigMessageBox(java.awt.Frame parent) {        
        super(parent, true);
        initComponents();
        buttonPressed = "";
    }

    /**
     * Creates new form BigMessageBox
     */
    public BigMessageBox(java.awt.Frame parent, String title, String summary,
            String content, String[] buttons) {
        this(parent);
        this.setTitle(title);
        txtMessageSummary.setText(summary);
        txtContent.setText(content);
        for (String s : buttons) {
            Button b = new Button(s);
            b.setActionCommand(s);
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonPressed = e.getActionCommand();
                    dispose();
                }
            }
            );
            panButtons.add(b);
        }
    }

    public String getButtonPressed() {
        return buttonPressed;
    }
        
    public String getEnteredText() {
        return txtContent.getText();
    }
    
    public void setEditableContent(boolean b) {
        txtContent.setEditable(b);
    }   
    
    public boolean isEditableContent() {
        return txtContent.isEditable();
    }   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMessageSummary = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        panButtons = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtMessageSummary.setText("Message summary");

        txtContent.setColumns(20);
        txtContent.setRows(5);
        jScrollPane1.setViewportView(txtContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(txtMessageSummary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(panButtons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMessageSummary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panButtons;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JLabel txtMessageSummary;
    // End of variables declaration//GEN-END:variables
}