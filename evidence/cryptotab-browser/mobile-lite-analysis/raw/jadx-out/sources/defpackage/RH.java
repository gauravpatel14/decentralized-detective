package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RH {
    public final Shader a;
    public final ColorStateList b;
    public int c;

    public RH(Shader shader, ColorStateList colorStateList, int i) {
        this.a = shader;
        this.b = colorStateList;
        this.c = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ff, code lost:
    
        if (r6 == 1) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0201, code lost:
    
        if (r6 == 2) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0203, code lost:
    
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0208, code lost:
    
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x020b, code lost:
    
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x020e, code lost:
    
        r3 = new android.graphics.LinearGradient(r12, r26, r25, r24, r0.a, r0.b, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0221, code lost:
    
        r3 = new android.graphics.SweepGradient(r20, r21, r0.a, r0.b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0236, code lost:
    
        if (r22 <= 0.0f) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x023b, code lost:
    
        if (r6 == 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x023e, code lost:
    
        if (r6 == 2) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0240, code lost:
    
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0243, code lost:
    
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0246, code lost:
    
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0248, code lost:
    
        r3 = new android.graphics.RadialGradient(r20, r21, r22, r0.a, r0.b, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0264, code lost:
    
        return new defpackage.RH(r3, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x026c, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01dd, code lost:
    
        if (r15.size() <= 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01df, code lost:
    
        r0 = new defpackage.C0047Dm0(r15, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e5, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e6, code lost:
    
        if (r0 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ea, code lost:
    
        if (r18 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01ec, code lost:
    
        r0 = new defpackage.C0047Dm0(r7, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01f2, code lost:
    
        r0 = new defpackage.C0047Dm0(r7, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01f8, code lost:
    
        if (r8 == 1) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01fb, code lost:
    
        if (r8 == 2) goto L108;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.RH a(android.content.res.Resources r27, int r28, android.content.res.Resources.Theme r29) {
        /*
            Method dump skipped, instruction units count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.RH.a(android.content.res.Resources, int, android.content.res.Resources$Theme):RH");
    }

    public final boolean b() {
        ColorStateList colorStateList;
        return this.a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }
}
