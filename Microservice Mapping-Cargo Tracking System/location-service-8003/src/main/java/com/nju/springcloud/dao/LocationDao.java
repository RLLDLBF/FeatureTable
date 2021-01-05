package com.nju.springcloud.dao;

import com.nju.springcloud.entities.locationVersion2.LocationVersion2;
import org.apache.ibatis.annotations.Insert;

public interface LocationDao {
    @Insert("insert into location(unlocode,name) values(#{unlocode},#{name})")
    Integer create(LocationVersion2 location);
}
