import com.aoe.gebspockreports.GebReportingListener
import org.openqa.selenium.chrome.ChromeOptions
import io.github.bonigarcia.wdm.WebDriverManager

//for Ubuntu
// reportsDir = new File("build/geb_reports")
reportingListener = new GebReportingListener()
reportsDir = 'build/geb-spock-reports'
driver = {

    Map<String, Object> prefs = new HashMap<>()

    prefs.put("profile.default_content_setting_values.notifications", 2)
    prefs.put("profile.default_content_settings.popups", 0)
    prefs.put("download.prompt_for_download", Boolean.valueOf(false))
    prefs.put("download.directory_upgrade", Boolean.valueOf(true))
    prefs.put("safebrowsing.enabled", Boolean.valueOf(true))
    prefs.put('safebrowsing.disable_download_protection', Boolean.valueOf(true))
    prefs.put('CapabilityType.ACCEPT_SSL_CERTS', true)
    prefs.put("credentials_enable_service", false)
    prefs.put("profile.password_manager_enabled", false)
    ChromeOptions options = new ChromeOptions()
    options.addArguments("--ignore-certificate-errors")
    options.addArguments("--disable-popup-blocking")
    options.addArguments("--ignore-ssl-errors")
    options.addArguments("--remote-allow-origins=*")
    //options.addArguments("--incognito")
    options.addArguments("--disable-blink-features=AutomationControlled")
    options.setExperimentalOption('useAutomationExtension', false)
    options.setExperimentalOption("excludeSwitches", ["enable-automation"])
    //please comment for Linux headless mode:
    options.addArguments("disable-infobars")
    options.addArguments("--no-sandbox")
    options.addArguments("--disable-popup-blocking")
    options.addArguments("--disable-search-engine-choice-screen")
    // options.addArguments("--disable-dev-shm-usage")//from Chromedriver 80
    options.setExperimentalOption("prefs", prefs)
    options.setCapability('goog:loggingPrefs', logPrefs)
//        options.addArguments("--headless")
//        options.addArguments("--disable-gpu")
//        options.addArguments("--window-size=1920,980")
    System.setProperty("webdriver.chrome.silentOutput", "true")

    def driverInstance = WebDriverManager
            .chromedriver()
            .capabilities(options)
            .create()
    println "driverInstance: " + driverInstance.toString()
    driverInstance.manage().window().maximize()
    driverInstance.manage().deleteAllCookies()
    driverInstance

}

waiting {
    timeout = 5
    retryInterval = 0.5
}

atCheckWaiting = true
reportOnTestFailureOnly = true
autoClearCookies = false