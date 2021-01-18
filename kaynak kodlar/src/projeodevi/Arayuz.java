package projeodevi;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Arayuz extends javax.swing.JFrame {

    
    private int f1, f2, f3, f4, b1, b2, b3, b4, bilgsecilen;
    private static int say = 0, fsay = 0, bsay = 0;
    private final Bilgisayar b = new Bilgisayar();
    private final Test c = new Test();
    private final Oyuncu o = new Oyuncu();
    private final Basketbolcu basketbol = new Basketbolcu();
    private final Futbolcu futbol = new Futbolcu();
    Kullanici kullanici = new Kullanici();
    private String pozisyon, kazanan;

    public Arayuz() {
        initComponents();
        kartlariAta();
        basketbolculariKaldir();
        kart1.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(f1))));
        kart2.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(f2))));
        kart3.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(f3))));
        kart4.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(f4))));
        kart5.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(b1 + 8))));
        kart6.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(b2 + 8))));
        kart7.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(b3 + 8))));
        kart8.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(b4 + 8))));
       simgeUnlem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/unlemisareti.png")));
       vs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/vsisareti.png")));
       
       
       ust.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/back5.png")));
       sag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/back5.png")));
       sol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/back5.png")));
       orta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/back5.png")));
       
       
    }

    private void kartlariAta() {
        f1 = kullanici.kartSec("f");
        f2 = kullanici.kartSec("f");
        f3 = kullanici.kartSec("f");
        f4 = kullanici.kartSec("f");

        b1 = kullanici.kartSec("b");
        b2 = kullanici.kartSec("b");
        b3 = kullanici.kartSec("b");
        b4 = kullanici.kartSec("b");
    }

    private String kartiGoster(int a) {
        switch (a) {
            case 0:
                return "/Resimler/ronaldo.png";
            case 1:
                return "/Resimler/messi.png";
            case 2:
                return "/Resimler/david.png";
            case 3:
                return "/Resimler/robin.png";
            case 4:
                return "/Resimler/kylian.png";
            case 5:
                return "/Resimler/neymar.png";
            case 6:
                return "/Resimler/romelu.png";
            case 7:
                return "/Resimler/paulo.png";
            case 8:
                return "/Resimler/shane.png";
            case 9:
                return "/Resimler/melih.png";
            case 10:
                return "/Resimler/osman.png";
            case 11:
                return "/Resimler/furkan.png";
            case 12:
                return "/Resimler/lebron.png";
            case 13:
                return "/Resimler/james.png";
            case 14:
                return "/Resimler/micheal.png";
            case 15:
                return "/Resimler/kobe.png";

        }
        return "";
    }

    private void futbolculariKaldir() {
        kart1.setEnabled(false);
        kart2.setEnabled(false);
        kart3.setEnabled(false);
        kart4.setEnabled(false);
        kart5.setEnabled(true);
        kart6.setEnabled(true);
        kart7.setEnabled(true);
        kart8.setEnabled(true);
    }

    private void basketbolculariKaldir() {
        kart1.setEnabled(true);
        kart2.setEnabled(true);
        kart3.setEnabled(true);
        kart4.setEnabled(true);
        kart5.setEnabled(false);
        kart6.setEnabled(false);
        kart7.setEnabled(false);
        kart8.setEnabled(false);
    }

    private void kartaBasildigindaFutbol(int numara) {
        bilgsecilen = b.kartSec("f");
        secimBilgisayar.setText(Integer.toString(bilgsecilen));
        secimKullanici.setText(Integer.toString(numara));
        pozisyon = c.RandomPozisyonSec("f");
        secilenPozisyon.setText(pozisyon);
        kazanan = c.karsilastir(numara, bilgsecilen, pozisyon);
        kazananTur.setText(kazanan);
        bilgisayarSkor.setText(Integer.toString(o.skorGoster("b")));
        kullaniciSkor.setText(Integer.toString(o.skorGoster("k")));

        if (!kazanan.equals("Berabere")) {
            say++;
            fsay++;
        } else {
            futbol.kartiSil(numara);
            futbol.kartiSil(bilgsecilen);

        }
        if (!(bsay == 4)) {
            futbolculariKaldir();
        }
        if (say == 7 && kazanan.equals("Berabere")) {
            while (kazanan.equals("Berabere")) {
                pozisyon = c.RandomPozisyonSec("f");
                secilenPozisyon.setText(pozisyon);
                kazanan = c.karsilastir(numara, bilgsecilen, pozisyon);
                kazananTur.setText(kazanan);
                bilgisayarSkor.setText(Integer.toString(o.skorGoster("b")));
                kullaniciSkor.setText(Integer.toString(o.skorGoster("k")));
            }
            say++;
        }
        secimKullanici.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(numara))));
        secimBilgisayar.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(bilgsecilen))));
        if(say==8)
        {
            if(o.skorGoster("k")<o.skorGoster("b"))
                 kazananOyun.setText("Bu Oyunu Bilgisayar Kazandi :( ");
            else if(o.skorGoster("k")>o.skorGoster("b"))
                 kazananOyun.setText("Bu Oyunu Kullanici Kazandi :) ");
            else
                kazananOyun.setText("Berabere Kaldiniz :\\ ");
            
        }
    }

    private void kartaBasildigindaBasketbol(int numara) {
        bilgsecilen = b.kartSec("b");
        secimBilgisayar.setText(Integer.toString(bilgsecilen));
        secimKullanici.setText(Integer.toString(numara));
        pozisyon = c.RandomPozisyonSec("b");
        secilenPozisyon.setText(pozisyon);
        kazanan = c.karsilastir(numara, bilgsecilen, pozisyon);
        kazananTur.setText(kazanan);
        bilgisayarSkor.setText(Integer.toString(o.skorGoster("b")));
        kullaniciSkor.setText(Integer.toString(o.skorGoster("k")));

        if (!kazanan.equals("Berabere")) {
            say++;
            bsay++;
        } else {
            basketbol.kartiSil(numara);
            basketbol.kartiSil(bilgsecilen);
        }
        if (!(fsay == 4)) {
            basketbolculariKaldir();
        }
        if (say == 7 && kazanan.equals("Berabere")) {
            while (kazanan.equals("Berabere")) {
                pozisyon = c.RandomPozisyonSec("b");
                secilenPozisyon.setText(pozisyon);
                kazanan = c.karsilastir(numara, bilgsecilen, pozisyon);
                kazananTur.setText(kazanan);
                bilgisayarSkor.setText(Integer.toString(o.skorGoster("b")));
                kullaniciSkor.setText(Integer.toString(o.skorGoster("k")));
            }
            say++;

        }

        secimKullanici.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(numara + 8))));
        secimBilgisayar.setIcon(new javax.swing.ImageIcon(getClass().getResource(kartiGoster(bilgsecilen + 8))));
        
        if(say==8)
        {
            if(o.skorGoster("k")<o.skorGoster("b"))
                 kazananOyun.setText("Bu Oyunu Bilgisayar Kazandi :( ");
            else if(o.skorGoster("k")>o.skorGoster("b"))
                 kazananOyun.setText("Bu Oyunu Kullanici Kazandi :) ");
            else
                kazananOyun.setText("Berabere Kaldiniz :\\ ");
            
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bilgisayarSkor = new javax.swing.JLabel();
        kullaniciSkor = new javax.swing.JLabel();
        simgeUnlem = new javax.swing.JButton();
        sol = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        kart2 = new javax.swing.JButton();
        kart3 = new javax.swing.JButton();
        kart4 = new javax.swing.JButton();
        kart1 = new javax.swing.JButton();
        kart6 = new javax.swing.JButton();
        kart5 = new javax.swing.JButton();
        kart7 = new javax.swing.JButton();
        kart8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        kazananOyun = new javax.swing.JLabel();
        ust = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        vs = new javax.swing.JLabel();
        secimBilgisayar = new javax.swing.JButton();
        secimKullanici = new javax.swing.JButton();
        orta = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        secilenPozisyon = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        kazananTur = new javax.swing.JLabel();
        sag = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.cyan);

        jPanel1.setPreferredSize(new java.awt.Dimension(336, 406));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Skorlar:");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Bilgisayar Skor: ");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Kullanici Skor: ");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Daha onceden secilen karti secemezsiniz!");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("(Berabere kalinan durumlar harictir.)");

        bilgisayarSkor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bilgisayarSkor.setText("0");

        kullaniciSkor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        kullaniciSkor.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(bilgisayarSkor))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(kullaniciSkor))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(simgeUnlem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sol, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(bilgisayarSkor)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(kullaniciSkor)))
                .addGap(65, 65, 65)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(simgeUnlem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sol, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 204));

        kart2.setPreferredSize(new java.awt.Dimension(160, 280));
        kart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart2ActionPerformed(evt);
            }
        });

        kart3.setPreferredSize(new java.awt.Dimension(160, 280));
        kart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart3ActionPerformed(evt);
            }
        });

        kart4.setPreferredSize(new java.awt.Dimension(160, 280));
        kart4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart4ActionPerformed(evt);
            }
        });

        kart1.setPreferredSize(new java.awt.Dimension(160, 280));
        kart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart1ActionPerformed(evt);
            }
        });

        kart6.setPreferredSize(new java.awt.Dimension(160, 280));
        kart6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart6ActionPerformed(evt);
            }
        });

        kart5.setPreferredSize(new java.awt.Dimension(160, 280));
        kart5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart5ActionPerformed(evt);
            }
        });

        kart7.setPreferredSize(new java.awt.Dimension(160, 280));
        kart7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart7ActionPerformed(evt);
            }
        });

        kart8.setPreferredSize(new java.awt.Dimension(160, 280));
        kart8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kart8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(kart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(kart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(kart3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(kart4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(kart5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(kart6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(kart7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(kart8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kart3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kart4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kart5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kart6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kart7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kart8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(728, 84));
        jPanel3.setVerifyInputWhenFocusTarget(false);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setText("Oyunu Kazanan:");

        kazananOyun.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        kazananOyun.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(kazananOyun, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ust, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(kazananOyun, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(ust, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Kullanici Secimi: ");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 255));
        jLabel8.setText("Bilgisayar Secimi: ");

        vs.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        vs.setText("VS");

        secimBilgisayar.setOpaque(false);
        secimBilgisayar.setPreferredSize(new java.awt.Dimension(160, 280));
        secimBilgisayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secimBilgisayarActionPerformed(evt);
            }
        });

        secimKullanici.setOpaque(false);
        secimKullanici.setPreferredSize(new java.awt.Dimension(160, 280));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(secimKullanici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(vs, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(secimBilgisayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(orta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(secimKullanici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel8))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(vs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(orta, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(secimBilgisayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("Secilen Pozisyon: ");

        secilenPozisyon.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        secilenPozisyon.setText("Bekleniyor");

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 255));
        jLabel11.setText("Turu Kazanan: ");

        kazananTur.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        kazananTur.setText("Bekleniyor");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(secilenPozisyon, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(kazananTur, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(sag, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(secilenPozisyon)
                .addGap(69, 69, 69)
                .addComponent(jLabel11))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(kazananTur))
            .addComponent(sag, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart2ActionPerformed
        kartaBasildigindaFutbol(f2);
        if (!kazanan.equals("Berabere")) {
            kart2.setVisible(false);
        }

    }//GEN-LAST:event_kart2ActionPerformed

    private void kart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart3ActionPerformed
        kartaBasildigindaFutbol(f3);
        if (!kazanan.equals("Berabere")) {
            kart3.setVisible(false);
        }
    }//GEN-LAST:event_kart3ActionPerformed

    private void kart4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart4ActionPerformed
        kartaBasildigindaFutbol(f4);
        if (!kazanan.equals("Berabere")) {
            kart4.setVisible(false);
        }
    }//GEN-LAST:event_kart4ActionPerformed

    private void kart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart1ActionPerformed
        kartaBasildigindaFutbol(f1);
        if (!kazanan.equals("Berabere")) {
            kart1.setVisible(false);
        }
    }//GEN-LAST:event_kart1ActionPerformed

    private void secimBilgisayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secimBilgisayarActionPerformed
        
    }//GEN-LAST:event_secimBilgisayarActionPerformed

    private void kart6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart6ActionPerformed
        kartaBasildigindaBasketbol(b2);
        if (!kazanan.equals("Berabere")) {
            kart6.setVisible(false);
        }
    }//GEN-LAST:event_kart6ActionPerformed

    private void kart5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart5ActionPerformed
        kartaBasildigindaBasketbol(b1);
        if (!kazanan.equals("Berabere")) {
            kart5.setVisible(false);
        }
    }//GEN-LAST:event_kart5ActionPerformed

    private void kart7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart7ActionPerformed
        kartaBasildigindaBasketbol(b3);
        if (!kazanan.equals("Berabere")) {
            kart7.setVisible(false);
        }
    }//GEN-LAST:event_kart7ActionPerformed

    private void kart8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kart8ActionPerformed
        kartaBasildigindaBasketbol(b4);
        if (!kazanan.equals("Berabere")) {
            kart8.setVisible(false);
        }
    }//GEN-LAST:event_kart8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arayuz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bilgisayarSkor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton kart1;
    private javax.swing.JButton kart2;
    private javax.swing.JButton kart3;
    private javax.swing.JButton kart4;
    private javax.swing.JButton kart5;
    private javax.swing.JButton kart6;
    private javax.swing.JButton kart7;
    private javax.swing.JButton kart8;
    private javax.swing.JLabel kazananOyun;
    private javax.swing.JLabel kazananTur;
    private javax.swing.JLabel kullaniciSkor;
    private javax.swing.JLabel orta;
    private javax.swing.JLabel sag;
    private javax.swing.JLabel secilenPozisyon;
    private javax.swing.JButton secimBilgisayar;
    private javax.swing.JButton secimKullanici;
    private javax.swing.JButton simgeUnlem;
    private javax.swing.JLabel sol;
    private javax.swing.JLabel ust;
    private javax.swing.JLabel vs;
    // End of variables declaration//GEN-END:variables

}
