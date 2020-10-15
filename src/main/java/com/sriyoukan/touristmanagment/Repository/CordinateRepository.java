package com.sriyoukan.touristmanagment.Repository;

import com.sriyoukan.touristmanagment.model.Cordinate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CordinateRepository  extends MongoRepository<Cordinate,String> {


}
