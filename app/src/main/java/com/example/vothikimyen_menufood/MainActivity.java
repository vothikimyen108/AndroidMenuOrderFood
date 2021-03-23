package com.example.vothikimyen_menufood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int loaip = 0;
    double priceP, priceTS;
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
        CheckedChange();
        SoLuongPizza();
        SoLuongTraSua();
        LamLai();
        DatHang();
        edMaGiamGia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Price();
            }
        });
    }


    //mapping voi uisss
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
        btTruTS = findViewById(R.id.truTraSua);
        btTangTS = findViewById(R.id.tangTraSua);
        edSLPizza = findViewById(R.id.editSoLuongPizza);
        edSLTraSua = findViewById(R.id.editSoLuongTraSua);
        edMaGiamGia = findViewById(R.id.edMaGiamGia);
        txtsoTienDuocGiam = findViewById(R.id.txtGiamGia);
        txtTong = findViewById(R.id.txtTong);
        rgLoai = findViewById(R.id.rgLoai);
        rgSize = findViewById(R.id.rgSize);

    }
    private void CheckedChange() {
        cbThemThach.setOnCheckedChangeListener(this::OnCheckedChange);
        cbThemPudding.setOnCheckedChangeListener(this::OnCheckedChange);
        cbThemThach.setOnCheckedChangeListener(this::OnCheckedChange);
        cbThemNam.setOnCheckedChangeListener(this::OnCheckedChange);
        cbThemPhomai.setOnCheckedChangeListener(this::OnCheckedChange);
        cbThemXiuMai.setOnCheckedChangeListener(this::OnCheckedChange);
    }
    private void OnCheckedChange(CompoundButton buttonView, boolean isCheck){
        int id = buttonView.getId();
        if(isCheck){
            switch(id) {
                case R.id.themNam:
                    priceP +=20000;
                    Price();
                    break;
                case R.id.themTranChau:
                    priceTS +=10000;
                    Price();
                    break;
                case R.id.themPhoMai:
                    priceP +=20000;
                    Price();
                    break;
                case R.id.themThach:
                    priceTS +=10000;
                    Price();
                    break;
                case R.id.themPudding:
                    priceTS +=10000;
                    Price();
                    break;
                case R.id.themXiuMai:
                    priceP +=20000;
                    Price();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + id);
            }
        }else {
            switch(id) {
                case R.id.themNam:
                    priceP -=20000;
                    Price();
                    break;
                case R.id.themTranChau:
                    priceTS -=10000;
                    Price();
                    break;
                case R.id.themPhoMai:
                    priceP -=20000;
                    Price();
                    break;
                case R.id.themThach:
                    priceTS -=10000;
                    Price();
                    break;
                case R.id.themPudding:
                    priceTS -=10000;
                    Price();
                    break;
                case R.id.themXiuMai:
                    priceP -=20000;
                    Price();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + id);
            }
        }
    }
    private void Price() {
        double price = 0;
        double totalPriceP = 0;
        double totalPriceTs = 0;
        double price1 = 140000, price2 = 45000;
        double dc = GiamGia();
        if(countP>0)
            totalPriceP = (priceP+loaip+price1)*countP;
        if(countTs>0)
            totalPriceTs = (priceTS+price2)*countTs;
        price = (totalPriceP+totalPriceTs);
        txtsoTienDuocGiam.setText("Số tiền giảm: "+String.valueOf(dc*price));
        txtTong.setText("Tổng hóa đơn: "+String.valueOf(Math.round(price*(1))));
    }
    private double GiamGia() {
        double dc =0;
            String dis = edMaGiamGia.getText().toString().toLowerCase();
            if (dis.equals("EnCute"))
                dc = 0.2;
            else if (dis.equals("108")) {
                dc = 0.5;
            } else dc = 0;
        return dc;
    }
    private void SoLuongPizza() {
        btTangP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countP = Integer.parseInt(edSLPizza.getText().toString());
                countP++;
                edSLPizza.setText(String.valueOf(countP));
                Price();
            }
        });
        btTruP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countP = Integer.parseInt(edSLPizza.getText().toString());
                if(countP>0)
                    countP--;
                edSLPizza.setText(String.valueOf(countP));
                Price();
            }
        });
    }
    private void SoLuongTraSua() {
        btTangTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTs = Integer.parseInt(edSLTraSua.getText().toString());
                countTs++;
                edSLTraSua.setText(String.valueOf(countTs));
                Price();
            }
        });
        btTruTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTs = Integer.parseInt(edSLTraSua.getText().toString());
                if(countTs>0)
                    countTs--;
                edSLTraSua.setText(String.valueOf(countTs));
                Price();
            }
        });
    }
    private void LamLai() {
        btLamLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Price();
                cbThemNam.setChecked(false);
                cbThemPhomai.setChecked(false);
                cbThemThach.setChecked(false);
                cbThemPudding.setChecked(false);
                cbThemTranChau.setChecked(false);
                cbThemXiuMai.setChecked(false);
                btPGa.setChecked(false);
                btPHaiSan.setChecked(false);
                btTruyenThong.setChecked(false);
                btSNho.setChecked(false);
                btSTrungBinh.setChecked(false);
                btSLon.setChecked(false);
                edSLTraSua.setText("0");
                edSLPizza.setText("0");
                txtsoTienDuocGiam.setText("");
                txtTong.setText("");
                edMaGiamGia.setText("  ");
            }
        });
    }
    private void DatHang() {
        btDatHangNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Price();
                Toast.makeText(getApplicationContext(),"Đặt hàng thành công!!!",Toast.LENGTH_LONG).show();
            }
        });
    }
}



