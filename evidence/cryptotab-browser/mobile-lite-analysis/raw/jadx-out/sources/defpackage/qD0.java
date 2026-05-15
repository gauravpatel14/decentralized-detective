package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class qD0 {
    public static qD0 f;
    public Lc b;
    public int d;
    public boolean e;
    public final C1132nD0 a = new InterfaceC1267pN1() { // from class: nD0
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        @Override // defpackage.InterfaceC1267pN1
        public final void a(Object obj) {
            IB2 ib2 = (IB2) obj;
            qD0 qd0 = this.a;
            qd0.getClass();
            if (ib2.a != qd0.d) {
                return;
            }
            int i = ib2.b;
            if (i == 5 || i == 6 || i == 7 || i == 3) {
                Gr1.h(i != 3 ? i != 5 ? i != 6 ? i != 7 ? 5 : 2 : 4 : qd0.e : 3, 6, "LanguageSettings.SplitInstallFinalStatus");
                qd0.b.a(i == 5);
                qd0.c.c(qd0.a);
                qd0.b = null;
                qd0.d = 0;
                qd0.e = false;
            }
        }
    };
    public final InterfaceC1023lN1 c = AbstractC1085mN1.a(AbstractC1499tM.a);
}
