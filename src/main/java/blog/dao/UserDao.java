/**
 * FileName: UserDao
 * Author:   hy
 * Date:     2019/11/9 14:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.dao;

import blog.entity.Article;
import blog.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    int[] batchInsert (List<User> userlist) throws SQLException;
    User findUserByMobile(String mobile) throws SQLException;
    List<User> selectAlluser() throws SQLException;
}
