package com.longxw.library.uitl;

import com.longxw.library.function.UncheckConsumer;
import com.longxw.library.function.UncheckPredicate;
import com.longxw.library.function.UncheckRunnable;
import com.longxw.library.function.UncheckSupplier;

/**
 * @author longxw
 * @since 2020/5/13
 */
public class Try {

    public static <T> void handler(T t,UncheckConsumer<T> consumer){
            try {
                consumer.accept(t);
            }catch (Exception e){
                if(e instanceof RuntimeException){
                    throw (RuntimeException)e;
                }
                throw new RuntimeException(e);
            }
    }

    public static void handler(UncheckRunnable uncheckRunnable){
        try {
            uncheckRunnable.run();
        }catch (Exception e){
            if(e instanceof RuntimeException){
                throw (RuntimeException)e;
            }
            throw new RuntimeException(e);
        }
    }

    public static <T> boolean handler(T t, UncheckPredicate<T> uncheckPredicate){
        try {
          return uncheckPredicate.test(t);
       }catch (Exception e){
          if(e instanceof RuntimeException){
              throw (RuntimeException)e;
          }
          throw new RuntimeException(e);
      }
    }

    public static <T> T handler(T t,UncheckSupplier<T> uncheckSupplier){
        try {
            return uncheckSupplier.get();
        }catch (Exception e){
            if(e instanceof RuntimeException){
                throw (RuntimeException)e;
            }
            throw new RuntimeException(e);
        }
    }
}
