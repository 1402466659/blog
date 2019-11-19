/**
 * FileName: UserController
 * Author:   hy
 * Date:     2019/11/9 17:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.controller;


import blog.domain.UserDto;
import blog.entity.Article;
import blog.entity.User;
import blog.factory.DaoFactory;
import blog.factory.ServiceFactory;
import blog.service.UserService;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/sign-in")
public class UserController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        logger.info("登录用户信息：" + stringBuilder.toString());
        Gson gson = new GsonBuilder().create();
        UserDto userDto = gson.fromJson(stringBuilder.toString(), UserDto.class);
        Map<String, Object> map = userService.signIn(userDto);
        String msg = (String) map.get("msg");
        ResponseObject ro;
        switch (msg) {
            case "登录成功":
                ro = ResponseObject.success(200, msg, map.get("data"));
                break;
            case "密码错误":
            case "手机号不存在":
            default:
                ro = ResponseObject.success(200, msg);
        }
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<User> userList = null;
            try{
                userList = DaoFactory.getUserDaoImpl().selectAlluser();
            }
            catch(SQLException e){
                logger.error("获取所有学生信息失败");
                e.printStackTrace();
            }
            PrintWriter out = resp.getWriter();
            Gson gson = new GsonBuilder().create();
            ResponseObject ro = ResponseObject.success(200,"成功",userList);
            out.print(gson.toJson(ro));
            out.close();
    }
}
