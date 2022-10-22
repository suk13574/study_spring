package springStudy.core.order;

public interface OrderService {

    //주문 만들기
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
