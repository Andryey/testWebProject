import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys
import org.sikuli.script.Key
import org.sikuli.script.Pattern
import org.sikuli.script.Screen

class WikiSearchTest extends GebReportingSpec {
    def currentPageUrl


    def "check the main page"() {
        given: "visit Wikipedia page"
        to HomePage

        when: "input 'Java' to the textField and check results "
        at HomePage
        waitFor { $(Locators.searchForm).click() }
        AssistanceSikuli.sikuliImgHighlightClick("searchTextField")

        waitFor { $(Locators.resultBox).isDisplayed() }
        currentPageUrl = getCurrentUrl()
        browser.report("testReport")

        then: "result of search contains 'Java' "
        assert $(Locators.resultBox).text().contains(Variables.expectedResult)

        and: "The url contains Java"
        assert currentPageUrl.contains("Javftghdfghda")
    }
}
