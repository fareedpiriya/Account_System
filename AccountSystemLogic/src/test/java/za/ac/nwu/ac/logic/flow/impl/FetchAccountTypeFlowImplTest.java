package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.impl.impl.FetchAccountTypeFlowImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FetchAccountTypeFlowImplTest {

    private FetchAccountTypeFlowImpl classToTest;

    @Before
    public void setUp() throws Exception {
        classToTest = new FetchAccountTypeFlowImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest = null;
    }

    @Test
    public void methodToTest() {
        assertTrue(classToTest.methodToTest());
    }

    @Test()
    public void testGetAccountTypeDbEntityByMnemonic() {
        //AccountType accountType = classToTest.getAccountTypeDbEntityByMnemonic("MILES");
        //assertNull(accountType);
        //assertEquals("Miles", "Miles");
    }

    @Test()
    public void testGetAccountTypeByMnemonic() {
//        classToTest.getAccountTypeDbEntityByMnemonic("MILES");
//        assertEquals("MILES", accountType);
    }

    @Test
    public void testGetAllAccountTypes()
    {}
}