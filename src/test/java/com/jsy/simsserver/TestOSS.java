package com.jsy.simsserver;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.junit.Test;

import java.io.File;

public class TestOSS {
    @Test
    public void testOSS() {
        String endpoint = "oss-cn-shanghai.aliyuncs.com";

        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GEtRcJPLmafNZJJAH3G";
        String accessKeySecret = "7ZcF61t63i7IQB7Hv6ydevkbtShJ9Q";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。 ，
        PutObjectRequest putObjectRequest = new PutObjectRequest("sims-web-jsy", "龚陈博头像.jpg",
                new File("/Users/mac/Downloads/gcbhead.jpg"));

        // 上传文件。
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
