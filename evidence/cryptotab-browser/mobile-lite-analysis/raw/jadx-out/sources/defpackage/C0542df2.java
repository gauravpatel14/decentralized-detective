package defpackage;

import J.N;
import android.util.Printer;
import org.chromium.base.EarlyTraceEvent;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: df2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0542df2 implements Printer {
    public String a;

    public void a(String str) {
        String str2;
        boolean zD = EarlyTraceEvent.d();
        if (TraceEvent.u || zD) {
            if (TraceEvent.w) {
                str2 = "Looper.dispatch: EVENT_NAME_FILTERED";
            } else {
                int iIndexOf = str.indexOf(40, 18);
                int iIndexOf2 = iIndexOf == -1 ? -1 : str.indexOf(41, iIndexOf);
                String strSubstring = iIndexOf2 != -1 ? str.substring(iIndexOf + 1, iIndexOf2) : "";
                int iIndexOf3 = str.indexOf(125, 18);
                int iIndexOf4 = iIndexOf3 == -1 ? -1 : str.indexOf(58, iIndexOf3);
                if (iIndexOf4 == -1) {
                    iIndexOf4 = str.length();
                }
                str2 = "Looper.dispatch: " + strSubstring + "(" + (iIndexOf3 != -1 ? str.substring(iIndexOf3 + 2, iIndexOf4) : "") + ")";
            }
            this.a = str2;
            if (TraceEvent.u) {
                N._V_O(6, this.a);
            } else {
                EarlyTraceEvent.a(this.a, true);
            }
        }
    }

    public void b(String str) {
        boolean zD = EarlyTraceEvent.d();
        if ((TraceEvent.u || zD) && this.a != null) {
            if (TraceEvent.u) {
                N._V(4);
            } else {
                EarlyTraceEvent.e(this.a, true);
            }
        }
        this.a = null;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (str.startsWith(">")) {
            a(str);
        } else {
            b(str);
        }
    }
}
