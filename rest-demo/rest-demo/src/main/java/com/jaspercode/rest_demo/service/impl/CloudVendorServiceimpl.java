package com.jaspercode.rest_demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jaspercode.rest_demo.exception.CloudVendorNotFoundException;
import com.jaspercode.rest_demo.model.CloudVendor;
import com.jaspercode.rest_demo.repository.CloudVendorRepository;
import com.jaspercode.rest_demo.service.CloudVendorService;

@Service
public class CloudVendorServiceimpl implements CloudVendorService {
    
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceimpl(CloudVendorRepository cloudVendorRepository){
        this.cloudVendorRepository=cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor){
        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor){
        // Business logic
        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId){
        // Business logic
        cloudVendorRepository.deleteById(cloudVendorId);
        return "success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {

        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested client vendor does not exist!");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
    
}
