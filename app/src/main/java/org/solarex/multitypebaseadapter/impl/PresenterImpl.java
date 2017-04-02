package org.solarex.multitypebaseadapter.impl;


import org.solarex.multitypebaseadapter.interfaces.BasePresenter;
import org.solarex.multitypebaseadapter.interfaces.IModel;
import org.solarex.multitypebaseadapter.interfaces.ItemTouchMoveListener;
import org.solarex.multitypebaseadapter.interfaces.ModelCallback;
import org.solarex.multitypebaseadapter.model.A;
import org.solarex.multitypebaseadapter.model.B;
import org.solarex.multitypebaseadapter.model.C;
import org.solarex.multitypebaseadapter.model.Constants;
import org.solarex.multitypebaseadapter.model.Visitable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by houruhou on 02/04/2017.
 */

public class PresenterImpl extends BasePresenter implements ModelCallback,ItemTouchMoveListener{
    private ArrayList<Visitable> mDatas;
    private IModel mModel;
    private Random mRandom;
    public PresenterImpl(){
        mDatas = new ArrayList<>();
        mModel = new ModelImpl(this, mDatas);
        mRandom = new Random();
    }
    @Override
    public void initData() {
        A a;
        B b;
        C c;
        for (int i = 0; i < 50; i++) {
            switch(i % 3){
                case 0:
                    a = new A("A类文本", "https://avatars1.githubusercontent.com/u/922231?v=3&s=160");
                    mDatas.add(a);
                    break;
                case 1:
                    b = new B("B类文本");
                    mDatas.add(b);
                    break;
                case 2:
                    c = new C("C类文本", "C类子标题");
                    mDatas.add(c);
                    break;
            }
        }
    }

    @Override
    public void addData() {
        int index = mRandom.nextInt(Constants.mRandomStrings.length);
        A a = new A(Constants.mRandomStrings[index], "https://avatars1.githubusercontent.com/u/922231?v=3&s=160");
        mModel.insertData(a);
    }

    @Override
    public void onInsertSuccessed(int position) {
        getView().notifyInserted(position);
    }

    @Override
    public void onInsertFailure() {

    }

    @Override
    public void onRemoveSuccessed(int position) {
        getView().notifyRemoved(position);
    }

    @Override
    public void onRemoveFailure() {

    }

    @Override
    public void onSwapSuccessed(int from, int to) {
        getView().notifySwaped(from, to);
    }

    @Override
    public void onSwapFailure() {

    }

    @Override
    public boolean onItemMoved(int from, int to) {
        mModel.swapData(from, to);
        return true;
    }

    @Override
    public void onItemRemoved(int position) {
        mModel.deleteData(position);
    }

    public ArrayList<Visitable> getDatas(){
        return mDatas;
    }
}
