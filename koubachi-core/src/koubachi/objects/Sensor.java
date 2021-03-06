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

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *   A class representing a Sensor
 *   @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 */
public class Sensor {
    String sensor_type_id; //12 - Humidity, 8 - Illuminance, 7 - temperature,
    private String name;
    private String unit_name;
    String color; //take a look "0092BF",
    private Map<Double,String> yaxis_ticks;
//
//  "yaxis_ticks":[[0.0,"very dry"],
//        [1800.0,"dry"],
//        [2500.0,"slightly moist"],
//        [4000.0,"moist"],
//        [6000.0,"wet"]],
private double yaxis_min;
    private double yaxis_max;
//TODO: parse the data
private double[][] data;
//                "data":[[1341247020000,4942.0],
//        [1341265020000,4934.0],
//        [1341283022000,4951.0],
//        [1341301022000,4953.0],
//        [1341311205000,4944.0],
//        [1341391022000,4898.0],
//        [1341409022000,4878.0],
//        [1341413946000,4874.0],
//        [1341427024000,4870.0],
//        [1341445026000,4854.0],
//        [1341463028000,4835.0],
//        [1341537167000,4747.0],
//        [1341555167000,4680.0],
//        [1341565839000,4670.0],
//        [1341573168000,4652.0],
//        [1341844242000,4146.0],
//        [1341847878000,5124.0],
//        [1341865880000,5432.0],
//        [1341883882000,5406.0],
//        [1341919882000,5295.0],
//        [1341922574000,5298.0]],
private Date last_read_at;

    public SensorTypeEnum getAdviceType() {
        return SensorTypeEnum.fromString(sensor_type_id);
    }

    public Color getColor()
    {
      return Color.decode(color);
    }

    public String getName() {
        return name;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public Map<Double, String> getYaxis_ticks() {
        return yaxis_ticks;
    }

    public double getYaxis_min() {
        return yaxis_min;
    }

    public double getYaxis_max() {
        return yaxis_max;
    }

    public double[][] getData() {
        return data;
    }

    public Date getLast_read_at() {
        return last_read_at;
    }
}
