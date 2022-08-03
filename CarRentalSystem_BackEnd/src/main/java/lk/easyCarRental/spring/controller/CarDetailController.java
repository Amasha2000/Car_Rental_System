package lk.easyCarRental.spring.controller;


import lk.easyCarRental.spring.dto.CarDetailDTO;
import lk.easyCarRental.spring.service.CarDetailService;
import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/vehicle_detail")
@CrossOrigin
public class CarDetailController {

    @Autowired
    private CarDetailService vehicleDetailService;


    @GetMapping(path = "/lastid")
    public ResponseEntity getLastVdid() {
        String lastVDID = vehicleDetailService.getLastVDID();
        return new ResponseEntity(new ResponseUtil(200, "Done", lastVDID), HttpStatus.CREATED);
    }

    @GetMapping(path = "get/{id}")
    public ResponseEntity getDriverDetailById(@PathVariable String id) {
        String vehicleId = vehicleDetailService.checkAvailability(id);
        System.out.println(id);
        return new ResponseEntity(new ResponseUtil(200, "Done", vehicleId), HttpStatus.OK);
    }

    @GetMapping("/get_images/{image}")
    public void getImages(@PathVariable String image, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg;charset=utf-8");
        response.setHeader("Content-Disposition", "inline; filename=girls.png");

        String[] split = image.split("-", 2);

        ServletOutputStream outputStream = response.getOutputStream();

        String path = "/Users/Amasha/Desktop/easyCarRentalStorage/vehicles/" + split[0];

        outputStream.write(Files.readAllBytes(Paths.get(path).resolve(image)));
        outputStream.flush();
        outputStream.close();
    }

    @PostMapping(path = "/upload_images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadPhotos(@RequestPart("image") MultipartFile image) {
        try {
            String file_name = image.getOriginalFilename();
            String[] split = file_name.split("-", 2);

            InputStream inputStream = image.getInputStream();
            Path path = Paths.get("/Users/Amasha/Desktop/easyCarRentalStorage/vehicles/" + split[0]);

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

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteVehicle(@RequestParam String id) {
        vehicleDetailService.deleteVehicle(id);
        return new ResponseEntity(new ResponseUtil(200, "Vehicle is deleted!!", null), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_images", params = {"id"})
    public ResponseEntity deleteVehicleImages(@RequestParam String id) {

        try {
            // create a new file object
            File directory = new File("/Users/Amasha/Desktop/easyCarRentalStorage/vehicles/" + id);

            // list all the files in an array
            File[] files = directory.listFiles();

            // delete each file from the directory
            for (File file : files) {
                file.delete();
            }

            // delete the directory
            if (directory.delete()) {
                return new ResponseEntity(new ResponseUtil(200, "Vehicle images are deleted!!", null), HttpStatus.OK);
            } else {
                return new ResponseEntity(new ResponseUtil(200, "Directory not Found!!", null), HttpStatus.OK);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return new ResponseEntity(new ResponseUtil(200, "Vehicle images are not found!!", null), HttpStatus.NOT_FOUND);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVehicle(@RequestBody CarDetailDTO dto) {
        vehicleDetailService.updateVehicle(dto);
        return new ResponseEntity(new ResponseUtil(200, "Vehicle updated successfully!", null), HttpStatus.OK);
    }

    @PutMapping(path = "/update_availability", params = {"id", "status"})
    public ResponseEntity updateVehicleAvailability(@RequestParam String id, @RequestParam String status) {
        vehicleDetailService.updateVehicleAvailability(id, status);
        return new ResponseEntity(new ResponseUtil(200, "Vehicle availability updated successfully!", null), HttpStatus.OK);
    }
}
