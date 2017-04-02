package org.solarex.multitypebaseadapter.interfaces;

/**
 * Created by houruhou on 02/04/2017.
 */

public interface ItemTouchMoveListener {
    boolean onItemMoved(int from, int to);
    void onItemRemoved(int position);
}
