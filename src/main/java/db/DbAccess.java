package db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


/**
 * 访问数据库
 */
public class DbAccess {
    //会话需要关闭 gdbc同样
    public SqlSession getSqlSession() throws IOException {
        //通过配置文件获取数据库的连接信息  mybaits 所带的获取配置文件 src文件为根
        //classpath下
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //通过配置信息构建一个sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //通过sqlSessionFactory打开一个数据库会话 获得一个sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
