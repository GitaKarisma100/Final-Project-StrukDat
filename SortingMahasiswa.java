import java.util.Scanner;

// Class mahasiswa dengan 2 attribut nama dan tahun lahir
class Mahasiswa {
   public String nama;
   public int tahunLahir;

   // construktor sebagai nilai awal untuk nama dan tahun lahir
   public Mahasiswa(String nama, int tahunLahir) {
      this.nama = nama;
      this.tahunLahir = tahunLahir;
   }

   // getter
   public String nama() {
      return nama;
   }

   // getter
   public int tahunLahir() {
      return tahunLahir;
   }
}

public class mhs {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      // array dengan panjang 100 dengan tipe data mahasiswa
      Mahasiswa[] mahasiswaArr = new Mahasiswa[100];
      // variabel sebagai index array mahasiswaArr
      int jumlahMahasiswa = 0;

      boolean isRunning = true;
      while (isRunning) { // jika isrunning bernilai true looping terus menerus
         printMenu();
         int menu = scanner.nextInt();
         scanner.nextLine(); // Membuang karakter baru (newline) setelah membaca angka

         switch (menu) { // pengkondisian menggunakan switch
            case 1: // jika nmenu bernilai 1
               System.out.println("Masukkan data mahasiswa:");
               System.out.print("Nama: ");
               String nama = scanner.nextLine();

               System.out.print("Tahun Lahir: ");
               int tahunLahir = scanner.nextInt();
               scanner.nextLine(); // Membuang karakter baru (newline) setelah membaca angka

               // buat objek mahasiswa dengan parameter nama dan tahun lahir dari inputan
               // diatas
               Mahasiswa mahasiswa = new Mahasiswa(nama, tahunLahir);
               // tambahakan objek mahasiswa ke dalam array mahasiswaArr
               mahasiswaArr[jumlahMahasiswa] = mahasiswa;
               // increment jumlah mahasiswa agar terus bertambah
               jumlahMahasiswa++;
               System.out.println("Data mahasiswa berhasil ditambahkan.");
               break;
            case 2: // jika nmenu bernilai 2
               bubbleSortMahasiswa(mahasiswaArr, jumlahMahasiswa); // sorting array mahasiswa menggunakan bubble sort
               System.out.println("==============================================================");
               System.out.println("Data mahasiswa berhasil diurutkan berdasarkan tahun lahir.");
               System.out.println("==============================================================");
               break;
            case 3: // jika nmenu bernilai 3
               displayMahasiswa(mahasiswaArr, jumlahMahasiswa); // menmapilkan daftar mahasiswa
               break;
            case 4: // jika nmenu bernilai 4
               isRunning = false; // is running menjadi false
               System.out.println("Terima kasih!");
               break;
            default: // jika nmenu bernilai lebih dari 4
               System.out.println("Pilihan tidak valid.");
         }
      }

      scanner.close();
   }

   public static void bubbleSortMahasiswa(Mahasiswa[] arr, int n) {
      for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < n - i - 1; j++) {
            if (arr[j].tahunLahir() > arr[j + 1].tahunLahir()) {
               // Tukar posisi objek Mahasiswa
               swap(arr, j, j + 1);
            }
         }
      }
   }

   public static void swap(Mahasiswa[] arr, int i, int j) {
      Mahasiswa temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public static void displayMahasiswa(Mahasiswa[] arr, int jumlahMahasiswa) {
      if (jumlahMahasiswa > 0) { // jumlah mahasiswa lebih dari 0 / ada
         for (int i = 0; i < jumlahMahasiswa; i++) { // looping menggunakan for
            // tampilkan datanya
            System.out.println("===========================================================================");
            System.out.println((i + 1) + " Nama : " + arr[i].nama + " Tahun Lahir : " + arr[i].tahunLahir);
            System.out.println("===========================================================================");
         }
      } else { // jika jumlah mahasiwa kurang dari 0 / tidak ada
         System.out.println("===========================================================================");
         System.out.println("Data Mahasiswa Masih Kosong");
         System.out.println("===========================================================================");
      }
   }

   public static void printMenu() {
      System.out.println("Menu:");
      System.out.println("1. Input Data Mahasiswa");
      System.out.println("2. Pengurutan Data Mahasiswa berdasarkan Tahun Lahir");
      System.out.println("3.Tampilkan Daftar Mahasiswa");
      System.out.println("4. Keluar");
      System.out.print("Pilihan Anda: ");
   }
}
