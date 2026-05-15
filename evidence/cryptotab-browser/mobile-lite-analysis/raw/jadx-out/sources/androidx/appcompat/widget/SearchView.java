package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.customview.view.AbsSavedState;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0189Pp1;
import defpackage.AbstractC0275Wp1;
import defpackage.AbstractC0305Yp1;
import defpackage.AbstractC0604eo2;
import defpackage.AbstractC0943kC1;
import defpackage.C0758hC1;
import defpackage.C1130nC1;
import defpackage.C1342qa2;
import defpackage.Ep1;
import defpackage.FG;
import defpackage.Ga;
import defpackage.Hp1;
import defpackage.InterfaceC1007lC1;
import defpackage.InterfaceC1069mC1;
import defpackage.bC1;
import defpackage.cC1;
import defpackage.dC1;
import defpackage.eC1;
import defpackage.fC1;
import defpackage.gC1;
import defpackage.iC1;
import defpackage.jC1;
import defpackage.oC1;
import defpackage.pC1;
import defpackage.uF0;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class SearchView extends uF0 implements FG {
    public static final C1130nC1 p0;
    public final SearchAutoComplete I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final View f12J;
    public final View K;
    public final View L;
    public final ImageView M;
    public final ImageView N;
    public final ImageView O;
    public final ImageView P;
    public final View Q;
    public pC1 R;
    public final Rect S;
    public final Rect T;
    public final int[] U;
    public final int[] V;
    public final ImageView W;
    public final Drawable a0;
    public final CharSequence b0;
    public InterfaceC1069mC1 c0;
    public InterfaceC1007lC1 d0;
    public View.OnClickListener e0;
    public final boolean f0;
    public boolean g0;
    public final CharSequence h0;
    public boolean i0;
    public final int j0;
    public String k0;
    public boolean l0;
    public int m0;
    public final cC1 n0;
    public final cC1 o0;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR = new oC1();
        public boolean v;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.v = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.v + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.v));
        }
    }

    static {
        C1130nC1 c1130nC1 = null;
        if (Build.VERSION.SDK_INT < 29) {
            C1130nC1 c1130nC12 = new C1130nC1();
            c1130nC12.a = null;
            c1130nC12.b = null;
            c1130nC12.c = null;
            C1130nC1.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                c1130nC12.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                c1130nC12.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                c1130nC12.c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            c1130nC1 = c1130nC12;
        }
        p0 = c1130nC1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchView(Context context) {
        int i = Ep1.searchViewStyle;
        super(context, null, i);
        this.S = new Rect();
        this.T = new Rect();
        this.U = new int[2];
        this.V = new int[2];
        this.n0 = new cC1(this, 0);
        this.o0 = new cC1(this, 1);
        new WeakHashMap();
        fC1 fc1 = new fC1(this);
        gC1 gc1 = new gC1(this);
        C0758hC1 c0758hC1 = new C0758hC1(this);
        iC1 ic1 = new iC1(this);
        jC1 jc1 = new jC1(this);
        bC1 bc1 = new bC1(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC0305Yp1.SearchView, i, 0);
        C1342qa2 c1342qa2 = new C1342qa2(context, typedArrayObtainStyledAttributes);
        AbstractC0604eo2.n(this, context, AbstractC0305Yp1.SearchView, null, typedArrayObtainStyledAttributes, i, 0);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.SearchView_layout, AbstractC0189Pp1.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(AbstractC0132Lp1.search_src_text);
        this.I = searchAutoComplete;
        searchAutoComplete.y = this;
        this.f12J = findViewById(AbstractC0132Lp1.search_edit_frame);
        View viewFindViewById = findViewById(AbstractC0132Lp1.search_plate);
        this.K = viewFindViewById;
        View viewFindViewById2 = findViewById(AbstractC0132Lp1.submit_area);
        this.L = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(AbstractC0132Lp1.search_button);
        this.M = imageView;
        ImageView imageView2 = (ImageView) findViewById(AbstractC0132Lp1.search_go_btn);
        this.N = imageView2;
        ImageView imageView3 = (ImageView) findViewById(AbstractC0132Lp1.search_close_btn);
        this.O = imageView3;
        ImageView imageView4 = (ImageView) findViewById(AbstractC0132Lp1.search_voice_btn);
        this.P = imageView4;
        ImageView imageView5 = (ImageView) findViewById(AbstractC0132Lp1.search_mag_icon);
        this.W = imageView5;
        viewFindViewById.setBackground(c1342qa2.b(AbstractC0305Yp1.SearchView_queryBackground));
        viewFindViewById2.setBackground(c1342qa2.b(AbstractC0305Yp1.SearchView_submitBackground));
        imageView.setImageDrawable(c1342qa2.b(AbstractC0305Yp1.SearchView_searchIcon));
        imageView2.setImageDrawable(c1342qa2.b(AbstractC0305Yp1.SearchView_goIcon));
        imageView3.setImageDrawable(c1342qa2.b(AbstractC0305Yp1.SearchView_closeIcon));
        imageView4.setImageDrawable(c1342qa2.b(AbstractC0305Yp1.SearchView_voiceIcon));
        imageView5.setImageDrawable(c1342qa2.b(AbstractC0305Yp1.SearchView_searchIcon));
        this.a0 = c1342qa2.b(AbstractC0305Yp1.SearchView_searchHintIcon);
        imageView.setTooltipText(getResources().getString(AbstractC0275Wp1.abc_searchview_description_search));
        typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.SearchView_suggestionRowLayout, AbstractC0189Pp1.abc_search_dropdown_item_icons_2line);
        typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fc1);
        imageView3.setOnClickListener(fc1);
        imageView2.setOnClickListener(fc1);
        imageView4.setOnClickListener(fc1);
        searchAutoComplete.setOnClickListener(fc1);
        searchAutoComplete.addTextChangedListener(bc1);
        searchAutoComplete.setOnEditorActionListener(c0758hC1);
        searchAutoComplete.setOnItemClickListener(ic1);
        searchAutoComplete.setOnItemSelectedListener(jc1);
        searchAutoComplete.setOnKeyListener(gc1);
        searchAutoComplete.setOnFocusChangeListener(new dC1(this));
        boolean z = typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.SearchView_iconifiedByDefault, true);
        if (this.f0 != z) {
            this.f0 = z;
            u(z);
            t();
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            this.j0 = dimensionPixelSize;
            requestLayout();
        }
        this.b0 = typedArrayObtainStyledAttributes.getText(AbstractC0305Yp1.SearchView_defaultQueryHint);
        this.h0 = typedArrayObtainStyledAttributes.getText(AbstractC0305Yp1.SearchView_queryHint);
        int i2 = typedArrayObtainStyledAttributes.getInt(AbstractC0305Yp1.SearchView_android_imeOptions, -1);
        if (i2 != -1) {
            searchAutoComplete.setImeOptions(i2);
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(AbstractC0305Yp1.SearchView_android_inputType, -1);
        if (i3 != -1) {
            searchAutoComplete.setInputType(i3);
        }
        setFocusable(typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.SearchView_android_focusable, true));
        c1342qa2.g();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        new Intent("android.speech.action.RECOGNIZE_SPEECH").addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.Q = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new eC1(this));
        }
        u(this.f0);
        t();
    }

    @Override // defpackage.FG
    public final void b() {
        if (this.l0) {
            return;
        }
        this.l0 = true;
        SearchAutoComplete searchAutoComplete = this.I;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.m0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.i0 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.I;
        searchAutoComplete.clearFocus();
        searchAutoComplete.a(false);
        this.i0 = false;
    }

    @Override // defpackage.FG
    public final void f() {
        q("");
        clearFocus();
        u(true);
        this.I.setImeOptions(this.m0);
        this.l0 = false;
    }

    public final void m() {
        int i = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.I;
        if (i >= 29) {
            AbstractC0943kC1.a(searchAutoComplete);
            return;
        }
        C1130nC1 c1130nC1 = p0;
        c1130nC1.getClass();
        C1130nC1.a();
        Method method = c1130nC1.a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        c1130nC1.getClass();
        C1130nC1.a();
        Method method2 = c1130nC1.b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void n() {
        SearchAutoComplete searchAutoComplete = this.I;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.a(true);
        } else if (this.f0) {
            InterfaceC1007lC1 interfaceC1007lC1 = this.d0;
            if (interfaceC1007lC1 != null) {
                interfaceC1007lC1.a();
            }
            clearFocus();
            u(true);
        }
    }

    public final void o() {
        u(false);
        SearchAutoComplete searchAutoComplete = this.I;
        searchAutoComplete.requestFocus();
        searchAutoComplete.a(true);
        View.OnClickListener onClickListener = this.e0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.n0);
        post(this.o0);
        super.onDetachedFromWindow();
    }

    @Override // defpackage.uF0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int[] iArr = this.U;
            SearchAutoComplete searchAutoComplete = this.I;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.V;
            getLocationInWindow(iArr2);
            int i5 = iArr[1] - iArr2[1];
            int i6 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i6;
            int height = searchAutoComplete.getHeight() + i5;
            Rect rect = this.S;
            rect.set(i6, i5, width, height);
            int i7 = rect.left;
            int i8 = rect.right;
            int i9 = i4 - i2;
            Rect rect2 = this.T;
            rect2.set(i7, 0, i8, i9);
            pC1 pc1 = this.R;
            if (pc1 == null) {
                pC1 pc12 = new pC1(rect2, rect, searchAutoComplete);
                this.R = pc12;
                setTouchDelegate(pc12);
            } else {
                pc1.b.set(rect2);
                Rect rect3 = pc1.d;
                rect3.set(rect2);
                int i10 = -pc1.e;
                rect3.inset(i10, i10);
                pc1.c.set(rect);
            }
        }
    }

    @Override // defpackage.uF0, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        if (this.g0) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.j0;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getContext().getResources().getDimensionPixelSize(Hp1.abc_search_view_preferred_width), size);
        } else if (mode == 0) {
            size = this.j0;
            if (size <= 0) {
                size = getContext().getResources().getDimensionPixelSize(Hp1.abc_search_view_preferred_width);
            }
        } else if (mode == 1073741824 && (i3 = this.j0) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getContext().getResources().getDimensionPixelSize(Hp1.abc_search_view_preferred_height), size2);
        } else if (mode2 == 0) {
            size2 = getContext().getResources().getDimensionPixelSize(Hp1.abc_search_view_preferred_height);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.t);
        u(savedState.v);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.v = this.g0;
        return savedState;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.n0);
    }

    public final void p() {
        SearchAutoComplete searchAutoComplete = this.I;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.c0 != null) {
            text.toString();
        } else {
            searchAutoComplete.a(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    public final void q(String str) {
        SearchAutoComplete searchAutoComplete = this.I;
        searchAutoComplete.setText(str);
        if (str != null) {
            searchAutoComplete.setSelection(searchAutoComplete.length());
        }
    }

    public final void r() {
        boolean zIsEmpty = TextUtils.isEmpty(this.I.getText());
        int i = (!zIsEmpty || (this.f0 && !this.l0)) ? 0 : 8;
        ImageView imageView = this.O;
        imageView.setVisibility(i);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        if (this.i0 || !isFocusable()) {
            return false;
        }
        if (this.g0) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.I.requestFocus(i, rect);
        if (zRequestFocus) {
            u(false);
        }
        return zRequestFocus;
    }

    public final void s() {
        int[] iArr = this.I.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.K.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.L.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void t() {
        CharSequence charSequence = this.h0;
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = this.b0;
        }
        if (charSequence2 == null) {
            charSequence2 = "";
        }
        boolean z = this.f0;
        SearchAutoComplete searchAutoComplete = this.I;
        CharSequence charSequence3 = charSequence2;
        if (z) {
            Drawable drawable = this.a0;
            charSequence3 = charSequence2;
            if (drawable != null) {
                int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
                drawable.setBounds(0, 0, textSize, textSize);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
                spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
                spannableStringBuilder.append(charSequence2);
                charSequence3 = spannableStringBuilder;
            }
        }
        searchAutoComplete.setHint(charSequence3);
    }

    public final void u(boolean z) {
        this.g0 = z;
        int i = z ? 0 : 8;
        TextUtils.isEmpty(this.I.getText());
        this.M.setVisibility(i);
        this.N.setVisibility(8);
        this.f12J.setVisibility(z ? 8 : 0);
        ImageView imageView = this.W;
        imageView.setVisibility((imageView.getDrawable() == null || this.f0) ? 8 : 0);
        r();
        this.P.setVisibility(8);
        this.L.setVisibility(8);
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class SearchAutoComplete extends Ga {
        public final cC1 A;
        public int x;
        public SearchView y;
        public boolean z;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, Ep1.autoCompleteTextViewStyle);
            this.A = new cC1(this, 2);
            this.x = getThreshold();
        }

        public final void a(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            cC1 cc1 = this.A;
            if (!z) {
                this.z = false;
                removeCallbacks(cc1);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.z = true;
                    return;
                }
                this.z = false;
                removeCallbacks(cc1);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.x <= 0 || super.enoughToFilter();
        }

        @Override // defpackage.Ga, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.z) {
                cC1 cc1 = this.A;
                removeCallbacks(cc1);
                post(cc1);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            setMinWidth((int) TypedValue.applyDimension(1, (i < 960 || i2 < 720 || configuration.orientation != 2) ? (i >= 600 || (i >= 640 && i2 >= 480)) ? 192 : 160 : 256, displayMetrics));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            SearchView searchView = this.y;
            searchView.u(searchView.g0);
            searchView.post(searchView.n0);
            if (searchView.I.hasFocus()) {
                searchView.m();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.y.clearFocus();
                        a(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.y.hasFocus() && getVisibility() == 0) {
                this.z = true;
                Context context = getContext();
                C1130nC1 c1130nC1 = SearchView.p0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        AbstractC0943kC1.b(this);
                        if (enoughToFilter()) {
                            showDropDown();
                            return;
                        }
                        return;
                    }
                    C1130nC1 c1130nC12 = SearchView.p0;
                    c1130nC12.getClass();
                    C1130nC1.a();
                    Method method = c1130nC12.c;
                    if (method != null) {
                        try {
                            method.invoke(this, Boolean.TRUE);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void setThreshold(int i) {
            super.setThreshold(i);
            this.x = i;
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }
    }
}
