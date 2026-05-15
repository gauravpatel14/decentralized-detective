package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: i00, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorC0815i00 implements Executor {
    public final AbstractC0771hO t;

    public ExecutorC0815i00(AbstractC0771hO abstractC0771hO) {
        this.t = abstractC0771hO;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.t.c(R60.t, runnable);
    }

    public final String toString() {
        return this.t.toString();
    }
}
