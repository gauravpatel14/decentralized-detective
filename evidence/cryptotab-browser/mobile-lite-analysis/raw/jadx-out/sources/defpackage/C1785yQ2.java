package defpackage;

import java.util.List;

/* JADX INFO: renamed from: yQ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1785yQ2 {
    public final /* synthetic */ TQ2 a;

    public C1785yQ2(TQ2 tq2) {
        this.a = tq2;
    }

    public final void a(int i, String str, List list, boolean z, boolean z2) {
        CO2 co2;
        int i2 = i - 1;
        TQ2 tq2 = this.a;
        if (i2 == 0) {
            WO2 wo2 = tq2.a.i;
            C1391rR2.k(wo2);
            co2 = wo2.m;
        } else if (i2 != 1) {
            if (i2 == 3) {
                WO2 wo22 = tq2.a.i;
                C1391rR2.k(wo22);
                co2 = wo22.n;
            } else if (i2 != 4) {
                WO2 wo23 = tq2.a.i;
                C1391rR2.k(wo23);
                co2 = wo23.l;
            } else if (z) {
                WO2 wo24 = tq2.a.i;
                C1391rR2.k(wo24);
                co2 = wo24.j;
            } else if (z2) {
                WO2 wo25 = tq2.a.i;
                C1391rR2.k(wo25);
                co2 = wo25.i;
            } else {
                WO2 wo26 = tq2.a.i;
                C1391rR2.k(wo26);
                co2 = wo26.k;
            }
        } else if (z) {
            WO2 wo27 = tq2.a.i;
            C1391rR2.k(wo27);
            co2 = wo27.g;
        } else if (z2) {
            WO2 wo28 = tq2.a.i;
            C1391rR2.k(wo28);
            co2 = wo28.f;
        } else {
            WO2 wo29 = tq2.a.i;
            C1391rR2.k(wo29);
            co2 = wo29.h;
        }
        int size = list.size();
        if (size == 1) {
            co2.b(list.get(0), str);
            return;
        }
        if (size == 2) {
            co2.c(list.get(0), list.get(1), str);
        } else if (size != 3) {
            co2.a(str);
        } else {
            co2.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
