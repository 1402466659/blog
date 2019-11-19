/**
 * FileName: DaoFactory
 * Author:   hy
 * Date:     2019/11/6 19:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.factory;

import blog.dao.*;

public class DaoFactory {
    public static StudentDaoImpl getStudentDaoInstance(){
        return new StudentDaoImpl();
    }
    public static UserDao getUserDaoImpl (){
        return new UserDaoImpl();
    }
    public static ArticleDao getArticleImpl(){ return new ArticleDaoImpl(); }
    public static ProjectDaoImpl getProjectImpl(){ return new ProjectDaoImpl(); }
}
