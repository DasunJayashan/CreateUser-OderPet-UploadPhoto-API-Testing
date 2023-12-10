package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JsonFileReader {

    private JsonNode getData(String fileName){
        ClassLoader classLoader=getClass().getClassLoader();
        File file=new File(classLoader.getResource(fileName+".json").getFile());
        FileInputStream fileInput=null;
        try {
            fileInput=new FileInputStream(file);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        JsonNode jsonNode=null;
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            jsonNode=objectMapper.readTree(fileInput);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return jsonNode;
    }
    public String getJson(String fileName, String key){
        return getData(fileName).get(key).toString();
    }
}
