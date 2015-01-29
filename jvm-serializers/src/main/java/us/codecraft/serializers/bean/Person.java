package us.codecraft.serializers.bean;

import java.io.Serializable;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-13 <br>
 * Time: 下午3:04 <br>
 */
public class Person implements Serializable{

    private static final long serialVersionUID = -3442422196541638739L;

    private String name;

    private int email;

    private int iad;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getIad() {
        return iad;
    }

    public void setIad(int id) {
        this.iad = id;
    }
}
