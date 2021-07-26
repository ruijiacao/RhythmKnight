import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import players.Player;

class PlayerTest extends ApplicationTest {
    private Player cut;

    @BeforeEach


    @Test
    void getGold() {
        cut = new Player();
        assertEquals(cut.getGold(), 0);
    }

    @Test
    void setGold() {
    }

    @Test
    void pickedUpGold() {
    }

    @Test
    void getMonstersSlain() {
    }

    @Test
    void monsterSlain() {
    }

    @Test
    void setMonstersSlain() {
    }

    @Test
    void getHealth() {
    }

    @Test
    void setHealth() {
    }

    @Test
    void updateHealth() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getWeapon() {
    }

    @Test
    void setWeapon() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void setPosition() {
    }

    @Test
    void resetStats() {
    }

    @Test
    void getScore() {
    }

    @Test
    void updateScore() {
    }
}