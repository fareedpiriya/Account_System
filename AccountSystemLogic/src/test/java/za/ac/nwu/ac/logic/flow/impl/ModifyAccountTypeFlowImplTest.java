package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.impl.impl.ModifyAccountTypeFlowImpl;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ModifyAccountTypeFlowImplTest {

    private ModifyAccountTypeFlowImpl modifyAccountTypeFlow;

    @Before
    public void setUp() throws Exception {
        modifyAccountTypeFlow = new ModifyAccountTypeFlowImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Mock
    AccountTypeRepository accountTypeRepository;

    @Test
    public void deleteAccountTypeTest() {

    }

    @Test
    public void updateAccountTypeTest() {
    }
}