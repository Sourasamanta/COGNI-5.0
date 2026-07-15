import org.example.ExternalApi;
import org.example.MyService;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public class MyServiceTest {

    @Test
    public void test(){
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData(anyString())).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData("100");
        assertEquals("Mock Data", result);
    }
}
