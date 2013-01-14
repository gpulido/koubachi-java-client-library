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

import java.util.Date;
/**
 *   A class representing a PlantCareAdvice
 *   @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 */
public class PlantCareAdvice {
    String advice_type;
    private int id;
    private Date scheduled_time;
    private Date sent_at;
    private String message;

    public AdviceTypeEnum getAdviceType() {
        return AdviceTypeEnum.fromString(advice_type);
    }

    public void setAdviceType(AdviceTypeEnum adviceType) {
        advice_type = adviceType.getName();
    }

    public int getId() {
        return id;
    }

    public Date getScheduledTime() {
        return scheduled_time;
    }

    public Date getSentAt() {
        return sent_at;
    }

    public String getMessage() {
        return message;
    }
}
