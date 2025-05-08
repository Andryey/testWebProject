import geb.Page

class HomePage extends Page{
    static url = "https://sk.wikipedia.org/wiki"

    static at = {
        waitFor {logoImage.getAttribute("src").contains("/static/images/icons/wikipedia.png")}
    }

    static content = {
        logoImage {$(Locators.logoImage)}
    }

}
