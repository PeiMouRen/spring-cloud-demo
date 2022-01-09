import com.rhythm.SeataOrderMain2001;
import com.rhythm.dao.OrderDao;
import com.rhythm.entity.Order;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author peixi
 * @Date 2022/1/9
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SeataOrderMain2001.class)
public class Test {

    @Resource
    private OrderDao orderDao;

    @org.junit.Test
    public void order() {
        Order order = new Order();
        order.setUserId(1l);
        order.setProductId(1l);
        order.setCount(2);
        order.setMoney(new BigDecimal("20"));
        order.setStatus(0);
        System.out.println("-------------------------------------");
        System.out.println(orderDao.updateOrderStatus(1l));
        //System.out.println(order.toString());
        System.out.println("-------------------------------------");
    }
}
