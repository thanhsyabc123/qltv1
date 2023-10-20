package com.example.quanlythuvien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "PNLIB";
    private static final int DB_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    static final String CREATE_TABLE_NAME_THU_THU =
            "CREATE TABLE ThuThu (maTT TEXT PRIMARY KEY, " +
                    "hoTen TEXT NOT NULL, " +
                    "matKhau TEXT NOT NULL)";
    static final String CREATE_TABLE_NAME_THANH_VIEN =
            "CREATE TABLE ThanhVien (\n" +
                    "maTV    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "hoTen   TEXT NOT NULL," +
                    "namSinh TEXT NOT NULL" +
                    ")";
    static final String CREATE_TABLE_NAME_LOAI_SACH =
            "CREATE TABLE LoaiSach (\n" +
                    "maLoai  INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "tenLoai TEXT NOT NULL\n" +
                    ")";
    static final String CREATE_TABLE_NAME_SACH =
            "CREATE TABLE Sach (\n" +
                    "maSach  INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "tenSach TEXT    NOT NULL,\n" +
                    "giaThue INTEGER NOT NULL,\n" +
                    "maLoai  INTEGER REFERENCES LoaiSach (maLoai) \n" +
                    ")";
    static final String CREATE_TABLE_PHIEU_MUON =
            "CREATE TABLE PhieuMuon (\n" +
                    "    maPM     INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    maTT     TEXT    REFERENCES ThuThu (maTT),\n" +
                    "    maTV     Integer    REFERENCES ThanhVien (maTV),\n" +
                    "    masach   INTEGER REFERENCES Sach (masach),\n" +
                    "    tienthue INTEGER NOT NULL,\n" +
                    "    ngay     DATE    NOT NULL,\n" +
                    "    traSach  INTEGER NOT NULL\n" +
                    ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NAME_THU_THU);
        db.execSQL(CREATE_TABLE_NAME_THANH_VIEN);
        db.execSQL(CREATE_TABLE_NAME_LOAI_SACH);
        db.execSQL(CREATE_TABLE_NAME_SACH);
        db.execSQL(CREATE_TABLE_PHIEU_MUON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropTableloaiThuThu = "drop table if exists ThuThu";
        db.execSQL(dropTableloaiThuThu);
        String dropTableThanhVien = "drop table if exists ThanhVien";
        db.execSQL(dropTableThanhVien);
        String dropTableloaiSach = "drop table if exists LoaiSach";
        db.execSQL(dropTableloaiSach);
        String dropTableSach = "drop table if exists Sach";
        db.execSQL(dropTableSach);
        String dropTablePhieuMuon = "drop table if exists PhieuMuon";
        db.execSQL(dropTablePhieuMuon);

        onCreate(db);
    }
}
