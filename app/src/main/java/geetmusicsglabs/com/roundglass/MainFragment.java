package geetmusicsglabs.com.roundglass;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swappnil on 21-01-2017.
 */
public class MainFragment extends Fragment {

    private List<ListItems> items = new ArrayList<>();
    public RecyclerView recyclerView;
    public List_Adapter list_adapter;
    private ListItems item;
    public int ccolor = 1, scolor = 2, total_items = 40;

    public GridLayoutManager getGridLayoutManager() {
        final GridLayoutManager manager = new GridLayoutManager(getActivity(), 8);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int index = position % 4;
                switch (index) {
                    case 0:
                        return 8;
                    case 1:
                        return 4;
                    case 2:
                        return 2;
                    default:
                        return 2;

                }
            }
        });
        return manager;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        list_adapter = new List_Adapter(items, getContext(), new OnClickInterface() {
            @Override
            public void onclick(View view) {
                int itemPosition = recyclerView.getChildLayoutPosition(view);
                String item = String.valueOf(itemPosition + 1);
                itemDes(itemPosition);
                //Toast.makeText(MainActivity.this, "Position : " + item +" Shape: "+items.get(itemPosition).getShape(), Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(getGridLayoutManager());
        recyclerView.setAdapter(list_adapter);
        prepareItemsData(total_items);

        return view;
    }
    private void prepareItemsData(int itemsize) {
        items.clear();
        while (items.size() < itemsize) {
            switch (items.size() % 4) {
                case 0:
                    item = new ListItems("plain", String.valueOf(items.size() + 1));
                    items.add(item);

                    break;
                case 1:
                    item = new ListItems("square", String.valueOf(scolor));
                    items.add(item);
                    break;
                case 2:
                    item = new ListItems("circle", String.valueOf(ccolor));
                    items.add(item);
                    break;
                case 3:
                    item = new ListItems("circle", String.valueOf(ccolor));
                    items.add(item);
                    break;
                default:
                    break;
            }
        }
    }
    public void colorDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.color_dialog);
        final View main_circle, circle1, circle2, circle3, main_square, square1, square2, square3;
        final TextView ok;
        main_circle = (View) dialog.findViewById(R.id.main_circle);
        final int color;
        switch (ccolor) {
            case 1:
                color = Color.parseColor("#1e88e5");
                break;
            case 2:
                color = Color.parseColor("#ff8a65");
                break;
            case 3:
                color = Color.parseColor("#26a69a");
                break;
            default:
                color = Color.parseColor("#26a69a");
                break;
        }
        ((GradientDrawable) main_circle.getBackground()).setColor(color);
        circle1 = (View) dialog.findViewById(R.id.circle1);
        circle2 = (View) dialog.findViewById(R.id.circle2);
        circle3 = (View) dialog.findViewById(R.id.circle3);
        ((GradientDrawable) circle1.getBackground()).setColor(Color.parseColor("#1e88e5"));
        ((GradientDrawable) circle2.getBackground()).setColor(Color.parseColor("#ff8a65"));
        ((GradientDrawable) circle3.getBackground()).setColor(Color.parseColor("#26a69a"));
        circle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((GradientDrawable) main_circle.getBackground()).setColor(Color.parseColor("#1e88e5"));
                ccolor = 1;
            }
        });
        circle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((GradientDrawable) main_circle.getBackground()).setColor(Color.parseColor("#ff8a65"));
                ccolor = 2;
            }
        });
        circle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((GradientDrawable) main_circle.getBackground()).setColor(Color.parseColor("#26a69a"));
                ccolor = 3;
            }
        });
        main_square = (View) dialog.findViewById(R.id.main_square);
        final int color1;
        switch (scolor) {
            case 1:
                main_square.setBackgroundResource(R.color.colorPrimary);
                break;
            case 2:
                main_square.setBackgroundResource(R.color.colorAccent);
                break;
            case 3:
                main_square.setBackgroundResource(R.color.fourth);
                break;
            default:
                main_square.setBackgroundResource(R.color.colorPrimary);
                break;
        }
        square1 = (View) dialog.findViewById(R.id.square1);
        square2 = (View) dialog.findViewById(R.id.square2);
        square3 = (View) dialog.findViewById(R.id.square3);
        square1.setBackgroundResource(R.color.colorPrimary);
        square2.setBackgroundResource(R.color.colorAccent);
        square3.setBackgroundResource(R.color.fourth);
        square1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_square.setBackgroundResource(R.color.colorPrimary);
                scolor = 1;
            }
        });
        square2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_square.setBackgroundResource(R.color.colorAccent);
                scolor = 2;
            }
        });
        square3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_square.setBackgroundResource(R.color.fourth);
                scolor = 3;
            }
        });
        ok = (TextView) dialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareItemsData(items.size());
                list_adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    public void itemsDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.seekbar_dialog);
        final SeekBar seekbar;
        final TextView ok, notext;
        ok = (TextView) dialog.findViewById(R.id.ok1);
        notext = (TextView) dialog.findViewById(R.id.textno);
        seekbar = (SeekBar) dialog.findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Toast.makeText(getApplicationContext(),"items selected: "+i*10, Toast.LENGTH_SHORT).show();
                notext.setText("Selection: " + String.valueOf(i * 10));
                total_items = i * 10;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareItemsData(total_items);
                list_adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    private void itemDes(int pos) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.shape_dec);
        final View color;
        final TextView des;
        des = (TextView) dialog.findViewById(R.id.details);
        color = (View) dialog.findViewById(R.id.color);
        des.setText("Position: " + String.valueOf(pos + 1) + " Shape: " + items.get(pos).getShape() + " Color: ");
        if (!items.get(pos).getShape().equals("plain")) {
            switch (Integer.valueOf(items.get(pos).getColor())) {
                case 1:
                    color.setBackgroundResource(R.color.colorPrimary);
                    break;
                case 2:
                    color.setBackgroundResource(R.color.colorAccent);
                    break;
                case 3:
                    color.setBackgroundResource(R.color.fourth);
                    break;
                default:
                    color.setBackgroundResource(R.color.colorPrimary);
                    break;

            }
        }else{
            des.setText("Position: " + String.valueOf(pos + 1) + " Shape: " + items.get(pos).getShape() + " Color: Grey");
        }
        dialog.show();
    }
}
