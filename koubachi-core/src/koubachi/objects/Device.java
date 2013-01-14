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
import java.util.List;

/**
 *   A class representing a Device
 *   @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 */
public class Device {
    String mac_address; //Take a look "000666802ec2",
    int number_of_readings;
    int number_of_recent_readings;
    double virtual_battery_level;
    String ssid;
    Date last_transmission;
    Date next_transmission;
    Date associated_since;
    String recent_soilmoisture_reading_value; //take a look "44%",
    Date recent_soilmoisture_reading_time;
    double recent_temperature_reading_value; //take a look "28.9\u202f\u00b0C",
    Date recent_temperature_reading_time;
    double recent_light_reading_value; //take a look": "287.9\u202flx",
    Date recent_light_reading_time;
    //It is list of Plants with id only. A lazy retrieve of the plant whole data should be added
    List<Plant> plants;


    public int getNumberOfReadings() {
        return number_of_readings;
    }

    public int getNumberOfRecentReadings() {
        return number_of_recent_readings;
    }

    public double getVirtualBatteryLevel() {
        return virtual_battery_level;
    }


    public String getSsid() {
        return ssid;
    }


    public Date getLastTransmission() {
        return last_transmission;
    }

    public Date getNextTransmission() {
        return next_transmission;
    }

    public Date getAssociatedSince() {
        return associated_since;
    }

    public String getRecentSoilmoistureReadingValue() {
        return recent_soilmoisture_reading_value;
    }

    public Date getRecentSoilmoistureReadingTime() {
        return recent_soilmoisture_reading_time;
    }

    public double getRecentTemperatureReadingValue() {
        return recent_temperature_reading_value;
    }


    public Date getRecentTemperatureReadingTime() {
        return recent_temperature_reading_time;
    }


    public double getRecentLightReadingValue() {
        return recent_light_reading_value;
    }

    public Date getRecentLightReadingTime() {
        return recent_light_reading_time;
    }

    //TODO: this retrieves only the id of the plants.
    public List<Plant> getPlants() {
        return plants;
    }

}
