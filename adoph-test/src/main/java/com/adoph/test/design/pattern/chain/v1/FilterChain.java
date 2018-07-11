package com.adoph.test.design.pattern.chain.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public class FilterChain implements Filter {
    private List<Filter> filters;

    public FilterChain() {
        filters = new ArrayList<>();
    }

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public String doFilter(String msg) {
        for (Filter filter : filters) {
            msg = filter.doFilter(msg);
        }
        return msg;
    }
}
