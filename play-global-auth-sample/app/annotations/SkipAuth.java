/** 
* Author       : Teriusray
* Created date : 2013/05/06
* Version      : 1.0
* CopyRright (c) 2013 Teriusray
* All right reserved.
*/ 
package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SkipAuth {

}
