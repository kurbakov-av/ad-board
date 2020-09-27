package com.example.adboard.domain;

public enum Status {
    CREATED,
    MODERATION,
    PUBLISHED,
    REJECT,
    BLOCK,
    CLOSE,
    TERMINATE;

    public boolean isCreated() {
        return this == CREATED;
    }

    public boolean isModeration() {
        return this == MODERATION;
    }

    public boolean isPublished() {
        return this == PUBLISHED;
    }

    public boolean isReject() {
        return this == REJECT;
    }

    public boolean isBlock() {
        return this == BLOCK;
    }

    public boolean isClose() {
        return this == CLOSE;
    }

    public boolean isTerminate() {
        return this == TERMINATE;
    }
}
