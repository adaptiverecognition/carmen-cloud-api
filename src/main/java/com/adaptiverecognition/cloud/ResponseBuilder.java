/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptiverecognition.cloud;

import com.adaptiverecognition.cloud.vehicle.AdrPlate;
import com.adaptiverecognition.cloud.vehicle.LicensePlate;
import com.adaptiverecognition.cloud.vehicle.Plate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

public class ResponseBuilder {
    /**
     * 
     */
    protected static final RuntimeTypeAdapterFactory<Plate> adapter = RuntimeTypeAdapterFactory
            .of(Plate.class)
            .registerSubtype(Plate.class)
            .registerSubtype(AdrPlate.class)
            .registerSubtype(LicensePlate.class);
    /**
     * 
     */
    private Gson jsonConverter;

    /**
     * 
     */
    public ResponseBuilder() {
        this(new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create());
    }

    /**
     * 
     * @param jsonConverter
     */
    public ResponseBuilder(Gson jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    /**
     * 
     * @return
     */
    public Gson getJsonConverter() {
        return this.jsonConverter;
    }

    /**
     * 
     * @param result
     * @return
     */
    public String createResponse(Result result) {
        return getJsonConverter().toJson(result, result.getClass());
    }
}
