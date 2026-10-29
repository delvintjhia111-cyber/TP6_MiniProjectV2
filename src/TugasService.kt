class TugasService(private val daftar: MutableList<Tugas>) {
    fun tambah(id: String, judul: String): Boolean {
        if (id.isBlank() || judul.isBlank()) return false
        if (daftar.any {
                it.id.equals(id, ignoreCase = true)
            }) return false
        daftar.add(Tugas(id.trim(), judul.trim()))
        return true
    }

    fun tampilkan(){
        if (daftar.isEmpty()) {
            println("Belum ada tugas")
            return
        }
        for ((indeks, tugas) in daftar.withIndex()) {
            val status = if (tugas.selesai) "selesai" else "Belum"
            println("${indeks + 1}. ${tugas.id} | ${tugas.judul} | $status")
        }
    }

    fun cari(id: String) : Tugas? =
        daftar.find { it.id.equals(id.trim(), ignoreCase = true)}

    fun ubahStatus(id: String) : Boolean {
        val tugas = cari(id) ?: return false
        tugas.selesai = !tugas.selesai
        return true
    }
    fun hapus(id: String): Boolean{
        val tugas = cari(id) ?: return false
        daftar.remove(tugas)
        return true
    }

}