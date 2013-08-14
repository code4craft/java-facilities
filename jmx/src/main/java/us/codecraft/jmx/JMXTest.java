package us.codecraft.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author yihua.huang@dianping.com <br>
 *         Date: 13-8-14 <br>
 *         Time: 下午10:55 <br>
 */
public class JMXTest {
    public static void main(String[] args) throws Exception {
        ApplicationCache cache = new ApplicationCache();
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("us.codecraft.jmx:type=ApplicationCache");
        mbs.registerMBean(cache, name);
        imitateActivity(cache);
    }
    private static void imitateActivity(ApplicationCache cache) {
        while(true) {
            try {
                cache.cacheObject(new Object());
                Thread.sleep(1000);
            }
            catch(InterruptedException e) { }
        }
    }
}