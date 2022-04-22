package Test.JustTest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import Test.JustTest.controller.TestController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestWebController extends JustTestControllerApplicationTests { //extend the class with the Main testing class

    @Autowired
    private WebApplicationContext webApplicationContext; //instantiate the web application context..cuz we dealing with web application


    private MockMvc mockMvc;//we instantiate the mockMVC tho test if they really get to see the endpoint

    @Before
    public void setUp(){
        //we add the set up context inside the mockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAdmin() throws Exception { //if the mock print out anything other than this,throw exception
        mockMvc.perform(get("/admin")).andExpect(status().isOk())
              //  .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect((ResultMatcher) content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("Korede")).andExpect(jsonPath("$.role").value("Soldier"))
                .andExpect(jsonPath("$.id").value("1L")).andExpect(jsonPath("$.salary").value(737873));
    }
}
