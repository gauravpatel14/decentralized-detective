package defpackage;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ER0 {
    public final ByteBuffer a;
    public final ArrayList b;
    public SE1 c;

    public ER0(ByteBuffer byteBuffer, ArrayList arrayList) {
        this.a = byteBuffer;
        this.b = arrayList;
    }

    public SE1 a() {
        if (this.c == null) {
            this.c = new SE1(this, new wS0(this));
        }
        return this.c;
    }
}
