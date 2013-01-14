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

package koubachi.api;

import koubachi.objects.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 */
public interface PlantResources {
    /**
     * List all plants associated with the current user which are located on space nr 0. Plants on other spaces are
     * not returned!
     * <br>http://api.koubachi.com/v2/plants/
     *
     * @return the plants associated with the current user
     * @see <a href="http://labs.koubachi.com/documentations/3">plants/list</a>
     */
    ArrayList<Plant> getPlants();

    /**
     * List all plants associated with the current user which are located on space nr 0. Plants on other spaces are
     * not returned!
     * <br>http://api.koubachi.com/v2/plants/
     *
     * @param since Timestamp to limit the list to updated plants.
     *              Only plants updated on or later than the given timestamps are returned
     * @return the plants associated with the current user
     * @see <a href="http://labs.koubachi.com/documentations/3">plants/list</a>
     */
    ArrayList<Plant> getPlants(Date since);

    /**
     * Get the details of a plant belonging to the current user including plant photos
     * <br>http://api.koubachi.com/v2/plants/:id
     *
     * @param plantId the id of the plant to retrieve information for
     * @return the plant data
     * @see <a href="http://labs.koubachi.com/documentations/4"plants/show</a>
     */
    Plant getPlant(int plantId);

    /**
     * Get a list of care advices for the plant
     * <br>http://api.koubachi.com/v2/plants/:plant_id/care_plan
     *
     * @param plantId the id of the plant to retrieve information for
     * @return the plant care advice list
     * @see <a href="http://labs.koubachi.com/documentations/5">plants/care_plan/list</a>
     */
    ArrayList<PlantCareAdvice> getPlantCareList(int plantId);

    /**
     * Get a filtered list of care advices for the plant
     * <br>http://api.koubachi.com/v2/plants/:plant_id/care_plan
     *
     * @param plantId    the id of the plant to retrieve information for
     * @param from       Only care advices with scheduled_time later than the given timestamp are returned
     * @param to         Only care advices with scheduled_time earlier than the given timestamp are returned.
     * @param vdmModule  Return only care advices of the given vdm module.
     *                   Must be one of "soilmoisture", "airhumidity", "fertilizer", "light", "temperature"
     * @param adviceType Return only care advices of the given type
     * @return the plant care advice list
     * @see <a href="http://labs.koubachi.com/documentations/5">plants/care_plan/list</a>
     */
    ArrayList<PlantCareAdvice> getPlantCareList(int plantId, Date from, Date to, String vdmModule, String adviceType);

    /**
     * Get a care advice for the plant
     * <br>http://api.koubachi.com/v2/plants/:plant_id/care_plan/:care_advice_id
     *
     * @param plantId  the id of the plant to retrieve information for
     * @param adviceId the id of the advice to retrieve information for
     * @return the plant advice data
     * @see <a href="http://labs.koubachi.com/documentations/6">plants/care_plan/show</a>
     */
    PlantCareAdvice getPlantAdvice(int plantId, int adviceId);


    /**
     * Get the pending tasks of the plan
     * <br>http://api.koubachi.com/v2/plants/:plant_id/pending_tasks/
     *
     * @param plantId the id of the plant to retrieve information for
     * @return the plant pending tasks
     * @see <a href="http://labs.koubachi.com/documentations/7">plants/pending_tasks</a>
     */
    ArrayList<PlantCareAdvice> getPlantPendingTaskList(int plantId);

    /**
     * Get the pending tasks of the plan filtered by vdm module
     * <br>http://api.koubachi.com/v2/plants/:plant_id/pending_tasks/
     *
     * @param plantId   the id of the plant to retrieve information for
     * @param vdmModule Return only care advices of the given vdm module.
     *                  Must be one of "soilmoisture", "airhumidity", "fertilizer", "light", "temperature"
     * @return the plant pending tasks
     * @see <a href="http://labs.koubachi.com/documentations/7">plants/pending_tasks</a>
     */
    ArrayList<PlantCareAdvice> getPlantPendingTaskList(int plantId, String vdmModule);


    /**
     * list all readings for sensors on smart devices associated with the plant which have a visible
     * sensor_type (attribute is_visible => true)
     * for the Koubachi Wi-Fi Plant Sensor this includes the soil moisture, light and temperature sensors
     * <br>http://api.koubachi.com/v2/plants/:id/readings
     *
     * @param plantId the id of the plant to retrieve information for
     * @return the plant sensor reading data
     * @see <a href="http://labs.koubachi.com/documentations/8">plants/readings/list</a>
     */
    ArrayList<Sensor> getPlantSensorReadingsList(int plantId);

    /**
     * list all readings for sensors on smart devices associated with the plant which have a visible
     * sensor_type (attribute is_visible => true)
     * for the Koubachi Wi-Fi Plant Sensor this includes the soil moisture, light and temperature sensors.
     * <br>http://api.koubachi.com/v2/plants/:id/readings
     *
     * @param plantId            the id of the plant to retrieve information for
     * @param onlyRecentReadings If true, retrieve only the list readings from the last 8 days
     * @return the plant sensor reading data
     * @see <a href="http://labs.koubachi.com/documentations/8">plants/readings/list</a>
     */
    ArrayList<Sensor> getPlantSensorReadingsList(int plantId, boolean onlyRecentReadings);


    /**
     * Publish an action back to the system (e.g water.performed, ...).
     * Take care that it is not always possible to publish all actions. e.g. if the plant has a
     * Koubachi Wi-Fi Plant Sensor you can not manually register a water performed task.
     * <br>http://api.koubachi.com/v2/plants/:plant_id/tasks
     *
     * @param plantId    the id of the plant to retrieve information for
     * @param actionType The care action type, e.g. water.performed, mist.skipped
     * @return the care action performed
     * @see <a href="http://labs.koubachi.com/documentations/9">plants/tasks</a>
     */
    CareAction publishAction(int plantId, ActionTypeEnum actionType);

    /**
     * Publish an action back to the system (e.g water.performed, ...).
     * Take care that it is not always possible to publish all actions. e.g. if the plant has a
     * Koubachi Wi-Fi Plant Sensor you can not manually register a water performed task.
     * <br>http://api.koubachi.com/v2/plants/:plant_id/tasks
     *
     * @param plantId      the id of the plant to retrieve information for
     * @param actionType   The care action type, e.g. water.performed, mist.skipped
     * @param time         When the user performed the action
     * @param careAdviceId The id of the care advice which caused the user to perform this action
     * @return the care action performed
     * @see <a href="http://labs.koubachi.com/documentations/9">plants/tasks</a>
     */
    CareAction publishAction(int plantId, ActionTypeEnum actionType, Date time, int careAdviceId);


}
