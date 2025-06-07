<template>
<view class="content">
	<view :style='{"width":"100%","background":"#fff","height":"100%"}'>
		<swiper :style='{"width":"100%","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='false' :autoplay='true' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
			<swiper-item :style='{"width":"50%","backgroundSize":"100% 100%","backgroundImage":"url(http://codegen.caihongy.cn/20221029/c6062776d2144186acd5e1b2a4c411fd.png)","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"572rpx","margin":"20rpx 84rpx","objectFit":"cover","display":"block","height":"294rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>

		<view class="cu-bar bg-white search" :style="[{top:CustomBar + 'px'}]">
			<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName" :value="queryIndex" @change="queryChange" style="padding-left: 20upx;">
				<view><image style="width: 20upx;height: 33upx;" src="../../static/center/to.png"></image></view>
			</picker>
			<view v-if="queryIndex==0" class="search-form round">
				<text class="cuIcon-search"></text>
				<input v-model="searchForm.tushuxinxitushumingcheng" type="text" placeholder="图书名称" ></input>
			</view>
			<view v-if="queryIndex==0" class="action">
				<button @tap="onPageTap('tushuxinxi')" class="cu-btn shadow-blur round">搜索</button>
			</view>
		</view>

		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"0","margin":"0","background":"#E4E6E1","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
            <block v-for="item in menuList" v-bind:key="item.roleName">
                <block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"20%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2('../'+child.tableName+'/list')">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","margin":"0px auto","color":"#000","borderRadius":"20rpx","background":"#fff","display":"block","width":"64rpx","lineHeight":"64rpx","fontSize":"64rpx","height":"64rpx"}'></view>
                                <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#666","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		
		
		<!-- 关于我们 -->
		<view :style='{"padding":"0 24rpx","margin":"20rpx 0","borderColor":"#ccc","flexWrap":"wrap","background":"#fff","borderWidth":"0 0 4rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
		  <view :style='{"width":"50%","lineHeight":"1.5","fontSize":"48rpx","color":"#beb0a7","textAlign":"center","order":"1"}'>{{aboutUsDetail.title}}</view>
		  <view :style='{"margin":"0 0 20rpx","color":"#999","textAlign":"center","display":"none","width":"100%","lineHeight":"1.5","fontSize":"32rpx"}'>{{aboutUsDetail.subtitle}}</view>
		  <view :style='{"padding":"0","boxShadow":"0px 10rpx 6rpx #ccc","margin":"0 0 20rpx","borderRadius":"20rpx","flexWrap":"wrap","display":"flex","width":"50%","height":"auto","order":"0"}'>
		    <img :style='{"border":"2rpx solid #ccc","margin":"0","objectFit":"cover","borderRadius":"20rpx","flex":1,"display":"block","height":"200rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
		  </view>
		  <view :style='{"padding":"0","margin":"0 0 20rpx 0","color":"rgb(102, 102, 102)","width":"100%","lineHeight":"2","fontSize":"28rpx","order":"3"}' v-html="aboutUsDetail.content"></view>
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		</view>

		<!-- 商品推荐 -->
		<view class="listBox recommend">
			<view v-if="false && 3 == 1" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20221025/a375c9ac918149e78d69fbc70fd4154c.jpg)","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"padding":"0 20rpx","boxShadow":"0 2rpx 20rpx #ccc","margin":"0 auto","borderRadius":"10rpx","textAlign":"center","background":"none","width":"50%"}'>
				<view :style='{"fontSize":"44rpx","lineHeight":"88rpx","color":"#beb0a7","fontWeight":"600"}'>图书信息推荐</view>
			</view>
			
			<view v-if="false && 3 == 2" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20221025/a375c9ac918149e78d69fbc70fd4154c.jpg)","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			
			
			
			  
			
			
			  
			<!-- 样式8 -->
			<view class="list-box style8" :style='{"width":"100%","padding":"24rpx","margin":"0","height":"auto"}'>
				<view v-if="tushuxinxilist.length > 0" @tap="onDetailTap('tushuxinxi',tushuxinxilist[0].id)" class="box box1"  :style='{"width":"100%","padding":"0","margin":"0  0 40rpx 0","overflow":"hidden","height":"344rpx","order":"0"}'>
					<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"#e4e6e1","color":"#666","textAlign":"center","width":"100%","lineHeight":"64rpx","fontSize":"36rpx","height":"64rpx"}' class="title ">{{tushuxinxilist[0].tushumingcheng}}</view>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"280rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[0].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[0].fengmian"></image>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"280rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[0].fengmian?baseUrl+tushuxinxilist[0].fengmian.split(',')[0]:''"></image>
				</view>
				<view class="list-item" :style='{"padding":"0","margin":"0 0 20rpx","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
					<view v-if="tushuxinxilist.length > 1" @tap="onDetailTap('tushuxinxi',tushuxinxilist[1].id)" class="box box2" :style='{"width":"48%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(228, 230, 225,1)","color":"#333","textAlign":"center","bottom":"0","borderRadius":"0 010rpx 10rpx","left":"0","width":"100%","lineHeight":"64rpx","fontSize":"32rpx","position":"absolute","zIndex":"1"}' class="title ">{{tushuxinxilist[1].tushumingcheng}}</view>
						<image :style='{"width":"100%","objectFit":"cover","borderRadius":"10rpx","display":"block","height":"280rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[1].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[1].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","borderRadius":"10rpx","display":"block","height":"280rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[1].fengmian?baseUrl+tushuxinxilist[1].fengmian.split(',')[0]:''"></image>
					</view>
					<view v-if="tushuxinxilist.length > 2" @tap="onDetailTap('tushuxinxi',tushuxinxilist[2].id)" class="box box3" :style='{"width":"48%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(228, 230, 225,1)","color":"#333","textAlign":"center","bottom":"0","borderRadius":"0 0 10rpx 10rpx","left":"0","width":"100%","lineHeight":"64rpx","fontSize":"32rpx","position":"absolute","zIndex":"1"}' class="title ">{{tushuxinxilist[2].tushumingcheng}}</view>
						<image :style='{"width":"100%","objectFit":"cover","borderRadius":"10rpx","display":"block","height":"280rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[2].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[2].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","borderRadius":"10rpx","display":"block","height":"280rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[2].fengmian?baseUrl+tushuxinxilist[2].fengmian.split(',')[0]:''"></image>
					</view>
					<view v-if="tushuxinxilist.length > 3" @tap="onDetailTap('tushuxinxi',tushuxinxilist[3].id)" class="box box4" :style='{"width":"32%","padding":"0","margin":"0","position":"relative","display":"none","height":"auto"}'>
						<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(0,0,0,.3)","color":"#fff","textAlign":"center","left":"0","bottom":"0","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","position":"absolute","zIndex":"1"}' class="title ">{{tushuxinxilist[3].tushumingcheng}}</view>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[3].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[3].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[3].fengmian?baseUrl+tushuxinxilist[3].fengmian.split(',')[0]:''"></image>
					</view>
				</view>
				<view class="list-item" :style='{"width":"100%","padding":"0","margin":"0","justifyContent":"space-between","display":"flex","height":"auto"}'>
					<view v-if="tushuxinxilist.length > 4" @tap="onDetailTap('tushuxinxi',tushuxinxilist[4].id)" class="box box5" :style='{"width":"48%","padding":"0","margin":"0","overflow":"hidden","height":"392rpx"}'>
						<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(178, 178, 178,.3)","color":"#666","textAlign":"center","width":"100%","lineHeight":"64rpx","fontSize":"32rpx","zIndex":"1","height":"64rpx"}' class="title ">{{tushuxinxilist[4].tushumingcheng}}</view>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[4].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[4].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[4].fengmian?baseUrl+tushuxinxilist[4].fengmian.split(',')[0]:''"></image>
					</view>
					<view v-if="tushuxinxilist.length > 5" @tap="onDetailTap('tushuxinxi',tushuxinxilist[5].id)" class="box box6" :style='{"width":"48%","padding":"0","margin":"0","overflow":"hidden","height":"392rpx"}'>
						<view v-if="true" :style='{"padding":"0 20rpx","margin":"0","backgroundColor":"rgba(178, 178, 178,.3)","color":"#666","textAlign":"center","width":"100%","lineHeight":"64rpx","fontSize":"32rpx","zIndex":"1"}' class="title ">{{tushuxinxilist[5].tushumingcheng}}</view>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[5].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[5].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"328rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[5].fengmian?baseUrl+tushuxinxilist[5].fengmian.split(',')[0]:''"></image>
					</view>
				</view>
			</view>
			
			  
			<view v-if="false && 3 == 3" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20221025/a375c9ac918149e78d69fbc70fd4154c.jpg)","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
		<!-- 商品推荐 -->
		
		

		<!-- 商品列表 -->
																																																<!-- 商品列表 -->
		
		
		<!-- 新闻资讯 -->
																																						<view class="listBox news">
			<view v-if="false && 3 == 1" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"width":"100%","padding":"0 24rpx","margin":"0","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"margin":"0 20rpx","fontSize":"44rpx","lineHeight":"88rpx","color":"#000","fontWeight":"600"}'>系统公告</view>
				<text :style='{"color":"#beb0a7","fontSize":"32rpx","lineHeight":"88rpx"}' @tap="onPageTap('news')">查看更多</text>
			</view>
			
			<view v-if="false && 3 == 2" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
					  
						
						
		  <!-- 样式4 -->
		  		  
		  <!-- 样式5 -->
		  		  
		  <!-- 样式6 -->
		  		  
		  <!-- 样式7 -->
		  		  
		  <!-- 样式8 -->
		  		  
		  <!-- 样式9 -->
		  		  <view class="news-box6" :style='{"width":"100%","padding":"24rpx","margin":"0","height":"auto"}'>
			<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"padding":"8rpx 24rpx 8rpx 80rpx","margin":"0 0 20rpx","borderColor":"#999","background":"#ebe7e4","borderWidth":"4rpx 0 4rpx 0","width":"100%","position":"relative","borderStyle":"dotted","height":"auto"}'>
			  <view :style='{"padding":"0","margin":"-30rpx 0 0 20rpx","color":"#a67252","textAlign":"center","borderRadius":"100%","top":"50%","left":"0","background":"rgba(204, 204, 204,.5)","width":"70rpx","lineHeight":"70rpx","fontSize":"32rpx","position":"absolute","height":"70rpx"}' class="num">
			    <view style="width: 100%;height: 100%;position: absolute;left: 0;top: 0;" :style="{transform: 'rotate('+(-index*60)+'deg)'}" class="dian">
			      <view :style='{"transform":"translateX(-50%)","borderRadius":"100%","top":"-8rpx","left":"50%","background":"red","display":"none","width":"16rpx","position":"absolute","height":"16rpx"}'></view>
			    </view>{{ index + 1 < 10 ? '0'+(index+1) : index+1 }}
			  </view>
			  <view class="item-list-body" :style='{"width":"100%","margin":"0","height":"auto"}'>
				<view :style='{"width":"100%","padding":"4rpx 20rpx","lineHeight":"1.4","fontSize":"28rpx","color":"#333"}' class="title ">{{item.title}}</view>
				<view :style='{"width":"100%","padding":"4rpx 20rpx","lineHeight":"1.2","fontSize":"28rpx","color":"#666"}' class="desc ">{{item.introduction}}</view>
			  </view>
			</view>
		  </view>
		  			
			<view v-if="false && 3 == 3" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
														<!-- 新闻资讯 -->
				

	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 1,
				column: 6,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                aboutUsDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"图书名称",
					},
				],
				queryIndex: 0,
				searchForm:{
					tushuxinxitushumingcheng:'',
				},
				CustomBar: '0',

				//轮播
				swiperList: [],
				tushuxinxilist: [],
				news: [],
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
        async onLoad(){
            this.role = uni.getStorageSync("role");
            let table = uni.getStorageSync("nowTable");
            let res = await this.$api.session(table);
            this.user = res.data;
            this.tableName = table;
            let menus = menu.list();
            this.menuList = menus;
            this.menuList.forEach((item,key) => {
                if(this.role==item.roleName) {
                    item.frontMenu.forEach((item2,key2) => {
                        if(item2.child[0].buttons.indexOf("查看")>-1) {
                            this.swiperMenuList.push(item2);
                        }
                    })
                }
            })
        },
		async onShow() {
            this.btnColor = this.btnColor.sort(()=> {
                    return (0.5-Math.random());
            });
			// 轮播图
			let swiperList = []
			let res = await this.$api.page('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
            this.getAboutUs();
			// 系统公告
			res = await this.$api.list('news', {
				page: 1,
				limit: 6
			});
			this.news = res.data.list

			// 推荐信息
			if(uni.getStorageSync("userid")!==null) {
				res = await this.$api.recommend2('tushuxinxi', {                                              
                    page: 1,
                    limit: 6
                });
			} else {
				res = await this.$api.recommend('tushuxinxi', {                                              
                    page: 1,
                    limit:6 
                });
			}
			this.tushuxinxilist = res.data.list

		},

		methods: {

			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.tushuxinxitushumingcheng="";
			},
			//轮播图跳转
			onSwiperTap(e) {

			},
            async getAboutUs() {
                let res = await this.$api.info('aboutus', 1)
                this.aboutUsDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				if(this.queryIndex==0) {
					uni.setStorageSync('indexQueryCondition',this.searchForm.tushuxinxitushumingcheng);
					this.searchForm.tushuxinxitushumingcheng = '';
				}

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
