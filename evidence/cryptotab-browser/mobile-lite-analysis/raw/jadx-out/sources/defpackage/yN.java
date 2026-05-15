package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yN extends AbstractC1864zn {
    public final InterfaceC0577eO u;
    public transient InterfaceC1670wN v;

    public yN(InterfaceC1670wN interfaceC1670wN, InterfaceC0577eO interfaceC0577eO) {
        super(interfaceC1670wN);
        this.u = interfaceC0577eO;
    }

    @Override // defpackage.InterfaceC1670wN
    public final InterfaceC0577eO getContext() {
        return this.u;
    }

    @Override // defpackage.AbstractC1864zn
    public final void p() {
        InterfaceC1670wN interfaceC1670wN = this.v;
        if (interfaceC1670wN != null && interfaceC1670wN != this) {
            ((d00) interfaceC1670wN).l();
        }
        this.v = NH.t;
    }

    public yN(InterfaceC1670wN interfaceC1670wN) {
        this(interfaceC1670wN, interfaceC1670wN != null ? interfaceC1670wN.getContext() : null);
    }
}
