import org.example.ExternalApi;
import org.example.MyService;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MyServiceTest3 {
    @Test
    public void test2(){
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData("101");
        verify(mockApi).getData("101");

    }
}
