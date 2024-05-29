import com.polaris.project.service.UserInterfaceInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * @author polaris
 * @data 2024-03-22 20:47
 * @version 1.0
 * ClassName UserInterfaceInfoServiceTest
 * Package com.polaris.project.service
 * Description
 */
@SpringBootTest
public class UserInterfaceInfoServiceTest {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Test
    public void invokeCount (){
        boolean result = userInterfaceInfoService.invokeCount(1L, 1L);
        Assertions.assertTrue(result);
    }
}