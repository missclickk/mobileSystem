package com.example.firsttry.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firsttry.viewmodel.Paint;
import com.example.firsttry.R;
import com.example.firsttry.model.HistoryDB;

import java.util.ArrayList;



public class HistoryAdapter extends   RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>  {
    private ArrayList<HistoryDB> history;
    HistoryAdapter(){
        history = new ArrayList<>();
    }
    void initialize(ArrayList<HistoryDB> history){
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
      private Button negativeButton;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemHistoryView=itemView.findViewById(R.id.tv_history_item);
           colorBlock=itemView.findViewById(R.id.colorBlock);

            }
        void bind(final HistoryDB historyDB) {
            listItemHistoryView.setText(historyDB.getTextRepresentation());

            if(historyDB.getA().equals("")) {
                int R = Integer.parseInt(historyDB.getR());
                int G = Integer.parseInt(historyDB.getG());
                int B = Integer.parseInt(historyDB.getB());
                Paint.changeBackGroundColor(colorBlock,R, G, B);
            }
            else
            {
                int A = Integer.parseInt(historyDB.getA());
                int R = Integer.parseInt(historyDB.getR());
                int G = Integer.parseInt(historyDB.getG());
                int B = Integer.parseInt(historyDB.getB());
                Paint.changeBackGroundColor(colorBlock,A,R, G, B);
            }
            negativeButton=itemView.findViewById(R.id.negative);
            negativeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        int R = Integer.parseInt(historyDB.getR());
                        int G = Integer.parseInt(historyDB.getG());
                        int B = Integer.parseInt(historyDB.getB());
                        //System.out.println(R);
                        Paint.changeBackGroundColor(colorBlock,255-R, 255-G, 255-B);
                }
            });
        }
        }

    }




