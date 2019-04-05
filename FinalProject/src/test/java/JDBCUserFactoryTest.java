import com.finalproject.model.dao.DaoFactory;
import com.finalproject.model.dao.UserDao;
import com.finalproject.model.dao.impl.JDBCDaoFactory;
import com.finalproject.model.dao.impl.JDBCUserFactory;
import com.finalproject.model.entity.User;
import com.finalproject.model.entity.enums.Role;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertTrue;

public class JDBCUserFactoryTest {
    private JDBCDaoFactory jdbcDaoFactory;
    private Connection connection;
    private JDBCUserFactory jdbcUserFactory;

    @Before
    public void init() {

    }

    @Test
    public void createTest() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao dao = daoFactory.createUser();
        User user = new User();
        user.setRole(Role.USER);
        user.setName("name");
        user.setUsername("username");
        user.setEmail("email@gmail.com");
        user.setPassword("password");
        assertTrue(dao.create(user));
    }

}
