package t_userSQL.dao.impl;

import t_userSQL.dao.BookDao;
import t_userSQL.pojo.Book;

import java.util.List;

/**
 * @author ����
 * @title: BookDaoImpl
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/10/3115:41
 */
public class BookDaoImpl extends BaseDAO implements BookDao {

    /**
     * ���ͼ��
     * @param book
     * @return
     */
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,author,price,sales,stock,img_path)values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    /**
     * ����idɾ��ͼ��
     * @param id
     * @return
     */
    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    /**
     * ����ͼ����Ϣ
     * @param book
     * @return
     */
    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    /**
     * ����id��ͼ��
     * @param id
     * @return
     */
    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book where id = ?";
        return queryOne(Book.class,sql,id);
    }

    /**
     * ��ѯȫ��ͼ��
     * @return
     */
    @Override
    public List<Book> queryBook() {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book";
        return queryList(Book.class,sql);
    }

    /**
     * ͳ������ͼ�������
     * @return
     */
    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) selectAll(sql);
        return count.intValue();
    }

    /**
     * ��ѯ��begin��pageSize��ͼ����Ϣ
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
     * ��ѯ�۸�min��max��ͼ������
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
     * ��ѯ�۸���min��max��begin��pageSize��ͼ����Ϣ
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
