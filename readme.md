# Spring Config Properties

## Resources

```
- di java terdapat fitur bernama Java IO sebagai management resources
- spring membungkus resources dalam sebuah interface bernama Resource
- d spring tidak perlu implementasi secara manual karena sudah di implementasikan oleh spring
```

## Resources Loader

```
- spring memiliki feature yang dapat digunakan untuk mengambil data resource secara otomatis, tanpa harus membuat object resource nya, namanya ResourceLoader
- ResourceLoader memiliki method bernama getResource(String) yang bisa kita gunakan untuk mengambil sebuah resource
- ResouceLoader akan mendeteksi jenis Resource yang butuh diambil dari data Springnya

--- implementasi dengan ResourceLoaderAware
  - ResourceLoader adalah interface, sehingga untuk implementasi harus menggunakan class implementasinya dari ApplicationContext
```

## Message Source

```
- mengambil data Properties secara otomatis
- message source digunakan untuk mengabil source dari spring
  - kombinasi message properties dan message format
  - merupakan interface dan perlu implementasi class, dan sudah disediakan oleh spring
```

## Spring Message Source

```
- jika kita menggunakan Spring Boot, maka Spring Boot secara otomatis telah membuat Message Source
- secara otomatis Spring Boot akan mengambil data resourceZ bundle messages.properties
- bisa menggunakan MessageSourceAware
- ApplicationContext adalah turunan dari MessageSource
```

## Application Properties

```
- saat membuat project spring, secara otomatis akan dibuatkan file application.properties
- file ini merupakan ppusat dari properties dari konfigurasi aplikasi spring
- secara otomatis spring boot akan membaca application.properties
- file ini digunakan untuk konfigurasi
- jika kita butuh Internationalization, gunakan file messages.properties

```

## Environtment

```
- dapat digunakan untuk mengambil value envi variable dari sistem operasi
- kita bisa menggunakan EnvirontmentAware jika ingin mendapatkan object Environment
```

## Value

```
- Value merupakan Annotation yang dapat kita gunakan untuk melakukan inject data dari properties ke field yang kita tandai
- cara nya dengan ${nama.properties.nya}, contoh: @Value("${application.name}")
- atau dengan ${nama.envivar}, contoh : @Value("${JAVA_HOME}")

-- check class ValuePropertiesTest
```

## Property Source

```
- secara default aplikasi hanya mmembaca application.properties
- Springboot supported untuk menambahkan properties dengan Property Source
- bisa menggunakan annotasi PropertySources
- misal tambahkan file pada folder resources sample.properties
- antar properties file tidak boleh terdapat key yg sama
```

## Test Property Source

```
- saat memmbuuat unit test terkadang kita perlu menggunakan properties file yang berbeda
- akan sulit jika hanya menggunakan Annotation PropertySource
- untungnya di spring boot support untuk  dengan Annotation TestPropertySOurce
```

## Profile

```
- profile merupakan fitur di spring yg bisa digunakan untuk menenetukan component jalan di profile mana
- profile cocok sekali ketika kta butuh component berbeda pada kondisi tertentu, misal kita buat component untuk koneksi ke memory db dan kita ingin component nya diganti ke koneksi memory aplikasi untuk local.
- untuk menandai sebuah component dengan informasi Profile, kita bisa menggunakan annotation profile
- kita bisa menggunakan application properties untuk enentukan profile mana yg active dengan key spring.profiles.active => spring.profiles.active=local,dev
- jika tidak mengactive kan profiles nya maka akan secara default mmenggunakan profile default
- kadang jika harus engubah profile di application properties akan menyulitkan ketika kita membuat unit test untuk beberapa profile
- untuk mengubah profile di unit test, kita bisa menggunakan annotation ActiveProfiles
- kadang kita ingin mendapatkan profile pada saat aplikasi berjalan
- jika kasus seperti ini, kita bisa menggunakan Environment
- terdapat method getActiveProfiles() untuk mendapatkan profile yg sedang aktif
```
