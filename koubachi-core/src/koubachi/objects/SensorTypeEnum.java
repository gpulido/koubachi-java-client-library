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

package koubachi.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: gpt
 * Date: 5/02/13
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 */
public enum SensorTypeEnum {
    //12 - Humidity, 8 - Illuminance, 7 - temperature,
    HUMIDITY("12"),
    ILLUMINANCE("8"),
    TEMPERATURE("7");

    private final String name;

    private static final Map<String, SensorTypeEnum> map = new HashMap<String, SensorTypeEnum>();

    static {
        for (SensorTypeEnum type : SensorTypeEnum.values()) {
            map.put(type.name, type);
        }
    }

    private SensorTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SensorTypeEnum fromString(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        throw new NoSuchElementException(name + "not found");
    }
}
