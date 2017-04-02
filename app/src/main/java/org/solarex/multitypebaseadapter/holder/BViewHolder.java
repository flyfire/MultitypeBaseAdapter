package org.solarex.multitypebaseadapter.holder;

import android.view.View;
import android.widget.TextView;

import org.solarex.multitypebaseadapter.R;
import org.solarex.multitypebaseadapter.interfaces.BaseViewHolder;
import org.solarex.multitypebaseadapter.model.B;

/**
 * Created by houruhou on 02/04/2017.
 */

public class BViewHolder extends BaseViewHolder<B> {
    public BViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(B model, int position) {
        TextView textView = (TextView)getView(R.id.textview);
        textView.setText(model.getText());
    }
}
