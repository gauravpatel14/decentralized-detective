package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: if0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExecutorC0857if0 implements Executor {
    public static final ExecutorC0857if0 t = new ExecutorC0857if0();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
