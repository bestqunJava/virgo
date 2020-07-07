package com.virgo.hw.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author wangchenkai
 * @since 2020/7/7 3:04 下午
 */@Slf4j
public class YouDaoSignUtil {

//    private static final String YOUDAO_URL = "https://openapi.youdao.com/ocrquestionapi";
//
//    private static final String APP_KEY = "您的应用ID";
//
//    private static final String APP_SECRET = "您的应用密钥";
//
////    public static void main(String[] args) throws IOException {
////
////        Map<String,String> params = new HashMap<>();
////        String q = loadAsBase64("图片的路径");
////        String salt = String.valueOf(System.currentTimeMillis());
////        params.put("q", q);
////        params.put("signType", "v2");
////        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
////        params.put("curtime", curtime);
////        String signStr = APP_KEY + truncate(q) + salt + curtime + APP_SECRET;
////        String sign = getDigest(signStr);
////        params.put("appKey", APP_KEY);
////        params.put("salt", salt);
////        params.put("sign", sign);
////        String result = requestForHttp(YOUDAO_URL,params);
////        /** 处理结果 */
////        System.out.println(result);
////    }
//
//    public static String requestForHttp(String url,Map<String,String> params) throws IOException {
//        String result = "";
//
//        /** 创建HttpClient */
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        /** httpPost */
//        HttpPost httpPost = new HttpPost(url);
//        List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
//        Iterator<Map.Entry<String,String>> it = params.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry<String,String> en = it.next();
//            String key = en.getKey();
//            String value = en.getValue();
//            paramsList.add(new BasicNameValuePair(key,value));
//        }
//        httpPost.setEntity(new UrlEncodedFormEntity(paramsList,"UTF-8"));
//        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//        try{
//            HttpEntity httpEntity = httpResponse.getEntity();
//            result = EntityUtils.toString(httpEntity,"UTF-8");
//            EntityUtils.consume(httpEntity);
//        }finally {
//            try{
//                if(httpResponse!=null){
//                    httpResponse.close();
//                }
//            }catch(IOException e){
//                logger.info("## release resouce error ##" + e);
//            }
//        }
//        return result;
//    }
//
    /**
     * 生成加密字段
     */
    public static String getDigest(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest mdInst = MessageDigest.getInstance("SHA-256");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String loadAsBase64(InputStream in)
    //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
    {
        byte[] data = null;
        //读取图片字节数组
        try
        {
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码 //返回Base64编码过的字节数组字符串
        return Base64.getEncoder().encodeToString(data);
    }

    public static String truncate(String q) {
        if (q == null) {
            return null;
        }
        int len = q.length();
        String result;
        return len <= 20 ? q : (q.substring(0, 10) + len + q.substring(len - 10, len));
    }


}
