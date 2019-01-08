package com.piterskikh.jpa.testconnection;

import bitronix.tm.resource.jdbc.PoolingDataSource;

public enum DatabaseProduct {

    H2(
            (ds, connectionURL) -> {
                ds.setClassName("org.h2.jdbcx.JdbcDataSource");

                // External instance: jdbc:h2:tcp://localhost/mem:test;USER=sa
                ds.getDriverProperties().put(
                    "URL",
                    connectionURL != null
                        ? connectionURL :
                        "jdbc:h2:mem:test"
                );

                // TODO: http://code.google.com/p/h2database/issues/detail?id=502
                ds.getDriverProperties().put("user", "sa");

                // TODO: Don't trace log values larger than X bytes (especially useful for
                // debugging LOBs, which are accessed in toString()!)
                // System.setProperty("h2.maxTraceDataLength", "256"); 256 bytes, default is 64 kilobytes

        },
        ImprovedH2Dialect.class.getName()
    ),

    MYSQL(
            (ds, connectionURL) -> {
                    // TODO: MySQL XA support is completely broken, we use the BTM XA wrapper
                    //ds.setClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
                    ds.setClassName("bitronix.tm.resource.jdbc.lrc.LrcXADataSource");
                    ds.getDriverProperties().put(
                            "url",
                            connectionURL != null
                                    ? connectionURL :
                                    "jdbc:mysql://localhost:3306/jpatest?sessionVariables=sql_mode='PIPES_AS_CONCAT'"
                    );

                    ds.getDriverProperties().put("driverClassName", "com.mysql.jdbc.Driver");
                    ds.getDriverProperties().put("user", "root");
                    ds.getDriverProperties().put("password", "root");

            },
            // Yes, this should work with 5.6, no idea why Gail named it 5.7
            org.hibernate.dialect.MariaDBDialect.class.getName()
    );

    public DataSourceConfiguration configuration;
    public String hibernateDialect;

    private DatabaseProduct(DataSourceConfiguration configuration,
                            String hibernateDialect) {
        this.configuration = configuration;
        this.hibernateDialect = hibernateDialect;
    }

    public interface DataSourceConfiguration {
        void configure(PoolingDataSource ds, String connectionURL);
    }

}
