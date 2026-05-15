package org.chromium.mojo.system.impl;

import java.io.Closeable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class BaseRunLoop implements Closeable {
    public static void runRunnable(Runnable runnable) {
        runnable.run();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }
}
