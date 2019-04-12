import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCDaoFactory;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.dao.impl.JDBCUserFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertTrue;

public class JDBCUserFactoryTest {
    private JDBCDaoFactory jdbcDaoFactory;
    private Connection connection;
    private JDBCUserFactory jdbcUserFactory;
    private DaoFactory daoFactory;
    @Before
    public void init() {
        daoFactory = DaoFactory.getInstance();
    }


    @Test
    public void udpateTest() {
        JDBCTaxReturnFactory dao = daoFactory.createTaxReturn();
        assertTrue(dao.taxReturnHasReport(21));
    }


    @Test
    public void changeInspectorTest(){

    }


}
