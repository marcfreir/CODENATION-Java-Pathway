package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationEndpoint {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Acceleration>(this.accelerationService.findById(id).orElse(new Acceleration()), HttpStatus.OK);
    }

    @GetMapping
    public List<Acceleration> findAllByCompanyId(@RequestParam(name = "companyId", required = false, defaultValue = "0") Long companyId) {
        return this.accelerationService.findByCompanyId(companyId);
    }
}
