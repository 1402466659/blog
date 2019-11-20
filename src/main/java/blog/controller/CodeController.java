/**
 * FileName: CodeController
 * Author:   hy
 * Date:     2019/11/20 11:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.controller;

import blog.entity.User;
import blog.util.ImageUtil;
import blog.util.StringUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns ="/code")
public class CodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = StringUtil.getRandomString();//生成图片
        BufferedImage img = ImageUtil.getIamge(code,200,100);
        //设置resp
        resp.setContentType("image/jpg");
        OutputStream out =resp.getOutputStream();
        ImageIO.write(img,"jpg",out);
        out.close();
    }
}
