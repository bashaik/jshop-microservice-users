
package com.jshop.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.StopWatch;

import com.jshop.core.logging.JShopLogger;

/**
 * ProductDao integration test
 *
 */
@TestPropertySource(locations = { "classpath:test-application-ext.properties" })
@Sql("/test-product.sql")
public class ProductsDaoTest extends BaseDaoTest
{
    // Reference: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/integration-testing.html
    public static final JShopLogger LOGGER = new JShopLogger(ProductsDaoTest.class);

    @Autowired
    IProductsDao classUnderTest;
    
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) 
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Set the schema before transaction starts
     *
     */
    @Before
    public void setup()
    {
        useSchema("testtenant_products");
    }

    /**
     * Integration test for getProducts()
     *
     * @throws Exception exception on retrieval of product , can be connection or invalid data
     */
    @Test
    public void testGetProducts() throws Exception
    {
        LOGGER.debug("In the test ");
        
        // setup
        StopWatch sw = new StopWatch();
        sw.start("getProductEntityByProductId");

        // execute
        ProductEntity product = classUnderTest.getProductEntityByProductId(1001);
        sw.stop();
        LOGGER.debug("Response Time (seconds): " + sw.getTotalTimeSeconds());

        // verify
        assertNotNull(product);
        assertEquals("CPU", product.getName());
    }
}
