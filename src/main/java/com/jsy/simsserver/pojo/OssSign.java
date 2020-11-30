package com.jsy.simsserver.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


/*
当您想以个人身份向OSS发送请求时，首先需要将发送的请求按照OSS指定的格式生成签名字符串，
然后使用AccessKeySecret对签名字符串进行加密产生验证码。OSS收到请求后，通过AccessKey
ID找到对应的AccessKey Secret，并以同样的方法提取签名字符串和验证码。如果计算出来的验证码和提供的一致则认为该请求有效；
否则，OSS将拒绝处理这次请求，并返回HTTP 403错误。
 */

public class OssSign {
    private String accessid;  // 用于标识用户
    private String policy;    //
    private String signature; // 签名
    private String dir;  //用户上传文件时指定的前缀z
    private String host;  // 将要上传的地址
    private String expire; // 过期时间:单位s
}
