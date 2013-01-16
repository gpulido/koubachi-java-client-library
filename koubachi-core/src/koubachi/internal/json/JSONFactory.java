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
package koubachi.internal.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import koubachi.objects.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Class that transforms JSON representations of objects onto instance of java objects
 *
 * @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 */
public class JSONFactory {

    private Gson gson;

    public JSONFactory() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
    }

    /* Helper method to use GSON to parse Dates
     * See http://stackoverflow.com/questions/7910734/gsonbuilder-setdateformat-for-2011-10-26t202959-0700
     */
    private static String cleanDateFormat(String json) { // takes in a string of JSON
        Pattern regex = Pattern.compile("\\d\\d:\\d\\d:\\d\\d[-\\+]\\d\\d:\\d\\d");
        Matcher regexMatcher = regex.matcher(json);
        StringBuffer buff = new StringBuffer();
        while (regexMatcher.find()) {
            regexMatcher.appendReplacement(buff, getSubOfMatch(regexMatcher));
        }
        regexMatcher.appendTail(buff);
        return buff.toString();
    }

    /* Helper method to use GSON to parse Dates
    * See http://stackoverflow.com/questions/7910734/gsonbuilder-setdateformat-for-2011-10-26t202959-0700
    */
    //then pull out the colon.
    private static String getSubOfMatch(Matcher matcher) {
        StringBuilder sb = new StringBuilder(matcher.group(0));
        sb.deleteCharAt(sb.length() - 3);
        return sb.toString();
    }

    /*
    * Constructs a List of Devices from a json string
    * @param jsonData JSON data as string
    * @returns an ArrayList of Devices
    */
    //TODO: handle exceptions with a new KoubachiException
    public ArrayList<Device> createDeviceList(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            return createDeviceList(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Device> createDeviceList(JSONArray jsonArray) {
        ArrayList<Device> devices = new ArrayList<Device>();
        for (int i = 0; i < jsonArray.length(); i++)
            devices.add(createDevice(jsonArray.optJSONObject(i)));
        return devices;
    }

    /*
    * Constructs a Device from a json string
    * @param jsonData JSON data as string
    * @returns an Decvice
    */
    //TODO: handle exceptions with a new KoubachiException
    public Device createDevice(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return createDevice(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Device createDevice(JSONObject jsonObject) {
        try {
            Type collectionType = new TypeToken<Device>() {
            }.getType();
            return gson.fromJson(cleanDateFormat(jsonObject.getString("device")), collectionType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * Constructs a List of Plants from a json string
    * @param jsonData JSON data as string
    * @returns an ArrayList of Plants
    */
    public ArrayList<Plant> createPlantList(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            return createPlantList(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    private ArrayList<Plant> createPlantList(JSONArray jsonArray) {
        ArrayList<Plant> plants = new ArrayList<Plant>();
        for (int i = 0; i < jsonArray.length(); i++)
            plants.add(createPlant(jsonArray.optJSONObject(i)));
        return plants;
    }

    /*
    * Constructs a Plant from a json string
    * @param jsonData JSON data as string
    * @returns Plant
    */
    public Plant createPlant(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return createPlant(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    private Plant createPlant(JSONObject jsonObject) {
        try {
            Type collectionType = new TypeToken<Plant>() {
            }.getType();
            return gson.fromJson(cleanDateFormat(jsonObject.getString("plant")), collectionType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * Constructs a List of PlantCareAdvice from a json string
    * @param jsonData JSON data as string
    * @returns an ArrayList of PlantCareAdvice
    */
    public ArrayList<PlantCareAdvice> createPlantCareList(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            return createPlantCareList(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<PlantCareAdvice> createPlantCareList(JSONArray jsonArray) {
        ArrayList<PlantCareAdvice> advices = new ArrayList<PlantCareAdvice>();
        for (int i = 0; i < jsonArray.length(); i++)
            advices.add(createCareAdvice(jsonArray.optJSONObject(i)));
        return advices;
    }

    /*
    * Constructs a PlantCareAdvice from a json string
    * @param jsonData JSON data as string
    * @returns PlantCareAdvice
    */
    public PlantCareAdvice createCareAdvice(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return createCareAdvice(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    private PlantCareAdvice createCareAdvice(JSONObject jsonObject) {
        try {
            Type collectionType = new TypeToken<PlantCareAdvice>() {
            }.getType();
            return gson.fromJson(cleanDateFormat(jsonObject.getString("plant_care_advice")), collectionType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * Constructs a List of Sensor from a json string
    * @param jsonData JSON data as string
    * @returns an ArrayList of Sensor
    */
    public ArrayList<Sensor> createPlantSensorReadingList(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            return createPlantSensorReadingList(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Sensor> createPlantSensorReadingList(JSONArray jsonArray) {
        ArrayList<Sensor> sensors = new ArrayList<Sensor>();
        for (int i = 0; i < jsonArray.length(); i++)
            sensors.add(createSensor(jsonArray.optJSONObject(i)));
        return sensors;
    }

    /*
    * Constructs a Sensor from a json string
    * @param jsonData JSON data as string
    * @returns Sensor
    */
    public Sensor createSensor(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return createSensor(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    private Sensor createSensor(JSONObject jsonObject) {
        try {
            Type collectionType = new TypeToken<Sensor>() {
            }.getType();
            return gson.fromJson(cleanDateFormat(jsonObject.getString("sensor")), collectionType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * Constructs a CareAction from a json string
    * @param jsonData JSON data as string
    * @returns CareAction
    */
    public CareAction createCareAction(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return createCareAction(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    private CareAction createCareAction(JSONObject jsonObject) {
        try {
            Type collectionType = new TypeToken<CareAction>() {
            }.getType();
            return gson.fromJson(cleanDateFormat(jsonObject.getString("care_action")), collectionType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * Creates a json String that represents the given CareAction
    * @param action to be transformed
    * @returns a json string that represents the action
     */
    public String retrieveJSONString(CareAction action) {
        return gson.toJson(action);
    }
}
