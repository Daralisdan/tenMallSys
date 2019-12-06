package com.cn.wanxi.mall.controller.brand;

import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.brand.ByPage;
import com.cn.wanxi.service.brand.IBrandService;
import com.cn.wanxi.utils.utils.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 【品牌管理模块】
 * <p>
 * 数据表： wx_tab_brand	品牌表
 *
 * @author 2019/11/16,Create by yaodan
 */

/**
 * @CrossOrigin 解决跨域问题
 */
@CrossOrigin
@RestController
@RequestMapping("/brand")
@Api(tags = "品牌管理模块的接口")
public class BrandController {

    @Autowired
    private IBrandService iBrandService;

    @Value("${spring.resources.static-locations}")
    private String path;

    @Value("${spring.mvc.static-path-pattern}")
    private String imageFileName;

    /**
     * 【添加品牌信息】
     *
     * @return
     */
    @ApiOperation(value = "添加品牌信息接口")
    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody BrandEntity brandEntity) {
        return iBrandService.add(brandEntity);
    }

    /**
     * 【展示所有品牌信息】
     *
     * @return
     */
    @ApiOperation(value = "展示所有品牌信息")
    @PostMapping("/findAll")
    public Msg findAll() {
        return iBrandService.findAll();
    }

    /**
     * 【根据品牌id查询信息】
     * <p>
     * 前端传的json数据可以用 map或者对象接收
     * 该方法用map接收json对象数据
     *
     * @param
     * @return
     * @RequestParam(required = true) int id  提示必须输入id
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/findById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg findById(@RequestBody Map<String, Integer> param) {
        int id = param.get("id");
        return iBrandService.findById(id);
    }

    /**
     * 【修改品牌信息】
     * <p>
     * 根据id查询
     *
     * @param
     * @return
     */
    @ApiOperation(value = "根据id查询修改品牌信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg update(@RequestBody BrandEntity brandEntity) {
        return iBrandService.update(brandEntity);
    }

    /**
     * 【根据id删除】
     * <p>
     * 前端传的json数据可以用 map或者对象接收
     * 该方法用对象接收json对象数据
     *
     * @param
     * @return
     * @RequestParam(required = true) int id  提示必须输入id
     */
    @ApiOperation(value = "根据id删除数据")
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Msg deleteById(@RequestBody BrandEntity brandEntity) {
        Integer id = brandEntity.getId();
        return iBrandService.deleteById(id);
    }


    /**
     * 【条件查询】
     *
     * @return
     */
    @ApiOperation(value = "条件查询")
    @RequestMapping(value = "/findList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg findList(@RequestBody BrandEntity brandEntity) {
        return iBrandService.findList(brandEntity);
    }

    /**
     * 【分页查询】
     *
     * @param param page 当前页码 size 当前页记录数
     * @return
     */
    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/findPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg findAllbyPager(@RequestBody Map<String, Integer> param) {
        return iBrandService.findAllbyPage(param);
    }

    /**
     * 【根据条件分页查询】
     *
     * @return
     */
    @ApiOperation(value = "根据条件分页查询")
    @RequestMapping(value = "/findPageCon", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg findByConditionPage(@RequestBody ByPage byPage) {
        return iBrandService.findListAndPage(byPage);
    }

    @ApiOperation(value = "查询所有的品牌名")
    @PostMapping(value = "/findIdAndName")
    public Msg findIdAndName() {
        return iBrandService.findIdAndName();
    }


}
