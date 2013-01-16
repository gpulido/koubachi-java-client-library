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
import koubachi.conf.ConfigurationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * A factory class for Koubachi
 * <br>An instance of this class is completely thread safe and can be re-used and used concurrently.
 * @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 * Based on the twitter4j implementation
 */
public final class KoubachiFactory implements java.io.Serializable {
    private static final Constructor<Koubachi> KOUBACHI_CONSTRUCTOR;

    private static final Koubachi SINGLETON;

    private final Configuration conf;

    static {

        String className = "koubachi.KoubachiImpl";

        Constructor<Koubachi> constructor;
        Class clazz;
        try {
            clazz = Class.forName(className);
            constructor = clazz.getDeclaredConstructor(Configuration.class);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
        KOUBACHI_CONSTRUCTOR = constructor;

        try {
            SINGLETON = KOUBACHI_CONSTRUCTOR.newInstance(ConfigurationContext.getInstance());
        } catch (InstantiationException e) {
            throw new AssertionError(e);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Creates a KoubachiFactory with the root configuration.
     */
    public KoubachiFactory() {
        this(ConfigurationContext.getInstance());
    }

    /**
     * Creates a KoubachiFactory with the given configuration.
     *
     * @param conf the configuration to use
     */
    public KoubachiFactory(Configuration conf) {
        if (conf == null) {
            throw new NullPointerException("configuration cannot be null");
        }
        this.conf = conf;
    }

    /**
     * Creates a KoubachiFactory with a specified config tree
     *
     * @param configTreePath the path
     */
    public KoubachiFactory(String configTreePath) {
        this(ConfigurationContext.getInstance(configTreePath));
    }

    /**
     * Returns a instance associated with the configuration bound to this factory.
     *
     * @return default singleton instance
     */
    public Koubachi getInstance() {
        try {
            return KOUBACHI_CONSTRUCTOR.newInstance(conf);
        } catch (InstantiationException e) {
            throw new AssertionError(e);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }


    /**
     * Returns default singleton Koubachi instance.
     *
     * @return default singleton Koubachi instance
     */
    public static Koubachi getSingleton() {
        return SINGLETON;
    }
}