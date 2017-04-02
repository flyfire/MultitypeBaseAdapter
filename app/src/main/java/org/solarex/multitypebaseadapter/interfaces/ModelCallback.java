package org.solarex.multitypebaseadapter.interfaces;

/**
 * Created by houruhou on 02/04/2017.
 */

public interface ModelCallback {
    void onInsertSuccessed(int position);
    void onInsertFailure();
    void onRemoveSuccessed(int position);
    void onRemoveFailure();
    void onSwapSuccessed(int from, int to);
    void onSwapFailure();
}
