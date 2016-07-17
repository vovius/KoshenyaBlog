package com.koshenya.koshenyablog;

/**
 * Created by sony on 7/17/2016.
 */
public class Koshenya {
    private Human owner;

    public Koshenya() {}

    public Koshenya(Human owner) {
        this.owner = owner;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }
}
