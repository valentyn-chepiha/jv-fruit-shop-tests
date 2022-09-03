package core.basesyntax.service.strategy;

import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.dao.ActivityDaoDbImpl;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.handlers.ActivityHandler;
import core.basesyntax.service.strategy.maps.TypeActivityToOperation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TypeActivityStrategyImplTest {
    private static TypeActivityStrategy typeActivityStrategy;
    private static TypeActivityToOperation typeActivityToOperation;
    private static ActivityDaoDb activityDaoDb;

    @BeforeClass
    public static void setUp() {
        activityDaoDb = new ActivityDaoDbImpl();
        typeActivityToOperation = new TypeActivityToOperation(activityDaoDb);
        typeActivityStrategy = new TypeActivityStrategyImpl(typeActivityToOperation);
    }

    @Test
    public void test_balance_ok() {
        String expected = "core.basesyntax.service.strategy.handlers.BalanceActivityHandlerImpl";
        ActivityHandler actualHandler
                = typeActivityStrategy.getHandlerByTypeActivity(TypeActivity.BALANCE);
        Assert.assertEquals("Must be BalanceActivityHandler",
                expected, actualHandler.getClass().getName());
    }

    @Test
    public void test_return_ok() {
        String expected = "core.basesyntax.service.strategy.handlers.ReturnActivityHandlerImpl";
        ActivityHandler actualHandler
                = typeActivityStrategy.getHandlerByTypeActivity(TypeActivity.RETURN);
        Assert.assertEquals("Must be ReturnActivityHandler",
                expected, actualHandler.getClass().getName());
    }
}
