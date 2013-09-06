// Korttiluokka määrittelee kortin tunnuksen
// ja onko kortti kuvapuoli ylös vai alaspäin

package muistipeli;

public class Kortti {

    private int id;
    private boolean face;

    public Kortti(int id) {
        this.id = id;
        this.face = false;
    }

    //Kuvapuoli getteri
    public boolean getFace() {
        return face;
    }
    
    //Kortin kääntö oikein/väärinpäin
//    public void turnFaceUp(){
//        this.face = true;
//    }
//    public void turnFaceDown(){
//        this.face = false;
//    }
    //Käännetään kortti
    public void turn() {
        if (this.face == true) {
            this.face = false;
        }
        if (this.face == false) {
            this.face = true;
        }
    }
    
    //Onko kortti sama
    public boolean same(Kortti k){
        if(k.getKortti()==this.id){
            return true;
        }
        return false;
    }
    
    //Kortin getteri
    public int getKortti(){
        return this.id;
    }
}
