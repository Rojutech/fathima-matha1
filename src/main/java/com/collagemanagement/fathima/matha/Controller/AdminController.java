package com.collagemanagement.fathima.matha.Controller;

import com.collagemanagement.fathima.matha.Service.AdminService;
import com.collagemanagement.fathima.matha.dao.Admin;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostConstruct
    private void createAdmin(){

        adminService.createAdmin();

    }
    //get all admins method

    @GetMapping("/admins")
    private List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();

    }
    //get one admin
    @GetMapping("/admins/{id}")
    public Optional<Admin> getoneAdmin(@PathVariable int id){
        return adminService.getoneAdmin(id);
    }

    //to delete admin

    @RequestMapping(method = RequestMethod.DELETE,value="/admins/{id}")
    private void deleteAdmin(@PathVariable int id ){
        adminService.deleteAdmin(id);
    }
      ////to add
    @RequestMapping(method =RequestMethod.POST,value = "/admins")
    private void addAdmins(@RequestBody Admin admins){
        adminService.addAdmin(admins);

    }
    //update using id
    @RequestMapping(method = RequestMethod.PUT,value = "/admins/{id}" )
    private void updateAdmins(@RequestBody Admin admins,@PathVariable int id){
        adminService.updateAdmin(admins,id);

    }




}
