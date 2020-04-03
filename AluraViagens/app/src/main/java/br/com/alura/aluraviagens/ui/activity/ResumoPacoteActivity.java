package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);

        Pacote pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraLocal(pacoteSP);

        mostraImagem(pacoteSP);

        mostraDias(pacoteSP);

        mostraPreco(pacoteSP);

        mostraPeriodo(pacoteSP);

    }

    private void mostraPeriodo(Pacote pacote) {
        TextView periodo = findViewById(R.id.resumo_pacote_periodo);
        String periodoFormatado = DataUtil.periodoEmTexto(pacote.getDias());
        periodo.setText(periodoFormatado);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String precoReal = MoedaUtil.formataParaBrasileiro(pacote.getPreco());

        preco.setText(precoReal);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imageView = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imageView.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
