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

import ch.arkeine.markupextractor.extractor.Command;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nils Ryter
 */
public class CommandTableModel extends AbstractTableModel {

    private List<Command> cmds;
    private final String[] colName;

    public CommandTableModel(Command[] cmds, String[] colName) {
        this.cmds = new ArrayList<>(Arrays.asList(cmds));
        this.colName = colName;
    }

    public CommandTableModel(String[] colName) {
        this.cmds = new ArrayList<>();
        this.colName = colName;
    }

    public Command[] getCommands() {
        return cmds.toArray(new Command[cmds.size()]);
    }

    public void setCommands(Command[] cmds) {
        this.cmds = new ArrayList<>(Arrays.asList(cmds));
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return cmds.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Command c = cmds.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getName();
            case 1:
                return c.getParameter1();
            case 2:
                return c.getParameter2();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Command c = cmds.get(rowIndex);
        switch (columnIndex) {
            case 0:
                c.setName((Command.CommandName) aValue);
                break;
            case 1:
                c.setParameter1((String) aValue);
                break;
            case 2:
                c.setParameter2((String) aValue);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public String getColumnName(int col) {
        return colName[col];
    }

    public void addCommand(Command c) {
        cmds.add(c);
        fireTableRowsInserted(cmds.size() - 1, cmds.size() - 1);
    }

    public void removeCommand(int i) {
        if (i != -1) {
            cmds.remove(i);
            fireTableRowsDeleted(i, i);
        }
    }

    public void moveRow(int start, int end, int to) {
        int shift = to - start;
        int first, last;
        if (shift < 0) {
            first = to;
            last = end;
        } else {
            first = start;
            last = to + end - start;
        }
        rotate(cmds, first, last + 1, shift);

        fireTableRowsUpdated(first, last);
    }

    private static int gcd(int i, int j) {
        return (j == 0) ? i : gcd(j, i % j);
    }

    private static void rotate(List l, int a, int b, int shift) {
        int size = b - a;
        int r = size - shift;
        int g = gcd(size, r);
        for (int i = 0; i < g; i++) {
            int to = i;
            Object tmp = l.get(a + to);
            for (int from = (to + r) % size; from != i; from = (to + r) % size) {
                l.set(a + to, l.get(a + from));
                to = from;
            }
            l.set(a + to, tmp);
        }
    }

}
