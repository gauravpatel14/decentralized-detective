package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: renamed from: ib, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0854ib {
    public final int[] a = {Ip1.abc_textfield_search_default_mtrl_alpha, Ip1.abc_textfield_default_mtrl_alpha, Ip1.abc_ab_share_pack_mtrl_alpha};
    public final int[] b = {Ip1.abc_ic_commit_search_api_mtrl_alpha, Ip1.abc_seekbar_tick_mark_material, Ip1.abc_ic_menu_share_mtrl_alpha, Ip1.abc_ic_menu_copy_mtrl_am_alpha, Ip1.abc_ic_menu_cut_mtrl_alpha, Ip1.abc_ic_menu_selectall_mtrl_alpha, Ip1.abc_ic_menu_paste_mtrl_am_alpha};
    public final int[] c = {Ip1.abc_textfield_activated_mtrl_alpha, Ip1.abc_textfield_search_activated_mtrl_alpha, Ip1.abc_cab_background_top_mtrl_alpha, Ip1.abc_text_cursor_material, Ip1.abc_text_select_handle_left_mtrl, Ip1.abc_text_select_handle_middle_mtrl, Ip1.abc_text_select_handle_right_mtrl};
    public final int[] d = {Ip1.abc_popup_background_mtrl_mult, Ip1.abc_cab_background_internal_bg, Ip1.abc_menu_hardkey_panel_mtrl_mult};
    public final int[] e = {Ip1.abc_tab_indicator_material, Ip1.abc_textfield_search_material};
    public final int[] f = {Ip1.abc_btn_check_material, Ip1.abc_btn_radio_material, Ip1.abc_btn_check_material_anim, Ip1.abc_btn_radio_material_anim};

    public static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList b(int i, Context context) {
        int iC = Q82.c(Ep1.colorControlHighlight, context);
        int iB = Q82.b(Ep1.colorButtonNormal, context);
        int[] iArr = Q82.b;
        int[] iArr2 = Q82.d;
        int iG = AbstractC1721xH.g(iC, i);
        return new ColorStateList(new int[][]{iArr, iArr2, Q82.c, Q82.f}, new int[]{iB, iG, AbstractC1721xH.g(iC, i), i});
    }

    public static LayerDrawable c(dv1 dv1Var, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawableC = dv1Var.c(Ip1.abc_star_black_48dp, context);
        Drawable drawableC2 = dv1Var.c(Ip1.abc_star_half_black_48dp, context);
        if ((drawableC instanceof BitmapDrawable) && drawableC.getIntrinsicWidth() == dimensionPixelSize && drawableC.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableC;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableC.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableC.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableC2 instanceof BitmapDrawable) && drawableC2.getIntrinsicWidth() == dimensionPixelSize && drawableC2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableC2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableC2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableC2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        return layerDrawable;
    }

    public static void e(Drawable drawable, int i) {
        drawable.mutate().setColorFilter(C0914jb.c(i, C0914jb.b));
    }

    public final ColorStateList d(int i, Context context) {
        if (i == Ip1.abc_edit_text_material) {
            return U3.b(AbstractC0084Gp1.abc_tint_edittext, context);
        }
        if (i == Ip1.abc_switch_track_mtrl_alpha) {
            return U3.b(AbstractC0084Gp1.abc_tint_switch_track, context);
        }
        if (i != Ip1.abc_switch_thumb_material) {
            if (i == Ip1.abc_btn_default_mtrl_shape) {
                return b(Q82.c(Ep1.colorButtonNormal, context), context);
            }
            if (i == Ip1.abc_btn_borderless_material) {
                return b(0, context);
            }
            if (i == Ip1.abc_btn_colored_material) {
                return b(Q82.c(Ep1.colorAccent, context), context);
            }
            if (i == Ip1.abc_spinner_mtrl_am_alpha || i == Ip1.abc_spinner_textfield_background_material) {
                return U3.b(AbstractC0084Gp1.abc_tint_spinner, context);
            }
            if (a(this.b, i)) {
                return Q82.d(Ep1.colorControlNormal, context);
            }
            if (a(this.e, i)) {
                return U3.b(AbstractC0084Gp1.abc_tint_default, context);
            }
            if (a(this.f, i)) {
                return U3.b(AbstractC0084Gp1.abc_tint_btn_checkable, context);
            }
            if (i == Ip1.abc_seekbar_thumb_material) {
                return U3.b(AbstractC0084Gp1.abc_tint_seek_thumb, context);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = Q82.d(Ep1.colorSwitchThumbNormal, context);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = Q82.b;
            iArr2[0] = Q82.b(Ep1.colorSwitchThumbNormal, context);
            iArr[1] = Q82.e;
            iArr2[1] = Q82.c(Ep1.colorControlActivated, context);
            iArr[2] = Q82.f;
            iArr2[2] = Q82.c(Ep1.colorSwitchThumbNormal, context);
        } else {
            int[] iArr3 = Q82.b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = Q82.e;
            iArr2[1] = Q82.c(Ep1.colorControlActivated, context);
            iArr[2] = Q82.f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }
}
