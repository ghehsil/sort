package two.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created by admin on 2020/1/18.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {FIELD, METHOD})
public @interface de {
    String value();
}
