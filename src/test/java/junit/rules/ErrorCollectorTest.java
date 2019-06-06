package junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorTest {
    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void addErrorToCollector(){
        collector.addError(new Throwable("first thing went wrong"));
        collector.addError(new Throwable("second thing went wrong"));
    }
}
