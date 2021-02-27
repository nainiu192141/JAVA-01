package com.nainiu192141.springjdbc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author 86134
 */
@SpringBootApplication
@Data
public class SpringJdbcApplication {

    @Resource
    private DataSource dataSource;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringJdbcApplication.class, args);
        SpringJdbcApplication application = applicationContext.getBean(SpringJdbcApplication.class);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // JDBC原生
        crudByJDBC(application);
        // tx, preparedStatement
        crudByTransaction(application);
        // HikariCP
        crudByHikariCP(application);

    }

    private static void crudByJDBC(SpringJdbcApplication application) {
        try (Connection con = DriverManager.getConnection(application.getUrl(), application.getUsername(), application.getPassword());
             Statement st = con.createStatement();) {
            st.execute("insert into users values ('xxx', '我的xxx',1)");
            st.execute("insert into users values ('xxxx', '我的xxxx',1)");
            st.execute("insert into users values ('xxxxx', '我的xxxxx',1)");
            st.execute("delete from users where username = 'xxxx'");
            st.execute("update users set password = 'cccc' where username = 'xxxxx'");
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                System.out.println(String.format("username:%s, password:%s", rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void crudByTransaction(SpringJdbcApplication application) {
        try (Connection con = DriverManager.getConnection(application.getUrl(), application.getUsername(), application.getPassword());
             PreparedStatement createStatement = con.prepareStatement("insert into users values (?,?)");
             PreparedStatement retrieveStatement = con.prepareStatement("select * from users");
             PreparedStatement updateStatement = con.prepareStatement("update users set password = ? where username = ?");
             PreparedStatement deleteStatement = con.prepareStatement("delete from users where username = ?")) {
             con.setAutoCommit(false);
            //新增 tx
            createStatement.setString(1, "111");
            createStatement.setString(2, "ddd");
            createStatement.addBatch();
            createStatement.setString(1, "222");
            createStatement.setString(2, "eee");
            createStatement.addBatch();
            createStatement.executeBatch();
            //修改
            updateStatement.setString(1, "dddd");
            updateStatement.setString(2, "111");
            updateStatement.execute();
            //删除
            deleteStatement.setString(1, "222");
            deleteStatement.execute();

            ResultSet rs = retrieveStatement.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("username:%s, password:%s", rs.getString("username"), rs.getString("password")));
            }

            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void crudByHikariCP(SpringJdbcApplication application) {
        try (Connection con = application.getDataSource().getConnection();
             PreparedStatement retrieveStatement = con.prepareStatement("select * from users where username = ?")) {
            retrieveStatement.setString(1, "dave");
            ResultSet rs = retrieveStatement.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("username:%s, password:%s", rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
