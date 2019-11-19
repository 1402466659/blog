/**
 * FileName: ProjectDaoImpl
 * Author:   hy
 * Date:     2019/11/15 21:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.dao;

import blog.entity.Article;
import blog.entity.Project;
import blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectDaoImpl implements ProjectDao{
    private static Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);

    @Override
    public int[] batchInsertProject(List listproject) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = " INSERT INTO t_project (projectname,projectfollows,projectarticles) VALUES(?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        listproject.forEach(projectname -> {
            try {
                pstmt.setString(1, (String) projectname);
                pstmt.setInt(2,new Random().nextInt(1000));
                pstmt.setInt(3,new Random().nextInt(1000));
                pstmt.addBatch();
            } catch (SQLException e) {
                logger.error("批量新增专题失败");
                e.printStackTrace();
            }
        });
        int [] result = pstmt.executeBatch();
        connection.commit();
        DbUtil.close(null,pstmt,connection);
        return result;
    }

    @Override
    public List<Project> selectALLProject() throws SQLException {
        List<Project> projectList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = " SELECT * FROM t_project ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            Project project = new Project();
            project.setId(rs.getInt("id"));
            project.setProjectname(rs.getString("projectname"));
            project.setProjectarticles(rs.getInt("projectarticles"));
            project.setProjectfollows(rs.getInt("projectfollows"));
            projectList.add(project);
        }
        connection.commit();
//        DbUtil.close(rs,pstmt,connection);
        return projectList;
    }
}
