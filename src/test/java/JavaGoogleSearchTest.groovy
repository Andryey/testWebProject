import geb.spock.GebSpec
import org.openqa.selenium.Keys

class JavaGoogleSearchTest extends GebSpec {
    def results = ""
    def currentPageUrl
    def at = {
        for (int j = 0; j < $(HomePage.pageResultsList).size(); j++) {
            results = results + $(HomePage.pageResultsList, j).text()
        }
    }

    def "check Computer programming language"() {
        given: "visit Google page"
        go(HomePage.url)

        when: "input 'Java' to the textfield and check results "

        waitFor { $(HomePage.googleSearchTextfield).value(Variables.testValue) }
        $(HomePage.googleSearchTextfield) << Keys.chord(Keys.ENTER)
        waitFor { $(HomePage.pageResultsList, 0) }
        currentPageUrl = getCurrentUrl()
        at JavaGoogleSearchTest
        while ($(HomePage.nextPageLink)) {
            $(HomePage.nextPageLink).click()
            waitFor { $(HomePage.pageResultsList, 0) }
            at JavaGoogleSearchTest
        }
        println results


        then: "results of search contain 'Computer programming language' "
        assert currentPageUrl.contains("google.")
        assert currentPageUrl.contains("q=Java")
        assert results.contains(Variables.expectedResult)
    }
}
