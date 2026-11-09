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

    @GetMapping
    public List<Karyawan> getAllKaryawan() {
        return karyawanRepository.findAll();
    }

    @PostMapping
    public Karyawan createKaryawan(@RequestBody Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }

    @DeleteMapping("/{karyawanId}")
    public void deleteKaryawan(@PathVariable long karyawanId) {
        karyawanRepository.deleteById(karyawanId);
    }

    @PutMapping("/{karyawanId}")
    public Karyawan editKaryawan(@PathVariable long karyawanId, @RequestBody Karyawan updatedKaryawan) {
        return karyawanRepository.findById(karyawanId).map(karyawan -> {
            karyawan.setName(updatedKaryawan.getName());
            karyawan.setNik(updatedKaryawan.getNik());
            return karyawanRepository.save(karyawan);
        }).orElseGet(() ->{
            updatedKaryawan.setId(karyawanId);
            return karyawanRepository.save(updatedKaryawan);
        });
    }


}
