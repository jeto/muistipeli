// Pelialusta luo kortit ja asettaa ne matriisiin.
package muistipeli;

import java.util.ArrayList;
import java.util.Collections;

public class Pelialusta {
    // Korttien määrä
    private int koko;
    
    //Kentän korkeus & leveys
    private int korkeus;
    private int leveys;
    
    // Korteille lista
    private ArrayList<Kortti> kortit;
    
    // Korteille matriisi
    private Kortti[][] matriisi;

    /* Alustetaan pelialusta konstruktorissa antamalla kentän korkeus ja leveys
     * Tarkistetaan, että annetulla koolla kentällä on parillinen määrä kortteja
     * ja että niitä on oikea määrä (4-30 korttia).
     * Luodaan kortit
     */
    public Pelialusta(int korkeus, int leveys) {
        this.koko = korkeus * leveys;
        if (leveys < 2 || korkeus < 2) {
            throw new IllegalArgumentException("Kentän minimikoko on 2x2");
        } else if (leveys > 6 || korkeus > 5 || koko > 30) {
            throw new IllegalArgumentException("Kentän maksimikoko on 5x6 tai 15 paria!");
        } else if (koko % 2 != 0) {
            throw new IllegalArgumentException("Kentällä tulee olla parillinen määrä kortteja!");
        }
        this.korkeus = korkeus;
        this.leveys = leveys;
        kortit = new ArrayList<>(koko);
        luoKortit();
    }

    // Luodaan korttiparit ja sekoitetaan lista
    private void luoKortit() {
        for (int i = 0; i < koko/2; i++) {
            Kortti kortti;
            kortti = new Kortti(i);
            kortit.add(kortti);
            kortti = new Kortti(i);
            kortit.add(kortti);
        }
        shuffle();
        luoMatriisi();
    }

    // Sekoitetaan kortit
    private void shuffle() {
        if (kortit.isEmpty()) {
            throw new IllegalArgumentException("Kortteja ei ole luotu!");
        }
        Collections.shuffle(kortit);
    }

    // Asetetaan kortit matriisiin
    public void luoMatriisi() {
        int i = 0;
        matriisi = new Kortti[korkeus][leveys];
        for (int row = 0; row < korkeus; row++) {
            for (int column = 0; column < leveys; column++) {
                matriisi[row][column] = kortit.get(i);
                i++;
            }
        }
    }
    
    // Matriisille getteri
    public Kortti[][] getMatriisi() {
        return matriisi;
    }
    
    
    //Testiprinttejä
//    public void printKortit(){
//        for (Kortti kortti : kortit) {
//            System.out.println(kortti.getKortti());
//        }
//    }
//    public void printMatriisi(){
//        for (int i = 0; i < korkeus; i++) {
//            for (int j = 0; j < leveys; j++) {
//                System.out.print(matriisi[i][j].getKortti() + " ");
//                
//            }
//            System.out.println("");
//        }
//    }
    
    // Korttien määrälle getteri
    public int getSize() {
        return kortit.size();
    }
}
