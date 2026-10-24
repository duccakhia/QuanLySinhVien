package com.ute.quanlysinhvien


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ute.quanlysinhvien.R
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var tvHoTen: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvSdt: TextView
    private lateinit var tvMsv: TextView
    private lateinit var tvLop: TextView
    private lateinit var btnQuayLai: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Anh xa view
        tvHoTen = findViewById(R.id.tvHoTen)
        tvEmail = findViewById(R.id.tvEmail)
        tvSdt = findViewById(R.id.tvSdt)
        tvMsv = findViewById(R.id.tvMsv)
        tvLop = findViewById(R.id.tvLop)
        btnQuayLai = findViewById(R.id.btnQuayLai)

        // Nhan du lieu tu Intent
        val hoTen = intent.getStringExtra("HOTEN") ?: ""
        val email = intent.getStringExtra("EMAIL") ?: ""
        val sdt = intent.getStringExtra("SDT") ?: ""
        val msv = intent.getStringExtra("MSV") ?: ""
        val lop = intent.getStringExtra("LOP") ?: ""

        // Hien thi thong tin
        tvHoTen.text = "Họ tên: $hoTen"
        tvEmail.text = "Email: $email"
        tvSdt.text = "Số điện thoại: $sdt"
        tvMsv.text = "MSV: $msv"
        tvLop.text = "Lớp: $lop"

        // Quay lai man hinh dang ki
        btnQuayLai.setOnClickListener {
            finish()
        }
    }
}
