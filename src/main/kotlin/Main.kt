import java.util.Scanner

// fungsi untuk melihat nama barang dari kode barang
fun cekBarang(kode: Int): String {
    when(kode) {
        1 -> return "Ballpoint"
        2 -> return "Spidol"
        3 -> return "Penghapus"
        4 -> return "Pensil"
        else -> return "Error"
    }
}

fun main(args: Array<String>) {
    // membuat menu barang
    println("Pilih barang: \n" +
            "1. Ballpoint @3000 IDR\n" +
            "2. Spidol @7500 IDR\n" +
            "3. Penghapus @1500 IDR\n" +
            "4. Pensil @2500 IDR\n" +
            "5. Checkout\n")

    // membuat scanner agar input dapat beragam tipe data
    val input = Scanner(System.`in`)

    // membuat variabel listBarang (array) untuk menampung barang yang akan dibeli (keranjang)
    var listBarang = arrayListOf<Int>()

    // lambda untuk mengecek harga barang
    val cekHarga = { kodeBarang: Int ->
        when(kodeBarang) {
            1 -> 3000
            2 -> 7500
            3 -> 1500
            4 -> 2500
            else -> 0
        }
    }

    // perulangan while -> input menu hingga user input checkout (5)
    var menu: Int = 0
    while(menu !== 5) {
        print("Masukkan pilihan barang [angka saja]: ")
        menu = input.nextInt()
        if(menu > 0 && menu <= 4) {
            listBarang.add(menu)
            println(cekBarang(menu) + " berhasil ditambahkan dalam keranjang!")
        } else if(menu == 5) {
            break
        } else {
            println("Pilihan menu tidak ditemukan!")
        }
    }

    // membuat data barang agar tidak ada duplikat
    val barangYangDibeli = listBarang.distinct()

    // menampilkan barang yang dibeli
    println("==================================\n" +
            "Daftar barang yang dibeli: ")
    barangYangDibeli.forEach { kodeBarang -> println(cekBarang(kodeBarang) + " " +
            listBarang.count { it == kodeBarang} + " x @" + cekHarga(kodeBarang) +
            " IDR = " + (cekHarga(kodeBarang) * listBarang.count { it == kodeBarang})) }

    // perulangan for -> hitung harga total
    var totalHarga: Int = 0
    for(i in listBarang) {
        totalHarga += cekHarga(i)
    }

    // menampilkan total harga
    println("-------------------------------- +\n" +
            "Total : @$totalHarga IDR\n" +
            "Terima kasih!")

}