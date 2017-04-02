package org.solarex.multitypebaseadapter.interfaces;

import org.solarex.multitypebaseadapter.model.Visitable;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by houruhou on 02/04/2017.
 */

public abstract class BasePresenter {
    protected Reference<IView> mViewRef;

    public void attachView(IView view){
        mViewRef = new WeakReference<IView>(view);
    }

    protected IView getView(){
        if (mViewRef != null){
            return mViewRef.get();
        }
        return null;
    }

    public void detachView(){
        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public abstract void initData();
    public abstract void addData();
    public abstract ArrayList<Visitable> getDatas();
}
