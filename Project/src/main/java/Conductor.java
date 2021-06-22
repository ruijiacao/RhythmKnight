import com.almasb.fxgl.dsl.FXGL;

public class Conductor {
    static float beatDuration;
    static float bpm;
    static float offset = .2f;
    static float songPostion;

    void updatePosition() {
        songPostion = (float)(FXGL.getGameTimer().getNow() - offset);
    }
}