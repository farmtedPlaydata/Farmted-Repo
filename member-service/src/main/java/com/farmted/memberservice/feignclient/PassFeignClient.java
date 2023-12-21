package com.farmted.memberservice.feignclient;

import com.farmted.memberservice.vo.PassVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "pass-service", path = "/pass-service")
public interface PassFeignClient {

    @GetMapping("/allpass")
    ResponseEntity<?> findAll(@RequestParam(required = false, defaultValue = "0", value = "page") int pageNo);

    @GetMapping("/findbyemail/{email}")
    ResponseEntity<?> findByEmail(@PathVariable String email);

    @PostMapping("/reissue/{uuid}")
    ResponseEntity<?> reIssue(@PathVariable String uuid);

    @PutMapping("/update-role")
    ResponseEntity<?> updateRole(@RequestBody PassVo passVo);
}
