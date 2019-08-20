package cn.ysy.ssmeasycrud.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ysy.ssmeasycrud.dao.CrudDao;
import cn.ysy.ssmeasycrud.domain.Crud;

@Service
public class CrudService {
	@Autowired
	private CrudDao crudDao;
	
	public List<Crud> findAll() {
		return crudDao.findAll();
	}

    public void save(Crud crud) {
		crudDao.save(crud);
    }

	public void del(Long id) {
		crudDao.del(id);
	}

	public void update(Crud crud) {
		crudDao.update(crud);
	}
}
