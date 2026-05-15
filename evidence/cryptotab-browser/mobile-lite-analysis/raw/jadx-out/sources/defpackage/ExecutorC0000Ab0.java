package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: Ab0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExecutorC0000Ab0 implements Executor {
    public static final ExecutorC0000Ab0 t = new ExecutorC0000Ab0();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
