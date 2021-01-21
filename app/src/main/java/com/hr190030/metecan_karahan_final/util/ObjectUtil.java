package com.hr190030.metecan_karahan_final.util;

import com.google.gson.Gson;
import com.hr190030.metecan_karahan_final.model.TakimModel;


public class ObjectUtil {

    public  static String takimToJsonString(TakimModel takimModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(takimModel);
    }

    public  static TakimModel jsonStringToTakim(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,TakimModel.class);
    }
}