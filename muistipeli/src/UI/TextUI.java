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
        engine.getGameboard().printMatrix();
        while (engine.playing()) {

            
            System.out.println("Anna arvauksen x-koordinaatti: (0-" + (width - 1) + ")");
            int x = scanner.nextInt();
            while (x > width || x < 0) {
                System.out.println("Väärä koordinaatti, koordinaatin tulee olla väliltä 0-" + width);
            }
            System.out.println("Anna arvauksen y-koordinaatti: (0-" + (height - 1) + ")");
            int y = scanner.nextInt();
            while (y > height || y < 0) {
                System.out.println("Väärä koordinaatti, koordinaatin tulee olla väliltä 0-" + height);
            }
            engine.turnCard(x, y);
            engine.getGameboard().printMatrix();
            engine.checkTurnedCards();
        }
    }
    private void end(){
        System.out.println("Onneksi olkoon, läpäisit pelin!");
        System.out.println("Sait " + engine.getScore() + " pistettä ja käytit " + engine.getTurns() + " vuoroa.");
    }
}