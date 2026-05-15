package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Yv1 extends AbstractC1864zn {
    public Yv1(InterfaceC1670wN interfaceC1670wN) {
        super(interfaceC1670wN);
        if (interfaceC1670wN != null && interfaceC1670wN.getContext() != R60.t) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // defpackage.InterfaceC1670wN
    public final InterfaceC0577eO getContext() {
        return R60.t;
    }
}
