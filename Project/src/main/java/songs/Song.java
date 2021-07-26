package songs;

public abstract class Song {
    private String path;
    private int bpm;

    public abstract String getPath();
    public abstract int getBpm();
}
