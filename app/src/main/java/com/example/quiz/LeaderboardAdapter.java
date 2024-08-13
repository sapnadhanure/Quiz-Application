package com.example.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quiz.databinding.RowLeaderboardBinding;

import java.util.ArrayList;

public class LeaderboardAdapter extends  RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>{
    Context context;
    ArrayList<User>users;
    public LeaderboardAdapter(Context context, ArrayList<User>users){
        this.context= context;
        this.users= users;
    }
    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_leaderboard,parent,false);
        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        User user= users.get(position);
        holder.binding.namee.setText(user.getName());
        holder.binding.coinss.setText(String.valueOf(user.getCoins()));
        holder.binding.index.setText(String.format("#%d",position+1));

        Glide.with(context)
                .load(user.getProfile())
                .into(holder.binding.profile);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public  class LeaderboardViewHolder extends RecyclerView.ViewHolder{

        RowLeaderboardBinding binding;

        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= RowLeaderboardBinding.bind(itemView);

        }
    }
}
