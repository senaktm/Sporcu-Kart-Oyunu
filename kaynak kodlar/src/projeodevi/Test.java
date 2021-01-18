package projeodevi;


public class Test {

    private static Futbolcu[] futbolcu = new Futbolcu[40];
    private static Basketbolcu[] basketbolcu=new Basketbolcu[40];
    Oyuncu kullanan=new Oyuncu();

    
    
    public int gonderPozisyon(int a,String pozisyon)
    {
        if(pozisyon.equals("Sertbest  Atis"))
            return futbolcu[a].getSerbestAtis();
        else if(pozisyon.equals("Penalti"))
            return futbolcu[a].getPenalti();
        else if(pozisyon.equals("Kaleci ile Karsi Karsiya"))
            return futbolcu[a].getKaleciKarsiKarsiya();
        else if(pozisyon.equals("Serbest Atis"))
            return basketbolcu[a].getSerbestAtis();
        else if(pozisyon.equals("Ikilik"))
            return basketbolcu[a].getIkilik();
        else if(pozisyon.equals("Ucluk"))
            return basketbolcu[a].getUcluk();
        return 0;
        
        
    }
    public Test() {
        futbolcu[0] = new Futbolcu("Cristiano Ronaldo", "Juventus", 95, 86, 90);
        futbolcu[1] = new Futbolcu("Lionel Messi", "Barcelona", 95, 90, 90);
        futbolcu[2] = new Futbolcu("David Beckham", "Manchester United", 100, 100, 85);
        futbolcu[3] = new Futbolcu("Robin van Persie", "Feyenoord", 85, 80, 85);
        futbolcu[4] = new Futbolcu("Kylian Mbappe", "Paris Saint-Germain", 95, 80, 90);
        futbolcu[5] = new Futbolcu("Neymar", "Paris Saint-Germain", 95, 85, 90);
        futbolcu[6] = new Futbolcu("Romelu Lukaku", "Inter", 90, 80, 85);
        futbolcu[7] = new Futbolcu("Paulo Dybala", "Juventus", 90, 85, 85);
        basketbolcu[0] = new Basketbolcu("Shane Larkin", "Anadolu Efes", 85, 80, 95);
        basketbolcu[1] = new Basketbolcu("Melih Mahmutoğlu", "Fenerbahçe", 80, 75, 90);
        basketbolcu[2] = new Basketbolcu("Cedi Osman", "Cleveland Cavaliers", 85, 75, 80);
        basketbolcu[3] = new Basketbolcu("Furkan Korkmaz", "Philadelphia 76ers", 85, 85, 90);
        basketbolcu[4] = new Basketbolcu("LeBron James", "Los Angeles Lakers", 90, 90, 95);
        basketbolcu[5] = new Basketbolcu("James Harden", "Houston Rockets", 85, 90, 90);
        basketbolcu[6] = new Basketbolcu("Michael Jordan", " Washington Wizards", 100, 90, 95);
        basketbolcu[7] = new Basketbolcu("Kobe Bryant", "Los Angeles Lakers", 100, 100, 100);
    }

    

    public String RandomPozisyonSec(String a) {
        int rastgele;
        rastgele=(int)(Math.random()*3);
        if(a.equals("f"))
        {
            switch(rastgele)
            {
                case 0:
                    return "Kaleci ile Karsi Karsiya";
                case 1:
                    return "Serbest  Atis";
                case 2:
                    return "Penalti";
            }
        }
        if(a.equals("b"))
        {
            switch(rastgele)
            {
                case 0:
                    return "Ikilik";
                case 1:
                    return "Ucluk";
                case 2:
                    return "Serbest Atis";
            }
        }
          
        return "";
    }
    
    
    
    public String karsilastir(int sporcu1,int sporcu2,String pozisyon)
    {
        int birinci,ikinci;
        switch(pozisyon)
            {
                case "Ikilik":
                    birinci=basketbolcu[sporcu1].getIkilik();
                    ikinci=basketbolcu[sporcu2].getIkilik();
                    if(ikinci>birinci)
                    {
                        kullanan.bilgisayarKazandi();
                        return "Bilgisayar Kazandi";
                    }
                    else if(birinci>ikinci)
                    {
                        kullanan.kullaniciKazandi();
                        return "Kullanici Kazandi";
                    }
                    else
                        return "Berabere";
                        
                case "Ucluk":
                    birinci=basketbolcu[sporcu1].getUcluk();
                    ikinci=basketbolcu[sporcu2].getUcluk();
                    if(ikinci>birinci)
                    {
                        kullanan.bilgisayarKazandi();
                        return "Bilgisayar Kazandi";
                    }
                    else if(birinci>ikinci)
                    {
                        kullanan.kullaniciKazandi();
                        return "Kullanici Kazandi";
                    }
                    else
                        return "Berabere";
                 
                case "Serbest Atis":
                    birinci=basketbolcu[sporcu1].getSerbestAtis();
                    ikinci=basketbolcu[sporcu2].getSerbestAtis();
                    if(ikinci>birinci)
                    {
                        kullanan.bilgisayarKazandi();
                        return "Bilgisayar Kazandi";
                    }
                    else if(birinci>ikinci)
                    {
                        kullanan.kullaniciKazandi();
                        return "Kullanici Kazandi";
                    }
                    else
                        return "Berabere";
                    
                case "Kaleci ile Karsi Karsiya":
                    birinci=futbolcu[sporcu1].getKaleciKarsiKarsiya();
                    ikinci=futbolcu[sporcu2].getKaleciKarsiKarsiya();
                    if(ikinci>birinci)
                    {
                        kullanan.bilgisayarKazandi();
                        return "Bilgisayar Kazandi";
                    }
                    else if(birinci>ikinci)
                    {
                        kullanan.kullaniciKazandi();
                        return "Kullanici Kazandi";
                    }else
                        return "Berabere";
                   
                case "Serbest  Atis":
                    birinci=futbolcu[sporcu1].getSerbestAtis();
                    ikinci=futbolcu[sporcu2].getSerbestAtis();
                    if(ikinci>birinci)
                    {
                        kullanan.bilgisayarKazandi();
                        return "Bilgisayar Kazandi";
                    }
                    else if(birinci>ikinci)
                    {
                        kullanan.kullaniciKazandi();
                        return "Kullanici Kazandi";
                    }else
                        return "Berabere";
                   
                case "Penalti":
                    birinci=futbolcu[sporcu1].getPenalti();
                    ikinci=futbolcu[sporcu2].getPenalti();
                    if(ikinci>birinci)
                    {
                        kullanan.bilgisayarKazandi();
                        return "Bilgisayar Kazandi";
                    }
                    else if(birinci>ikinci)
                    {
                        kullanan.kullaniciKazandi();
                        return "Kullanici Kazandi";
                    }
                    else
                        return "Berabere";
            }
        return "";
    }

}
