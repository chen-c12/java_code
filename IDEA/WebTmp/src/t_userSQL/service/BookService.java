package t_userSQL.service;

import t_userSQL.pojo.Book;
import t_userSQL.pojo.Page;

import java.util.List;

/**
 * @author ½ðÓã
 * @title: BookService
 * @projectName WebTmp
 * @description: BookService½Ó¿Ú
 * @date 2021/10/3116:48
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBook();

    Page<Book> page(int pageNumber, int pageSize);

    Page<Book> pageByPrice(int pageNumber, int pageSize, int min, int max);
}
