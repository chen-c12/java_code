package t_userSQL.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ����
 * @title: Cart
 * @projectName WebTmp
 * @description: ���ﳵ����
 * @date 2021/11/1017:30
 */
public class Cart {
    /**
     * key����Ʒ���
     * value����Ʒ��Ϣ
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    /**
     * �����Ʒ��
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        //�Ȳ鿴���ﳵ�Ƿ���ӹ�����Ʒ���������ӣ��������ۼƣ��ܽ����£����û����ӹ���ֱ�����
        CartItem item = items.get(cartItem.getId());
        if (item == null){
            items.put(cartItem.getId(), cartItem);
        }else {
            //�Ѿ���ӹ������
            //�����ۼ�
            item.setCount(item.getCount() + 1);
            //�����ܽ��
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * ɾ����Ʒ��
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * ��չ��ﳵ
     */
    public void clear(){
        items.clear();
    }


    public void updateCount(Integer id,Integer count){
        //�Ȳ鿴�������Ƿ��д���Ʒ������У��޸���Ʒ�����������ܽ��
        CartItem cartItem = items.get(id);
        if (cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));


        }

    }



    /**
     * ��Ʒ����
     */
    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer,CartItem> entry :items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem> entry :items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
