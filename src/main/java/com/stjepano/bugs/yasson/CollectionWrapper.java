package com.stjepano.bugs.yasson;

import java.util.Collection;

/**
 * A generic collection wrapper.
 */
public class CollectionWrapper<T> {

    private Collection<T> data;

    public CollectionWrapper() {
    }

    public CollectionWrapper(Collection<T> data) {
        this.data = data;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}
