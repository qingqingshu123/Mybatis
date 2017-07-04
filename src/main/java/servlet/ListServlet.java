package servlet;

import sevrice.ListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 列表页面初始化控制
 */

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("UTF-8");
        String path = req.getContextPath();
        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
//        System.out.println(path);
//        System.out.println(basePath);
        //得到参数 接收页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        //向页面传值
        req.setAttribute("command",command);
        req.setAttribute("description",description);
        //查询消息列表并传给页面
        ListService listService = new ListService();
        req.setAttribute("messageList",listService.queryMeesageList(command,description));
        //向页面跳转
        req.getRequestDispatcher("WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
