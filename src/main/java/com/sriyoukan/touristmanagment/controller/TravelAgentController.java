package com.sriyoukan.touristmanagment.controller;

import com.sriyoukan.touristmanagment.Repository.NotificationRepository;
import com.sriyoukan.touristmanagment.Repository.RegisteredPackageRepository;
import com.sriyoukan.touristmanagment.Repository.RoleRepository;
import com.sriyoukan.touristmanagment.Repository.UserRepository;
import com.sriyoukan.touristmanagment.model.Notification;
import com.sriyoukan.touristmanagment.model.RegisteredPackage;
import com.sriyoukan.touristmanagment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TravelAgentController {
    @Autowired
    public UserRepository travelAgentRepository;
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegisteredPackageRepository registeredPackageRepository;


    @PostMapping(value = "/getNotification")
    public List<Notification> getNotification(@RequestBody EmailBody email){
        return notificationRepository.findAllByToWhom(userRepository.findByEmail(email.getEmail()));
    }

    @PostMapping(value="sendNotification")
    public Boolean sendNotification(Notification notification){
        notificationRepository.insert(notification);

        return true;
    }
    @PostMapping(value="assignQuideToTour")
    public boolean assignQuide(@RequestBody RegisterPackBody registerPackBody){

        RegisteredPackage r = registeredPackageRepository.findRegisteredPackageById(registerPackBody.getPackId());
        User u = userRepository.findByEmail(registerPackBody.getUserId());
        if(r!= null && u!= null) {
            r.setQuide(u);
            registeredPackageRepository.save(r);
            Notification notification1 = new Notification();
            notification1.setDescription(String.format("%s you are added to tour  %s",u.getName(),r.getId()));
            notification1.setToWhom(u);
            notificationRepository.save(notification1);

            return true;
        }
        else{
            throw new UsernameNotFoundException("user or package not found");
        }
    }







}
