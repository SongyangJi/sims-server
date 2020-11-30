package com.jsy.simsserver.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.jsy.simsserver.pojo.OssSign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Date;


//OSS文件上传
@RestController
public class OSSUploadController {
    //读取配置
    @Value("${spring.cloud.alicloud.access-key}")
    private String accessId;
    @Value("${spring.cloud.alicloud.secret-key}")
    private String accessKey;
    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint;
    @Value("${spring.cloud.alicloud.bucket-name}")
    private String bucket;

    @Resource
    private OSS ossClient;

    //服务返回oss签名 ，web拿到签名后，上传文件到OSS
    @GetMapping("/ossSign")
    public ResponseEntity<OssSign> ossSign(){
        // host的格式为 bucketname.endpoint
        String host = "http://" + bucket + "." + endpoint;

        // callbackUrl为 上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
//        String callbackUrl = "http://localhost:8088/callback";

        // 用户上传文件时指定的前缀。
        String dir = "students-images";

        try {
            long expireTime = 30; //过期时间间隔 30s
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;  // 当前时间 + 过期时间间隔 (单位 ms)
            Date expiration = new Date(expireEndTime);

            // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
            PolicyConditions policyConds = new PolicyConditions();
            // 10485760 是1000MB
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 10485760);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);


            return ResponseEntity.ok(new OssSign(accessId,encodedPolicy,postSignature,dir,host,String.valueOf(expireEndTime / 1000)) );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return null;
    }
}

