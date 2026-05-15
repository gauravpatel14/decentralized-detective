package defpackage;

import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class I23 extends AbstractC1823zD2 {
    public final CallableC0839iQ2 v;

    public I23(CallableC0839iQ2 callableC0839iQ2) {
        super("internal.appMetadata");
        this.v = callableC0839iQ2;
    }

    @Override // defpackage.AbstractC1823zD2
    public final InterfaceC1601vE2 a(IQ2 iq2, List list) {
        try {
            return AbstractC0712gU2.b(this.v.call());
        } catch (Exception unused) {
            return InterfaceC1601vE2.l;
        }
    }
}
