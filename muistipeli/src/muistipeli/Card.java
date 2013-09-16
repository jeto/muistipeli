// Korttiluokka määrittelee kortin tunnuksen
// ja onko kortti kuvapuoli ylös vai alaspäin

package muistipeli;

public class Card {

    private int id;
    private int x;
    private int y;
    
//    private boolean face;

    public Card(int id) {
        this.id = id;
//        this.face = false;
    }

    //Kuvapuoli getteri
//    public boolean getFace() {
//        return face;
//    }
    
    //Kortin kääntö oikein/väärinpäin
//    public void turnFaceUp(){
//        this.face = true;
//    }
//    public void turnFaceDown(){
//        this.face = false;
//    }
    //Käännetään kortti
//    public void turn() {
//        if (this.face == true) {
//            this.face = false;
//        } else if (this.face == false) {
//            this.face = true;
//        }
//    }
    
    //Onko kortti sama
    public boolean same(Card k){
        if(k.getCard()==this.id){
            return true;
        }
        return false;
    }
    
    //Kortin getteri
    public int getCard(){
        return this.id;
    }
    public void setCoord(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
