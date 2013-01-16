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
package koubachi.internal.rest;

import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Parameter;
import org.restlet.data.Reference;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: gpt
 * Date: 11/01/13
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public class RestHelper {


    public static String getJsonData(Reference reference, Iterable<Parameter> extraParameters) throws java.io.IOException {
        reference.addQueryParameters(extraParameters);
        ClientResource cr = new ClientResource(reference);
        cr.setMethod(Method.GET);
        Representation rep = cr.get(MediaType.APPLICATION_JSON);
        String jsonData = rep.getText();
        return jsonData;
    }

    public static String getJsonData(Reference reference, Parameter extraParameter) throws java.io.IOException {
        ArrayList<Parameter> extraParameters = new ArrayList<Parameter>();
        extraParameters.add(extraParameter);
        return getJsonData(reference, extraParameters);
    }

    public static String getJsonData(Reference reference) throws java.io.IOException {
        ArrayList<Parameter> extraParameters = new ArrayList<Parameter>();
        return getJsonData(reference, extraParameters);
    }

    public static String postJsonData(Reference reference, String jsonData, Iterable<Parameter> extraParameters) throws java.io.IOException {
        reference.addQueryParameters(extraParameters);
        ClientResource cr = new ClientResource(reference);
        cr.setMethod(Method.POST);
        Representation rep = cr.post(new JsonRepresentation(jsonData));
        Response resp = cr.getResponse();
        String jsonResponse = "";
        String nid = "";
        if (resp.getStatus().isSuccess()) {
            jsonResponse = resp.getEntity().getText();
            return jsonResponse;
        } else {
            System.out.println(resp.getStatus().getName());
        }
        return "";
    }

    public static String postJsonData(Reference reference, String jsonData, Parameter extraParameter) throws java.io.IOException {
        ArrayList<Parameter> extraParameters = new ArrayList<Parameter>();
        extraParameters.add(extraParameter);
        return postJsonData(reference, jsonData, extraParameters);
    }

    public static String postJsonData(Reference reference, String jsonData) throws java.io.IOException {
        ArrayList<Parameter> extraParameters = new ArrayList<Parameter>();
        return postJsonData(reference, jsonData, extraParameters);
    }


}
