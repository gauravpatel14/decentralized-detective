package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: j13, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0877j13 implements JO2 {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ long c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ ArrayList e;
    public final /* synthetic */ C0219Sa0 f;

    public C0877j13(C0219Sa0 c0219Sa0, ArrayList arrayList, ArrayList arrayList2, long j, boolean z, ArrayList arrayList3) {
        this.f = c0219Sa0;
        this.a = arrayList;
        this.b = arrayList2;
        this.c = j;
        this.d = z;
        this.e = arrayList3;
    }

    @Override // defpackage.JO2
    public final void a(int i) {
        this.f.k(6, i, null, null, null, null, null);
    }

    @Override // defpackage.JO2
    public final void zza() {
        ArrayList arrayList = this.a;
        ArrayList arrayList2 = this.b;
        C0219Sa0 c0219Sa0 = this.f;
        c0219Sa0.l.addAll(arrayList);
        c0219Sa0.m.addAll(arrayList2);
        Long lValueOf = Long.valueOf(this.c);
        c0219Sa0.k(5, 0, null, lValueOf, lValueOf, null, null);
    }

    @Override // defpackage.JO2
    public final void zzc() {
        if (this.d) {
            return;
        }
        ArrayList arrayList = this.e;
        ArrayList arrayList2 = this.a;
        ArrayList arrayList3 = this.b;
        C0219Sa0 c0219Sa0 = this.f;
        c0219Sa0.i.getClass();
        QD2 qd2 = (QD2) GZ2.u.get();
        C0877j13 c0877j13 = new C0877j13(c0219Sa0, arrayList2, arrayList3, this.c, true, arrayList);
        qd2.getClass();
        if (NM1.e.get() == null) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        qd2.d.execute(new JD2(qd2, arrayList, c0877j13));
    }
}
