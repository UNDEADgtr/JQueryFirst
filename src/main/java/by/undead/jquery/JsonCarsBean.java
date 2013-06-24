package by.undead.jquery;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "jsonCarsBean")
@ViewScoped
public class JsonCarsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Object> car = new HashMap<String, Object>();

    public Map<String, Object> getCar() {
        return car;
    }

    public void setCar(Map<String, Object> car) {
        this.car = car;
    }

    public void writeJson() {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("/home/dzmity/IdeaProjects/JQueryFirst/src/main/webapp/data.json"));
            JSONObject jsonObject = (JSONObject) obj;

            for (int i = 0; ; i++) {
                if (!jsonObject.containsKey("car" + i)) {
                    jsonObject.put("car" + i, car);
                    break;
                }
            }

            FileWriter file = new FileWriter("/home/dzmity/IdeaProjects/JQueryFirst/src/main/webapp/data.json");
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}