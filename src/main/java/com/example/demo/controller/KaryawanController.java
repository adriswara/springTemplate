package com.example.demo.controller;

import com.example.demo.model.Karyawan;
import com.example.demo.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/karyawan")
@CrossOrigin(origins = "http://localhost:5173")
public class KaryawanController {

    @Autowired
    private KaryawanRepository karyawanRepository;

    @GetMapping("/get")
    public List<Karyawan> getAllKaryawan() {
        return karyawanRepository.findAll();
    }

    @PostMapping("/post")
    public Karyawan createKaryawan(@RequestBody Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }


}
