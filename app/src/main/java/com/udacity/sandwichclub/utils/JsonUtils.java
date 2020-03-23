package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            String name = jsonObject.getJSONObject("name").getString("mainName");
            JSONArray AKAarray = jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs");
            List<String> AKA = new ArrayList<String>();
            if (AKAarray.length() != 0) {
                for (int i = 0 ; i < AKAarray.length() ; i++){
                    AKA.add(AKAarray.getString(i));
                }
            }
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String descrip = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            JSONArray ingredArray = jsonObject.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<String>();
            if (ingredArray.length() != 0) {
                for (int i = 0 ; i < ingredArray.length() ; i++){
                    ingredients.add(ingredArray.getString(i));
                }
            }
            return new Sandwich(name,AKA,placeOfOrigin,descrip,image,ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
