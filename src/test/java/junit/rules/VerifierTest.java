package junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

public class VerifierTest {
    String result;

    @Rule
    public final Verifier verifier = new Verifier() {
        // 每个测试之行为完之后都会调用
        @Override
        protected void verify() throws Throwable {
            if(!"Success".equals(result)){
                throw new Exception("Test fail");
            }
        }
    };

    @Test
    public void testVerifierFail(){
        result = "Fail";
    }

    @Test
    public void testVerifierSuccess(){
        result = "Success";
    }
}
