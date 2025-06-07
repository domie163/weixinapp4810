package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CuihaitixingDao;
import com.entity.CuihaitixingEntity;
import com.service.CuihaitixingService;
import com.entity.vo.CuihaitixingVO;
import com.entity.view.CuihaitixingView;

@Service("cuihaitixingService")
public class CuihaitixingServiceImpl extends ServiceImpl<CuihaitixingDao, CuihaitixingEntity> implements CuihaitixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CuihaitixingEntity> page = this.selectPage(
                new Query<CuihaitixingEntity>(params).getPage(),
                new EntityWrapper<CuihaitixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CuihaitixingEntity> wrapper) {
		  Page<CuihaitixingView> page =new Query<CuihaitixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CuihaitixingVO> selectListVO(Wrapper<CuihaitixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CuihaitixingVO selectVO(Wrapper<CuihaitixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CuihaitixingView> selectListView(Wrapper<CuihaitixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CuihaitixingView selectView(Wrapper<CuihaitixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
