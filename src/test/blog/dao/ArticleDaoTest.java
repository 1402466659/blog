package blog.dao;

import blog.entity.Article;
import blog.factory.DaoFactory;
import blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ArticleDaoTest {
    private static Logger logger = LoggerFactory.getLogger(ArticleDapImpl.class);
    private ArticleDao articleDao = DaoFactory.getArticleImpl();
    @Test
    public void batchInsertArticle() {
        try {
            int[] result = articleDao.batchInsertArticle(JSoupSpider.getArticle());
        } catch (SQLException e) {
            logger.error("批量新增文章出现异常");
        }
    }
}