package com.longxw.mall.redis;

import lombok.Data;

/**
 * @author longxw
 * @since 2020/5/13
 */
@Data
public class ObjectWrapper {
    public ObjectWrapper(){
    }

    private Object object;
    public ObjectWrapper(Object o){
        this.object = o;
    }
}
