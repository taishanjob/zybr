package com.zybr.common.dao.zybr.mapping.user;

import java.util.List;
import com.zybr.common.dao.zybr.param.user.MessageParam;
import com.zybr.common.dao.zybr.bean.user.Message;

public interface MessageDao {

	public List<Message> selectMessage(MessageParam messageParam);

	public int countMessage(MessageParam messageParam);
	
	public void insertMessage(Message message);
	
	public void insertMessageList(List<Message> messageList);
	
	public void updateMessage(MessageParam messageParam);
	
	public void deleteMessage(MessageParam messageParam);
	
}