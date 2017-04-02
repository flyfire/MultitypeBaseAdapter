package org.solarex.multitypebaseadapter.interfaces;

import android.view.View;

import org.solarex.multitypebaseadapter.model.A;
import org.solarex.multitypebaseadapter.model.B;
import org.solarex.multitypebaseadapter.model.C;

/**
 * Created by houruhou on 02/04/2017.
 */

public interface TypeFactory {
    int type(A a);
    int type(B b);
    int type(C c);
    BaseViewHolder createViewHolder(int viewType, View view);
}
