import org.example.ExternalApi;
import org.example.MyService;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class MyServiceTest2 {
    @Test
    public void testVerifyIntegration(){
        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchData("101");
        verify(mockApi).getData("101");
    }
}
