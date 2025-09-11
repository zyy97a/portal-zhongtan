// 引入 axios
import axios from "axios";



// let base = 'http://localhost:8087';
// let base = 'http://116.62.21.148:8888';  // 改为服务器IP
let base = '/api';  // 改为服务器IP

//传送json格式的get请求
/*export const getRequest=(url,params)=>{
    return axios({
        method:'get',
        url:`${base}${url}`,
        data: params,
    })
}*/

export const getRequest = (url, params) => {
    return axios({
        method: 'get',
        url: `${base}${url}`,  // 不加 /api
        params: params,        // GET 请求参数写在这里
    });
};

/*export const getRequest = (url, params) => {
    return axios({
        method: 'get',
        url: `${base}/api${url}`,
        params: params,  // ✅ 改为 params
    });
};*/

/*export const getRequest = (url, params) => {
    return axios({
        method: 'get',
        url: `${base}/api${url}`,  // 使用 /api 前缀
        data: params,
    })
};;*/
