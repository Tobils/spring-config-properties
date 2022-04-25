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
