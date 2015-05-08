package com.zybr.common.misc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zybr.common.json.ResultMessage;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;
import org.springframework.web.servlet.ModelAndView;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by pst on 15-4-23.
 */
public class CodeTool {

    public static String toJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new MessageException(e, new ResultMessage(Constant.CODE_FAILURE, "生成json出错"));
        }
    }

    public static <T> T convertJsonBean(String value, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(value, clazz);
        } catch (Exception e) {
            throw new MessageException(e, new ResultMessage(Constant.CODE_FAILURE, "解析json出错[%s]", value));
        }
    }

    public static ModelAndView redirect(String url) {
        return new ModelAndView(new StringBuilder().append("redirect:").append(url).toString());
    }

    public static boolean isInvalid(Object t) {
        if (t == null) {
            return true;
        }
        if (t instanceof String && ((String)t).trim().isEmpty()) {
            return true;
        }
        if (t instanceof Collection<?> && ((Collection<?>)t).isEmpty()) {
            return true;
        }
        if (t instanceof Map<?, ?> && ((Map<?, ?>)t).isEmpty()) {
            return true;
        }
        return false;
    }

    public static <T> Collection<Collection<T>> splitCollection(Collection<T> collection, int limit) {
        Collection<Collection<T>> splitCollection = new ArrayList<Collection<T>>();
        int size = collection.size();
        if (size <= limit) {
            splitCollection.add(collection);
        } else {
            List<T> list = new ArrayList<T>(collection);
            int fromIndex = 0;
            int toIndex = limit;
            List<T> subList = null;
            do {
                subList = list.subList(fromIndex, toIndex);
                splitCollection.add(subList);
                fromIndex += limit;
                toIndex += limit;
                if (toIndex > size) {
                    toIndex = size;
                }
            } while(fromIndex < toIndex);
        }
        return splitCollection;
    }

    public static <T> T getUniqueBean(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        if (size == 1) {
            return list.get(0);
        } else {
            throw new MessageException(new ResultMessage(Constant.CODE_FAILURE, "list is not unique, size is %1$s, list is %2$s", size, list));
        }
    }

    public static String encodeMD5(String data) throws Exception {
        byte[] digest = MessageDigest.getInstance("MD5").digest(data.getBytes(Constant.UTF_8));
        StringBuilder sb = new StringBuilder();
        String md5Hex;
        for (int i = 0; i < digest.length; i++) {
            md5Hex = Integer.toHexString(digest[i] & 0xFF);
            if (md5Hex.length() < 2) {
                sb.append(0);
            }
            sb.append(md5Hex);
        }
        return sb.toString();
    }

    public static String parser(String value) throws Exception {
        StringBuilder sb = new StringBuilder();
        Parser parser = new Parser(value);
        NodeIterator elements = parser.elements();
        while (elements.hasMoreNodes()) {
            sb.append(elements.nextNode().toPlainTextString());
        }
        return sb.toString();
    }

}
