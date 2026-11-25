package perpustakaan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositoriMemori implements RepositoriPeminjaman {
    private final List<Peminjaman> data = new ArrayList<>();
    @Override
    public void simpan(Peminjaman peminjaman) {
        data.add(peminjaman);
    }

    @Override
    public List<Peminjaman> semua() {
        return Collections.unmodifiableList(new ArrayList<>(data));
    }
}
