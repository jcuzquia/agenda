package e2e;

import org.junit.Test;

import play.Logger;
import play.libs.ws.WS;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.test.TestServer;

import static play.test.Helpers.*;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class AgendaAppTest {

	@Test
	public void testNewContactFormPage() {
		TestServer server = testServer(3333);
		running(server, () -> {
			CompletionStage<WSResponse> completionStage = WS.url("http://localhost:3333/contacts/new").get();
			WSResponse response = null;
			try {
				response = completionStage.toCompletableFuture().get();
				String body = response.getBody();
				assertTrue(body.contains("New Contact"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		});
	}
}
