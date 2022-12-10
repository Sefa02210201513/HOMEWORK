/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package huffmann.kodlamasi;


import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;
/**
 *
 * @author SEFA
 */
public class HuffmannKodlamasi {

    /* KodBas Fonksiyonu özyinelemeli yapıda - ağaç geçişi boyunca huffman kodu
     oluşan huffman kodu */
    public static void KodBas(HuffmanDugum kok, String s)
    {
 
        /* sağ, sol boş ise bir yaprak düğüm yazdırılır kok 
        eğer boş değilse (yaprak ise) yazdırılıyor,
      s; ağacı çaprazlayarak kodu üretir */
        if (kok.sol == null && kok.sag == null && Character.isLetter(kok.c)) {
 
            // c düğümdeki karakter
            System.out.println(kok.c + ":" + s);
 
            return;
        }
 
        // eğer sola dallanırsa koda '0' eklenir.
        // eğer sağa giderse koda '1' eklenir.
        //ağacın sol ve sağ alt ağacı için özyinelemeli çağrımlar.
        KodBas(kok.sol, s + "0");
        KodBas(kok.sag, s + "1");
    }
 
    
    public static void main(String[] args)
    {
 
        Scanner s = new Scanner(System.in);
 
        // 6 harfli alfabe.
        int n = 6;
        char[] alfabe = { 'a', 'b', 'c', 'd', 'e', 'f' }; // alfabemizdeki harfler
        int[] frekans = { 5, 9, 12, 13, 16, 45 };   // Harflerin frekansları sıralı bir şekilde
 
        //öncelikli kuyruk oluşturma q.
        //minimum önceliğe sahip kuyruk(min-heap) oluşturma.
        PriorityQueue<HuffmanDugum> q = new PriorityQueue<HuffmanDugum>(n, new MyComparator());
 
        for (int i = 0; i < n; i++) {
 
            /* Huffman düğüm nesnesi oluşturma ve öncelik sırasına ekleme. */
            HuffmanDugum hn = new HuffmanDugum();
 
            hn.c = alfabe[i];
            hn.veri = frekans[i];
 
            hn.sol = null;
            hn.sol = null;
 
            // kuyruğa huffman düğümü ekleme fonksiyonu.
            q.add(hn);
        }
 
        // Kök düğüm oluştur
        HuffmanDugum kok = null;
 
        /* Burada boyutu 1'e düşene kadar her seferinde yığından iki minimum değeri çıkarılacak, tüm düğümler çıkarılana kadar çıkarılacak. */
        while (q.size() > 1) {
 
            // birinci minimum u ayıkla.
            HuffmanDugum x = q.peek();
            q.poll();
 
            // ikinci minimum u ayıkla.
            HuffmanDugum y = q.peek();
            q.poll();
 
            HuffmanDugum f = new HuffmanDugum();
 
            /* iki düğümün frekanslarının toplamını f düğümüne atanıyor */
            f.veri = x.veri + y.veri;
            f.c = '-';
 
            // sol çocuk olarak ilk çıkarılan düğüm.
            f.sol = x;
 
            // sağ çocuk olarak ikinci ayıklanan düğüm.
            f.sag = y;
 
            // f düğümünü kok düğümüne atama.
            kok = f;
 
            // bu düğümü öncelikli kuyruğa ekleme.
            q.add(f);
        }
 
        // ağacı çaprazlayarak kodlarını yazdır
        KodBas(kok, "");
    }
}
 
// düğüm sınıfı (HuffmanDugum), Huffman ağacında bulunan her düğümün temel yapısıdır.
class HuffmanDugum {
 
    int veri;
    char c;
 
    HuffmanDugum sol;
    HuffmanDugum sag;
}
 

/* karşılaştırıcı sınıfı, düğümün özniteliklerinden birine göre karşılaştırılmasına yardımcı olur.
 Burada düğümlerin veri değerleri bazında karşılaştırılacak. */
class MyComparator implements Comparator<HuffmanDugum> {
    public int compare(HuffmanDugum x, HuffmanDugum y)
    {
 
        return x.veri - y.veri;
    }
}
    /**
     * @param args the command line arguments
