package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class z33 extends K33 {
    public final RN2 g;
    public final /* synthetic */ C0334aC2 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z33(C0334aC2 c0334aC2, String str, int i, RN2 rn2) {
        super(str, i);
        this.h = c0334aC2;
        this.g = rn2;
    }

    @Override // defpackage.K33
    public final int a() {
        return this.g.m();
    }

    @Override // defpackage.K33
    public final boolean b() {
        return this.g.x();
    }

    @Override // defpackage.K33
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(java.lang.Long r17, java.lang.Long r18, defpackage.C0471cQ2 r19, long r20, defpackage.KE2 r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 867
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z33.h(java.lang.Long, java.lang.Long, cQ2, long, KE2, boolean):boolean");
    }
}
