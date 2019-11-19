package blog.util;


import blog.entity.Article;
import blog.entity.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @author mq_xu
 * @ClassName JSoupSpider
 * @Description JSoup实现的一个爬虫工具
 * @Date 9:13 2019/11/7
 * @Version 1.0
 **/
public class JSoupSpider {
    private static Logger logger = LoggerFactory.getLogger(JSoupSpider.class);
    private static List detail = new ArrayList(100);
    /**
     * 获取用户信息
     * */
    public static List<User> getUsers() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        for (int i = 1; i <= 10; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("col-xs-8");
            divs.forEach(div -> {
                Element wrapDiv = div.child(0);
                Element link = wrapDiv.child(0);
                Elements linkChildren = link.children();
                User user = new User();
                user.setMobile(Datautil.getMobile());
                user.setPassword(Datautil.getPassword());
                user.setGender(Datautil.getGender());
                user.setAvatar("https:" + linkChildren.get(0).attr("src"));
                user.setNickname(linkChildren.get(1).text());
                user.setIntroduction(linkChildren.get(2).text());
                user.setBirthday(Datautil.getBirthday());
                user.setCreateTime(LocalDateTime.now());
                userList.add(user);
            });
        }
        return userList;
    }
/**
 * 获取文章的简单信息
 */

    public static List<Article> getArticle(){
        List<Article> articleList = new ArrayList<>(100);
        for(int num = 1;num<= 20 ;num++){
            Document document = null;
            try {
                document = Jsoup.connect("https://www.cnblogs.com/sitehome/p/"+num).get();
            } catch (IOException e) {
                System.out.println("错啦");
            }
            Elements datas =  document.getElementsByClass("post_item_body");
            datas.forEach(data->{
//                System.out.println(data.child(0).text());//标题
//                System.out.println(data.child(1).text());//小内容
//                System.out.println(data.child(2).child(1).text());//评论数
//                System.out.println(data.child(2).child(2).text());//阅读
                Article article =new Article();
                article.setTitle(data.child(0).text());
                article.setScontent(data.child(1).text());
                article.setNcomment(data.child(2).child(1).text());
                article.setNread(data.child(2).child(2).text());
                articleList.add(article);
            });
            //获取详细内容
//            Elements detaildivs = document.getElementsByClass("titlelnk");
//            Elements dataillinks = detaildivs.select("a");
//
//            //获取超链接
//            dataillinks.forEach(detaillink->{
//                Document detaildocument = null;
//                try {
//                    detaildocument = Jsoup.connect(""+detaillink.attr("href")).get();
////                    System.out.println(detaillink.attr("href"));//输出url
//                } catch (IOException e) {
//                    System.out.println("爬取详细信息错啦");
//                }
//                Elements detailmessage = detaildocument.getElementsByClass("postBody");
//                Elements messagelink = detailmessage.select("p");
//                //System.out.println(messagelink.text());//输出详细信息
//                messagelink.text().replaceAll(" ", "");
//                detail.add(messagelink.text());
//            });
        }return articleList;

    }
/**
 * 获取详细的文章信息
 * */
    public static List getArticleDetail() {
        for (int num = 1; num <= 20; num++) {
            Document document = null;
            try {
                document = Jsoup.connect("https://www.cnblogs.com/sitehome/p/" + num).get();
            } catch (IOException e) {
                System.out.println("错啦");
            }
            Elements detaildivs = document.getElementsByClass("titlelnk");
            Elements dataillinks = detaildivs.select("a");
            //获取超链接
            dataillinks.forEach(detaillink -> {
                Document detaildocument = null;
                try {
                    detaildocument = Jsoup.connect("" + detaillink.attr("href")).get();
//                    System.out.println(detaillink.attr("href"));//输出url
                } catch (IOException e) {
                    System.out.println("爬取详细信息错啦");
                }
                Elements detailmessage = detaildocument.getElementsByClass("postBody");
                Elements messagelink = detailmessage.select("p");
                //System.out.println(messagelink.text());//输出详细信息
                messagelink.text().replaceAll(" ", "");
                detail.add(messagelink.text());
            });
        }
        return detail;
    }

    public static List getProject(){
        List listproject = new ArrayList();
        listproject.add("短篇小说");
        listproject.add("故事");
        listproject.add("上班那点事儿");
        listproject.add("连载小说");
        listproject.add("程序员");
        listproject.add("哲思");
        listproject.add("漫画");
        listproject.add("任务");
        listproject.add("文学");
        listproject.add("游戏");
        return listproject;
    }



    public static List getArticlePic() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        List articlepic = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("col-xs-8");
            divs.forEach(div -> {
                Element wrapDiv = div.child(0);
                Element link = wrapDiv.child(0);
                Elements linkChildren = link.children();
                articlepic.add("https:" + linkChildren.get(0).attr("src"));
            });
        }
        return articlepic;
    }

}
