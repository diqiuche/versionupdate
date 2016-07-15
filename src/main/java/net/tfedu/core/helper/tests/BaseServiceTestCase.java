package net.tfedu.core.helper.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 表示继承了SpringJUnit4ClassRunner类
 * 
 * @author bruce
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml", "classpath*:/applicationContext-*.xml" })
public abstract class BaseServiceTestCase {

    protected static Logger log = LoggerFactory.getLogger(BaseControllerTestCase.class);

    protected long startTime;
    protected long endTime;

    /**
     * 初始化
     */
    @Before
    public void onSetUp() {
        startTime = System.currentTimeMillis();
    }

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
}
