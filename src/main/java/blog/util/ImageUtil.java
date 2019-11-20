/**
 * FileName: ImageUtil
 * Author:   hy
 * Date:     2019/11/20 11:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    /**
     * 将字符串绘制成指定大小的矩形图片
     */
    public  static BufferedImage getIamge (String content,int width,int height){
       BufferedImage  bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
       Graphics2D g= (Graphics2D) bufferedImage.getGraphics();
       g.setBackground(new Color(255, 255, 255));
       //g.setColor(new Color(43, 43, 43));
       g.setPaint(new Color(254, 49, 93));
       g.drawRect(0,0,200,100);
       Font font = new Font("微软雅黑",Font.BOLD,30);
       g.setFont(font);
//       g.setColor(new Color(0,0,0));
       g.drawString(content,50,50);
        return bufferedImage;
    }

    public static void main(String[] args) throws IOException {
        //生成验证码
        String code = StringUtil.getRandomString();//生成图片
        BufferedImage img = ImageUtil.getIamge(code,200,100);
        File file = new File("D://code.jpg");
        ImageIO.write(img,"jpg",file);
    }
}
