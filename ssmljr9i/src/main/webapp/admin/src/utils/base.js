const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmljr9i/",
            name: "ssmljr9i",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmljr9i/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "微信小程序的图书管理系统"
        } 
    }
}
export default base
