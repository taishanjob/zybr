package com.zybr.common.dao.zybr.service.user.impl;

import com.zybr.common.dao.zybr.bean.user.Message;
import com.zybr.common.dao.zybr.mapping.user.MessageDao;
import com.zybr.common.dao.zybr.param.user.MessageParam;
import com.zybr.common.dao.zybr.service.user.MessageService;
import com.zybr.common.misc.CodeTool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageDao messageDao;

	@Override
	public List<Message> selectMessage(MessageParam messageParam) {
		return messageDao.selectMessage(messageParam);
	}

	@Override
	public int countMessage(MessageParam messageParam) {
		return messageDao.countMessage(messageParam);
	}

	@Override
	public void deleteMessage(MessageParam messageParam) {
		messageDao.deleteMessage(messageParam);
	}

	@Override
	public void insertMessage(Message message) {
		messageDao.insertMessage(message);
	}
	
	@Override
	public void insertMessageCollection(Collection<Message> messageCollection) {
		if (CodeTool.isInvalid(messageCollection)) {
			return;
		}
		Collection<Collection<Message>> splitCollection = CodeTool.splitCollection(messageCollection, 500);
		for (Collection<Message> collection : splitCollection) {
			messageDao.insertMessageList(new ArrayList<Message>(collection));
		}
	}

	@Override
	public void updateMessage(MessageParam messageParam) {
		messageDao.updateMessage(messageParam);
	}
	
}