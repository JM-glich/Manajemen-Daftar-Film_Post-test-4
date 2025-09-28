# Manajemen-Daftar-Film_Post-test-4
## Jemis Movid (2409116070)

## 1. Menerapkan encapsulation (getter dan setter)

Semua properti dalam class Movie seperti id, title, genre, year, dan rating sebelumnya kan dibuat private. Artinya, nilai properti tidak bisa diakses secara langsung dari luar class.
Karenanya agar tetap bisa membaca atau mengubah nilai, dibuatlah getter dan setter.

Contoh kode:
```java
//(getter & setter)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

dst..
```

Nah, alih-alih manggil movie.title, programnya harus menggunakan movie.getTitle() atau movie.setTitle("judul baru").

## 2. Menerapkan inheritance (minimal memiliki 1 superclass dengan 2 subclass)

Inheritance atau pewarisan adalah sebuah teknik yang memungkinkan sebuah class (subclass) untuk mewarisi properti dan method dari class lain (superclass).
Dalam program ini ```Movie``` dijadikan superclass karena di dalamnya udah ada properti umum seperti misalnya title, genre, year, dan rating.
Lalu dibuat 2 subclass untuk memperluas Movie:
- ActionMovie. Ditambahkan properti khusus stuntCoordinator untuk menyimpan siapa yang bertanggung jawab atas adegan aksi.
Contoh kode:
```java
public class ActionMovie extends Movie {
    private String stuntLevel; // tambahan atribut khusus
    private final String stuntCoordinator;

    public ActionMovie(int id, String title, String genre, int year, double rating, String stuntCoordinator) {
    super(id, title, genre, year, rating);
    this.stuntCoordinator = stuntCoordinator;
    }
```

- RomanceMovie. Ditambahkan properti khusus leadCouple untuk menyimpan nama pasangan utama dalam cerita.
Contoh kode:
```java
public class RomanceMovie extends Movie {
    private String loveTheme; // tambahan atribut khusus
    private final String leadCouple;

    public RomanceMovie(int id, String title, String genre, int year, double rating, String leadCouple) {
    super(id, title, genre, year, rating);
    this.leadCouple = leadCouple;
    }
```

Dengan begini misalnya class ```ActionMovie``` bisa tetap memiliki ibaratnya sifat dari class ```Movie``` tetapi juga menambahkan properti uniknya sendiri.

## 3. Menerapkan Overriding

Overriding berarti mendefinisikan ulang method yang sudah ada di superclass agar memiliki perilaku berbeda di subclass. Lalu di dalam program ini sendiri, Method getInfo() yang ada di class Movie dioverride di subclass (ActionMovie dan RomanceMovie).
- Pada ActionMovie, getInfo() ditambahkan informasi tentang stuntCoordinator.
```java
@Override
    public String getInfo() {
        return super.getInfo() + " | Stunt Level: " + stuntLevel;
    }
```
- Pada RomanceMovie, getInfo() ditambahkan informasi tentang leadCouple.
```java
 @Override
    public String getInfo() {
        return super.getInfo() + " | Tema Cinta: " + loveTheme;
    }
```

Dengan begini, Kalau kita punya sebuah objek ```Movie``` biasa, ```getInfo()``` hanya akan menampilkan atribut standar. Tapi kalau objeknya ```ActionMovie```, hasilnya akan menambahkan informasi tentang stunt coordinator.
