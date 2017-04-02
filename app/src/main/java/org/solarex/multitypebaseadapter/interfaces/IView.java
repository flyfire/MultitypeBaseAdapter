package org.solarex.multitypebaseadapter.interfaces;

/**
 * Created by houruhou on 02/04/2017.
 */

public interface IView {
    void notifyInserted(int position);
    void notifyRemoved(int position);
    void notifySwaped(int from, int to);
}
