package geetmusicsglabs.com.roundglass;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by swappnil on 20-01-2017.
 */
public class ViewHolderPlain extends RecyclerView.ViewHolder {

    private TextView label1, label2;

    public ViewHolderPlain(View v) {
        super(v);
        /*label1 = (TextView) v.findViewById(R.id.text_shape);
        label2 = (TextView) v.findViewById(R.id.text_color);*/
    }

    public TextView getLabel1() {
        return label1;
    }

    public void setLabel1(TextView label1) {
        this.label1 = label1;
    }

    public TextView getLabel2() {
        return label2;
    }

    public void setLabel2(TextView label2) {
        this.label2 = label2;
    }
}
