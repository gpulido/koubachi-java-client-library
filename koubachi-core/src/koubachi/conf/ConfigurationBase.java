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

import org.restlet.data.Reference;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/**
 * Configuration base class with defaults settings.
 *
 * @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 * Based on twitter4j implementation
 */
public class ConfigurationBase implements Configuration, java.io.Serializable {

    private String userCredentials;
    private String appKey;

    private String restBaseURL;

    private static final String DEFAULT_REST_BASE_URL = "http://api.koubachi.com/v2/";


    protected ConfigurationBase() {
        setUserCredentials(null);
        setAppKey(null);

        setRestBaseUrl(DEFAULT_REST_BASE_URL);

    }


    @Override
    public final String getUserCredentials() {
        return this.userCredentials;
    }

    protected final void setUserCredentials(String userCredentials) {
        this.userCredentials = userCredentials;

    }

    @Override
    public final String getAppKey() {
        return this.appKey;
    }

    protected final void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    private static final List<ConfigurationBase> instances = new ArrayList<ConfigurationBase>();

    private static void cacheInstance(ConfigurationBase conf) {
        if (!instances.contains(conf)) {
            instances.add(conf);
        }
    }

    protected void cacheInstance() {
        cacheInstance(this);
    }

    private static ConfigurationBase getInstance(ConfigurationBase configurationBase) {
        int index;
        if ((index = instances.indexOf(configurationBase)) == -1) {
            instances.add(configurationBase);
            return configurationBase;
        } else {
            return instances.get(index);
        }
    }

    // assures equality after deserializedation
    protected Object readResolve() throws ObjectStreamException {
        return getInstance(this);
    }

    @Override
    public String getRestBaseURL() {
        return restBaseURL;
    }

    protected final void setRestBaseUrl(String defaultRestBaseUrl) {
        this.restBaseURL = defaultRestBaseUrl;
    }

    @Override
    public Reference getRestReference(String path) {
        Reference reference = new Reference(getRestBaseURL() + path);
        reference.addQueryParameter("user_credentials", getUserCredentials());
        reference.addQueryParameter("app_key", getAppKey());
        return reference;
    }


}
