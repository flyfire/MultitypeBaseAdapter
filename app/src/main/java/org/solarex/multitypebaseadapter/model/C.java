package org.solarex.multitypebaseadapter.model;

import org.solarex.multitypebaseadapter.interfaces.TypeFactory;

/**
 * Created by houruhou on 02/04/2017.
 */

public class C implements Visitable {
    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
    private String title;
    private String subtitle;
    public C(String title, String subtitle){
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
