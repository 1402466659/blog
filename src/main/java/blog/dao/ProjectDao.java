package blog.dao;

import blog.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
   int[] batchInsertProject(List listproject) throws SQLException;
   List<Project> selectALLProject() throws SQLException;
}
