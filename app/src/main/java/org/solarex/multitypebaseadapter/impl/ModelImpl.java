package org.solarex.multitypebaseadapter.impl;

import org.solarex.multitypebaseadapter.interfaces.IModel;
import org.solarex.multitypebaseadapter.interfaces.ModelCallback;
import org.solarex.multitypebaseadapter.model.Visitable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by houruhou on 02/04/2017.
 */

public class ModelImpl extends IModel {
    private boolean mockRet = true;
    public ModelImpl(ModelCallback callback, ArrayList<Visitable> datas) {
        super(callback, datas);
    }

    @Override
    public void insertData(Visitable data) {
        this.mDatas.add(data);
        if (mockRet){
            int position = mDatas.size()>0?mDatas.size()-1:0;
            mCallback.onInsertSuccessed(15);
        } else {
            mCallback.onInsertFailure();
        }
    }

    @Override
    public void deleteData(int position) {
        this.mDatas.remove(position);
        if (mockRet){
            mCallback.onRemoveSuccessed(position);
        } else {
            mCallback.onRemoveFailure();
        }
    }

    @Override
    public void swapData(int from, int to) {
        Collections.swap(this.mDatas, from, to);
        if (mockRet){
            mCallback.onSwapSuccessed(from, to);
        } else {
            mCallback.onSwapFailure();
        }
    }
}
