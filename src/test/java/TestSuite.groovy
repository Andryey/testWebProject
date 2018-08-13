import org.junit.runner.RunWith
import org.junit.runners.Suite
import spock.lang.Stepwise

@Stepwise()
@RunWith(Suite.class)
@Suite.SuiteClasses([
        JavaGoogleSearchTest.class

])
class TestSuite {
}