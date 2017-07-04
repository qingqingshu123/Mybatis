package sevrice;

import dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护业务的相关功能
 */
public class MaintainService {
    public void deleteOne(String id){
        if(id != null && !"".equals(id.trim())){
            MessageDao messageDao = new MessageDao();
            messageDao.deleteOne(Integer.valueOf(id));
        }
    }

    public void deleteBatch(String[] ids){
        if(ids != null && ids.length != 0){
            MessageDao messageDao = new MessageDao();
            List<Integer> list = new ArrayList<Integer>();
            for(String i: ids){
                list.add(Integer.valueOf(i));
            }
            messageDao.deleteBatch(list);
        }

    }
}
