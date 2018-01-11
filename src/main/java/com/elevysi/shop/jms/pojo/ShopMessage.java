package com.elevysi.shop.jms.pojo;

public class ShopMessage {
	
	private String to;
	private String body;
	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public ShopMessage(String to, String body){
		this.to = to;
		this.body = body;
	}
	
	@Override
	public String toString(){
		return String.format("Message{to=%s, body=%s}", getTo(), getBody());
	}

}
