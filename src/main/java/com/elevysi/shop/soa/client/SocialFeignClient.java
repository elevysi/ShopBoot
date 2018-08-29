package com.elevysi.shop.soa.client;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("socialservice")
public interface SocialFeignClient {

}
