package creational;

public class Wall extends MapSite implements Cloneable {

    public Wall() {}

    void enter() {}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
