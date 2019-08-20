package cn.ysy.ssmeasycrud.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.ysy.ssmeasycrud.domain.Crud;
import cn.ysy.ssmeasycrud.service.CrudService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/crud")
@Api(value = "接口",description = "测试ssmSwagger")
public class CrudController {
    @Autowired
    private CrudService crudService;

    @RequestMapping("/findAll")
    @ApiOperation("查询全部")
    public List<Crud> findAll(){

        List<Crud> list = crudService.findAll();


        return list;
    }

    @ApiOperation("添加")
    @RequestMapping("/add")
    public String input(String text){
        try {
            text = new String(text.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder big = new StringBuilder();
        StringBuilder small = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder other = new StringBuilder();
        char[] chars = text.toCharArray();
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
        Crud crud = new Crud();
        crud.setLowerCase(small.toString());
        crud.setUpperCase(big.toString());
        crud.setNumber(number.toString());
        crud.setOther(other.toString());
        try {
            crudService.save(crud);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "添加OK";
    }

    @RequestMapping("/del")
    public String del(Long id){
        try {
            crudService.del(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }
    @RequestMapping("/update")
    public String update(@RequestBody Crud crud){

        try {
            crudService.update(crud);
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败";
        }
        return "修改成功";
    }

}
