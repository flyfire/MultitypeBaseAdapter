package org.solarex.multitypebaseadapter.model;

import org.solarex.multitypebaseadapter.interfaces.TypeFactory;

/**
 * Created by houruhou on 02/04/2017.
 */

public class B implements Visitable {

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    private String text;

    public B(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
