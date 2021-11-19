package com.iete.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.iete.myapplication.Doctors;
import com.iete.myapplication.R;
import com.iete.myapplication.activity_appointment;
import com.iete.myapplication.activity_doctors_general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {
    private static Context context;
    private ArrayList<Doctors> docList;
    ArrayList<Doctors>docListAll;

    public RecyclerViewAdapter(Context context, ArrayList<Doctors> docList, ArrayList<Doctors> docListAll) {
        this.context = context;
        this.docList = docList;
        this.docListAll = docListAll;
    }



    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_name_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewAdapter.ViewHolder holder, int position) {

            Doctors doctor = docList.get(position);
            holder.Name.setText(doctor.getName());


    }

    @Override
    public int getItemCount() {
        return  docList.size();
    }



    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList filteredList = new ArrayList<Doctors>();

            if(constraint.toString().isEmpty()){
                filteredList.addAll(docList);
            }
            else{
                for(Doctors doctor : docListAll){
                    if(doctor.getName().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(doctor);
                    }
                }
            }
            FilterResults filteredResults = new FilterResults();
            filteredResults.values = filteredList;


            return filteredResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            docList.clear();
            docList.addAll((Collection<? extends Doctors>) results.values);
            notifyDataSetChanged();

        }
    };

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView Name;
        public ImageView iconButton;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            Name = itemView.findViewById(R.id.docNameCard);
            iconButton = itemView.findViewById(R.id.icon);

            iconButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("Click","Clicked");


            Intent intent = new Intent(context, activity_appointment.class);

            context.startActivity(intent);

        }
    }

}
