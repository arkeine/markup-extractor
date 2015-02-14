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
package ch.arkeine.markupextractor.userinterface.scripteditor;

import ch.arkeine.markupextractor.userinterface.wizard.BigMessageBox;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Nils Ryter
 */
public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private final JButton delegate;
    private String saveContent;

    public ButtonEditor() {
        this.delegate = new JButton();

        this.delegate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BigMessageBox box = new BigMessageBox(null, "trol", "Enterpas",
                        saveContent, new String[]{"Ok", "Cancel"});
                box.setLocationRelativeTo(delegate);
                box.setVisible(true);
                if (box.getButtonPressed().equals("Ok")) {
                    saveContent = box.getEnteredText();
                    fireEditingStopped();
                } else {
                    fireEditingCanceled();
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (value != null) {
            saveContent = (String) value;
        }

        return delegate;
    }

    @Override
    public Object getCellEditorValue() {
        return saveContent;
    }
}
