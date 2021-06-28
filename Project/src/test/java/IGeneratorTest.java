import javafx.scene.Node;
import javafx.scene.control.Button;
import org.assertj.core.internal.bytebuddy.agent.builder.AgentBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import settings.GlobalSettings;
import ui.IGenerator;

public class IGeneratorTest {

    @BeforeAll
    public static void setUp() {
        GameApp.main(new String[]{""});     // Just to get FX working
    }

    @Test
    public void generateNode() {
        Button butt = (Button) IGenerator.nodeGen(new Button(), 100, 200, 2);
        Assertions.assertEquals(100, butt.getLayoutX());
        Assertions.assertEquals(200, butt.getLayoutY());
        Assertions.assertEquals(2, butt.getScaleX());
        System.out.println("ran");
    }

}
