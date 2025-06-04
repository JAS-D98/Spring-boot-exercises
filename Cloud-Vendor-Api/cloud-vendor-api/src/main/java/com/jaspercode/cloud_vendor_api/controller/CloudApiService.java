package com.jaspercode.cloud_vendor_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaspercode.cloud_vendor_api.model.CloudVendor;

@RestController
@RequestMapping("/cloudvendor")
public class CloudApiService {

    CloudVendor cloudVendor;
    
    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId){
        return new CloudVendor("C1", "Vendor1", "Address One", "xxxxxx");
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor=cloudVendor;
        return "cloud member created successfully";
    }

}
