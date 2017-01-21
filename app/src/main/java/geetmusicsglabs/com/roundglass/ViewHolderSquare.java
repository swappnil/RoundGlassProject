package geetmusicsglabs.com.roundglass;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by swappnil on 20-01-2017.
 */
public class ViewHolderSquare extends RecyclerView.ViewHolder {

    private TextView label1, label2;
    private View view;

    public ViewHolderSquare(View v) {
        super(v);
        view= (View)v.findViewById(R.id.square_view);
        //view.setBackgroundColor(Color.parseColor(String.valueOf(R.color.colorAccent)));
        //view.setBackgroundResource(R.color.colorAccent);
        /*label1 = (TextView) v.findViewById(R.id.text_shape);
        label2 = (TextView) v.findViewById(R.id.text_color);*/
    }

    public TextView getLabel1() {
        return label1;
    }

    public void setColor(int colorId) {
        //view.setBackgroundColor(ContextCompat.getColor(colorId));
        view.setBackgroundResource(colorId);
    }

    public TextView getLabel2() {
        return label2;
    }

    public void setLabel2(TextView label2) {
        this.label2 = label2;
    }
}
