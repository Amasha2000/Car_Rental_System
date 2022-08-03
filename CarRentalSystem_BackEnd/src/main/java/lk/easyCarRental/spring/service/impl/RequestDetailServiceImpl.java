package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.RequestDetailDTO;
import lk.easyCarRental.spring.entity.Car;
import lk.easyCarRental.spring.entity.Request;
import lk.easyCarRental.spring.entity.RequestDetail;
import lk.easyCarRental.spring.exception.NotFoundException;
import lk.easyCarRental.spring.repo.RequestDetailRepo;
import lk.easyCarRental.spring.service.RequestDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RequestDetailServiceImpl implements RequestDetailService {

    @Autowired
    private RequestDetailRepo requestDetailRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void updateRequestMessage(RequestDetailDTO dto) {
        RequestDetail requestDetail = mapper.map(dto, RequestDetail.class);
        requestDetailRepo.save(requestDetail);
    }

    @Override
    public void deleteRequestDetails(String rid, String vid) {
        Request request = new Request();
        Car vehicle = new Car();
        request.setRid(rid);
        vehicle.setCarId(vid);
        if (requestDetailRepo.existsByRequest(request)) {
            requestDetailRepo.deleteByRequestAndVehicle(request, vehicle);
        } else {
            throw new NotFoundException("Request Details not found!");
        }
    }
}
