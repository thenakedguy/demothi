package com.example.hngdng.demothi;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder> {
    private Context mContext;
    private Cursor mCursor;
    public SinhVienAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    @NonNull
    @Override
    public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item,parent,false);
        return new SinhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienViewHolder sinhVienViewHolder, int i) {
            if (!mCursor.moveToPosition(i)){
                return;
            }
            String maSV = mCursor.getString(mCursor.getColumnIndex(SinhVien.SinhVienEntry.COL_MASV));
            String tenSV = mCursor.getString(mCursor.getColumnIndex(SinhVien.SinhVienEntry.COL_TENSV));
            sinhVienViewHolder.tvMaSV.setText(maSV);
            sinhVienViewHolder.tvTenSV.setText(tenSV);
    }


    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
    public void swapCursor(Cursor newCursor){
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = newCursor;
        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
    public class SinhVienViewHolder extends RecyclerView.ViewHolder{
        public TextView tvMaSV, tvTenSV;

        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaSV = itemView.findViewById(R.id.tvMaSV);
            tvTenSV = itemView.findViewById(R.id.tvTenSV);
        }
    }
}
