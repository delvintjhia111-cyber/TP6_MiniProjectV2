import java.io.File

object Penyimpanan {
    fun muat(file: File): MutableList<Tugas> {
        val hasil = mutableListOf<Tugas>()
        if (!file.exists()) return hasil

        for (baris in file.readLines()) {
            val bagian = baris.split(";")
            if (bagian.size != 3) continue
            val id = bagian[0].trim()
            val judul = bagian[1].trim()
            val selesai = bagian[2].trim().toBooleanStrictOrNull() ?: continue
            if (id.isNotBlank() && judul.isNotBlank()) {
                hasil.add(Tugas(id, judul, selesai))
            }
        }
        return hasil
    }

    fun simpan(file: File, data: List<Tugas>) {
        val teks = data.joinToString("\n"){
            "${it.id};${it.judul};${it.selesai}"
        }
        file.writeText(teks)
    }
}