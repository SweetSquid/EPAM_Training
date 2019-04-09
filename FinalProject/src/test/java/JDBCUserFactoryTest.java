import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.impl.JDBCActionReportFactory;
import com.finalproject.model.dao.impl.JDBCDaoFactory;
import com.finalproject.model.dao.impl.JDBCTaxReturnFactory;
import com.finalproject.model.dao.impl.JDBCUserFactory;
import com.finalproject.model.entity.ActionReport;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.time.LocalDateTime;

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
        JDBCActionReportFactory dao = daoFactory.createActionReport();
        ActionReport actionReport = new ActionReport();
        actionReport.setAction(ActionReport.Action.APPROVED);
        actionReport.setDate(LocalDateTime.now());
        dao.create(actionReport,4);
        dao.create(actionReport,5);
        dao.create(actionReport,17);
        dao.create(actionReport,18);
        dao.create(actionReport,19);
        dao.create(actionReport,20);
    }


}
