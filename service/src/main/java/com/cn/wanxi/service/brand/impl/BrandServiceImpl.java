package com.cn.wanxi.service.brand.impl;

import com.cn.wanxi.dao.brand.BrandDao;
import com.cn.wanxi.entity.brand.BrandEntity;
import com.cn.wanxi.entity.brand.ByPage;
import com.cn.wanxi.service.brand.IBrandService;
import com.cn.wanxi.utils.utils.Msg;
import com.cn.wanxi.utils.utils.MsgData;
import com.cn.wanxi.utils.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yaodan
 */
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandDao brandDao;

    /**
     * 【添加品牌信息】
     *
     * @param brand
     * @return
     */
    @Override
    public Msg add(BrandEntity brand) {
        //判断页面传的值中名字不能为空
//        String name = brand.getName() != null ? brand.getName().trim() : "";

        Msg msg;
        //正则表达式 匹配A-z之间任意一个英文字母，不能是中文或数字
        String reg = "[A-z]{1}";
        String letter = brand.getLetter();
        if (!(StringUtils.isEmpty(brand.getName())) && (null != brand.getSeq()) && letter.matches(reg)) {
            int result = brandDao.insert(brand);
            if (result == 1) {
                msg = new Msg(0, "新增成功");
            } else {
                msg = new Msg(1, "新增失败");
            }
        } else {
            msg = new Msg(1, "名字和排序不能为空且首字母只能为任意一位英文字母，不能是中文或数字");
        }
        return msg;
    }

    /**
     * 【查询所有品牌信息】
     *
     * @return
     */
    @Override
    public Msg findAll() {
        Msg msg;
        List<Map<String, Object>> maps = brandDao.queryAll();
        //判断集合是否有数据，如果没有数据返回失败
        //对List进行判空时，需要使用两个条件：先使用 list == null判断list是否初始化后，再使用 list .size == 0判断是否为空。
        if (null != maps && maps.size() > 0) {
//            msg = new Msg(0, maps);
            msg = new Msg(0, "查询成功", new MsgData(maps, maps.size()));
        } else {
            msg = new Msg(1, "数据库中没有数据");
        }
        return msg;
    }

    /**
     * 【根据id查询】
     *
     * @param id
     * @return
     */
    @Override
    public Msg findById(Integer id) {
        Msg msg;
        if (!StringUtils.isEmpty(id) && id > 0) {
            BrandEntity brand = brandDao.findById(id);
            //判断是否有返回的数据
            List<BrandEntity> list = new ArrayList<>();
            list.add(brand);
            if (!ObjectUtils.isEmpty(brand)) {
                msg = new Msg(0, "查询成功", new MsgData(list, list.size()));
            } else {
                msg = new Msg(1, "未查询到数据,该品牌不存在");
            }
        } else {
            msg = new Msg(1, "请正确输入id");
        }
        return msg;
    }

    /**
     * 【根据id修改】
     *
     * @param brandEntity
     * @param
     * @return
     */
    @Override
    public Msg update(BrandEntity brandEntity) {
        Msg msg;
        //获取前台传的id
        Integer id = brandEntity.getId();

        //正则表达式 匹配A-z之间任意一个英文字母，不能是中文或数字
        String reg = "[A-z]{1}";
        String letter = brandEntity.getLetter();

        //判断id 是否为空
        if (!StringUtils.isEmpty(id)) {
            BrandEntity brand = brandDao.findById(id);
            //判断是否查询到该品牌信息
            if (!ObjectUtils.isEmpty(brand)) {
                //规定letter只能是一个英文字母
                if (letter.matches(reg)) {
                    //查询到品牌信息，开始修改
                    int result = brandDao.update(brandEntity);
                    if (result == 1) {
                        msg = new Msg(0, "修改成功");
                    } else {
                        msg = new Msg(1, "修改失败");
                    }
                } else {
                    msg = new Msg(1, "首字母只能为任意一位英文字母，不能是中文或数字");
                }
            } else {
                msg = new Msg(1, "未查到该品牌信息,该品牌不存在");
            }
        } else {
            msg = new Msg(1, "请确保是正确的id");
        }
        return msg;
    }


    /**
     * 【根据id删除】
     *
     * @param id
     * @return
     */
    @Override
    public Msg deleteById(Integer id) {
        Msg msg;
        if (!StringUtils.isEmpty(id)) {
            int result = brandDao.deleteById(id);
            if (result == 1) {
                msg = new Msg(0, "删除成功");
            } else {
                msg = new Msg(1, "该品牌信息不存在");
            }
        } else {
            msg = new Msg(1, "请确保id是正确的");
        }
        return msg;
    }


    /**
     * 【条件查询】
     *
     * @param brandEntity
     * @return
     */
    @Override
    public Msg findList(BrandEntity brandEntity) {
        Msg msg;
        List<Map<String, Object>> list = brandDao.findList(brandEntity);
        if (null != list && list.size() > 0) {
            msg = new Msg(0, "查询成功", new MsgData(list, list.size()));
        } else {
            msg = new Msg(1, "该品牌信息不存在");
        }
        return msg;
    }

    /**
     * 分页查询
     *
     * @param
     * @param
     * @return
     */

    @Override
    public Msg findAllbyPage(Map<String, Integer> param) {
        //实例化 分页实体类
        int page = param.get("page");
        int size = param.get("size");
        PageList pageList = new PageList();

        //处理int类型的变量为空时
        if (page == 0) {
            page = 1;
        }
        if (size == 0) {
            page = 30;
        }
        List<Map<String, Object>> list = brandDao.findAllbyPage(page, size);
        return getMsg(page, size, pageList, list);
    }


    /**
     * 统计所有数据
     *
     * @return
     */
    @Override
    public int countAll() {
        return brandDao.countAll();
    }

    /**
     * 【分页+条件查询】
     *
     * @param
     * @param
     * @param
     * @return
     */
    @Override
    public Msg findListAndPage(ByPage byPage) {
        int page = byPage.getPage();
        int size = byPage.getSize();
        BrandEntity brandEntity = new BrandEntity();
        Object name = byPage.getSearchMap().get("name");
        if (name != null) {
            brandEntity.setName(name.toString());
        }
        Object letter = byPage.getSearchMap().get("letter");
        if (letter != null) {
            brandEntity.setLetter(letter.toString());
        }
        //实例化 分页实体类
        PageList pageList = new PageList();
        List<Map<String, Object>> list = brandDao.findListAndPage(brandEntity, page, size);
        return getMsg(page, size, pageList, list);
    }

    @Override
    public Msg findIdAndName() {
        Msg msg;
        List<Map<String, Object>> list = brandDao.queryNameId();
        //判断集合是否有数据，如果没有数据返回失败
        //对List进行判空时，需要使用两个条件：先使用 list == null判断list是否初始化后，再使用 list .size == 0判断是否为空。
        if (null != list && list.size() > 0) {
            msg = new Msg(0, "查询成功", new MsgData(list, list.size()));
        } else {
            msg = new Msg(1, "数据库中没有数据");
        }
        return msg;
    }


    /**
     * 【分页查询+条件分页查询】 公共方法
     *
     * @param page
     * @param size
     * @param pageList
     * @param list
     * @return
     */
    private Msg getMsg(int page, int size, PageList pageList, List<Map<String, Object>> list) {
        Msg msg;
        if (null != list && list.size() > 0) {
            //把查询出来的对象封装在分页实体类中
            pageList.setList(list);
            //统计所有数据的总行数
            int totalRows = brandDao.countAll();

            //把页数封装在分页实体类中
            pageList.setPage(page);
            pageList.setTotal(list.size());
            //查询出来的总行数封装在分页实体类中
            pageList.setTotalRows(totalRows);
            int pages = 0;

            if (totalRows % size == 0) {
                pages = totalRows / size;
            } else {
                pages = totalRows / size + 1;
            }
            System.out.println("目前分页的总页数是" + pages);
            //总页数
            pageList.setPages(pages);
            List<PageList> map = new ArrayList<>();
            map.add(pageList);
            msg = new Msg(0, new MsgData(map, map.size()));
        } else {
            msg = new Msg(1, "未查询到相关品牌的信息");
        }
        return msg;
    }

}
