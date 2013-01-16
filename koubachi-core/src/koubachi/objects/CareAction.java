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

import java.util.Date;

/**
 *   A class representing Care Action data
 */
public class CareAction {
    String action_type;
    private Date time;
    int plant_id;

    /*
    * Dummy constructor for gson
     */
    public CareAction() {
    }

    public CareAction(int plantId) {
        plant_id = plantId;
    }

    public int getPlantId() {
        return plant_id;
    }

    public ActionTypeEnum getActionType() {
        return ActionTypeEnum.fromString(action_type);
    }

    public void setActionType(ActionTypeEnum actionType) {
        action_type = actionType.getName();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
