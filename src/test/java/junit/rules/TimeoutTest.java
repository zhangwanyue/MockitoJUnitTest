package junit.rules;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

// the timeout rule applies the same timeout to all test methods in a class
public class TimeoutTest {
    public static String log = "";

    @Rule
    public final TestRule globalTimeout = Timeout.millis(20);

    @Test
    public void testInfiniteLoop1(){
        log += "ran1";
        for(;;){}
    }

    @Test
    public void testInfiniteLoop2(){
        log += "ran2";
        for(;;){}

    }

    @AfterClass
    public static void afterLoop(){
        System.out.println(log);
    }

}
