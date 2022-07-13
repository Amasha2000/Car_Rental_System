package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.AdminDTO;


public interface AdminService {
    void saveAdmin(AdminDTO dto);
    void updateAdmin(AdminDTO dto);
    void deleteAdmin(String id);
    AdminDTO searchAdmin(String id);
}
