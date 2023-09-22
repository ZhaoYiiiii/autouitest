package com.frame.demo2.xUtils;

public class Position {
    private String path;
    private String positionName;
    private ByType type;
    private int waitSec;

    public enum ByType {
        xpath, id, name, className, cssSelector, tagName, partialLinkText, linkText;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public ByType getType() {
        return type;
    }

    public void setType(ByType type) {
        this.type = type;
    }

    public int getWaitSec() {
        return waitSec;
    }

    public void setWaitSec(int waitSec) {
        this.waitSec = waitSec;
    }

    public Position(String path, ByType type, String positionName) {
        super();
        this.path = path;
        this.positionName = positionName;
        this.type = type;
    }

    //这种可以看作是针对iframe的情况
    public Position(String path, String positionName) {
        super();
        this.path = path;
        this.positionName = positionName;
    }

    public Position(String path, int waitSec, ByType type, String positionName) {
        super();
        this.path = path;
        this.waitSec = waitSec;
        this.positionName = positionName;
        this.type = type;
    }
}
