package blog.dao;

import blog.entity.Project;
import blog.factory.DaoFactory;
import blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ProjectDaoTest {
    private static Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);
    private ProjectDao projectDao = DaoFactory.getProjectImpl();
    @Test
    public void batchInsertProject() {
        try {
            int[] result = projectDao.batchInsertProject(JSoupSpider.getProject());
        } catch (SQLException e) {
            logger.error("批量新增专题出现异常");
            e.printStackTrace();
        }
    }

    @Test
    public void selectALLProject() {
        List<Project> result=null;
        try {
             result = projectDao.selectALLProject();
        } catch (SQLException e) {
            logger.error("查询所有专题出现异常");
            e.printStackTrace();
        }
        System.out.println(result);
    }
}