package com.company.modulejava.lecture14.ex0;

public abstract class CrossCompiler {
    public final void crossCompile() {
        collectSource();
        compileToTarget();
    }
    //Template methods
    protected abstract void collectSource();
    protected abstract void compileToTarget();
}
