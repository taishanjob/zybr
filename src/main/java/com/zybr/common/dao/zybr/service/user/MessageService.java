package com.zybr.common.dao.zybr.service.user;

import java.util.Collection;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.zybr.common.dao.zybr.bean.user.Message;
import com.zybr.common.dao.zybr.param.user.MessageParam;

public interface MessageService {

	@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<Message> selectMessage(MessageParam messageParam);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public int countMessage(MessageParam messageParam);
	
	@Transactional
	public void insertMessage(Message message);
	
	@Transactional
	public void insertMessageCollection(Collection<Message> messageCollection);
	
	@Transactional
	public void updateMessage(MessageParam messageParam);
	
	@Transactional
	public void deleteMessage(MessageParam messageParam);
	
}