package com.zybr.common.dao.zybr.param.user;

import com.zybr.common.dao.zybr.bean.user.Message;
import com.zybr.common.misc.PageBean;

import java.util.Collection;

public class MessageParam extends Message {

	private Message updateMessage;
	private PageBean pageBean;
	private String groupView;
	private String orderView;
	private Collection<Integer> messageIdCollection;
	
	public Message getUpdateMessage() {
		return updateMessage;
	}

	public void setUpdateMessage(Message updateMessage) {
		this.updateMessage = updateMessage;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	public String getGroupView() {
		return groupView;
	}

	public void setGroupView(String groupView) {
		this.groupView = groupView;
	}
	
	public String getOrderView() {
		return orderView;
	}

	public void setOrderView(String orderView) {
		this.orderView = orderView;
	}
	
	public Collection<Integer> getMessageIdCollection() {
		return messageIdCollection;
	}

	public void setMessageIdCollection(Collection<Integer> messageIdCollection) {
		this.messageIdCollection = messageIdCollection;
	}
	
}
