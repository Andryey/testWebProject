import org.openqa.selenium.chrome.ChromeDriver

waiting {
        timeout = 10
        retryInterval = 0.5
    }
    reportsDir = "target/geb-reports"
driver = {
    def pathToBin = 'src/test/java/drivers/chromedriver.exe'
    System.setProperty("webdriver.chrome.driver",pathToBin)
    def driverInstance = new ChromeDriver();
    driverInstance.manage().window().maximize()
    driverInstance
}