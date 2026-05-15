package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bQ1 extends RC0 implements InterfaceC0926jk0 {
    public final /* synthetic */ String u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bQ1(String str) {
        super(1);
        this.u = str;
    }

    @Override // defpackage.InterfaceC0926jk0
    public final Object j(Object obj) {
        C1417ry0 c1417ry0 = (C1417ry0) obj;
        int i = c1417ry0.u + 1;
        return this.u.subSequence(c1417ry0.t, i).toString();
    }
}
