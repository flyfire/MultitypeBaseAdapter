package org.solarex.multitypebaseadapter.impl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import org.solarex.multitypebaseadapter.interfaces.ItemTouchMoveListener;

/**
 * Created by houruhou on 02/04/2017.
 */

public class SolarexTouchListener extends ItemTouchHelper.Callback {

    private ItemTouchMoveListener mListener;
    public SolarexTouchListener(ItemTouchMoveListener listener){
        this.mListener = listener;
        Log.d("solarex", "SolarexTouchListener | mListener = " + mListener);
    }
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP|ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() != target.getItemViewType()){
            return false;
        }
        return this.mListener.onItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        Log.d("solarex", "onSwiped | mListener = " + mListener);
        this.mListener.onItemRemoved(position);
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        Log.d("solarex", "onSelectChanged, position = " + (viewHolder!=null?viewHolder.getAdapterPosition():-1) + ",actionState = " + actionState);
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            viewHolder.itemView.setBackgroundColor(Color.argb(0xff, 0x4c, 0xaf, 0x50));
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        Log.d("solarex", "clearView | position = " + viewHolder.getAdapterPosition() );
        viewHolder.itemView.setBackgroundColor(Color.RED);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder
            viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        Log.d("solarex", "onChildDraw | dX = " + dX + ",dY = " + dY);
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            float factor = 1 - Math.abs(dX)/viewHolder.itemView.getWidth();
            viewHolder.itemView.setAlpha(factor);
            viewHolder.itemView.setScaleX(factor);
            viewHolder.itemView.setScaleY(factor);
        }
    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder
            viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
