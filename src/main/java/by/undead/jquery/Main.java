package by.undead.jquery;

import javax.faces.bean.ManagedBean;

/**
 * User: Khralovich Dzmitry
 * Date: 19.06.13
 * Time: 16:26
 */
@ManagedBean(name = "main")
public class Main {

    private String value = "This editor is provided by PrimeFaces";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
