package org.solarex.multitypebaseadapter.model;

import org.solarex.multitypebaseadapter.interfaces.TypeFactory;

/**
 * Created by houruhou on 02/04/2017.
 */

public class A implements Visitable {
    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    private String text;
    private String url;

    public A(String text, String url){
        this.text = text;
        this.url = url;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
