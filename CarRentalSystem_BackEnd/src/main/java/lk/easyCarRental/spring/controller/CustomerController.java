package lk.easyCarRental.spring.controller;

import lk.easyCarRental.spring.dto.CustomerDTO;
import lk.easyCarRental.spring.service.CustomerService;
import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity getAllCustomers() {
        ArrayList<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity(new ResponseUtil(200, "Done", allCustomers), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getCustomerById(@PathVariable String id) {
        CustomerDTO customer = customerService.getCustomerById(id);
        return new ResponseEntity(new ResponseUtil(200, "Done", customer), HttpStatus.CREATED);
    }

    @GetMapping(path = "/lastid")
    public ResponseEntity getMethod() {
        String lastCid = customerService.getLastCid();
        return new ResponseEntity(new ResponseUtil(200, "Done", lastCid), HttpStatus.CREATED);
    }

    @GetMapping("/get_image/{image}")
    public void getImages(@PathVariable String image, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg;charset=utf-8");
        response.setHeader("Content-Disposition", "inline; filename=girls.png");

        ServletOutputStream outputStream = response.getOutputStream();

        String path = "/Users/Amasha/Desktop/easyCarRentalStorage/customers/";

        outputStream.write(Files.readAllBytes(Paths.get(path).resolve(image)));
        outputStream.flush();
        outputStream.close();
    }

    @PostMapping(path = "/upload_image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadPhotos(@RequestPart("image") MultipartFile image) {
        try {
            String file_name = image.getOriginalFilename();

            InputStream inputStream = image.getInputStream();
            Path path = Paths.get("/Users/Amasha/Desktop/easyCarRentalStorage/customers/");

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            Files.copy(inputStream, path.resolve(file_name));
            return new ResponseEntity(new ResponseUtil(200, "Image Uploaded", null), HttpStatus.CREATED);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(new ResponseUtil(200, "Error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
