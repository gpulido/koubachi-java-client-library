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
 * ConfigurationFactory implementation for PropertyConfiguration.
 * Currently getInstance calls concrete constructor each time. No caching at all.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public enum ActionTypeEnum {
    CALIBRATION_WATERED("calibration.watered"),
    CALIBRATION_ISDRY("calibration.is_dry"),
    CALIBRATION_ISNOTDRY("calibration.is_not_dry"),
    CALIBRATION_RESTARTED("calibration.restarted"),
    WATER_PERFORMED("water.performed"),
    WATER_CHANGED("water.changed"),
    MIST_SKIPPED("mist.skipped"),
    MIST_PERFORMED("mist.performed"),
    MIST_CHANGED("mist.changed"),
    FERTILIZE_SKIPPED("fertilize.skipped"),
    FERTILIZE_PERFORMED("fertilize.performed"),
    FERTILIZE_CHANGED("fertilize.changed"),
    PUTINTOLIGHT_PERFORMED("put_into_light.performed"),
    PUTINTOSHADE_PERFORMED("put_into_shade.performed"),
    HEATPLANT_PERFORMED("heat_plant.performed"),
    COOLPLANT_PERFORMED("cool_plant.performed");

    private final String name;

    private static final Map<String, ActionTypeEnum> map = new HashMap<String, ActionTypeEnum>();

    static {
        for (ActionTypeEnum type : ActionTypeEnum.values()) {
            map.put(type.name, type);
        }
    }

    private ActionTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ActionTypeEnum fromString(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        throw new NoSuchElementException(name + "not found");
    }
}
