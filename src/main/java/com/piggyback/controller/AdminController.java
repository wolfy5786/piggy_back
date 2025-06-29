package com.piggyback.controller;

import com.piggyback.dto.AdminDTO;
import com.piggyback.model.Admin;
import com.piggyback.model.User;
import com.piggyback.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService)
    {
        this.adminService = adminService;
    }
    @GetMapping("/test")
    public String test_Admin()
    {
        System.out.println("hey there");
        return  "Hey there";
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody AdminDTO adminDTO) throws Exception {
//        System.out.println("got my request");
//        System.out.println(admin.toString());
//        if (admin==null) //change exception type
//        {
//            throw new Exception("admin object null");
//        }
//        Admin result = adminService.createAdmin(admin);
//
//        if (result==null)
//        {
//            System.out.println("admin object exist");
//            return new ResponseEntity<>(result,HttpStatus.CONFLICT);
//        }
//        return new ResponseEntity<Admin>(result, HttpStatus.CREATED);
        return null;
    }

    @GetMapping("all_users")
    public ResponseEntity<List<User>> fetchAllUsers()
    {
        List<User> list =null;
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
