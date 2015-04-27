import com.zybr.common.json.ResultMessage;
import org.springframework.util.ClassUtils;

/**
 * Created by pst on 15-4-23.
 */
public class Test {

    public static void main(String[] args) {
        String shortNameAsProperty = ClassUtils.getShortNameAsProperty(ResultMessage.class);
        System.out.println(shortNameAsProperty);

    }

}
