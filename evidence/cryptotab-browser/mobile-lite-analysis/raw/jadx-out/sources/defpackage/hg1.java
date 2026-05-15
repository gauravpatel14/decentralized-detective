package defpackage;

import java.util.concurrent.Executor;
import org.chromium.base.ThreadUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hg1 implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        ThreadUtils.b().post(runnable);
    }
}
