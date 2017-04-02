package org.solarex.multitypebaseadapter.impl;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.solarex.multitypebaseadapter.interfaces.BaseViewHolder;
import org.solarex.multitypebaseadapter.interfaces.TypeFactory;
import org.solarex.multitypebaseadapter.model.Visitable;

import java.util.ArrayList;

/**
 * Created by houruhou on 02/04/2017.
 */
public class Adapter extends RecyclerView.Adapter<BaseViewHolder>{
    private ArrayList<Visitable> mDatas;
    private TypeFactory mTypeFactory;
    public Adapter(ArrayList<Visitable> datas){
        this.mDatas = datas;
        this.mTypeFactory = new TypeFactoryForList();
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return mTypeFactory.createViewHolder(viewType, view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setUpView(mDatas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDatas.get(position).type(mTypeFactory);
    }
}
