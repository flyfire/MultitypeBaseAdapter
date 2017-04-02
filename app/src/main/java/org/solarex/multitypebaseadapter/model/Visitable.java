package org.solarex.multitypebaseadapter.model;

import org.solarex.multitypebaseadapter.interfaces.TypeFactory;

/**
 * Created by houruhou on 02/04/2017.
 */

public interface Visitable {
    int type(TypeFactory typeFactory);
}
