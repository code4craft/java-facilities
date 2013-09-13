package us.codecraft.orm;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author yihua.huang@dianping.com
 */
public class DbUtilsTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        QueryRunner queryRunner = new QueryRunner();
        Integer query = queryRunner.query(connection, "", new BeanHandler<Integer>(Integer.class));
    }
}
