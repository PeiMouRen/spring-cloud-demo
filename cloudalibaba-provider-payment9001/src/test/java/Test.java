import com.rhythm.PaymentProviderMain9001;
import com.rhythm.dao.PaymentDao;
import com.rhythm.entities.Payment;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author peixi
 * @Date 2021/12/23 13:57
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentProviderMain9001.class)
public class Test {

    @Autowired
    private PaymentDao paymentDao;

    @org.junit.Test
    public void test() {
//        List<Payment> payments = paymentDao.findAllPayment();
//        for (Payment payment : payments) {
//            System.out.println(payment.toString());
//        }
//        Payment payment = paymentDao.selectById(2l);
//        System.out.println(payment);
        Payment payment = new Payment();
        payment.setSerialno("bbccbb");
        System.out.println(paymentDao.insert(payment));
        System.out.println(payment.getId());

    }



}
