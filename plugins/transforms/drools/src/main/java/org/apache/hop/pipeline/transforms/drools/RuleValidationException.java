/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hop.pipeline.transforms.drools;

import org.kie.api.builder.Message;

import java.util.ArrayList;
import java.util.List;

public class RuleValidationException extends Exception {

    List<String> messages;

    /**
     * Constructs a new throwable with the specified set of detail messages.
     *
     * @param messages the detailed messages (which is saved for later retrieval by the getMessages()
     *     method).
     */
    public RuleValidationException(List<Message> messages) {
        super();
        this.messages = new ArrayList<String>();
        for (Message item : messages) {

            this.messages.add("Severity: " + item.getLevel().toString() +
                    " - Line: " + item.getLine() + " - Message: " + item.getText());
        }
    }

    public List<String> getMessages() {
        return messages;
    }
}
