package com.dao;

import com.entity.CuihaitixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CuihaitixingVO;
import com.entity.view.CuihaitixingView;


/**
 * 催还提醒
 * 
 * @author 
 * @email 
 * @date 2022-12-06 09:47:41
 */
public interface CuihaitixingDao extends BaseMapper<CuihaitixingEntity> {
	
	List<CuihaitixingVO> selectListVO(@Param("ew") Wrapper<CuihaitixingEntity> wrapper);
	
	CuihaitixingVO selectVO(@Param("ew") Wrapper<CuihaitixingEntity> wrapper);
	
	List<CuihaitixingView> selectListView(@Param("ew") Wrapper<CuihaitixingEntity> wrapper);

	List<CuihaitixingView> selectListView(Pagination page,@Param("ew") Wrapper<CuihaitixingEntity> wrapper);
	
	CuihaitixingView selectView(@Param("ew") Wrapper<CuihaitixingEntity> wrapper);
	

}
