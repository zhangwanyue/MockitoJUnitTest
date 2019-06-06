package junit.runners;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestWithParam {
    private String expected;
    private String target;

    /**
     * 参数化测试必须的构造函数
     * @param expected      期望的测试结果，对应参数集中的第一个参数
     * @param target        测试数据，对应参数集中的第二个参数
     */
    public TestWithParam(String expected, String target) {
        this.expected = expected;
        this.target = target;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> messageToPrint(){
        return Arrays.asList(new Object[][]{
                {null, null},                   //测试null时的情况
                {"",""},                        //测试空字符串
                {"hello", "hello"},             //测试只有一个单词
                {"hello world", "hello world"}  //测试多个单词
        });
    }

    @Test
    public void test(){
        System.out.println("Inside TestWithParam");
        assertEquals(expected, (new MessageUtil(target)).getMessage());
    }

}

class MessageUtil {
    String message;

    public MessageUtil(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}