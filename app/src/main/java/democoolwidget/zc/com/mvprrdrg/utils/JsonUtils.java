package democoolwidget.zc.com.mvprrdrg.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static Gson mGson = new Gson();


    public static String toJson(Object list) {
        return mGson.toJson(list);
    }


    public static <T> List<T>  getStringTList(String json,Class<T> clazz){
        List<T> lst = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            lst.add(mGson.fromJson(elem, clazz));
        }
        return lst;
    }
}
