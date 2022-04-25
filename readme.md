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
