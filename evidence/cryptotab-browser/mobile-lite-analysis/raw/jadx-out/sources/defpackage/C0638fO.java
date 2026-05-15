package defpackage;

/* JADX INFO: renamed from: fO, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0638fO extends RC0 implements xk0 {
    public static final C0638fO v = new C0638fO(2, 0);
    public static final C0638fO w = new C0638fO(2, 1);
    public final /* synthetic */ int u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0638fO(int i, int i2) {
        super(i);
        this.u = i2;
    }

    @Override // defpackage.xk0
    public final Object i(Object obj, Object obj2) {
        switch (this.u) {
            case 0:
                return ((InterfaceC0577eO) obj).j((InterfaceC0405bO) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            default:
                return ((InterfaceC0577eO) obj).j((InterfaceC0405bO) obj2);
        }
    }
}
