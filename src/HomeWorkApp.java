import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

//    Player's definition

    public static int playerMaxHP = 100;
    public static int playerStr = 50;
    public static int playerScore = 0;
    public static int playerHP = playerMaxHP;
    public static int playerCoins = 0;
    public static int playerX;
    public static int playerY;

    // Map definition
    public static char[][] map;
    public static int mapWidth;
    public static int mapHeight;
    public static int mapMinSize = 4;
    public static int mapMaxSize = 6;
    public static char emptyCell = '_';
    public static char player = '&';

    //Movement directions
    public static final int playerMoveUp = 8;
    public static final int playerMoveDown = 2;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;

    public static final char coin = '$';
    public static int coinsCount;

    public static final char enemy = 'E';
    public static int enemyHP;
    public static int enemyStr;
    public static int enemyValueMin = 20;
    public static int enemyValueMax = 25;

    public static int enemiesCount;
    public static int gameLevel = 0;




    public static void main(String[] args) {

        while (isPlayerAlive()) {
            ++gameLevel;
            System.out.println("START GAME LEVEL " + gameLevel);
            levelCycle();
        }
        System.out.println("GAME OVER! Player Score " + playerScore);

    }
    public static void levelCycle() {
        createMap();
        createPlayer();
        spawnEnemies();
        spawnCoins();

        while (true) {
            printMap();
            playerMoveAction();

            if (!isPlayerAlive()) {
                System.out.println("Player dead. Game over");
                break;
            }

            if (!isEnemyExist() && coinsCount < 1) {
                System.out.println("========================================");
                System.out.println("Player Win. Enemies defeated: " + playerScore + ". Coins founded: " + playerCoins + ". Level finished");
                break;
            }
        }
        printMap();
    }


    public static void createMap() {
        mapWidth = randomValue(mapMinSize, mapMaxSize);
        mapHeight = randomValue(mapMinSize, mapMaxSize);
        map = new char[mapHeight][mapWidth];
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = emptyCell;
            }
        }
        System.out.println("Created map, size: " +mapWidth + "x" + mapHeight);
    }


    public static void printMap() {
        System.out.println("===== MAP =====");
        System.out.print("  ");
        for (int i = 0; i < mapWidth; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int y = 0; y < mapHeight; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < mapWidth; x++) {

                if (map[y][x] != player) {
                    System.out.print(emptyCell + "|");
                } else {
                    System.out.print(map[y][x] + "|");
                }
            }
            System.out.println();
        }
        System.out.println("===============");
        System.out.println("Score: " + playerScore + "    Coins: " + playerCoins);
        System.out.println("===============");
    }
    public static void createPlayer() {
        playerHP = playerMaxHP;
        playerX = randomValue(0, mapWidth - 1);
        playerY = randomValue(0, mapHeight - 1);
        map[playerY][playerX] = player;
        System.out.println("Player has been created in [" + (playerX + 1) + ":" + (playerY + 1) + "]");
        System.out.println("Player HP = " + playerHP);
    }
    public static void spawnEnemies() {
        enemiesCount = (mapWidth + mapHeight) / 3;
        spawnItem(enemiesCount, enemy);
        System.out.println("Enemies has been created. Count is " + enemiesCount);
    }
    public static void spawnCoins() {
        coinsCount = (mapWidth + mapHeight) / 3;
        spawnItem(coinsCount, coin);
        System.out.println("Coins has been created. Count is " + coinsCount);
    }
    public static void spawnItem(int itemsCount, char itemChar) {
        int itemPosX;
        int itemPosY;

        for (int i = 1; i <= itemsCount; i++) {

            do {
                itemPosX = random.nextInt(mapWidth);
                itemPosY = random.nextInt(mapHeight);
            } while (!isEmptyCell(itemPosX, itemPosY));
            map[itemPosY][itemPosX] = itemChar;
        }
    }

    public static void playerMoveAction() {
        int playerLastX = playerX;
        int playerLastY = playerY;

        int playerDestination;

        do {
            System.out.print("Enter your destination: UP(" + playerMoveUp +
                    ") | DOWN(" + playerMoveDown +
                    ") | LEFT(" + playerMoveLeft +
                    ") | RIGHT(" + playerMoveRight + ") > ");
            playerDestination = scanner.nextInt();

            switch (playerDestination) {
                case playerMoveUp:
                    playerY -= 1;
                    break;
                case playerMoveDown:
                    playerY += 1;
                    break;
                case playerMoveLeft:
                    playerX -= 1;
                    break;
                case playerMoveRight:
                    playerX += 1;
                    break;
            }
        } while (!isValidPlayerMoveNextCell(playerX, playerY, playerLastX, playerLastY));

        playerNextCellCheck();
        map[playerLastY][playerLastX] = emptyCell;
        map[playerY][playerX] = player;

    }

    public static void playerNextCellCheck() {

        switch (map[playerY][playerX]) {
            case enemy:
                battle();
                break;
            case coin:
                playerCoins++;
                coinsCount--;
                System.out.println("Player found a coin. He has " + playerCoins + " coins now.");
                break;
        }
    }

    public static boolean isValidPlayerMoveNextCell(int nextCellX, int nextCellY, int lastCellX, int lastCellY) {
        if (isValidCell(nextCellX, nextCellY)) {
            System.out.println("Player move to [" + (nextCellX + 1) + ":" + (nextCellY + 1) + "]");
            return true;
        } else {
            System.out.println("Invalid move");
            playerX = lastCellX;
            playerY = lastCellY;
            return false;
        }
    }
    public static int randomValue (int min, int max) {
        return min + random.nextInt(max - min + 1);
    }
    public static boolean isEmptyCell(int x, int y) {
        return map[y][x] == emptyCell;
    }

    public static boolean isPlayerAlive() {
        return playerHP > 0;
    }

    public static boolean isEnemyAlive() {
        return enemyHP > 0;
    }

    public static boolean isValidCell(int x, int y) {
        return x >= 0 && x < mapWidth && y >= 0 && y < mapHeight;
    }

    public static boolean isEnemyExist() {
        return enemiesCount > 0;
    }
    public static void battle() {
        int playerAttack;
        int enemyAttack;
        enemyHP = randomValue(enemyValueMin, enemyValueMax);
        enemyStr = randomValue(enemyValueMin, enemyValueMax);
        System.out.println("Player found an enemy. The battle begins.....");
        while (isPlayerAlive() && isEnemyAlive()) {
            enemyAttack = randomValue(enemyStr/2,enemyStr);
            playerAttack = randomValue(playerStr/2,playerStr);
            playerHP -= enemyAttack;

            System.out.print("Enemy shoot Player on " + enemyAttack + ". ");
            if (isPlayerAlive()) {
                System.out.println("Player HP now is " + playerHP);
            } else {
                System.out.println("Player defeated.");
                break;
            }
            enemyHP -= playerAttack;
            System.out.print("Player shoot Enemy on " + playerAttack + ". ");
            if (isEnemyAlive()) {
                System.out.println("Enemy HP now is " + enemyHP);
            } else {
                playerScore++;
                enemiesCount--;
                System.out.println("Enemy defeated. Player score is " + playerScore + " now.");
                break;
            }
        }

    }
}

