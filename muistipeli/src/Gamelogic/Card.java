// Korttiluokka määrittelee kortin tunnuksen
// ja onko kortti kuvapuoli ylös vai alaspäin
// sekä onko kortti löydetty

package Gamelogic;

public class Card {

    private int id;
    private boolean face;
    private boolean found;
    
    public Card(int id) {
        this.id = id;
        this.face = false;
        this.found = false;
    }

    // Kuvapuoli getteri
    public boolean getFace() {
        return face;
    }
    
    // Käännetään kortti
    public void turn() {
        if (this.face == true) {
            this.face = false;
        } else if (this.face == false) {
            this.face = true;
        }
    }
    
    // Onko kortti sama
    // Jos on, merkitään molemmat löydetyiksi
    public boolean same(Card card){
        if(card.getCard()==this.id){
            card.find();
            this.found = true;
            return true;
        }
        return false;
    }
    
    // Palautetaan kortin tunnus
    public int getCard(){
        return this.id;
    }
    
    // Kortin löytömetodi
    private void find(){
        this.found = true;
    }
    public boolean found(){
        return found;
    }
}
