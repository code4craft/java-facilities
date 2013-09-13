package us.codecraft.template;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author code4crafter@gmail.com
 */
public class FreemarkerTest {

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setTemplateLoader(new FileTemplateLoader(new File("/Users/yihua/codecraft/java-facilities/template/src/main/resources/")));
        Template template = configuration.getTemplate("list.ftl");
        StringWriter out = new StringWriter();
        template.process(null, out);
    }
}
