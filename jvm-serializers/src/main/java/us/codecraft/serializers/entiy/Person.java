package us.codecraft.serializers.entiy;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-13 <br>
 * Time: 下午3:04 <br>
 */
@EqualsAndHashCode
@ToString
@Data
public class Person implements Serializable{

    private static final long serialVersionUID = -3442422196541638739L;

    private String name;

    private String email;

    private int id;

}
