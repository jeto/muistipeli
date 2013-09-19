package Gamelogic;
/**
 * Card -luokka määrittelee kortin tunnuksen,
 * onko kortti kuvapuoli ylös vai alaspäin sekä onko kortti löydetty.
 * Luokka sisältää myös toiminnon korttien vertailulle ja löydetyksi merkitsemiselle.
 * 
 * @author Jere Toivonen
 */
public class Card {
    
    /**
     * Kortin tunnus
     */
    private int id;
    /**
     * Kortin kuvapuoli näkyvissä
     */
    private boolean face;
    /**
     * Kortti löydetty
     */
    private boolean found;
    
    /**
     * Konstruktori määrittelee luodun kortin tunnuksen ja
     * asettaa luodun kortin löytämättömäksi ja väärinpäin.
     */
    public Card(int id) {
        this.id = id;
        this.face = false;
        this.found = false;
    }
    
    /**
     * Kortin kääntämismetodi kääntää kortin kuvapuolen toisinpäin.
     */
    public void turn() {
        if (this.face == true) {
            this.face = false;
        } else if (this.face == false) {
            this.face = true;
        }
    }
    
    /**
     * Metodi vertaa annetun kortin tunnusta kortin tunnukseen,
     * jos tunnus on sama asetetaan molemmat kortit löydetyiksi.
     * 
     * @param card Verrattava kortti.
     * 
     * @return Palauttaa true jos kortit ovat samat, muutoin false.
     */
    public boolean same(Card card){
        if(card.getCard()==this.id){
            card.find();
            this.found = true;
            return true;
        }
        return false;
    }
    
    public boolean getFace() {
        return face;
    }
    
    public int getCard(){
        return this.id;
    }
    
    private void find(){
        this.found = true;
    }
    public boolean found(){
        return found;
    }
}
