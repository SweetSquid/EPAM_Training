import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.TaxReturnDao;
import com.finalproject.model.dao.UserDao;
import com.finalproject.model.dao.impl.JDBCDaoFactory;
import com.finalproject.model.dao.impl.JDBCUserFactory;
import com.finalproject.model.entity.TaxReturn;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Arrays;

public class JDBCUserFactoryTest {
    private JDBCDaoFactory jdbcDaoFactory;
    private Connection connection;
    private JDBCUserFactory jdbcUserFactory;
    private DaoFactory daoFactory;
    @Before
    public void init() {
        daoFactory = DaoFactory.getInstance();
    }

    @Ignore
    @Test
    public void udpateTest() {
        TaxReturnDao dao = daoFactory.createTaxReturn();
        TaxReturn taxReturn = new TaxReturn();
        taxReturn.setUserId(4);
        taxReturn.setInspectorId(8);
        taxReturn.setCategory(TaxReturn.Category.LAND_TAX);
        taxReturn.setDate(LocalDateTime.now());
        dao.create(taxReturn);
    }


    @Test
    public void changeInspectorTest(){
        UserDao userDao = daoFactory.createUser();
        System.out.println(Arrays.toString(userDao.getInspectorIdList().toArray()));
    }


}
