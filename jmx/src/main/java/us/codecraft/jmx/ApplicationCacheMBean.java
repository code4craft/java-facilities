package us.codecraft.jmx;

/**
 * @author yihua.huang@dianping.com <br>
 *         Date: 13-8-14 <br>
 *         Time: 下午10:54 <br>
 */
public interface ApplicationCacheMBean {

    int getMaxCacheSize();
    void setMaxCacheSize(int value);
    int getCachedObjects();
    void clearCache();

}
