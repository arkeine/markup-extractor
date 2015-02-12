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
import javax.swing.JPanel;

/**
 *
 * @author Nils Ryter
 */
public abstract class ScriptEditor extends JPanel{
    public abstract Command[] getCommandScript();
    public abstract boolean isCommandScriptValid();
    public abstract void setCommandScript(Command[] cmds);
}
