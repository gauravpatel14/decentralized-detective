package defpackage;

import android.view.ViewGroup;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: us1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C1584us1 extends Pr1 implements QG0 {
    public final Bh0 w;
    public final InterfaceC1529ts1 x;

    /* JADX WARN: Multi-variable type inference failed */
    public C1584us1(ss1 ss1Var, InterfaceC1529ts1 interfaceC1529ts1) {
        this.w = (Bh0) ss1Var;
        this.x = interfaceC1529ts1;
        ((SG0) ss1Var).l(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [Bh0, ss1] */
    @Override // defpackage.Pr1
    public final int b() {
        return this.w.g();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [Bh0, ss1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.Pr1
    public final int d(int i) {
        return this.w.getItemViewType(i);
    }

    @Override // defpackage.QG0
    public final void e(SG0 sg0, int i, int i2, Object obj) {
        this.t.d(i, i2, obj);
    }

    @Override // defpackage.QG0
    public final void h(int i, int i2) {
        this.t.c(i, i2);
    }

    @Override // defpackage.QG0
    public final void j(SG0 sg0, int i, int i2) {
        i(i, i2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [Bh0, ss1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.Pr1
    public final void m(ps1 ps1Var, int i) {
        this.w.i(ps1Var, i, null);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [Bh0, ss1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.Pr1
    public final void n(ps1 ps1Var, int i, List list) {
        if (list.isEmpty()) {
            m(ps1Var, i);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.w.i(ps1Var, i, it.next());
        }
    }

    @Override // defpackage.Pr1
    public final ps1 o(int i, ViewGroup viewGroup) {
        return (ps1) this.x.a(i, viewGroup);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [Bh0, ss1] */
    @Override // defpackage.Pr1
    public final void s(ps1 ps1Var) {
        this.w.k(ps1Var);
    }
}
