import static play.mvc.Results.notFound;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import play.GlobalSettings;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import play.mvc.Results;
import views.html.notFound;

public class Global extends GlobalSettings {
	
	public CompletionStage<Result> onHandlerNotFound(RequestHeader arg0) {
		return CompletableFuture.completedFuture(Results.badRequest(notFound.render()));
	}
}
