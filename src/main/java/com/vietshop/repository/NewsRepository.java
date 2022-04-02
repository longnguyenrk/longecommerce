package com.vietshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vietshop.Entity.News;

public interface NewsRepository extends JpaRepository<News,Long>{

}
