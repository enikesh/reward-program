package com.nikesh.customer.client.util;

public class CustomerRewardUtil {
	
	public static ServerResponse getResponse(boolean status){
		if(status){
			return getServerResponse(ServerReponseCode.SUCCESS, true);
		}else{
			return getServerResponse(ServerReponseCode.ERROR, false);
		}
	}
	
	private static ServerResponse getServerResponse(int statusCode, Object data){
		ServerResponse response = new ServerResponse();
		response.setStatusCode(statusCode);
		response.setData(data);
		return response;
	}

}
