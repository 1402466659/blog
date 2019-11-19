/**
 * FileName: UserServiceImpl
 * Author:   hy
 * Date:     2019/11/9 15:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.service.impl;

import blog.dao.UserDao;
import blog.domain.UserDto;
import blog.entity.User;
import blog.factory.DaoFactory;
import blog.service.UserService;
import blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userdao = DaoFactory.getUserDaoImpl();
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public Map<String, Object> signIn(UserDto userdto){
       User user = null;
       Map<String,Object> map = new HashMap<>();
        try {
            user =userdao.findUserByMobile(userdto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if(user!=null){
            if(user.getPassword().equals(userdto.getPassword())){
                map.put("msg","登录成功");
                map.put("data",user);
            }else{
                map.put("msg","密码错误");
            }
        }else{
            map.put("msg","手机号不存在");
        }
        return map;

    }
}
