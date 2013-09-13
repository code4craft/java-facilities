package us.codecraft.nio;

import java.nio.ByteBuffer;

/**
 * @author yihua.huang@dianping.com
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.put((byte)1);
        byteBuffer.put((byte)2);
    }
}
