package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.view.Display;
import java.util.List;
import java.util.WeakHashMap;
import org.chromium.ui.display.DisplayAndroidManager;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o00 {
    public static final n00[] q = new n00[0];
    public final int b;
    public float d;
    public float e;
    public float f;
    public int g;
    public int h;
    public int i;
    public float j;
    public Display.Mode k;
    public List l;
    public boolean m;
    public boolean o;
    public boolean p;
    public float n = 1.0f;
    public final WeakHashMap a = new WeakHashMap();
    public Point c = new Point();

    public o00(int i) {
        this.b = i;
    }

    public static o00 a(Context context) {
        Display displayA = DisplayAndroidManager.a(context);
        DisplayAndroidManager displayAndroidManagerB = DisplayAndroidManager.b();
        displayAndroidManagerB.getClass();
        int displayId = displayA.getDisplayId();
        SparseArray sparseArray = displayAndroidManagerB.c;
        o00 o00Var = (o00) sparseArray.get(displayId);
        if (o00Var != null) {
            return o00Var;
        }
        int displayId2 = displayA.getDisplayId();
        jg1 jg1Var = new jg1(displayA);
        sparseArray.put(displayId2, jg1Var);
        jg1Var.f(displayA);
        return jg1Var;
    }

    public final n00[] b() {
        return (n00[]) this.a.keySet().toArray(q);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ba A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.graphics.Point r20, java.lang.Float r21, java.lang.Float r22, java.lang.Float r23, java.lang.Integer r24, java.lang.Integer r25, java.lang.Integer r26, java.lang.Boolean r27, java.lang.Boolean r28, java.lang.Float r29, android.view.Display.Mode r30, java.util.List r31, java.lang.Boolean r32, java.lang.Float r33) {
        /*
            Method dump skipped, instruction units count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o00.c(android.graphics.Point, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Float, android.view.Display$Mode, java.util.List, java.lang.Boolean, java.lang.Float):void");
    }
}
