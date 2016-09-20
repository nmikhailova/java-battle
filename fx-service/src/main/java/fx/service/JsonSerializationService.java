package fx.service;

import com.google.gson.Gson;

/**
 * Created by Оля on 18.04.2016.
 */
public class JsonSerializationService <T> {

    public String objectToJson(T obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public T objectFromJson(String json, Class<T> classofT) {
        Gson gson = new Gson();
        return gson.fromJson(json, classofT);
    }
}
