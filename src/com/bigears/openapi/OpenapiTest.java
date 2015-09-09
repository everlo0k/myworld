/*
 * <p>OpenapiTest.java</p>
 */
package com.bigears.openapi;

import java.util.Date;

import org.apache.log4j.Logger;


import cn.bidlink.openapi.client.ClientSupport.AuthMode;
import cn.bidlink.openapi.client.bidweb.impl.BidwebDataTransferOpenApiClientImpl;
import cn.bidlink.openapi.client.commons.ResponseEntity;
import cn.bidlink.openapi.client.exceptions.BidExceptionHandler;
import cn.bidlink.openapi.client.exceptions.ExceptionMode;
import cn.bidlink.openapi.common.bidweb.dto.BidwebDataTransferDto;

/**
 * @Project    : myworld
 * @ClassName  : com.bigears.openapi.OpenapiTest
 * @Description: TODO
 * @Author     : shenyang
 * @Date  	   : 2015年4月2日 下午3:28:34 
 */
public class OpenapiTest {

	private static final Logger logger = Logger.getLogger(OpenapiTest.class);
	
	private static BidwebDataTransferOpenApiClientImpl client;
	
	public static void init() {
		if (client == null) {
			synchronized (BidwebDataTransferOpenApiClientImpl.class) {
				String name = "test0001";
				String password = "test0001";
				if (client == null) {
					client = BidwebDataTransferOpenApiClientImpl.getClient(AuthMode.BASIC, new String[] { name, password });
					client.setExceptionMode(ExceptionMode.INTERFACE, new BidExceptionHandler() {
						@Override
						public void doHandler(ResponseEntity responseEntity) {
							logger.error(responseEntity.getMessage());
						}
					});
				}
			}
		}
	}

	public static BidwebDataTransferOpenApiClientImpl getOpenApiClient() {
		init();
		return OpenapiTest.client;
	}
	
	public static void main(String[] args) {
		
		BidwebDataTransferOpenApiClientImpl temp = getOpenApiClient();
		BidwebDataTransferDto dto = new BidwebDataTransferDto();
		dto.setBidCode("aaaaaaaaa");
		dto.setBidKindCode("bbbbbbbb");
		dto.setBidOpenTime(new Date());
		dto.setBidOrg("ccccccc");
		dto.setBidOwner("ddddddddd");
		dto.setDocContent("eeeeeeeee");
		dto.setDocTitle("fffffff");
		dto.setEmail("gggggggg");
		dto.setInfoType("1");
		dto.setLinkMan("hhhhhhhhh");
		dto.setTell("iiiiiiii");
		dto.setTradeClassCodes("jjjjjjjjjjjjjj");
		dto.setZoneCode("kkkkk");
		Integer i = temp.saveBidwebDataTransfer(dto);
		System.out.println(i);
	}
		
}
