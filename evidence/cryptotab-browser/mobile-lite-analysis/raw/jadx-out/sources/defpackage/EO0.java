package defpackage;

import android.app.PendingIntent;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.mediarouter.app.d;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EO0 implements View.OnClickListener {
    public final /* synthetic */ int t;
    public final /* synthetic */ d u;

    public /* synthetic */ EO0(d dVar, int i) {
        this.t = i;
        this.u = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        PlaybackStateCompat playbackStateCompat;
        PendingIntent sessionActivity;
        switch (this.t) {
            case 0:
                int id = view.getId();
                d dVar = this.u;
                if (id == 16908313 || id == 16908314) {
                    if (dVar.B.e()) {
                        i = id == 16908313 ? 2 : 1;
                        dVar.z.getClass();
                        if (i < 0 || i > 3) {
                            throw new IllegalArgumentException("Unsupported reason to unselect route");
                        }
                        C1087mP0.b();
                        bm0 bm0VarC = C1087mP0.c();
                        C0838iP0 c0838iP0C = bm0VarC.c();
                        if (bm0VarC.e() != c0838iP0C) {
                            bm0VarC.g(c0838iP0C, i, true);
                        }
                    }
                    dVar.dismiss();
                    return;
                }
                if (id != AbstractC0132Lp1.mr_control_playback_ctrl) {
                    if (id == AbstractC0132Lp1.mr_close) {
                        dVar.dismiss();
                        return;
                    }
                    return;
                }
                YM0 ym0 = dVar.l0;
                if (ym0 == null || (playbackStateCompat = dVar.n0) == null) {
                    return;
                }
                int i2 = 0;
                i = playbackStateCompat.t != 3 ? 0 : 1;
                if (i != 0 && (playbackStateCompat.x & 514) != 0) {
                    ym0.a().a.pause();
                    i2 = AbstractC0275Wp1.mr_controller_pause;
                } else if (i != 0 && (playbackStateCompat.x & 1) != 0) {
                    ym0.a().a.stop();
                    i2 = AbstractC0275Wp1.mr_controller_stop;
                } else if (i == 0 && (playbackStateCompat.x & 516) != 0) {
                    ym0.a().a.play();
                    i2 = AbstractC0275Wp1.mr_controller_play;
                }
                AccessibilityManager accessibilityManager = dVar.G0;
                if (accessibilityManager == null || !accessibilityManager.isEnabled() || i2 == 0) {
                    return;
                }
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
                accessibilityEventObtain.setPackageName(dVar.C.getPackageName());
                accessibilityEventObtain.setClassName(EO0.class.getName());
                accessibilityEventObtain.getText().add(dVar.C.getString(i2));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
                return;
            case 1:
                this.u.dismiss();
                return;
            case 2:
                d dVar2 = this.u;
                YM0 ym02 = dVar2.l0;
                if (ym02 == null || (sessionActivity = ym02.a.a.getSessionActivity()) == null) {
                    return;
                }
                try {
                    sessionActivity.send();
                    dVar2.dismiss();
                    return;
                } catch (PendingIntent.CanceledException unused) {
                    Log.e("MediaRouteCtrlDialog", sessionActivity + " was not sent, it had been canceled.");
                    return;
                }
            default:
                d dVar3 = this.u;
                boolean z = dVar3.x0;
                dVar3.x0 = !z;
                if (!z) {
                    dVar3.X.setVisibility(0);
                }
                dVar3.D0 = dVar3.x0 ? dVar3.E0 : dVar3.F0;
                dVar3.w(true);
                return;
        }
    }
}
