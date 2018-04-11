import com.stream.hello.StreamAlpplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StreamAlpplication.class)
@WebAppConfiguration
public class Tests {
  /*  @Autowired
    SinkSender ss;

    String port;
    @Test
    public void test01(){
        ss.output().send(MessageBuilder.withPayload("from SinkSender").build());//不知道为啥不行，可能是jar版本问题
    }*/
}
