package defpackage;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Gu1 implements ThreadFactory {
    public String a;
    public int b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Fu1(runnable, this.a, this.b);
    }
}
