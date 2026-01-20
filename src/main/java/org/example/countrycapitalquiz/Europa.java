package org.example.countrycapitalquiz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.Normalizer;
import java.util.Random;

public class Europa {

    private final String country;
    private final String capital;

    public Europa() {
        try {
            final String url = "https://mein-lernen.at/geographie-ueberblick/europa6/europa-lander-mit-hauptstadten/";
            Document doc = Jsoup.connect(url).get();
            Element table = doc.select(".wikitable.sortable.jquery-tablesorter").first();
            Elements rows = table.select("tbody").select("tr");

            Random random = new Random();
            int randumNum = random.nextInt(rows.size() - 1);

            Element selectedRow = rows.get(randumNum);
            Elements tds = selectedRow.select("td");

            if (tds.size() >= 2) {
                tds.remove(0);
                tds.remove(tds.size() - 1);
            }

            this.country = Europa.flattenToAscii(tds.get(0).text());
            this.capital = Europa.flattenToAscii(tds.get(1).text());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String flattenToAscii(String text) {
        if (text == null) return "";

        // Zerlegt Sonderzeichen (z.B. ș -> s + cedilla)
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);

        // Entfernt alle "Markierungen" (die Akzente/Cedillen), sodass nur Basis-ASCII bleibt
        return normalized.replaceAll("\\p{M}", "");
    }


    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

}
