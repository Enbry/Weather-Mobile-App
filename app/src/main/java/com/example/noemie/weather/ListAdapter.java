package com.example.noemie.weather;

import android.support.v7. widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final ArrayList<City> values;
    private ListAdapter.OnClickListener listener;

    public ListAdapter(ArrayList<City> values, ListAdapter.OnClickListener listener){
        this.values = values;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ListAdapter.ViewHolder(inflater.inflate(R.layout.line_list, parent, false));
    }

    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {
        holder.city.setText(values.get(position).city);
        holder.region.setText(values.get(position).region);
    }

    public void removeAt(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView city, region;
        public ViewHolder(View itemView) {
            super(itemView);
            city = (TextView) itemView.findViewById(R.id.view1);
            region = (TextView) itemView.findViewById(R.id.view2);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null){
                int position = getAdapterPosition();
                listener.onClick(position, values.get(position));

            }
        }
    }

    public interface OnClickListener {
        void onClick(int position, City city);

    }
}
