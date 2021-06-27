import static org.junit.jupiter.api.Assertions.*;

import com.almasb.fxgl.app.GameApplication;
import javafx.application.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rhythm.Conductor;

import java.io.File;

public class ConductorTest {
    @Test
    void testConstructor1() {
        new Thread(() -> GameApplication.launch(GameApp.class, new String[0])).start();
        String OSTPath = "." + File.separator
                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "assets" + File.separator + "sounds" + File.separator + "Diodes.mp3";
        Conductor conductor = new Conductor(20, OSTPath, 21);
        assertNotNull(conductor);
    }

    @Test
    void testConstructor2() {
        new Thread(() -> GameApplication.launch(GameApp.class, new String[0])).start();
        String OSTPath = "." + File.separator
                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "assets" + File.separator + "sounds" + File.separator + "TheRhythmWizard.mp3";
        Conductor conductor = new Conductor(20, OSTPath, 21);
        assertNotNull(conductor);
    }

    @Test
    void startAndKeepRhythm() {

    }

    @Test
    void checkRhythm() {
    }
}