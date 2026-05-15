package defpackage;

import android.content.Context;
import org.chromium.base.process_launcher.FileDescriptorInfo;
import org.chromium.content.app.ContentChildProcessServiceDelegate;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CA {
    public static boolean p;
    public static int q;
    public static long r;
    public final ContentChildProcessServiceDelegate a;
    public final AbstractServiceC1019lL b;
    public final Context c;
    public boolean f;
    public int g;
    public String h;
    public Thread i;
    public String[] j;
    public FileDescriptorInfo[] k;
    public boolean l;
    public boolean m;
    public hs0 n;
    public final Object d = new Object();
    public final Object e = new Object();
    public final BA o = new BA(this);

    public CA(ContentChildProcessServiceDelegate contentChildProcessServiceDelegate, AbstractServiceC1019lL abstractServiceC1019lL, Context context) {
        this.a = contentChildProcessServiceDelegate;
        this.b = abstractServiceC1019lL;
        this.c = context;
    }
}
