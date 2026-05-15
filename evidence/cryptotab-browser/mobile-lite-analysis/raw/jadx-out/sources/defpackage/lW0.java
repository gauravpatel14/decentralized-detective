package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lW0 extends PI0 implements L00 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater w = AtomicIntegerFieldUpdater.newUpdater(lW0.class, "isTaken");
    private volatile /* synthetic */ int isTaken = 0;

    public abstract void w();

    public abstract boolean x();
}
