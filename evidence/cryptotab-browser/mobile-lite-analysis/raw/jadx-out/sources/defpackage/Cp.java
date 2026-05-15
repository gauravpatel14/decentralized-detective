package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Cp {
    public int a;
    public String b;

    public static Bp a() {
        Bp bp = new Bp();
        bp.b = "";
        return bp;
    }

    public final String toString() {
        int i = this.a;
        int i2 = AbstractC1659wF2.a;
        PE2 pe2 = EnumC1821zB2.v;
        Integer numValueOf = Integer.valueOf(i);
        return "Response Code: " + (!pe2.containsKey(numValueOf) ? EnumC1821zB2.u : (EnumC1821zB2) pe2.get(numValueOf)).toString() + ", Debug Message: " + this.b;
    }
}
