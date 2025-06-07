package com.entity.view;

import com.entity.WodedaihaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 我的待还
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-12-06 09:47:41
 */
@TableName("wodedaihai")
public class WodedaihaiView  extends WodedaihaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WodedaihaiView(){
	}
 
 	public WodedaihaiView(WodedaihaiEntity wodedaihaiEntity){
 	try {
			BeanUtils.copyProperties(this, wodedaihaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
