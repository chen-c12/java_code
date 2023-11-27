package t_userSQL.pojo;

import java.util.List;

/**
 * @author ����
 * @title: Page
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/316:56
 */

/**
 * Page�Ƿ�ҳģ�Ͷ���
 * @param <T>�Ǿ����ģ���javaBean��
 */
public class Page<T> {
    public static final Integer PAGE_SIZE = 4;
    //��ǰҳ��
    private Integer pageNumber;
    //��ҳ��
    private Integer pageTotal;
    //��ǰҳ��ʾ����
    private Integer pageSize = PAGE_SIZE;
    //�ܼ�¼��
    private Integer pageTotalCount;
    //��ǰҳ����
    private List<T> items;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNumber=" + pageNumber +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
