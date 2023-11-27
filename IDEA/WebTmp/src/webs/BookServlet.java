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
 * @author ����
 * @title: BookServlet
 * @projectName WebTmp
 * @description: ��̨BookServlet����ͼ��ģ��
 * @date 2021/11/18:31
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();


    /**
     * ��ʾ����ͼ����Ϣ
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1��ͨ��bookservlet��ѯȫ��ͼ��
        List<Book> books = bookService.queryBook();
        //2,��ȫ��ͼ�鱣�浽request����
        req.setAttribute("books", books);
        //3,����ת����/pages/manager/book_manager
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
     * �����ҳ����
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
     * ���ͼ��
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
     * ɾ��ͼ��
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
     * ����ͼ��
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
     * �޸�ͼ��ʱ���õ���ǰͼ�����Ϣ
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //��ȡ����Ĳ���
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //����bookService.queryBookById��ѯͼ��
        Book book = bookService.queryBookById(id);
        //���浽ͼ�鵽Request����
        req.setAttribute("book", book);
        //����ת��
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
}
