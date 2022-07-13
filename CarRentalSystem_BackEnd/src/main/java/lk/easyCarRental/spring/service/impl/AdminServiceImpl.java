package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.AdminDTO;
import lk.easyCarRental.spring.entity.Admin;
import lk.easyCarRental.spring.repo.AdminRepo;
import lk.easyCarRental.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if(!adminRepo.existsById(dto.getAdminId())){
            adminRepo.save(modelMapper.map(dto, Admin.class));
        }else{
            throw new RuntimeException("Admin Already Exists");
        }
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if(adminRepo.existsById(dto.getAdminId())){
            adminRepo.save(modelMapper.map(dto,Admin.class));
        }else{
            throw new RuntimeException("No such admin to update");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if(adminRepo.existsById(id)){
            adminRepo.deleteById(id);
        }else{
            throw new RuntimeException("No such admin to delete");
        }
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if(adminRepo.existsById(id)){
            return modelMapper.map(adminRepo.findById(id),AdminDTO.class);
        }else{
            throw new RuntimeException("Nos such admin");
        }
    }
}
