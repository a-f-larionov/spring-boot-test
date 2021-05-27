package spring2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring2.controllers.HomeController;

@SpringBootTest
class Spring2ApplicationTests {

    @Autowired
    private HomeController homeController;

    @Test
    void contextLoads() {
        Assertions.assertThat(homeController).isNotNull();
    }
}
