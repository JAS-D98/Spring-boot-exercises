package com.jaspercode.rest_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaspercode.rest_demo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{
    
}
