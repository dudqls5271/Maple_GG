/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package filter.hmimpl;

import java.util.ArrayList;
import java.util.List;
import filter.IFilter;

public class HMFilter implements IFilter {

    public String[] filter(String[] values, String prefix) {
        if (values == null) {
            return null;
        }
        if (prefix == null) {
            return values;
        }
        List<String> result = new ArrayList<>();
        for (String value : values) {
            if (value != null && value.startsWith(prefix)) {
                result.add(value);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
