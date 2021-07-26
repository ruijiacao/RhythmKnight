package settings;

import players.Player;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import monsters.Monster;
import org.jetbrains.annotations.NotNull;
import tilesystem.MapDirectory;
import tilesystem.TileMap;
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

    private static Player player;

    //Room Counter
    private static int roomCounter = 0;
    private static int pathChosen;

    // pre-generated paths
    private static int[] path1;
    private static int[] path2;
    private static int[] path3;
    private static int[] path4;

    // room lists
    private static ArrayList<TileMap> rooms1;
    private static ArrayList<TileMap> rooms2;
    private static ArrayList<TileMap> rooms3;
    private static ArrayList<TileMap> rooms4;

    // paths list
    private static ArrayList<Integer> pathList;

    // current map
    private static TileMap currentMap;
    private static MapDirectory mapDirectory;


    // Game config
    private static int difficulty = -1;            // enum?
    private static int startingWeapon = -1;
    private static int playerHealth;
    private static int maxHealth;
    private static int monstersKilled;
    // monsters
    private static ArrayList<Monster> activeMonsters = new ArrayList<>();

    public static boolean canStart() {
        boolean canStart = true;
        if (player.getName() == null || player.getName().isBlank()
                && GlobalSettings.difficulty == -1
                && GlobalSettings.startingWeapon == -1) {
            IGenerator.createAlert("", "Please use the configuration menu to set your preferences "
                    + "before starting the game!");
            canStart = false;

            // comment out the previous 3 lines and uncomment the next 3 lines for quick testing

        } else {
            if (player.getName() == null || player.getName().isBlank()) {
                IGenerator.createAlert("", "A name was not selected, please try again");
                canStart = false;
            }
            if (GlobalSettings.difficulty == -1) {
                IGenerator.createAlert("", "A difficulty was not selected, please try again");
                canStart = false;
            }
            if (player.getWeapon() == -1) {
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
        return player.getName();
    }

    public static void setPlayerName(String playerName) {
        player.setName(playerName);
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
        return player.getWeapon();
    }

    public static void setStartingWeapon(int startingWeapon) {
        player.setWeapon(startingWeapon);
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
        player = new Player();
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

        rooms1 = new ArrayList();
        rooms1.add(mapDirectory.getStartMap());
        i = 1;
        while (i < path1.length) {
            rooms1.add(mapDirectory.getIDLayout(path1[i - 1]));
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

        rooms2 = new ArrayList();
        rooms2.add(mapDirectory.getStartMap());
        i = 1;
        while (i < path2.length) {
            rooms2.add(mapDirectory.getIDLayout(path2[i - 1]));
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

        rooms3 = new ArrayList();
        rooms3.add(mapDirectory.getStartMap());
        i = 1;
        while (i < path3.length) {
            rooms3.add(mapDirectory.getIDLayout(path3[i - 1]));
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

        rooms4 = new ArrayList();
        rooms4.add(mapDirectory.getStartMap());
        i = 1;
        while (i < path4.length) {
            rooms4.add(mapDirectory.getIDLayout(path4[i - 1]));
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

    public static void setCurrentMap(TileMap currentMap) {
        GlobalSettings.currentMap = currentMap;
    }

    public static TileMap getCurrentMap() {
        return currentMap;
    }

    public static void setCurrPlayerTile(int currPlayerTile) {
        GlobalSettings.currPlayerTile = currPlayerTile;
    }

    public static int getCurrPlayerTile() {
        return currPlayerTile;
    }

    public static void addActiveMonster(Monster monster) {
        activeMonsters.add(monster);
    }

    public static ArrayList<Monster> getActiveMonsters() {
        return activeMonsters;
    }

    public static void clearActiveMonsters() {
        activeMonsters.clear();
    }

    public static int getPlayerHealth() {
        return player.getHealth();
    }

    public static void setPlayerHealth(int playerHealth) {
        player.updateHealth(playerHealth);
    }

    public static Player getPlayer() {
        return player;
    }

    public static MapDirectory getMapDirectory() {
        return mapDirectory;
    }

    public static void setMapDirectory(MapDirectory mapDirectory) {
        GlobalSettings.mapDirectory = mapDirectory;
    }

    public static void setMonstersKilled(int monstersKilled) {
        GlobalSettings.monstersKilled = monstersKilled;
    }

    public static int getMonstersKilled() {
        return monstersKilled;
    }
}