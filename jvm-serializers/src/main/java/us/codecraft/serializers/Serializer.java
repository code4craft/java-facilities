package us.codecraft.serializers;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-13 <br>
 * Time: 下午3:13 <br>
 */
public interface Serializer {

    public <T extends Serializable> byte[] serialize(T v) throws IOException;

    public <T extends Serializable> T deSerialize(byte[] bytes) throws IOException;

}
