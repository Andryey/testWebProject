import org.sikuli.script.Key
import org.sikuli.script.Pattern
import org.sikuli.script.Screen

class AssistanceSikuli {

    static String sikuliFolderPath = "${System.getProperty('user.dir')}/src/test/imagesForSikuli/"

    static void sikuliImgHighlightClick(String imgName) {
        def screen = new Screen()
        def pattern = new Pattern("${sikuliFolderPath}${imgName}.png").similar(0.6f)

        try {
            screen.wait(pattern, 80).highlight(1).click()
            screen.type(Variables.testValue)
            screen.type(Key.ENTER)
        } catch (Exception e) {
            println e
            println "Image not found: ${imgName}"
        }
    }
}
