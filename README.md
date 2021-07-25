# 2340G21-RhythmKnight
A dungeon crawler with rhythm game elements!

### Branch Design:
- master: The default and main branch where reviewed code and changes can be stored
- experimental: The branch where features from the UI and game branches are merged to before going to master and test their cohesion
- UI: The branch dedicated to UI-related features and changes
- game: The branch dedicated to game level and logic features and changes

### Current progress:
- Menu system developed
- Working rhythm system created
- Score system created

### To be done for M2:
- Create Domain and Use Case Models
- Work on game config screen in the menu (system settings, character selector)
- Create TestFX tests for the first level and main menu

### Test-Driven Development Process for Milestone 2
For the Milestone 2 project, we added unit tests to cover several core classes.  
- First, we included several tests to examine the functionality of the Conductor test as it was central to 
our music-themed game. In particular, we tested the constructor method of this class on two audio files to ensure its the functionality. 
- Next, we added tests for the Tile class.  The Tile class is a central user interface element of our game since it graphically represents the position on which 
the player resides.  Our unit tests examined the constructor, setOpacity(), setScale(), getOpacity(), isActive(), reset() methods in the Tile class. For each test, we created a mock 
Tile object with some initialized fields.  We then examined the functionality of the methods by changing the values of each field. 
- Finally, we included two tests covering the GlobalSettings class.  These two two tests check all default settings of the game such as resolution, sound, and windwow width. 

### Test-Driven Development Process for Milestone 3
For the Milestone 3 project, we added unit tests to cover software classes that control the movement of the player.
- First, we included several tests to examine the functionality of the MapDirectory class since this class manages various dungeon rooms used in our game. In particular, we tested 
the functionality of some of rooms used in the game.  For each room, the corresponding unit test examined that it returned the desired properties, such as Tile types.
- Next, we added tests to examine the functionality of the Generator class, which served to generate a random sequence of rooms that the player would explore during the game.
The unit test examined the getRoomID() method by ensuring the return value of the method stayed within the total range of the rooms.
- Finally, we included a test covering the Initializer class, which served to initialize all the properties of the game. In particular, we tested the setGold() method by changing the value
of the field.

### Test-Driven Development Process for Milestone 4
For the Milestone 4 project, we added unit tests to cover sofeware classes that represent several entities of the game.
- First, we included several tests to examine the functionality of the subclasses of the Monster class since they represent monsters in the
game. For each type of monster (Slime, Zombie, Wizard), the corresponing unit tests examined that its methods, such as doDamage(), yielded
the desired effect.  For example, the doDomage() method should decrease the health of the monster.
- Next, we included unit tests covering the some of the layout components of the game since the they were central to the functionality of 
the game.  For example, we added a few unit tests to enture that the elements of the MapDirectory() class correctly corresponded to 
our design.
