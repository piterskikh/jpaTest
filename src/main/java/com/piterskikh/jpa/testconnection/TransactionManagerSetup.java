package com.piterskikh.jpa.testconnection;

import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jdbc.PoolingDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.transaction.Status;
import javax.transaction.UserTransaction;
import java.util.logging.Logger;

/**
 * Provides a database connection pool with the Bitronix JTA transaction
 * manager (http://docs.codehaus.org/display/BTM/Home).
 * <p>
 * Hibernate will look up the datasource and <code>UserTransaction</code> through
 * JNDI, that's why you also need a <code>jndi.properties</code> file. A minimal
 * JNDI context is bundled with and started by Bitronix.
 * </p>
 */
public class TransactionManagerSetup {

    public static final String DATASOURCE_NAME = "myDS";

    private static final Logger logger =
        Logger.getLogger(TransactionManagerSetup.class.getName());

    protected final Context context = new InitialContext();
    protected final PoolingDataSource datasource;
    public final DatabaseProduct databaseProduct = DatabaseProduct.MYSQL;



    public TransactionManagerSetup() throws Exception {


        TransactionManagerServices.getConfiguration().setServerId("myServer1234");
        TransactionManagerServices.getConfiguration().setDisableJmx(true);
        TransactionManagerServices.getConfiguration().setJournal("null");
        TransactionManagerServices.getConfiguration().setWarnAboutZeroResourceTransaction(false);

        datasource = new PoolingDataSource();
        datasource.setUniqueName(DATASOURCE_NAME);
        datasource.setMinPoolSize(1);
        datasource.setMaxPoolSize(5);
        datasource.setPreparedStatementCacheSize(10);
        datasource.setIsolationLevel("READ_COMMITTED");
        datasource.setAllowLocalTransactions(true);




        databaseProduct.configuration.configure(datasource, null);


        datasource.init();
    }

    public Context getNamingContext() {
        return context;
    }

    public UserTransaction getUserTransaction() {
        try {
            return (UserTransaction) getNamingContext()
                .lookup("java:comp/UserTransaction");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public DataSource getDataSource() {
        try {
            return (DataSource) getNamingContext().lookup(DATASOURCE_NAME);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void rollback() {
        UserTransaction tx = getUserTransaction();
        try {
            if (tx.getStatus() == Status.STATUS_ACTIVE ||
                tx.getStatus() == Status.STATUS_MARKED_ROLLBACK)
                tx.rollback();
        } catch (Exception ex) {
            System.err.println("Rollback of transaction failed, trace follows!");
            ex.printStackTrace(System.err);
        }
    }

    public void stop() throws Exception {
        logger.fine("Stopping database connection pool");
        datasource.close();
        TransactionManagerServices.getTransactionManager().shutdown();
    }

}
