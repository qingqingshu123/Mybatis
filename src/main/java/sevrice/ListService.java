package sevrice;

import bean.Message;
import dao.MessageDao;

import java.util.List;

/**
 * 列表相关的业务功能
 */
public class ListService {
    public List<Message> queryMeesageList(String command, String description){
        MessageDao messageDao = new MessageDao();
        return  messageDao.queryMessage(command, description);
    }
}
