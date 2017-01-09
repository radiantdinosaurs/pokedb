package io.radiantdinosaurs.pokedb.database;

import org.junit.Test;
import org.mariadb.jdbc.internal.queryresults.resultset.MariaSelectResultSet;
import org.mockito.Mockito;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.Vector;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * @author radiantdinosaurs
 */
public class DatabaseReaderTest {

    @Test
    public void resultSetToVector() throws Exception {
        // CASE: Parses ResultSet correctly
        DatabaseReader dr = new DatabaseReader();
        String testName = "Bethany";
        ResultSet rs = Mockito.mock(ResultSet.class);
        when(rs.next()).thenReturn(true).thenReturn(false);
        when(rs.getObject(0)).thenReturn(testName);
        Vector<Object> resultVector = dr.resultSetToVector(rs, 1);
        assertNotNull(resultVector);
        assertEquals(testName, ((Vector) resultVector.get(0)).get(0));
    }

}