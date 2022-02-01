package com.example.bdtrunsport.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdtrunsport.Buslist;
import com.example.bdtrunsport.R;

import java.util.ArrayList;

public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.MyViewHolder> implements Filterable {

    Context context;
    ArrayList<Buslist> BusListArray;
    ArrayList<Buslist> BusListArrayFull;

    public BusListAdapter(Context context, ArrayList<Buslist> busListArray) {
        this.context = context;
        this.BusListArrayFull = busListArray;
        this.BusListArray = new ArrayList<>(BusListArrayFull);
    }

    @NonNull
    @Override
    public BusListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.buslist,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BusListAdapter.MyViewHolder holder, int position) {
        Buslist buslist = BusListArray.get(position);

        holder.BusName.setText(buslist.BusName);
        holder.BriefRoutes.setText(buslist.BriefRoutes);


    }

    @Override
    public int getItemCount() {
        return BusListArray.size();
    }

    @Override
    public Filter getFilter() {
        return busListFilter;
    }

    private  final  Filter busListFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Buslist>filterBusList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){

                filterBusList.addAll(BusListArrayFull);

            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Buslist buslist : BusListArrayFull){
                    if (buslist.BusName.toLowerCase().contains(filterPattern)) {
                        filterBusList.add(buslist);
                    }else if (buslist.BriefRoutes.toLowerCase().contains(filterPattern)){
                        filterBusList.add(buslist);
                    }
                }

            }
            FilterResults results = new FilterResults();
            results.values = filterBusList;
            results.count = filterBusList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            BusListArray.clear();
            BusListArray.addAll((ArrayList)results.values);
            notifyDataSetChanged();

        }
    };

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView BusName;
        TextView BriefRoutes;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            BusName = itemView.findViewById(R.id.BusName);
            BriefRoutes = itemView.findViewById(R.id.BriefRoutes);


        }
    }
}
