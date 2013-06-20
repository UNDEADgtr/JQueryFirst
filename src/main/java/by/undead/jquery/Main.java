package by.undead.jquery;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.faces.bean.ManagedBean;
import java.io.FileWriter;
import java.io.IOException;

/**
 * User: Khralovich Dzmitry
 * Date: 19.06.13
 * Time: 16:26
 */
@ManagedBean(name = "main")
public class Main {


    public void writeJson() {
        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try {

            FileWriter file = new FileWriter("/home/dzmity/IdeaProjects/JQueryFirst/src/main/webapp/resources/json/test.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
    }

}
