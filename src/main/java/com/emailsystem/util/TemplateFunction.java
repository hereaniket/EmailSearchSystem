package com.emailsystem.util;

@FunctionalInterface
public interface TemplateFunction<A,B,C> {
    C apply(A a, B b);
}
