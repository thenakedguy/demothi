package com.example.hngdng.demothi;

import android.provider.BaseColumns;

public class SinhVien {
    public String TenSinhVien,MaSinhVien;

    public SinhVien() {
    }

    public SinhVien(String tenSinhVien, String maSinhVien) {
        TenSinhVien = tenSinhVien;
        MaSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return TenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        TenSinhVien = tenSinhVien;
    }

    public String getMaSinhVien() {
        return MaSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        MaSinhVien = maSinhVien;
    }

    public static final class SinhVienEntry implements BaseColumns {
        public static final String TABLE_NAME = "sinhVien";
        public static final String COL_ID = "ID";
        public static final String COL_MASV= "MaSV";
        public static final String COL_TENSV = "TenSV";
    }
}
