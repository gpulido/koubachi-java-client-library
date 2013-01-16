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
package koubachi.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: gpt
 * Date: 4/01/13
 * Time: 14:04
 * To change this template use File | Settings | File Templates.
 */
//TODO: define the advice types
public enum AdviceTypeEnum {
    //mist_plant, water_plant, cool_plant, cool_plant_alarm, fertilize_plant, water_plant_reminder, put_into_light
    MIST_PLANT("mist_plant"),
    WATER_PLANT("water_plant"),
    COOL_PLANT("cool_plant"),
    COOL_PLANT_ALARM("cool_plant_alarm"),
    FERTILIZE_PLANT("fertilize_plant"),
    WATER_PLANT_REMINDER("water_plant_reminder"),
    PUT_INTO_LIGHT("put_into_light"),;

    private final String name;

    private static final Map<String, AdviceTypeEnum> map = new HashMap<String, AdviceTypeEnum>();

    static {
        for (AdviceTypeEnum type : AdviceTypeEnum.values()) {
            map.put(type.name, type);
        }
    }

    private AdviceTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static AdviceTypeEnum fromString(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        throw new NoSuchElementException(name + "not found");
    }
}
