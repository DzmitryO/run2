package fiori.example.scenario.run2.Test;

import fiori.example.scenario.run2.base.TestBase;
import org.junit.Test;

public class OrdersListTest extends TestBase {

    @Test
    public void processOrders()  {
        //start();
        //запуск методов из класса FioriAppOrderPage
        app.fioriOrderListExecute();

        app.fioriOrderDetailExecute();


    }

}
