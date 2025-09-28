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

# Penambahan.
## 4. Menerapkan Abstract Class. 

Class ```Movie``` diubah menjadi abstract class karena nantinya akan berfungsi sebagai kerangka dasar untuk semua jenis film, bukan untuk dibuat objek secara langsung. Di dalamnya sudah ada atribut penting seperti id, title, genre, year, dan rating, serta constructor untuk mengisi data tersebut.
```java
public abstract class Movie {
    private int id;
    private String title;
    private String genre;
    private int year;
    private double rating;

    public Movie(int id, String title, String genre, int year, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }
```
Dengan menjadikannya abstrak, program memaksa kita membuat subclass turunan seperti ActionMovie atau RomanceMovie agar lebih spesifik.

## 5. Menerapkan polymorphism

```ActionMovie```, yang menambahkan atribut khusus berupa ```stuntLevel``` dan ```stuntCoordinator```. Method ```getInfo()``` ditulis ulang (```@Override```) sehingga selain menampilkan data dasar film, juga menampilkan informasi aksi seperti tingkat stunt dan koordinatornya.
```java
@Override
    public String getInfo() {
        return baseInfo() + " | Stunt Level: " 
                + (stuntLevel == null ? "N/A" : stuntLevel)
                + " | Coordinator: " + stuntCoordinator;
    }
}
```

```RomanceMovie```, yang menambahkan atribut ```loveTheme``` dan ```leadCouple```. Method ```getInfo()``` juga dioverride agar bisa menampilkan tema cinta dan pasangan utama film tersebut.
```java
@Override
    public String getInfo() {
        return baseInfo() + " | Tema Cinta: " 
                + (loveTheme == null ? "Belum ditentukan" : loveTheme)
                + " | Lead Couple: " + leadCouple;
    }
```
Selain itu, polymorphism juga diterapkan dalam bentuk overloading. Pada ```MovieService```, method ```create()``` dibuat dalam beberapa versi dengan parameter berbeda. 
Misalnya, ada yang menerima ```title```, ```genre```, ```year```, dan ```rating```, sementara bisa dibuat juga versi lain dengan parameter lebih sedikit. 
Walaupun namanya sama, method ini bisa digunakan sesuai kebutuhan input. Dengan begitu, proses pembuatan film lebih fleksibel.
```java
    public Movie create(String title, String genre, int year, double rating) {
    Movie m = new Movie(nextId++, title, genre, year, rating) {
        @Override
        public String getInfo() {
            return "ID: " + getId() + " | " + getTitle() + " (" + getYear() + ") | " 
                   + getGenre() + " | Rating: " + getRating();
        }
    };
    movies.add(m);
    return m;
    }
```

## 6. Interface
Terakhir, ditambahkan interface ```Rateable``` yang berisi kontrak method ```getRating()```. Interface ini membuat setiap kelas film dianggap memiliki kemampuan untuk menampilkan rating. Dengan begitu, baik objek ```Movie```, ```ActionMovie```, maupun ```RomanceMovie``` bisa diperlakukan sama jika hanya dilihat dari sisi rating.
```java
package model;

public interface Rateable {
    double getRating();
}
```
