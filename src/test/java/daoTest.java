import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ysy.ssmeasycrud.dao.CrudDao;
import cn.ysy.ssmeasycrud.domain.Crud;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class daoTest {

	@Autowired
	private CrudDao crudDao;
	
	@Test
	public void testAll() {
		List<Crud> findAll = crudDao.findAll();
		System.err.println(findAll);
	}

	@Test
	public void test3(){

		String s= "dsa43AE24上电视看SAD你的.,.";
		StringBuilder big = new StringBuilder();
		StringBuilder small = new StringBuilder();
		StringBuilder number = new StringBuilder();
		StringBuilder other = new StringBuilder();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if(Character.isUpperCase(aChar)){
				big.append(aChar);
			}else if (Character.isLowerCase(aChar)){
				small.append(aChar);
			}else if (48<=aChar&&aChar<=57){
				number.append(aChar);
			}else {
				other.append(aChar);
			}
		}
		System.out.println(big.toString());
		System.out.println(small.toString());
		System.out.println(number.toString());
		System.out.println(other.toString());
	}

	@Test
	public void test4(){
		Crud crud = new Crud();
		crud.setOther("米好");
		crud.setNumber("234");
		crud.setLowerCase("asdae");
		crud.setUpperCase("QETWQ");
		crudDao.save(crud);
	}

	@Test
	public void test5(){
		crudDao.del(4l);
	}
	@Test
	public void test2(){
		Crud crud = new Crud(5l,"AAA","aaa","111","***");
		crudDao.update(crud);
	}
}
