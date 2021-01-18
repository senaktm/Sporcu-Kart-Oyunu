package projeodevi;

public class Bilgisayar extends Oyuncu {

    public int rastgele;
    private int kartlariKaristirBasketbol;
    private int kartlariKaristirFutbol;

    public Bilgisayar() {

    }

    public Bilgisayar(String oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

    public int kartSec(String a) {
        if (a.equals("b")) {
            rastgele = basketbolcuSec();
        } else if (a.equals("f")) {
            rastgele = futbolcuSec();
        }

        return rastgele;
    }

    public int basketbolcuSec() {
        boolean kullanildimi = true;
        Basketbolcu a1 = new Basketbolcu();
        Oyuncu oyun = new Oyuncu();
        int[] kullaniciKartlari;
        while (kullanildimi) {
            kartlariKaristirBasketbol = (int) (Math.random() * 8);
            kullaniciKartlari = oyun.kartListesi();
            kullanildimi = a1.kartKullanildiMi(kartlariKaristirBasketbol);
            for (int i : kullaniciKartlari) {
                if (i == kartlariKaristirBasketbol+8) {
                    kullanildimi = true;
                }
            }

        }

        return kartlariKaristirBasketbol;

    }

    public int futbolcuSec() {
        boolean kullanildimi = true;
        Futbolcu a1 = new Futbolcu();
        int[] kullaniciKartlari;
        Oyuncu oyun = new Oyuncu();
        while (kullanildimi) {
            kartlariKaristirFutbol = (int) (Math.random() * 8);
            kullaniciKartlari = oyun.kartListesi();
            kullanildimi = a1.kartKullanildiMi(kartlariKaristirFutbol);
            for (int i : kullaniciKartlari) {
                if (i == kartlariKaristirFutbol) {
                    kullanildimi = true;
                }
            }
        }

        return kartlariKaristirFutbol;

    }
}
