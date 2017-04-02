package org.solarex.multitypebaseadapter.holder;

import android.view.View;
import android.widget.TextView;

import org.solarex.multitypebaseadapter.R;
import org.solarex.multitypebaseadapter.interfaces.BaseViewHolder;
import org.solarex.multitypebaseadapter.model.C;

/**
 * Created by houruhou on 02/04/2017.
 */

public class CViewHolder extends BaseViewHolder<C> {

    public CViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(C model, int position) {
        TextView tv1 = (TextView)getView(R.id.textview1);
        tv1.setText(model.getTitle());
        TextView tv2 = (TextView)getView(R.id.textview2);
        tv2.setText(model.getSubtitle());
    }
}
