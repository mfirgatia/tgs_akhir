package org.aplas.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.aplas.myapplication.Model.BankSoal;
import org.aplas.myapplication.R;

public class AdapterBankSoal extends RecyclerView.Adapter<AdapterBankSoal.ViewHolder> {
    BankSoal bank_soal;
    Context context;

    public AdapterBankSoal(BankSoal bank_soal, Context context) {
        this.bank_soal = bank_soal;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterBankSoal.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_banksoal, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBankSoal.ViewHolder holder, int position) {
        holder.mapel.setText(bank_soal.getData()[position].getMapel());
        holder.soal.setText("Soal : " +bank_soal.getData()[position].getSoal());
    }

    @Override
    public int getItemCount() {
        return bank_soal.getData().length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView soal, mapel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mapel = itemView.findViewById(R.id.txtMapel);
            soal = itemView.findViewById(R.id.txtSoal);
        }
    }
}
