package org.solarex.multitypebaseadapter.impl;

import android.view.View;

import org.solarex.multitypebaseadapter.R;
import org.solarex.multitypebaseadapter.holder.AViewHolder;
import org.solarex.multitypebaseadapter.holder.BViewHolder;
import org.solarex.multitypebaseadapter.holder.CViewHolder;
import org.solarex.multitypebaseadapter.interfaces.BaseViewHolder;
import org.solarex.multitypebaseadapter.interfaces.TypeFactory;
import org.solarex.multitypebaseadapter.model.A;
import org.solarex.multitypebaseadapter.model.B;
import org.solarex.multitypebaseadapter.model.C;

/**
 * Created by houruhou on 02/04/2017.
 */

public class TypeFactoryForList implements TypeFactory {

    private final int ITEM_1 = R.layout.item_1;
    private final int ITEM_2 = R.layout.item_2;
    private final int ITEM_3 = R.layout.item_3;
    @Override
    public int type(A a) {
        return ITEM_1;
    }

    @Override
    public int type(B b) {
        return ITEM_2;
    }

    @Override
    public int type(C c) {
        return ITEM_3;
    }

    @Override
    public BaseViewHolder createViewHolder(int viewType, View view) {
        BaseViewHolder vh = null;
        switch (viewType){
            case ITEM_1:
                vh = new AViewHolder(view);
                break;
            case ITEM_2:
                vh = new BViewHolder(view);
                break;
            case ITEM_3:
                vh = new CViewHolder(view);
                break;
        }
        return vh;
    }
}
