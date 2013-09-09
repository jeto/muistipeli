// Pelialusta luo kortit ja asettaa ne matriisiin.

package muistipeli;

import java.util.ArrayList;
import java.util.Collections;

public class Pelialusta {
    // Korttiparien määrä
    private int parit;
    // Kortit listaan
    private ArrayList<Kortti> kortit;
    // Kortit matriisiin
    private Kortti[][] matriisi;
    
    
    public Pelialusta(int parit){
        if (parit < 2){
            throw new IllegalArgumentException("Anna useampi pari");
        } else if (parit > 16){
            throw new IllegalArgumentException("Liian suuri kenttä!");
        }
        this.parit = parit;
        kortit = new ArrayList<>(parit*2);
        luoKortit();
    }
    
    // Luodaan korttiparit ja sekoitetaan lista
    private void luoKortit(){
        for (int i = 0; i < parit*2; i++) {
            Kortti kortti;
            kortti = new Kortti(i);
            kortit.add(kortti);
            kortti = new Kortti(i);
            kortit.add(kortti);
        }
        shuffle();
    }
    
    // Sekoitetaan kortit
    private void shuffle(){
        if(kortit.isEmpty()){
            throw new IllegalArgumentException("Kortteja ei ole luotu!");
        }
        Collections.shuffle(kortit);
    }
    
    // Asetetaan kortit matriisiin
    public void luoMatriisi(){
        
    }
    
    // Tulostustesti
//    public void tulosta(){
//        for (int i = 0; i < kortit.size(); i++) {
//            System.out.println(kortit.get(i).getKortti());
//        }
//    }
}
