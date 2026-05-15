package defpackage;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.n;

/* JADX INFO: renamed from: kG0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0949kG0 extends n {
    public View A;
    public boolean B;
    public final Handler t = new Handler();
    public final RunnableC0827iG0 u = new RunnableC0827iG0(this);
    public final C0888jG0 v = new C0888jG0(this);
    public ListAdapter w;
    public ListView x;
    public View y;
    public View z;

    public final void F0() {
        if (this.x != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.x = (ListView) view;
        } else {
            TextView textView = (TextView) view.findViewById(16711681);
            if (textView == null) {
                this.y = view.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.z = view.findViewById(16711682);
            this.A = view.findViewById(16711683);
            View viewFindViewById = view.findViewById(R.id.list);
            if (!(viewFindViewById instanceof ListView)) {
                if (viewFindViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) viewFindViewById;
            this.x = listView;
            View view2 = this.y;
            if (view2 != null) {
                listView.setEmptyView(view2);
            }
        }
        this.B = true;
        this.x.setOnItemClickListener(this.v);
        ListAdapter listAdapter = this.w;
        if (listAdapter != null) {
            this.w = null;
            H0(listAdapter);
        } else if (this.z != null) {
            K0(false, false);
        }
        this.t.post(this.u);
    }

    public final void H0(ListAdapter listAdapter) {
        boolean z = this.w != null;
        this.w = listAdapter;
        ListView listView = this.x;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.B || z) {
                return;
            }
            K0(true, requireView().getWindowToken() != null);
        }
    }

    public final void K0(boolean z, boolean z2) {
        F0();
        View view = this.z;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.B == z) {
            return;
        }
        this.B = z;
        if (z) {
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                this.A.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.A.clearAnimation();
            }
            this.z.setVisibility(8);
            this.A.setVisibility(0);
            return;
        }
        if (z2) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            this.A.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.A.clearAnimation();
        }
        this.z.setVisibility(0);
        this.A.setVisibility(8);
    }

    @Override // androidx.fragment.app.n
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context contextRequireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(contextRequireContext);
        LinearLayout linearLayout = new LinearLayout(contextRequireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(contextRequireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(contextRequireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(contextRequireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(contextRequireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.n
    public final void onDestroyView() {
        this.t.removeCallbacks(this.u);
        this.x = null;
        this.B = false;
        this.A = null;
        this.z = null;
        this.y = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.n
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        F0();
    }
}
