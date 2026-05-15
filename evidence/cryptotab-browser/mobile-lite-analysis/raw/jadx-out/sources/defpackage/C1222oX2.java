package defpackage;

import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: oX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1222oX2 implements InterfaceC1023lN1 {
    public final QH2 a;
    public final QH2 b;
    public final QH2 c;

    public C1222oX2(QH2 qh2, QH2 qh22, QH2 qh23) {
        this.a = qh2;
        this.b = qh22;
        this.c = qh23;
    }

    @Override // defpackage.InterfaceC1023lN1
    public final G62 a(List list) {
        return h().a(list);
    }

    @Override // defpackage.InterfaceC1023lN1
    public final Set b() {
        return h().b();
    }

    @Override // defpackage.InterfaceC1023lN1
    public final void c(InterfaceC1267pN1 interfaceC1267pN1) {
        h().c(interfaceC1267pN1);
    }

    @Override // defpackage.InterfaceC1023lN1
    public final Set d() {
        return h().d();
    }

    @Override // defpackage.InterfaceC1023lN1
    public final void e(InterfaceC1267pN1 interfaceC1267pN1) {
        h().e(interfaceC1267pN1);
    }

    @Override // defpackage.InterfaceC1023lN1
    public final G62 f(List list) {
        return h().f(list);
    }

    @Override // defpackage.InterfaceC1023lN1
    public final G62 g(C1207oN1 c1207oN1) {
        return h().g(c1207oN1);
    }

    public final InterfaceC1023lN1 h() {
        return this.c.zza() == null ? (InterfaceC1023lN1) this.a.zza() : (InterfaceC1023lN1) this.b.zza();
    }
}
