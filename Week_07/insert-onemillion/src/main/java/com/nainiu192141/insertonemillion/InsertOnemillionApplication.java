package com.nainiu192141.insertonemillion;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;

/**
 * 在mysql文件下找到my.ini文件，在【mysqlId】下添加一个配置：
 * max_allowed_packet = 300M 最后重启mysql
 * rewriteBatchedStatements=true 开启批量插入，插入只执行一次，所有插入比较快
 * ps = (PreparedStatement) con.prepareStatement("select * from bigTable",
 *           ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
 *       ps.setFetchSize(Integer.MIN_VALUE);
 *       ps.setFetchDirection(ResultSet.FETCH_REVERSE);
 * @author 86134
 */
@SpringBootApplication
@Data
public class InsertOnemillionApplication {

    @Resource
    private DataSource dataSource;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(InsertOnemillionApplication.class, args);
        InsertOnemillionApplication application = applicationContext.getBean(InsertOnemillionApplication.class);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //sql拼接+jdbc批量执行+preparestatment
        //insertjdbcpstbatch(application);
        //insertJDBC(application);
        //jdbctemplate_batch
        insertBigData(application);
        //insertHikariCP(application);
        //load data infile
        //先队列后跑批
        //改myisam引擎+ 批插入或者换InfoBright的loaddata
        //生成sql文件，source导入
        //setLocalInfileInputStream
        insertLoadInputStream(application);
    }

    private static void insertLoadInputStream(InsertOnemillionApplication application) {
        String testSql = "LOAD DATA LOCAL INFILE 'sql.csv' IGNORE INTO TABLE test.test (a,b,c,d,e,f)";
        InputStream dataStream = loadDataUtil.getTestDataInputStream();
        InsertOnemillionApplication dao = new InsertOnemillionApplication();
        try {
            long beginTime=System.currentTimeMillis();
            int rows=dao.bulkLoadFromInputStream(application,testSql, dataStream);
            long endTime=System.currentTimeMillis();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 从流中加载数据到mysql
     * load bulk data from InputStream to MySQL
     */
    public int bulkLoadFromInputStream(InsertOnemillionApplication application,String loadDataSql,
                                       InputStream dataStream) throws SQLException {
        if(dataStream==null){
            return 0;
        }
        Connection conn = application.getDataSource().getConnection();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(application.getDataSource());
        PreparedStatement statement = conn.prepareStatement(loadDataSql);

        int result = 0;

        if (statement.isWrapperFor(Statement.class)) {

            PreparedStatement mysqlStatement = statement.unwrap(PreparedStatement.class);
            //为什么不可用？？？
            //mysqlStatement.setLocalInfileInputStream(dataStream);
            result = mysqlStatement.executeUpdate();
        }
        return result;
    }
    /**
     * 8ms
     * @param application
     */
    private static void insertjdbcpstbatch(InsertOnemillionApplication application) {
        // 开时时间
        Long begin = System.currentTimeMillis();
        // sql前缀
        String prefix = "INSERT INTO oms_order (member_id, receiver_name, receiver_phone,create_time) VALUES ";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(application.getUrl(), application.getUsername(), application.getPassword());
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // Statement st = conn.createStatement();
            // 比起st，pst会更好些
            pst = conn.prepareStatement(prefix);
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 100; i++) {
                // 第次提交步长
                for (int j = 1; j <= 10000; j++) {
                    // 构建sql后缀
                    suffix.append("(" + j * i + ", 'xfx','13345678765' " + ", SYSDATE()),");
                }
                // 构建完整sql
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行sql
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        // 耗时
        System.out.println("cast : " + (end - begin) / 1000 + " ms");

    }

    /**
     * 82ms
     * @param application
     */
    public static void insertJDBC(InsertOnemillionApplication application) {
        Long begin = System.currentTimeMillis();
        String sql = "INSERT INTO oms_order (member_id, receiver_name, receiver_phone,create_time) VALUES (?,?,?,SYSDATE())";
        try {
            Connection conn = DriverManager.getConnection(application.getUrl(), application.getUsername(), application.getPassword());
            aaa(sql, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println("cast : " + (end - begin) / 1000 + " ms");
    }

    /**
     * hekari
     *7ms
     */
    public static void insertBigData(InsertOnemillionApplication application) {
        Long begin = System.currentTimeMillis();

        /*DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(application.getDataSource());
        dataSource.setUrl(application.getUrl());
        dataSource.setUsername(application.getUsername());
        dataSource.setPassword(application.getPassword());*/

        JdbcTemplate jdbcTemplate=new JdbcTemplate(application.getDataSource());


        String sql = "INSERT INTO oms_order (member_id, receiver_name, receiver_phone,create_time) VALUES (?,?,?,SYSDATE())";

        jdbcTemplate.setLazyInit(true);
        jdbcTemplate.setMaxRows(100000);
        jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement pst, int i) throws SQLException {
                        for (int k = 1; k <= 50000; k++) {
                            pst.setLong(1, i);
                            pst.setString(2, "xfx");
                            pst.setString(3, "1233434444");
                            pst.addBatch();
                        }
                        pst.executeBatch();
                    }
                    @Override
                    public int getBatchSize() { return 20; }
                });


        /* final int count = 1000000;
            jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            // 为prepared statement设置参数。这个方法将在整个过程中被调用的次数
            @Override
            public void setValues(PreparedStatement pst, int i)
                    throws SQLException {
                pst.setLong(1, i);
                pst.setString(2, "xfx");
                pst.setString(3, "1233434444");
            }
            // 返回更新的结果集条数
            @Override
            public int getBatchSize() {
                return count;
            }
        });*/
        Long end = System.currentTimeMillis();
        System.out.println("cast : " + (end - begin) / 1000 + " ms");
    }

    /**
     * 83ms
     * @param application
     */
    private static void insertHikariCP(InsertOnemillionApplication application) {
        Long begin = System.currentTimeMillis();
        String sql = "INSERT INTO oms_order (member_id, receiver_name, receiver_phone,create_time) VALUES (?,?,?,SYSDATE())";

        try {
            Connection conn = application.getDataSource().getConnection();
            aaa(sql, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println("cast : " + (end - begin) / 1000 + " ms");
    }

    private static void aaa(String sql, Connection conn) throws SQLException {
        conn.setAutoCommit(false);
        PreparedStatement pst = conn.prepareStatement(sql);
        for (int i = 1; i <= 100; i++) {
            for (int k = 1; k <= 10000; k++) {
                pst.setLong(1, k * i);
                pst.setString(2, "xfx");
                pst.setString(3, "1233434444");
                pst.addBatch();
            }
            pst.executeBatch();
            conn.commit();
        }
        pst.close();
        conn.close();
    }
}
