package spring2;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import spring2.controllers.HomeController;

/**
 * @SpringBootTest include:
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith(SpringExtension.class)
 * @WebMvcTest include:
 * @BootstrapWith(WebMvcTestContextBootstrapper.class)
 * @ExtendWith(SpringExtension.class)
 * @AutoConfigureWebMvc
 * @AutoConfigureMockMvc ...
 * <p>
 * However, in this test,
 * Spring Boot instantiates only the web layer rather than the whole context.
 * In an application with multiple controllers, you can even ask for only one
 * to be instantiated by using, for example, @WebMvcTest(HomeController.class).
 */
@WebMvcTest(HomeController.class)
public class MockMvcTest2 {

    @Autowired
    private MockMvc mockMvc;

    public void test() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/")
        ).andDo(
                MockMvcResultHandlers.print()
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Hello,World"))
        );

    }
}
