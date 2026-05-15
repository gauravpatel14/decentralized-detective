package defpackage;

import java.io.PrintWriter;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JH0 extends EH0 {
    public final Object a;
    public final IH0 b;

    public JH0(InterfaceC0762hF0 interfaceC0762hF0, C0094Ho2 c0094Ho2) {
        this.a = interfaceC0762hF0;
        C0083Go2 c0083Go2 = new C0083Go2(c0094Ho2, IH0.d, DO.b);
        iF iFVarA = Gs1.a(IH0.class);
        String strB = iFVarA.b();
        if (strB == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.b = (IH0) c0083Go2.a(iFVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strB));
    }

    public final void b(String str, PrintWriter printWriter) {
        IH0 ih0 = this.b;
        if (ih0.b.v <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Loaders:");
        String str2 = str + "    ";
        int i = 0;
        while (true) {
            C1325qM1 c1325qM1 = ih0.b;
            if (i >= c1325qM1.v) {
                return;
            }
            FH0 fh0 = (FH0) c1325qM1.u[i];
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(ih0.b.t[i]);
            printWriter.print(": ");
            printWriter.println(fh0.toString());
            printWriter.print(str2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str2);
            printWriter.print("mLoader=");
            printWriter.println(fh0.l);
            AbstractC1230og abstractC1230og = fh0.l;
            String str3 = str2 + "  ";
            abstractC1230og.getClass();
            printWriter.print(str3);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mListener=");
            printWriter.println(abstractC1230og.a);
            if (abstractC1230og.b || abstractC1230og.e) {
                printWriter.print(str3);
                printWriter.print("mStarted=");
                printWriter.print(abstractC1230og.b);
                printWriter.print(" mContentChanged=");
                printWriter.print(abstractC1230og.e);
                printWriter.print(" mProcessingChange=");
                printWriter.println(false);
            }
            if (abstractC1230og.c || abstractC1230og.d) {
                printWriter.print(str3);
                printWriter.print("mAbandoned=");
                printWriter.print(abstractC1230og.c);
                printWriter.print(" mReset=");
                printWriter.println(abstractC1230og.d);
            }
            if (abstractC1230og.g != null) {
                printWriter.print(str3);
                printWriter.print("mTask=");
                printWriter.print(abstractC1230og.g);
                printWriter.print(" waiting=");
                abstractC1230og.g.getClass();
                printWriter.println(false);
            }
            if (abstractC1230og.h != null) {
                printWriter.print(str3);
                printWriter.print("mCancellingTask=");
                printWriter.print(abstractC1230og.h);
                printWriter.print(" waiting=");
                abstractC1230og.h.getClass();
                printWriter.println(false);
            }
            if (fh0.n != null) {
                printWriter.print(str2);
                printWriter.print("mCallbacks=");
                printWriter.println(fh0.n);
                GH0 gh0 = fh0.n;
                gh0.getClass();
                printWriter.print(str2 + "  ");
                printWriter.print("mDeliveredData=");
                printWriter.println(gh0.b);
            }
            printWriter.print(str2);
            printWriter.print("mData=");
            AbstractC1230og abstractC1230og2 = fh0.l;
            Object obj = fh0.e;
            Object obj2 = obj != AbstractC1493tH0.k ? obj : null;
            abstractC1230og2.getClass();
            StringBuilder sb = new StringBuilder(64);
            if (obj2 == null) {
                sb.append("null");
            } else {
                sb.append(obj2.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(obj2)));
                sb.append("}");
            }
            printWriter.println(sb.toString());
            printWriter.print(str2);
            printWriter.print("mStarted=");
            printWriter.println(fh0.c > 0);
            i++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.a;
        sb.append(obj.getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}}");
        return sb.toString();
    }
}
