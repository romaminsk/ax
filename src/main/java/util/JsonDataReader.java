package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonDataReader {

    public static Map<String, String> getSearchData() {
        CustomLogger.info("Getting search data");
        Map<String, String> search = null;
        try {
            search = new ObjectMapper().readValue(new File(PropertiesReader.getProperty("searchData.path")),
                    new TypeReference<Map<String, String>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
            CustomLogger.error("Can't read searchData.json file");
        }
        return search;
    }

}
