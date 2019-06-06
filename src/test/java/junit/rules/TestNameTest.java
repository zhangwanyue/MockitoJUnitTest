package junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestNameTest {
    @Rule
    public final TestName testName = new TestName();

    @Test
    public void testA(){
        System.out.println("testA: " + testName.getMethodName());
    }

    @Test
    public void testB(){
        System.out.println("testB: " + testName.getMethodName());
    }
}
