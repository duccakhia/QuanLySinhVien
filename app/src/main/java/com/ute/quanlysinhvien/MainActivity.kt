package com.ute.quanlysinhvien

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import com.ute.quanlysinhvien.R
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var edtHoTen: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtSdt: EditText
    private lateinit var edtMsv: EditText
    private lateinit var edtLop: EditText
    private lateinit var btnDangKy: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Anh xa cac view
        edtHoTen = findViewById(R.id.edtHoTen)
        edtEmail = findViewById(R.id.edtEmail)
        edtSdt = findViewById(R.id.edtSdt)
        edtMsv = findViewById(R.id.edtMsv)
        edtLop = findViewById(R.id.edtLop)
        btnDangKy = findViewById(R.id.btnDangKy)

        btnDangKy.setOnClickListener {
            dangKy()
        }
    }

    private fun dangKy() {
        val hoTen = edtHoTen.text.toString().trim()
        val email = edtEmail.text.toString().trim()
        val sdt = edtSdt.text.toString().trim()
        val msv = edtMsv.text.toString().trim()
        val lop = edtLop.text.toString().trim()

        // 1. Kiem tra ho ten
        if (hoTen.isEmpty()) {
            edtHoTen.error = "Vui long nhap ho ten"
            edtHoTen.requestFocus()
            return
        }

        if (!hoTen.matches(
                Regex("^[\\p{L}][\\p{L}\\s'.-]{1,49}$")
            )
        ) {
            edtHoTen.error = "Ho ten khong hop le"
            edtHoTen.requestFocus()
            return
        }

        // 2. Kiem tra email
        if (email.isEmpty()) {
            edtEmail.error = "Vui long nhap email"
            edtEmail.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error = "Email khong dung dinh dang"
            edtEmail.requestFocus()
            return
        }

        // 3. Kiem tra so dien thoai
        if (sdt.isEmpty()) {
            edtSdt.error = "Vui long nhap so dien thoai"
            edtSdt.requestFocus()
            return
        }

        if (!sdt.matches(Regex("^0\\d{9}$"))) {
            edtSdt.error = "SDT phai co 10 chu so, bat dau bang 0"
            edtSdt.requestFocus()
            return
        }

        // 4. Kiem tra MSV
        if (msv.isEmpty()) {
            edtMsv.error = "Vui long nhap MSV"
            edtMsv.requestFocus()
            return
        }

        if (!msv.matches(Regex("^[A-Za-z0-9]{5,15}$"))) {
            edtMsv.error = "MSV phai co 5-15 ky tu chu hoac so"
            edtMsv.requestFocus()
            return
        }

        // 5. Kiem tra lop
        if (lop.isEmpty()) {
            edtLop.error = "Vui long nhap lop"
            edtLop.requestFocus()
            return
        }

        if (!lop.matches(
                Regex("^[\\p{L}0-9][\\p{L}0-9 ._-]{1,19}$")
            )
        ) {
            edtLop.error = "Ten lop khong hop le"
            edtLop.requestFocus()
            return
        }

        // 6. Tat ca hop le: hien Snackbar
        Snackbar.make(
            findViewById(android.R.id.content),
            "Dang ki thanh cong!",
            Snackbar.LENGTH_LONG
        ).setAction("CHI TIẾT") {

            // Gui du lieu sang DetailActivity
            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("HOTEN", hoTen)
            intent.putExtra("EMAIL", email)
            intent.putExtra("SDT", sdt)
            intent.putExtra("MSV", msv)
            intent.putExtra("LOP", lop)

            startActivity(intent)
        }.show()
    }
}
