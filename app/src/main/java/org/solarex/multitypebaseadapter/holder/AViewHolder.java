package org.solarex.multitypebaseadapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.solarex.multitypebaseadapter.R;
import org.solarex.multitypebaseadapter.interfaces.BaseViewHolder;
import org.solarex.multitypebaseadapter.model.A;

/**
 * Created by houruhou on 02/04/2017.
 */

public class AViewHolder extends BaseViewHolder<A> {
    public AViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(A model, int position) {
        final ImageView imageView = (ImageView)getView(R.id.circleimage);
        final TextView textView = (TextView)getView(R.id.tv);
        textView.setText(model.getText());
        Glide.with(imageView.getContext()).load(model.getUrl()).into(imageView);
    }
}
