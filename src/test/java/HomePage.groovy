import geb.Page

class HomePage extends Page{
    static url = "http://www.google.com"
    static nextPageLink = "#pnnext"
    static pageResultsList = "div.g > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)"
    static googleSearchTextfield = "#lst-ib"

}
