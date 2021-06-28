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

### Test-Driven Development Process
For the Milestone 2 project, we added unit tests to cover several core classes.  
- First, we included several tests to examine the functionality of the Conductor test as it was central to 
our music-themed game. In particular, we tested the constructor method of this class on two audio files to ensure its the functionality. 
- Next, we added tests for the Tile class.  The Tile class is a central user interface element of our game since it graphically represents the position on which 
the player resides.  Our unit tests examined the constructor, setOpacity(), setScale(), getOpacity(), isActive(), reset() methods in the Tile class. For each test, we created a mock 
Tile object with some initialized fields.  We then examined the functionality of the methods by changing the values of each field. 
- Finally, we included two tests covering the GlobalSettings class.  These two two tests check all default settings of the game such as resolution, sound, and windwow width. 
