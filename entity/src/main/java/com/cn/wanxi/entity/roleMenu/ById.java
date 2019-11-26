/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ById
 * Author:   Administrator
 * Date:     2019/11/26 9:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.wanxi.entity.roleMenu;

import lombok.Data;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/26
 * @since 1.0.0
 */
@Data
public class ById {
    private Map<String, Object> searchMap;
    private int roleid;
    private String menuid;

}