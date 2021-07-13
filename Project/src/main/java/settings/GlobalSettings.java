package settings;

import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import tilesystem.MapDirectory;
import tilesystem.Tile;
import ui.AppMainMenu;
import ui.IGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GlobalSettings {
    private static int windowWidth = 1920;
    private static int windowHeight = 1080;
    private static String gameTitle = "Rhythm Knight";
    private static String version = "Milestone 3";
    private static List<String> credits = Arrays.asList(
            "Kyle Fry - Game Design/Programming",
            "Albin Liang - Programming/Debugging",
            "Jinuk Yun - Production Modeling",
            "Ruijia Cao - Model/Design Implementation",
            "Micah Lingle - Character/Level Design"
    );
    private static Texture playerSprite;
    private static int currPlayerTile;

    //Room Counter
    private static int roomCounter = 0;
    private static int pathChosen;

    // pre-generated paths
    private static int[] path1;
    private static int[] path2;
    private static int[] path3;
    private static int[] path4;

    // room lists
    private static ArrayList<Tile>[] rooms1;
    private static ArrayList<Tile>[] rooms2;
    private static ArrayList<Tile>[] rooms3;
    private static ArrayList<Tile>[] rooms4;

    // paths list
    private static ArrayList<Integer> pathList;

    // current map
    private static ArrayList<Tile> currentMap;

    // Game config
    private static String playerName;
    private static int difficulty = -1;            // enum?
    private static int startingWeapon = -1;

    public static boolean canStart() {
        boolean canStart = true;
        if (GlobalSettings.playerName == null || GlobalSettings.playerName.isBlank()
                && GlobalSettings.difficulty == -1
                && GlobalSettings.startingWeapon == -1) {
            IGenerator.createAlert("", "Please use the configuration menu to set your preferences "
                    + "before starting the game!");
            canStart = false;
        } else {
            if (GlobalSettings.playerName == null || GlobalSettings.playerName.isBlank()) {
                IGenerator.createAlert("", "A name was not selected, please try again");
                canStart = false;
            }
            if (GlobalSettings.difficulty == -1) {
                IGenerator.createAlert("", "A difficulty was not selected, please try again");
                canStart = false;
            }
            if (GlobalSettings.startingWeapon == -1) {
                IGenerator.createAlert("", "A starting weapon was not selected, please try again");
                canStart = false;
            }
        }
        return canStart;
    }
  
    public static int getWindowWidth() {
        return windowWidth;
    }

    public static int getWindowHeight() {
        return windowHeight;
    }

    public static String getGameTitle() {
        return gameTitle;
    }

    public static String getVersion() {
        return version;
    }

    public static List<String> getCredits() {
        return credits;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        GlobalSettings.playerName = playerName;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static void setRoomCounter(int roomCounter) {
        GlobalSettings.roomCounter = roomCounter;
    }

    public static void setDifficulty(int difficulty) {
        GlobalSettings.difficulty = difficulty;
    }

    public static int getStartingWeapon() {
        return startingWeapon;
    }

    public static void setStartingWeapon(int startingWeapon) {
        GlobalSettings.startingWeapon = startingWeapon;
    }

    public static void setPlayerSprite(Texture playerSprite) {
        GlobalSettings.playerSprite = playerSprite;
    }

    public static void setPlayerPos(Point2D playerPos) {
        playerSprite.setX(playerPos.getX());
        playerSprite.setY(playerPos.getY());
    }

    public static Texture getPlayerSprite() {
        return playerSprite;
    }
    public static int getRoomCounter() {
        return roomCounter;
    }

    public static void setDefault(GameSettings game) {
        game.setWidth(GlobalSettings.getWindowWidth());
        game.setHeight(GlobalSettings.getWindowHeight());
        game.setTitle(GlobalSettings.getGameTitle());
        game.setVersion(GlobalSettings.getVersion());
        game.setMainMenuEnabled(true);
        game.setSceneFactory(new SceneFactory() {
            @NotNull
            @Override
            public FXGLMenu newMainMenu() {
                return new AppMainMenu(MenuType.MAIN_MENU);
            }
        });
    }

    public static void generatePath(int difficulty) {
        // EXIT PATH 1
        ArrayList<Integer> used = new ArrayList<>();
        Random rand = new Random();
        path1 = new int[7 + difficulty];
        int i = 0;
        int id = 1 + rand.nextInt(20);
        while (i < path1.length) {
            if (!used.contains(id)) {
                used.add(id);
                path1[i] = id;
                i++;
            } else {
                id = 1 + rand.nextInt(20);
            }
        }

        rooms1 = new ArrayList[path1.length + 1];
        MapDirectory maps = new MapDirectory();
        rooms1[0] = maps.getStartMap();
        i = 1;
        while (i < rooms1.length) {
            rooms1[i] = maps.getIDLayout(path1[i - 1]);
            i++;
        }

        // EXIT PATH 2
        used = new ArrayList<>();
        rand = new Random();
        path2 = new int[7 + difficulty];
        i = 0;
        id = 1 + rand.nextInt(20);
        while (i < path2.length) {
            if (!used.contains(id)) {
                used.add(id);
                path2[i] = id;
                i++;
            } else {
                id = 1 + rand.nextInt(20);
            }
        }

        rooms2 = new ArrayList[path2.length + 1];
        maps = new MapDirectory();
        rooms2[0] = maps.getStartMap();
        i = 1;
        while (i < rooms2.length) {
            rooms2[i] = maps.getIDLayout(path2[i - 1]);
            i++;
        }

        // EXIT PATH 3
        used = new ArrayList<>();
        rand = new Random();
        path3 = new int[7 + difficulty];
        i = 0;
        id = 1 + rand.nextInt(20);
        while (i < path3.length) {
            if (!used.contains(id)) {
                used.add(id);
                path3[i] = id;
                i++;
            } else {
                id = 1 + rand.nextInt(20);
            }
        }

        rooms3 = new ArrayList[path3.length + 1];
        maps = new MapDirectory();
        rooms3[0] = maps.getStartMap();
        i = 1;
        while (i < rooms3.length) {
            rooms3[i] = maps.getIDLayout(path3[i - 1]);
            i++;
        }

        // EXIT PATH 4
        used = new ArrayList<>();
        rand = new Random();
        path4 = new int[7 + difficulty];
        i = 0;
        id = 1 + rand.nextInt(20);
        while (i < path4.length) {
            if (!used.contains(id)) {
                used.add(id);
                path4[i] = id;
                i++;
            } else {
                id = 1 + rand.nextInt(20);
            }
        }

        rooms4 = new ArrayList[path4.length + 1];
        maps = new MapDirectory();
        rooms4[0] = maps.getStartMap();
        i = 1;
        while (i < rooms4.length) {
            rooms4[i] = maps.getIDLayout(path4[i - 1]);
            i++;
        }
    }

    public static int[] getPath(int pathID) {
        ArrayList<int[]> paths = new ArrayList<>();
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        paths.add(path4);
        return paths.get(pathID - 1);
    }

    public static void setPathChosen(int pathChosen) {
        GlobalSettings.pathChosen = pathChosen;
    }

    public static int getPathChosen() {
        return pathChosen;
    }

    public static void setPathList(ArrayList<Integer> pathList) {
        GlobalSettings.pathList = pathList;
    }

    public static ArrayList<Integer> getPathList() {
        return pathList;
    }

    public static void setCurrentMap(ArrayList<Tile> currentMap) {
        GlobalSettings.currentMap = currentMap;
    }

    public static ArrayList<Tile> getCurrentMap() {
        return currentMap;
    }

    public static void setCurrPlayerTile(int currPlayerTile) {
        GlobalSettings.currPlayerTile = currPlayerTile;
    }

    public static int getCurrPlayerTile() {
        return currPlayerTile;
    }
}