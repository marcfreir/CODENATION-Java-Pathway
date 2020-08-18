package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeEndpoint {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping
    public ResponseEntity<List<Challenge>> findByAccelerationIdAndUserId(@RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId, @RequestParam(value = "userId", required = false, defaultValue = "0") Long userId) {

        System.out.println(accelerationId + userId);
        List<Challenge> challengeList = challengeService.findByAccelerationIdAndUserId(accelerationId, userId);

        return ResponseEntity.ok().body(challengeList);
    }
}
