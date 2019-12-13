package eg.edu.alexu.csd.oop.game.sample.object;

public class cloneFactory {

    public protoType getColone(protoType ImageObject) throws CloneNotSupportedException {
        return ImageObject.makeCopy();
    }

}
