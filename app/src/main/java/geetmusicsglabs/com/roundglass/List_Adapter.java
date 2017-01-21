package geetmusicsglabs.com.roundglass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * Created by swappnil on 20-01-2017.
 */
public class List_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnClickListener{
    private List<ListItems> items = new ArrayList<>();
    private final int CIRCLE = 0, TRIANGLE = 1, PLAIN=2;
    public Context context;
    public RecyclerView recyclerview;
    public OnClickInterface onclick;

    public List_Adapter(List<ListItems> items, Context context,OnClickInterface onclick) {
        this.items = items;
        this.context= context;
        this.onclick=onclick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case CIRCLE:
                View v1 = inflater.inflate(R.layout.viewholdercircle, viewGroup, false);
                v1.setOnClickListener(this);
                viewHolder = new ViewHolderCircle(v1);
                break;
            case TRIANGLE:
                View v2 = inflater.inflate(R.layout.viewholdersquare, viewGroup, false);
                v2.setOnClickListener(this);
                viewHolder = new ViewHolderSquare(v2);
                break;
            case PLAIN:
                View v3 = inflater.inflate(R.layout.viewholderplain, viewGroup, false);
                v3.setOnClickListener(this);
                viewHolder = new ViewHolderPlain(v3);
                break;
            default:
                View v = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                v.setOnClickListener(this);
                viewHolder = new ViewHolderCircle(v);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case CIRCLE:
                ViewHolderCircle vh1 = (ViewHolderCircle) viewHolder;
                configureViewHolder1(vh1, position);
                break;
            case TRIANGLE:
                ViewHolderSquare vh2 = (ViewHolderSquare) viewHolder;
                configureViewHolder2(vh2, position);
                break;
            case PLAIN:
                ViewHolderPlain vh3 = (ViewHolderPlain) viewHolder;
                configureViewHolder3(vh3, position);
                break;
            default:
                /*RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) viewHolder;
                configureDefaultViewHolder(vh, position);*/
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position).getShape().equals("circle")) {
            return CIRCLE;
        } else if (items.get(position).getShape().equals("square")) {
            return TRIANGLE;
        }else if (items.get(position).getShape().equals("plain")) {
            return PLAIN;
        }
        return -1;
    }


    @Override
    public int getItemCount() {
        return this.items.size();
    }
    /*private void configureDefaultViewHolder(RecyclerViewSimpleTextViewHolder vh, int position) {
        vh.getLabel().setText((CharSequence) items.get(position));
    }*/

    private void configureViewHolder1(ViewHolderCircle vh1, int position) {
        ListItems item = (ListItems) items.get(position);
        if (item != null) {
            if(item.getColor().equals("1")){
                vh1.setColor("#1e88e5");
            }else if(item.getColor().equals("2")){
                vh1.setColor("#ff8a65");
            }else if(item.getColor().equals("3")){
                vh1.setColor("#26a69a");
            }
            //((GradientDrawable)vh1.getColor().getBackground()).setColor(Color.parseColor("#00FFFF"));
            //vh1.getLabel2().setText("Color: " + item.getColor());
        }
    }
    private void configureViewHolder2(ViewHolderSquare vh1, int position) {
        ListItems item = (ListItems) items.get(position);
        if (item != null) {
            if(item.getColor().equals("1")){
                vh1.setColor(R.color.colorPrimary);
            }else if(item.getColor().equals("2")){
                vh1.setColor(R.color.colorAccent);
            }else if(item.getColor().equals("3")){
                vh1.setColor(R.color.fourth);
            }
            /*vh1.getLabel1().setText("Shape: " + item.getShape());
            vh1.getLabel2().setText("Color: " + item.getColor());*/
        }
    }
    private void configureViewHolder3(ViewHolderPlain vh1, int position) {
        ListItems item = (ListItems) items.get(position);
        /*if (item != null) {
            vh1.getLabel1().setText("Shape: " + item.getShape());
            vh1.getLabel2().setText("Color: " + item.getColor());
        }*/
    }

    @Override
    public void onClick(View view) {
        onclick.onclick(view);
        /*int itemPosition = recyclerview.getChildLayoutPosition(view);
        String item = String.valueOf(items.get(itemPosition));
        Toast.makeText(context, "Item Selected : "+item, Toast.LENGTH_SHORT).show();*/
    }
}
