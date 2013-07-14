package serializers;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import us.codecraft.serializers.Serializer;
import us.codecraft.serializers.build_in.BuildinSerializer;
import us.codecraft.serializers.entiy.Person;
import us.codecraft.serializers.hessian.HessianSerializer;
import us.codecraft.serializers.protobuff.PersonProto;
import us.codecraft.serializers.protobuff.ProtobuffSerializer;
import us.codecraft.serializers.utils.ByteDumper;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-13 <br>
 *        Time: 下午3:13 <br>
 */
public class SerializerTest {

	private List<Serializer> serializers = new ArrayList<Serializer>();

	private List<Object> serializables = new ArrayList<Object>();

	@Before
	public void setUp() {
		serializers.add(new BuildinSerializer());
        serializers.add(new HessianSerializer());
        Person person = new Person();
        person.setId(1);
        person.setName("code4crafter");
        person.setEmail("code4crafter@gmail.com");
        serializables.add(person);
	}

	@Test
	public void test() throws IOException {
		for (Serializer serializer : serializers) {
            for (Object o : serializables) {
                testEach(serializer,o);
            }
        }
	}

	public void testEach(Serializer serializer, Object object) throws IOException {
        System.out.println(serializer.getClass());
        System.out.println(object);
        byte[] serialize = serializer.serialize(object);
        System.out.println(ByteDumper.dumperArray(serialize));
        Serializable deSerialized = serializer.deSerialize(serialize);
        Assert.assertEquals(object,deSerialized);
    }

    @Test
    public void testProtobuff() throws IOException {
        ProtobuffSerializer protobuffSerializer = new ProtobuffSerializer();
        PersonProto.Person code4crafter = PersonProto.Person.newBuilder().setName("code4crafter").setEmail("code4crafter@gmail.com").setId(1).build();
        byte[] serialize = protobuffSerializer.serialize(code4crafter);
        System.out.println(ByteDumper.dumperArray(serialize));
        PersonProto.Person person = protobuffSerializer.deSerialize(serialize);
        Assert.assertEquals(code4crafter,person);
    }

}
