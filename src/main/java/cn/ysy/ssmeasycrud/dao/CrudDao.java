package cn.ysy.ssmeasycrud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.ysy.ssmeasycrud.domain.Crud;
import org.apache.ibatis.annotations.Update;

public interface CrudDao {
	
	@Select("select * from ssm_easy_crud")
	List<Crud> findAll();

	@Insert("insert into ssm_easy_crud(id,upperCase,lowerCase,number,other) values(#{id},#{upperCase},#{lowerCase},#{number},#{other})")
    void save(Crud crud);

	@Delete("delete from ssm_easy_crud where id = #{id}")
	void del(Long id);

	@Update("update ssm_easy_crud set upperCase=#{upperCase},lowerCase=#{lowerCase},number=#{number},other=#{other} where id = #{id}")
	void update(Crud crud);
}
