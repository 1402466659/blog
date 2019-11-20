/**
 * FileName: StringUtil
 * Author:   hy
 * Date:     2019/11/20 10:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.util;

import java.util.Random;

public class StringUtil {

    public static  String getRandomString(){
        int a[] = new int[4];
        Random random  = new Random();
        String str = "";
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(10) + 48;
            int uppercase = random.nextInt(26) + 65;
            int lowercase = random.nextInt(26) + 97;
            a[0] = num;
            a[1] = uppercase;
            a[2] = lowercase;
            str+=(char)a[random.nextInt(3)];
        }
        return str;
    }


    public static void main(String[] args) {
        StringUtil stringutil = new StringUtil();
    }
}