package com.longxw.graphql.annotation;

import java.lang.annotation.*;

/**
 * @author longxw
 * @since 2020/4/10
 */
@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GraphqlMutation {
}
