
import java.util.Random;
import java.util.Scanner;

public class Game {

    private char table[][] = new char[10][10];
    private Hole hole;
    private Murderer murderer;

    public Game() {
        Random rand = new Random(System.currentTimeMillis());
        int x1, x2, y1, y2;
        do {
            x1 = rand.nextInt(10);
            x2 = rand.nextInt(10);
            y1 = rand.nextInt(10);
            y2 = rand.nextInt(10);
        } while (x1 != x2 && y1 != y2);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                table[i][j] = '-';
            }
        }
        table[x1][y1] = 'H';
        table[x2][y2] = 'M';
        hole = new Hole(x1, y1);
        murderer = new Murderer(x2, y2);
        System.out.println("Welcome to the Game!");
        start();
    }

    public void display() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void update() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                table[i][j] = '-';
            }
        }
        table[hole.returnx()][hole.returny()] = 'H';
        table[murderer.returnx()][murderer.returny()] = 'M';
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        Random rand = new Random(System.currentTimeMillis());
        boolean turn = true;
        boolean end = false;
        int answer;
        do {
            display();
            if (turn == true) {
                System.out.println("Its time for Hole to Move! ");
            } else {
                System.out.println("Its time for Murderer to Move! ");
            }
            if (turn == true) {
                System.out.println("Please Select the direction that you want to move : ");
                System.out.println("1. Up ");
                System.out.println("2. Down ");
                System.out.println("3. Left ");
                System.out.println("4. Right ");
                answer = input.nextInt();
                switch (answer) {
                    case 1:
                        if (hole.returnx() - 1 >= 0) {
                            hole.move(hole.returnx() - 1, hole.returny());
                        } else {
                            System.out.println("Couldnt go up so i didnt move");
                        }
                        break;
                    case 2:
                        if (hole.returnx() + 1 <= 9) {
                            hole.move(hole.returnx() + 1, hole.returny());
                        } else {
                            System.out.println("Couldnt go down so i didnt move");
                        }
                        break;
                    case 3:
                        if (hole.returny() - 1 >= 0) {
                            hole.move(hole.returnx(), hole.returny() - 1);
                        } else {
                            System.out.println("Couldnt go left so i didnt move");
                        }
                        break;
                    case 4:
                        if (hole.returny() + 1 <= 9) {
                            hole.move(hole.returnx(), hole.returny() + 1);
                        } else {
                            System.out.println("Couldnt go right so i didnt move");
                        }
                        break;
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    answer = rand.nextInt(4) + 1;
                    switch (answer) {
                        case 1:
                            if (murderer.returnx() - 1 >= 0) {
                                System.out.println("Moved up");
                                murderer.move(murderer.returnx() - 1, murderer.returny());
                            } else {
                                System.out.println("Couldnt go up so i didnt move");
                            }
                            break;
                        case 2:
                            if (murderer.returnx() + 1 <= 9) {
                                System.out.println("Moved down");
                                murderer.move(murderer.returnx() + 1, murderer.returny());
                            } else {
                                System.out.println("Couldnt go down so i didnt move");
                            }
                            break;
                        case 3:
                            if (murderer.returny() - 1 >= 0) {
                                System.out.println("Moved Left");
                                murderer.move(murderer.returnx(), murderer.returny() - 1);
                            } else {
                                System.out.println("Couldnt go left so i didnt move");
                            }
                            break;
                        case 4:
                            if (murderer.returny() + 1 <= 9) {
                                System.out.println("Moved Right");
                                murderer.move(murderer.returnx(), murderer.returny() + 1);
                            } else {
                                System.out.println("Couldnt go right so i didnt move");
                            }
                            break;
                    }

                }
            }
            update();
            if (turn == true) {
                turn = false;
            } else {
                turn = true;
            }
            if (hole.returnx() == murderer.returnx() && hole.returny() == murderer.returny()) {
                end = true;
            }
        } while (end != true);

    }

}
