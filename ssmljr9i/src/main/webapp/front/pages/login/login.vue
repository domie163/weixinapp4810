<template>
	<view class="content">
		<view class="box" :style='{"width":"100%","padding":"24rpx","backgroundSize":"100% 100%","backgroundImage":"url(http://codegen.caihongy.cn/20221028/eda5b2b547b14897a3d9330ccda0fc57.png)","height":"100vh"}'>
			<view :style='{"width":"100%","padding":"24rpx","margin":"0 auto","display":"block","height":"auto"}'>
				<image :style='{"border":"4rpx solid #666","boxShadow":"0px 0px 40rpx #e4e6e0","margin":"60rpx auto 35% auto","borderRadius":"100%","display":"block","width":"200rpx","height":"200rpx"}' src="http://codegen.caihongy.cn/20221028/d422484ba714443db89191eee99051c2.webp" mode="aspectFill"></image>
				<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' class="uni-form-item uni-column">
					<input v-model="username" :style='{"border":"2rpx solid #ccc","padding":"0px 24rpx","boxShadow":"0px 4rpx 10rpx rgba(76, 75, 72,.2)","margin":"10rpx 0","color":"rgb(0, 0, 0)","borderRadius":"100rpx","background":"#fff","width":"100%","fontSize":"28rpx","height":"88rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
				</view>
				<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' class="uni-form-item uni-column">
					<input v-model="password" :style='{"border":"2rpx solid #ccc","padding":"0px 24rpx","boxShadow":"0px 4rpx 10rpx rgba(76, 75, 72,.2)","margin":"10rpx 0","color":"rgb(0, 0, 0)","borderRadius":"100rpx","background":"#fff","width":"100%","fontSize":"28rpx","height":"88rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
				</view>
				<picker v-if="roleNum>1" :style='{"width":"100%","margin":"0 0 20rpx 0","textAlign":"center","height":"auto"}' @change="optionsChange" :value="index" :range="options">
					<view class="uni-picker-type" :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"rgb(0,0,0)"}'>{{options[index]}}</view>
				</picker>
				<button class="btn-submit" @tap="onLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"100rpx","background":"#383428","width":"100%","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}'>登录</button>
				<view class="links" :style='{"width":"100%","margin":"0 0 24rpx 0","flexWrap":"wrap","display":"flex","height":"auto"}'>
					<view class="link-highlight" @tap="onRegisterTap('yonghu')" :style='{"color":"#999","padding":"0 8rpx","fontSize":"28rpx"}'>注册用户</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				username: '',
				password: '',
				codes: [{
				  num: 1,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 2,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 3,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 4,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}],
				options: [
					'请选择登录用户类型'
				],
                		optionsValues: [
					'',
                    			'yonghu',
				],
				index: 0,
				roleNum:0
			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].hasFrontLogin=='是'){
					options.push(this.menuList[i].roleName);
					this.roleNum++;
				}
			}
			if(this.roleNum==1) {
				this.index = 1;
			}	
			this.options = options;
			this.styleChange()
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.loginFrom.content.input.backgroundColor
					// })
				})
			},
			onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			async onLoginTap() {
                if (!this.username) {
					this.$utils.msg('请输入用户名')
					return
				}
                if (!this.password) {
					this.$utils.msg('请输入用户密码')
					return
				}
                if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登陆用户类型')
					return
				}
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
                uni.removeStorageSync("useridTag");
				uni.setStorageSync("token", res.token);
				uni.setStorageSync("nickname",this.username);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
                if(res.data.touxiang) {
                    uni.setStorageSync('headportrait', res.data.touxiang);
                } else if(res.data.headportrait) {
                    uni.setStorageSync('headportrait', res.data.headportrait);
                }
				// 保存用户id
				uni.setStorageSync("userid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("role", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			optionsChange(e) {
				this.index = e.target.value
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
