package com.yanti.koperasi;

import com.yanti.koperasi.model.*;
import com.yanti.koperasi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path="/api")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private KursiRepository kursiRepository;
    @Autowired
    private PulsaRepository pulsaRepository;
    @Autowired
    private RuanganRepository ruanganRepository;
    @Autowired
    private PesananRepository pesananRepository;
    @Autowired
    private PengantaranRepository pengantaranRepository;

    @GetMapping(path = "/users")
    public @ResponseBody Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path="/register")
    public @ResponseBody String register(User user) {
        userRepository.save(user);
        return "Customer Berhasil Didaftarkan";
    }

    @PostMapping(path="/login")
    public @ResponseBody User login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);
        if(user != null && user.getPassword().equals(password)) return user;
        else return null;
    }

    // CRUD MENU
    @GetMapping(path = "/menu")
    public @ResponseBody Iterable<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    @PostMapping(path = "/menu/tambah")
    public @ResponseBody String tambahMenu(Menu menu) {
        menuRepository.save(menu);
        return "Berhasil tambah menu";
    }

    @PutMapping(path = "/menu")
    public @ResponseBody String ubahMenu(Menu menu) {
        menuRepository.save(menu);
        return "Berhasil ubah menu";
    }

    @DeleteMapping(path = "/menu")
    public @ResponseBody String hapusMenu(@RequestParam Integer idMenu) {
        menuRepository.deleteById(idMenu);
        return "Berhasil hapus menu";
    }

    @PostMapping(path = "/menu/pesan")
    public @ResponseBody String pesanMenu(@RequestParam Integer idMenu, @RequestParam String nomorKTP, @RequestParam int jumlah) {
        User user = userRepository.findByNomorKTP(nomorKTP);
        Menu menu = menuRepository.findByIdMenu(idMenu);
        Pesanan pesanan = new Pesanan(null, jumlah, user, menu);
        pesananRepository.save(pesanan);
        return "Berhasil pesan menu";
    }

    @GetMapping(path = "/pesanan/harian")
    public @ResponseBody Iterable<Pesanan> getPesananHarian() {
        return pesananRepository.findByTanggalPesanan(Date.valueOf(LocalDate.now()));
    }

    @PutMapping(path = "/kursi/pesan")
    public @ResponseBody String pesanKursi(@RequestParam Integer nomorKursi, @RequestParam String nomorKTP) {
        User user = userRepository.findByNomorKTP(nomorKTP);
        Kursi kursi = kursiRepository.findByNomorKursi(nomorKursi);
        kursi.setUser(user);
        kursiRepository.save(kursi);
        return "Berhasil pesan kursi";
    }

    @PostMapping(path = "/kursi/tambah")
    public @ResponseBody String tambahKursi(Kursi kursi) {
        kursiRepository.save(kursi);
        return "Berhasil tambah kursi";
    }

    @GetMapping(path = "/kursi/tersedia")
    public @ResponseBody List<Kursi> getKursiTersedia() {
        return kursiRepository.findByUserIsNull();
    }

    @PostMapping(path = "/ruangan/tambah")
    public @ResponseBody String tambahRuangan(Ruangan ruangan) {
        ruanganRepository.save(ruangan);
        return "Berhasil tambah ruangan";
    }

    @GetMapping(path = "/ruangan/tersedia")
    public @ResponseBody List<Ruangan> getRuanganTersedia() {
        return ruanganRepository.findByUserIsNull();
    }

    @PutMapping(path = "/ruangan/booking")
    public @ResponseBody String bookingRuangan(@RequestParam Integer nomorRuangan, @RequestParam String nomorKTP) {
        User user = userRepository.findByNomorKTP(nomorKTP);
        Ruangan ruangan = ruanganRepository.findByNomorRuangan(nomorRuangan);
        ruangan.setUser(user);
        ruanganRepository.save(ruangan);
        return "Berhasil pesan ruangan";
    }

    @PutMapping(path = "/pulsa/beli")
    public @ResponseBody String beliPulsa(@RequestParam Integer idPulsa, @RequestParam String nomorKTP) {
        User user = userRepository.findByNomorKTP(nomorKTP);
        Pulsa pulsa = pulsaRepository.findByIdPulsa(idPulsa);
        pulsa.getUsers().add(user);
        pulsaRepository.save(pulsa);
        return "Berhasil beli pulsa";
    }

    @PostMapping(path = "/pulsa/tambah")
    public @ResponseBody String tambahPulsa(Pulsa pulsa) {
        pulsaRepository.save(pulsa);
        return "Berhasil tambah pulsa";
    }

    @PostMapping(path = "/pengantaran/pesan")
    public @ResponseBody String pesanPengantaran(Pengantaran pengantaran, @RequestParam String nomorKTP) {
        User user = userRepository.findByNomorKTP(nomorKTP);
        pengantaran.setUser(user);
        pengantaranRepository.save(pengantaran);
        return "Berhasil pesan pengantaran paket";
    }

    @GetMapping(path = "/pesanan")
    public @ResponseBody Iterable<Pesanan> getPesanan() {
        return pesananRepository.findAll();
    }

    @GetMapping(path = "/pesanan/{nomorKTP}")
    public @ResponseBody Iterable<Pesanan> getPesananByNoKTP (@RequestParam String nomorKTP) {
        return pesananRepository.findByUserNomorKTP(nomorKTP);
    }
}
