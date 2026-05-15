package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ex extends OH {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(Ex.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    public Ex(C1703wx c1703wx, Throwable th, boolean z) {
        super(th, z);
        this._resumed = 0;
    }
}
