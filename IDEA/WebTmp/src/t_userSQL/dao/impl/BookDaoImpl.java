package t_userSQL.dao.impl;

import t_userSQL.dao.BookDao;
import t_userSQL.pojo.Book;

import java.util.List;

/**
 * @author 金鱼
 * @title: BookDaoImpl
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/10/3115:41
 */
public class BookDaoImpl extends BaseDAO implements BookDao {

    /**
     * 添加图书
     * @param book
     * @return
     */
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,author,price,sales,stock,img_path)values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    /**
     * 更新图书信息
     * @param book
     * @return
     */
    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    /**
     * 根据id查图书
     * @param id
     * @return
     */
    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book where id = ?";
        return queryOne(Book.class,sql,id);
    }

    /**
     * 查询全部图书
     * @return
     */
    @Override
    public List<Book> queryBook() {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book";
        return queryList(Book.class,sql);
    }

    /**
     * 统计所有图书的数量
     * @return
     */
    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) selectAll(sql);
        return count.intValue();
    }

    /**
     * 查询从begin到pageSize的图书信息
     * @param begin
     * @param pageSize
     * @return
     */
    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book limit ?,?";
        return queryList(Book.class,sql,begin,pageSize);
    }

    /**
     * 查询价格min到max的图书数量
     * @param min
     * @param max
     * @return
     */
    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) selectAll(sql,min,max);
        return count.intValue();
    }

    /**
     * 查询价格在min到max从begin到pageSize的图书信息
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book " +
                "where price between ? and ? order by price limit ?,? ";
        return queryList(Book.class,sql,min,max,begin,pageSize);
    }
}
