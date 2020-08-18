package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyEndpoint {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable("id") Long id) {
        return (new ResponseEntity<Company>(this.companyService.findById(id).orElse(new Company()), HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<List<Company>> findByAccelerationIdOrUserId(@RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId, @RequestParam(value = "userId", required = false, defaultValue = "0") Long userId) {

        List<Company> companyList = new ArrayList<>();

        if (accelerationId != 0) {
            companyList.addAll(this.companyService.findByAccelerationId(accelerationId));
        }

        if (userId != 0) {
            companyList.addAll(this.companyService.findByUserId(userId));
        }

        return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);
    }
}
