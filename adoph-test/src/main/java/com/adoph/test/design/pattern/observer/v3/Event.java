package com.adoph.test.design.pattern.observer.v3;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/3/21
 */
public abstract class Event {

    public Event(Object src) {
        this.src = src;
    }

    private String name;
    private long happenTime;
    private Object src;

    public long getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(long happenTime) {
        this.happenTime = happenTime;
    }

    public Object getSrc() {
        return src;
    }

    public void setSrc(Object src) {
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
