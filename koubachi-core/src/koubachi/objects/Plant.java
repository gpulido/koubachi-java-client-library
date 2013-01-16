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
*   A class representing a Plant
*   @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
*/
public class Plant {

    Date created_at;
    int display_position;
    int fertilizer_id;
    //fertilizer-type;
    int id;
    Date last_fertilizer_at;
    Date last_mist_at;
    Date last_water_at;
    String name;
    Date next_fertilizer_at;
    Date next_water_at;
    //note;
    int plant_type_family_id;
    int plant_type_id;
    //Color pot_color;
    int pot_shape;
    int size;
    Date updated_at;
    int user_id;

    //Calibration
    Date wcd_calibration_checked_at;
    Date wcd_calibration_ended_at;
    Date wcd_calibration_started_at;
    boolean vdm_calibration_start_pending;
    boolean vdm_calibration_check_pendig;
    Date vdm_next_calibration_check_at;
    Date vdm_last_calibration_check_at;
    boolean vdm_calibration_in_progress;
    //water
    boolean vdm_water_pending;
    float vdm_water_level;
    boolean vdm_precalibrated;
    int vdm_water_cycle; //take a look
    String vdm_water_instruction;
    int vdm_water_analyzing_until;
    //mist
    boolean vdm_mist_pending;
    float vdm_mist_level;
    String vdm_mist_instruction;
    //Fertilizer
    boolean vdm_fertilizer_pending;
    double vdm_fertilizer_level;
    String vdm_fertilizer_instruction;
    //Temperature
    boolean vdm_temperature_pending;
    String vdm_temperature_advice;
    double vdm_temperature_level;
    String vdm_temperature_instruction;
    String vdm_temperature_hint;
    Date vdm_temperature_analyzing_until;
    //Light
    boolean vdm_light_pending;
    String vdm_light_advice;
    double vdm_light_level;
    String vdm_light_instruction;
    String vdm_light_hint;
    Date vdm_light_analyzing_until;
    //more data
    String pot_color_hex; //take a look":"cc6633"
    boolean has_smart_device_associated;
    //"plant_photos":[]


}
