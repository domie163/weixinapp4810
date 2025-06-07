package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WodedaihaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WodedaihaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WodedaihaiView;


/**
 * 我的待还
 *
 * @author 
 * @email 
 * @date 2022-12-06 09:47:41
 */
public interface WodedaihaiService extends IService<WodedaihaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodedaihaiVO> selectListVO(Wrapper<WodedaihaiEntity> wrapper);
   	
   	WodedaihaiVO selectVO(@Param("ew") Wrapper<WodedaihaiEntity> wrapper);
   	
   	List<WodedaihaiView> selectListView(Wrapper<WodedaihaiEntity> wrapper);
   	
   	WodedaihaiView selectView(@Param("ew") Wrapper<WodedaihaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodedaihaiEntity> wrapper);
   	

}

