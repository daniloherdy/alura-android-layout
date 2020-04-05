package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);

        Pacote pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraLocal(pacoteSP);
        mostraImagem(pacoteSP);
        mostraPeriodo(pacoteSP);
        mostraPreco(pacoteSP);
    }

    private void mostraPreco(Pacote pacoteSP) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        preco.setText(MoedaUtil.formataParaBrasileiro(pacoteSP.getPreco()));
    }

    private void mostraPeriodo(Pacote pacote) {
        TextView periodo = findViewById(R.id.resumo_compra_periodo_pacote);
        periodo.setText(DataUtil.periodoEmTexto(pacote.getDias()));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        imagem.setImageDrawable(ResourceUtil.devolveDrawable(this, pacote.getImagem()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }
}
