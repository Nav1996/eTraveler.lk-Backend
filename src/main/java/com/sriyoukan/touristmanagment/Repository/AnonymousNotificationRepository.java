package com.sriyoukan.touristmanagment.Repository;
import com.sriyoukan.touristmanagment.model.AnonymousNotification;
import com.sriyoukan.touristmanagment.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AnonymousNotificationRepository extends MongoRepository<AnonymousNotification,String> {
}
