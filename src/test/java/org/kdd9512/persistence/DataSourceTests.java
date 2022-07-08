package org.kdd9512.persistence;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
//// Java
//@ContextConfiguration(classes = {RootConfig.class})
// XML
@ContextConfiguration("file:src/main/webapp/WEB-INF/root-context.xml")
@Log4j
public class DataSourceTests {

    @Setter(onMethod_ = {@Autowired})
    private DataSource dataSource;

    @Setter(onMethod_ = {@Autowired})
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testMyBatis(){
        try {

            SqlSession sess = sqlSessionFactory.openSession();
            Connection conn = sess.getConnection();

            log.info(sess);
            log.info(conn);

        } catch (Exception e) {
            fail(e.getMessage());
        }

    }


    @Test
    public void testConnection() {
        try {
            Connection con = dataSource.getConnection();
            log.info(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
