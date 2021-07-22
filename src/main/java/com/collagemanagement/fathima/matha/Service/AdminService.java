package com.collagemanagement.fathima.matha.Service;

import com.collagemanagement.fathima.matha.dao.Admin;
import com.collagemanagement.fathima.matha.jparepository.AdminRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepositary adminRepositary;

    private List<Admin> admins=new ArrayList<>(
            Arrays.asList(
                    new Admin(1,"roju","roju@gmail.com","777651431","rojur"),
                    new Admin(2,"raju","raju@gmail.com","1233456672","raju")
            )
    );

    public void createAdmin() {
        adminRepositary.saveAll(admins);


    }

    public List<Admin> getAllAdmin() {

        return adminRepositary.findAll();

    }

    public Optional<Admin> getoneAdmin(int id) {
        return adminRepositary.findById(id);
    }


    public void deleteAdmin(int id) {
        adminRepositary.deleteById(id);
    }

    public void addAdmin(Admin admin) {
        adminRepositary.save(admin);

    }

    public void updateAdmin(Admin admins, int id) {
    Optional<Optional<Admin>>admin=Optional.ofNullable(adminRepositary.findById(id));
    if (admin.isPresent()){
        admins.setId(id);
        adminRepositary.save(admins);

    }

    }
}
