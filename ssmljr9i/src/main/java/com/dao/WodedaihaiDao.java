package com.dao;

import com.entity.WodedaihaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WodedaihaiVO;
import com.entity.view.WodedaihaiView;


/**
 * 我的待还
 * 
 * @author 
 * @email 
 * @date 2022-12-06 09:47:41
 */
public interface WodedaihaiDao extends BaseMapper<WodedaihaiEntity> {
	
	List<WodedaihaiVO> selectListVO(@Param("ew") Wrapper<WodedaihaiEntity> wrapper);
	
	WodedaihaiVO selectVO(@Param("ew") Wrapper<WodedaihaiEntity> wrapper);
	
	List<WodedaihaiView> selectListView(@Param("ew") Wrapper<WodedaihaiEntity> wrapper);

	List<WodedaihaiView> selectListView(Pagination page,@Param("ew") Wrapper<WodedaihaiEntity> wrapper);
	
	WodedaihaiView selectView(@Param("ew") Wrapper<WodedaihaiEntity> wrapper);
	

}
