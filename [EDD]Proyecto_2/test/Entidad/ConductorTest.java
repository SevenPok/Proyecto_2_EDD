/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SevenPok
 */
public class ConductorTest {
    
    public ConductorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getTipoLicencia method, of class Conductor.
     */
    @Test
    public void testGetTipoLicencia() {
        System.out.println("getTipoLicencia");
        Conductor instance = null;
        String expResult = "";
        String result = instance.getTipoLicencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoLicencia method, of class Conductor.
     */
    @Test
    public void testSetTipoLicencia() {
        System.out.println("setTipoLicencia");
        String tipoLicencia = "";
        Conductor instance = null;
        instance.setTipoLicencia(tipoLicencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Conductor.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Conductor o = null;
        Conductor instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
