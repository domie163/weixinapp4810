package com.entity.view;

import com.entity.CuihaitixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 催还提醒
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-12-06 09:47:41
 */
@TableName("cuihaitixing")
public class CuihaitixingView  extends CuihaitixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CuihaitixingView(){
	}
 
 	public CuihaitixingView(CuihaitixingEntity cuihaitixingEntity){
 	try {
			BeanUtils.copyProperties(this, cuihaitixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
