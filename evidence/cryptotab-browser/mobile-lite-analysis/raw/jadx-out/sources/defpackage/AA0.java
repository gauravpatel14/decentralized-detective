package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AA0 {
    public final dj0 a;
    public final RunnableC1766yA0 b = new RunnableC1766yA0(this, 1);
    public final AtomicBoolean c = new AtomicBoolean(false);

    public AA0(dj0 dj0Var) {
        this.a = dj0Var;
        AbstractC1819zA0.a.post(new RunnableC1766yA0(this, 0));
    }
}
