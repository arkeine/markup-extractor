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

import ch.arkeine.markupextractor.extractor.Command;

/**
 *
 * @author Nils Ryter
 */
public class ToolCommands {
    
    public static String commandsToString(Command[] cmds) {
        StringBuilder s = new StringBuilder();

        for (Command c : cmds) {
            s.append(c.getName().toString());
            s.append("\n");
            s.append(c.getParameter1());
            s.append("\n");
            s.append(c.getParameter2());
            s.append("\n");
        }

        return s.toString();
    }

    public static Command[] stringToCommands(String s) {
        String[] strCmds = s.split("\n");

        if ((strCmds.length - 1) % 3 == 0) {
            Command[] cmds = new Command[strCmds.length - 1];

            for (int i = 0; i < cmds.length; i++) {
                cmds[i] = new Command(Command.CommandName.valueOf(strCmds[i]));
                cmds[i].setParameter1(strCmds[i + 1]);
                cmds[i].setParameter2(strCmds[i + 2]);
            }

            return cmds;
        } else {
            return new Command[0];
        }
    }

}
