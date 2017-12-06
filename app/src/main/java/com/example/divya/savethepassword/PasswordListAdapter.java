package com.example.divya.savethepassword;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divya.savethepassword.Database.Password;

import java.util.List;

/**
 * Created by divya on 12/5/2017.
 */

public class PasswordListAdapter extends RecyclerView.Adapter<PasswordListAdapter.MyViewHolder> {

    private List<Password> passwordList;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView passwordName;
        public MyViewHolder(View itemView) {
            super(itemView);
            passwordName = (TextView) itemView.findViewById(R.id.passwordname);
        }
    }

    public PasswordListAdapter(List<Password> passwordList)
    {
        this.passwordList = passwordList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_password_row, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Password pwd = passwordList.get(position);
        holder.passwordName.setText(pwd.getName());
    }

    @Override
    public int getItemCount() {
        return passwordList != null ? passwordList.size(): 0;
    }
}
