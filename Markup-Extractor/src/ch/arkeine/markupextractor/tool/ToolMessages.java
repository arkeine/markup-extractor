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
package ch.arkeine.markupextractor.tool;

import ch.arkeine.markupextractor.extractor.Extractor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Nils Ryter
 */
public class ToolMessages {

    public static void showException(Component parentComponent, String summary,
            String title, Exception ex) {

        showBigMessage(parentComponent, summary, title, ex.getLocalizedMessage(),
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showBigMessage(Component parentComponent, String summary,
            String title, String message, int messageType) {

        JPanel panel = buildBigPane(false, summary, message);
        JOptionPane.showMessageDialog(parentComponent, panel, title,
                messageType);
    }

    public static String showBigInput(Component parentComponent, String summary,
            String title, String message, int messageType) {

        JPanel panel = buildBigPane(true, summary, message);
        JOptionPane.showMessageDialog(parentComponent, panel, title,
                messageType);
        return panel.toString();
    }

    private static JPanel buildBigPane(boolean editable, String summary,
            String message) {

        JLabel label = new JLabel(summary);
        JTextArea txtBig = new JTextArea(message);
        txtBig.setEditable(editable);
        txtBig.setWrapStyleWord(true);
        txtBig.setLineWrap(true);

        JPanel panel = new JPanel() {
            @Override
            public String toString() {
                return txtBig.getText();
            }

        };
        JScrollPane sp = new JScrollPane();
        sp.setPreferredSize(new Dimension(10, 200));
        sp.setViewportView(txtBig);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(sp, BorderLayout.CENTER);

        return panel;
    }
}
