/**
 * Copyright (c) 2013 Gabriel Pulido <gabriel.pulidodetorres@gmail.com>
 *
 * This file is part of Koubachi API Java Client Library.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Note: This library and this source file are an unofficial project.
 * Please respect Koubachi's terms in your use of the API.
 */
package koubachi;


import koubachi.conf.Configuration;
import koubachi.internal.json.JSONFactory;

/**
 * @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 */
abstract public class KoubachiBaseImpl implements KoubachiBase, java.io.Serializable {
    protected Configuration conf;

    protected JSONFactory factory;

    KoubachiBaseImpl(Configuration conf) {
        this.conf = conf;
        init();

    }

    private void init() {
        setFactory();

    }

    protected void setFactory() {
        factory = new JSONFactory();
    }

    @Override
    public void shutdown() {


    }

    @Override
    public Configuration getConfiguration() {
        return this.conf;

    }

}
