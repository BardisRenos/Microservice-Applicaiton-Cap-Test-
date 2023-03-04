package accountService.service;

import com.example.dao.AccountRepository;
import com.example.dto.AccountDTO;
import com.example.entity.Account;
import com.example.service.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {AccountServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AccountServiceTest {


    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private WebClient.Builder webClient;

    @MockBean
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AccountServiceImpl accountService;

    @BeforeEach
    void setup() {
        this.accountRepository = mock(AccountRepository.class);
        this.webClient = mock(WebClient.Builder.class);
        this.rabbitTemplate = mock(RabbitTemplate.class);
        this.accountService = new AccountServiceImpl(this.accountRepository, this.webClient, this.rabbitTemplate);
    }

    @Test
    void getAllAccount_whenAllAccounts_thenReturnAllAccounts() {

        List<Account> accounts = new ArrayList<>(Arrays.asList(
                new Account(1, 10, LocalDateTime.now(), 1, 1),
                new Account(2, 20, LocalDateTime.now().plusDays(1), 2, 2),
                new Account(3, 30, LocalDateTime.now().plusDays(2), 3, 3)));


        when(accountRepository.findAll()).thenReturn(accounts);

        List<AccountDTO> accountDTOList = accountService.getAllAccount();

        assertAll("Check all entities",
                ()->assertEquals(3, accountDTOList.size()),
                ()->assertEquals(1, accountDTOList.get(0).getAccountID()),
                ()->assertEquals(10, accountDTOList.get(0).getInitialCredit()));
    }


}
