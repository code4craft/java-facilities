package us.codecraft.serializers.build_in;

import us.codecraft.serializers.Serializer;

import java.io.*;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-13 <br>
 * Time: 下午3:15 <br>
 */
public class BuildinSerializer implements Serializer{

    @Override
    public <T extends Serializable> byte[] serialize(T v) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(v);
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T extends Serializable> T deSerialize(byte[] bytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        try {
            T t = (T) objectInputStream.readObject();
            return t;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
