package org.kdd9512.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.fail;

@Log4j
public class JDBCTests {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // oracle 접속 테스트.
    // 접속관련 정보 하드코딩. 커밋 시 주의.
    @Test
    public void testConnection(){

        try(Connection con =
                    DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:XE",
                            "book_ex",
                            "hwhw9512")) {
            log.info(con);
        } catch (Exception e){
            fail(e.getMessage());
        }

    }

}
