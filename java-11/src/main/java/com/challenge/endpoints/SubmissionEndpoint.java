package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionEndpoint {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping
    ResponseEntity<List<SubmissionDTO>> findByChallengeIdAndAccelerationId(@RequestParam(value = "challengeId", required = true) Long challengeId, @RequestParam(value = "accelerationId", required = true) Long accelerationId) {
        return (new ResponseEntity<List<SubmissionDTO>>(this.submissionMapper.map(this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId)), HttpStatus.OK));
    }
}
