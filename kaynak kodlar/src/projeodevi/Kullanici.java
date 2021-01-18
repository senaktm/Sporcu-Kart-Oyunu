package projeodevi;


public class Kullanici extends Oyuncu {

    public int rastgele;
    private int kartlariKaristirBasketbol;
    private int kartlariKaristirFutbol;

    public Kullanici() {
        super();

    }

    public Kullanici(String oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

    public int kartSec(String a) {
        if (a.equals("b")) 
            rastgele=basketbolcuSec();
        else if (a.equals("f")) 
            rastgele=futbolcuSec();

        return rastgele;
    }

    public int basketbolcuSec() {
        boolean kullanildimi = true;
        Basketbolcu a1 = new Basketbolcu();
        Oyuncu a = new Oyuncu();
        while (kullanildimi) {
            kartlariKaristirBasketbol = (int) (Math.random() * 8);
            kullanildimi = a1.kartKullanildiMi(kartlariKaristirBasketbol);
        }

        a.kartListesineEkle(kartlariKaristirBasketbol+8);

        return kartlariKaristirBasketbol;

    }

    public int futbolcuSec() {
        boolean kullanildimi = true;
        Futbolcu a1 = new Futbolcu();
        Oyuncu a = new Oyuncu();
        while (kullanildimi) {
            kartlariKaristirFutbol = (int) (Math.random() * 8);
            kullanildimi = a1.kartKullanildiMi(kartlariKaristirFutbol);
        }

        a.kartListesineEkle(kartlariKaristirFutbol);

        return kartlariKaristirFutbol;

    }
}
