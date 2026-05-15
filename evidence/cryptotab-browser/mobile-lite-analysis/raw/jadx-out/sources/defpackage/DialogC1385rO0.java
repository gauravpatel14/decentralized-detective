package defpackage;

import android.content.Context;
import android.os.SystemClock;
import android.view.ContextThemeWrapper;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: rO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DialogC1385rO0 extends AbstractDialogC0788hb {
    public C0468cP0 A;
    public ArrayList B;
    public TextView C;
    public TextView D;
    public RelativeLayout E;
    public TextView F;
    public TextView G;
    public LinearLayout H;
    public Button I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ProgressBar f36J;
    public ListView K;
    public C1209oO0 L;
    public final C1329qO0 M;
    public boolean N;
    public long O;
    public final mO0 P;
    public final C1087mP0 y;
    public final C1147nO0 z;

    /* JADX WARN: Illegal instructions before constructor call */
    public DialogC1385rO0(int i, Context context) {
        ContextThemeWrapper contextThemeWrapperA = oP0.a(i, context, false);
        super(oP0.b(contextThemeWrapperA), contextThemeWrapperA);
        this.A = C0468cP0.c;
        this.P = new mO0(this);
        this.y = C1087mP0.d(getContext());
        this.z = new C1147nO0(this);
        this.M = new C1329qO0(this);
    }

    @Override // defpackage.AbstractDialogC0788hb, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            getContext().unregisterReceiver(this.M);
        } catch (IllegalArgumentException unused) {
        }
        super.dismiss();
    }

    public final void i(List list) {
        this.O = SystemClock.uptimeMillis();
        this.B.clear();
        this.B.addAll(list);
        this.L.notifyDataSetChanged();
        mO0 mo0 = this.P;
        mo0.removeMessages(3);
        mo0.removeMessages(2);
        if (!list.isEmpty()) {
            m(1);
        } else {
            m(0);
            mo0.sendMessageDelayed(mo0.obtainMessage(2), 5000L);
        }
    }

    public final void j() {
        if (this.N) {
            this.y.getClass();
            ArrayList arrayList = new ArrayList(C1087mP0.f());
            int size = arrayList.size();
            while (true) {
                int i = size - 1;
                if (size <= 0) {
                    break;
                }
                C0838iP0 c0838iP0 = (C0838iP0) arrayList.get(i);
                if (c0838iP0.b() || !c0838iP0.g || !c0838iP0.f(this.A)) {
                    arrayList.remove(i);
                }
                size = i;
            }
            Collections.sort(arrayList, C1268pO0.a);
            if (SystemClock.uptimeMillis() - this.O >= 300) {
                i(arrayList);
                return;
            }
            mO0 mo0 = this.P;
            mo0.removeMessages(1);
            mo0.sendMessageAtTime(mo0.obtainMessage(1, arrayList), this.O + 300);
        }
    }

    public final void k(C0468cP0 c0468cP0) {
        if (c0468cP0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.A.equals(c0468cP0)) {
            return;
        }
        this.A = c0468cP0;
        if (this.N) {
            C1087mP0 c1087mP0 = this.y;
            C1147nO0 c1147nO0 = this.z;
            c1087mP0.h(c1147nO0);
            c1087mP0.a(c0468cP0, c1147nO0, 1);
        }
        j();
    }

    public final void m(int i) {
        if (i == 0) {
            setTitle(AbstractC0275Wp1.mr_chooser_title);
            this.K.setVisibility(8);
            this.D.setVisibility(0);
            this.f36J.setVisibility(0);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.G.setVisibility(8);
            this.E.setVisibility(8);
            return;
        }
        if (i == 1) {
            setTitle(AbstractC0275Wp1.mr_chooser_title);
            this.K.setVisibility(0);
            this.D.setVisibility(8);
            this.f36J.setVisibility(8);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.G.setVisibility(8);
            this.E.setVisibility(8);
            return;
        }
        if (i == 2) {
            setTitle(AbstractC0275Wp1.mr_chooser_title);
            this.K.setVisibility(8);
            this.D.setVisibility(8);
            this.f36J.setVisibility(0);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.G.setVisibility(4);
            this.E.setVisibility(0);
            return;
        }
        if (i != 3) {
            return;
        }
        setTitle(AbstractC0275Wp1.mr_chooser_zero_routes_found_title);
        this.K.setVisibility(8);
        this.D.setVisibility(8);
        this.f36J.setVisibility(8);
        this.H.setVisibility(0);
        this.I.setVisibility(0);
        this.G.setVisibility(0);
        this.E.setVisibility(0);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.N = true;
        this.y.a(this.A, this.z, 1);
        j();
        mO0 mo0 = this.P;
        mo0.removeMessages(2);
        mo0.removeMessages(3);
        mo0.removeMessages(1);
        mo0.sendMessageDelayed(mo0.obtainMessage(2), 5000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0166  */
    @Override // defpackage.AbstractDialogC0788hb, defpackage.lI, android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.DialogC1385rO0.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.N = false;
        this.y.h(this.z);
        mO0 mo0 = this.P;
        mo0.removeMessages(1);
        mo0.removeMessages(2);
        mo0.removeMessages(3);
        super.onDetachedFromWindow();
    }

    @Override // defpackage.AbstractDialogC0788hb, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        this.C.setText(charSequence);
    }

    @Override // defpackage.AbstractDialogC0788hb, android.app.Dialog
    public final void setTitle(int i) {
        this.C.setText(i);
    }
}
