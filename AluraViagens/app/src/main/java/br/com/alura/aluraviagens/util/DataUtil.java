package br.com.alura.aluraviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);

        SimpleDateFormat formatoBrasileiroData = new SimpleDateFormat(DIA_MES);
        String dataFormatadaIda = formatoBrasileiroData.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBrasileiroData.format(dataVolta.getTime());

        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
    }
}
