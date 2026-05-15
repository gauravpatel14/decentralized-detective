package defpackage;

import java.math.BigDecimal;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class P33 extends K33 {
    public final C1446sO2 g;
    public final /* synthetic */ C0334aC2 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P33(C0334aC2 c0334aC2, String str, int i, C1446sO2 c1446sO2) {
        super(str, i);
        this.h = c0334aC2;
        this.g = c1446sO2;
    }

    @Override // defpackage.K33
    public final int a() {
        return this.g.l();
    }

    @Override // defpackage.K33
    public final boolean b() {
        return false;
    }

    @Override // defpackage.K33
    public final boolean c() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean h(Long l, Long l2, C1618vR2 c1618vR2, boolean z) {
        C0327a03.a();
        C0334aC2 c0334aC2 = this.h;
        boolean zP = c0334aC2.a.g.p(this.a, AbstractC0579eO2.U);
        C1446sO2 c1446sO2 = this.g;
        boolean zQ = c1446sO2.q();
        boolean zR = c1446sO2.r();
        boolean zS = c1446sO2.s();
        Object[] objArr = zQ || zR || zS;
        Boolean boolG = null;
        boolD = null;
        Boolean boolD = null;
        boolG = null;
        boolG = null;
        boolG = null;
        Boolean boolD2 = null;
        boolG = null;
        C1391rR2 c1391rR2 = c0334aC2.a;
        if (z && objArr != true) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.c(Integer.valueOf(this.b), c1446sO2.t() ? Integer.valueOf(c1446sO2.l()) : null, "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID");
            return true;
        }
        C0350aO2 c0350aO2M = c1446sO2.m();
        boolean zQ2 = c0350aO2M.q();
        if (c1618vR2.A()) {
            if (c0350aO2M.s()) {
                boolG = K33.g(K33.f(c1618vR2.m(), c0350aO2M.m()), zQ2);
            } else {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.i.b(c1391rR2.m.d(c1618vR2.p()), "No number filter for long property. property");
            }
        } else if (c1618vR2.z()) {
            if (c0350aO2M.s()) {
                double dL = c1618vR2.l();
                try {
                    boolD = K33.d(new BigDecimal(dL), c0350aO2M.m(), Math.ulp(dL));
                } catch (NumberFormatException unused) {
                }
                boolG = K33.g(boolD, zQ2);
            } else {
                WO2 wo23 = c1391rR2.i;
                C1391rR2.k(wo23);
                wo23.i.b(c1391rR2.m.d(c1618vR2.p()), "No number filter for double property. property");
            }
        } else if (!c1618vR2.C()) {
            WO2 wo24 = c1391rR2.i;
            C1391rR2.k(wo24);
            wo24.i.b(c1391rR2.m.d(c1618vR2.p()), "User property has no value, property");
        } else if (c0350aO2M.t()) {
            String strQ = c1618vR2.q();
            BO2 bo2N = c0350aO2M.n();
            WO2 wo25 = c1391rR2.i;
            C1391rR2.k(wo25);
            boolG = K33.g(K33.e(strQ, bo2N, wo25), zQ2);
        } else if (!c0350aO2M.s()) {
            WO2 wo26 = c1391rR2.i;
            C1391rR2.k(wo26);
            wo26.i.b(c1391rR2.m.d(c1618vR2.p()), "No string or number filter defined. property");
        } else if (VX2.A(c1618vR2.q())) {
            String strQ2 = c1618vR2.q();
            C1148nO2 c1148nO2M = c0350aO2M.m();
            if (VX2.A(strQ2)) {
                try {
                    boolD2 = K33.d(new BigDecimal(strQ2), c1148nO2M, 0.0d);
                } catch (NumberFormatException unused2) {
                }
            }
            boolG = K33.g(boolD2, zQ2);
        } else {
            WO2 wo27 = c1391rR2.i;
            C1391rR2.k(wo27);
            wo27.i.c(c1391rR2.m.d(c1618vR2.p()), c1618vR2.q(), "Invalid user property value for Numeric number filter. property, value");
        }
        WO2 wo28 = c1391rR2.i;
        C1391rR2.k(wo28);
        wo28.n.b(boolG == null ? "null" : boolG, "Property filter result");
        if (boolG == null) {
            return false;
        }
        this.c = Boolean.TRUE;
        if (zS && !boolG.booleanValue()) {
            return true;
        }
        if (!z || c1446sO2.q()) {
            this.d = boolG;
        }
        if (boolG.booleanValue() && objArr != false && c1618vR2.B()) {
            long jN = c1618vR2.n();
            if (l != null) {
                jN = l.longValue();
            }
            if (zP && c1446sO2.q() && !c1446sO2.r() && l2 != null) {
                jN = l2.longValue();
            }
            if (c1446sO2.r()) {
                this.f = Long.valueOf(jN);
            } else {
                this.e = Long.valueOf(jN);
            }
        }
        return true;
    }
}
