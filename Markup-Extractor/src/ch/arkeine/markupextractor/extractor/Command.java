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
package ch.arkeine.markupextractor.extractor;

import java.io.Serializable;

public class Command implements Serializable, Cloneable {

    public enum CommandName {

        DELETE("DELETE"), CUT("CUT"), COPY("COPY"), RELOAD("RELOAD"),
        INCLUDE_BEGIN("INCLUDE_BEGIN"), INCLUDE_END("INCLUDE_END");

        private final String name;

        private CommandName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    //IN-OUT
    private CommandName name;
    private String parameter1;
    private String parameter2;

    public Command(CommandName name) {
        this.name = name;
        parameter1 = "";
        parameter2 = "";
    }

    public Command cloneOf() {
        Command n = new Command(name);
        n.parameter1 = this.parameter1;
        n.parameter2 = this.parameter2;
        return n;
    }

    public CommandName getName() {
        return name;
    }

    public void setName(CommandName name) {
        this.name = name;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return cloneOf();
    }
}
