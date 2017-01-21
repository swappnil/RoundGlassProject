package geetmusicsglabs.com.roundglass;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by swappnil on 20-01-2017.
 */
public class ViewHolderCircle extends RecyclerView.ViewHolder {

    private TextView label1, label2;
    private View circleColor;

    public ViewHolderCircle(View v) {
        super(v);
        circleColor = (View) v.findViewById(R.id.view_circle);
        /*int color = Color.parseColor("#00FFFF");
        ((GradientDrawable)circleColor.getBackground()).setColor(color);*/
        /*label1 = (TextView) v.findViewById(R.id.text_shape);
        label2 = (TextView) v.findViewById(R.id.text_color);*/
    }

    public View getColor() {
        return circleColor;
    }

    public void setColor(String colour) {
        int color = Color.parseColor(colour);
        ((GradientDrawable)circleColor.getBackground()).setColor(color);
    }

    public TextView getLabel2() {
        return label2;
    }

    public void setLabel2(TextView label2) {
        this.label2 = label2;
    }


}
