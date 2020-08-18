package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateEndpoint {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable(value = "userId") Long userId, @PathVariable(value = "companyId") Long companyId, @PathVariable(value = "accelerationId") Long accelerationId) {
        return (new ResponseEntity<CandidateDTO>(this.candidateMapper.map(this.candidateService.findById(userId, companyId, accelerationId).orElse(new Candidate())), HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> findAllByCompanyId(@RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId, @RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId) {
        List<Candidate> candidateList = new ArrayList<>();

        if (companyId != 0)
        {
            candidateList.addAll(candidateService.findByCompanyId(companyId));
        }
        if (accelerationId != 0)
        {
            candidateList.addAll(candidateService.findByAccelerationId(accelerationId));
        }

        return (new ResponseEntity<List<CandidateDTO>>(this.candidateMapper.map(candidateList), HttpStatus.OK));
    }
}
