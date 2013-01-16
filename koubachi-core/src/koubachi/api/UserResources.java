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
package koubachi.api;

import koubachi.objects.Device;

import java.util.ArrayList;

/**
 * @author Gabriel Pulido - gabriel.pulidodetorres at gmail.com
 */
public interface UserResources {


    /**
     * List all smart devices associated with the current user
     * <br>http://api.koubachi.com/v2/user/smart_devices
     *
     * @param onlyRecentAssociatedDevices When true, only smart devices associated with the current user in the last 10 minutes are returned
     * @return the devices associated with the current user
     * @see <a href="http://labs.koubachi.com/documentations/1">user/smart_devices/show</a>
     */
    ArrayList<Device> getDevices(boolean onlyRecentAssociatedDevices);

    /**
     * Show smart device information of a specified smart device associated with the current user
     * <br>http://api.koubachi.com/v2/user/smart_devices/:mac_address
     *
     * @param macAddress the mac address of the device to show information
     * @return the devices associated with the current user
     * @see <a href="http://labs.koubachi.com/documentations/2">user/smart_devices/list</a>
     */
    Device getDevice(String macAddress);


}
