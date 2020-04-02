package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSP.getLocal());

        ImageView imageView = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacoteSP.getImagem());
        imageView.setImageDrawable(drawable);

        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasTexto = DiasUtil.formataEmTexto(pacoteSP.getDias());
        dias.setText(diasTexto);

        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String precoReal = MoedaUtil.formataParaBrasileiro(pacoteSP.getPreco());

        preco.setText(precoReal);

    }
}
