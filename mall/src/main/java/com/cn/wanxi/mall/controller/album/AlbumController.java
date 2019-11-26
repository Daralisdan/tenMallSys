package com.cn.wanxi.mall.controller.album;

import com.cn.wanxi.entity.album.AlbumEntity;
import com.cn.wanxi.entity.brand.BrandEntity;

import com.cn.wanxi.service.album.IAlbumService;
import com.cn.wanxi.utils.utils.Msg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**【图片库管理】：用于存储商品图片的空间，一个图片库（相册）下有多张图片
 * 数据表： wx_tab_album （相册表）
 *
 * 2019/11/26,Create by lxh
 */
@RestController
@RequestMapping("/photoes")
public class AlbumController {

    @Autowired
    private IAlbumService iAlbumService;

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Msg add(@RequestBody AlbumEntity albumEntity) {
        Msg msg = null;
        if (null != albumEntity.getTitle() && albumEntity.getTitle().trim() != "") {
            int result = iAlbumService.insert(albumEntity);
            if (0 != result) {
                msg = Msg.success();
            }
        } else {
            msg = Msg.fail().messageData("名字不能为空");
        }
        return msg;
    }

    /**
     * 【展示所有品牌信息】
     *
     * @return
     */
    @PostMapping("/findAll")
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> list = iAlbumService.queryAll();
        //判断集合是否有数据，如果没有数据返回失败
        if (list.isEmpty()) {
            msg = Msg.fail().messageData("数据库中没有数据");
        } else {
            msg = Msg.success().messageData(list);
        }
        return msg;
    }

    /**
     * 【根据品牌id查询信息】
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
        Msg msg = null;
        int id = param.get("id");
        if (!StringUtils.isEmpty(id) && id > 0) {
            AlbumEntity byId = iAlbumService.findById(id);
            //判断是否有返回的数据
            if (!ObjectUtils.isEmpty(byId)) {
                msg = Msg.success().messageData(byId);
            } else {
                msg = Msg.fail().messageData("该相册不存在");
            }
        }
        return msg;
    }
    /**
     * 【修改品牌信息】根据id查询
     *
     * @param albumEntity
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg update(@RequestBody AlbumEntity albumEntity) {
        Msg msg = null;
        //先获取id
        int id = albumEntity.getId();
        if (id > 0) {
            //根据id查询数据
            AlbumEntity byId = iAlbumService.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(byId)) {
                int result = iAlbumService.update(albumEntity);
                if (result > 0) {
                    msg = Msg.success().messageData(albumEntity);
                }
            } else {
                msg = Msg.fail().messageData("该相册不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }

    /**
     * 【根据id删除】
     * 前端传的json数据可以用 map或者对象接收
     * 该方法用对象接收json对象数据
     *
     * @param
     * @return
     * @RequestParam(required = true) int id  提示必须输入id
     */
    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "根据id删除数据")
    public Msg deleteById(@RequestBody AlbumEntity albumEntity) {
        Msg msg = null;
        int id = albumEntity.getId();
        if (id > 0) {
            int i = iAlbumService.deleteById(id);
            if (i > 0) {
                msg = Msg.success().messageData("删除成功");
            } else {
                msg = Msg.fail().messageData("删除失败,该用户不存在");
            }
        } else {
            msg = Msg.fail().messageData("请输入id");
        }
        return msg;
    }

}
