package webs;

import t_userSQL.pojo.Book;
import t_userSQL.pojo.Page;
import t_userSQL.service.BookService;
import t_userSQL.service.Impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 金鱼
 * @title: BookServlet
 * @projectName WebTmp
 * @description: 后台BookServlet处理图书模块
 * @date 2021/11/18:31
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();


    /**
     * 显示所有图书信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1，通过bookservlet查询全部图书
        List<Book> books = bookService.queryBook();
        //2,把全部图书保存到request域中
        req.setAttribute("books", books);
        //3,请求转发到/pages/manager/book_manager
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNumber,pageSize);

        page.setUrl("manager/bookServlet?action=page");

        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);



    }
    /**
     * 添加图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"),0);
        pageNumber+=1;
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNumber="+pageNumber);
    }

    /**
     * 删除图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNumber="+req.getParameter("pageNumber"));
    }

    /**
     * 更新图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNumber="+req.getParameter("pageNumber"));
    }

    /**
     * 修改图书时，得到当前图书的信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //保存到图书到Request域中
        req.setAttribute("book", book);
        //请求转发
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
}
