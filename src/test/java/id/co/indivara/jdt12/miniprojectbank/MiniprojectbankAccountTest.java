package id.co.indivara.jdt12.miniprojectbank;
import id.co.indivara.jdt12.miniprojectbank.controller.AccountController;
import id.co.indivara.jdt12.miniprojectbank.entity.Account;
import id.co.indivara.jdt12.miniprojectbank.service.AccountService;
import id.co.indivara.jdt12.miniprojectbank.mapper.MapperConver;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class MiniprojectbankAccountTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountController accountController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }
    @Test
    public void getAllAccount() throws Exception {
        List<Account> accountsChecker = accountService.getAllAccount();
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/account")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    List<Account> accounts = MapperConver.getAllData(result.getResponse().getContentAsString(), Account.class);
                    Assertions.assertNotNull(accounts);
                    Assertions.assertEquals(accountsChecker.get(0).getAccountNumber(), accounts.get(0).getAccountNumber());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accountId").isNotEmpty());
    }
}
