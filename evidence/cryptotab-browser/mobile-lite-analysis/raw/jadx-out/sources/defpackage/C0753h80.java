package defpackage;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: h80, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0753h80 implements InterfaceC1390rR1, yn1 {
    public final HashMap a = new HashMap();
    public ArrayDeque b = new ArrayDeque();
    public final ExecutorC0367af0 c;

    public C0753h80(ExecutorC0367af0 executorC0367af0) {
        this.c = executorC0367af0;
    }

    public final synchronized void a(Executor executor, InterfaceC0940k80 interfaceC0940k80) {
        try {
            executor.getClass();
            if (!this.a.containsKey(LT.class)) {
                this.a.put(LT.class, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.a.get(LT.class)).put(interfaceC0940k80, executor);
        } catch (Throwable th) {
            throw th;
        }
    }
}
