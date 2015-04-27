package com.zybr.common.misc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zybr.common.json.ResultMessage;
import com.zybr.common.misc.Constant;
import com.zybr.common.misc.MessageException;
import org.springframework.web.servlet.ModelAndView;

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

}
