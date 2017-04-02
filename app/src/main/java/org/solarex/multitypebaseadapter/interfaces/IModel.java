package org.solarex.multitypebaseadapter.interfaces;


import org.solarex.multitypebaseadapter.model.Visitable;

import java.util.ArrayList;

/**
 * Created by houruhou on 02/04/2017.
 */

public abstract class IModel {
    protected ModelCallback mCallback;
    protected ArrayList<Visitable> mDatas;

    public IModel(ModelCallback callback, ArrayList<Visitable> datas){
        this.mCallback = callback;
        this.mDatas = datas;
    }

    public abstract void insertData(Visitable data);
    public abstract void deleteData(int position);
    public abstract void swapData(int from, int to);
}
