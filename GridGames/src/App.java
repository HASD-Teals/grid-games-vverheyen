public class App {
    public static void main(String[] args) throws Exception {
        // Grid Games, like tic tac toe
        System.out.println("Play it like connect 4 no gravity no diagonal, if you think you have four in a row check for the win vertically and horizontally.");
        System.out.println("If you don't check for 4-in-a-row before your next turn and get 5-in-a-row, it won't count and you'll have to continue");

        char[][] myGrid = createGrid(7, 7);
        printboard(myGrid);
    }

    public static char[][] createGrid(int row, int col) {
        char[][] array = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int d = 0; d < col; d++) {
                array[i][d] = '*';
            }
        }
        return array;
    }

    public static void printboard(char[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int d = 0; d < ar[i].length; d++) {
                System.out.print(ar[i][d] + " ");
            }
            System.out.println();
        }
    }

    public static void writeBlock(char[][] array, int row, int col, char a) {
        if (array[row][col] == '*') {
            array[row][col] = a;
        } else {
            array[row][col] = array[row][col];
        }
    }

    public static void checkHwin(char[][] array, char a, int num) {
        int counter = 0;
        for (int row = 0; row < array.length; row++) {
            int coordRow = 0;
            int coordCol = 0;
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == a) {
                    counter++;
                    coordRow = row;
                    coordCol = col;
                } else {
                    counter = 0;
                }
                if (counter == num) {
                    if (array[row][col] == array.length) {
                        coordCol = coordCol - num + 1;
                        System.out.println("Congratulations! You win at " + coordRow + "," + coordCol);
                    } else {
                        coordCol = coordCol - num + 1;
                        System.out.println("Congratulations! You win at " + coordRow + "," + coordCol);
                    }
                }
            }
        }
    }

    public static void checkVwin(char[][] array, char a, int num) {
        int counter = 0;
        for (int col = 0; col < array[col].length - 1; col++) {
            int coordRow = 0;
            int coordCol = 0;
            for (int row = 0; row < array.length; row++) {
                if (array[row][col] == a) {
                    counter++;
                    coordRow = row;
                    coordCol = col;
                } else {
                    counter = 0;
                }
                if (counter == num) {
                    if (array[row][col] == array.length) {
                        coordRow = coordRow - num + 1;
                        System.out.println("Congratulations! You win at " + coordRow + "," + coordCol);
                    } else {
                        coordRow = coordRow - num + 1;
                        System.out.println("Congratulations! You win at " + coordRow + "," + coordCol);
                    }
                }
            }
        }
    }

    public static void writeBlock(char[][] array, int row, int col, char a, boolean overwrite) {
        if (overwrite == true) {
            array[row][col] = a;
        }
    }

    public static void reverseRow(char[][] array, int row) {
        int b = array[row].length - 1;
        for (int i = 0; i < array[row].length / 2; i++) {
            char temp = array[row][i];
            array[row][i] = array[row][b];
            array[row][b] = temp;
            b--;
        }
    }

    public static void reverseCol(char[][] array, int col) {
        int b = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i][col];
            array[i][col] = array[b][col];
            array[b][col] = temp;
            b--;
        }
    }

    public static void blast(char[][] array, int row, int col, char b) {
        int top = 1;
        int bottom = 1;
        int left = 1;
        int right = 1;
        if (row == 0) {
            top--;
        }
        if (row == array.length - 1) {
            bottom--;
        }
        if (col == 0) {
            left--;
        }
        if (col == array[0].length - 1) {
            right--;
        }
        if (right == 1) {
            array[row][col + 1] = b;
        }
        if (left == 1) {
            array[row][col - 1] = b;
        }
        if (top == 1) {
            array[row - 1][col] = b;
        }
        if (bottom == 1) {
            array[row + 1][col] = b;
        }
    }

    public static void scoreboard(char[][] array, char b, int point) {
        int counter = 0;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == b) {
                    counter = counter + point;
                }
            }
        }
        System.out.println("You have " + counter + " points");
    }
}
