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
package koubachi.conf;

/**
 * ConfigurationFactory implementation for PropertyConfiguration.
 * Currently getInstance calls concrete constructor each time. No caching at all.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * Code from twitter4j implementation
 */
class PropertyConfigurationFactory implements ConfigurationFactory {
    private static final PropertyConfiguration ROOT_CONFIGURATION;

    static {
        ROOT_CONFIGURATION = new PropertyConfiguration();
        // calling ROOT_CONFIGURATION.dumpConfiguration() will cause ExceptionInInitializerError as Logger has not been initialized.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Configuration getInstance() {
        return ROOT_CONFIGURATION;
    }

    // It may be preferable to cache the config instance

    /**
     * {@inheritDoc}
     */
    @Override
    public Configuration getInstance(String configTreePath) {
        PropertyConfiguration conf = new PropertyConfiguration(configTreePath);
        //conf.dumpConfiguration();
        return conf;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        // nothing to do for property based configuration
    }
}