import java.lang.reflect.Method;
import play.GlobalSettings;
import play.mvc.Action;
import play.mvc.Result;
import play.mvc.Http.Context;
import play.mvc.Http.Request;

import annotations.SkipAuth;


public class Global extends GlobalSettings {

	@Override
	public Action onRequest(Request request, Method method) {
		return new ActionWrapper(super.onRequest(request, method), method);
	}
	
	private class ActionWrapper extends Action.Simple {
		private Method method; 
		
		public ActionWrapper(Action action, Method method) {
			this.delegate = action;
			this.method = method;
		}

		@Override
		public Result call(Context arg0) throws Throwable {
			if (method.isAnnotationPresent(SkipAuth.class)) {
				System.out.println("Skip");
				return this.delegate.call(arg0);
			}
			
			//This is where your Auth code presents
			System.out.println("Auth");

			return this.delegate.call(arg0);
		}
	}

}
