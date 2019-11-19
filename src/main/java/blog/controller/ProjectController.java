/**
 * FileName: ProjectController
 * Author:   hy
 * Date:     2019/11/17 14:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.controller;

import blog.entity.Article;
import blog.entity.Project;
import blog.factory.DaoFactory;
import blog.util.ResponseObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/project")
public class ProjectController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Project> projectList = null;
        try{
            projectList = DaoFactory.getProjectImpl().selectALLProject();
        }
        catch(SQLException e){
            logger.error("获取所有专题信息失败");
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        Gson gson = new GsonBuilder().create();
        ResponseObject ro = ResponseObject.success(200,"成功",projectList);
        out.print(gson.toJson(ro));
        out.close();
    }
}
