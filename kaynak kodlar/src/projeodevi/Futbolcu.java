package projeodevi;


public class Futbolcu extends Sporcu {

    private int penalti;
    private int SerbestAtis;
    private int kaleciKarsiKarsiya;
    private static int[] kullanimBilgisi = {-1, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private static int sayac;
    private String futbolcuAdi;
    private String futbolcuTakim;

    public Futbolcu() {
        super();
    }

    public Futbolcu(String futbolcuAdi, String futbolcuTakim, int penalti, int SerbestAtis, int kaleciKarsiKarsiya) {
        super(futbolcuAdi, futbolcuTakim);
        this.penalti = penalti;
        this.SerbestAtis = SerbestAtis;
        this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
        futbolcuAdi = super.getSporcuIsim();
        futbolcuTakim = super.getSporcuTakim();
    }

    public int getPenalti() {
        return penalti;
    }

    public void setPenalti(int penalti) {
        this.penalti = penalti;
    }

    public int getSerbestAtis() {
        return SerbestAtis;
    }

    public void setSut(int SerbestAtis) {
        this.SerbestAtis = SerbestAtis;
    }

    public int getKaleciKarsiKarsiya() {
        return kaleciKarsiKarsiya;
    }

    public void setKaleciKarsiKarsiya(int kaleciKarsiKarsiya) {
        this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
    }
    

    public String getFutbolcuAdi() {
		return futbolcuAdi;
	}

	public void setFutbolcuAdi(String futbolcuAdi) {
		this.futbolcuAdi = futbolcuAdi;
	}

	public String getFutbolcuTakim() {
		return futbolcuTakim;
	}

	public void setFutbolcuTakim(String futbolcuTakim) {
		this.futbolcuTakim = futbolcuTakim;
	}

    @Override
    public int sporcuPuaniGoster(String futbolcuAdi, String pozisyon, int pozisyonDegeri) {

        if (pozisyon.equals("Serbest  Atis")) {
            pozisyonDegeri = SerbestAtis;
            return pozisyonDegeri;
        }
        if (pozisyon.equals("Penalti")) {
            pozisyonDegeri = penalti;
            return pozisyonDegeri;
        }
        if (pozisyon.equals("Kaleci ile Karsi Karsiya")) {
            pozisyonDegeri = kaleciKarsiKarsiya;
            return pozisyonDegeri;
        }
        return 0;

    }

    public boolean kartKullanildiMi(int futbolcuNumarasi) {

        for (int gecici : kullanimBilgisi) {
            if (gecici == futbolcuNumarasi) {
                return true;
            }
        }
        kullanimBilgisi[sayac] = futbolcuNumarasi;
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
