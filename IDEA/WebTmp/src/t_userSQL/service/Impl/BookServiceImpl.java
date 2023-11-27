package t_userSQL.service.Impl;

import t_userSQL.dao.BookDao;
import t_userSQL.dao.impl.BookDaoImpl;
import t_userSQL.pojo.Book;
import t_userSQL.pojo.Page;
import t_userSQL.service.BookService;

import java.util.List;

/**
 * @author ����
 * @title: BookServiceImpl
 * @projectName WebTmp
 * @description: ʵ�ֽӿ�
 * @date 2021/10/3116:54
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBook() {
        return bookDao.queryBook();
    }

    @Override
    public Page<Book> page(int pageNumber, int pageSize) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal+=1;
        }
        //���ݱ߽����Ч���
        if (pageNumber<1){
            pageNumber=1;
        }
        if (pageNumber>pageTotal){
            pageNumber=pageTotal;
        }

        page.setPageNumber(pageNumber);
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNumber()-1)*pageSize;
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);

        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNumber, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal+=1;
        }
        page.setPageNumber(pageNumber);
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNumber()-1)*pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);

        page.setItems(items);
        return page;
    }
}
