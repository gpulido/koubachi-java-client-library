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
import java.util.Date;

/**
*   A class representing a Plant
*   @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
*/
public class Plant {

    private Date created_at;
    private int display_position;
    private int fertilizer_id;
    //fertilizer-type;
    private int id;
    private Date last_fertilizer_at;
    private Date last_mist_at;
    private Date last_water_at;
    private String name;
    private Date next_fertilizer_at;
    private Date next_water_at;
    //note;
    private int plant_type_family_id;
    private int plant_type_id;
    //Color pot_color;
    private int pot_shape;
    private int size;
    private Date updated_at;
    private int user_id;

    //Calibration
    private Date wcd_calibration_checked_at;
    private Date wcd_calibration_ended_at;
    private Date wcd_calibration_started_at;
    private boolean vdm_calibration_start_pending;
    private boolean vdm_calibration_check_pendig;
    private Date vdm_next_calibration_check_at;
    private Date vdm_last_calibration_check_at;
    private boolean vdm_calibration_in_progress;
    //water
    private boolean vdm_water_pending;
    private float vdm_water_level;
    private boolean vdm_precalibrated;
    private int vdm_water_cycle; //take a look
    private String vdm_water_instruction;
    private int vdm_water_analyzing_until;
    //mist
    private boolean vdm_mist_pending;
    private float vdm_mist_level;
    private String vdm_mist_instruction;
    //Fertilizer
    private boolean vdm_fertilizer_pending;
    private double vdm_fertilizer_level;
    private String vdm_fertilizer_instruction;
    //Temperature
    private boolean vdm_temperature_pending;
    private String vdm_temperature_advice;
    private double vdm_temperature_level;
    private String vdm_temperature_instruction;
    private String vdm_temperature_hint;
    private Date vdm_temperature_analyzing_until;
    //Light
    private boolean vdm_light_pending;
    private String vdm_light_advice;
    private double vdm_light_level;
    private String vdm_light_instruction;
    private String vdm_light_hint;
    private Date vdm_light_analyzing_until;
    //more data
    private String pot_color_hex; //take a look":"cc6633"
    private boolean has_smart_device_associated;

    public Date getCreatedAt() {
        return created_at;
    }

    public int getDisplayPosition() {
        return display_position;
    }

    public int getFertilizerId() {
        return fertilizer_id;
    }

    public int getId() {
        return id;
    }

    public Date getLastFertilizerAt() {
        return last_fertilizer_at;
    }

    public Date getLastMistAt() {
        return last_mist_at;
    }

    public Date getLastWaterAt() {
        return last_water_at;
    }

    public String getName() {
        return name;
    }

    public Date getNextFfertilizerAt() {
        return next_fertilizer_at;
    }

    public Date getNextWaterAt() {
        return next_water_at;
    }

    public int getPlantTypeFamilyId() {
        return plant_type_family_id;
    }

    public int getPlantTypeId() {
        return plant_type_id;
    }

    public int getPotShape() {
        return pot_shape;
    }

    public int getSize() {
        return size;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public int getUserId() {
        return user_id;
    }

    public Date getWcdCalibrationCheckedAt() {
        return wcd_calibration_checked_at;
    }

    public Date getWcdCalibrationEndedAt() {
        return wcd_calibration_ended_at;
    }

    public Date getWcdCalibrationStartedAt() {
        return wcd_calibration_started_at;
    }

    public boolean isVdmCalibrationStartPending() {
        return vdm_calibration_start_pending;
    }

    public boolean isVdmCalibrationCheckPendig() {
        return vdm_calibration_check_pendig;
    }

    public Date getVdmNextCalibrationCheckAt() {
        return vdm_next_calibration_check_at;
    }

    public Date getVdmLastCalibrationCheckAt() {
        return vdm_last_calibration_check_at;
    }

    public boolean isVdmCalibrationInProgress() {
        return vdm_calibration_in_progress;
    }

    public boolean isVdmWaterPending() {
        return vdm_water_pending;
    }

    public float getVdmWaterLevel() {
        return vdm_water_level;
    }

    public boolean isVdmPrecalibrated() {
        return vdm_precalibrated;
    }

    public int getVdmWaterCycle() {
        return vdm_water_cycle;
    }

    public String getVdmWaterInstruction() {
        return vdm_water_instruction;
    }

    public int getVdmWaterAnalyzing_until() {
        return vdm_water_analyzing_until;
    }

    public boolean isVdmMistPending() {
        return vdm_mist_pending;
    }

    public float getVdmMistLevel() {
        return vdm_mist_level;
    }

    public String getVdmMistInstruction() {
        return vdm_mist_instruction;
    }

    public boolean isVdmFertilizerPending() {
        return vdm_fertilizer_pending;
    }

    public double getVdmFertilizerLevel() {
        return vdm_fertilizer_level;
    }

    public String getVdmFertilizerInstruction() {
        return vdm_fertilizer_instruction;
    }

    public boolean isVdmTemperaturePending() {
        return vdm_temperature_pending;
    }

    public String getVdmTemperatureAdvice() {
        return vdm_temperature_advice;
    }

    public double getVdmTemperatureLevel() {
        return vdm_temperature_level;
    }

    public String getVdmTemperatureInstruction() {
        return vdm_temperature_instruction;
    }

    public String getVdmTemperatureHint() {
        return vdm_temperature_hint;
    }

    public Date getVdmTemperatureAnalyzingUntil() {
        return vdm_temperature_analyzing_until;
    }

    public boolean isVdmLightPending() {
        return vdm_light_pending;
    }

    public String getVdmLightAdvice() {
        return vdm_light_advice;
    }

    public double getVdmLightLevel() {
        return vdm_light_level;
    }

    public String getVdmLightInstruction() {
        return vdm_light_instruction;
    }

    public String getVdmLightHint() {
        return vdm_light_hint;
    }

    public Date getVdmLightAnalyzingUntil() {
        return vdm_light_analyzing_until;
    }

    public Color getPotColor() {
        return Color.decode(pot_color_hex);
    }

    public boolean hasSmartDeviceAssociated() {
        return has_smart_device_associated;
    }
    //"plant_photos":[]


}
