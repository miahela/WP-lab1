//package mk.finki.ukim.mk.lab;
//
//import mk.ukim.finki.wp.lab.model.Balloon;
//import mk.ukim.finki.wp.lab.model.Manufacturer;
//import mk.ukim.finki.wp.lab.model.Order;
//import mk.ukim.finki.wp.lab.service.BalloonService;
//import mk.ukim.finki.wp.lab.service.ManufacturerService;
//import mk.ukim.finki.wp.lab.service.OrderService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.management.relation.Role;
//
//@ActiveProfiles("test")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//class WpLab1ApplicationTests {
//
//    MockMvc mockMvc;
//
//
////    @Autowired
////    UserService userService;
//
//    @Autowired
//    ManufacturerService manufacturerService;
//
//    @Autowired
//    OrderService orderService;
//
//
//    @Autowired
//    BalloonService balloonService;
//
//
//    private static Order c1;
//    private static Manufacturer m1;
//    private static boolean dataInitialized = false;
//
//    @BeforeEach
//    public void setup(WebApplicationContext wac) {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//        initData();
//    }
//
//    private void initData() {
//        if (!dataInitialized) {
//            c1 = orderService.create("c1", "c1");
//            orderService.create("c2", "c2");
//
//            m1 = manufacturerService.save("m1", "m1").get();
//            manufacturerService.save("m2", "m2");
//
//            String user = "user";
//            String admin = "admin";
//
//            userService.register(user, user, user, user, user, Role.ROLE_USER);
//            userService.register(admin, admin, admin, admin, admin, Role.ROLE_ADMIN);
//            dataInitialized = true;
//        }
//    }
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    public void testGetProducts() throws Exception {
//        MockHttpServletRequestBuilder productRequest = MockMvcRequestBuilders.get("/products");
//        this.mockMvc.perform(productRequest)
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.model().attributeExists("products"))
//                .andExpect(MockMvcResultMatchers.model().attribute("bodyContent", "products"))
//                .andExpect(MockMvcResultMatchers.view().name("master-template"));
//
//    }
//
//    @Test
//    public void testDeleteProduct() throws Exception {
//        Balloon product = this.balloonService.save("test", 2.0, 2, c1.getId(), m1.getId()).get();
//        MockHttpServletRequestBuilder productDeleteRequest = MockMvcRequestBuilders
//                .delete("/balloons/delete/" + product.getId());
//
//        this.mockMvc.perform(productDeleteRequest)
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/products"));
//    }
//
//}
//
