package serializers;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import us.codecraft.serializers.Serializer;
import us.codecraft.serializers.build_in.BuildinSerializer;
import us.codecraft.serializers.entiy.Person;

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

	private List<Serializable> serializables = new ArrayList<Serializable>();

	@Before
	public void setUp() {
		serializers.add(new BuildinSerializer());
		serializables.add(new Person());
	}

	@Test
	public void test() throws IOException {
		for (Serializer serializer : serializers) {
            for (Serializable serializable : serializables) {
                testEach(serializer,serializable);
            }
        }
	}

	public void testEach(Serializer serializer, Serializable serializable) throws IOException {
        byte[] serialize = serializer.serialize(serializable);
        Serializable deSerialized = serializer.deSerialize(serialize);
        Assert.assertEquals(serializable,deSerialized);
    }

}
