package tilesystem;

import javafx.geometry.Point2D;
import rhythm.Conductor;
import rooms.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
===== HOW TO MAP LAYOUT IMAGES TO TILES =====
1) Open up any image editor of your choice (preferably Photoshop)
2) Open up a layout image with all the tiles
3) Select a tile you want to map. Grab the coordinates of the top left corner of the tile
4) Add 30 to the x coordinate and 25 to the y coordinate
5) Instantiate a new tile with the coordinates calculated and the type of tile it is
6) Add the tile to the ArrayList for that level
==============================================
 */
public class MapDirectory {
    private ArrayList<TileMap> tilemaps;

    public MapDirectory() {

        // origin, unused, gold, monster, exits, mystery, lockedExits
        try {
            Scanner read = new Scanner(new File("Project" + File.separator + "src" + File.separator + "main" + File.separator
                    + "resources" + File.separator + "assets" + File.separator + "map" + File.separator
                    + "rooms.txt"));
            /*Scanner read = new Scanner(new File("." + File.separator + "src" + File.separator + "main" + File.separator
                    + "resources" + File.separator + "assets" + File.separator + "map" + File.separator
                    + "rooms.txt"));*/

            tilemaps = new ArrayList<>();
            int addedRooms = 0;

            while (read.hasNextLine()) {
                String line = read.nextLine();
                // Remove whitespace
                line = line.replaceAll("\\s","");
                String[] lineComponents = line.split(String.valueOf((char) 47)); // /
                int[] origin = null;
                int[] unused = null;
                int[] gold = null;
                int[] monster = null;
                int[] exits = null;
                int[] mystery = null;
                int[] lockedExits = null;

                for (int i = 0; i < lineComponents.length; i++) {
                    if (!lineComponents[i].isBlank()) {
                        String[] csv = lineComponents[i].split(",");
                        int[] values = new int[csv.length];
                        for (int j = 0; j < csv.length; j++) {
                            values[j] = Integer.parseInt(csv[j]);
                        }
                        switch (i) {
                            case 0:
                                origin = values;
                                break;
                            case 1:
                                unused = values;
                                break;
                            case 2:
                                gold = values;
                                break;
                            case 3:
                                monster = values;
                                break;
                            case 4:
                                exits = values;
                                break;
                            case 5:
                                mystery = values;
                                break;
                            case 6:
                                lockedExits = values;
                                break;
                        }
                    }
                }
                int[][] allData = new int[][]{origin, unused, gold, monster, exits, mystery, lockedExits};
                Room room = new Room(allData);
                tilemaps.add(addedRooms, new TileMap(addedRooms, room.buildTiles()));
                addedRooms++;
            }

            // Link exits to randomized path mechanism
            tilemaps.get(0).getTiles().get(11).setPathID(1);
            tilemaps.get(0).getTiles().get(21).setPathID(2);
            tilemaps.get(0).getTiles().get(16).setPathID(3);
            tilemaps.get(0).getTiles().get(2).setPathID(4);

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public TileMap getStartMap() {
        return tilemaps.get(0);
    }

    public TileMap getIDLayout(int id) {
        return tilemaps.get(id);
    }


    public Point2D getMapOrigin(int id) {
        return tilemaps.get(id).getTiles().get(0).getPosition();
    }

    public int getMapOriginTileID(int id) {
        return tilemaps.get(id).getTiles().get(0).getTileID();
    }
}
