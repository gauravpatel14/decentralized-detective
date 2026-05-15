package androidx.mediarouter.app;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import defpackage.AO0;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0163Np1;
import defpackage.AbstractC0176Op1;
import defpackage.AbstractC0189Pp1;
import defpackage.AbstractC0275Wp1;
import defpackage.AbstractC1721xH;
import defpackage.BO0;
import defpackage.C0468cP0;
import defpackage.C0838iP0;
import defpackage.C1087mP0;
import defpackage.C1730xO0;
import defpackage.CO0;
import defpackage.DO0;
import defpackage.EO0;
import defpackage.Ep1;
import defpackage.FO0;
import defpackage.GO0;
import defpackage.HO0;
import defpackage.Hp1;
import defpackage.IO0;
import defpackage.Q51;
import defpackage.QO0;
import defpackage.YM0;
import defpackage.oP0;
import defpackage.s6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends s6 {
    public static final int I0 = (int) TimeUnit.SECONDS.toMillis(30);
    public final HO0 A;
    public int A0;
    public final C0838iP0 B;
    public int B0;
    public final Context C;
    public int C0;
    public boolean D;
    public Interpolator D0;
    public boolean E;
    public final Interpolator E0;
    public int F;
    public final Interpolator F0;
    public Button G;
    public final AccessibilityManager G0;
    public Button H;
    public final AO0 H0;
    public ImageButton I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public MediaRouteExpandCollapseButton f17J;
    public FrameLayout K;
    public LinearLayout L;
    public FrameLayout M;
    public ImageView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public final boolean R;
    public final boolean S;
    public LinearLayout T;
    public RelativeLayout U;
    public LinearLayout V;
    public View W;
    public OverlayListView X;
    public c Y;
    public ArrayList Z;
    public HashSet a0;
    public HashSet b0;
    public HashSet c0;
    public SeekBar d0;
    public IO0 e0;
    public C0838iP0 f0;
    public int g0;
    public int h0;
    public int i0;
    public final int j0;
    public HashMap k0;
    public YM0 l0;
    public final GO0 m0;
    public PlaybackStateCompat n0;
    public MediaDescriptionCompat o0;
    public FO0 p0;
    public Bitmap q0;
    public Uri r0;
    public boolean s0;
    public Bitmap t0;
    public int u0;
    public boolean v0;
    public boolean w0;
    public boolean x0;
    public boolean y0;
    public final C1087mP0 z;
    public boolean z0;

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Context context) {
        boolean z = false;
        ContextThemeWrapper contextThemeWrapperA = oP0.a(0, context, true);
        super(oP0.b(contextThemeWrapperA), contextThemeWrapperA);
        this.R = true;
        this.H0 = new AO0(0, this);
        Context context2 = getContext();
        this.C = context2;
        this.m0 = new GO0(this);
        this.z = C1087mP0.d(context2);
        if (C1087mP0.c != null) {
            C1087mP0.c().getClass();
            z = true;
        }
        this.S = z;
        this.A = new HO0(this);
        this.B = C1087mP0.g();
        s(C1087mP0.e());
        this.j0 = context2.getResources().getDimensionPixelSize(Hp1.mr_controller_volume_group_list_padding_top);
        this.G0 = (AccessibilityManager) context2.getSystemService("accessibility");
        this.E0 = AnimationUtils.loadInterpolator(contextThemeWrapperA, AbstractC0176Op1.mr_linear_out_slow_in);
        this.F0 = AnimationUtils.loadInterpolator(contextThemeWrapperA, AbstractC0176Op1.mr_fast_out_slow_in);
    }

    public static void r(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public final void j(int i, ViewGroup viewGroup) {
        DO0 do0 = new DO0(viewGroup.getLayoutParams().height, i, viewGroup);
        do0.setDuration(this.A0);
        do0.setInterpolator(this.D0);
        viewGroup.startAnimation(do0);
    }

    public final boolean k() {
        return (this.o0 == null && this.n0 == null) ? false : true;
    }

    public final void m(boolean z) {
        HashSet hashSet;
        int firstVisiblePosition = this.X.getFirstVisiblePosition();
        for (int i = 0; i < this.X.getChildCount(); i++) {
            View childAt = this.X.getChildAt(i);
            C0838iP0 c0838iP0 = (C0838iP0) this.Y.getItem(firstVisiblePosition + i);
            if (!z || (hashSet = this.a0) == null || !hashSet.contains(c0838iP0)) {
                ((LinearLayout) childAt.findViewById(AbstractC0132Lp1.volume_item_container)).setVisibility(0);
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
                alphaAnimation.setDuration(0L);
                animationSet.addAnimation(alphaAnimation);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0L);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
            }
        }
        for (Q51 q51 : this.X.t) {
            q51.j = true;
            q51.k = true;
            C1730xO0 c1730xO0 = q51.l;
            if (c1730xO0 != null) {
                d dVar = c1730xO0.b;
                dVar.c0.remove(c1730xO0.a);
                dVar.Y.notifyDataSetChanged();
            }
        }
        if (z) {
            return;
        }
        n(false);
    }

    public final void n(boolean z) {
        this.a0 = null;
        this.b0 = null;
        this.y0 = false;
        if (this.z0) {
            this.z0 = false;
            w(z);
        }
        this.X.setEnabled(true);
    }

    public final int o(int i, int i2) {
        return i >= i2 ? (int) (((this.F * i2) / i) + 0.5f) : (int) (((this.F * 9.0f) / 16.0f) + 0.5f);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.E = true;
        this.z.a(C0468cP0.c, this.A, 2);
        s(C1087mP0.e());
    }

    @Override // defpackage.s6, defpackage.AbstractDialogC0788hb, defpackage.lI, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        setContentView(AbstractC0189Pp1.mr_controller_material_dialog_b);
        findViewById(R.id.button3).setVisibility(8);
        EO0 eo0 = new EO0(this, 0);
        FrameLayout frameLayout = (FrameLayout) findViewById(AbstractC0132Lp1.mr_expandable_area);
        this.K = frameLayout;
        frameLayout.setOnClickListener(new EO0(this, 1));
        LinearLayout linearLayout = (LinearLayout) findViewById(AbstractC0132Lp1.mr_dialog_area);
        this.L = linearLayout;
        linearLayout.setOnClickListener(new BO0());
        int i = Ep1.colorPrimary;
        Context context = this.C;
        int iF = oP0.f(i, context);
        if (AbstractC1721xH.d(iF, oP0.f(R.attr.colorBackground, context)) < 3.0d) {
            iF = oP0.f(Ep1.colorAccent, context);
        }
        Button button = (Button) findViewById(R.id.button2);
        this.G = button;
        button.setText(AbstractC0275Wp1.mr_controller_disconnect);
        this.G.setTextColor(iF);
        this.G.setOnClickListener(eo0);
        Button button2 = (Button) findViewById(R.id.button1);
        this.H = button2;
        button2.setText(AbstractC0275Wp1.mr_controller_stop_casting);
        this.H.setTextColor(iF);
        this.H.setOnClickListener(eo0);
        this.Q = (TextView) findViewById(AbstractC0132Lp1.mr_name);
        ((ImageButton) findViewById(AbstractC0132Lp1.mr_close)).setOnClickListener(eo0);
        this.M = (FrameLayout) findViewById(AbstractC0132Lp1.mr_default_control);
        EO0 eo02 = new EO0(this, 2);
        ImageView imageView = (ImageView) findViewById(AbstractC0132Lp1.mr_art);
        this.N = imageView;
        imageView.setOnClickListener(eo02);
        findViewById(AbstractC0132Lp1.mr_control_title_container).setOnClickListener(eo02);
        this.T = (LinearLayout) findViewById(AbstractC0132Lp1.mr_media_main_control);
        this.W = findViewById(AbstractC0132Lp1.mr_control_divider);
        this.U = (RelativeLayout) findViewById(AbstractC0132Lp1.mr_playback_control);
        this.O = (TextView) findViewById(AbstractC0132Lp1.mr_control_title);
        this.P = (TextView) findViewById(AbstractC0132Lp1.mr_control_subtitle);
        ImageButton imageButton = (ImageButton) findViewById(AbstractC0132Lp1.mr_control_playback_ctrl);
        this.I = imageButton;
        imageButton.setOnClickListener(eo0);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(AbstractC0132Lp1.mr_volume_control);
        this.V = linearLayout2;
        linearLayout2.setVisibility(8);
        SeekBar seekBar = (SeekBar) findViewById(AbstractC0132Lp1.mr_volume_slider);
        this.d0 = seekBar;
        C0838iP0 c0838iP0 = this.B;
        seekBar.setTag(c0838iP0);
        IO0 io0 = new IO0(this);
        this.e0 = io0;
        this.d0.setOnSeekBarChangeListener(io0);
        this.X = (OverlayListView) findViewById(AbstractC0132Lp1.mr_volume_group_list);
        this.Z = new ArrayList();
        c cVar = new c(this, this.X.getContext(), this.Z);
        this.Y = cVar;
        this.X.setAdapter((ListAdapter) cVar);
        this.c0 = new HashSet();
        LinearLayout linearLayout3 = this.T;
        OverlayListView overlayListView = this.X;
        boolean zQ = q();
        int iF2 = oP0.f(Ep1.colorPrimary, context);
        int iF3 = oP0.f(Ep1.colorPrimaryDark, context);
        if (zQ && oP0.c(context) == -570425344) {
            iF3 = iF2;
            iF2 = -1;
        }
        linearLayout3.setBackgroundColor(iF2);
        overlayListView.setBackgroundColor(iF3);
        linearLayout3.setTag(Integer.valueOf(iF2));
        overlayListView.setTag(Integer.valueOf(iF3));
        MediaRouteVolumeSlider mediaRouteVolumeSlider = (MediaRouteVolumeSlider) this.d0;
        LinearLayout linearLayout4 = this.T;
        int iC = oP0.c(context);
        if (Color.alpha(iC) != 255) {
            iC = AbstractC1721xH.g(iC, ((Integer) linearLayout4.getTag()).intValue());
        }
        mediaRouteVolumeSlider.a(iC, iC);
        HashMap map = new HashMap();
        this.k0 = map;
        map.put(c0838iP0, this.d0);
        MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = (MediaRouteExpandCollapseButton) findViewById(AbstractC0132Lp1.mr_group_expand_collapse);
        this.f17J = mediaRouteExpandCollapseButton;
        mediaRouteExpandCollapseButton.B = new EO0(this, 3);
        this.D0 = this.x0 ? this.E0 : this.F0;
        this.A0 = context.getResources().getInteger(AbstractC0163Np1.mr_controller_volume_group_list_animation_duration_ms);
        this.B0 = context.getResources().getInteger(AbstractC0163Np1.mr_controller_volume_group_list_fade_in_duration_ms);
        this.C0 = context.getResources().getInteger(AbstractC0163Np1.mr_controller_volume_group_list_fade_out_duration_ms);
        this.D = true;
        v();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.z.h(this.A);
        s(null);
        this.E = false;
        super.onDetachedFromWindow();
    }

    @Override // defpackage.s6, android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 25 && i != 24) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.S || !this.x0) {
            this.B.i(i == 25 ? -1 : 1);
        }
        return true;
    }

    @Override // defpackage.s6, android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 25 || i == 24) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final int p(boolean z) {
        if (!z && this.V.getVisibility() != 0) {
            return 0;
        }
        int paddingBottom = this.T.getPaddingBottom() + this.T.getPaddingTop();
        if (z) {
            paddingBottom += this.U.getMeasuredHeight();
        }
        int measuredHeight = this.V.getVisibility() == 0 ? this.V.getMeasuredHeight() + paddingBottom : paddingBottom;
        return (z && this.V.getVisibility() == 0) ? this.W.getMeasuredHeight() + measuredHeight : measuredHeight;
    }

    public final boolean q() {
        C0838iP0 c0838iP0 = this.B;
        return c0838iP0.c() && Collections.unmodifiableList(c0838iP0.v).size() > 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(android.support.v4.media.session.MediaSessionCompat$Token r7) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.d.s(android.support.v4.media.session.MediaSessionCompat$Token):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(boolean r13) {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.d.t(boolean):void");
    }

    public final void u() {
        MediaDescriptionCompat mediaDescriptionCompat = this.o0;
        Bitmap bitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.x;
        Uri uri = mediaDescriptionCompat != null ? mediaDescriptionCompat.y : null;
        FO0 fo0 = this.p0;
        Bitmap bitmap2 = fo0 == null ? this.q0 : fo0.a;
        Uri uri2 = fo0 == null ? this.r0 : fo0.b;
        if (bitmap2 == bitmap) {
            if (bitmap2 != null) {
                return;
            }
            if (uri2 != null && uri2.equals(uri)) {
                return;
            }
            if (uri2 == null && uri == null) {
                return;
            }
        }
        if (!q() || this.S) {
            FO0 fo02 = this.p0;
            if (fo02 != null) {
                fo02.cancel(true);
            }
            FO0 fo03 = new FO0(this);
            this.p0 = fo03;
            fo03.execute(new Void[0]);
        }
    }

    public final void v() {
        Context context = this.C;
        int iA = QO0.a(context);
        getWindow().setLayout(iA, -2);
        View decorView = getWindow().getDecorView();
        this.F = (iA - decorView.getPaddingLeft()) - decorView.getPaddingRight();
        Resources resources = context.getResources();
        this.g0 = resources.getDimensionPixelSize(Hp1.mr_controller_volume_group_list_item_icon_size);
        this.h0 = resources.getDimensionPixelSize(Hp1.mr_controller_volume_group_list_item_height);
        this.i0 = resources.getDimensionPixelSize(Hp1.mr_controller_volume_group_list_max_height);
        this.q0 = null;
        this.r0 = null;
        u();
        t(false);
    }

    public final void w(boolean z) {
        this.M.requestLayout();
        this.M.getViewTreeObserver().addOnGlobalLayoutListener(new CO0(this, z));
    }

    public final void x(boolean z) {
        int i = 0;
        this.W.setVisibility((this.V.getVisibility() == 0 && z) ? 0 : 8);
        LinearLayout linearLayout = this.T;
        if (this.V.getVisibility() == 8 && !z) {
            i = 8;
        }
        linearLayout.setVisibility(i);
    }
}
