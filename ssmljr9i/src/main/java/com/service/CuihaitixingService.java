package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CuihaitixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CuihaitixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CuihaitixingView;


/**
 * 催还提醒
 *
 * @author 
 * @email 
 * @date 2022-12-06 09:47:41
 */
public interface CuihaitixingService extends IService<CuihaitixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CuihaitixingVO> selectListVO(Wrapper<CuihaitixingEntity> wrapper);
   	
   	CuihaitixingVO selectVO(@Param("ew") Wrapper<CuihaitixingEntity> wrapper);
   	
   	List<CuihaitixingView> selectListView(Wrapper<CuihaitixingEntity> wrapper);
   	
   	CuihaitixingView selectView(@Param("ew") Wrapper<CuihaitixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CuihaitixingEntity> wrapper);
   	

}

