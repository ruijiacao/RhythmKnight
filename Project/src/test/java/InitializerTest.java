import initializers.Initializer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class InitializerTest {

    private Initializer cuT;

    @BeforeEach
    public void setCuT() {
        cuT = new Initializer();
    }

    @Test
    public void level1Test() {
    }

    @Test
    public void setGoldTest() {
        cuT.setGold(13);
        Assertions.assertEquals(13, cuT.getGold());
    }
}
