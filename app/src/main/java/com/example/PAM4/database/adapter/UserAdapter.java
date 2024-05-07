package com.example.PAM4.database.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.PAM4.R;
import com.example.PAM4.database.entitas.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewAdapter>{
    private List<User> list;
    private Context context;

    public UserAdapter( Context context,List<User> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.fullName.setText(list.get(position).fullName);
        holder.nim.setText(list.get(position).nim);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView fullName , nim;
        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.full_name);
            nim = itemView.findViewById(R.id.nim);
        }
    }
}
