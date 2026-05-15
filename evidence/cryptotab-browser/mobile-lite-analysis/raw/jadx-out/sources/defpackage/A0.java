package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class A0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    public A0(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
        this.g = z7;
        this.h = z8;
    }

    public final String toString() {
        return "State{isScreenReaderEnabled=" + this.a + ", isTouchExplorationEnabled=" + this.b + ", isPerformGesturesEnabled=" + this.c + ", isAnyAccessibilityServiceEnabled=" + this.d + ", isAccessibilityToolPresent=" + this.e + ", isSpokenFeedbackServicePresent=" + this.f + ", isTextShowPasswordEnabled=" + this.g + ", isOnlyPasswordManagersEnabled=" + this.h + "}";
    }
}
