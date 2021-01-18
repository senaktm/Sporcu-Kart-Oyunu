package projeodevi;
public class Oyuncu {
    private String oyuncuAdi;
    private String oyuncuID;
    private int skor=0;
    private static int skorBilgisayar,skorKullanici;
    private static int[] kartlar = {-1,-1,-1,-1,-1,-1,-1,-1};
    private static int sayac;
    
    
    public Oyuncu(String oyuncuID, String oyuncuAdi, int skor) {
		
		this.oyuncuID = oyuncuID;
		this.oyuncuAdi = oyuncuAdi;
		this.skor = skor;
	
	}
    
    public Oyuncu(String oyuncuAdi,int skorBilgisayar,int skorKullanici)
    {
        this.oyuncuAdi=oyuncuAdi;
        Oyuncu.skorBilgisayar=skorBilgisayar;
        Oyuncu.skorKullanici=skorKullanici;
    }
    public Oyuncu()
    {
        oyuncuAdi="";
        
    }
    public void kartListesineEkle(int a)
    {
        kartlar[sayac]=a;
        sayac++;
    }
    public int[] kartListesi()
    {
        return kartlar;
    }
    
    public int skorGoster(String a)
    {
        if(a.equals("b"))
        {
            return skorBilgisayar;
        }
        else if(a.equals("k"))
        {
            return skorKullanici;
        }
        return 0;
    }
    public void bilgisayarKazandi()
    {
        skorBilgisayar+=10;
    }
    public void kullaniciKazandi()
    {
        skorKullanici+=10;
    }
    public void skorlariSifirla()
    {
        skorKullanici=0;
        skorBilgisayar=0;
    }
    public int kartSec()
    {
        return 0;
    }
    public String getOyuncuAdi() {
		return oyuncuAdi;
	}

	public void setOyuncuAdi(String oyuncuAdi) {
		this.oyuncuAdi = oyuncuAdi;
	}

	public String getOyuncuID() {
		return oyuncuID;
	}

	public void setOyuncuID(String oyuncuID) {
		this.oyuncuID = oyuncuID;
	}

	public int getSkor() {
		return skor;
	}

	public void setSkor(int skor) {
		this.skor = skor;
	}

	public static int[] getKartlar() {
		return kartlar;
	}

	public static void setKartlar(int[] kartlar) {
		Oyuncu.kartlar = kartlar;
	}
	

	 public static int getSkorBilgisayar() {
		return skorBilgisayar;
	}

	public static void setSkorBilgisayar(int skorBilgisayar) {
		Oyuncu.skorBilgisayar = skorBilgisayar;
	}

	public static int getSkorKullanici() {
		return skorKullanici;
	}

	public static void setSkorKullanici(int skorKullanici) {
		Oyuncu.skorKullanici = skorKullanici;
	}

}
