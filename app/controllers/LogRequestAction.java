package controllers;

import java.util.concurrent.CompletionStage;

import play.Logger;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;

public class LogRequestAction extends Action<LogRequest>{

	@Override
	public CompletionStage<Result> call(Context ctx) {
		Logger.info("The request was called " + ctx);
		return delegate.call(ctx);
	}

}
