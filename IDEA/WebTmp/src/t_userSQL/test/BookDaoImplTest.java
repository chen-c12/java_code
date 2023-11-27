package t_userSQL.test;

import org.junit.Test;
import t_userSQL.dao.BookDao;
import t_userSQL.dao.impl.BookDaoImpl;
import t_userSQL.pojo.Book;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author ½ðÓã
 * @title: BookDaoImplTest
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/10/3116:19
 */
public class BookDaoImplTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"chenjj",new BigDecimal(999),"³Â",999,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(26);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"chenjjewwwwwwwww",new BigDecimal(9999),"³Â",999,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(2));
    }

    @Test
    public void queryBook() {
        System.out.println(bookDao.queryBook());
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems(){
        for (Book book : bookDao.queryForPageItems(4, 4)) {
            System.out.println(book);
        }
    }
    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 1000000));
    }

    @Test
    public void queryForPageItemsByPrice(){
        System.out.println(bookDao.queryForPageItemsByPrice(1, 20, 1, 100));
    }
}