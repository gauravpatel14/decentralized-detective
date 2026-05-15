package defpackage;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import org.chromium.base.task.PostTask;

/* JADX INFO: renamed from: lg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RejectedExecutionHandlerC1041lg implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        ExecutorC0859ig executorC0859ig = AbstractC1103mg.e;
        PostTask.c(1, runnable);
    }
}
