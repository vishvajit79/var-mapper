package io.qhacks.var_mapper;

/**
 * Created by Emilio K on 2018-02-03.
 */

public class Tuple<T, T1> {
    private T x;
    private T1 y;

    public Tuple(T x, T1 y){
        this.x = x;

        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T1 getY() {
        return y;
    }

    public void setY(T1 y) {
        this.y = y;
    }

    public boolean isEqual(Tuple<T, T1> t1){
        return t1.getX().equals(getX()) && t1.getY().equals(getY());
    }
}
