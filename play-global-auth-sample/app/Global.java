/** 
* Author       : Teriusray
* Created date : 2013/05/06
* Version      : 1.0
* CopyRright (c) 2013 Teriusray
* All right reserved.
*/ 

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
		public Result call(Context context) throws Throwable {
			if (method.isAnnotationPresent(SkipAuth.class)) {
				System.out.println("Skip");
				return this.delegate.call(context);
			}
			
			//This is where your Auth code presents
			System.out.println("Auth");

			return this.delegate.call(context);
		}
	}

}
