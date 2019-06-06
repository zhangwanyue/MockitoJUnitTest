package junit.rules;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestWatcherTest {
    @Rule
    public final TestWatcher testWatcher = new TestWatcher() {

        @Override
        protected void succeeded(Description description) {
            System.out.println(description.getDisplayName() + "Succeed");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(description.getDisplayName() + "Failed");
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.println(description.getDisplayName() + "Skipped");
        }

        @Override
        protected void starting(Description description) {
            System.out.println(description.getDisplayName() + "Starting");
        }

        @Override
        protected void finished(Description description) {
            System.out.println(description.getDisplayName() + "Finished");
        }
    };

    @Test
    public void testWatcherTest(){
        System.out.println("testWatcherTest");
//        throw new RuntimeException();
    }
}
