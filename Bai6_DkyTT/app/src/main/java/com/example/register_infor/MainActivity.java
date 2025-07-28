package com.example.register_infor;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editHoten, editCMND, editBosung;
    RadioButton rdoTC, rdoCD, rdoDH;
    CheckBox chkdocbao, chkdocsach, chkdoccoding;
    Button btnguitt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần
        editHoten = findViewById(R.id.editHoten);
        editCMND = findViewById(R.id.editCMND);
        editBosung = findViewById(R.id.editBosung);

        rdoTC = findViewById(R.id.rdoTC);
        rdoCD = findViewById(R.id.rdoCD);
        rdoDH = findViewById(R.id.rdoDH);

        chkdocbao = findViewById(R.id.chkdocbao);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkdoccoding = findViewById(R.id.chkdoccoding);

        btnguitt = findViewById(R.id.btnguitt);

        btnguitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienThiThongTin();
            }
        });
    }

    private void hienThiThongTin() {
        String hoten = editHoten.getText().toString().trim();
        String cmnd = editCMND.getText().toString().trim();
        String bosung = editBosung.getText().toString().trim();

        String bangcap = "";
        if (rdoTC.isChecked()) bangcap = "Trung cấp";
        else if (rdoCD.isChecked()) bangcap = "Cao đẳng";
        else if (rdoDH.isChecked()) bangcap = "Đại học";

        String sothich = "";
        if (chkdocbao.isChecked()) sothich += "Đọc báo; ";
        if (chkdocsach.isChecked()) sothich += "Đọc sách; ";
        if (chkdoccoding.isChecked()) sothich += "Đọc coding; ";
        if (sothich.isEmpty()) sothich = "Không có";

        String thongtin = "Họ tên: " + hoten + "\n" +
                "CMND: " + cmnd + "\n" +
                "Bằng cấp: " + bangcap + "\n" +
                "Sở thích: " + sothich + "\n" +
                "Thông tin bổ sung: " + bosung;

        // Hiển thị AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setMessage(thongtin);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    // Xác nhận thoát khi nhấn nút Back
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận");
        builder.setMessage("Bạn có chắc chắn muốn thoát?");
        builder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Thoát app
            }
        });
        builder.setNegativeButton("Không", null);
        builder.show();
    }
}
