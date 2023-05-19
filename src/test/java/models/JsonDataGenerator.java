package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class JsonDataGenerator {
    public static void main(String[] args) {
        String json = "[\n" +
                "  {\n" +
                "    \"url\": \"https://web2.0calc.com/\",\n" +
                "    \"expressions\": [\n" +
                "      \"2+3\",\n" +
                "      \"10-2\",\n" +
                "      \"(10-2)*2\",\n" +
                "      \"sin(30)\"\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        Gson gson = new Gson();

        Type dataListType = new TypeToken<List<DataItem>>() {}.getType();
        List<DataItem> dataItems = gson.fromJson(json, dataListType);

        for (DataItem item : dataItems) {
            System.out.println("URL: " + item.getUrl());
            System.out.println("Expressions:");
            for (String expression : item.getExpressions()) {
                System.out.println("- " + expression);
            }
        }
    }
}
