package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HT2 implements Runnable {
    public final /* synthetic */ String t;
    public final /* synthetic */ String u;
    public final /* synthetic */ Object v;
    public final /* synthetic */ long w;
    public final /* synthetic */ IU2 x;

    public HT2(IU2 iu2, String str, String str2, Object obj, long j) {
        this.x = iu2;
        this.t = str;
        this.u = str2;
        this.v = obj;
        this.w = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.v;
        this.x.w(this.w, obj, this.t, this.u);
    }
}
