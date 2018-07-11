package com.adoph.test.design.pattern.chain.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/11
 */
public class FilterChain implements Filter<String> {

    private List<Filter<String>> filterChain;
    private int index = 0;

    public FilterChain() {
        filterChain = new ArrayList<>();
    }

    public FilterChain addFilter(Filter<String> filter) {
        filterChain.add(filter);
        return this;
    }

//    @Override
    public void doFilter(Request<String> request, Response<String> response) {
        doFilter(request, response, this);
    }

    @Override
    public void doFilter(Request<String> request, Response<String> response, FilterChain fc) {
        if (index == filterChain.size()) {
            return;
        }
        Filter<String> filter = filterChain.get(index);
        index++;
        filter.doFilter(request, response, fc);
    }
}
