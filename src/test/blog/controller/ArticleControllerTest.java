package blog.controller;

import blog.entity.Article;
import blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ArticleControllerTest {

    @Test
    public void doGet() {
        List<Article> articleList = null;
        try{
            articleList = DaoFactory.getArticleImpl().selectAll();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(articleList);
    }
}