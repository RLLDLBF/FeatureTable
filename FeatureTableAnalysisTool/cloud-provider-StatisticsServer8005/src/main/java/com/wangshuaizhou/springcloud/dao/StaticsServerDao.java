package com.wangshuaizhou.springcloud.dao;

import com.wangshuaizhou.springcloud.entities.FeatureTable;
import com.wangshuaizhou.springcloud.entities.FeatureWeight;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaticsServerDao {
    @Insert("insert into featuretable(Appname,Funcname,Microservice,BackEndRelated,InfoTrans,DataStore,Search,Appearance,Preference,FuncExtension,Timeliness,SoftwareDev,Notification,DataComputation,HotKey) values (#{Appname},#{Funcname},#{Microservice},#{BackEndRelated},#{InfoTrans},#{DataStore},#{Search},#{Appearance},#{Preference},#{FuncExtension},#{Timeliness},#{SoftwareDev},#{Notification},#{DataComputation},#{HotKey})")
    public int InsertFeatureTable(FeatureTable featureTable);

    /*@Select("select * from payment where id = #{id}")
    public FeatureTable SelectById(@Param("id") Integer id);

    @Update("update payment set serial = #{serial} where id = #{id}")
    public int update(FeatureTable featureTable);

    @Delete("delete from payment where id = #{id}")
    public int delete(@Param("id") Long id);*/

    @Select("select * from featureweight")
    public List<FeatureWeight> SelectAllFeatureWeight();

    @Update("update featureweight set FeatureWeight = #{FeatureWeight} where FeatureName = #{FeatureName}")
    public int UpdateFeatureWeight(FeatureWeight featureWeight);

    @Select("select count(*) from featuretable where ${featureweight_name} = 1")
    public Integer SelectFeatureWeightAllNumberByName(@Param("featureweight_name") String featureweight_name);

    @Select("select count(*) from featuretable where ${featureweight_name} = 1 and Microservice = 1")
    public Integer SelectFeatureWeightMicroNumberByName(@Param("featureweight_name") String featureweight_name);

    @Select("select count(*) from featuretable")
    public Integer SelectFeatureWeightAllNumber();
}
