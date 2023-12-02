package com.farmted.productservice.FeignClient;

import com.farmted.productservice.vo.RequestAuctionCreateVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AUCTION-SERVICE", path = "auction-service")
public interface ProductToAuctionFeignClient {
    @PostMapping("/auctions/products")
    public void createProductToAuction(@RequestBody RequestAuctionCreateVo auctionCreateVo);
}
