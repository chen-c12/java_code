package t_userSQL.test;

import org.junit.Test;
import t_userSQL.pojo.Book;
import t_userSQL.service.BookService;
import t_userSQL.service.Impl.BookServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Н№гу
 * @title: BookServiceImplTest
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/10/3117:04
 */
public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"chen",new BigDecimal(10000),"ddd",1000,999,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24,"chenwwwww",new BigDecimal(10000),"ddd",1000,999,null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(4));
    }

    @Test
    public void queryBook() {
        System.out.println(bookService.queryBook());
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, 4));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, 4, 1, 100));
    }
}