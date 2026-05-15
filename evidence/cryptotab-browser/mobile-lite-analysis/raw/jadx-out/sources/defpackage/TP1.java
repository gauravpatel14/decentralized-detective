package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TP1 extends RC0 implements InterfaceC0926jk0 {
    public final /* synthetic */ String u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TP1(String str) {
        super(1);
        this.u = str;
    }

    @Override // defpackage.InterfaceC0926jk0
    public final Object j(Object obj) {
        String str = (String) obj;
        boolean zG = cQ1.g(str);
        String str2 = this.u;
        return zG ? str.length() < str2.length() ? str2 : str : F.a(str2, str);
    }
}
