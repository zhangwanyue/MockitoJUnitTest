package junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// the ExpectedException Rule allows in-test specification of expected exception types and messages
public class ExpectedExceptionTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsNullPointerException(){
        expectedException.expect(NullPointerException.class);
        throw new NullPointerException();
    }

    @Test
    public void throwsNullPointerExceptionWithMessage(){
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("What happened?");
        throw new NullPointerException("What happened?");
    }
}
