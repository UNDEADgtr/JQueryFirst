package by.undead.jquery;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Khralovich Dzmitry
 * Date: 19.06.13
 * Time: 16:26
 */
@ManagedBean(name = "main")
@SessionScoped
public class Main implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Object> cars = new HashMap<String, Object>();

    public Main() {
        this.cars.put("model", "123");
    }

    public void addJson() {
        writeJson(cars);
    }


    private String color;

    public void writeJson(Map<String, Object> value) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("/home/dzmity/IdeaProjects/JQueryFirst/src/main/webapp/resources/json/test.json"));
            JSONObject jsonObject = (JSONObject) obj;

            for (Map.Entry<String, Object> entry : value.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

//            String name = (String) jsonObject.get("name");
//            long age = (Long) jsonObject.get("age");
//            JSONArray msg = (JSONArray) jsonObject.get("messages");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

            FileWriter file = new FileWriter("/home/dzmity/IdeaProjects/JQueryFirst/src/main/webapp/resources/json/test.json");
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

    public Map<String, Object> getCars() {
        return cars;
    }

    public void setCars(Map<String, Object> cars) {
        this.cars = cars;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
