package br.com.tcc.skinguard.resource;

import br.com.tcc.skinguard.model.Admin;
import br.com.tcc.skinguard.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminResource {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/todos")
    public List<Admin> listarTodosAdmin(){
        return adminRepository.findAll(Sort.by("admin").ascending());
    }
}
