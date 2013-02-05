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
package koubachi;

import koubachi.conf.ConfigurationBuilder;
import org.restlet.data.Parameter;
import koubachi.conf.Configuration;
import koubachi.internal.rest.RestHelper;
import koubachi.objects.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * A Java Representation of the  <a href="http://labs.koubachi.com/documentations">Koubachi REST API</a>
 *
 * @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 */
public class KoubachiImpl extends KoubachiBaseImpl implements Koubachi {


    KoubachiImpl(Configuration conf) {
        super(conf);

    }

    //test
    public static void main(String[] args) throws IOException {

        Koubachi koubachi = KoubachiFactory.getSingleton();
        ArrayList<Plant> lista = koubachi.getPlants();

    }

    /* UserResources */
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Device> getDevices(boolean onlyRecentAssociatedDevices) {

        ArrayList<Device> deviceList = new ArrayList<Device>();
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("user/smart_devices"),
                    new Parameter("only_recent_associated_devices",
                            String.valueOf(onlyRecentAssociatedDevices)));
            deviceList = factory.createDeviceList(jsonData);

        } catch (IOException ex) {

        }
        return deviceList;
    }

    /*Plant Resources */
    /**
     * {@inheritDoc}
    */
    @Override
    public Device getDevice(String macAddress) {
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("user/smart_devices/" + macAddress));
            return factory.createDevice(jsonData);
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Plant> getPlants() {
        ArrayList<Plant> plantList = new ArrayList<Plant>();
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants"));
            plantList = factory.createPlantList(jsonData);

        } catch (IOException ex) {
            System.out.println("Exception");
        }
        return plantList;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Plant> getPlants(Date since) {
        ArrayList<Plant> plantList = new ArrayList<Plant>();
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants"),
                    new Parameter("since", String.valueOf(since)));
            plantList = factory.createPlantList(jsonData);
        } catch (IOException ex) {

        }
        return plantList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Plant getPlant(int plantId) {
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants/" + String.valueOf(plantId)));
            return factory.createPlant(jsonData);
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlantCareAdvice> getPlantCareList(int plantId) {
        ArrayList<PlantCareAdvice> plantCareList = new ArrayList<PlantCareAdvice>();
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants/" + String.valueOf(plantId) + "/care_plan"));
            plantCareList = factory.createPlantCareList(jsonData);
        } catch (IOException ex) {

        }
        return plantCareList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlantCareAdvice> getPlantCareList(int plantId, Date from, Date to, String vdmModule, String adviceType) {
        ArrayList<PlantCareAdvice> plantCareList = new ArrayList<PlantCareAdvice>();
        try {
            ArrayList<Parameter> parameters = new ArrayList<Parameter>();
            if (from != null)
                parameters.add(new Parameter("from", String.valueOf(from)));
            if (to != null)
                parameters.add(new Parameter("to", String.valueOf(to)));
            if (vdmModule != null)
                parameters.add(new Parameter("vdm_module", vdmModule));
            if (adviceType != null)
                parameters.add(new Parameter("advice_type", adviceType));
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants/" + String.valueOf(plantId) + "/care_plan"), parameters);
            plantCareList = factory.createPlantCareList(jsonData);
        } catch (IOException ex) {

        }
        return plantCareList;

    }

    /**
     * {@inheritDoc}
     */
    public PlantCareAdvice getPlantAdvice(int plantId, int adviceId) {
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants/" + String.valueOf(plantId) + "/care_plan/" + String.valueOf(adviceId)));
            return factory.createCareAdvice(jsonData);
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlantCareAdvice> getPlantPendingTaskList(int plantId) {
        ArrayList<PlantCareAdvice> plantCareList = new ArrayList<PlantCareAdvice>();
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants/" + String.valueOf(plantId) + "/pending_tasks"));
            plantCareList = factory.createPlantCareList(jsonData);
        } catch (IOException ex) {

        }
        return plantCareList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlantCareAdvice> getPlantPendingTaskList(int plantId, String vdmModule) {
        ArrayList<PlantCareAdvice> plantCareList = new ArrayList<PlantCareAdvice>();
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants/" + String.valueOf(plantId) + "/pending_tasks"),
                    new Parameter("vdm_module", vdmModule));
            plantCareList = factory.createPlantCareList(jsonData);
        } catch (IOException ex) {

        }
        return plantCareList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Sensor> getPlantSensorReadingsList(int plantId) {
        ArrayList<Sensor> plantSensorReadingList = new ArrayList<Sensor>();
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants/" + String.valueOf(plantId) + "/readings"));
            plantSensorReadingList = factory.createPlantSensorReadingList(jsonData);
        } catch (IOException ex) {

        }
        return plantSensorReadingList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Sensor> getPlantSensorReadingsList(int plantId, boolean onlyRecentReadings) {
        ArrayList<Sensor> plantSensorReadingList = new ArrayList<Sensor>();
        try {
            String jsonData = RestHelper.getJsonData(conf.getRestReference("plants/" + String.valueOf(plantId) + "/readings"),
                    new Parameter("only_recent_readings", String.valueOf(onlyRecentReadings)));
            plantSensorReadingList = factory.createPlantSensorReadingList(jsonData);
        } catch (IOException ex) {

        }
        return plantSensorReadingList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CareAction publishAction(int plantId, ActionTypeEnum actionType) {
        CareAction action = new CareAction(plantId);
        action.setActionType(actionType);
        String postData = factory.retrieveJSONString(action);
        String jsonData = null;
        try {
            jsonData = RestHelper.postJsonData(conf.getRestReference("plants/" + String.valueOf(plantId) + "/tasks"),
                    postData);
            return factory.createCareAction(jsonData);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CareAction publishAction(int plantId, ActionTypeEnum actionType, Date time, int careAdviceId) {
        CareAction action = new CareAction(plantId);
        action.setActionType(actionType);
        action.setTime(time);
        String postData = factory.retrieveJSONString(action);
        String jsonData = null;
        try {
            jsonData = RestHelper.postJsonData(conf.getRestReference("plants/" + String.valueOf(plantId) + "/tasks"),
                    postData);
            return factory.createCareAction(jsonData);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }


}
