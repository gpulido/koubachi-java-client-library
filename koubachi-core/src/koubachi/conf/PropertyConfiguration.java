/*
 * Copyright (c) 2013.
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
 */

package koubachi.conf;

import koubachi.internal.z_T4JInternalStringUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 * Based on twitter4j implementation
 */
public class PropertyConfiguration extends ConfigurationBase implements Serializable {
    public static final String USER_CREDENTIALS = "userCredentials";
    public static final String APP_KEY = "appKey";

    PropertyConfiguration(InputStream is) {
        super();
        Properties props = new Properties();
        loadProperties(props, is);
        setFieldsWithTreePath(props, "/");
    }

    public PropertyConfiguration(Properties props) {
        this(props, "/");
    }

    public PropertyConfiguration(Properties props, String treePath) {
        super();
        setFieldsWithTreePath(props, treePath);
    }

    PropertyConfiguration(String treePath) {
        super();
        Properties props;
        // load from system properties
        try {
            props = (Properties) System.getProperties().clone();
            try {
                Map<String, String> envMap = System.getenv();
                for (String key : envMap.keySet()) {
                    props.setProperty(key, envMap.get(key));
                }
            } catch (SecurityException ignore) {
            }
            normalize(props);
        } catch (SecurityException ignore) {
            // Unsigned applets are not allowed to access System properties
            props = new Properties();
        }
        final String KOUBACHI_PROPERTIES = "koubachi.properties";
        // override System properties with ./koubachi.properties in the classpath
        loadProperties(props, "." + File.separatorChar + KOUBACHI_PROPERTIES);
        // then, override with /koubachi.properties in the classpath
        loadProperties(props, Configuration.class.getResourceAsStream("/" + KOUBACHI_PROPERTIES));
        // then, override with /WEB/INF/koubachi.properties in the classpath
        loadProperties(props, Configuration.class.getResourceAsStream("/WEB-INF/" + KOUBACHI_PROPERTIES));

        setFieldsWithTreePath(props, treePath);
    }

    /**
     * Creates a root PropertyConfiguration. This constructor is equivalent to new PropertyConfiguration("/").
     */
    PropertyConfiguration() {
        this("/");
    }

    private boolean notNull(Properties props, String prefix, String name) {
        return props.getProperty(prefix + name) != null;
    }

    private boolean loadProperties(Properties props, String path) {
        FileInputStream fis = null;
        try {
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                fis = new FileInputStream(file);
                props.load(fis);
                normalize(props);
                return true;
            }
        } catch (Exception ignore) {
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ignore) {

            }
        }
        return false;
    }

    private boolean loadProperties(Properties props, InputStream is) {
        try {
            props.load(is);
            normalize(props);
            return true;
        } catch (Exception ignore) {
        }
        return false;
    }

    private void normalize(Properties props) {
        Set keys = props.keySet();
        ArrayList<String> toBeNormalized = new ArrayList<String>(9);
        for (Object key : keys) {
            String keyStr = (String) key;
            if (-1 != (keyStr.indexOf("koubachi."))) {
                toBeNormalized.add(keyStr);
            }
        }
        for (String keyStr : toBeNormalized) {
            String property = props.getProperty(keyStr);
            int index = keyStr.indexOf("koubachi.");
            String newKey = keyStr.substring(0, index) + keyStr.substring(index + 9);
            props.setProperty(newKey, property);
        }
    }

    /**
     * passing "/foo/bar" as treePath will result:<br>
     * 1. load [koubachi.]restBaseURL<br>
     * 2. override the value with foo.[koubachi.]restBaseURL<br>
     * 3. override the value with foo.bar.[koubachi.]restBaseURL<br>
     *
     * @param props    properties to be loaded
     * @param treePath the path
     */
    private void setFieldsWithTreePath(Properties props, String treePath) {
        setFieldsWithPrefix(props, "");
        String[] splitArray = z_T4JInternalStringUtil.split(treePath, "/");
        String prefix = null;
        for (String split : splitArray) {
            if (!"".equals(split)) {
                if (null == prefix) {
                    prefix = split + ".";
                } else {
                    prefix += split + ".";
                }
                setFieldsWithPrefix(props, prefix);
            }
        }
    }

    private void setFieldsWithPrefix(Properties props, String prefix) {
        if (notNull(props, prefix, USER_CREDENTIALS)) {
            setUserCredentials(getString(props, prefix, USER_CREDENTIALS));
        }
        if (notNull(props, prefix, APP_KEY)) {
            setAppKey(getString(props, prefix, APP_KEY));
        }

        cacheInstance();
    }

    protected boolean getBoolean(Properties props, String prefix, String name) {
        String value = props.getProperty(prefix + name);
        return Boolean.valueOf(value);
    }

    protected int getIntProperty(Properties props, String prefix, String name) {
        String value = props.getProperty(prefix + name);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    protected long getLongProperty(Properties props, String prefix, String name) {
        String value = props.getProperty(prefix + name);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException nfe) {
            return -1L;
        }
    }

    protected String getString(Properties props, String prefix, String name) {
        return props.getProperty(prefix + name);
    }

    // assures equality after deserialization
    protected Object readResolve() throws ObjectStreamException {
        return super.readResolve();
    }
}
