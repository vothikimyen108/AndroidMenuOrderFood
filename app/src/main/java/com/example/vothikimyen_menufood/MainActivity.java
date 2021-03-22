package com.example.vothikimyen_menufood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int loaip = 0;
    double priceP, priceTS, price;
    int countP, countTs;
    //khai bao bien
    CheckBox cbThemNam, cbThemPhomai, cbThemXiuMai, cbThemTranChau, cbThemThach, cbThemPudding;
    RadioButton btPGa, btPHaiSan, btTruyenThong, btSNho, btSTrungBinh, btSLon;
    Button btTruP, btTangP, btTruTS, btTangTS, btDatHangNgay, btLamLai;
    EditText edSLPizza, edSLTraSua, edMaGiamGia;
    TextView txtsoTienDuocGiam, txtTong;
    RadioGroup rgLoai, rgSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
    }
    //mapping voi ui
    private void AnhXa() {
        cbThemNam = findViewById(R.id.themNam);
        cbThemPhomai = findViewById(R.id.themPhoMai);
        cbThemXiuMai = findViewById(R.id.themXiuMai);
        cbThemThach = findViewById(R.id.themThach);
        cbThemTranChau = findViewById(R.id.themTranChau);
        cbThemPudding = findViewById(R.id.themPudding);
        btPGa = findViewById(R.id.rbPizzaGa);
        btPHaiSan = findViewById(R.id.rbPizzaHaiSan);
        btTruyenThong = findViewById(R.id.rbPizzaTruyenThong);
        btSNho = findViewById(R.id.rbSizaNho);
        btSLon = findViewById(R.id.rbCoLon);
        btSTrungBinh = findViewById(R.id.rbSizeTrungBinh);
        btDatHangNgay = findViewById(R.id.btDatHang);
        btLamLai = findViewById(R.id.btLamlai);
        btTruP = findViewById(R.id.truPizza);
        btTangP = findViewById(R.id.tangPizaa);
        btTruP = findViewById(R.id.truTraSua);
        btTangTS = findViewById(R.id.tangTraSua);
        edSLPizza = findViewById(R.id.editSoLuongPizza);
        edSLTraSua = findViewById(R.id.editSoLuongTraSua);
        txtsoTienDuocGiam = findViewById(R.id.txtGiamGia);
        txtTong = findViewById(R.id.txtTong);
        rgLoai = findViewById(R.id.rgLoai);
        rgSize = findViewById(R.id.rgSize);

    }
    private void CheckedChange() {
        //cbThemThach.setOnCheckedChangeListener(this);
    }
    private  void OnCheckedChange(CompoundButton buttonView, boolean isCheck){
        int id = buttonView.getId();
        if(isCheck){
            switch(id) {
                case R.id.themNam:
                    priceP +=10000;
                    price();
                    break;
            }
        }
    }

    private void price() {
        double price = 0;
    }
}