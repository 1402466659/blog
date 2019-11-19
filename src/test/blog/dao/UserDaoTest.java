package blog.dao;

import blog.entity.User;
import blog.factory.DaoFactory;
import blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.SQLException;
import java.util.List;

public class UserDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    private UserDao userDao = DaoFactory.getUserDaoImpl();
    @Test
    public void batchInsert() {
        try {
            int[] result = userDao.batchInsert(JSoupSpider.getUsers());
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }

    @Test
    public void selectAlluser() {
        List<User> result=null;
        try {
             result = userDao.selectAlluser();
        } catch (SQLException e) {
            logger.error("查询所有用户出现异常");
        }
        System.out.println(result);
    }
}