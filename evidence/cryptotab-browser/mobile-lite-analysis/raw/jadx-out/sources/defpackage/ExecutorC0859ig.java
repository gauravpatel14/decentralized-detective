package defpackage;

import java.util.concurrent.Executor;
import org.chromium.base.task.PostTask;

/* JADX INFO: renamed from: ig, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExecutorC0859ig implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        PostTask.c(1, runnable);
    }
}
