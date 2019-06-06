package mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {
    @Mock private List<String> mockList;

    @Test
    public void test(){
//        System.out.println("annotationTest");
        mockList.add("one");
        verify(mockList).add("one");
        System.out.println("annotationTest");
    }
}
