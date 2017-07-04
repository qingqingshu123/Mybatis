package dao;

import bean.Message;
import db.DbAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 和message表相关的数据库操作
 */
public class MessageDao {




    public void deleteOne(int id){
        DbAccess dbAccess = new DbAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession= dbAccess.getSqlSession();
            //通过session执行  mapper 中对应select语句  传参数
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();  //需要手动提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭Sqlsession
            if(sqlSession!=null)
                sqlSession.close();
        }
    }

    public void deleteBatch(List<Integer> list){
        DbAccess dbAccess = new DbAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession= dbAccess.getSqlSession();
            //通过session执行  mapper 中对应select语句  传参数
            sqlSession.delete("Message.deleteBatch", list);
            sqlSession.commit();  //需要手动提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭Sqlsession
            if(sqlSession!=null)
                sqlSession.close();
        }
    }


    public  List<Message> queryMessage(String command, String description){
        DbAccess dbAccess = new DbAccess();
        List<Message> messageList = new ArrayList<Message>();
        SqlSession sqlSession = null;
        try {
            sqlSession= dbAccess.getSqlSession();
            //通过session执行  mapper 中对应select语句  传参数
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            messageList= sqlSession.selectList("Message.queryMessage",message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭Sqlsession
            if(sqlSession!=null)
                sqlSession.close();
        }
        return messageList;


//        ResultSet rs;
//        rs.getString();
//        rs.getMetaData().getColumnClassName(1);


//        List<Message> messageList = new ArrayList<Message>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micor_message", "root", "910214");
//            StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");  //避免出错
//            List<String> paraList = new ArrayList<String>();// 存参数
//            if (command != null && !"".equals(command.trim())) {
//                sql.append(" and COMMAND= ? ");
//                paraList.add(command);
//            }
//            if (description != null && !"".equals(description.trim())) {
//                sql.append(" and DESCRIPTION like '%' ? '%'"); //模糊查询  //MySql语法：'%'空格?空格'%'
//                //Stirng sql="select * from user where username like ? "; pst.setString(1,'%'+user.getUsername+'%');
//                paraList.add(description);
//            }
//            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
//            for (int i = 0; i < paraList.size(); i++) {
//                //数据库中索引从1开始   第几个问号
//                preparedStatement.setString(i + 1, paraList.get(i));
//            }
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                Message message = new Message();
//                message.setId(resultSet.getInt("ID"));
//                message.setCommand(resultSet.getString("COMMAND"));
//                message.setDescription(resultSet.getString("DESCRIPTION"));
//                message.setContent(resultSet.getString("CONTENT"));
//                messageList.add(message);
//                //System.out.println(message);
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return messageList;
    }
    //可以用测试做
    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        messageDao.queryMessage("","");
    }
}
