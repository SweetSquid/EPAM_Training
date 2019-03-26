
import com.regform.model.DAO.impl.JDBCDaoFactory;
import com.regform.model.DAO.impl.JDBCNotebookDao;
import com.regform.model.DAO.mapper.NotebookMapper;
import com.regform.model.entity.Notebook;
import com.regform.model.entity.WrongLoginException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.regform.model.DAO.DaoFactory.getInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JDBCDaoFactoryTest {
    private JDBCDaoFactory jdbcDaoFactory;
    private Connection connection;
    private JDBCNotebookDao jdbcNotebookDao;

    @Before
    public void init(){
        jdbcDaoFactory = (JDBCDaoFactory) getInstance();
        connection = jdbcDaoFactory.getConnection();
        jdbcNotebookDao = new JDBCNotebookDao(connection);
    }

    @Test
    public void getConnectionTest() throws SQLException{
        assertFalse(connection.isClosed());
    }

    @Ignore
    @Test
    public void createTest() throws WrongLoginException {
        assertTrue(jdbcNotebookDao.create(new Notebook("Mykyta","sweetsquid")));
    }

    @Test
    public void readTest(){
        Notebook notebook = jdbcNotebookDao.read("sashasuper");
        assertEquals("sashasuper",notebook.getLogin());
    }
    @Ignore
    @Test
    public void deleteTest(){
        assertTrue(jdbcNotebookDao.delete("login"));
    }

    @Ignore
    @Test
    public void updateTest() {
        jdbcNotebookDao.update(new Notebook("name","login"),"login1");
        Notebook notebook = jdbcNotebookDao.read("login");
        assertEquals("login", notebook.getLogin());
    }


    @Test
    public void readAllTest(){
        List<String> nameList = new ArrayList<>();
        List<Notebook> notebookList = jdbcNotebookDao.getAll();
        notebookList.forEach( p -> {
            nameList.add(p.getLogin());
        });
        String expected = "[sashasuper, qwe12345, prosto123]";
        assertEquals(expected, Arrays.toString(nameList.toArray()));
    }

    @Test
    public void isUnique() {
        NotebookMapper notebookMapper = new NotebookMapper();
        assertFalse(notebookMapper.isUnique(new Notebook("name","login")));
        assertFalse(notebookMapper.isUnique(new Notebook("name","prosto123")));
        assertTrue(notebookMapper.isUnique(new Notebook("1","login2")));
    }
}
