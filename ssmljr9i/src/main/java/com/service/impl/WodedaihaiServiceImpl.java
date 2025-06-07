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


import com.dao.WodedaihaiDao;
import com.entity.WodedaihaiEntity;
import com.service.WodedaihaiService;
import com.entity.vo.WodedaihaiVO;
import com.entity.view.WodedaihaiView;

@Service("wodedaihaiService")
public class WodedaihaiServiceImpl extends ServiceImpl<WodedaihaiDao, WodedaihaiEntity> implements WodedaihaiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodedaihaiEntity> page = this.selectPage(
                new Query<WodedaihaiEntity>(params).getPage(),
                new EntityWrapper<WodedaihaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodedaihaiEntity> wrapper) {
		  Page<WodedaihaiView> page =new Query<WodedaihaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WodedaihaiVO> selectListVO(Wrapper<WodedaihaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WodedaihaiVO selectVO(Wrapper<WodedaihaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WodedaihaiView> selectListView(Wrapper<WodedaihaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodedaihaiView selectView(Wrapper<WodedaihaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
