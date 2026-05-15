package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Em implements Q62 {
    public final int a;

    public Em(int i) {
        this.a = i;
    }

    @Override // defpackage.Q62
    public final void a(O62 o62) {
        Lm lmD = Lm.d();
        boolean z = o62.e;
        lmD.getClass();
        int i = this.a;
        if (z) {
            Lm.a(Lm.e(i), "Android.BackgroundTaskScheduler.TaskCreated.WithExpiration");
        } else {
            Lm.a(Lm.e(i), "Android.BackgroundTaskScheduler.TaskCreated.WithoutExpiration");
        }
    }

    @Override // defpackage.Q62
    public final void b(P62 p62) {
        Lm lmD = Lm.d();
        boolean z = p62.e;
        lmD.getClass();
        int i = this.a;
        if (z) {
            Lm.a(Lm.e(i), "Android.BackgroundTaskScheduler.TaskCreated.WithExpiration");
        } else {
            Lm.a(Lm.e(i), "Android.BackgroundTaskScheduler.TaskCreated.WithoutExpiration");
        }
    }
}
