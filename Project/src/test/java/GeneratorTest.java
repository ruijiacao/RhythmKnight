import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import settings.GlobalSettings;
import tilesystem.Generator;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    // This method tests if the Generator class works as intended.
    @Test
    public void genRoomIDTest() {
        int test = Generator.genRoomID();
        Assertions.assertEquals(test <= 15, true);
        Assertions.assertEquals(test >= 0, true);
    }
}