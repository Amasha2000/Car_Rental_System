package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.CustomDTO;
import lk.easyCarRental.spring.dto.RequestDTO;
import lk.easyCarRental.spring.entity.Request;
import lk.easyCarRental.spring.exception.ValidationException;
import lk.easyCarRental.spring.repo.RequestRepo;
import lk.easyCarRental.spring.service.RequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addRequest(RequestDTO dto) {
        if (requestRepo.existsById(dto.getRid())) {
            throw new ValidationException("Request is already in the system..");
        } else {
            Request request = mapper.map(dto, Request.class);
            requestRepo.save(request);
        }
    }

    @Override
    public void deleteRequest(String id) {
        if (requestRepo.existsById(id)) {
            requestRepo.deleteById(id);
        } else {
            throw new ValidationException("There is no request matches in the system..");
        }
    }

    @Override
    public void updateRequest(RequestDTO dto) {
        if (requestRepo.existsById(dto.getRid())) {
            Request request = mapper.map(dto, Request.class);
            requestRepo.save(request);
        } else {
            throw new ValidationException("There is no request matches in the system..");
        }
    }

    @Override
    public ArrayList<RequestDTO> findAllRequests() {
        List<Request> all = requestRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<Request>>() {
        }.getType());
    }

    @Override
    public RequestDTO findRequestById(String id) {
        Optional<Request> request = requestRepo.findById(id);
        if (request.isPresent()) {
            Request rq = request.get();
            return mapper.map(rq, RequestDTO.class);
        } else {
            throw new ValidationException("There is no any matching Requests in the system!");
        }
    }

    @Override
    public ArrayList<RequestDTO> findRequestByCid(String cid) {
        ArrayList<Request> all = requestRepo.findRequestByCId(cid);
        return mapper.map(all, new TypeToken<ArrayList<RequestDTO>>() {
        }.getType());
    }

    @Override
    public String getLastRid() {
        return requestRepo.geLastRid();
    }

    @Override
    public ArrayList<RequestDTO> getAllRequests() {
        List<Request> all = requestRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<RequestDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<CustomDTO> test(String id) {
        ArrayList<Object[]> test = requestRepo.test(id);
        ArrayList<CustomDTO> all = new ArrayList<>();
        for (Object[] o : test) {
            all.add(new CustomDTO(
                    o[0].toString(),
                    o[1].toString(),
                    o[2].toString(),
                    Integer.parseInt(o[3].toString())
            ));
        }

        return all;
    }

    @Override
    public void deleteRequestDetails(String rid) {
        if (requestRepo.existsById(rid)) {
            requestRepo.deleteById(rid);
        }
    }
}
