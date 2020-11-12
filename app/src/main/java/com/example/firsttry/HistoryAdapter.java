package com.example.firsttry;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class HistoryAdapter extends   RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>  {
    private ArrayList<HistoryItem> history;
    HistoryAdapter(){
        history = new ArrayList<>();
    }
    void initialize(ArrayList<HistoryItem> history){
        this.history = history;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.history_list_item, viewGroup, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder historyItemViewHolder, int i) {
        historyItemViewHolder.bind(history.get(i));
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder{
      private   TextView listItemHistoryView;
      private LinearLayout colorBlock;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemHistoryView=itemView.findViewById(R.id.tv_history_item);
           colorBlock=itemView.findViewById(R.id.colorBlock);

            }
        void bind(HistoryItem historyItem) {
            listItemHistoryView.setText(historyItem.getTextRepresentation());
            colorBlock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(colorBlock.getContext(), "Пора покормить кота!", Toast.LENGTH_SHORT).show();
                }
            });
            if(historyItem.getA().equals("")) {
                int R = Integer.parseInt(historyItem.getR());
                int G = Integer.parseInt(historyItem.getG());
                int B = Integer.parseInt(historyItem.getB());
                Paint.changeBackGroundColor(colorBlock,R, G, B);
            }
            else
            {
                int A = Integer.parseInt(historyItem.getA());
                int R = Integer.parseInt(historyItem.getR());
                int G = Integer.parseInt(historyItem.getG());
                int B = Integer.parseInt(historyItem.getB());
                Paint.changeBackGroundColor(colorBlock,A,R, G, B);
            }

        }
        }

    }




/*
    class HistoryItemViewHolder extends RecyclerView.ViewHolder {

        private TextView historyText;
        private Button historyButton;

        HistoryItemViewHolder(View itemView) {
            super(itemView);
            historyText = itemView.findViewById(R.id.history_text);
            historyButton = itemView.findViewById(R.id.history_button);
        }


    }*/
