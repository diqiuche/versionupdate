package net.tfedu.core.helper.tests;

import org.junit.After;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Controller 单元测试基类
 * 
 * @author bruce
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml", "classpath*:/applicationContext-*.xml", "classpath:/spring-mvc.xml" })
public abstract class BaseControllerTestCase {

    protected static Logger log = LoggerFactory.getLogger(BaseControllerTestCase.class);
    
    /**
     * 注意，所有子类都不能新建request、response
     */
    protected MockHttpServletRequest request =new MockHttpServletRequest("GET", "/");
    protected MockHttpServletResponse response = new MockHttpServletResponse();

    protected long startTime;
    protected long endTime;

    /*@Autowired
    private UserService userService;
    
    *//**
     * 初始化
     *//*
    @Before
    public void onSetUp() {
        UserSimple us = userService.getUserSimpleById(1l," ",false);
        request.addHeader("Authorization", us.getToken());
        request.setAttribute("currentUserId", 1l); 
        
        
        
        
//        request.setAttribute("request_key_CustomException", CustomException.SUCCESS);
        startTime = System.currentTimeMillis();
    }
*/
    /**
     * 结束
     * 
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        endTime = System.currentTimeMillis();
        log.info("执行时长：" + (endTime - startTime) + "ms");
    }

    /**
     * Convenience methods to make tests simpler
     *
     * @param url
     *            the URL to post to
     * @return a MockHttpServletRequest with a POST to the specified URL
     */
    public MockHttpServletRequest newPost(String url) {
        return new MockHttpServletRequest("POST", url);
    }

    /**
     * get请求
     * 
     * @param url
     * @return
     */
    public MockHttpServletRequest newGet(String url) {
        return new MockHttpServletRequest("GET", url);
    }

}
