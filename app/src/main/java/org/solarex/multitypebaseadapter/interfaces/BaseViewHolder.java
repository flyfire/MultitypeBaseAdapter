package org.solarex.multitypebaseadapter.interfaces;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by houruhou on 02/04/2017.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mItemView;
    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
        mItemView = itemView;
    }

    protected View getView(int resId){
        View view = mViews.get(resId);
        if (view == null){
            view = mItemView.findViewById(resId);
            mViews.put(resId, view);
        }
        return view;
    }

    abstract public void setUpView(T model, int position);
}
