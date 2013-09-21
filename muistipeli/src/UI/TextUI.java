package UI;

import Gamelogic.Engine;
import java.util.Scanner;

public class TextUI {

    private Engine engine;
    private Scanner scanner;
    private int width;
    private int height;

    public TextUI() {
        scanner = new Scanner(System.in);
        start();
        play();
        end();
    }

    private void start() {
        System.out.println("Tervetuloa muistipeliin");
        System.out.println("Anna kentän korkeus: (2-5)");
        height = scanner.nextInt();
        while (height < 2 || height > 5) {
            System.out.println("Väärä korkeus, korkeuden tulee olla väliltä 2-5");
            height = scanner.nextInt();
        }
        System.out.println("Anna kentän leveys: (2-6)");
        width = scanner.nextInt();
        while (width < 2 || width > 5) {
            System.out.println("Väärä leveys, leveyden tulee olla väliltä 2-6");
            width = scanner.nextInt();
        }
        if((height*width)%2!=0){
            System.out.println("Kentällä tulee olla parillinen määrä kortteja");
            start();
        }
        engine = new Engine(width, height);
    }
    private void play(){
        printMatrix();
        while (engine.playing()) {
            System.out.println("Anna arvauksen x-koordinaatti: (0-" + (width - 1) + ")");
            int x = scanner.nextInt();
            while (x > width-1 || x < 0) {
                System.out.println("Väärä koordinaatti, koordinaatin tulee olla väliltä 0-" + (width-1));
                x = scanner.nextInt();
            }
            System.out.println("Anna arvauksen y-koordinaatti: (0-" + (height - 1) + ")");
            int y = scanner.nextInt();
            while (y > height-1 || y < 0) {
                System.out.println("Väärä koordinaatti, koordinaatin tulee olla väliltä 0-" + (height-1));
                y = scanner.nextInt();
            }
            engine.turnCard(x, y);
            printMatrix();
            engine.checkTurnedCards();
        }
    }
    private void end(){
        System.out.println("Onneksi olkoon, läpäisit pelin!");
        System.out.println("Sait " + engine.getScore() + " pistettä ja käytit " + engine.getTurns() + " vuoroa.");
        System.out.println("Pisin arvausputkesi oli " + engine.getHighestStreak() + " paria peräkkäin!");
    }
    
    private void printMatrix() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!engine.getGameboard().getMatrix()[i][j].getFace() && !engine.getGameboard().getMatrix()[i][j].found()) {
                    System.out.print("[] ");
                } else if (engine.getGameboard().getMatrix()[i][j].found()) {
                    System.out.print("   ");
                } else {
                    if (engine.getGameboard().getMatrix()[i][j].getCard() < 10) {
                        System.out.print(engine.getGameboard().getMatrix()[i][j].getCard() + "  ");
                    } else {
                        System.out.print(engine.getGameboard().getMatrix()[i][j].getCard() + " ");
                    }
                }
            }
            System.out.println("");
        }
    }
}