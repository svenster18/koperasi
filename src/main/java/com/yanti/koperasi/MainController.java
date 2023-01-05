package com.yanti.koperasi;

import com.yanti.koperasi.model.Kursi;
import com.yanti.koperasi.model.Menu;
import com.yanti.koperasi.model.User;
import com.yanti.koperasi.repository.KursiRepository;
import com.yanti.koperasi.repository.MenuRepository;
import com.yanti.koperasi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private KursiRepository kursiRepository;

    @PostMapping(path="/register")
    public @ResponseBody String register(User user) {
        userRepository.save(user);
        return "Customer Berhasil Didaftarkan";
    }

    @PostMapping(path="/login")
    public @ResponseBody String login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);
        if(user != null && user.getPassword().equals(password)) return "Login berhasil";
        else return "Username/Password salah";
    }

    @PutMapping(path = "/menu/pesan")
    public @ResponseBody String pesanMenu(@RequestParam Integer idMenu, @RequestParam String nomorKTP) {
        User user = userRepository.findByNomorKTP(nomorKTP);
        Menu menu = menuRepository.findByIdMenu(idMenu);
        user.getMenus().add(menu);
        userRepository.save(user);
        return "Berhasil pesan menu";
    }

    @PutMapping(path = "/kursi/pesan")
    public @ResponseBody String pesanKursi(@RequestParam Integer nomorKursi, @RequestParam String nomorKTP) {
        User user = userRepository.findByNomorKTP(nomorKTP);
        Kursi kursi = kursiRepository.findByNomorKursi(nomorKursi);
        kursi.setUser(user);
        kursiRepository.save(kursi);
        return "Berhasil pesan kursi";
    }

    @PostMapping(path = "/menu/tambah")
    public @ResponseBody String tambahMenu(Menu menu) {
        menuRepository.save(menu);
        return "Berhasil tambah menu";
    }

    @PostMapping(path = "/kursi/tambah")
    public @ResponseBody String tambahKursi(Kursi kursi) {
        kursiRepository.save(kursi);
        return "Berhasil tambah kursi";
    }
}
