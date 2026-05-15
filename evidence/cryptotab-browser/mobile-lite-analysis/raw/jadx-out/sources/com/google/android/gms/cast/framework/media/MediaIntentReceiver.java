package com.google.android.gms.cast.framework.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.AbstractC0338aF1;
import defpackage.C0025By;
import defpackage.C1312qC2;
import defpackage.Ly;
import defpackage.Nt1;
import defpackage.WC2;
import defpackage.eF1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MediaIntentReceiver extends BroadcastReceiver {
    public static void a(Ly ly, long j) {
        Nt1 nt1B;
        if (j == 0 || (nt1B = b(ly)) == null || nt1B.g() || nt1B.i()) {
            return;
        }
        nt1B.m(nt1B.b() + j);
    }

    public static Nt1 b(Ly ly) {
        if (ly == null || !ly.a()) {
            return null;
        }
        return ly.f();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        eF1 ef1A;
        Nt1 nt1B;
        Nt1 nt1B2;
        Nt1 nt1B3;
        KeyEvent keyEvent;
        Nt1 nt1B4;
        String action = intent.getAction();
        if (action == null) {
        }
        ef1A = C0025By.b(context).a();
        switch (action) {
            case "com.google.android.gms.cast.framework.action.REWIND":
                long longExtra = intent.getLongExtra("googlecast-extra_skip_step_ms", 0L);
                AbstractC0338aF1 abstractC0338aF1C = ef1A.c();
                if (abstractC0338aF1C instanceof Ly) {
                    a((Ly) abstractC0338aF1C, -longExtra);
                    break;
                }
                break;
            case "com.google.android.gms.cast.framework.action.SKIP_NEXT":
                AbstractC0338aF1 abstractC0338aF1C2 = ef1A.c();
                if ((abstractC0338aF1C2 instanceof Ly) && (nt1B = b((Ly) abstractC0338aF1C2)) != null && !nt1B.i()) {
                    Preconditions.checkMainThread("Must be called from the main thread.");
                    if (!nt1B.r()) {
                        Nt1.o();
                    } else {
                        nt1B.p(new WC2(nt1B, nt1B.f));
                    }
                    break;
                }
                break;
            case "com.google.android.gms.cast.framework.action.SKIP_PREV":
                AbstractC0338aF1 abstractC0338aF1C3 = ef1A.c();
                if ((abstractC0338aF1C3 instanceof Ly) && (nt1B2 = b((Ly) abstractC0338aF1C3)) != null && !nt1B2.i()) {
                    Preconditions.checkMainThread("Must be called from the main thread.");
                    if (!nt1B2.r()) {
                        Nt1.o();
                    } else {
                        nt1B2.p(new C1312qC2(nt1B2, nt1B2.f));
                    }
                    break;
                }
                break;
            case "com.google.android.gms.cast.framework.action.STOP_CASTING":
                ef1A.b(true);
                break;
            case "com.google.android.gms.cast.framework.action.DISCONNECT":
                ef1A.b(false);
                break;
            case "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK":
                AbstractC0338aF1 abstractC0338aF1C4 = ef1A.c();
                if ((abstractC0338aF1C4 instanceof Ly) && (nt1B3 = b((Ly) abstractC0338aF1C4)) != null) {
                    nt1B3.n();
                    break;
                }
                break;
            case "com.google.android.gms.cast.framework.action.FORWARD":
                long longExtra2 = intent.getLongExtra("googlecast-extra_skip_step_ms", 0L);
                AbstractC0338aF1 abstractC0338aF1C5 = ef1A.c();
                if (abstractC0338aF1C5 instanceof Ly) {
                    a((Ly) abstractC0338aF1C5, longExtra2);
                    break;
                }
                break;
            case "android.intent.action.MEDIA_BUTTON":
                AbstractC0338aF1 abstractC0338aF1C6 = ef1A.c();
                if ((abstractC0338aF1C6 instanceof Ly) && intent.hasExtra("android.intent.extra.KEY_EVENT") && (keyEvent = (KeyEvent) intent.getExtras().get("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 85 && (nt1B4 = b((Ly) abstractC0338aF1C6)) != null) {
                    nt1B4.n();
                    break;
                }
                break;
        }
    }
}
