/**
 * FileName: ArticleDao
 * Author:   hy
 * Date:     2019/11/9 21:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.dao;

import blog.entity.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {
    int[] batchInsertArticle (List<Article> articlelist) throws SQLException;
    List<Article> selectAll() throws SQLException;
    void insertDetail(List detailmessage) throws SQLException;
    public void insertpic(List articlepic) throws SQLException;
}
