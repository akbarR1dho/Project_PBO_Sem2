/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bioskop;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author dHooF15
 */
public class Ambacinema {

    private Map<String, Set<String>> kursiTerpesan = new HashMap<>();

    public boolean isKursiTerpesan(String film, String jam, String kursi) {
        return kursiTerpesan.getOrDefault(film + "-" + jam, new HashSet<>()).contains(kursi);
    }

    public void pesanKursi(String film, String jam, List<String> daftarKursi) {
        String key = film + "-" + jam;
        kursiTerpesan.putIfAbsent(key, new HashSet<>());
        kursiTerpesan.get(key).addAll(daftarKursi);
    }

    public List<String> getJamTayangValid(String[] semuaJam) {
        List<String> jamValid = new ArrayList<>();
        LocalTime sekarang = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        for (String jam : semuaJam) {
            try {
                LocalTime waktuTayang = LocalTime.parse(jam, formatter);
                if (waktuTayang.isAfter(sekarang)) {
                    jamValid.add(jam);
                }
            } catch (Exception e) { /* mengabaikan format salah */ }
        }
        return jamValid;
    }

}
