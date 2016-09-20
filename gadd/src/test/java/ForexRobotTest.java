import ForexMarket.*;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

/**
 * Example of EasyMock usage
 */
@RunWith(EasyMockRunner.class)
public class ForexRobotTest {

    Dollar dollarsSum = new Dollar(25);
    Euro euroSum = new Euro(20);

    @Mock
    private Forex forexEngineMock;

    @Mock
    private Strategy strategy;

    @TestSubject
    Robot robot = new Robot(1000, forexEngineMock, strategy);

    @Test
    public void robotBuyEuroTest() {
        try {
            expect(forexEngineMock.buyEuro(dollarsSum)).andReturn(euroSum);
        } catch (UnableBuyCurrencyException ex) {
            ex.printStackTrace();
        }
        replay(forexEngineMock);

        robot.buyEuro(dollarsSum);
        assertEquals((int) robot.getDollarAmount(), 975);
        assertEquals((int) robot.getEuroAmount(), 20);
        verify(forexEngineMock);


    }

}
