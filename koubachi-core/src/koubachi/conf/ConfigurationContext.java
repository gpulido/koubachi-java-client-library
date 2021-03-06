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
 * Static factory of Configuration. This class wraps ConfigurationFactory implementations.<br>
 * By default, koubachi.conf.PropertyConfigurationFactory will be used and can be changed with -Dkoubachi.configurationFactory system property.
 * @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 * Based on twitter4j implementation
 */
public final class ConfigurationContext {
    public static final String DEFAULT_CONFIGURATION_FACTORY = "koubachi.conf.PropertyConfigurationFactory";
    public static final String CONFIGURATION_IMPL = "koubachi.configurationFactory";
    private static final ConfigurationFactory factory;

    static {
        String CONFIG_IMPL;
        try {
            CONFIG_IMPL = System.getProperty(CONFIGURATION_IMPL, DEFAULT_CONFIGURATION_FACTORY);
        } catch (SecurityException ignore) {
            // Unsigned applets are not allowed to access System properties
            CONFIG_IMPL = DEFAULT_CONFIGURATION_FACTORY;
        }

        try {
            factory = (ConfigurationFactory) Class.forName(CONFIG_IMPL).newInstance();
        } catch (ClassNotFoundException cnfe) {
            throw new AssertionError(cnfe);
        } catch (InstantiationException ie) {
            throw new AssertionError(ie);
        } catch (IllegalAccessException iae) {
            throw new AssertionError(iae);
        }
    }


    public static Configuration getInstance() {
        return factory.getInstance();
    }

    public static Configuration getInstance(String configTreePath) {
        return factory.getInstance(configTreePath);
    }
}
