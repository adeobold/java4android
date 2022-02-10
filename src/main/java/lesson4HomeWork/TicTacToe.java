package lesson4HomeWork;

import java.util.*;

public class TicTacToe {

    private static int size;
    private static char[][] gameField;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_COMP = '0';
    private static final String DOT_LOGO = "🥇";
    private static String DOT_FORMAT = "";

    private static final Scanner scan = new Scanner(System.in);
    private static final Random rand = new Random();

    private static int countDotsToWin;

    private static int lastHumanX = -1;
    private static int lastHumanY = -1;
    private static int lastCompX = -1;
    private static int lastCompY = -1;
    private static int candidateCompX = -1;
    private static int candidateCompY = -1;


    public static void turnGame() {

        init();
        printMap();

        while (true) {

            humanTurn();
            printMap();
            if (checkWin(DOT_HUMAN, gameField, lastHumanX, lastHumanY)) {
                System.out.println("\nВы победили!!!");
                break;
            }

            if (checkEnd(gameField)) {
                System.out.println("\nНичья!");
                break;
            }
            compTurn();
            printMap();
            if (checkWin(DOT_COMP, gameField, lastCompX, lastCompY)) {
                System.out.println("\nКомпьютер выиграл!!!");
                break;
            }

            if (checkEnd(gameField)) {
                System.out.println("\nНичья!");
                break;
            }
        }

    }


    private static void init() {

        System.out.println("Введите размер поля для игры (3-30)");

        do {
            size = scan.nextInt();
        } while (!isSizeValid(size));

        countDotsToWin = (size < 5) ? 3 : 4;

        System.out.printf("\nКоличество победных фишек %d", countDotsToWin);

        DOT_FORMAT = (size > 9) ? "%3s" : "%2s ";

        initMap();

    }

    private static void initMap() {

        gameField = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameField[i][j] = DOT_EMPTY;
            }
        }

    }

    private static void printMap() {

        System.out.println();
        System.out.printf("\n" + DOT_FORMAT, DOT_LOGO);

        for (int i = 0; i < size; i++) {
            System.out.printf(DOT_FORMAT, i + 1);
        }

        for (int i = 0; i < size; i++) {
            System.out.printf("\n" + DOT_FORMAT, (i + 1));
            for (int j = 0; j < size; j++) {
                System.out.printf(DOT_FORMAT, gameField[i][j]);
            }
        }

        System.out.println();

    }


    private static boolean checkWin(char dot, char[][] fieldToCheck, int lastX, int lastY) {

        if (lastX == -1 || lastY == -1) return false;

        int winCounter;

        // horizontal check
        winCounter = 0;
        for (int i = 0; i < size; i++) {
            if (fieldToCheck[lastX][i] == dot) {
                winCounter++;
            } else {
                winCounter = 0;
            }
            if (winCounter == countDotsToWin) {
                return true;
            }
        }

        // vertical check
        winCounter = 0;
        for (int i = 0; i < size; i++) {
            if (fieldToCheck[i][lastY] == dot) {
                winCounter++;
            } else {
                winCounter = 0;
            }
            if (winCounter == countDotsToWin) {
                return true;
            }
        }

        // main diagonal check
        winCounter = 0;

        int startX = (lastX < lastY) ? 0 : lastX - lastY;
        int startY = (lastX < lastY) ? lastY - lastX : 0;

        while (Math.max(startX, startY) < size) {

            if (fieldToCheck[startX][startY] == dot) {
                winCounter++;
            } else {
                winCounter = 0;
            }
            if (winCounter == countDotsToWin) {
                return true;
            }

            startX++;
            startY++;
        }

        // secondary diagonal check
        winCounter = 0;

        startX = (lastX + lastY >= size) ? size - 1 : lastX + lastY;
        startY = (lastX + lastY >= size) ? lastY - (size - 1 - lastX) : 0;

        while (startX >= 0 && startY < size) {

            if (fieldToCheck[startX][startY] == dot) {
                winCounter++;
            } else {
                winCounter = 0;
            }
            if (winCounter == countDotsToWin) {
                return true;
            }

            startX--;
            startY++;
        }

        return false;

    }

    private static boolean checkEnd(char[][] fieldToCheck) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (fieldToCheck[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void humanTurn() {

        int x;
        int y;

        do {
            System.out.println("\nВведите номер строки и столбца");
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        } while (!isTurnValid(x, y, DOT_HUMAN));

        gameField[x][y] = DOT_HUMAN;

        lastHumanX = x;
        lastHumanY = y;

    }

    private static void compTurn() {

        candidateCompX = -1;
        candidateCompY = -1;

        char[][] possibleField = new char[size][size];

        for (int i = 0; i < size; i++) {
            possibleField[i] = Arrays.copyOf(gameField[i], size);
        }

        // find comp turn by minimax algorithm if size == 3
        if (size == 3) {
            try {
                int[] candidate = miniMax(possibleField, DOT_COMP, lastHumanX, lastHumanY, lastCompX, lastCompY);
                candidateCompX = candidate[0];
                candidateCompY = candidate[1];
            } catch (Exception ex) {
                //System.out.println("Ошибка");
            }
            //System.out.println(rc);
        }

        // if minimax didn't find comp turn or size > 3
        if (candidateCompX == -1 || candidateCompY == -1) {
            // find turn to block human recursive (according last human turn)
            findPossibleCompTurn(possibleField, lastHumanX, lastHumanY, countDotsToWin);
        }

        // if minimax and recursive block didn't find comp turn get it random
        if (candidateCompX == -1 || candidateCompY == -1) {
            do {
                candidateCompX = rand.nextInt(size);
                candidateCompY = rand.nextInt(size);
            } while (!isTurnValid(candidateCompX, candidateCompY, DOT_COMP));
        }

        gameField[candidateCompX][candidateCompY] = DOT_COMP;

        lastCompX = candidateCompX;
        lastCompY = candidateCompY;

    }

    // recursive algorithm find possible turn according last Human turn just looking in all directions (up, down, left, right, all diagonals)
    private static void findPossibleCompTurn(char[][] possibleField, int lastHumanX, int lastHumanY, int depth) {

        if (lastHumanX - 1 >= 0 && possibleField[lastHumanX - 1][lastHumanY] == DOT_EMPTY) {
            possibleField[lastHumanX - 1][lastHumanY] = DOT_HUMAN;
            if (checkWin(DOT_HUMAN, possibleField, lastHumanX - 1, lastHumanY)) {
                candidateCompX = lastHumanX - 1;
                candidateCompY = lastHumanY;
            } else if (depth != 1) {
                findPossibleCompTurn(possibleField, lastHumanX - 1, lastHumanY, depth - 1);
            }
            possibleField[lastHumanX - 1][lastHumanY] = DOT_EMPTY;
        }

        if (lastHumanX - 1 >= 0 && lastHumanY - 1 >= 0 && possibleField[lastHumanX - 1][lastHumanY - 1] == DOT_EMPTY) {
            possibleField[lastHumanX - 1][lastHumanY - 1] = DOT_HUMAN;
            if (checkWin(DOT_HUMAN, possibleField,lastHumanX - 1,lastHumanY - 1)) {
                candidateCompX = lastHumanX - 1;
                candidateCompY = lastHumanY - 1;
            } else if (depth != 1) {
                findPossibleCompTurn(possibleField, lastHumanX - 1, lastHumanY - 1, depth - 1);
            }
            possibleField[lastHumanX - 1][lastHumanY - 1] = DOT_EMPTY;
        }

        if (lastHumanY - 1 >= 0 && possibleField[lastHumanX][lastHumanY - 1] == DOT_EMPTY) {
            possibleField[lastHumanX][lastHumanY - 1] = DOT_HUMAN;
            if (checkWin(DOT_HUMAN, possibleField, lastHumanX, lastHumanY - 1)) {
                candidateCompX = lastHumanX;
                candidateCompY = lastHumanY - 1;
            } else if (depth != 1) {
                findPossibleCompTurn(possibleField, lastHumanX, lastHumanY - 1, depth - 1);
            }
            possibleField[lastHumanX][lastHumanY - 1] = DOT_EMPTY;
        }

        if (lastHumanX + 1 < size && possibleField[lastHumanX + 1][lastHumanY] == DOT_EMPTY) {
            possibleField[lastHumanX + 1][lastHumanY] = DOT_HUMAN;
            if (checkWin(DOT_HUMAN, possibleField, lastHumanX + 1, lastHumanY)) {
                candidateCompX = lastHumanX + 1;
                candidateCompY = lastHumanY;
            } else if (depth != 1) {
                findPossibleCompTurn(possibleField, lastHumanX + 1, lastHumanY, depth - 1);
            }
            possibleField[lastHumanX + 1][lastHumanY] = DOT_EMPTY;
        }

        if (lastHumanX + 1 < size && lastHumanY + 1 < size && possibleField[lastHumanX + 1][lastHumanY + 1] == DOT_EMPTY) {
            possibleField[lastHumanX + 1][lastHumanY + 1] = DOT_HUMAN;
            if (checkWin(DOT_HUMAN, possibleField, lastHumanX + 1, lastHumanY + 1)) {
                candidateCompX = lastHumanX + 1;
                candidateCompY = lastHumanY + 1;
            } else if (depth != 1) {
                findPossibleCompTurn(possibleField, lastHumanX + 1, lastHumanY + 1, depth - 1);
            }
            possibleField[lastHumanX + 1][lastHumanY + 1] = DOT_EMPTY;
        }

        if (lastHumanY + 1 < size && possibleField[lastHumanX][lastHumanY + 1] == DOT_EMPTY) {
            possibleField[lastHumanX][lastHumanY + 1] = DOT_HUMAN;
            if (checkWin(DOT_HUMAN, possibleField, lastHumanX,lastHumanY + 1)) {
                candidateCompX = lastHumanX;
                candidateCompY = lastHumanY + 1;
            } else if (depth != 1) {
                findPossibleCompTurn(possibleField, lastHumanX, lastHumanY + 1, depth - 1);
            }
            possibleField[lastHumanX][lastHumanY + 1] = DOT_EMPTY;
        }

        if (lastHumanX + 1 < size && lastHumanY - 1 >= 0 && possibleField[lastHumanX + 1][lastHumanY - 1] == DOT_EMPTY) {
            possibleField[lastHumanX + 1][lastHumanY - 1] = DOT_HUMAN;
            if (checkWin(DOT_HUMAN, possibleField, lastHumanX + 1,lastHumanY - 1)) {
                candidateCompX = lastHumanX + 1;
                candidateCompY = lastHumanY - 1;
            } else if (depth != 1) {
                findPossibleCompTurn(possibleField, lastHumanX + 1, lastHumanY - 1, depth - 1);
            }
            possibleField[lastHumanX + 1][lastHumanY - 1] = DOT_EMPTY;
        }

        if (lastHumanX - 1 >= 0 && lastHumanY + 1 < size && possibleField[lastHumanX - 1][lastHumanY + 1] == DOT_EMPTY) {
            possibleField[lastHumanX - 1][lastHumanY + 1] = DOT_HUMAN;
            if (checkWin(DOT_HUMAN, possibleField, lastHumanX - 1,lastHumanY + 1)) {
                candidateCompX = lastHumanX - 1;
                candidateCompY = lastHumanY + 1;
            } else if (depth != 1) {
                findPossibleCompTurn(possibleField, lastHumanX - 1, lastHumanY + 1, depth - 1);
            }
            possibleField[lastHumanX - 1][lastHumanY + 1] = DOT_EMPTY;
        }
    }

    // minimax algorithm
    // result is array[3]: result[0] = possible X turn, result[1] = possible Y turn, result[3] = score of turn
    private static int[] miniMax(char[][] currentGameField, char player, int lstHumanX, int lstHumanY, int lstCompX, int lstCompY) {

        ArrayList<Integer[]> turns = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();

        int[] result = new int[3];

        if (checkWin(DOT_COMP, currentGameField, lstCompX, lstCompY)) {
            result[2] = 1;
            return result;
        } else if (checkWin(DOT_HUMAN, currentGameField, lstHumanX, lstHumanY)) {
            result[2] = -1;
            return result;
        } else if (checkEnd(currentGameField)) {
            result[2] = 0;
            return result;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (currentGameField[i][j] == DOT_EMPTY) {

                    currentGameField[i][j] = player;

                    turns.add(new Integer[]{i, j});

                    result[0] = i;
                    result[1] = j;

                    if (player == DOT_COMP) {
                        lstCompX = i;
                        lstCompY = j;
                    } else {
                        lstHumanX = i;
                        lstHumanY = j;
                    }

                    if (player == DOT_COMP) {
                        result[2] = miniMax(currentGameField, DOT_HUMAN, lstHumanX, lstHumanY, lstCompX, lstCompY)[2];
                    } else {
                        result[2] = miniMax(currentGameField, DOT_COMP, lstHumanX, lstHumanY, lstCompX, lstCompY)[2];
                    }

                    currentGameField[i][j] = DOT_EMPTY;

                    scores.add(result[2]);

                }
            }
        }

        if (player == DOT_COMP) {
            Integer maxScore = Collections.max(scores);
            Integer maxIndex = scores.indexOf(maxScore);

            result[0] = turns.get(maxIndex)[0];
            result[1] = turns.get(maxIndex)[1];
            result[2] = maxScore;
        } else {
            Integer minScore = Collections.min(scores);
            Integer minIndex = scores.indexOf(minScore);

            result[0] = turns.get(minIndex)[0];
            result[1] = turns.get(minIndex)[1];
            result[2] = minScore;
        }

        return result;

    }

    private static boolean isSizeValid(int size) {

        return (size >= 3 && size <= 30);

    }

    private static boolean isTurnValid(int x, int y, char dotCurrent) {

        if (x < 0 || x > size || y < 0 && y > size) {
            if (dotCurrent == DOT_HUMAN) {
                System.out.print("\nНеверные номер строки или столбца!");
            }
            return false;
        }
        ;

        if (gameField[x][y] != DOT_EMPTY) {
            if (dotCurrent == DOT_HUMAN) {
                System.out.print("\nЭто место занято!");
            }
            return false;
        }

        return true;

    }

}
