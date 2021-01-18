package projeodevi;


public class Basketbolcu extends Sporcu {

    private int ikilik;
    private int ucluk;
    private int serbestAtis;
    private String basketbolcuAdi;
    private String basketbolcuTakim;
    private static int[] kullanimBilgisi = {-1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private static int sayac;

    public Basketbolcu() {
        super();
    }

    public Basketbolcu(String sporcuIsim, String sporcuTakim, int ikilik, int ucluk, int serbestAtis) {
        super(sporcuIsim, sporcuTakim);
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
        basketbolcuAdi=super.getSporcuIsim();
	basketbolcuTakim=super.getSporcuTakim();
    }

    public int getIkilik() {
        return ikilik;
    }

    public void setIkilik(int ikilik) {
        this.ikilik = ikilik;
    }

    public int getUcluk() {
        return ucluk;
    }

    public void setUcluk(int ucluk) {
        this.ucluk = ucluk;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
    }

    public String getBasketbolcuAdi() {
		return basketbolcuAdi;
	}


	public void setBasketbolcuAdi(String basketbolcuAdi) {
		this.basketbolcuAdi = basketbolcuAdi;
	}


	public String getBasketbolcuTakim() {
		return basketbolcuTakim;
	}


	public void setBasketbolcuTakim(String basketbolcuTakim) {
		this.basketbolcuTakim = basketbolcuTakim;
	}
        
    @Override
    public int sporcuPuaniGoster(String Ad, String pozisyon, int pozisyonDegeri) {

        if (pozisyon.equals("Ikilik")) {
            pozisyonDegeri = ikilik;
            return pozisyonDegeri;
        }
        if (pozisyon.equals("Serbest Atis")) {
            pozisyonDegeri = serbestAtis;
            return pozisyonDegeri;
        }
        if (pozisyon.equals("Ucluk")) {
            pozisyonDegeri = ucluk;
            return pozisyonDegeri;
        }
        return 0;

    }

    public boolean kartKullanildiMi(int basketbolcuNumara) {

        for (int gecici : kullanimBilgisi) {
            if (gecici == basketbolcuNumara) {
                return true;
            }
        }
        kullanimBilgisi[sayac] = basketbolcuNumara;
        sayac++;
        return false;
    }

    public void kartiSil(int a) {
        for (int i = 0; i < kullanimBilgisi.length; i++) {
            if (kullanimBilgisi[i] == a) {
                kullanimBilgisi[i] = -1;
            }
        }
    }

}
