package junit.runners;

import mockito.AnnotationTest;
import mockito.MockObjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AnnotationTest.class, MockObjectTest.class})
public class SuiteTest {
}
