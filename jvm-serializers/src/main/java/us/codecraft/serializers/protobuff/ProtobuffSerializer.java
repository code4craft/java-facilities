package us.codecraft.serializers.protobuff;

import java.io.IOException;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-13 <br>
 * Time: 下午4:03 <br>
 */
public class ProtobuffSerializer{

    public byte[] serialize(PersonProto.Person v) throws IOException {
        return v.toByteArray();
    }

    public PersonProto.Person deSerialize(byte[] bytes) throws IOException {
        return PersonProto.Person.parseFrom(bytes);
    }
}
