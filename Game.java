package Main;

public class Game {
    int[][] spots = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0}
    };

    private final int row = 6;
    private final int col = 7;
    private boolean player = true;
    private int win_piece_1x, win_piece_1y, win_piece_2x, win_piece_2y;

    public Game() {} // Constructor

    public void playerInput(int choice) {
        int option = choice - 1;

        for (int i = row - 1; i >= 0; i--) {
            if (spots[i][option] == 0) {
                if (player) {
                    spots[i][option] = 1; // Player 1
                    break;
                } else {
                    spots[i][option] = 2; // Player 2
                    break;
                }
            }
        }

        player = !player;
    }

    public int[][] getState() {return spots;}

    public boolean getPlayer() {return player;}

    public int getFreeCol(int choice) {
        int option = choice - 1;
        for (int i = row - 1; i >= 0; i--) {
            if (spots[i][option] == 0) {
                return i;
            }
        }

        return 0;
    }
    
    // Checks if the players inputs is valid
    public boolean validInput(int choice) {
        int option = choice - 1;
        int check = 0;

        for (int k = row - 1; k >= 0; k--) {
            if (spots[k][option] == 1 || spots[k][option] == 2) {
                    check++;
            }
        }

        if (check == 6) { // If the row picked is full
            return false;
        }

        return true;
    }

    private boolean horizontalCheck() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 4; j++) {
                if (spots[i][j] != 0 && spots[i][j] == spots[i][j + 1] && spots[i][j] == spots[i][j + 2] && spots[i][j] == spots[i][j + 3]) {
                    win_piece_1x = j;
                    win_piece_1y = i;
                    win_piece_2x = j + 3;
                    win_piece_2y = i;
                    return true;
                }
            }
        }

        return false;
    }

    private boolean verticalCheck() {
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < 3; i++) {
                if (spots[i][j] != 0 && spots[i][j] == spots[i + 1][j] && spots[i][j] == spots[i + 2][j] && spots[i][j] == spots[i + 3][j]) {
                    win_piece_1x = j;
                    win_piece_1y = i;
                    win_piece_2x = j;
                    win_piece_2y = i + 3;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalCheckOne() {
        for (int i = row - 1; i > 2; i--) {
            for (int j = 0; j < 4; j++) {
                if (spots[i][j] != 0 && spots[i][j] == spots[i - 1][j + 1] && spots[i][j] == spots[i - 2][j + 2] && spots[i][j] == spots[i - 3][j + 3]) {
                    win_piece_1x = j;
                    win_piece_1y = i;
                    win_piece_2x = j + 3;
                    win_piece_2y = i - 3;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalCheckTwo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (spots[i][j] != 0 && spots[i][j] == spots[i + 1][j + 1] && spots[i][j] == spots[i + 2][j + 2] && spots[i][j] == spots[i + 3][j + 3]) {
                    win_piece_1x = j;
                    win_piece_1y = i;
                    win_piece_2x = j + 3;
                    win_piece_2y = i + 3;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean drawCheck() {
        int check = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (spots[i][j] == 1 || spots[i][j] == 2) {
                    check++;
                }
            }
        }

        if (check == 42) {
            return true;
        }

        return false;
    }

    public boolean winCheck() {
        if (this.verticalCheck() || this.horizontalCheck() || this.diagonalCheckOne() || this.diagonalCheckTwo()) {
            return true;
        }

        return false;
    }

    // Getting winning peices coordinates
    public int getx1() {return win_piece_1x;}
    public int gety1() {return win_piece_1y;}
    public int getx2() {return win_piece_2x;}
    public int gety2() {return win_piece_2y;}

    public void reset() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                spots[i][j] = 0;
            }
        }

        player = true;
    }

}
