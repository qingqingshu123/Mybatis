package servlet;

import sevrice.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jixiaoqiang on 2017/7/3.
 */
public class DeleteBatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("UTF-8");
        //得到参数 接收页面的值
        String [] ids = req.getParameterValues("ids");
        if(ids!=null){
            System.out.println(ids.length);
            for (int i = 0; i < ids.length; i++) {
                System.out.println(ids[i]);
            }
        }
        //查询消息列表并传给页面
        MaintainService maintainService = new MaintainService();
        maintainService.deleteBatch(ids);
        //向页面跳转
        req.getRequestDispatcher("/List.action").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
