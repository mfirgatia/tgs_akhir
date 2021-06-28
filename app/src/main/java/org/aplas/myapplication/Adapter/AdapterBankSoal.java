package org.aplas.myapplication.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import org.aplas.myapplication.Model.BankSoal;
import org.aplas.myapplication.R;

public class AdapterBankSoal<pu> extends RecyclerView.Adapter<AdapterBankSoal.ViewHolder> {
    BankSoal bank_soal;
    Context context;

    String kunci;
    String A,B,C,D,E;

    public AdapterBankSoal(BankSoal bank_soal, Context context) {
        this.bank_soal = bank_soal;
        this.context = context;
    }
    private static final String[] Jawaban = new String[]{
            "A","B","C","D","E"
    };

    private String radioButtom;

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
        kunci = bank_soal.getData()[position].getKunci();
        A = bank_soal.getData()[position].getPilihan_a();
        B = bank_soal.getData()[position].getPilihan_b();
        C = bank_soal.getData()[position].getPilihan_c();
        D = bank_soal.getData()[position].getPilihan_d();
        E = bank_soal.getData()[position].getPilihan_e();
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if(id == R.id.btnJawab){
                    radioButtom = Jawaban[0];
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Pertanyaan");
                    builder.setSingleChoiceItems(Jawaban, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            radioButtom = Jawaban[i];
                        }
                    });
                    builder.setPositiveButton("Jawab", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Snackbar.make(view, "Benar: " + kunci, Snackbar.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("Batal", null);
                    builder.show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bank_soal.getData().length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView soal, mapel;
        Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mapel = itemView.findViewById(R.id.txtMapel);
            soal = itemView.findViewById(R.id.txtSoal);
            btn = itemView.findViewById(R.id.btnJawab);

        }
    }
}
