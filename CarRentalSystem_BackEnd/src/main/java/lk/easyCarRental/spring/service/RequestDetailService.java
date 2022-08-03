package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.RequestDetailDTO;

public interface RequestDetailService {
    void updateRequestMessage(RequestDetailDTO dto);

    void deleteRequestDetails(String rid, String vid);
}
