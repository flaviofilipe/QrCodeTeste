package br.com.redewsouza.qrcodeteste;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GeneratorActivity extends AppCompatActivity {

    EditText edtCode;
    Button btnGerar;
    ImageView imgCode;
    String txtQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        edtCode = (EditText) findViewById(R.id.edt_cod);
        btnGerar = (Button) findViewById(R.id.btn_gerar);
        imgCode = (ImageView) findViewById(R.id.img_code);

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtQr = edtCode.getText().toString().trim();
                if (!txtQr.equals("")) {
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    try {
                        //Cria QR Code com tamanho 500
                        BitMatrix bitMatrix = multiFormatWriter.encode(txtQr, BarcodeFormat.QR_CODE, 500, 500);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                        //Insere no campo img
                        imgCode.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(GeneratorActivity.this,"Insira o conteudo do código",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
