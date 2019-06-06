package mockito;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;


public class MockObjectTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void classMock(){
        // class mock 改变了 class 的行为，所以 mock 出来的对象就完全失去了原来的行为
        // 对于需要返回值的地方，mock的对象会返回一些默认值（比如null, 0等）
        List<String> mockList = mock(List.class);

        mockList.add("one");
        verify(mockList).add("one"); // 验证mockList调用了add("one")这个方法
        Assert.assertEquals(mockList.size(), 0); // mockList实际并没有执行真正的add方法
        Assert.assertEquals(mockList.get(0), null); // 对于需要返回值的地方，mock的对象会返回一些默认值（比如null, 0等）

        when(mockList.get(0)).thenReturn("first");// stub out some methods
        Assert.assertEquals(mockList.get(0), "first");
    }

    @Test
    public void partialMock(){
        // create a spy of the real object, the spy calls real methods unless they are stubbed.
        List<String> list = new ArrayList<>();
        List mockList = spy(list);

        mockList.add("one");
        verify(mockList).add("one"); // 验证mockList调用了add("one")这个方法
        Assert.assertEquals(mockList.size(), 1); // mockList执行了真正的add方法

        when(mockList.size()).thenReturn(100); // stub out some methods
        Assert.assertEquals(mockList.size(), 100);
    }

    @Test
    public void stubbingConsecutive(){
        List<String> mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("one").thenThrow(new RuntimeException()); // 第一次get(0)获取到"one", 第二次抛异常

        Assert.assertEquals(mockList.get(0), "one"); // 第一次第一次get(0)获取到"one"
        expectedException.expect(RuntimeException.class);
        mockList.get(0); // 第二次抛异常
    }

    // stubbing void methods requires a different approach from when(Object) because the compiler does not like void methods inside brackets
    // use doReturn()|doThrow()|doAnswer()|doNothing()|doCallRealMethod() family of methods
    @Test
    public void doReturnFamily(){
        List<String> mockList = mock(List.class);
//        when(mockList.clear()).thenThrow(new RuntimeException()); // stubbing void methods requires a different approach from when(Object) because the compiler does not like void methods inside brackets
        doThrow(new RuntimeException()).when(mockList).clear();
        expectedException.expect(RuntimeException.class);
        mockList.clear();
    }

    // Mockito verifies argument values in natural java style: by using an equals() method. This is also the recommended way of matching arguments because it makes tests clean & simple. In some situations though, it is helpful to assert on certain arguments after the actual verification.
    @Test
    public void captureArgument(){
        List<String> mockList = mock(List.class);
        mockList.add("one");

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockList).add(argumentCaptor.capture());

        Assert.assertEquals(argumentCaptor.getValue(), "one");
    }

}
