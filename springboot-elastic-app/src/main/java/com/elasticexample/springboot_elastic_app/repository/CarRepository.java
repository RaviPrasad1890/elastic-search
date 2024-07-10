package com.elasticexample.springboot_elastic_app.repository;

import com.elasticexample.springboot_elastic_app.model.CarModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CarRepository extends ElasticsearchRepository<CarModel,String> {

    List<CarModel> findAllByBrand(String brand);
}
