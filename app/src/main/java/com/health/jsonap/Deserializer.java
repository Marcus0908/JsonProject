package com.health.jsonap;



import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;



/**
 * Created by Leonardo Saganski on 16/07/17.
 */




public class Deserializer<T> implements JsonDeserializer<Object> {

    private Class<T> type;

    public Deserializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement obj = json.getAsJsonObject();

        return ( new Gson().fromJson( obj, this.type ));
    }
}